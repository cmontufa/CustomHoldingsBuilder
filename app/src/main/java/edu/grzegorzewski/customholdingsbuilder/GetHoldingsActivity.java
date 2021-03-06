package edu.grzegorzewski.customholdingsbuilder;

/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import edu.grzegorzewski.customholdingsbuilder.dao.OclcDao;
import edu.grzegorzewski.customholdingsbuilder.services.OclcIntentService;

/**
 * TODO Class description.
 *
 * @author Christopher Montufar.
 * @version 1.0, 12/01/2016.
 */
public class GetHoldingsActivity extends AppCompatActivity {

    /*
     * Declare class variables
     */

    private static GetHoldingsActivity getHoldingsActivityInstance;
    private OclcIntentServiceReceiver receiver;
    private String sourceState;

    /*
     * Methods.
     */

    public static GetHoldingsActivity getInstance() {
        return getHoldingsActivityInstance;
    }

    /**
     * Executes when activity starts.
     *
     * @param savedInstanceState - the saved activity state.
     * @since 1.0
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getHoldingsActivityInstance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_holdings);


        OclcDao oclcDao = new OclcDao(GetHoldingsActivity.this);
        String dbState = oclcDao.getDBSourceState();

        //TODO Description.
        setupContinueProcessingButton();

        //TODO Description.
        IntentFilter filter = new IntentFilter(OclcIntentServiceReceiver.PROCESS_RESPONSE);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver = new OclcIntentServiceReceiver();
        registerReceiver(receiver, filter);

        //Intent passed in
        //Intent thisIntent = this.getIntent();
       // sourceState = thisIntent.getStringExtra("state");

        SharedPreferences stateSetting = PreferenceManager.getDefaultSharedPreferences(GetHoldingsActivity.this);
        String sourceState = stateSetting.getString("sourceState", dbState);

        Intent msgIntent = new Intent(GetHoldingsActivity.this, OclcIntentService.class);
        msgIntent.putExtra("state", sourceState);
        startService(msgIntent);

    } // end method onCreate.

    /**
     * TODO Method description.
     *
     * @since 1.0
     */
    @Override
    protected void onStart() {
        super.onStart();

    } //end method onStart.

    /**
     * TODO Method description.
     *
     * @since 1.0
     */
    @Override
    protected void onResume() {
        super.onResume();
    } //end method onResume.

    @Override
    protected void onStop() {
        if (receiver!=null) {
            unregisterReceiver(receiver);
            receiver=null;
        }
        super.onStop();
    }

    /**
     * TODO Method description.
     *
     * @since 1.0
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    } //end method onDestroy.

    /*
     * Inside classes.
     */

    /**
     * TODO Class description.
     *
     * @since 1.0
     */
    public class OclcIntentServiceReceiver extends BroadcastReceiver {

        /*
         * Declare class variables
         */
        public static final String PROCESS_RESPONSE = "edu.grzegorzewski.customholdingsbuilder.intent.action.PROCESS_RESPONSE";

        /*
         * Methods.
         */

        /**
         * TODO Method description.
         *
         * @param context TODO description.
         * @param intent TODO description.
         * @since 1.0
         */
        @Override
        public void onReceive(Context context, Intent intent) {

            // TODO description.
            String processedState = intent.getStringExtra(OclcIntentService.BROADCAST_RESPONSE_STRING);

            // TODO description.
            int textViewId = getResources().getIdentifier(String.format("textView%s", processedState),
                    "id", getPackageName());

            // Find the state label.
            TextView stateLabel = (TextView) findViewById(textViewId);
            TextView status = (TextView) findViewById(R.id.textViewStatus);
            TextView processButton = (TextView) findViewById(R.id.button_continue_to_process);

            // Change the background and text color.
            stateLabel.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.state_border_on));
            stateLabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryLight));
            //Toast.makeText(GetHoldingsActivity.this, "State Completed: " + intent.getStringExtra(OclcIntentService.BROADCAST_RESPONSE_STRING), Toast.LENGTH_LONG).show();

            // When the the last state is completed.
            if (Objects.equals(processedState, "WY")) {
                // Hide the status
                status.setVisibility(View.INVISIBLE);
                // Reveal the Continue Processing button
                processButton.setVisibility(View.VISIBLE);
            } // end if.

        } //end method onReceive.

    } //end class OclcIntentServiceReceiver.

    /**
     * Sets up the Begin Building Holdings Button.
     *
     * @since 1.0
     */
    private void setupContinueProcessingButton() {

        // Get button resource.
        Button button = (Button) findViewById(R.id.button_continue_to_process);
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

                // Launch ProcessListActivity.

                // Create  intent for GetHoldingsActivity.
                Intent intent = new Intent(GetHoldingsActivity.this, ProcessListActivity.class);
                // Execute intent.
                startActivity(intent);

            } // end method onClick.

        }); // end button.setOnClickListener

    } // end method setupContinueProcessingButton.

} // end class GetHoldingsActivity
