package edu.grzegorzewski.customholdingsbuilder;
/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        // Set up action for Start Button.
        setupCreateNewButton();
        // Set up action for Continue Button.
        setupContinueButton();

    } // end method onCreate

    /**
     * TODO Method description.
     *
     * @since 1.0
     */
    private void setupCreateNewButton() {

        // Get button resource.
        Button button = (Button) findViewById(R.id.button_create_new);
        // Create button listener.
        button.setOnClickListener( new View.OnClickListener() {

            /**
             * Execute on create new button click.
             *
             * @param view - the view to set OnClickListener
             * @since 1.0
             */
            @Override
            public void onClick(View view) {

                // TODO If Previous Holdings exist, launch a warning dialog
                // right now always launch dialog.

                // Create a dialog.
                createPreviousHoldingsDialog();

                // TODO else continue to create new holdings.
                // startGetLocationActivity();

            } // end method onClick.

        }); // end button.setOnClickListener

    } // end method setupCreateNewButton.

    /**
     * TODO Method description.
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

                // TODO If No Previous Holdings exist, launch a warning dialog
                // right now always launch dialog.

                // Create a dialog.
                createNoPreviousHoldingsDialog();

                // TODO else continue to previous holdings.
                // startGetHoldingsActivity();

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
     * TODO Method description.
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
     * TODO Method description.
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

} // end class MainActivity.