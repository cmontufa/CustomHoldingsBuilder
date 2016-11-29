package edu.grzegorzewski.customholdingsbuilder;
/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO Class description.
 *
 * @author Dennis Grzegorzewski.
 * @version 1.0, 11/23/2016
 */
public class GetLocationActivity extends Activity implements AdapterView.OnItemSelectedListener {

    // the state of origin for canculations
    //final TextView state = (TextView) findViewById(R.id.textView_auto_this);
    //String currentState = (String) state.getText();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);

        //Log.d("currentState = ", currentState);
        //setupAutoLocationState();
        setupStateSpinner();
        setupStartButton();

    } // end method onCreate

    private void setupAutoLocationState() {


        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        // Create a listener for location updates
        // Used for receiving notifications from the LocationManager when the location has changed.
        LocationListener locationListener = new LocationListener() {

            // Called when the location has changed.
            public void onLocationChanged(Location location) {
                //
                ThisState thisState = new ThisState() {
                };
                //
                // try {
                // get the state from the location address.
                //currentState = (String) thisState.getThisState(location.getLatitude(), location.getLongitude());
                //} // end try
                //
                //catch (IOException e) {
                //    e.printStackTrace();
                //} // end catch

                // change textview
                //state.setText(currentState);
            } // end method onLocationChanged

            /**
             * Called when the provider status changes.
             * This method is called when a provider is unable to fetch a location
             * or if the provider has recently become available after a period of unavailability.
             *
             * @param provider String: the name of the location provider associated with this update.
             * @param status int: OUT_OF_SERVICE if the provider is out of service,
             *               and this is not expected to change in the near future;
             *               TEMPORARILY_UNAVAILABLE if the provider is temporarily unavailable
             *               but is expected to be available shortly;
             *               and AVAILABLE if the provider is currently available.
             * @param extras Bundle: an optional Bundle which will contain
             *               provider specific status variables.
             */
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            /**
             * Called when the provider is enabled by the user.
             *
             * @param provider String: the name of the location provider associated with this update.
             */
            public void onProviderEnabled(String provider) {
            }

            /**
             * Called when the provider is disabled by the user.
             * If requestLocationUpdates is called on an already disabled provider,
             * this method is called immediately.
             *
             * @param provider String: the name of the location provider associated with this update.
             */
            public void onProviderDisabled(String provider) {
            }
        };

        // TODO if location permission is not granted
       /* if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            // ActivityCompat#requestPermissions here to request the missing permissions,
            // and then overriding
            // public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission.
            // See the documentation for ActivityCompat#requestPermissions for more details.
            return;
        }
        // Register the listener with the Location Manager to receive location updates
        // Register for location updates using the named provider, and a pending intent.
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);*/

    } // end method setupAutoLocationState

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


    } // end method setupStateSpinner

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

    } // end method setStateList

    private void setupStartButton() {
    } // end method setupStartButton

    /**
     * Callback method to be invoked when an item in this view has been selected.
     * This callback is invoked only when the newly selected position is different
     * from the previously selected position or if there was no selected item.
     * Implementers can call getItemAtPosition(position)
     * if they need to access the data associated with the selected item.
     *
     * @param parent AdapterView: The AdapterView where the selection happened.
     * @param view View: The view within the AdapterView that was clicked.
     * @param position int: The position of the view in the adapter.
     * @param id long: The row id of the item that is selected.
     * @since 1.0
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //
        String item = parent.getItemAtPosition(position).toString();
        //display location data toast
        Toast.makeText(GetLocationActivity.this, item + ": Selected", Toast.LENGTH_LONG).show();
    } // end method onItemSelected.

    /**
     * Callback method to be invoked when the selection disappears from this view.
     * The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent AdapterView: The AdapterView that now contains no selected item.
     * @since 1.0
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Auto-generated method stub.
    } //end method onNothingSelected.

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

} // end class GetLocationActivity.