package edu.grzegorzewski.customholdingsbuilder.services;

/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

    OclcDao oclcDao = new OclcDao(GetHoldingsActivity.getInstance());

    //Example of the URL for search params of state:MA AND state:OH AND supplier:Y
    private static final String OCLC_URL = "https://ill.sd00.worldcat.org/illpolicies/institutionsearch";
    private static final String OCLC_AND_VALUE = "%20AND%20";
    private static final String OCLC_AND_VALUE_WITH_SPACES = " AND ";
    private static final String OCLC_TOKEN = "&wskey=vGFCwWwPUemlAApDyGfvpYrj2fR5orRXDVBrpO38RFDoHDnKlwh4bElCvfVaj8pG5KEP8HD4itDj7l4p";
    private static final String OCLC_SEARCH_QUERY_TEMPLATE = "?q=state:%s%ssupplier:%s";
    //private static final String OCLC_SEARCH_QUERY_TEMPLATE = "?q=state:%s%sstate:%s%ssupplier:%s";  // only need state and supplier the second state is redundant and should speed it up 2X

    public static final String BROADCAST_RESPONSE_STRING = "broadcastResponse";

    /*
     * Constructors
     */

    /**
     * TODO Constructor descripton.
     *
     * @since 1.0
     */
    public OclcIntentService() {
        super("OclcIntentService");
    } // end constructor

    /*
     * Methods.
     */

    /**
     * TODO Method descripton.
     *
     * @param intent TODO descripton.
     * @see StateZoneList TODO descripton.
     * @since 1.0
     */
    @Override
    protected void onHandleIntent(Intent intent) {


        OclcDao oclcDao = new OclcDao(OclcIntentService.this);
        String dbState = oclcDao.getDBSourceState();

        // The from state
        //String state = intent.getStringExtra("state");

        SharedPreferences stateSetting = PreferenceManager.getDefaultSharedPreferences(OclcIntentService.this);
        String sourceState = stateSetting.getString("sourceState", dbState);

        // TODO descripton.
        StateZoneList stateZone = new StateZoneList(sourceState);

        // TODO descripton.
        List<Pair> stateZoneList = stateZone.getStateZones();

        //
        for (Pair stateZonePair : stateZoneList) {
            // Build URL for API calls
            String apiUrlCall = buildUrlForAPI((String) stateZonePair.first);

            Log.i("Running for URL: ", apiUrlCall);

            // TODO descripton.
            retrieveAndParseOclc(apiUrlCall, sourceState, (String) stateZonePair.first, String.valueOf((Integer) stateZonePair.second), false);
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

        } //end for.

    } // end method onHandleIntent.

    /**
     * Build URL for API calls
     *
     * @param toState TODO descripton.
     * @return - TODO descripton.
     * @since 1.0
     */
    private String buildUrlForAPI(String toState) {

        StringBuilder url = new StringBuilder(OCLC_URL);
        url.append(String.format(OCLC_SEARCH_QUERY_TEMPLATE,
                //fromState,
                //OCLC_AND_VALUE,
                toState,
                OCLC_AND_VALUE,
                "Y"));
        url.append(OCLC_TOKEN);
        return url.toString();

    } // end method buildUrlForAPI.

    /**
     * TODO Method descripton.
     *
     * @param url TODO descripton.
     * @param sourceState TODO descripton.
     * @param forceUpdate TODO descripton.
     * @return - TODO descripton.
     * @since 1.0
     */
    public List<Institution> retrieveAndParseOclc(String url, String sourceState, String targetState, String zone, Boolean forceUpdate) {

        String params[] = new String[]{url, sourceState, targetState, zone};

        // TODO descripton.
        List<Institution> institutions = oclcDao.getAllInstitutionsBySourceAndTargetState(sourceState, targetState);

        // TODO descripton.
        if (institutions.isEmpty() || forceUpdate) {
            try {
                // TODO descripton.

                institutions = new OclCSearchResultsTask().execute(params).get();
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

} // end class OclcIntentService.