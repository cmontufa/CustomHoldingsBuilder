package edu.grzegorzewski.customholdingsbuilder.services.impl;
/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.List;
import java.util.concurrent.ExecutionException;

import edu.grzegorzewski.customholdingsbuilder.MainActivity;
import edu.grzegorzewski.customholdingsbuilder.dao.OclcDao;
import edu.grzegorzewski.customholdingsbuilder.domain.Institution;

/**
 * TODO Class description.
 *
 * @author Christopher Montufar.
 * @version 1.0, 11/27/2016.
 */
public class OclcService extends Service {

    /*
     * Declare instance variables.
     */
    private IBinder mBinder = new LocalBinder();
    OclcDao oclcDao = new OclcDao(MainActivity.getInstance());

    /**
     * TODO Method description.
     *
     * @param intent TODO description.
     * @return -  TODO description.
     * @since 1.0
     */
    @Override
    public IBinder onBind(Intent intent) {

        // TODO description.
        return mBinder;

    } // end method onBind.

    /**
     * TODO Class description.
     *
     * @since 1.0
     */
    public class LocalBinder extends Binder {

        /**
         * TODO description.
         *
         * @return -  TODO description.
         * @since 1.0
         */
        public OclcService getServerInstance() {

            // TODO description.
            return OclcService.this;

        } // end method getServerInstance.

    } // end class LocalBinder.

    /**
     * TODO Method description.
     *
     * @param url  TODO description.
     * @param searchParams  TODO description.
     * @param forceUpdate  TODO description.
     * @return -  TODO description.
     * @since 1.0
     */
    public List<Institution> retrieveAndParseOclc(String url, String searchParams, Boolean forceUpdate) {

        // TODO description.
        List<Institution> institutions = oclcDao.getAllInstitutionsBySearchParams(searchParams);

        // TODO description.
        if (institutions.isEmpty() || forceUpdate) {
            // TODO description.
            try {
                // TODO description.
                institutions = new OclCSearchResultsTask().execute(url).get();
                // TODO description.
                for (Institution institution : institutions) {
                    // TODO description.
                    oclcDao.addInstitution(institution);
                } // end for.

            }  //end try.
            // TODO description.
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } // end catch.

        } //end if.

        // TODO description.
        return institutions;

    } // end method retrieveAndParseOclc.

} // end class OclcService.