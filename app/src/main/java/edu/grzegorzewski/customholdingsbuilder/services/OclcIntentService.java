package edu.grzegorzewski.customholdingsbuilder.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;

import java.util.List;
import java.util.concurrent.ExecutionException;

import edu.grzegorzewski.customholdingsbuilder.GetHoldingsActivity;
import edu.grzegorzewski.customholdingsbuilder.MainActivity;
import edu.grzegorzewski.customholdingsbuilder.StateZoneList;
import edu.grzegorzewski.customholdingsbuilder.dao.OclcDao;
import edu.grzegorzewski.customholdingsbuilder.domain.Institution;
import edu.grzegorzewski.customholdingsbuilder.services.impl.OclCSearchResultsTask;

/**
 * Created by Christopher Montufar on 12/1/16.
 */

public class OclcIntentService extends IntentService {

    OclcDao oclcDao = new OclcDao(MainActivity.getInstance());

    //Example of the URL for search params of state:MA AND state:OH AND supplier:Y
    private static final String OCLC_URL = "https://ill.sd00.worldcat.org/illpolicies/institutionsearch";
    private static final String OCLC_AND_VALUE = "%20AND%20";
    private static final String OCLC_AND_VALUE_WITH_SPACES = " AND ";
    private static final String OCLC_TOKEN = "&wskey=vGFCwWwPUemlAApDyGfvpYrj2fR5orRXDVBrpO38RFDoHDnKlwh4bElCvfVaj8pG5KEP8HD4itDj7l4p";
    private static final String OCLC_SEARCH_QUERY_TEMPLATE = "?q=state:%s%sstate:%s%ssupplier:%s";

    public static final String BROADCAST_RESPONSE_STRING = "broadcastResponse";

    public OclcIntentService() {
        super("OclcIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String state = intent.getStringExtra("state");
        StateZoneList stateZone = new StateZoneList(state);
        List<Pair> stateZoneList = stateZone.getStateZones();

        for (Pair stateZonePair : stateZoneList) {
            String apiUrlCall = buildUrlForAPI(state, (String) stateZonePair.first);
            String searchParams = buildSearchParams(state, (String) stateZonePair.first);
            Log.i("Running for URL: ", apiUrlCall);
            retrieveAndParseOclc(apiUrlCall, searchParams, true);
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GetHoldingsActivity.OclcIntentServiceReceiver.PROCESS_RESPONSE);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(BROADCAST_RESPONSE_STRING, (String) stateZonePair.first);
            sendBroadcast(broadcastIntent);
        }

    }

    // Build URL for API calls
    private String buildUrlForAPI(String fromState, String toState) {
        StringBuilder url = new StringBuilder(OCLC_URL);
        url.append(String.format(OCLC_SEARCH_QUERY_TEMPLATE, fromState,
                OCLC_AND_VALUE,
                toState,
                OCLC_AND_VALUE,
                "Y"));
        url.append(OCLC_TOKEN);
        return url.toString();
    }

    private String buildSearchParams(String fromState, String toState) {
        return String.format(OCLC_SEARCH_QUERY_TEMPLATE, fromState,
                OCLC_AND_VALUE_WITH_SPACES,
                toState,
                OCLC_AND_VALUE_WITH_SPACES,
                "Y");
    }

    public List<Institution> retrieveAndParseOclc(String url, String searchParams, Boolean forceUpdate) {

        List<Institution> institutions = oclcDao.getAllInstitutionsBySearchParams(searchParams);

        if (institutions.isEmpty() || forceUpdate) {
            try {
                institutions = new OclCSearchResultsTask().execute(url).get();
                for (Institution institution : institutions) {
                    oclcDao.addInstitution(institution);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return institutions;
    }
}
