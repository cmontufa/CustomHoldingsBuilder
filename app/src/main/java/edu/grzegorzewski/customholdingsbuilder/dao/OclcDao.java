package edu.grzegorzewski.customholdingsbuilder.dao;

/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

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
 * TODO Class description.
 *
 * @author Christopher Montufar.
 * @version 1.0, 11/27/2016.
 */
public class OclcDao extends SQLiteOpenHelper {

    /*
     * Declare and initialize class variables.
     */

    // Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "OclcDB";
    // OCLC table name
    private static final String TABLE_OCLC_SEARCH_RESULTS = "OCLC_SEARCH_RESULTS";
    private static final String TABLE_OCLC_HOLDINGS_LIST = "OCLC_HOLDINGS_LIST";
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
    private static final String KEY_SOURCE_STATE = "source_state";
    private static final String KEY_TARGET_STATE = "target_state";
    private static final String KEY_ZONE = "zone";

    /*
     * Constructors.
     */

    /**
     *  TODO Constructor description.
     *
     * @param context TODO description.
     */
    public OclcDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    } // end constructor.

    /*
     * Methods.
     */

    /**
     * TODO Method description.
     *
     * @param db TODO description.
     * @since 1.0
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_OCLC_SEARCH_RESULTS_TABLE = "CREATE TABLE OCLC_SEARCH_RESULTS ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, "+
                "institution_id TEXT, " + "supplier TEXT, " + "days_to_respond TEXT, " +
                "loan_days_to_respond TEXT, " + "copy_days_to_respond TEXT, " + "symbol TEXT, "+
                "country TEXT, " + "location TEXT, " + "loan_fees REAL, " +
                "copy_fees REAL, " + "source_state TEXT, " + "target_state TEXT, " + "zone TEXT) ";

        db.execSQL(CREATE_OCLC_SEARCH_RESULTS_TABLE);

    } // end method onCreate.

    /***
     * TODO Method description.
     *
     * @param db TODO description.
     * @param oldVersion TODO description.
     * @param newVersion TODO description.
     * @since 1.0
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // drop  old table
        db.execSQL("DROP TABLE IF EXISTS OCLC_SEARCH_RESULTS");

        // create new table
        this.onCreate(db);

    } // end method onUpgrade.

    /**
     * TODO Method description.
     *
     * @param institution TODO description.
     * @since 1.0
     */
    public void addInstitution(Institution institution) {

        //Log.d("addInstitution", institution.toString());
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
        values.put(KEY_SOURCE_STATE, institution.getSourceState());
        values.put(KEY_TARGET_STATE, institution.getTargetState());
        values.put(KEY_ZONE, institution.getZone());

        //Verify if institution already exists before adding
        Institution persistedInstitution = getInstitutionBySourceStateAndInstitutionId(institution.getSourceState(),
                institution.getTargetState(), institution.getInstitutionId());

        if (persistedInstitution == null) {
            db.insert(TABLE_OCLC_SEARCH_RESULTS,
                    null,
                    values);
        }

        db.close();

    } // end method addInstitution.

    /**
     * TODO Method description.
     *
     * @param sourceState TODO description.
     * @param institutionId TODO description.
     * @return - TODO description.
     * @since 1.0
     */
    private Institution getInstitutionBySourceStateAndInstitutionId(String sourceState, String targetState, String institutionId) {

        /*
         * Declare and initialize local variables.
         */

        Log.d("getInstSearchParams - ", sourceState);

        // not used.
        List<Institution> institutions = new LinkedList<>();

        String query = "SELECT * FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState +
                "' AND target_state = '" + targetState + "' AND institution_id = '" + institutionId + "'";

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
            institution.setLoanFees(cursor.getFloat(10));
            institution.setCopyFees(cursor.getFloat(11));
            institution.setSourceState(cursor.getString(12));
            institution.setTargetState(cursor.getString(13));
            institution.setZone(cursor.getInt(14));
        } // end if.

        cursor.close();
        return institution;

    } //end method getInstitutionBySearchParamsAndInstitutionId.


    public Integer getInstitutionCount(String query) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int rowCount = 0;

        if (cursor.moveToFirst()) {
            rowCount = cursor.getInt(0);
        }

        cursor.close();
        return rowCount;
    }

    public Integer getBookFreeCount(String sourceState, Integer zone) {
        String book_free_count_query = "SELECT count(*) FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState + "' " +
                "AND loan_fees = 0 AND zone = " + zone;
        return getInstitutionCount(book_free_count_query);
    }

    public Integer getBookPayCount(String sourceState, Integer zone) {
        String book_pay_count_query = "SELECT count(*) FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState + "' " +
                "AND loan_fees > 0 AND zone = " + zone;
        return getInstitutionCount(book_pay_count_query);
    }

    public Integer getARFreeCount(String sourceState, Integer zone) {
        String ar_free_count_query = "SELECT count(*) FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState + "' " +
                "AND copy_fees = 0 AND zone = " + zone;
        return getInstitutionCount(ar_free_count_query);
    }

    public Integer getARPayCount(String sourceState, Integer zone) {
        String ar_pay_count_query = "SELECT count(*) FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState + "' " +
                "AND copy_fees > 0 AND zone = " + zone;
        return getInstitutionCount(ar_pay_count_query);
    }

    public List<Institution> getAllInstitutionsBySourceAndTargetState(String sourceState, String targetState) {
        String select_query = "SELECT * FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState +
                "' AND target_state = '" + targetState + "'";
        return getAllInstitutions(select_query);
    }

    public List<Institution> getBookFreeInstitutionsBySourceStateAndZone(String sourceState, Integer zone) {
        String book_free_query = "SELECT * FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState + "' " +
                "AND loan_fees = 0 AND zone = " + zone;
        return getAllInstitutions(book_free_query);
    }

    public List<Institution> getBookPayInstitutionsBySourceStateAndZone(String sourceState, Integer zone) {
        String book_pay_query = "SELECT * FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState + "' " +
                "AND loan_fees > 0 AND zone = " + zone;
        return getAllInstitutions(book_pay_query);
    }

    public List<Institution> getARFreeInstitutionsBySourceStateAndZone(String sourceState, Integer zone) {
        String ar_free_query = "SELECT * FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState + "' " +
                "AND copy_fees = 0 AND zone = " + zone;
        return getAllInstitutions(ar_free_query);
    }

    public List<Institution> getARPayInstitutionsBySourceStateAndZone(String sourceState, Integer zone) {
        String ar_pay_query = "SELECT * FROM " + TABLE_OCLC_SEARCH_RESULTS + " where source_state = '" + sourceState + "' " +
                "AND copy_fees > 0 AND zone = " + zone;
        return getAllInstitutions(ar_pay_query);
    }

    /**
     * Return all records from the database in a linked list.
     *
     * @param query TODO description.
     * @return - TODO description.
     * @since 1.0
     */
    public List<Institution> getAllInstitutions(String query) {

        List<Institution> institutions = new LinkedList<>();

        //

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Institution institution;

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
                institution.setLoanFees(cursor.getFloat(10));
                institution.setCopyFees(cursor.getFloat(11));
                institution.setSourceState(cursor.getString(12));
                institution.setTargetState(cursor.getString(13));
                institution.setZone(cursor.getInt(14));

                institutions.add(institution);
            } while (cursor.moveToNext());
        } // end if.

        cursor.close();
        Log.d("getAllInstitutions()", institutions.toString());
        return institutions;

    } // end method getAllInstitutionsBySearchParams.

    /**
     * Updates Institution record in database.
     *
     * @param institution TODO description.
     * @return - TODO description.
     * @since 1.0
     */
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
        values.put(KEY_SOURCE_STATE, institution.getSourceState());
        values.put(KEY_TARGET_STATE, institution.getTargetState());
        values.put(KEY_ZONE, institution.getZone());

        int i = db.update(TABLE_OCLC_SEARCH_RESULTS,
                values,
                KEY_ID+" = ?",
                new String[] { String.valueOf(institution.getId()) });

        db.close();

        // the number of rows affected.
        return i;

    } // end method updateInstitution.

    /**
     * Gets the source state from the database.
     *
     * @return - String dbState: The source state from the first db record returned, or null if there are no records.
     * @see #TABLE_OCLC_SEARCH_RESULTS The OCLC Search Results table name
     * since 1.0
     */
    public String getDBSourceState() {

        //
        SQLiteDatabase db = this.getWritableDatabase();

        // Define a query to return the whole OCLC Search Results table from the database.
        String query = "SELECT * FROM " + TABLE_OCLC_SEARCH_RESULTS;

        // Get a cursor based on the query.
        Cursor cursor = db.rawQuery(query, null);

        // Set the default return value to null.
        String dbState = null;

        // Get the source state from the first record in the cursor,
        // if there is one.
        if (cursor.moveToFirst()) {
            dbState = (cursor.getString(12));
        } // end if.

        // Release cursor resources.
        cursor.close();

        // The source state from the first record returned,
        // or null if there are no records.
        return dbState;

    } // end method getDBSourceState.

    /**
     * Deletes Institution object record from the database.
     *
     * @param institution Institution object to delete from the database.
     * @since 1.0
     */
    public void deleteInstitution(Institution institution) {
        // Method stub.
    } // end method deleteInstitution.

} // end class deleteInstitution.
