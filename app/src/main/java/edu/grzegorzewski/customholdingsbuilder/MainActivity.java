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
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        // Comment this out. deletes the database for testing.
        //this.deleteDatabase("CustomHoldingsDB");

        // Set up action for Create New Button.
        setupCreateNewButton();
        // Set up action for Continue Button.
        setupContinueButton();

    } // end method onCreate.

    /**
     * Executes when activity stops.
     *
     * @since 1.0
     */
    @Override
    protected void onStop() {
        super.onStop();
        if(oclcServiceBounded) {
            unbindService(oclcServiceConnection);
            oclcServiceBounded = false;
        }
    };

    /**
     * Executes when activity starts.
     *
     * @since 1.0
     */
    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, OclcService.class), oclcServiceConnection, BIND_AUTO_CREATE);
        Log.d("onStart()", "Service Started");
    }

    /**
     * Sets up the Create New Button
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
                // TODO else continue to create new holdings.
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
                    // TODO else continue to previous holdings.
                    // startGetHoldingsActivity();
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
     *
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
                }
        });
        // Set a listener to be invoked when the negative button of the dialog is pressed.
        builder.setNegativeButton(
            R.string.cancel,
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Cancel the dialog.
                    dialog.cancel();
                }
        });
        // Create an AlertDialog with the arguments supplied to this builder.
        AlertDialog dialog = builder.create();
        dialog.show();

    } // end method createPreviousHoldingsDialog.

    /**
     * Create a warning dialog for creating new custom holdings.
     *
     * @since 1.0
     */
    void createNoPreviousHoldingsDialog() {

        // Create a builder for an alert dialog that uses the default alert dialog theme.
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Set the message to display using the given resource id.
        builder.setMessage(R.string.continue_dialog_message);
        // Set the title using the given resource id.
        builder.setTitle(R.string.continue_dialog_title);
        // Set a listener to be invoked when the positive button of the dialog is pressed.
        builder.setPositiveButton(
                R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // start new holdings
                        startGetLocationActivity();
                    }
                });
        // Set a listener to be invoked when the negative button of the dialog is pressed.
        builder.setNegativeButton(
                R.string.cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cancel the dialog.
                        dialog.cancel();
                    }
                });
        // Create an AlertDialog with the arguments supplied to this builder.
        AlertDialog dialog = builder.create();
        dialog.show();

    } // end method createNoPreviousHoldingsDialog.


    ServiceConnection oclcServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            oclcServiceBounded = true;
            OclcService.LocalBinder mLocalBinder = (OclcService.LocalBinder)service;
            oclcService = mLocalBinder.getServerInstance();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            oclcServiceBounded = false;
            oclcService = null;
        }
    };





} // end class MainActivity.