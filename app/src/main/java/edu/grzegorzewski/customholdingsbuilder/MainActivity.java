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
import android.widget.Button;

import java.io.File;

import edu.grzegorzewski.customholdingsbuilder.dao.OclcDao;

/**
 * Determines if a database exits already.
 * Gets uer input to create new custom holdings,
 * to continue to create an unfinished custom holdings,
 * or to overwrite an existing custom holdings.
 *
 * @author Dennis Grzegorzewski.
 * @version 1.0, 11/23/2016
 */
public class MainActivity extends AppCompatActivity {

    /*
     * Declare Class variables
     */

    private static MainActivity mainActivityInstance;

    /*
     * Methods.
     */

    public static MainActivity getInstance() {
        return mainActivityInstance;
    }

    /**
     * Executes when activity starts.
     *
     * @see #setupContinueButton() Sets up the Continue Button.
     * @see #setupCreateNewButton() Sets up the Create New Button.
     * @param savedInstanceState - the saved activity state.
     * @since 1.0
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainActivityInstance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("onCreate()", "onCreate executed.");

        // Comment this out. deletes the database for testing.
        //this.deleteDatabase("OclcDB");
        //Log.d("onCreate()", "Database Deleted.");

        // Set up action for Create New Button.
        setupCreateNewButton();
        // Set up action for Continue Button.
        setupContinueButton();

        // Comment this out. For testing skip to...
        //startGetLocationActivity();
        // Comment this out. For testing skip to...
        //startGetHoldingsActivity();

    } // end method onCreate.

    /**
     * Executes when activity starts.
     *
     * @since 1.0
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart()", "onStart executed.");
    } // end method onStart.

    /**
     * Executes when the activity will start interacting with the user, and is at the top of the activity stack
     *
     * @since 1.0
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume()", "onResume executed.");
    } // end method onResume.

    /**
     * Executes when the activity becomes hidden.
     *
     * @since 1.0
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop()", "onStop executed.");
    } // end method onStop.

    /**
     * Executes before your activity is destroyed
     *
     * @since 1.0
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy()", "onDestroy executed.");
    } //end method onDestroy.

    /**
     * Sets up the Create New Button.
     *
     * @see #createPreviousHoldingsDialog() Create warning dialog about overwriting previous custom holdings.
     * @see #startGetLocationActivity() Launch GetLocationActivity.
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
            File database = getApplicationContext().getDatabasePath("OclcDB");
            if (database.exists()) {
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

        Log.d("setupCreateNewButton()", "Create New Button is set up.");

    } // end method setupCreateNewButton.

    /**
     * Sets up the Continue Button.
     *
     * @see #createNoPreviousHoldingsDialog() Create a warning dialog for creating new custom holdings.
     * @see #startGetHoldingsActivity() Launch GetHoldingsActivity.
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
                File database = getApplicationContext().getDatabasePath("OclcDB");
                if ( !database.exists()) {
                    Log.d("setupContinueNewButton", "database does not exist.");
                    // Create a dialog.
                    createNoPreviousHoldingsDialog();
                } //end if.
                else {
                    Log.d("setupContinueNewButton", "database exists.");
                    // Set source state in shared preferences to that in.
                    OclcDao oclcDao = new OclcDao(MainActivity.this);
                    if (oclcDao.getDBSourceState()==null) {
                        Log.d("setupContinueNewButton", "sourceState is null");
                        // Get state location.
                        startGetLocationActivity();
                    }
                    else {
                        SharedPreferences stateSetting = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                        SharedPreferences.Editor editor = stateSetting.edit();
                        editor.putString("sourceState", oclcDao.getDBSourceState());
                        editor.apply();
                        Log.d("SharedPreferences", "sourceState=" + oclcDao.getDBSourceState());
                        // Continue to previous holdings.
                        startGetHoldingsActivity();
                    }

                } //end else.

            } // end method onClick.

        }); // end button.setOnClickListener.

        Log.d("setupContinueButton()", "Continue Button is set up.");

    } // end method setupContinueButton.

    /**
     * Launch GetLocationActivity.
     *
     * @see GetLocationActivity Gets state location from user.
     * @since 1.0
     */
    void startGetLocationActivity() {

        // Create  intent for GetLocationActivity.
        Intent intent = new Intent(MainActivity.this, GetLocationActivity.class);
        Log.d("startGetLocationActvty", "Launch GetLocationActivity");
        // Execute intent.
        startActivity(intent);

    } // end method startGetLocationActivity.

    /**
     * Launch GetHoldingsActivity.
     *
     * @see GetHoldingsActivity displays state progress screen as it downloads holdings data
     * @since 1.0
     */
    void startGetHoldingsActivity() {

        // Create  intent for GetHoldingsActivity.
        Intent intent = new Intent(MainActivity.this, GetHoldingsActivity.class);
        Log.d("startGetHoldingsActvty", "Launch GetHoldingsActivity");
        // Execute intent.
        startActivity(intent);

    } // end method startGetHoldingsActivity.

    /**
     * Create warning dialog about overwriting previous custom holdings.
     * Called when previous holding exist.
     * On OK button calls startGetLocationActivity().
     *
     * @see #startGetLocationActivity() Launch GetLocationActivity.
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
                    getApplicationContext().deleteDatabase("OclcDB");
                    Log.d("PreviousHoldingsDialog", "Delete previous database");
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

        Log.d("createPreviousHldngsDlg", "Set up.");

    } // end method createPreviousHoldingsDialog.

    /**
     * Create a warning dialog for creating new custom holdings.
     * Called when no previous holding exist for continuing.
     * On OK button calls startGetLocationActivity().
     *
     * @see #startGetLocationActivity() Launch GetLocationActivity.
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

        Log.d("createNoPrevsHldgsDlg", "Set up.");

    } // end method createNoPreviousHoldingsDialog.

} // end class MainActivity.