package edu.grzegorzewski.customholdingsbuilder.services.impl;

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
 * Created by Christopher Montufar on 11/24/16.
 */
public class OclcService extends Service {

    IBinder mBinder = new LocalBinder();
    OclcDao oclcDao = new OclcDao(MainActivity.getInstance());

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder {
        public OclcService getServerInstance() {
            return OclcService.this;
        }
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
