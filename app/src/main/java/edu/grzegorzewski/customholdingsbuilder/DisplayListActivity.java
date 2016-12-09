package edu.grzegorzewski.customholdingsbuilder;

/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Displays a selected custom holdings list content on the in a srollong test view.
 *
 * @author Dennis Grzegorzewski.
 * @version 1.0, 12/01/2016
 */
public class DisplayListActivity extends AppCompatActivity {

    private static final String INTENT_PARAM_SYMBOLS = "symbols";
    private static final String INTENT_PARAM_CUSTOM_HOLDINGS_LIST = "customHoldingsList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        Intent displayListActivity = this.getIntent();

        String symbols = displayListActivity.getStringExtra(INTENT_PARAM_SYMBOLS);
        String customHoldingsList = displayListActivity.getStringExtra(INTENT_PARAM_CUSTOM_HOLDINGS_LIST);


        TextView holdingsListTitle = (TextView) findViewById(R.id.textView_display_title);
        holdingsListTitle.setText(customHoldingsList);
        TextView holdingsList = (TextView) findViewById(R.id.textView_display_list);
        holdingsList.setText(symbols);

    } // end methd onCreate.

} // end class DisplayListActivity.
