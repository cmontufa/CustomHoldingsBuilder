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
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.widget.TextView;

import edu.grzegorzewski.customholdingsbuilder.services.OclcIntentService;

/**
 * TODO Class description.
 *
 * @author Christopher Montufar.
 * @version 1.0, 12/01/2016.
 */
public class GetHoldingsActivity extends Activity {

    /*
     * Declare class variables
     */
    private OclcIntentServiceReceiver receiver;

    /*
     * Methods.
     */

    /**
     * Executes when activity starts.
     *
     * @param savedInstanceState - the saved activity state.
     * @since 1.0
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_holdings);

        IntentFilter filter = new IntentFilter(OclcIntentServiceReceiver.PROCESS_RESPONSE);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver = new OclcIntentServiceReceiver();
        registerReceiver(receiver, filter);

        //Intent passed in
        Intent thisIntent = this.getIntent();

        String state = thisIntent.getStringExtra("state");

        Intent msgIntent = new Intent(GetHoldingsActivity.this, OclcIntentService.class);
        msgIntent.putExtra("state", state);
        startService(msgIntent);

    } // end method onCreate.

    /**
     *
     * @since 1.0
     */
    @Override
    protected void onStart() {
        super.onStart();

    } //end method onStart.

    /**
     *
     * @since 1.0
     */
    @Override
    protected void onResume() {
        super.onResume();
    } //end method onResume.

    /**
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
         * @param context
         * @param intent
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

            // Change the background and text color.
            stateLabel.setBackground(getResources().getDrawable(R.drawable.state_border_on));
            stateLabel.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
            //Toast.makeText(GetHoldingsActivity.this, "State Completed: " + intent.getStringExtra(OclcIntentService.BROADCAST_RESPONSE_STRING), Toast.LENGTH_LONG).show();

        } //end method onReceive.

    } //end class OclcIntentServiceReceiver.

} // end class GetHoldingsActivity
