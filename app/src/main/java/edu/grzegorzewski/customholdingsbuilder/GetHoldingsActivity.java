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

public class GetHoldingsActivity extends Activity {

    private OclcIntentServiceReceiver receiver;

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    } //end method onDestroy.

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public class OclcIntentServiceReceiver extends BroadcastReceiver {

        public static final String PROCESS_RESPONSE = "edu.grzegorzewski.customholdingsbuilder.intent.action.PROCESS_RESPONSE";

        @Override
        public void onReceive(Context context, Intent intent) {
            String processedState = intent.getStringExtra(OclcIntentService.BROADCAST_RESPONSE_STRING);
            int textViewId = getResources().getIdentifier(String.format("textView%s", processedState),
                    "id", getPackageName());
            TextView stateLabel = (TextView) findViewById(textViewId);
            stateLabel.setBackground(getResources().getDrawable(R.drawable.state_border_on));
            stateLabel.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
            //Toast.makeText(GetHoldingsActivity.this, "State Completed: " + intent.getStringExtra(OclcIntentService.BROADCAST_RESPONSE_STRING), Toast.LENGTH_LONG).show();
        }
    }
}
