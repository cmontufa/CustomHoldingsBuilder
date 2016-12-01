package edu.grzegorzewski.customholdingsbuilder;
/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

import edu.grzegorzewski.customholdingsbuilder.services.impl.OclcService;

/**
 * TODO Class description.
 *
 * @author Dennis Grzegorzewski.
 * @version 1.0, 11/23/2016
 */
public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivityInstance;

    public static MainActivity getInstance() {
        return mainActivityInstance;
    }

    private OclcService oclcService;
    private Boolean oclcServiceBounded = false;

    /**
     *
     */
    ServiceConnection oclcServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            oclcServiceBounded = true;
            OclcService.LocalBinder mLocalBinder = (OclcService.LocalBinder)service;
            oclcService = mLocalBinder.getServerInstance();
        } // end method onServiceConnected.

        @Override
        public void onServiceDisconnected(ComponentName name) {
            oclcServiceBounded = false;
            oclcService = null;
        } // end method onServiceDisconnected
    };

    //Example of the URL for search params of state:MA AND state:OH AND supplier:Y
    private static final String OCLC_URL = "https://ill.sd00.worldcat.org/illpolicies/institutionsearch?q=state:MA%20AND%20state:OH%20AND%20supplier:Y&wskey=vGFCwWwPUemlAApDyGfvpYrj2fR5orRXDVBrpO38RFDoHDnKlwh4bElCvfVaj8pG5KEP8HD4itDj7l4p";

    /**
     * Executes when activity starts.
     *
     * @param savedInstanceState - the saved activity state.
     * @since 1.0
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainActivityInstance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Comment this out. creates the the file for testing.
        //
        // Comment this out. deletes the database for testing.
        //this.deleteDatabase("CustomHoldingsDB");

        // Set up action for Create New Button.
        setupCreateNewButton();
        // Set up action for Continue Button.
        setupContinueButton();

    } // end method onCreate.

    /**
     * Executes when thr activity brcomrs hidden.
     *
     * @since 1.0
     */
    @Override
    protected void onStop() {
        super.onStop();

        // Unbind oclcServiceConnection service if bounded and unset flag.
        if(oclcServiceBounded) {
            unbindService(oclcServiceConnection);
            oclcServiceBounded = false;
        } // end if.

        Log.d("onStart()", "Service oclcServiceConnection unbind.");
    }

    /**
     * Executes when activity starts.
     *
     * @since 1.0
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Executes when the activity will start interacting with the user, and is at the top of the activity stack
     *
     * @since 1.0
     */
    @Override
    protected void onResume() {
        super.onResume();

        //
        oclcServiceBounded = getApplicationContext().bindService(
                new Intent(getApplicationContext(), OclcService.class),
                oclcServiceConnection,
                Context.BIND_AUTO_CREATE );

        Log.d("onStart()", "Service oclcServiceConnection Started");

    } // end method onResume.

    /**
     * Executes before your activity is destroyed
     *
     * @since 1.0
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Unbind oclcServiceConnection service if bounded.
        if (oclcServiceBounded) {
            getApplicationContext().unbindService(oclcServiceConnection);
        } // end if.

        Log.d("onStart()", "Service oclcServiceConnection unbind.");

    } //end method onDestroy.

    // TODO delete this block
    // MainActivity has leaked ServiceConnection error
    // Internet solution
    // This is usually a result of a Service being bound when an Activity is dismissed.
    // I've solved it before by keeping a boolean value in the Activity that keeps track of whether or not the Service is bound.
    // Then in onDestroy check if the Service is still bound with the boolean instance variable and unbind the Service if it is still bound.
    // I also do my initial binding of the Service in onResume while checking to make sure it isn't already bound with my boolean instance variable just in case
    // boolean isServiceBound = false;
    // isServiceBound = getApplicationContext().bindService( new Intent(getApplicationContext(), OclcService.class), oclcServiceConnection, Context.BIND_AUTO_CREATE );
    // if (isServiceBound)
    // getApplicationContext().unbindService(oclcServiceConnection);

    /**
     * Sets up the Create New Button.
     *
     * @since 1.0
     */
    private void setupCreateNewButton() {

        // Get button resource.
        Button button = (Button) findViewById(R.id.button_create_new);
        // Create button listener.
        button.setOnClickListener( new View.OnClickListener() {

            /**
             * Execute on Create New button click.
             *
             * @param view - the view to set OnClickListener
             * @since 1.0
             */
            @Override
            public void onClick(View view) {

            // If Previous Holdings exist, launch a warning dialog.
            File dbFile = new File("CustomHoldingsDB");
            if (dbFile.exists()) {
                Log.d("setupCreateNewButton", "database exists.");
                // Create a dialog.
                createPreviousHoldingsDialog();
            } //end if.
            else {
                Log.d("setupCreateNewButton", "database does not exist.");
                // Continue to create new holdings.
                startGetLocationActivity();
            } //end else.

            } // end method onClick.

        }); // end button.setOnClickListener

    } // end method setupCreateNewButton.

    /**
     * Sets up the Continue Button.
     *
     * @since 1.0
     */
    private void setupContinueButton() {

        // Get button resource.
        Button button = (Button) findViewById(R.id.button_continue);
        // Create button listener.
        button.setOnClickListener( new View.OnClickListener() {

            /**
             * Execute on continue button click.
             *
             * @param view - the view to set OnClickListener
             * @since 1.0
             */
            @Override
            public void onClick(View view) {

                // If No Previous Holdings exist, launch a warning dialog.
                File dbFile = new File("CustomHoldingsDB");
                if ( !dbFile.exists()) {
                    Log.d("setupCreateNewButton", "database does not exist.");
                    // Create a dialog.
                    createNoPreviousHoldingsDialog();
                } //end if.
                else {
                    Log.d("setupCreateNewButton", "database exists.");
                    // Continue to previous holdings.
                    startGetHoldingsActivity();
                } //end else.

            } // end method onClick.

        }); // end button.setOnClickListener.

    } // end method setupContinueButton.

    /**
     * Launch GetLocationActivity.
     *
     * @since 1.0
     */
    void startGetLocationActivity() {

        // Create  intent for GetLocationActivity.
        Intent intent = new Intent(MainActivity.this, GetLocationActivity.class);
        // Execute intent.
        startActivity(intent);

    } // end method startGetLocationActivity.

    /**
     * Launch GetHoldingsActivity.
     *
     * @since 1.0
     */
    void startGetHoldingsActivity() {

        // Create  intent for GetHoldingsActivity.
        Intent intent = new Intent(MainActivity.this, GetHoldingsActivity.class);
        // Execute intent.
        startActivity(intent);

    } // end method startGetHoldingsActivity.

    /**
     * Create warning dialog about overwriting previous custom holdings.
     * Called when previous holding exist.
     * On OK button calls startGetLocationActivity().
     *
     * @see #startGetLocationActivity()
     * @since 1.0
     */
    void createPreviousHoldingsDialog() {

        // Create a builder for an alert dialog that uses the default alert dialog theme.
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // Set the message to display using the given resource id.
        builder.setMessage(R.string.create_new_dialog_message);

        // Set the title using the given resource id.
        builder.setTitle(R.string.create_new_dialog_title);

        // Set a listener to be invoked when the positive button of the dialog is pressed.
        builder.setPositiveButton(
            R.string.ok,
            new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    // start new holdings
                    startGetLocationActivity();
                } // end method onClick
        });

        // Set a listener to be invoked when the negative button of the dialog is pressed.
        builder.setNegativeButton(
            R.string.cancel,
            new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    // Cancel the dialog.
                    dialog.cancel();
                } // end method onClick
        });

        // Create an AlertDialog with the arguments supplied to this builder.
        AlertDialog dialog = builder.create();
        dialog.show();

    } // end method createPreviousHoldingsDialog.

    /**
     * Create a warning dialog for creating new custom holdings.
     * Called when no previous holding exist for continuing.
     * On OK button calls startGetLocationActivity().
     *
     * @see #startGetLocationActivity()
     * @since 1.0
     */
    void createNoPreviousHoldingsDialog() {

        // Create a builder for an alert dialog that uses the default alert dialog theme.
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // Set the title using the given resource id.
        builder.setTitle(R.string.continue_dialog_title);

        // Set the message to display using the given resource id.
        builder.setMessage(R.string.continue_dialog_message);

        // Set a listener to be invoked when the positive button of the dialog is pressed.
        builder.setPositiveButton(
                R.string.ok,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // start new holdings
                        startGetLocationActivity();
                    } // end method onClick
                });

        // Set a listener to be invoked when the negative button of the dialog is pressed.
        builder.setNegativeButton(
                R.string.cancel,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // Cancel the dialog.
                        dialog.cancel();
                    } // end method onClick
                });

        // Create an AlertDialog with the arguments supplied to this builder.
        AlertDialog dialog = builder.create();
        dialog.show();

    } // end method createNoPreviousHoldingsDialog.

} // end class MainActivity.