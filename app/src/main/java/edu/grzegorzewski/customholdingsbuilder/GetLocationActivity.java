package edu.grzegorzewski.customholdingsbuilder;

/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.grzegorzewski.customholdingsbuilder.dao.OclcDao;

/**
 * Displays a Spinner with a dropdown menu of US state and territory abbreviations,
 * and a button which launches the GetHoldingsActivity when clicked.
 * When the GetHoldingsActivity is launched, the intent carries the String value of the state selected.
 * The default value for the state is set to IL.
 *
 * @author Dennis Grzegorzewski.
 * @version 1.0, 11/23/2016
 */
public class GetLocationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /*
     * Declare and initialize class variables
     */

    private static GetLocationActivity getLocationActivityInstance;
    private String stateItemSelected; // State selected from dropdown spinner.

    /*
     * Methods.
     */

    /**
     * TODO Description.
     *
     * @return TODO Description.
     */
    public static GetLocationActivity getInstance() {
        return getLocationActivityInstance;
    } // end method getInstance.

    /**
     * Executes when activity starts.
     *
     * @param savedInstanceState - the saved activity state.
     * @see #setupStateSpinner() TODO Description.
     * @see #setupBeginBuildingHoldingsButton(String) TODO Description.
     * @since 1.0
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getLocationActivityInstance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);

        OclcDao oclcDao = new OclcDao(GetLocationActivity.this);
        String dbState = oclcDao.getDBSourceState();

        // Sets a Spinner to display a list of state and territory abbreviations for selection.
        setupStateSpinner();

        // Sets up the Begin Building Holdings Button.
        // Which launches GetHoldingsActivity.
        setupBeginBuildingHoldingsButton(dbState);

    } // end method onCreate.

    /**
     * Called when the activity is becoming visible to the user.
     * Called by onCreate method.
     *
     * @since 1.0
     */
    @Override
    public void onStart() {
        super.onStart();
        // Auto-generated method stub.
    } //end method onStart.

    /**
     * Called when the activity is no longer visible to the user.
     *
     * @since 1.0
     */
    @Override
    public void onStop() {
        super.onStop();
        // Auto-generated method stub.
    } // end method onStop.

    /**
     * Sets a Spinner to display a list of state and territory abbreviations for selection.
     *
     * @see #setStateList() Creates an ArrayList of Strings stateList containing state abbreviation data.
     * @since 1.0
     */
    private void setupStateSpinner() {

        // Create a spinner object.
        Spinner spinner = (Spinner) findViewById(R.id.state_spinner);

        // Declare and initialize stateList
        List<String> stateList = setStateList();

        // Set a listener on the spinner
        spinner.setOnItemSelectedListener(this);

        // Create a data adapter for the spinner list
        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stateList);

        // Set the layout resource to create the drop down views.
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Attach the data adapter to spinner
        spinner.setAdapter(dataAdapter);

        // Set default selection to IL
        spinner.setSelection(14, true);

        // Set the layout resource to create the drop down views.
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


    } // end method setupStateSpinner.

    /**
     * Sets up the Begin Building Holdings Button.
     *
     * @param dbState TODO Description.
     * @see #stateItemSelected TODO Description.
     * @see #startGetHoldingsActivity() TODO Description.
     * @see #createStateMismatchDialog(String) TODO Description.
     * @since 1.0
     */
    private void setupBeginBuildingHoldingsButton(final String dbState) {

        // Get button resource.
        Button button = (Button) findViewById(R.id.button_begin_building);
        // Create button listener.
        button.setOnClickListener( new View.OnClickListener() {

            /**
             * Execute on Begin Building Holdings button click.
             *
             * @param view - the view to set OnClickListener
             * @since 1.0
             */
            @Override
            public void onClick(View view) {

                // Launch GetHoldingsActivity.

                // if the spinner selected state is different than database state.
                if (!stateItemSelected.equals(dbState)&&(dbState != null)){
                    //open a dialog and ask if you want to start a new database
                    createStateMismatchDialog(dbState);
                }

                if (stateItemSelected == null) {
                    pleaseSelectAStateDialog();
                }
                // change state in shared preferences.
                setSharedPreferencesSourceState(stateItemSelected);
                // Launch GetHoldingsActivity.
                startGetHoldingsActivity();

            } // end method onClick.

        }); // end button.setOnClickListener

    } // end method setupBeginBuildingHoldingsButton.

    /**
     * Creates an ArrayList of Strings stateList containing state abbreviation data.
     * Used by setupStateSpinner.
     *
     * @return - stateList: A List of Strings containing state abbreviations.
     * @since 1.0
     */
    private List<String> setStateList() {

        // Declare an Array of Strings and initialize with state abbreviation data.
        String[] stateNames = {"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
                "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME",
                "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM",
                "NV", "NY", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN",
                "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};

        // Create an ArrayList of Strings stateList.
        List<String> stateList = new ArrayList<>();

        // Add the contents of the Array of Strings statenames to the ArrayList of Strings stateList
        Collections.addAll(stateList, stateNames);

        // A List of Strings containing state abbreviations.
        return stateList;

    } // end method setStateList.

    /**
     * Initializes state field variable with item selected from Spinner.
     * Displays Toast.
     *
     * Callback method to be invoked when an item in this view has been selected.
     * This callback is invoked only when the newly selected position is different
     * from the previously selected position or if there was no selected item.
     * Implementers can call getItemAtPosition(position)
     * if they need to access the data associated with the selected item.
     * Implimented method for AdapterView.OnItemSelectedListener interface.
     *
     * @param parent AdapterView: The AdapterView where the selection happened.
     * @param view View: The view within the AdapterView that was clicked.
     * @param position int: The position of the view in the adapter.
     * @param id long: The row id of the item that is selected.
     * @since 1.0
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // get the text of the item at selected position.
        stateItemSelected = parent.getItemAtPosition(position).toString();
        // display item text in a toast
        Toast.makeText(GetLocationActivity.this, stateItemSelected + ": Selected", Toast.LENGTH_LONG).show();

    } // end method onItemSelected.

    /**
     * Callback method to be invoked when the selection disappears from this view.
     * The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     * Implimented method for AdapterView.OnItemSelectedListener interface.
     *
     * @param parent AdapterView: The AdapterView that now contains no selected item.
     * @since 1.0
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing.
    } //end method onNothingSelected.

    /**
     * Create warning dialog about overwriting previous custom holdings.
     * Called when previous holding exist.
     * On OK button calls startGetLocationActivity().
     *
     * @param dbState TODO Description.
     * @see #stateItemSelected TODO Description.
     * @see #setSharedPreferencesSourceState(String) TODO Description.
     * @see #startGetHoldingsActivity() TODO Description.
     * @since 1.0
     */
    void createStateMismatchDialog(final String dbState) {

        // Create a builder for an alert dialog that uses the default alert dialog theme.
        AlertDialog.Builder builder = new AlertDialog.Builder(GetLocationActivity.this);

        // Set the title using the given resource id.
        builder.setTitle("Previous Custom Holdings For " + dbState + "Exist");

        // Set the message to display using the given resource id.
        builder.setMessage("Are you sure you want to create new holdings for " + stateItemSelected +
                ". Previous holdings for " + dbState + " will be lost.");

        // Set a listener to be invoked when the positive button of the dialog is pressed.
        builder.setPositiveButton(
                R.string.ok,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // if ok delete database and use this selected state.
                        getApplicationContext().deleteDatabase("OclcDB");
                        Log.d("PreviousHoldingsDialog", "Delete previous database");

                        // change state in shared preferences.
                        setSharedPreferencesSourceState(stateItemSelected);
                        Log.d("SharedPreferences", "sourceState=" + stateItemSelected);

                        //  Launch GetHoldingsActivity.
                        startGetHoldingsActivity();
                    } // end method onClick
                });

        // Set a listener to be invoked when the negative button of the dialog is pressed.
        builder.setNegativeButton(
                R.string.cancel,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // if cancel use database state.
                        setSharedPreferencesSourceState(dbState);
                        Log.d("SharedPreferences", "sourceState=" + dbState);
                        // Cancel the dialog.
                        dialog.cancel();
                    } // end method onClick
                });

        // Create an AlertDialog with the arguments supplied to this builder.
        AlertDialog dialog = builder.create();
        dialog.show();

        Log.d("createPreviousHldngsDlg", "Set up.");

    } // end method createStateMismatchDialog.

    /**
     * Launch GetHoldingsActivity.
     *
     * @since 1.0
     */
    void startGetHoldingsActivity() {

        // Create  intent for GetHoldingsActivity.
        Intent intent = new Intent(GetLocationActivity.this, GetHoldingsActivity.class);
        Log.d("startGetHoldingsActvty", "Launch GetHoldingsActivity");
        // Execute intent.
        startActivity(intent);

    } // end method startGetHoldingsActivity.

    /**
     * TODO Description.
     *
     * @param state TODO Description.
     * @since 1.0
     */
    public void setSharedPreferencesSourceState(String state) {

        // Set source state in shared preferences.
        SharedPreferences stateSetting = PreferenceManager.getDefaultSharedPreferences(GetLocationActivity.this);
        SharedPreferences.Editor editor = stateSetting.edit();
        editor.putString("sourceState", state);
        // Commit the edits!
        editor.apply();
        Log.d("setSharePrefSourceState", "sourceState=" + state);

    } // end method setSharedPreferencesSourceState.

    public void pleaseSelectAStateDialog() {

        // Create a builder for an alert dialog that uses the default alert dialog theme.
        AlertDialog.Builder builder = new AlertDialog.Builder(GetLocationActivity.this);

        // Set the title using the given resource id.
        builder.setTitle("A Location Has Not Been Chosen");

        // Set the message to display using the given resource id.
        builder.setMessage("Please select a state.");

        // Set a listener to be invoked when the positive button of the dialog is pressed.
        builder.setPositiveButton(
                R.string.ok,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // Cancel the dialog.
                        dialog.cancel();
                    } // end method onClick
                });


        // Create an AlertDialog with the arguments supplied to this builder.
        AlertDialog dialog = builder.create();
        dialog.show();

        Log.d("pleaseSelectStateDialog", "Set up.");

    } // end method pleaseSelectAStateDialog.

} // end class GetLocationActivity.