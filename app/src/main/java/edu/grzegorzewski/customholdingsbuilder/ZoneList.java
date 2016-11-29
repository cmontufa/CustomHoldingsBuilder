package edu.grzegorzewski.customholdingsbuilder;
/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */
import java.util.ArrayList;
import java.util.Collections;

/**
 * TODO Class description THIS IS NOT READY TO USE.
 *
 * @author Dennis Grzegorzewski.
 * @version 1.0, 11/26/2016
 */
class ZoneList {

    /*
     * Declare instance variables.
     */
    private ArrayList<Zone> zones; // A list of 10 zones, each containing a list of U.S. state or territory abbreviations.

    /*
     * Constructors.
     */

    /**
     * TODO Constructor description.
     *
     * @param state
     * @see #zones  A list of 10 zones, each containing a list of U.S. state or territory abbreviations.
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    public ZoneList(String state) {
        setZone0(state);
        setZone1(state);
        setZone2(state);
        setZone3(state);
        setZone4(state);
        setZone5(state);
        setZone6(state);
        setZone7(state);
        setZone8(state);
        setZone9(state);
        setZone10(state);
    } // end constructor.

    /*
     * NOTE:
     * The switch statements in the following methods could have the empty cases deleted,
     * but they are left to facilitate any future changes to the zone areas.
     */
    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone0(String state) {
        Zone zone = new Zone();
        zone.addState(state);
        this.zones.add(0, zone);
    } // end method setZone0.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone1(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                Collections.addAll(states, "GA", "KY", "LA", "MS", "TN");
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                Collections.addAll(states, "NY", "VT", "NH", "ME", "MA", "RI", "NJ", "DE", "MD");
                break;
            case "DC":
                Collections.addAll(states, "VA", "MD", "DE", "NJ", "PA");
                break;
            case "DE":
                Collections.addAll(states, "MD", "NJ", "CT", "PA");
                break;
            case "FL":
                break;
            case "GA":
                Collections.addAll(states, "AL");
                break;
            case "HI":
                break;
            case "IA":
                Collections.addAll(states, "MO", "MN", "NE", "KS");
                break;
            case "ID":
                Collections.addAll(states, "UT");
                break;
            case "IL":
                Collections.addAll(states, "IN", "IA", "WI");
                break;
            case "IN":
                Collections.addAll(states, "IL", "OH", "KY");
                break;
            case "KS":
                Collections.addAll(states, "OK");
                break;
            case "KY":
                Collections.addAll(states, "TN", "IN", "OH", "WV");
                break;
            case "LA":
                Collections.addAll(states, "MS");
                break;
            case "MA":
                Collections.addAll(states, "VT", "NH", "ME", "RI", "CT", "NJ", "DE", "NY");
                break;
            case "MD":
                Collections.addAll(states, "DE", "VA", "DC", "NJ", "PA");
                break;
            case "ME":
                Collections.addAll(states, "VT", "NH", "MA", "CT", "RI");
                break;
            case "MI":
                break;
            case "MN":
                Collections.addAll(states, "WI", "IA");
                break;
            case "MO":
                Collections.addAll(states, "IL");
                break;
            case "MS":
                Collections.addAll(states, "LA");
                break;
            case "MT":
                break;
            case "NC":
                Collections.addAll(states, "SC", "VA", "DC");
                break;
            case "ND":
                break;
            case "NE":
                Collections.addAll(states, "KS", "IA");
                break;
            case "NH":
                Collections.addAll(states, "ME", "VT", "MA", "CT", "RI");
                break;
            case "NJ":
                Collections.addAll(states, "DE", "MD", "CT", "MA", "VT", "NY", "PA");
                break;
            case "NM":
                break;
            case "NV":
                Collections.addAll(states, "UT", "ID");
                break;
            case "NY":
                Collections.addAll(states, "NJ", "DE", "CT", "RI", "MA", "NH", "VT", "ME");
                break;
            case "OH":
                Collections.addAll(states, "IN", "KY", "MI");
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                Collections.addAll(states, "NJ", "DE", "MD", "DC", "CT", "OH", "WV", "VA");
                break;
            case "PR":
                break;
            case "RI":
                Collections.addAll(states, "ME", "VT", "NH", "MA", "CT", "NJ");
                break;
            case "SC":
                Collections.addAll(states, "GA");
                break;
            case "SD":
                Collections.addAll(states, "NE", "MN", "ND");
                break;
            case "TN":
                Collections.addAll(states, "KY");
                break;
            case "TX":
                break;
            case "UT":
                Collections.addAll(states, "ID");
                break;
            case "VA":
                Collections.addAll(states, "WV", "DC", "MD", "DE", "NC");
                break;
            case "VT":
                Collections.addAll(states, "NH", "ME", "NY", "MA", "CT", "RI");
                break;
            case "WA":
                Collections.addAll(states, "OR");
                break;
            case "WI":
                Collections.addAll(states, "IL", "IN");
                break;
            case "WV":
                Collections.addAll(states, "VA", "KY", "OH");
                break;
            case "WY":
                break;
            default:
                break;
        } // end switch
        zone.addState(state);
        this.zones.add(1, zone);
    } // end method setZone1.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone2(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                Collections.addAll(states, "IL", "IN");
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                break;
            case "DC":
                break;
            case "DE":
                break;
            case "FL":
                break;
            case "GA":
                break;
            case "HI":
                break;
            case "IA":
                break;
            case "ID":
                break;
            case "IL":
                break;
            case "IN":
                break;
            case "KS":
                break;
            case "KY":
                break;
            case "LA":
                break;
            case "MA":
                break;
            case "MD":
                break;
            case "ME":
                break;
            case "MI":
                break;
            case "MN":
                break;
            case "MO":
                break;
            case "MS":
                break;
            case "MT":
                break;
            case "NC":
                break;
            case "ND":
                break;
            case "NE":
                break;
            case "NH":
                break;
            case "NJ":
                break;
            case "NM":
                break;
            case "NV":
                break;
            case "NY":
                break;
            case "OH":
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                break;
            case "PR":
                break;
            case "RI":
                break;
            case "SC":
                break;
            case "SD":
                break;
            case "TN":
                break;
            case "TX":
                break;
            case "UT":
                break;
            case "VA":
                break;
            case "VT":
                break;
            case "WA":
                break;
            case "WI":
                break;
            case "WV":
                break;
            case "WY":
                break;
            default:
                break;
        } // end switch.
        zone.addState(state);
        this.zones.add(2, zone);
    } // end method setZone2.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone3(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                break;
            case "DC":
                break;
            case "DE":
                break;
            case "FL":
                break;
            case "GA":
                break;
            case "HI":
                break;
            case "IA":
                break;
            case "ID":
                break;
            case "IL":
                break;
            case "IN":
                break;
            case "KS":
                break;
            case "KY":
                break;
            case "LA":
                break;
            case "MA":
                break;
            case "MD":
                break;
            case "ME":
                break;
            case "MI":
                break;
            case "MN":
                break;
            case "MO":
                break;
            case "MS":
                break;
            case "MT":
                break;
            case "NC":
                break;
            case "ND":
                break;
            case "NE":
                break;
            case "NH":
                break;
            case "NJ":
                break;
            case "NM":
                break;
            case "NV":
                break;
            case "NY":
                break;
            case "OH":
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                break;
            case "PR":
                break;
            case "RI":
                break;
            case "SC":
                break;
            case "SD":
                break;
            case "TN":
                break;
            case "TX":
                break;
            case "UT":
                break;
            case "VA":
                break;
            case "VT":
                break;
            case "WA":
                break;
            case "WI":
                break;
            case "WV":
                break;
            case "WY":
                break;
            default:
                break;
        } // end switch.
        zone.addState(state);
        this.zones.add(3, zone);
    } // end method setZone3.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone4(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                break;
            case "DC":
                break;
            case "DE":
                break;
            case "FL":
                break;
            case "GA":
                break;
            case "HI":
                break;
            case "IA":
                break;
            case "ID":
                break;
            case "IL":
                break;
            case "IN":
                break;
            case "KS":
                break;
            case "KY":
                break;
            case "LA":
                break;
            case "MA":
                break;
            case "MD":
                break;
            case "ME":
                break;
            case "MI":
                break;
            case "MN":
                break;
            case "MO":
                break;
            case "MS":
                break;
            case "MT":
                break;
            case "NC":
                break;
            case "ND":
                break;
            case "NE":
                break;
            case "NH":
                break;
            case "NJ":
                break;
            case "NM":
                break;
            case "NV":
                break;
            case "NY":
                break;
            case "OH":
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                break;
            case "PR":
                break;
            case "RI":
                break;
            case "SC":
                break;
            case "SD":
                break;
            case "TN":
                break;
            case "TX":
                break;
            case "UT":
                break;
            case "VA":
                break;
            case "VT":
                break;
            case "WA":
                break;
            case "WI":
                break;
            case "WV":
                break;
            case "WY":
                break;
            default:
                break;
        } // end switch.
        zone.addState(state);
        this.zones.add(4, zone);
    } // end method setZone4.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone5(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                break;
            case "DC":
                break;
            case "DE":
                break;
            case "FL":
                break;
            case "GA":
                break;
            case "HI":
                break;
            case "IA":
                break;
            case "ID":
                break;
            case "IL":
                break;
            case "IN":
                break;
            case "KS":
                break;
            case "KY":
                break;
            case "LA":
                break;
            case "MA":
                break;
            case "MD":
                break;
            case "ME":
                break;
            case "MI":
                break;
            case "MN":
                break;
            case "MO":
                break;
            case "MS":
                break;
            case "MT":
                break;
            case "NC":
                break;
            case "ND":
                break;
            case "NE":
                break;
            case "NH":
                break;
            case "NJ":
                break;
            case "NM":
                break;
            case "NV":
                break;
            case "NY":
                break;
            case "OH":
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                break;
            case "PR":
                break;
            case "RI":
                break;
            case "SC":
                break;
            case "SD":
                break;
            case "TN":
                break;
            case "TX":
                break;
            case "UT":
                break;
            case "VA":
                break;
            case "VT":
                break;
            case "WA":
                break;
            case "WI":
                break;
            case "WV":
                break;
            case "WY":
                break;
            default:
                break;
        } // end switch.
        zone.addState(state);
        this.zones.add(5, zone);
    } // end method setZone5.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone6(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                break;
            case "DC":
                break;
            case "DE":
                break;
            case "FL":
                break;
            case "GA":
                break;
            case "HI":
                break;
            case "IA":
                break;
            case "ID":
                break;
            case "IL":
                break;
            case "IN":
                break;
            case "KS":
                break;
            case "KY":
                break;
            case "LA":
                break;
            case "MA":
                break;
            case "MD":
                break;
            case "ME":
                break;
            case "MI":
                break;
            case "MN":
                break;
            case "MO":
                break;
            case "MS":
                break;
            case "MT":
                break;
            case "NC":
                break;
            case "ND":
                break;
            case "NE":
                break;
            case "NH":
                break;
            case "NJ":
                break;
            case "NM":
                break;
            case "NV":
                break;
            case "NY":
                break;
            case "OH":
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                break;
            case "PR":
                break;
            case "RI":
                break;
            case "SC":
                break;
            case "SD":
                break;
            case "TN":
                break;
            case "TX":
                break;
            case "UT":
                break;
            case "VA":
                break;
            case "VT":
                break;
            case "WA":
                break;
            case "WI":
                break;
            case "WV":
                break;
            case "WY":
                break;
            default:
                break;
        } // end switch.
        zone.addState(state);
        this.zones.add(6, zone);
    } // end method setZone6.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone7(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                break;
            case "DC":
                break;
            case "DE":
                break;
            case "FL":
                break;
            case "GA":
                break;
            case "HI":
                break;
            case "IA":
                break;
            case "ID":
                break;
            case "IL":
                break;
            case "IN":
                break;
            case "KS":
                break;
            case "KY":
                break;
            case "LA":
                break;
            case "MA":
                break;
            case "MD":
                break;
            case "ME":
                break;
            case "MI":
                break;
            case "MN":
                break;
            case "MO":
                break;
            case "MS":
                break;
            case "MT":
                break;
            case "NC":
                break;
            case "ND":
                break;
            case "NE":
                break;
            case "NH":
                break;
            case "NJ":
                break;
            case "NM":
                break;
            case "NV":
                break;
            case "NY":
                break;
            case "OH":
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                break;
            case "PR":
                break;
            case "RI":
                break;
            case "SC":
                break;
            case "SD":
                break;
            case "TN":
                break;
            case "TX":
                break;
            case "UT":
                break;
            case "VA":
                break;
            case "VT":
                break;
            case "WA":
                break;
            case "WI":
                break;
            case "WV":
                break;
            case "WY":
                break;
            default:
                break;
        } // end switch.
        zone.addState(state);
        this.zones.add(7, zone);
    } // end method setZone7.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone9(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone8(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                break;
            case "DC":
                break;
            case "DE":
                break;
            case "FL":
                break;
            case "GA":
                break;
            case "HI":
                break;
            case "IA":
                break;
            case "ID":
                break;
            case "IL":
                break;
            case "IN":
                break;
            case "KS":
                break;
            case "KY":
                break;
            case "LA":
                break;
            case "MA":
                break;
            case "MD":
                break;
            case "ME":
                break;
            case "MI":
                break;
            case "MN":
                break;
            case "MO":
                break;
            case "MS":
                break;
            case "MT":
                break;
            case "NC":
                break;
            case "ND":
                break;
            case "NE":
                break;
            case "NH":
                break;
            case "NJ":
                break;
            case "NM":
                break;
            case "NV":
                break;
            case "NY":
                break;
            case "OH":
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                break;
            case "PR":
                break;
            case "RI":
                break;
            case "SC":
                break;
            case "SD":
                break;
            case "TN":
                break;
            case "TX":
                break;
            case "UT":
                break;
            case "VA":
                break;
            case "VT":
                break;
            case "WA":
                break;
            case "WI":
                break;
            case "WV":
                break;
            case "WY":
                break;
            default:
                break;
        } // end switch.
        zone.addState(state);
        this.zones.add(8, zone);
    } // end method setZone8.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone10(String)
     * @since 1.0
     */
    private void setZone9(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                break;
            case "DC":
                break;
            case "DE":
                break;
            case "FL":
                break;
            case "GA":
                break;
            case "HI":
                break;
            case "IA":
                break;
            case "ID":
                break;
            case "IL":
                break;
            case "IN":
                break;
            case "KS":
                break;
            case "KY":
                break;
            case "LA":
                break;
            case "MA":
                break;
            case "MD":
                break;
            case "ME":
                break;
            case "MI":
                break;
            case "MN":
                break;
            case "MO":
                break;
            case "MS":
                break;
            case "MT":
                break;
            case "NC":
                break;
            case "ND":
                break;
            case "NE":
                break;
            case "NH":
                break;
            case "NJ":
                break;
            case "NM":
                break;
            case "NV":
                break;
            case "NY":
                break;
            case "OH":
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                break;
            case "PR":
                break;
            case "RI":
                break;
            case "SC":
                break;
            case "SD":
                break;
            case "TN":
                break;
            case "TX":
                break;
            case "UT":
                break;
            case "VA":
                break;
            case "VT":
                break;
            case "WA":
                break;
            case "WI":
                break;
            case "WV":
                break;
            case "WY":
                break;
            default:
                break;
        } //end switch.
        zone.addState(state);
        this.zones.add(9, zone);
    } // end method setZone9.

    /**
     * TODO Method description.
     *
     * @param state
     * @see Zone
     * @see #setZone0(String)
     * @see #setZone1(String)
     * @see #setZone2(String)
     * @see #setZone3(String)
     * @see #setZone4(String)
     * @see #setZone5(String)
     * @see #setZone6(String)
     * @see #setZone7(String)
     * @see #setZone8(String)
     * @see #setZone9(String)
     * @since 1.0
     */
    private void setZone10(String state) {
        Zone zone = new Zone();
        ArrayList<String> states = new ArrayList<String>();
        switch (state) {
            case "AK":
                break;
            case "AL":
                break;
            case "AR":
                break;
            case "AZ":
                break;
            case "CA":
                break;
            case "CO":
                break;
            case "CT":
                break;
            case "DC":
                break;
            case "DE":
                break;
            case "FL":
                break;
            case "GA":
                break;
            case "HI":
                break;
            case "IA":
                break;
            case "ID":
                break;
            case "IL":
                break;
            case "IN":
                break;
            case "KS":
                break;
            case "KY":
                break;
            case "LA":
                break;
            case "MA":
                break;
            case "MD":
                break;
            case "ME":
                break;
            case "MI":
                break;
            case "MN":
                break;
            case "MO":
                break;
            case "MS":
                break;
            case "MT":
                break;
            case "NC":
                break;
            case "ND":
                break;
            case "NE":
                break;
            case "NH":
                break;
            case "NJ":
                break;
            case "NM":
                break;
            case "NV":
                break;
            case "NY":
                break;
            case "OH":
                break;
            case "OK":
                break;
            case "OR":
                break;
            case "PA":
                break;
            case "PR":
                break;
            case "RI":
                break;
            case "SC":
                break;
            case "SD":
                break;
            case "TN":
                break;
            case "TX":
                break;
            case "UT":
                break;
            case "VA":
                break;
            case "VT":
                break;
            case "WA":
                break;
            case "WI":
                break;
            case "WV":
                break;
            case "WY":
                break;
            default:
                break;
        } // end switch.
        zone.addState(state);
        this.zones.add(10, zone);
    } // end method setZone10.
} // end class ZoneList.
