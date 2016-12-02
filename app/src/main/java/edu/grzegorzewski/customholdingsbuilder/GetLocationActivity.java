package edu.grzegorzewski.customholdingsbuilder;

/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Displays a Spinner with a dropdown menu of US state and territory abbreviations,
 * and a button which launches the GetHoldingsActivity when clicked.
 * When the GetHoldingsActivity is launched, the intent carries the String value of the state selected.
 * The default value for the state is set to IL.
 *
 * @author Dennis Grzegorzewski.
 * @version 1.0, 11/23/2016
 */
public class GetLocationActivity extends Activity implements AdapterView.OnItemSelectedListener {

    /*
     * Declare class variables
     */
    private String itemState; // State selected from dropdown spinner.

    /**
     * Executes when activity starts.
     *
     * @param savedInstanceState - the saved activity state.
     * @since 1.0
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);

        // Sets a Spinner to display a list of state and territory abbreviations for selection.
        setupStateSpinner();

        // Sets up the Begin Building Holdings Button.
        // Launches GetHoldingsActivity.
        setupBeginBuildingHoldingsButton();

    } // end method onCreate

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
     * @since 1.0
     */
    private void setupBeginBuildingHoldingsButton() {

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

                // Create  intent for GetHoldingsActivity.
                Intent intent = new Intent(GetLocationActivity.this, GetHoldingsActivity.class);
                // send value of state to GetHoldingsActivity.
                intent.putExtra("state", itemState);
                // Execute intent.
                startActivity(intent);

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
        itemState = parent.getItemAtPosition(position).toString();
        // display item text in a toast
        Toast.makeText(GetLocationActivity.this, itemState + ": Selected", Toast.LENGTH_LONG).show();

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

} // end class GetLocationActivity.