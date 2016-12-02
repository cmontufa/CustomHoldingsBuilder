package edu.grzegorzewski.customholdingsbuilder.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import edu.grzegorzewski.customholdingsbuilder.domain.Institution;

/**
 * Created by Christopher Montufar on 11/27/16.
 */
public class OclcDao extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "OclcDB";
    // OCLC table name
    private static final String TABLE_OCLC_SEARCH_RESULTS = "OCLC_SEARCH_RESULTS";
    // OCLC Search Results Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_INSTITUTION_ID = "institution_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SUPPLIER = "supplier";
    private static final String KEY_DAYS_TO_RESPOND = "days_to_respond";
    private static final String KEY_LOAN_DAYS_TO_RESPOND = "loan_days_to_respond";
    private static final String KEY_COPY_DAYS_TO_RESPOND = "copy_days_to_respond";
    private static final String KEY_SYMBOL = "symbol";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_LOAN_FEES = "loan_fees";
    private static final String KEY_COPY_FEES = "copy_fees";
    private static final String KEY_SEARCH_PARAMS = "search_params";

    public OclcDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_OCLC_SEARCH_RESULTS_TABLE = "CREATE TABLE OCLC_SEARCH_RESULTS ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, "+
                "institution_id TEXT, " + "supplier TEXT, " + "days_to_respond TEXT, " +
                "loan_days_to_respond TEXT, " + "copy_days_to_respond TEXT, " + "symbol TEXT, "+
                "country TEXT, " + "location TEXT, " + "loan_fees REAL, " +
                "copy_fees REAL, " + "search_params TEXT) ";

        db.execSQL(CREATE_OCLC_SEARCH_RESULTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        db.execSQL("DROP TABLE IF EXISTS OCLC_SEARCH_RESULTS");

        this.onCreate(db);
    }

    public void addInstitution(Institution institution){
        Log.d("addInstitution", institution.toString());
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_INSTITUTION_ID, institution.getInstitutionId());
        values.put(KEY_NAME, institution.getName());
        values.put(KEY_SUPPLIER, institution.getSupplier());
        values.put(KEY_DAYS_TO_RESPOND, institution.getDaysToRespond());
        values.put(KEY_LOAN_DAYS_TO_RESPOND, institution.getLoanDaysToRespond());
        values.put(KEY_COPY_DAYS_TO_RESPOND, institution.getCopyDaysToRespond());
        values.put(KEY_SYMBOL, institution.getSymbol());
        values.put(KEY_COUNTRY, institution.getCountry());
        values.put(KEY_LOCATION, institution.getLocation());
        values.put(KEY_LOAN_FEES, institution.getLoanFees());
        values.put(KEY_COPY_FEES, institution.getCopyFees());
        values.put(KEY_SEARCH_PARAMS, institution.getSearchParams());

        //Verify if institution already exists before adding
        Institution persistedBook = getInstitutionBySearchParamsAndInstitutionId(institution.getSearchParams(), institution.getInstitutionId());

        if (persistedBook == null) {
            db.insert(TABLE_OCLC_SEARCH_RESULTS,
                    null,
                    values);
        }

        db.close();
    }

    public Institution getInstitutionBySearchParamsAndInstitutionId(String searchParams, String institutionId) {
        Log.d("getInstSearchParams - ", searchParams);
        List<Institution> institutions = new LinkedList<Institution>();

        String query = "SELECT * FROM " + TABLE_OCLC_SEARCH_RESULTS + " where search_params = '" + searchParams + "' AND institution_id = '" + institutionId + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Institution institution = null;
        if (cursor.moveToFirst()) {
            institution = new Institution();
            institution.setId(cursor.getString(0));
            institution.setName(cursor.getString(1));
            institution.setInstitutionId(cursor.getString(2));
            institution.setSupplier(cursor.getString(3));
            institution.setDaysToRespond(cursor.getString(4));
            institution.setLoanDaysToRespond(cursor.getString(5));
            institution.setCopyDaysToRespond(cursor.getString(6));
            institution.setSymbol(cursor.getString(7));
            institution.setCountry(cursor.getString(8));
            institution.setLocation(cursor.getString(9));
            institution.setLoanFees(cursor.getString(10));
            institution.setCopyFees(cursor.getString(11));
            institution.setSearchParams(cursor.getString(12));
        }

        return institution;
    }

    public List<Institution> getAllInstitutionsBySearchParams(String searchParams) {
        List<Institution> institutions = new LinkedList<>();

        String query = "SELECT * FROM " + TABLE_OCLC_SEARCH_RESULTS + " where search_params = '" + searchParams + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Institution institution = null;

        if (cursor.moveToFirst()) {
            do {
                institution = new Institution();
                institution.setId(cursor.getString(0));
                institution.setName(cursor.getString(1));
                institution.setInstitutionId(cursor.getString(2));
                institution.setSupplier(cursor.getString(3));
                institution.setDaysToRespond(cursor.getString(4));
                institution.setLoanDaysToRespond(cursor.getString(5));
                institution.setCopyDaysToRespond(cursor.getString(6));
                institution.setSymbol(cursor.getString(7));
                institution.setCountry(cursor.getString(8));
                institution.setLocation(cursor.getString(9));
                institution.setLoanFees(cursor.getString(10));
                institution.setCopyFees(cursor.getString(11));
                institution.setSearchParams(cursor.getString(12));

                institutions.add(institution);
            } while (cursor.moveToNext());
        }
        Log.d("getAllInstitutions()", institutions.toString());
        return institutions;
    }


    public int updateInstitution(Institution institution) {
        Log.d("updateInstitution()", institution.toString());
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_INSTITUTION_ID, institution.getInstitutionId());
        values.put(KEY_NAME, institution.getName());
        values.put(KEY_SUPPLIER, institution.getSupplier());
        values.put(KEY_DAYS_TO_RESPOND, institution.getDaysToRespond());
        values.put(KEY_LOAN_DAYS_TO_RESPOND, institution.getLoanDaysToRespond());
        values.put(KEY_COPY_DAYS_TO_RESPOND, institution.getCopyDaysToRespond());
        values.put(KEY_SYMBOL, institution.getSymbol());
        values.put(KEY_COUNTRY, institution.getCountry());
        values.put(KEY_LOCATION, institution.getLocation());
        values.put(KEY_LOAN_FEES, institution.getLoanFees());
        values.put(KEY_COPY_FEES, institution.getCopyFees());
        values.put(KEY_SEARCH_PARAMS, institution.getSearchParams());

        int i = db.update(TABLE_OCLC_SEARCH_RESULTS,
                values,
                KEY_ID+" = ?",
                new String[] { String.valueOf(institution.getId()) });

        db.close();

        return i;
    }

    public void deleteInstitution(Institution institution) {
    }

}
