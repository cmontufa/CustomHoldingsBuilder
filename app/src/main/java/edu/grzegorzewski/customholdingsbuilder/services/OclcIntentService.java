package edu.grzegorzewski.customholdingsbuilder.services;

/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

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
 * TODO Class description.
 *
 * @author Christopher Montufar.
 * @version 1.0, 12/01/2016.
 */
public class OclcIntentService extends IntentService {

    OclcDao oclcDao = new OclcDao(MainActivity.getInstance());

    //Example of the URL for search params of state:MA AND state:OH AND supplier:Y
    private static final String OCLC_URL = "https://ill.sd00.worldcat.org/illpolicies/institutionsearch";
    private static final String OCLC_AND_VALUE = "%20AND%20";
    private static final String OCLC_AND_VALUE_WITH_SPACES = " AND ";
    private static final String OCLC_TOKEN = "&wskey=vGFCwWwPUemlAApDyGfvpYrj2fR5orRXDVBrpO38RFDoHDnKlwh4bElCvfVaj8pG5KEP8HD4itDj7l4p";
    private static final String OCLC_SEARCH_QUERY_TEMPLATE = "?q=state:%s%ssupplier:%s";
    //private static final String OCLC_SEARCH_QUERY_TEMPLATE = "?q=state:%s%sstate:%s%ssupplier:%s";  // only need state and supplier the second state is redundant and should speed it up 2X

    public static final String BROADCAST_RESPONSE_STRING = "broadcastResponse";

    public OclcIntentService() {
        super("OclcIntentService");
    }

    /**
     * TODO Method descripton.
     *
     * @param intent
     * @see StateZoneList
     * @since 1.0
     */
    @Override
    protected void onHandleIntent(Intent intent) {

        // TODO descripton.
        String state = intent.getStringExtra("state");
        // TODO descripton.
        StateZoneList stateZone = new StateZoneList(state);
        // TODO descripton.
        List<Pair> stateZoneList = stateZone.getStateZones();

        for (Pair stateZonePair : stateZoneList) {
            // TODO descripton.
            String apiUrlCall = buildUrlForAPI(state, (String) stateZonePair.first);
            // TODO descripton.
            String searchParams = buildSearchParams(state, (String) stateZonePair.first);

            Log.i("Running for URL: ", apiUrlCall);

            // TODO descripton.
            retrieveAndParseOclc(apiUrlCall, searchParams, true);
            // TODO descripton.
            Intent broadcastIntent = new Intent();
            // TODO descripton.
            broadcastIntent.setAction(GetHoldingsActivity.OclcIntentServiceReceiver.PROCESS_RESPONSE);
            // TODO descripton.
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            // TODO descripton.
            broadcastIntent.putExtra(BROADCAST_RESPONSE_STRING, (String) stateZonePair.first);
            // TODO descripton.
            sendBroadcast(broadcastIntent);
        }

    }

    /**
     * Build URL for API calls
     *
     * @param toState TODO descripton.
     * @return - TODO descripton.
     * @since 1.0
     */
    private String buildUrlForAPI(String fromState, String toState) {

        StringBuilder url = new StringBuilder(OCLC_URL);
        url.append(String.format(OCLC_SEARCH_QUERY_TEMPLATE,
                //fromState,
                //OCLC_AND_VALUE,
                toState,
                OCLC_AND_VALUE,
                "Y"));
        url.append(OCLC_TOKEN);
        return url.toString();
    }

    /**
     * TODO Method descripton.
     *
     * @param fromState TODO descripton.
     * @param toState TODO descripton.
     * @return - TODO descripton.
     * @since 1.0
     */
    private String buildSearchParams(String fromState, String toState) {

        return String.format(OCLC_SEARCH_QUERY_TEMPLATE, fromState,
                OCLC_AND_VALUE_WITH_SPACES,
                toState,
                OCLC_AND_VALUE_WITH_SPACES,
                "Y");
    }

    /**
     * TODO Method descripton.
     *
     * @param url TODO descripton.
     * @param searchParams TODO descripton.
     * @param forceUpdate TODO descripton.
     * @return - TODO descripton.
     * @since 1.0
     */
    public List<Institution> retrieveAndParseOclc(String url, String searchParams, Boolean forceUpdate) {

        // TODO descripton.
        List<Institution> institutions = oclcDao.getAllInstitutionsBySearchParams(searchParams);

        // TODO descripton.
        if (institutions.isEmpty() || forceUpdate) {
            try {
                // TODO descripton.
                institutions = new OclCSearchResultsTask().execute(url).get();
                for (Institution institution : institutions) {
                    oclcDao.addInstitution(institution);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        // TODO descripton.
        return institutions;

    } // end method retrieveAndParseOclc.
}
