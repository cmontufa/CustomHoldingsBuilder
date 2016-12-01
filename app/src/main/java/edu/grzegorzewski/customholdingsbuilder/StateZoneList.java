package edu.grzegorzewski.customholdingsbuilder;
/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains a list of key/value pairs of destination states and postal zones
 * for the state supplied in the parameter with the default being Illinois.
 *
 * @author Dennis Grzegorzewski.
 * @version 1.0, 11/27/2016
 */
public class StateZoneList {

    /*
     * Declare and initialize instance variables and objects.
     */
    private List<Pair> stateZones = new ArrayList<>();

    public List<Pair> getStateZones() {
        return stateZones;
    }

    public void setStateZones(List<Pair> stateZones) {
        this.stateZones = stateZones;
    }

    /*
     * Constructors.
     */
    /**
     * No-Arg constructor.
     *
     * @see #stateZones A List of Pair objects containing key/value pairs of state or territory abbreviation strings and zone integers for Illinois.
     * @since 1.0
     */
    public StateZoneList() {

        this.stateZones = createILZoneTable();

    } // end No-Arg constructor.

    /**
     * Full-arg constructor.
     *
     * @param state String of a state or territory abbreviation.
     * @see #stateZones A List of Pair objects containing key/value pairs of state or territory abbreviation strings and zone integers for parameter state.
     */
    public StateZoneList(String state) {

        // Create key/value state/zone Pair list based on state parameter.
        switch(state) {
            case "AK":
                this.stateZones = createAKZoneTable();
                break;
            case "AL":
                this.stateZones = createALZoneTable();
                break;
            case "AR":
                this.stateZones = createARZoneTable();
                break;
            case "AZ":
                this.stateZones = createAZZoneTable();
                break;
            case "CA":
                this.stateZones = createCAZoneTable();
                break;
            case "CO":
                this.stateZones = createCOZoneTable();
                break;
            case "CT":
                this.stateZones = createCTZoneTable();
                break;
            case "DC":
                this.stateZones = createDCZoneTable();
                break;
            case "DE":
                this.stateZones = createDEZoneTable();
                break;
            case "FL":
                this.stateZones = createFLZoneTable();
                break;
            case "GA":
                this.stateZones = createGAZoneTable();
                break;
            case "HI":
                this.stateZones = createHIZoneTable();
                break;
            case "IA":
                this.stateZones = createIAZoneTable();
                break;
            case "ID":
                this.stateZones = createIDZoneTable();
                break;
            case "IL":
                this.stateZones = createILZoneTable();
                break;
            case "IN":
                this.stateZones = createINZoneTable();
                break;
            case "KS":
                this.stateZones = createKSZoneTable();
                break;
            case "KY":
                this.stateZones = createKYZoneTable();
                break;
            case "LA":
                this.stateZones = createLAZoneTable();
                break;
            case "MA":
                this.stateZones = createMAZoneTable();
                break;
            case "MD":
                this.stateZones = createMDZoneTable();
                break;
            case "ME":
                this.stateZones = createMEZoneTable();
                break;
            case "MI":
                this.stateZones = createMIZoneTable();
                break;
            case "MN":
                this.stateZones = createMNZoneTable();
                break;
            case "MO":
                this.stateZones = createMOZoneTable();
                break;
            case "MS":
                this.stateZones = createMSZoneTable();
                break;
            case "MT":
                this.stateZones = createMTZoneTable();
                break;
            case "NC":
                this.stateZones = createNCZoneTable();
                break;
            case "ND":
                this.stateZones = createNDZoneTable();
                break;
            case "NE":
                this.stateZones = createNEZoneTable();
                break;
            case "NH":
                this.stateZones = createNHZoneTable();
                break;
            case "NJ":
                this.stateZones = createNJZoneTable();
                break;
            case "NM":
                this.stateZones = createNMZoneTable();
                break;
            case "NV":
                this.stateZones = createNVZoneTable();
                break;
            case "NY":
                this.stateZones = createNYZoneTable();
                break;
            case "OH":
                this.stateZones = createOHZoneTable();
                break;
            case "OK":
                this.stateZones = createOKZoneTable();
                break;
            case "OR":
                this.stateZones = createORZoneTable();
                break;
            case "PA":
                this.stateZones = createPAZoneTable();
                break;
            case "PR":
                this.stateZones = createPRZoneTable();
                break;
            case "RI":
                this.stateZones = createRIZoneTable();
                break;
            case "SC":
                this.stateZones = createSCZoneTable();
                break;
            case "SD":
                this.stateZones = createSDZoneTable();
                break;
            case "TN":
                this.stateZones = createTNZoneTable();
                break;
            case "TX":
                this.stateZones = createTXZoneTable();
                break;
            case "UT":
                this.stateZones = createUTZoneTable();
                break;
            case "VA":
                this.stateZones = createVAZoneTable();
                break;
            case "VT":
                this.stateZones = createVTZoneTable();
                break;
            case "WA":
                this.stateZones = createWAZoneTable();
                break;
            case "WI":
                this.stateZones = createWIZoneTable();
                break;
            case "WV":
                this.stateZones = createWVZoneTable();
                break;
            case "WY":
                this.stateZones = createWYZoneTable();
                break;
            default :
                this.stateZones = createILZoneTable();
                break;
        } // end switch

    } // end Full-arg constructor.

    /*
     * Methods.
     */
    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for AK.
     *
     * @return A List of Pair objects containing key/value pairs of state or territory abbreviation strings and zone integers for AK.
     * @since 1.0
     */
    private List<Pair> createAKZoneTable() {

        List<Pair> AK = new ArrayList<>();

        AK.add(Pair.create("AK", 0));
        AK.add(Pair.create("AL", 7));
        AK.add(Pair.create("AR", 7));
        AK.add(Pair.create("AZ", 5));
        AK.add(Pair.create("CA", 4));
        AK.add(Pair.create("CO", 7));
        AK.add(Pair.create("CT", 8));
        AK.add(Pair.create("DC", 8));
        AK.add(Pair.create("DE", 8));
        AK.add(Pair.create("FL", 8));
        AK.add(Pair.create("GA", 8));
        AK.add(Pair.create("HI", 6));
        AK.add(Pair.create("IA", 7));
        AK.add(Pair.create("ID", 4));
        AK.add(Pair.create("IL", 7));
        AK.add(Pair.create("IN", 7));
        AK.add(Pair.create("KS", 7));
        AK.add(Pair.create("KY", 7));
        AK.add(Pair.create("LA", 7));
        AK.add(Pair.create("MA", 8));
        AK.add(Pair.create("MD", 8));
        AK.add(Pair.create("ME", 8));
        AK.add(Pair.create("MI", 7));
        AK.add(Pair.create("MN", 7));
        AK.add(Pair.create("MO", 7));
        AK.add(Pair.create("MS", 7));
        AK.add(Pair.create("MT", 4));
        AK.add(Pair.create("NC", 8));
        AK.add(Pair.create("ND", 7));
        AK.add(Pair.create("NE", 7));
        AK.add(Pair.create("NH", 8));
        AK.add(Pair.create("NJ", 8));
        AK.add(Pair.create("NM", 6));
        AK.add(Pair.create("NV", 4));
        AK.add(Pair.create("NY", 8));
        AK.add(Pair.create("OH", 7));
        AK.add(Pair.create("OK", 7));
        AK.add(Pair.create("OR", 3));
        AK.add(Pair.create("PA", 8));
        AK.add(Pair.create("PR", 10));
        AK.add(Pair.create("RI", 8));
        AK.add(Pair.create("SC", 8));
        AK.add(Pair.create("SD", 8));
        AK.add(Pair.create("TN", 7));
        AK.add(Pair.create("TX", 6));
        AK.add(Pair.create("UT", 4));
        AK.add(Pair.create("VA", 8));
        AK.add(Pair.create("VT", 8));
        AK.add(Pair.create("WA", 3));
        AK.add(Pair.create("WI", 7));
        AK.add(Pair.create("WV", 8));
        AK.add(Pair.create("WY", 6));

        return AK;

    } // end method createAKZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for AL.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for AL.
     * @since 1.0
     */
    private List<Pair> createALZoneTable() {

        List<Pair> AL = new ArrayList<>();

        AL.add(Pair.create("AK", 3));
        AL.add(Pair.create("AL", 0));
        AL.add(Pair.create("AR", 2));
        AL.add(Pair.create("AZ", 5));
        AL.add(Pair.create("CA", 5));
        AL.add(Pair.create("CO", 4));
        AL.add(Pair.create("CT", 3));
        AL.add(Pair.create("DC", 2));
        AL.add(Pair.create("DE", 2));
        AL.add(Pair.create("FL", 2));
        AL.add(Pair.create("GA", 1));
        AL.add(Pair.create("HI", 6));
        AL.add(Pair.create("IA", 2));
        AL.add(Pair.create("ID", 5));
        AL.add(Pair.create("IL", 2));
        AL.add(Pair.create("IN", 2));
        AL.add(Pair.create("KS", 2));
        AL.add(Pair.create("KY", 1));
        AL.add(Pair.create("LA", 1));
        AL.add(Pair.create("MA", 3));
        AL.add(Pair.create("MD", 2));
        AL.add(Pair.create("ME", 3));
        AL.add(Pair.create("MI", 2));
        AL.add(Pair.create("MN", 3));
        AL.add(Pair.create("MO", 2));
        AL.add(Pair.create("MS", 1));
        AL.add(Pair.create("MT", 5));
        AL.add(Pair.create("NC", 2));
        AL.add(Pair.create("ND", 3));
        AL.add(Pair.create("NE", 3));
        AL.add(Pair.create("NH", 3));
        AL.add(Pair.create("NJ", 2));
        AL.add(Pair.create("NM", 3));
        AL.add(Pair.create("NV", 5));
        AL.add(Pair.create("NY", 3));
        AL.add(Pair.create("OH", 2));
        AL.add(Pair.create("OK", 2));
        AL.add(Pair.create("OR", 5));
        AL.add(Pair.create("PA", 2));
        AL.add(Pair.create("PR", 4));
        AL.add(Pair.create("RI", 3));
        AL.add(Pair.create("SC", 2));
        AL.add(Pair.create("SD", 3));
        AL.add(Pair.create("TN", 1));
        AL.add(Pair.create("TX", 3));
        AL.add(Pair.create("UT", 5));
        AL.add(Pair.create("VA", 2));
        AL.add(Pair.create("VT", 3));
        AL.add(Pair.create("WA", 5));
        AL.add(Pair.create("WI", 2));
        AL.add(Pair.create("WV", 2));
        AL.add(Pair.create("WY", 4));

        return AL;

    } // end method createALZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for AR.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for AR.
     * @since 1.0
     */
    private List<Pair> createARZoneTable() {

        List<Pair> AR = new ArrayList<>();

        AR.add(Pair.create("AK", 3));
        AR.add(Pair.create("AL", 2));
        AR.add(Pair.create("AR", 0));
        AR.add(Pair.create("AZ", 3));
        AR.add(Pair.create("CA", 5));
        AR.add(Pair.create("CO", 3));
        AR.add(Pair.create("CT", 4));
        AR.add(Pair.create("DC", 3));
        AR.add(Pair.create("DE", 3));
        AR.add(Pair.create("FL", 3));
        AR.add(Pair.create("GA", 2));
        AR.add(Pair.create("HI", 6));
        AR.add(Pair.create("IA", 2));
        AR.add(Pair.create("ID", 4));
        AR.add(Pair.create("IL", 2));
        AR.add(Pair.create("IN", 2));
        AR.add(Pair.create("KS", 2));
        AR.add(Pair.create("KY", 2));
        AR.add(Pair.create("LA", 2));
        AR.add(Pair.create("MA", 4));
        AR.add(Pair.create("MD", 3));
        AR.add(Pair.create("ME", 5));
        AR.add(Pair.create("MI", 3));
        AR.add(Pair.create("MN", 3));
        AR.add(Pair.create("MO", 2));
        AR.add(Pair.create("MS", 2));
        AR.add(Pair.create("MT", 4));
        AR.add(Pair.create("NC", 3));
        AR.add(Pair.create("ND", 3));
        AR.add(Pair.create("NE", 2));
        AR.add(Pair.create("NH", 4));
        AR.add(Pair.create("NJ", 4));
        AR.add(Pair.create("NM", 3));
        AR.add(Pair.create("NV", 4));
        AR.add(Pair.create("NY", 4));
        AR.add(Pair.create("OH", 3));
        AR.add(Pair.create("OK", 2));
        AR.add(Pair.create("OR", 5));
        AR.add(Pair.create("PA", 3));
        AR.add(Pair.create("PR", 5));
        AR.add(Pair.create("RI", 4));
        AR.add(Pair.create("SC", 3));
        AR.add(Pair.create("SD", 3));
        AR.add(Pair.create("TN", 2));
        AR.add(Pair.create("TX", 2));
        AR.add(Pair.create("UT", 4));
        AR.add(Pair.create("VA", 3));
        AR.add(Pair.create("VT", 4));
        AR.add(Pair.create("WA", 5));
        AR.add(Pair.create("WI", 3));
        AR.add(Pair.create("WV", 3));
        AR.add(Pair.create("WY", 4));

        return AR;

    } // end method createARZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for AZ.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for AZ.
     * @since 1.0
     */
    private List<Pair> createAZZoneTable() {

        List<Pair> AZ = new ArrayList<>();

        AZ.add(Pair.create("AK", 4));
        AZ.add(Pair.create("AL", 4));
        AZ.add(Pair.create("AR", 3));
        AZ.add(Pair.create("AZ", 0));
        AZ.add(Pair.create("CA", 2));
        AZ.add(Pair.create("CO", 3));
        AZ.add(Pair.create("CT", 5));
        AZ.add(Pair.create("DC", 5));
        AZ.add(Pair.create("DE", 5));
        AZ.add(Pair.create("FL", 4));
        AZ.add(Pair.create("GA", 4));
        AZ.add(Pair.create("HI", 3));
        AZ.add(Pair.create("IA", 4));
        AZ.add(Pair.create("ID", 3));
        AZ.add(Pair.create("IL", 4));
        AZ.add(Pair.create("IN", 4));
        AZ.add(Pair.create("KS", 4));
        AZ.add(Pair.create("KY", 4));
        AZ.add(Pair.create("LA", 3));
        AZ.add(Pair.create("MA", 5));
        AZ.add(Pair.create("MD", 5));
        AZ.add(Pair.create("ME", 5));
        AZ.add(Pair.create("MI", 4));
        AZ.add(Pair.create("MN", 4));
        AZ.add(Pair.create("MO", 4));
        AZ.add(Pair.create("MS", 3));
        AZ.add(Pair.create("MT", 3));
        AZ.add(Pair.create("NC", 4));
        AZ.add(Pair.create("ND", 4));
        AZ.add(Pair.create("NE", 4));
        AZ.add(Pair.create("NH", 5));
        AZ.add(Pair.create("NJ", 5));
        AZ.add(Pair.create("NM", 2));
        AZ.add(Pair.create("NV", 2));
        AZ.add(Pair.create("NY", 5));
        AZ.add(Pair.create("OH", 4));
        AZ.add(Pair.create("OK", 3));
        AZ.add(Pair.create("OR", 3));
        AZ.add(Pair.create("PA", 5));
        AZ.add(Pair.create("PR", 6));
        AZ.add(Pair.create("RI", 5));
        AZ.add(Pair.create("SC", 4));
        AZ.add(Pair.create("SD", 4));
        AZ.add(Pair.create("TN", 4));
        AZ.add(Pair.create("TX", 3));
        AZ.add(Pair.create("UT", 2));
        AZ.add(Pair.create("VA", 5));
        AZ.add(Pair.create("VT", 5));
        AZ.add(Pair.create("WA", 3));
        AZ.add(Pair.create("WI", 4));
        AZ.add(Pair.create("WV", 5));
        AZ.add(Pair.create("WY", 3));

        return AZ;

    } // end method createAZZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for CA.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for CA.
     * @since 1.0
     */
    private List<Pair> createCAZoneTable() {

        List<Pair> CA = new ArrayList<>();

        CA.add(Pair.create("AK", 3));
        CA.add(Pair.create("AL", 5));
        CA.add(Pair.create("AR", 4));
        CA.add(Pair.create("AZ", 2));
        CA.add(Pair.create("CA", 0));
        CA.add(Pair.create("CO", 3));
        CA.add(Pair.create("CT", 5));
        CA.add(Pair.create("DC", 5));
        CA.add(Pair.create("DE", 5));
        CA.add(Pair.create("FL", 5));
        CA.add(Pair.create("GA", 5));
        CA.add(Pair.create("HI", 2));
        CA.add(Pair.create("IA", 4));
        CA.add(Pair.create("ID", 2));
        CA.add(Pair.create("IL", 4));
        CA.add(Pair.create("IN", 5));
        CA.add(Pair.create("KS", 4));
        CA.add(Pair.create("KY", 5));
        CA.add(Pair.create("LA", 5));
        CA.add(Pair.create("MA", 5));
        CA.add(Pair.create("MD", 5));
        CA.add(Pair.create("ME", 5));
        CA.add(Pair.create("MI", 5));
        CA.add(Pair.create("MN", 5));
        CA.add(Pair.create("MO", 4));
        CA.add(Pair.create("MS", 5));
        CA.add(Pair.create("MT", 3));
        CA.add(Pair.create("NC", 5));
        CA.add(Pair.create("ND", 4));
        CA.add(Pair.create("NE", 4));
        CA.add(Pair.create("NH", 5));
        CA.add(Pair.create("NJ", 5));
        CA.add(Pair.create("NM", 3));
        CA.add(Pair.create("NV", 2));
        CA.add(Pair.create("NY", 5));
        CA.add(Pair.create("OH", 5));
        CA.add(Pair.create("OK", 4));
        CA.add(Pair.create("OR", 2));
        CA.add(Pair.create("PA", 5));
        CA.add(Pair.create("PR", 7));
        CA.add(Pair.create("RI", 5));
        CA.add(Pair.create("SC", 5));
        CA.add(Pair.create("SD", 4));
        CA.add(Pair.create("TN", 5));
        CA.add(Pair.create("TX", 4));
        CA.add(Pair.create("UT", 2));
        CA.add(Pair.create("VA", 5));
        CA.add(Pair.create("VT", 5));
        CA.add(Pair.create("WA", 2));
        CA.add(Pair.create("WI", 4));
        CA.add(Pair.create("WV", 5));
        CA.add(Pair.create("WY", 3));

        return CA;

    } // end method createCAZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for CO.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for CO.
     * @since 1.0
     */
    private List<Pair> createCOZoneTable() {

        List<Pair> CO = new ArrayList<>();

        CO.add(Pair.create("AK", 5));
        CO.add(Pair.create("AL", 3));
        CO.add(Pair.create("AR", 3));
        CO.add(Pair.create("AZ", 2));
        CO.add(Pair.create("CA", 3));
        CO.add(Pair.create("CO", 0));
        CO.add(Pair.create("CT", 5));
        CO.add(Pair.create("DC", 4));
        CO.add(Pair.create("DE", 4));
        CO.add(Pair.create("FL", 4));
        CO.add(Pair.create("GA", 4));
        CO.add(Pair.create("HI", 4));
        CO.add(Pair.create("IA", 2));
        CO.add(Pair.create("ID", 2));
        CO.add(Pair.create("IL", 3));
        CO.add(Pair.create("IN", 3));
        CO.add(Pair.create("KS", 2));
        CO.add(Pair.create("KY", 3));
        CO.add(Pair.create("LA", 3));
        CO.add(Pair.create("MA", 5));
        CO.add(Pair.create("MD", 4));
        CO.add(Pair.create("ME", 5));
        CO.add(Pair.create("MI", 4));
        CO.add(Pair.create("MN", 3));
        CO.add(Pair.create("MO", 2));
        CO.add(Pair.create("MS", 3));
        CO.add(Pair.create("MT", 2));
        CO.add(Pair.create("NC", 4));
        CO.add(Pair.create("ND", 3));
        CO.add(Pair.create("NE", 2));
        CO.add(Pair.create("NH", 5));
        CO.add(Pair.create("NJ", 4));
        CO.add(Pair.create("NM", 2));
        CO.add(Pair.create("NV", 2));
        CO.add(Pair.create("NY", 4));
        CO.add(Pair.create("OH", 4));
        CO.add(Pair.create("OK", 2));
        CO.add(Pair.create("OR", 3));
        CO.add(Pair.create("PA", 4));
        CO.add(Pair.create("PR", 5));
        CO.add(Pair.create("RI", 5));
        CO.add(Pair.create("SC", 4));
        CO.add(Pair.create("SD", 2));
        CO.add(Pair.create("TN", 3));
        CO.add(Pair.create("TX", 2));
        CO.add(Pair.create("UT", 2));
        CO.add(Pair.create("VA", 4));
        CO.add(Pair.create("VT", 5));
        CO.add(Pair.create("WA", 3));
        CO.add(Pair.create("WI", 3));
        CO.add(Pair.create("WV", 4));
        CO.add(Pair.create("WY", 2));

        return CO;

    } // end method createCOZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for CT.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for CT.
     * @since 1.0
     */
    private List<Pair> createCTZoneTable() {

        List<Pair> CT = new ArrayList<>();

        CT.add(Pair.create("AK", 4));
        CT.add(Pair.create("AL", 3));
        CT.add(Pair.create("AR", 3));
        CT.add(Pair.create("AZ", 5));
        CT.add(Pair.create("CA", 5));
        CT.add(Pair.create("CO", 4));
        CT.add(Pair.create("CT", 0));
        CT.add(Pair.create("DC", 2));
        CT.add(Pair.create("DE", 1));
        CT.add(Pair.create("FL", 3));
        CT.add(Pair.create("GA", 3));
        CT.add(Pair.create("HI", 5));
        CT.add(Pair.create("IA", 3));
        CT.add(Pair.create("ID", 5));
        CT.add(Pair.create("IL", 2));
        CT.add(Pair.create("IN", 2));
        CT.add(Pair.create("KS", 3));
        CT.add(Pair.create("KY", 2));
        CT.add(Pair.create("LA", 4));
        CT.add(Pair.create("MA", 1));
        CT.add(Pair.create("MD", 1));
        CT.add(Pair.create("ME", 1));
        CT.add(Pair.create("MI", 2));
        CT.add(Pair.create("MN", 3));
        CT.add(Pair.create("MO", 3));
        CT.add(Pair.create("MS", 4));
        CT.add(Pair.create("MT", 5));
        CT.add(Pair.create("NC", 2));
        CT.add(Pair.create("ND", 4));
        CT.add(Pair.create("NE", 3));
        CT.add(Pair.create("NH", 1));
        CT.add(Pair.create("NJ", 1));
        CT.add(Pair.create("NM", 4));
        CT.add(Pair.create("NV", 5));
        CT.add(Pair.create("NY", 1));
        CT.add(Pair.create("OH", 2));
        CT.add(Pair.create("OK", 4));
        CT.add(Pair.create("OR", 5));
        CT.add(Pair.create("PA", 2));
        CT.add(Pair.create("PR", 5));
        CT.add(Pair.create("RI", 1));
        CT.add(Pair.create("SC", 2));
        CT.add(Pair.create("SD", 4));
        CT.add(Pair.create("TN", 3));
        CT.add(Pair.create("TX", 5));
        CT.add(Pair.create("UT", 5));
        CT.add(Pair.create("VA", 2));
        CT.add(Pair.create("VT", 1));
        CT.add(Pair.create("WA", 5));
        CT.add(Pair.create("WI", 3));
        CT.add(Pair.create("WV", 2));
        CT.add(Pair.create("WY", 5));

        return CT;

    } // end method createCTZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for DC.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for DC.
     * @since 1.0
     */
    private List<Pair> createDCZoneTable() {

        List<Pair> DC = new ArrayList<>();

        DC.add(Pair.create("AK", 4));
        DC.add(Pair.create("AL", 3));
        DC.add(Pair.create("AR", 3));
        DC.add(Pair.create("AZ", 4));
        DC.add(Pair.create("CA", 4));
        DC.add(Pair.create("CO", 4));
        DC.add(Pair.create("CT", 2));
        DC.add(Pair.create("DC", 0));
        DC.add(Pair.create("DE", 1));
        DC.add(Pair.create("FL", 3));
        DC.add(Pair.create("GA", 2));
        DC.add(Pair.create("HI", 5));
        DC.add(Pair.create("IA", 3));
        DC.add(Pair.create("ID", 5));
        DC.add(Pair.create("IL", 3));
        DC.add(Pair.create("IN", 2));
        DC.add(Pair.create("KS", 3));
        DC.add(Pair.create("KY", 2));
        DC.add(Pair.create("LA", 3));
        DC.add(Pair.create("MA", 2));
        DC.add(Pair.create("MD", 1));
        DC.add(Pair.create("ME", 2));
        DC.add(Pair.create("MI", 2));
        DC.add(Pair.create("MN", 3));
        DC.add(Pair.create("MO", 3));
        DC.add(Pair.create("MS", 3));
        DC.add(Pair.create("MT", 5));
        DC.add(Pair.create("NC", 2));
        DC.add(Pair.create("ND", 5));
        DC.add(Pair.create("NE", 4));
        DC.add(Pair.create("NH", 2));
        DC.add(Pair.create("NJ", 1));
        DC.add(Pair.create("NM", 5));
        DC.add(Pair.create("NV", 5));
        DC.add(Pair.create("NY", 2));
        DC.add(Pair.create("OH", 2));
        DC.add(Pair.create("OK", 4));
        DC.add(Pair.create("OR", 5));
        DC.add(Pair.create("PA", 1));
        DC.add(Pair.create("PR", 5));
        DC.add(Pair.create("RI", 2));
        DC.add(Pair.create("SC", 2));
        DC.add(Pair.create("SD", 4));
        DC.add(Pair.create("TN", 2));
        DC.add(Pair.create("TX", 4));
        DC.add(Pair.create("UT", 5));
        DC.add(Pair.create("VA", 1));
        DC.add(Pair.create("VT", 2));
        DC.add(Pair.create("WA", 5));
        DC.add(Pair.create("WI", 3));
        DC.add(Pair.create("WV", 2));
        DC.add(Pair.create("WY", 4));

        return DC;

    } // end method createDCZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for DE.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for DE.
     * @since 1.0
     */
    private List<Pair> createDEZoneTable() {

        List<Pair> DE = new ArrayList<>();

        DE.add(Pair.create("AK", 4));
        DE.add(Pair.create("AL", 3));
        DE.add(Pair.create("AR", 3));
        DE.add(Pair.create("AZ", 4));
        DE.add(Pair.create("CA", 4));
        DE.add(Pair.create("CO", 4));
        DE.add(Pair.create("CT", 1));
        DE.add(Pair.create("DC", 2));
        DE.add(Pair.create("DE", 0));
        DE.add(Pair.create("FL", 3));
        DE.add(Pair.create("GA", 2));
        DE.add(Pair.create("HI", 5));
        DE.add(Pair.create("IA", 3));
        DE.add(Pair.create("ID", 5));
        DE.add(Pair.create("IL", 3));
        DE.add(Pair.create("IN", 2));
        DE.add(Pair.create("KS", 3));
        DE.add(Pair.create("KY", 2));
        DE.add(Pair.create("LA", 3));
        DE.add(Pair.create("MA", 2));
        DE.add(Pair.create("MD", 1));
        DE.add(Pair.create("ME", 2));
        DE.add(Pair.create("MI", 2));
        DE.add(Pair.create("MN", 3));
        DE.add(Pair.create("MO", 3));
        DE.add(Pair.create("MS", 3));
        DE.add(Pair.create("MT", 5));
        DE.add(Pair.create("NC", 2));
        DE.add(Pair.create("ND", 4));
        DE.add(Pair.create("NE", 4));
        DE.add(Pair.create("NH", 2));
        DE.add(Pair.create("NJ", 1));
        DE.add(Pair.create("NM", 5));
        DE.add(Pair.create("NV", 5));
        DE.add(Pair.create("NY", 2));
        DE.add(Pair.create("OH", 2));
        DE.add(Pair.create("OK", 4));
        DE.add(Pair.create("OR", 5));
        DE.add(Pair.create("PA", 1));
        DE.add(Pair.create("PR", 5));
        DE.add(Pair.create("RI", 2));
        DE.add(Pair.create("SC", 2));
        DE.add(Pair.create("SD", 4));
        DE.add(Pair.create("TN", 2));
        DE.add(Pair.create("TX", 4));
        DE.add(Pair.create("UT", 5));
        DE.add(Pair.create("VA", 2));
        DE.add(Pair.create("VT", 2));
        DE.add(Pair.create("WA", 5));
        DE.add(Pair.create("WI", 3));
        DE.add(Pair.create("WV", 2));
        DE.add(Pair.create("WY", 4));

        return DE;

    } // end method createDEZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for FL.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for FL.
     * @since 1.0
     */
    private List<Pair> createFLZoneTable() {

        List<Pair> FL = new ArrayList<>();

        FL.add(Pair.create("AK", 4));
        FL.add(Pair.create("AL", 2));
        FL.add(Pair.create("AR", 3));
        FL.add(Pair.create("AZ", 5));
        FL.add(Pair.create("CA", 5));
        FL.add(Pair.create("CO", 5));
        FL.add(Pair.create("CT", 3));
        FL.add(Pair.create("DC", 2));
        FL.add(Pair.create("DE", 3));
        FL.add(Pair.create("FL", 0));
        FL.add(Pair.create("GA", 2));
        FL.add(Pair.create("HI", 6));
        FL.add(Pair.create("IA", 4));
        FL.add(Pair.create("ID", 6));
        FL.add(Pair.create("IL", 4));
        FL.add(Pair.create("IN", 4));
        FL.add(Pair.create("KS", 3));
        FL.add(Pair.create("KY", 2));
        FL.add(Pair.create("LA", 2));
        FL.add(Pair.create("MA", 4));
        FL.add(Pair.create("MD", 3));
        FL.add(Pair.create("ME", 4));
        FL.add(Pair.create("MI", 4));
        FL.add(Pair.create("MN", 4));
        FL.add(Pair.create("MO", 3));
        FL.add(Pair.create("MS", 2));
        FL.add(Pair.create("MT", 6));
        FL.add(Pair.create("NC", 2));
        FL.add(Pair.create("ND", 5));
        FL.add(Pair.create("NE", 4));
        FL.add(Pair.create("NH", 4));
        FL.add(Pair.create("NJ", 3));
        FL.add(Pair.create("NM", 5));
        FL.add(Pair.create("NV", 6));
        FL.add(Pair.create("NY", 4));
        FL.add(Pair.create("OH", 4));
        FL.add(Pair.create("OK", 3));
        FL.add(Pair.create("OR", 5));
        FL.add(Pair.create("PA", 3));
        FL.add(Pair.create("PR", 3));
        FL.add(Pair.create("RI", 4));
        FL.add(Pair.create("SC", 2));
        FL.add(Pair.create("SD", 5));
        FL.add(Pair.create("TN", 2));
        FL.add(Pair.create("TX", 4));
        FL.add(Pair.create("UT", 6));
        FL.add(Pair.create("VA", 2));
        FL.add(Pair.create("VT", 4));
        FL.add(Pair.create("WA", 6));
        FL.add(Pair.create("WI", 4));
        FL.add(Pair.create("WV", 2));
        FL.add(Pair.create("WY", 6));

        return FL;

    } // end method createFLZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for GA.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for GA.
     * @since 1.0
     */
    private List<Pair> createGAZoneTable() {

        List<Pair> GA = new ArrayList<>();

        GA.add(Pair.create("AK", 3));
        GA.add(Pair.create("AL", 1));
        GA.add(Pair.create("AR", 2));
        GA.add(Pair.create("AZ", 4));
        GA.add(Pair.create("CA", 4));
        GA.add(Pair.create("CO", 3));
        GA.add(Pair.create("CT", 3));
        GA.add(Pair.create("DC", 2));
        GA.add(Pair.create("DE", 2));
        GA.add(Pair.create("FL", 2));
        GA.add(Pair.create("GA", 0));
        GA.add(Pair.create("HI", 5));
        GA.add(Pair.create("IA", 3));
        GA.add(Pair.create("ID", 5));
        GA.add(Pair.create("IL", 2));
        GA.add(Pair.create("IN", 2));
        GA.add(Pair.create("KS", 3));
        GA.add(Pair.create("KY", 2));
        GA.add(Pair.create("LA", 2));
        GA.add(Pair.create("MA", 3));
        GA.add(Pair.create("MD", 2));
        GA.add(Pair.create("ME", 3));
        GA.add(Pair.create("MI", 2));
        GA.add(Pair.create("MN", 3));
        GA.add(Pair.create("MO", 2));
        GA.add(Pair.create("MS", 2));
        GA.add(Pair.create("MT", 5));
        GA.add(Pair.create("NC", 2));
        GA.add(Pair.create("ND", 4));
        GA.add(Pair.create("NE", 3));
        GA.add(Pair.create("NH", 3));
        GA.add(Pair.create("NJ", 2));
        GA.add(Pair.create("NM", 4));
        GA.add(Pair.create("NV", 5));
        GA.add(Pair.create("NY", 3));
        GA.add(Pair.create("OH", 2));
        GA.add(Pair.create("OK", 3));
        GA.add(Pair.create("OR", 5));
        GA.add(Pair.create("PA", 2));
        GA.add(Pair.create("PR", 4));
        GA.add(Pair.create("RI", 3));
        GA.add(Pair.create("SC", 2));
        GA.add(Pair.create("SD", 4));
        GA.add(Pair.create("TN", 2));
        GA.add(Pair.create("TX", 2));
        GA.add(Pair.create("UT", 5));
        GA.add(Pair.create("VA", 2));
        GA.add(Pair.create("VT", 3));
        GA.add(Pair.create("WA", 5));
        GA.add(Pair.create("WI", 2));
        GA.add(Pair.create("WV", 2));
        GA.add(Pair.create("WY", 4));

        return GA;

    } // end method createGAZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for HI.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for HI.
     * @since 1.0
     */
    private List<Pair> createHIZoneTable() {

        List<Pair> HI = new ArrayList<>();

        HI.add(Pair.create("AK", 4));
        HI.add(Pair.create("AL", 5));
        HI.add(Pair.create("AR", 5));
        HI.add(Pair.create("AZ", 3));
        HI.add(Pair.create("CA", 2));
        HI.add(Pair.create("CO", 4));
        HI.add(Pair.create("CT", 6));
        HI.add(Pair.create("DC", 6));
        HI.add(Pair.create("DE", 6));
        HI.add(Pair.create("FL", 6));
        HI.add(Pair.create("GA", 6));
        HI.add(Pair.create("HI", 0));
        HI.add(Pair.create("IA", 5));
        HI.add(Pair.create("ID", 4));
        HI.add(Pair.create("IL", 5));
        HI.add(Pair.create("IN", 5));
        HI.add(Pair.create("KS", 5));
        HI.add(Pair.create("KY", 5));
        HI.add(Pair.create("LA", 5));
        HI.add(Pair.create("MA", 6));
        HI.add(Pair.create("MD", 6));
        HI.add(Pair.create("ME", 6));
        HI.add(Pair.create("MI", 5));
        HI.add(Pair.create("MN", 5));
        HI.add(Pair.create("MO", 5));
        HI.add(Pair.create("MS", 5));
        HI.add(Pair.create("MT", 4));
        HI.add(Pair.create("NC", 6));
        HI.add(Pair.create("ND", 5));
        HI.add(Pair.create("NE", 5));
        HI.add(Pair.create("NH", 6));
        HI.add(Pair.create("NJ", 6));
        HI.add(Pair.create("NM", 4));
        HI.add(Pair.create("NV", 3));
        HI.add(Pair.create("NY", 6));
        HI.add(Pair.create("OH", 5));
        HI.add(Pair.create("OK", 5));
        HI.add(Pair.create("OR", 5));
        HI.add(Pair.create("PA", 6));
        HI.add(Pair.create("PR", 8));
        HI.add(Pair.create("RI", 6));
        HI.add(Pair.create("SC", 6));
        HI.add(Pair.create("SD", 5));
        HI.add(Pair.create("TN", 5));
        HI.add(Pair.create("TX", 5));
        HI.add(Pair.create("UT", 3));
        HI.add(Pair.create("VA", 6));
        HI.add(Pair.create("VT", 6));
        HI.add(Pair.create("WA", 5));
        HI.add(Pair.create("WI", 5));
        HI.add(Pair.create("WV", 6));
        HI.add(Pair.create("WY", 4));

        return HI;

    } // end method createHIZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for IA.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for IA.
     * @since 1.0
     */
    private List<Pair> createIAZoneTable() {

        List<Pair> IA = new ArrayList<>();

        IA.add(Pair.create("AK", 6));
        IA.add(Pair.create("AL", 3));
        IA.add(Pair.create("AR", 2));
        IA.add(Pair.create("AZ", 4));
        IA.add(Pair.create("CA", 4));
        IA.add(Pair.create("CO", 2));
        IA.add(Pair.create("CT", 4));
        IA.add(Pair.create("DC", 3));
        IA.add(Pair.create("DE", 3));
        IA.add(Pair.create("FL", 3));
        IA.add(Pair.create("GA", 3));
        IA.add(Pair.create("HI", 5));
        IA.add(Pair.create("IA", 0));
        IA.add(Pair.create("ID", 3));
        IA.add(Pair.create("IL", 2));
        IA.add(Pair.create("IN", 2));
        IA.add(Pair.create("KS", 1));
        IA.add(Pair.create("KY", 2));
        IA.add(Pair.create("LA", 3));
        IA.add(Pair.create("MA", 4));
        IA.add(Pair.create("MD", 3));
        IA.add(Pair.create("ME", 4));
        IA.add(Pair.create("MI", 2));
        IA.add(Pair.create("MN", 1));
        IA.add(Pair.create("MO", 1));
        IA.add(Pair.create("MS", 2));
        IA.add(Pair.create("MT", 3));
        IA.add(Pair.create("NC", 3));
        IA.add(Pair.create("ND", 2));
        IA.add(Pair.create("NE", 1));
        IA.add(Pair.create("NH", 4));
        IA.add(Pair.create("NJ", 4));
        IA.add(Pair.create("NM", 3));
        IA.add(Pair.create("NV", 3));
        IA.add(Pair.create("NY", 3));
        IA.add(Pair.create("OH", 2));
        IA.add(Pair.create("OK", 2));
        IA.add(Pair.create("OR", 4));
        IA.add(Pair.create("PA", 3));
        IA.add(Pair.create("PR", 3));
        IA.add(Pair.create("RI", 4));
        IA.add(Pair.create("SC", 3));
        IA.add(Pair.create("SD", 2));
        IA.add(Pair.create("TN", 2));
        IA.add(Pair.create("TX", 3));
        IA.add(Pair.create("UT", 3));
        IA.add(Pair.create("VA", 3));
        IA.add(Pair.create("VT", 4));
        IA.add(Pair.create("WA", 4));
        IA.add(Pair.create("WI", 2));
        IA.add(Pair.create("WV", 3));
        IA.add(Pair.create("WY", 3));

        return IA;

    } // end method createIAZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for ID.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for ID.
     * @since 1.0
     */
    private List<Pair> createIDZoneTable() {

        List<Pair> ID = new ArrayList<>();

        ID.add(Pair.create("AK", 4));
        ID.add(Pair.create("AL", 4));
        ID.add(Pair.create("AR", 4));
        ID.add(Pair.create("AZ", 2));
        ID.add(Pair.create("CA", 2));
        ID.add(Pair.create("CO", 2));
        ID.add(Pair.create("CT", 5));
        ID.add(Pair.create("DC", 5));
        ID.add(Pair.create("DE", 5));
        ID.add(Pair.create("FL", 4));
        ID.add(Pair.create("GA", 4));
        ID.add(Pair.create("HI", 3));
        ID.add(Pair.create("IA", 3));
        ID.add(Pair.create("ID", 0));
        ID.add(Pair.create("IL", 4));
        ID.add(Pair.create("IN", 4));
        ID.add(Pair.create("KS", 3));
        ID.add(Pair.create("KY", 4));
        ID.add(Pair.create("LA", 4));
        ID.add(Pair.create("MA", 5));
        ID.add(Pair.create("MD", 5));
        ID.add(Pair.create("ME", 5));
        ID.add(Pair.create("MI", 4));
        ID.add(Pair.create("MN", 4));
        ID.add(Pair.create("MO", 3));
        ID.add(Pair.create("MS", 4));
        ID.add(Pair.create("MT", 2));
        ID.add(Pair.create("NC", 4));
        ID.add(Pair.create("ND", 3));
        ID.add(Pair.create("NE", 3));
        ID.add(Pair.create("NH", 5));
        ID.add(Pair.create("NJ", 5));
        ID.add(Pair.create("NM", 2));
        ID.add(Pair.create("NV", 2));
        ID.add(Pair.create("NY", 5));
        ID.add(Pair.create("OH", 4));
        ID.add(Pair.create("OK", 3));
        ID.add(Pair.create("OR", 2));
        ID.add(Pair.create("PA", 5));
        ID.add(Pair.create("PR", 6));
        ID.add(Pair.create("RI", 5));
        ID.add(Pair.create("SC", 4));
        ID.add(Pair.create("SD", 3));
        ID.add(Pair.create("TN", 4));
        ID.add(Pair.create("TX", 3));
        ID.add(Pair.create("UT", 1));
        ID.add(Pair.create("VA", 5));
        ID.add(Pair.create("VT", 5));
        ID.add(Pair.create("WA", 2));
        ID.add(Pair.create("WI", 4));
        ID.add(Pair.create("WV", 5));
        ID.add(Pair.create("WY", 2));

        return ID;

    } // end method createIDZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for IL.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for IL.
     * @since 1.0
     */
    private List<Pair> createILZoneTable() {

        List<Pair> IL = new ArrayList<>();

        IL.add(Pair.create("AK", 4));
        IL.add(Pair.create("AL", 3));
        IL.add(Pair.create("AR", 3));
        IL.add(Pair.create("AZ", 4));
        IL.add(Pair.create("CA", 4));
        IL.add(Pair.create("CO", 3));
        IL.add(Pair.create("CT", 3));
        IL.add(Pair.create("DC", 3));
        IL.add(Pair.create("DE", 3));
        IL.add(Pair.create("FL", 3));
        IL.add(Pair.create("GA", 2));
        IL.add(Pair.create("HI", 5));
        IL.add(Pair.create("IA", 1));
        IL.add(Pair.create("ID", 4));
        IL.add(Pair.create("IL", 0));
        IL.add(Pair.create("IN", 1));
        IL.add(Pair.create("KS", 2));
        IL.add(Pair.create("KY", 2));
        IL.add(Pair.create("LA", 3));
        IL.add(Pair.create("MA", 3));
        IL.add(Pair.create("MD", 3));
        IL.add(Pair.create("ME", 3));
        IL.add(Pair.create("MI", 2));
        IL.add(Pair.create("MN", 2));
        IL.add(Pair.create("MO", 2));
        IL.add(Pair.create("MS", 3));
        IL.add(Pair.create("MT", 4));
        IL.add(Pair.create("NC", 3));
        IL.add(Pair.create("ND", 3));
        IL.add(Pair.create("NE", 2));
        IL.add(Pair.create("NH", 3));
        IL.add(Pair.create("NJ", 2));
        IL.add(Pair.create("NM", 4));
        IL.add(Pair.create("NV", 4));
        IL.add(Pair.create("NY", 2));
        IL.add(Pair.create("OH", 2));
        IL.add(Pair.create("OK", 3));
        IL.add(Pair.create("OR", 4));
        IL.add(Pair.create("PA", 2));
        IL.add(Pair.create("PR", 5));
        IL.add(Pair.create("RI", 3));
        IL.add(Pair.create("SC", 3));
        IL.add(Pair.create("SD", 3));
        IL.add(Pair.create("TN", 2));
        IL.add(Pair.create("TX", 4));
        IL.add(Pair.create("UT", 4));
        IL.add(Pair.create("VA", 3));
        IL.add(Pair.create("VT", 3));
        IL.add(Pair.create("WA", 4));
        IL.add(Pair.create("WI", 1));
        IL.add(Pair.create("WV", 2));
        IL.add(Pair.create("WY", 4));

        return IL;

    } // end method createILZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for IN.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for IN.
     * @since 1.0
     */
    private List<Pair> createINZoneTable() {

        List<Pair> IN = new ArrayList<>();

        IN.add(Pair.create("AK", 4));
        IN.add(Pair.create("AL", 2));
        IN.add(Pair.create("AR", 2));
        IN.add(Pair.create("AZ", 4));
        IN.add(Pair.create("CA", 4));
        IN.add(Pair.create("CO", 3));
        IN.add(Pair.create("CT", 3));
        IN.add(Pair.create("DC", 2));
        IN.add(Pair.create("DE", 2));
        IN.add(Pair.create("FL", 3));
        IN.add(Pair.create("GA", 2));
        IN.add(Pair.create("HI", 5));
        IN.add(Pair.create("IA", 2));
        IN.add(Pair.create("ID", 4));
        IN.add(Pair.create("IL", 1));
        IN.add(Pair.create("IN", 0));
        IN.add(Pair.create("KS", 2));
        IN.add(Pair.create("KY", 1));
        IN.add(Pair.create("LA", 2));
        IN.add(Pair.create("MA", 3));
        IN.add(Pair.create("MD", 2));
        IN.add(Pair.create("ME", 3));
        IN.add(Pair.create("MI", 2));
        IN.add(Pair.create("MN", 2));
        IN.add(Pair.create("MO", 2));
        IN.add(Pair.create("MS", 2));
        IN.add(Pair.create("MT", 4));
        IN.add(Pair.create("NC", 2));
        IN.add(Pair.create("ND", 3));
        IN.add(Pair.create("NE", 3));
        IN.add(Pair.create("NH", 3));
        IN.add(Pair.create("NJ", 2));
        IN.add(Pair.create("NM", 4));
        IN.add(Pair.create("NV", 4));
        IN.add(Pair.create("NY", 2));
        IN.add(Pair.create("OH", 1));
        IN.add(Pair.create("OK", 3));
        IN.add(Pair.create("OR", 4));
        IN.add(Pair.create("PA", 2));
        IN.add(Pair.create("PR", 5));
        IN.add(Pair.create("RI", 3));
        IN.add(Pair.create("SC", 2));
        IN.add(Pair.create("SD", 3));
        IN.add(Pair.create("TN", 2));
        IN.add(Pair.create("TX", 3));
        IN.add(Pair.create("UT", 4));
        IN.add(Pair.create("VA", 2));
        IN.add(Pair.create("VT", 3));
        IN.add(Pair.create("WA", 4));
        IN.add(Pair.create("WI", 2));
        IN.add(Pair.create("WV", 2));
        IN.add(Pair.create("WY", 4));

        return IN;

    } // end method createINZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for KS.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for KS.
     * @since 1.0
     */
    private List<Pair> createKSZoneTable() {

        List<Pair> KS = new ArrayList<>();

        KS.add(Pair.create("AK", 4));
        KS.add(Pair.create("AL", 2));
        KS.add(Pair.create("AR", 2));
        KS.add(Pair.create("AZ", 4));
        KS.add(Pair.create("CA", 4));
        KS.add(Pair.create("CO", 2));
        KS.add(Pair.create("CT", 4));
        KS.add(Pair.create("DC", 3));
        KS.add(Pair.create("DE", 4));
        KS.add(Pair.create("FL", 3));
        KS.add(Pair.create("GA", 2));
        KS.add(Pair.create("HI", 5));
        KS.add(Pair.create("IA", 2));
        KS.add(Pair.create("ID", 3));
        KS.add(Pair.create("IL", 2));
        KS.add(Pair.create("IN", 2));
        KS.add(Pair.create("KS", 0));
        KS.add(Pair.create("KY", 2));
        KS.add(Pair.create("LA", 2));
        KS.add(Pair.create("MA", 4));
        KS.add(Pair.create("MD", 4));
        KS.add(Pair.create("ME", 4));
        KS.add(Pair.create("MI", 3));
        KS.add(Pair.create("MN", 2));
        KS.add(Pair.create("MO", 2));
        KS.add(Pair.create("MS", 2));
        KS.add(Pair.create("MT", 3));
        KS.add(Pair.create("NC", 3));
        KS.add(Pair.create("ND", 2));
        KS.add(Pair.create("NE", 2));
        KS.add(Pair.create("NH", 4));
        KS.add(Pair.create("NJ", 4));
        KS.add(Pair.create("NM", 3));
        KS.add(Pair.create("NV", 3));
        KS.add(Pair.create("NY", 3));
        KS.add(Pair.create("OH", 2));
        KS.add(Pair.create("OK", 1));
        KS.add(Pair.create("OR", 4));
        KS.add(Pair.create("PA", 3));
        KS.add(Pair.create("PR", 5));
        KS.add(Pair.create("RI", 4));
        KS.add(Pair.create("SC", 3));
        KS.add(Pair.create("SD", 2));
        KS.add(Pair.create("TN", 2));
        KS.add(Pair.create("TX", 2));
        KS.add(Pair.create("UT", 3));
        KS.add(Pair.create("VA", 3));
        KS.add(Pair.create("VT", 4));
        KS.add(Pair.create("WA", 4));
        KS.add(Pair.create("WI", 2));
        KS.add(Pair.create("WV", 3));
        KS.add(Pair.create("WY", 3));

        return KS;

    } // end method createKSZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for KY.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for KY.
     * @since 1.0
     */
    private List<Pair> createKYZoneTable() {

        List<Pair> KY = new ArrayList<>();

        KY.add(Pair.create("AK", 3));
        KY.add(Pair.create("AL", 2));
        KY.add(Pair.create("AR", 2));
        KY.add(Pair.create("AZ", 4));
        KY.add(Pair.create("CA", 4));
        KY.add(Pair.create("CO", 3));
        KY.add(Pair.create("CT", 3));
        KY.add(Pair.create("DC", 2));
        KY.add(Pair.create("DE", 2));
        KY.add(Pair.create("FL", 2));
        KY.add(Pair.create("GA", 2));
        KY.add(Pair.create("HI", 5));
        KY.add(Pair.create("IA", 2));
        KY.add(Pair.create("ID", 4));
        KY.add(Pair.create("IL", 2));
        KY.add(Pair.create("IN", 1));
        KY.add(Pair.create("KS", 2));
        KY.add(Pair.create("KY", 0));
        KY.add(Pair.create("LA", 2));
        KY.add(Pair.create("MA", 3));
        KY.add(Pair.create("MD", 2));
        KY.add(Pair.create("ME", 3));
        KY.add(Pair.create("MI", 2));
        KY.add(Pair.create("MN", 2));
        KY.add(Pair.create("MO", 2));
        KY.add(Pair.create("MS", 2));
        KY.add(Pair.create("MT", 4));
        KY.add(Pair.create("NC", 2));
        KY.add(Pair.create("ND", 3));
        KY.add(Pair.create("NE", 3));
        KY.add(Pair.create("NH", 3));
        KY.add(Pair.create("NJ", 2));
        KY.add(Pair.create("NM", 4));
        KY.add(Pair.create("NV", 4));
        KY.add(Pair.create("NY", 2));
        KY.add(Pair.create("OH", 1));
        KY.add(Pair.create("OK", 2));
        KY.add(Pair.create("OR", 4));
        KY.add(Pair.create("PA", 2));
        KY.add(Pair.create("PR", 3));
        KY.add(Pair.create("RI", 3));
        KY.add(Pair.create("SC", 2));
        KY.add(Pair.create("SD", 3));
        KY.add(Pair.create("TN", 1));
        KY.add(Pair.create("TX", 3));
        KY.add(Pair.create("UT", 4));
        KY.add(Pair.create("VA", 2));
        KY.add(Pair.create("VT", 3));
        KY.add(Pair.create("WA", 4));
        KY.add(Pair.create("WI", 2));
        KY.add(Pair.create("WV", 1));
        KY.add(Pair.create("WY", 4));

        return KY;

    } // end method createKYZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for LA.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for LA.
     * @since 1.0
     */
    private List<Pair> createLAZoneTable() {

        List<Pair> LA = new ArrayList<>();

        LA.add(Pair.create("AK", 4));
        LA.add(Pair.create("AL", 2));
        LA.add(Pair.create("AR", 2));
        LA.add(Pair.create("AZ", 3));
        LA.add(Pair.create("CA", 5));
        LA.add(Pair.create("CO", 3));
        LA.add(Pair.create("CT", 5));
        LA.add(Pair.create("DC", 3));
        LA.add(Pair.create("DE", 3));
        LA.add(Pair.create("FL", 2));
        LA.add(Pair.create("GA", 2));
        LA.add(Pair.create("HI", 5));
        LA.add(Pair.create("IA", 3));
        LA.add(Pair.create("ID", 5));
        LA.add(Pair.create("IL", 3));
        LA.add(Pair.create("IN", 3));
        LA.add(Pair.create("KS", 3));
        LA.add(Pair.create("KY", 2));
        LA.add(Pair.create("LA", 0));
        LA.add(Pair.create("MA", 5));
        LA.add(Pair.create("MD", 3));
        LA.add(Pair.create("ME", 5));
        LA.add(Pair.create("MI", 3));
        LA.add(Pair.create("MN", 3));
        LA.add(Pair.create("MO", 2));
        LA.add(Pair.create("MS", 1));
        LA.add(Pair.create("MT", 5));
        LA.add(Pair.create("NC", 2));
        LA.add(Pair.create("ND", 4));
        LA.add(Pair.create("NE", 3));
        LA.add(Pair.create("NH", 5));
        LA.add(Pair.create("NJ", 5));
        LA.add(Pair.create("NM", 3));
        LA.add(Pair.create("NV", 4));
        LA.add(Pair.create("NY", 5));
        LA.add(Pair.create("OH", 3));
        LA.add(Pair.create("OK", 2));
        LA.add(Pair.create("OR", 5));
        LA.add(Pair.create("PA", 3));
        LA.add(Pair.create("PR", 4));
        LA.add(Pair.create("RI", 5));
        LA.add(Pair.create("SC", 2));
        LA.add(Pair.create("SD", 4));
        LA.add(Pair.create("TN", 2));
        LA.add(Pair.create("TX", 2));
        LA.add(Pair.create("UT", 4));
        LA.add(Pair.create("VA", 3));
        LA.add(Pair.create("VT", 5));
        LA.add(Pair.create("WA", 5));
        LA.add(Pair.create("WI", 3));
        LA.add(Pair.create("WV", 3));
        LA.add(Pair.create("WY", 4));

        return LA;

    } // end method createLAZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for MA.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for MA.
     * @since 1.0
     */
    private List<Pair> createMAZoneTable() {

        List<Pair> MA = new ArrayList<>();

        MA.add(Pair.create("AK", 5));
        MA.add(Pair.create("AL", 3));
        MA.add(Pair.create("AR", 4));
        MA.add(Pair.create("AZ", 5));
        MA.add(Pair.create("CA", 5));
        MA.add(Pair.create("CO", 4));
        MA.add(Pair.create("CT", 1));
        MA.add(Pair.create("DC", 2));
        MA.add(Pair.create("DE", 1));
        MA.add(Pair.create("FL", 4));
        MA.add(Pair.create("GA", 3));
        MA.add(Pair.create("HI", 6));
        MA.add(Pair.create("IA", 3));
        MA.add(Pair.create("ID", 5));
        MA.add(Pair.create("IL", 3));
        MA.add(Pair.create("IN", 3));
        MA.add(Pair.create("KS", 4));
        MA.add(Pair.create("KY", 3));
        MA.add(Pair.create("LA", 4));
        MA.add(Pair.create("MA", 0));
        MA.add(Pair.create("MD", 2));
        MA.add(Pair.create("ME", 1));
        MA.add(Pair.create("MI", 3));
        MA.add(Pair.create("MN", 3));
        MA.add(Pair.create("MO", 3));
        MA.add(Pair.create("MS", 4));
        MA.add(Pair.create("MT", 5));
        MA.add(Pair.create("NC", 3));
        MA.add(Pair.create("ND", 4));
        MA.add(Pair.create("NE", 4));
        MA.add(Pair.create("NH", 1));
        MA.add(Pair.create("NJ", 1));
        MA.add(Pair.create("NM", 5));
        MA.add(Pair.create("NV", 5));
        MA.add(Pair.create("NY", 1));
        MA.add(Pair.create("OH", 2));
        MA.add(Pair.create("OK", 4));
        MA.add(Pair.create("OR", 5));
        MA.add(Pair.create("PA", 2));
        MA.add(Pair.create("PR", 5));
        MA.add(Pair.create("RI", 1));
        MA.add(Pair.create("SC", 3));
        MA.add(Pair.create("SD", 4));
        MA.add(Pair.create("TN", 3));
        MA.add(Pair.create("TX", 5));
        MA.add(Pair.create("UT", 5));
        MA.add(Pair.create("VA", 2));
        MA.add(Pair.create("VT", 1));
        MA.add(Pair.create("WA", 5));
        MA.add(Pair.create("WI", 3));
        MA.add(Pair.create("WV", 2));
        MA.add(Pair.create("WY", 5));

        return MA;

    } // end method createMAZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for MD.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for MD.
     * @since 1.0
     */
    private List<Pair> createMDZoneTable() {

        List<Pair> MD = new ArrayList<>();

        MD.add(Pair.create("AK", 4));
        MD.add(Pair.create("AL", 3));
        MD.add(Pair.create("AR", 3));
        MD.add(Pair.create("AZ", 4));
        MD.add(Pair.create("CA", 5));
        MD.add(Pair.create("CO", 4));
        MD.add(Pair.create("CT", 2));
        MD.add(Pair.create("DC", 1));
        MD.add(Pair.create("DE", 1));
        MD.add(Pair.create("FL", 3));
        MD.add(Pair.create("GA", 2));
        MD.add(Pair.create("HI", 5));
        MD.add(Pair.create("IA", 3));
        MD.add(Pair.create("ID", 5));
        MD.add(Pair.create("IL", 3));
        MD.add(Pair.create("IN", 2));
        MD.add(Pair.create("KS", 3));
        MD.add(Pair.create("KY", 2));
        MD.add(Pair.create("LA", 3));
        MD.add(Pair.create("MA", 2));
        MD.add(Pair.create("MD", 0));
        MD.add(Pair.create("ME", 2));
        MD.add(Pair.create("MI", 2));
        MD.add(Pair.create("MN", 3));
        MD.add(Pair.create("MO", 3));
        MD.add(Pair.create("MS", 3));
        MD.add(Pair.create("MT", 5));
        MD.add(Pair.create("NC", 2));
        MD.add(Pair.create("ND", 4));
        MD.add(Pair.create("NE", 4));
        MD.add(Pair.create("NH", 2));
        MD.add(Pair.create("NJ", 1));
        MD.add(Pair.create("NM", 5));
        MD.add(Pair.create("NV", 5));
        MD.add(Pair.create("NY", 2));
        MD.add(Pair.create("OH", 2));
        MD.add(Pair.create("OK", 4));
        MD.add(Pair.create("OR", 5));
        MD.add(Pair.create("PA", 1));
        MD.add(Pair.create("PR", 5));
        MD.add(Pair.create("RI", 2));
        MD.add(Pair.create("SC", 2));
        MD.add(Pair.create("SD", 4));
        MD.add(Pair.create("TN", 2));
        MD.add(Pair.create("TX", 4));
        MD.add(Pair.create("UT", 5));
        MD.add(Pair.create("VA", 1));
        MD.add(Pair.create("VT", 2));
        MD.add(Pair.create("WA", 5));
        MD.add(Pair.create("WI", 3));
        MD.add(Pair.create("WV", 2));
        MD.add(Pair.create("WY", 4));

        return MD;

    } // end method createMDZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for ME.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for ME.
     * @since 1.0
     */
    private List<Pair> createMEZoneTable() {

        List<Pair> ME = new ArrayList<>();

        ME.add(Pair.create("AK", 5));
        ME.add(Pair.create("AL", 3));
        ME.add(Pair.create("AR", 4));
        ME.add(Pair.create("AZ", 5));
        ME.add(Pair.create("CA", 5));
        ME.add(Pair.create("CO", 4));
        ME.add(Pair.create("CT", 1));
        ME.add(Pair.create("DC", 2));
        ME.add(Pair.create("DE", 2));
        ME.add(Pair.create("FL", 4));
        ME.add(Pair.create("GA", 3));
        ME.add(Pair.create("HI", 6));
        ME.add(Pair.create("IA", 3));
        ME.add(Pair.create("ID", 5));
        ME.add(Pair.create("IL", 3));
        ME.add(Pair.create("IN", 3));
        ME.add(Pair.create("KS", 4));
        ME.add(Pair.create("KY", 3));
        ME.add(Pair.create("LA", 4));
        ME.add(Pair.create("MA", 1));
        ME.add(Pair.create("MD", 0));
        ME.add(Pair.create("ME", 0));
        ME.add(Pair.create("MI", 3));
        ME.add(Pair.create("MN", 3));
        ME.add(Pair.create("MO", 3));
        ME.add(Pair.create("MS", 4));
        ME.add(Pair.create("MT", 5));
        ME.add(Pair.create("NC", 3));
        ME.add(Pair.create("ND", 4));
        ME.add(Pair.create("NE", 4));
        ME.add(Pair.create("NH", 1));
        ME.add(Pair.create("NJ", 2));
        ME.add(Pair.create("NM", 5));
        ME.add(Pair.create("NV", 5));
        ME.add(Pair.create("NY", 2));
        ME.add(Pair.create("OH", 2));
        ME.add(Pair.create("OK", 4));
        ME.add(Pair.create("OR", 5));
        ME.add(Pair.create("PA", 2));
        ME.add(Pair.create("PR", 5));
        ME.add(Pair.create("RI", 1));
        ME.add(Pair.create("SC", 3));
        ME.add(Pair.create("SD", 4));
        ME.add(Pair.create("TN", 3));
        ME.add(Pair.create("TX", 5));
        ME.add(Pair.create("UT", 5));
        ME.add(Pair.create("VA", 2));
        ME.add(Pair.create("VT", 1));
        ME.add(Pair.create("WA", 5));
        ME.add(Pair.create("WI", 3));
        ME.add(Pair.create("WV", 2));
        ME.add(Pair.create("WY", 5));

        return ME;

    } // end method createMEZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for MI.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for MI.
     * @since 1.0
     */
    private List<Pair> createMIZoneTable() {

        List<Pair> MI = new ArrayList<>();

        MI.add(Pair.create("AK", 4));
        MI.add(Pair.create("AL", 3));
        MI.add(Pair.create("AR", 3));
        MI.add(Pair.create("AZ", 4));
        MI.add(Pair.create("CA", 4));
        MI.add(Pair.create("CO", 3));
        MI.add(Pair.create("CT", 2));
        MI.add(Pair.create("DC", 2));
        MI.add(Pair.create("DE", 2));
        MI.add(Pair.create("FL", 3));
        MI.add(Pair.create("GA", 2));
        MI.add(Pair.create("HI", 5));
        MI.add(Pair.create("IA", 2));
        MI.add(Pair.create("ID", 4));
        MI.add(Pair.create("IL", 2));
        MI.add(Pair.create("IN", 2));
        MI.add(Pair.create("KS", 3));
        MI.add(Pair.create("KY", 2));
        MI.add(Pair.create("LA", 3));
        MI.add(Pair.create("MA", 3));
        MI.add(Pair.create("MD", 2));
        MI.add(Pair.create("ME", 3));
        MI.add(Pair.create("MI", 0));
        MI.add(Pair.create("MN", 2));
        MI.add(Pair.create("MO", 2));
        MI.add(Pair.create("MS", 3));
        MI.add(Pair.create("MT", 4));
        MI.add(Pair.create("NC", 2));
        MI.add(Pair.create("ND", 3));
        MI.add(Pair.create("NE", 3));
        MI.add(Pair.create("NH", 3));
        MI.add(Pair.create("NJ", 2));
        MI.add(Pair.create("NM", 4));
        MI.add(Pair.create("NV", 4));
        MI.add(Pair.create("NY", 2));
        MI.add(Pair.create("OH", 2));
        MI.add(Pair.create("OK", 3));
        MI.add(Pair.create("OR", 4));
        MI.add(Pair.create("PA", 2));
        MI.add(Pair.create("PR", 5));
        MI.add(Pair.create("RI", 3));
        MI.add(Pair.create("SC", 2));
        MI.add(Pair.create("SD", 3));
        MI.add(Pair.create("TN", 2));
        MI.add(Pair.create("TX", 4));
        MI.add(Pair.create("UT", 4));
        MI.add(Pair.create("VA", 2));
        MI.add(Pair.create("VT", 3));
        MI.add(Pair.create("WA", 4));
        MI.add(Pair.create("WI", 2));
        MI.add(Pair.create("WV", 2));
        MI.add(Pair.create("WY", 4));

        return MI;

    } // end method createMIZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for MN.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for MN.
     * @since 1.0
     */
    private List<Pair> createMNZoneTable() {

        List<Pair> MN = new ArrayList<>();

        MN.add(Pair.create("AK", 4));
        MN.add(Pair.create("AL", 3));
        MN.add(Pair.create("AR", 3));
        MN.add(Pair.create("AZ", 4));
        MN.add(Pair.create("CA", 4));
        MN.add(Pair.create("CO", 3));
        MN.add(Pair.create("CT", 4));
        MN.add(Pair.create("DC", 3));
        MN.add(Pair.create("DE", 3));
        MN.add(Pair.create("FL", 3));
        MN.add(Pair.create("GA", 3));
        MN.add(Pair.create("HI", 5));
        MN.add(Pair.create("IA", 1));
        MN.add(Pair.create("ID", 4));
        MN.add(Pair.create("IL", 2));
        MN.add(Pair.create("IN", 2));
        MN.add(Pair.create("KS", 2));
        MN.add(Pair.create("KY", 2));
        MN.add(Pair.create("LA", 3));
        MN.add(Pair.create("MA", 4));
        MN.add(Pair.create("MD", 3));
        MN.add(Pair.create("ME", 4));
        MN.add(Pair.create("MI", 2));
        MN.add(Pair.create("MN", 0));
        MN.add(Pair.create("MO", 2));
        MN.add(Pair.create("MS", 3));
        MN.add(Pair.create("MT", 3));
        MN.add(Pair.create("NC", 3));
        MN.add(Pair.create("ND", 2));
        MN.add(Pair.create("NE", 2));
        MN.add(Pair.create("NH", 4));
        MN.add(Pair.create("NJ", 3));
        MN.add(Pair.create("NM", 3));
        MN.add(Pair.create("NV", 4));
        MN.add(Pair.create("NY", 3));
        MN.add(Pair.create("OH", 2));
        MN.add(Pair.create("OK", 3));
        MN.add(Pair.create("OR", 4));
        MN.add(Pair.create("PA", 3));
        MN.add(Pair.create("PR", 4));
        MN.add(Pair.create("RI", 4));
        MN.add(Pair.create("SC", 3));
        MN.add(Pair.create("SD", 2));
        MN.add(Pair.create("TN", 3));
        MN.add(Pair.create("TX", 3));
        MN.add(Pair.create("UT", 4));
        MN.add(Pair.create("VA", 3));
        MN.add(Pair.create("VT", 4));
        MN.add(Pair.create("WA", 4));
        MN.add(Pair.create("WI", 1));
        MN.add(Pair.create("WV", 3));
        MN.add(Pair.create("WY", 3));

        return MN;

    } // end method createMNZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for MO.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for MO.
     * @since 1.0
     */
    private List<Pair> createMOZoneTable() {

        List<Pair> MO = new ArrayList<>();

        MO.add(Pair.create("AK", 4));
        MO.add(Pair.create("AL", 2));
        MO.add(Pair.create("AR", 2));
        MO.add(Pair.create("AZ", 4));
        MO.add(Pair.create("CA", 4));
        MO.add(Pair.create("CO", 2));
        MO.add(Pair.create("CT", 3));
        MO.add(Pair.create("DC", 2));
        MO.add(Pair.create("DE", 3));
        MO.add(Pair.create("FL", 3));
        MO.add(Pair.create("GA", 2));
        MO.add(Pair.create("HI", 5));
        MO.add(Pair.create("IA", 2));
        MO.add(Pair.create("ID", 4));
        MO.add(Pair.create("IL", 1));
        MO.add(Pair.create("IN", 2));
        MO.add(Pair.create("KS", 2));
        MO.add(Pair.create("KY", 2));
        MO.add(Pair.create("LA", 2));
        MO.add(Pair.create("MA", 3));
        MO.add(Pair.create("MD", 3));
        MO.add(Pair.create("ME", 3));
        MO.add(Pair.create("MI", 2));
        MO.add(Pair.create("MN", 2));
        MO.add(Pair.create("MO", 0));
        MO.add(Pair.create("MS", 2));
        MO.add(Pair.create("MT", 4));
        MO.add(Pair.create("NC", 2));
        MO.add(Pair.create("ND", 3));
        MO.add(Pair.create("NE", 2));
        MO.add(Pair.create("NH", 3));
        MO.add(Pair.create("NJ", 3));
        MO.add(Pair.create("NM", 3));
        MO.add(Pair.create("NV", 4));
        MO.add(Pair.create("NY", 3));
        MO.add(Pair.create("OH", 2));
        MO.add(Pair.create("OK", 2));
        MO.add(Pair.create("OR", 4));
        MO.add(Pair.create("PA", 2));
        MO.add(Pair.create("PR", 5));
        MO.add(Pair.create("RI", 3));
        MO.add(Pair.create("SC", 2));
        MO.add(Pair.create("SD", 3));
        MO.add(Pair.create("TN", 2));
        MO.add(Pair.create("TX", 2));
        MO.add(Pair.create("UT", 4));
        MO.add(Pair.create("VA", 2));
        MO.add(Pair.create("VT", 3));
        MO.add(Pair.create("WA", 4));
        MO.add(Pair.create("WI", 2));
        MO.add(Pair.create("WV", 2));
        MO.add(Pair.create("WY", 3));

        return MO;

    } // end method createMOZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for MS.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for MS.
     * @since 1.0
     */
    private List<Pair> createMSZoneTable() {

        List<Pair> MS = new ArrayList<>();

        MS.add(Pair.create("AK", 4));
        MS.add(Pair.create("AL", 2));
        MS.add(Pair.create("AR", 2));
        MS.add(Pair.create("AZ", 3));
        MS.add(Pair.create("CA", 5));
        MS.add(Pair.create("CO", 3));
        MS.add(Pair.create("CT", 4));
        MS.add(Pair.create("DC", 3));
        MS.add(Pair.create("DE", 3));
        MS.add(Pair.create("FL", 2));
        MS.add(Pair.create("GA", 2));
        MS.add(Pair.create("HI", 6));
        MS.add(Pair.create("IA", 3));
        MS.add(Pair.create("ID", 5));
        MS.add(Pair.create("IL", 2));
        MS.add(Pair.create("IN", 3));
        MS.add(Pair.create("KS", 3));
        MS.add(Pair.create("KY", 2));
        MS.add(Pair.create("LA", 1));
        MS.add(Pair.create("MA", 4));
        MS.add(Pair.create("MD", 3));
        MS.add(Pair.create("ME", 4));
        MS.add(Pair.create("MI", 4));
        MS.add(Pair.create("MN", 3));
        MS.add(Pair.create("MO", 2));
        MS.add(Pair.create("MS", 0));
        MS.add(Pair.create("MT", 5));
        MS.add(Pair.create("NC", 2));
        MS.add(Pair.create("ND", 4));
        MS.add(Pair.create("NE", 3));
        MS.add(Pair.create("NH", 4));
        MS.add(Pair.create("NJ", 4));
        MS.add(Pair.create("NM", 3));
        MS.add(Pair.create("NV", 4));
        MS.add(Pair.create("NY", 4));
        MS.add(Pair.create("OH", 3));
        MS.add(Pair.create("OK", 2));
        MS.add(Pair.create("OR", 5));
        MS.add(Pair.create("PA", 3));
        MS.add(Pair.create("PR", 4));
        MS.add(Pair.create("RI", 4));
        MS.add(Pair.create("SC", 2));
        MS.add(Pair.create("SD", 4));
        MS.add(Pair.create("TN", 2));
        MS.add(Pair.create("TX", 2));
        MS.add(Pair.create("UT", 4));
        MS.add(Pair.create("VA", 3));
        MS.add(Pair.create("VT", 4));
        MS.add(Pair.create("WA", 5));
        MS.add(Pair.create("WI", 3));
        MS.add(Pair.create("WV", 3));
        MS.add(Pair.create("WY", 4));

        return MS;

    } // end method createMSZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for MT.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for MT.
     * @since 1.0
     */
    private List<Pair> createMTZoneTable() {

        List<Pair> MT = new ArrayList<>();

        MT.add(Pair.create("AK", 5));
        MT.add(Pair.create("AL", 5));
        MT.add(Pair.create("AR", 4));
        MT.add(Pair.create("AZ", 3));
        MT.add(Pair.create("CA", 3));
        MT.add(Pair.create("CO", 3));
        MT.add(Pair.create("CT", 6));
        MT.add(Pair.create("DC", 5));
        MT.add(Pair.create("DE", 5));
        MT.add(Pair.create("FL", 5));
        MT.add(Pair.create("GA", 5));
        MT.add(Pair.create("HI", 4));
        MT.add(Pair.create("IA", 3));
        MT.add(Pair.create("ID", 2));
        MT.add(Pair.create("IL", 4));
        MT.add(Pair.create("IN", 4));
        MT.add(Pair.create("KS", 4));
        MT.add(Pair.create("KY", 4));
        MT.add(Pair.create("LA", 5));
        MT.add(Pair.create("MA", 6));
        MT.add(Pair.create("MD", 5));
        MT.add(Pair.create("ME", 6));
        MT.add(Pair.create("MI", 4));
        MT.add(Pair.create("MN", 3));
        MT.add(Pair.create("MO", 4));
        MT.add(Pair.create("MS", 4));
        MT.add(Pair.create("MT", 0));
        MT.add(Pair.create("NC", 5));
        MT.add(Pair.create("ND", 2));
        MT.add(Pair.create("NE", 3));
        MT.add(Pair.create("NH", 6));
        MT.add(Pair.create("NJ", 6));
        MT.add(Pair.create("NM", 4));
        MT.add(Pair.create("NV", 3));
        MT.add(Pair.create("NY", 5));
        MT.add(Pair.create("OH", 4));
        MT.add(Pair.create("OK", 4));
        MT.add(Pair.create("OR", 2));
        MT.add(Pair.create("PA", 5));
        MT.add(Pair.create("PR", 6));
        MT.add(Pair.create("RI", 6));
        MT.add(Pair.create("SC", 5));
        MT.add(Pair.create("SD", 3));
        MT.add(Pair.create("TN", 4));
        MT.add(Pair.create("TX", 4));
        MT.add(Pair.create("UT", 2));
        MT.add(Pair.create("VA", 5));
        MT.add(Pair.create("VT", 6));
        MT.add(Pair.create("WA", 2));
        MT.add(Pair.create("WI", 3));
        MT.add(Pair.create("WV", 5));
        MT.add(Pair.create("WY", 2));

        return MT;

    } // end method createMTZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for NC.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for NC.
     * @since 1.0
     */
    private List<Pair> createNCZoneTable() {

        List<Pair> NC = new ArrayList<>();

        NC.add(Pair.create("AK", 3));
        NC.add(Pair.create("AL", 2));
        NC.add(Pair.create("AR", 2));
        NC.add(Pair.create("AZ", 4));
        NC.add(Pair.create("CA", 4));
        NC.add(Pair.create("CO", 4));
        NC.add(Pair.create("CT", 2));
        NC.add(Pair.create("DC", 1));
        NC.add(Pair.create("DE", 2));
        NC.add(Pair.create("FL", 2));
        NC.add(Pair.create("GA", 2));
        NC.add(Pair.create("HI", 5));
        NC.add(Pair.create("IA", 3));
        NC.add(Pair.create("ID", 5));
        NC.add(Pair.create("IL", 2));
        NC.add(Pair.create("IN", 2));
        NC.add(Pair.create("KS", 3));
        NC.add(Pair.create("KY", 2));
        NC.add(Pair.create("LA", 2));
        NC.add(Pair.create("MA", 3));
        NC.add(Pair.create("MD", 2));
        NC.add(Pair.create("ME", 3));
        NC.add(Pair.create("MI", 2));
        NC.add(Pair.create("MN", 3));
        NC.add(Pair.create("MO", 2));
        NC.add(Pair.create("MS", 2));
        NC.add(Pair.create("MT", 5));
        NC.add(Pair.create("NC", 0));
        NC.add(Pair.create("ND", 4));
        NC.add(Pair.create("NE", 3));
        NC.add(Pair.create("NH", 3));
        NC.add(Pair.create("NJ", 2));
        NC.add(Pair.create("NM", 4));
        NC.add(Pair.create("NV", 5));
        NC.add(Pair.create("NY", 3));
        NC.add(Pair.create("OH", 2));
        NC.add(Pair.create("OK", 3));
        NC.add(Pair.create("OR", 5));
        NC.add(Pair.create("PA", 2));
        NC.add(Pair.create("PR", 4));
        NC.add(Pair.create("RI", 3));
        NC.add(Pair.create("SC", 1));
        NC.add(Pair.create("SD", 4));
        NC.add(Pair.create("TN", 2));
        NC.add(Pair.create("TX", 3));
        NC.add(Pair.create("UT", 5));
        NC.add(Pair.create("VA", 1));
        NC.add(Pair.create("VT", 3));
        NC.add(Pair.create("WA", 5));
        NC.add(Pair.create("WI", 3));
        NC.add(Pair.create("WV", 2));
        NC.add(Pair.create("WY", 5));

        return NC;

    } // end method createNCZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for ND.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for ND.
     * @since 1.0
     */
    private List<Pair> createNDZoneTable() {

        List<Pair> ND = new ArrayList<>();

        ND.add(Pair.create("AK", 6));
        ND.add(Pair.create("AL", 4));
        ND.add(Pair.create("AR", 3));
        ND.add(Pair.create("AZ", 4));
        ND.add(Pair.create("CA", 4));
        ND.add(Pair.create("CO", 3));
        ND.add(Pair.create("CT", 5));
        ND.add(Pair.create("DC", 4));
        ND.add(Pair.create("DE", 4));
        ND.add(Pair.create("FL", 4));
        ND.add(Pair.create("GA", 4));
        ND.add(Pair.create("HI", 5));
        ND.add(Pair.create("IA", 2));
        ND.add(Pair.create("ID", 3));
        ND.add(Pair.create("IL", 3));
        ND.add(Pair.create("IN", 3));
        ND.add(Pair.create("KS", 2));
        ND.add(Pair.create("KY", 3));
        ND.add(Pair.create("LA", 3));
        ND.add(Pair.create("MA", 5));
        ND.add(Pair.create("MD", 4));
        ND.add(Pair.create("ME", 5));
        ND.add(Pair.create("MI", 3));
        ND.add(Pair.create("MN", 2));
        ND.add(Pair.create("MO", 2));
        ND.add(Pair.create("MS", 3));
        ND.add(Pair.create("MT", 2));
        ND.add(Pair.create("NC", 5));
        ND.add(Pair.create("ND", 0));
        ND.add(Pair.create("NE", 2));
        ND.add(Pair.create("NH", 5));
        ND.add(Pair.create("NJ", 5));
        ND.add(Pair.create("NM", 4));
        ND.add(Pair.create("NV", 3));
        ND.add(Pair.create("NY", 4));
        ND.add(Pair.create("OH", 3));
        ND.add(Pair.create("OK", 3));
        ND.add(Pair.create("OR", 3));
        ND.add(Pair.create("PA", 4));
        ND.add(Pair.create("PR", 5));
        ND.add(Pair.create("RI", 5));
        ND.add(Pair.create("SC", 5));
        ND.add(Pair.create("SD", 2));
        ND.add(Pair.create("TN", 3));
        ND.add(Pair.create("TX", 4));
        ND.add(Pair.create("UT", 3));
        ND.add(Pair.create("VA", 4));
        ND.add(Pair.create("VT", 5));
        ND.add(Pair.create("WA", 3));
        ND.add(Pair.create("WI", 2));
        ND.add(Pair.create("WV", 4));
        ND.add(Pair.create("WY", 2));

        return ND;

    } // end method createNDZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for NE.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for NE.
     * @since 1.0
     */
    private List<Pair> createNEZoneTable() {

        List<Pair> NE = new ArrayList<>();

        NE.add(Pair.create("AK", 6));
        NE.add(Pair.create("AL", 3));
        NE.add(Pair.create("AR", 3));
        NE.add(Pair.create("AZ", 3));
        NE.add(Pair.create("CA", 4));
        NE.add(Pair.create("CO", 2));
        NE.add(Pair.create("CT", 4));
        NE.add(Pair.create("DC", 3));
        NE.add(Pair.create("DE", 3));
        NE.add(Pair.create("FL", 3));
        NE.add(Pair.create("GA", 3));
        NE.add(Pair.create("HI", 5));
        NE.add(Pair.create("IA", 1));
        NE.add(Pair.create("ID", 3));
        NE.add(Pair.create("IL", 2));
        NE.add(Pair.create("IN", 3));
        NE.add(Pair.create("KS", 1));
        NE.add(Pair.create("KY", 3));
        NE.add(Pair.create("LA", 3));
        NE.add(Pair.create("MA", 4));
        NE.add(Pair.create("MD", 3));
        NE.add(Pair.create("ME", 4));
        NE.add(Pair.create("MI", 3));
        NE.add(Pair.create("MN", 2));
        NE.add(Pair.create("MO", 2));
        NE.add(Pair.create("MS", 3));
        NE.add(Pair.create("MT", 3));
        NE.add(Pair.create("NC", 3));
        NE.add(Pair.create("ND", 2));
        NE.add(Pair.create("NE", 0));
        NE.add(Pair.create("NH", 4));
        NE.add(Pair.create("NJ", 4));
        NE.add(Pair.create("NM", 3));
        NE.add(Pair.create("NV", 3));
        NE.add(Pair.create("NY", 3));
        NE.add(Pair.create("OH", 3));
        NE.add(Pair.create("OK", 2));
        NE.add(Pair.create("OR", 4));
        NE.add(Pair.create("PA", 3));
        NE.add(Pair.create("PR", 3));
        NE.add(Pair.create("RI", 4));
        NE.add(Pair.create("SC", 3));
        NE.add(Pair.create("SD", 2));
        NE.add(Pair.create("TN", 2));
        NE.add(Pair.create("TX", 2));
        NE.add(Pair.create("UT", 3));
        NE.add(Pair.create("VA", 3));
        NE.add(Pair.create("VT", 4));
        NE.add(Pair.create("WA", 4));
        NE.add(Pair.create("WI", 2));
        NE.add(Pair.create("WV", 3));
        NE.add(Pair.create("WY", 3));

        return NE;

    } // end method createNEZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for NH.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for NH.
     * @since 1.0
     */
    private List<Pair> createNHZoneTable() {

        List<Pair> NH = new ArrayList<>();

        NH.add(Pair.create("AK", 4));
        NH.add(Pair.create("AL", 3));
        NH.add(Pair.create("AR", 4));
        NH.add(Pair.create("AZ", 5));
        NH.add(Pair.create("CA", 5));
        NH.add(Pair.create("CO", 4));
        NH.add(Pair.create("CT", 1));
        NH.add(Pair.create("DC", 2));
        NH.add(Pair.create("DE", 2));
        NH.add(Pair.create("FL", 3));
        NH.add(Pair.create("GA", 3));
        NH.add(Pair.create("HI", 6));
        NH.add(Pair.create("IA", 3));
        NH.add(Pair.create("ID", 5));
        NH.add(Pair.create("IL", 3));
        NH.add(Pair.create("IN", 2));
        NH.add(Pair.create("KS", 3));
        NH.add(Pair.create("KY", 2));
        NH.add(Pair.create("LA", 4));
        NH.add(Pair.create("MA", 1));
        NH.add(Pair.create("MD", 2));
        NH.add(Pair.create("ME", 1));
        NH.add(Pair.create("MI", 3));
        NH.add(Pair.create("MN", 3));
        NH.add(Pair.create("MO", 3));
        NH.add(Pair.create("MS", 4));
        NH.add(Pair.create("MT", 5));
        NH.add(Pair.create("NC", 2));
        NH.add(Pair.create("ND", 4));
        NH.add(Pair.create("NE", 4));
        NH.add(Pair.create("NH", 0));
        NH.add(Pair.create("NJ", 2));
        NH.add(Pair.create("NM", 5));
        NH.add(Pair.create("NV", 5));
        NH.add(Pair.create("NY", 2));
        NH.add(Pair.create("OH", 2));
        NH.add(Pair.create("OK", 4));
        NH.add(Pair.create("OR", 5));
        NH.add(Pair.create("PA", 2));
        NH.add(Pair.create("PR", 5));
        NH.add(Pair.create("RI", 1));
        NH.add(Pair.create("SC", 2));
        NH.add(Pair.create("SD", 4));
        NH.add(Pair.create("TN", 3));
        NH.add(Pair.create("TX", 4));
        NH.add(Pair.create("UT", 5));
        NH.add(Pair.create("VA", 2));
        NH.add(Pair.create("VT", 1));
        NH.add(Pair.create("WA", 5));
        NH.add(Pair.create("WI", 3));
        NH.add(Pair.create("WV", 2));
        NH.add(Pair.create("WY", 5));

        return NH;

    } // end method createNHZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for NJ.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for NJ.
     * @since 1.0
     */
    private List<Pair> createNJZoneTable() {

        List<Pair> NJ = new ArrayList<>();

        NJ.add(Pair.create("AK", 4));
        NJ.add(Pair.create("AL", 3));
        NJ.add(Pair.create("AR", 3));
        NJ.add(Pair.create("AZ", 4));
        NJ.add(Pair.create("CA", 5));
        NJ.add(Pair.create("CO", 4));
        NJ.add(Pair.create("CT", 1));
        NJ.add(Pair.create("DC", 2));
        NJ.add(Pair.create("DE", 1));
        NJ.add(Pair.create("FL", 3));
        NJ.add(Pair.create("GA", 2));
        NJ.add(Pair.create("HI", 5));
        NJ.add(Pair.create("IA", 3));
        NJ.add(Pair.create("ID", 5));
        NJ.add(Pair.create("IL", 2));
        NJ.add(Pair.create("IN", 2));
        NJ.add(Pair.create("KS", 3));
        NJ.add(Pair.create("KY", 2));
        NJ.add(Pair.create("LA", 3));
        NJ.add(Pair.create("MA", 1));
        NJ.add(Pair.create("MD", 1));
        NJ.add(Pair.create("ME", 2));
        NJ.add(Pair.create("MI", 2));
        NJ.add(Pair.create("MN", 3));
        NJ.add(Pair.create("MO", 3));
        NJ.add(Pair.create("MS", 3));
        NJ.add(Pair.create("MT", 5));
        NJ.add(Pair.create("NC", 2));
        NJ.add(Pair.create("ND", 4));
        NJ.add(Pair.create("NE", 3));
        NJ.add(Pair.create("NH", 2));
        NJ.add(Pair.create("NJ", 0));
        NJ.add(Pair.create("NM", 4));
        NJ.add(Pair.create("NV", 5));
        NJ.add(Pair.create("NY", 1));
        NJ.add(Pair.create("OH", 2));
        NJ.add(Pair.create("OK", 4));
        NJ.add(Pair.create("OR", 5));
        NJ.add(Pair.create("PA", 1));
        NJ.add(Pair.create("PR", 5));
        NJ.add(Pair.create("RI", 1));
        NJ.add(Pair.create("SC", 2));
        NJ.add(Pair.create("SD", 4));
        NJ.add(Pair.create("TN", 2));
        NJ.add(Pair.create("TX", 4));
        NJ.add(Pair.create("UT", 5));
        NJ.add(Pair.create("VA", 2));
        NJ.add(Pair.create("VT", 1));
        NJ.add(Pair.create("WA", 5));
        NJ.add(Pair.create("WI", 3));
        NJ.add(Pair.create("WV", 2));
        NJ.add(Pair.create("WY", 5));

        return NJ;

    } // end method createNJZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for NM.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for NM.
     * @since 1.0
     */
    private List<Pair> createNMZoneTable() {

        List<Pair> NM = new ArrayList<>();

        NM.add(Pair.create("AK", 5));
        NM.add(Pair.create("AL", 3));
        NM.add(Pair.create("AR", 2));
        NM.add(Pair.create("AZ", 2));
        NM.add(Pair.create("CA", 3));
        NM.add(Pair.create("CO", 2));
        NM.add(Pair.create("CT", 5));
        NM.add(Pair.create("DC", 4));
        NM.add(Pair.create("DE", 4));
        NM.add(Pair.create("FL", 3));
        NM.add(Pair.create("GA", 3));
        NM.add(Pair.create("HI", 4));
        NM.add(Pair.create("IA", 3));
        NM.add(Pair.create("ID", 3));
        NM.add(Pair.create("IL", 3));
        NM.add(Pair.create("IN", 4));
        NM.add(Pair.create("KS", 3));
        NM.add(Pair.create("KY", 4));
        NM.add(Pair.create("LA", 2));
        NM.add(Pair.create("MA", 5));
        NM.add(Pair.create("MD", 4));
        NM.add(Pair.create("ME", 5));
        NM.add(Pair.create("MI", 4));
        NM.add(Pair.create("MN", 4));
        NM.add(Pair.create("MO", 3));
        NM.add(Pair.create("MS", 3));
        NM.add(Pair.create("MT", 3));
        NM.add(Pair.create("NC", 3));
        NM.add(Pair.create("ND", 4));
        NM.add(Pair.create("NE", 3));
        NM.add(Pair.create("NH", 5));
        NM.add(Pair.create("NJ", 4));
        NM.add(Pair.create("NM", 0));
        NM.add(Pair.create("NV", 3));
        NM.add(Pair.create("NY", 4));
        NM.add(Pair.create("OH", 4));
        NM.add(Pair.create("OK", 2));
        NM.add(Pair.create("OR", 3));
        NM.add(Pair.create("PA", 4));
        NM.add(Pair.create("PR", 5));
        NM.add(Pair.create("RI", 5));
        NM.add(Pair.create("SC", 3));
        NM.add(Pair.create("SD", 3));
        NM.add(Pair.create("TN", 3));
        NM.add(Pair.create("TX", 2));
        NM.add(Pair.create("UT", 2));
        NM.add(Pair.create("VA", 4));
        NM.add(Pair.create("VT", 5));
        NM.add(Pair.create("WA", 3));
        NM.add(Pair.create("WI", 4));
        NM.add(Pair.create("WV", 4));
        NM.add(Pair.create("WY", 3));

        return NM;

    } // end method createNMZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for NV.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for NV.
     * @since 1.0
     */
    private List<Pair> createNVZoneTable() {

        List<Pair> NV = new ArrayList<>();

        NV.add(Pair.create("AK", 4));
        NV.add(Pair.create("AL", 4));
        NV.add(Pair.create("AR", 4));
        NV.add(Pair.create("AZ", 2));
        NV.add(Pair.create("CA", 2));
        NV.add(Pair.create("CO", 2));
        NV.add(Pair.create("CT", 5));
        NV.add(Pair.create("DC", 5));
        NV.add(Pair.create("DE", 5));
        NV.add(Pair.create("FL", 4));
        NV.add(Pair.create("GA", 4));
        NV.add(Pair.create("HI", 3));
        NV.add(Pair.create("IA", 3));
        NV.add(Pair.create("ID", 1));
        NV.add(Pair.create("IL", 4));
        NV.add(Pair.create("IN", 4));
        NV.add(Pair.create("KS", 3));
        NV.add(Pair.create("KY", 4));
        NV.add(Pair.create("LA", 4));
        NV.add(Pair.create("MA", 5));
        NV.add(Pair.create("MD", 5));
        NV.add(Pair.create("ME", 5));
        NV.add(Pair.create("MI", 4));
        NV.add(Pair.create("MN", 4));
        NV.add(Pair.create("MO", 3));
        NV.add(Pair.create("MS", 4));
        NV.add(Pair.create("MT", 2));
        NV.add(Pair.create("NC", 4));
        NV.add(Pair.create("ND", 3));
        NV.add(Pair.create("NE", 3));
        NV.add(Pair.create("NH", 5));
        NV.add(Pair.create("NJ", 5));
        NV.add(Pair.create("NM", 2));
        NV.add(Pair.create("NV", 0));
        NV.add(Pair.create("NY", 5));
        NV.add(Pair.create("OH", 4));
        NV.add(Pair.create("OK", 3));
        NV.add(Pair.create("OR", 2));
        NV.add(Pair.create("PA", 5));
        NV.add(Pair.create("PR", 6));
        NV.add(Pair.create("RI", 5));
        NV.add(Pair.create("SC", 4));
        NV.add(Pair.create("SD", 3));
        NV.add(Pair.create("TN", 4));
        NV.add(Pair.create("TX", 3));
        NV.add(Pair.create("UT", 1));
        NV.add(Pair.create("VA", 5));
        NV.add(Pair.create("VT", 5));
        NV.add(Pair.create("WA", 2));
        NV.add(Pair.create("WI", 4));
        NV.add(Pair.create("WV", 5));
        NV.add(Pair.create("WY", 2));

        return NV;

    } // end method createNVZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for NY.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for NY.
     * @since 1.0
     */
    private List<Pair> createNYZoneTable() {

        List<Pair> NY = new ArrayList<>();

        NY.add(Pair.create("AK", 4));
        NY.add(Pair.create("AL", 3));
        NY.add(Pair.create("AR", 4));
        NY.add(Pair.create("AZ", 5));
        NY.add(Pair.create("CA", 5));
        NY.add(Pair.create("CO", 4));
        NY.add(Pair.create("CT", 1));
        NY.add(Pair.create("DC", 2));
        NY.add(Pair.create("DE", 1));
        NY.add(Pair.create("FL", 3));
        NY.add(Pair.create("GA", 3));
        NY.add(Pair.create("HI", 6));
        NY.add(Pair.create("IA", 3));
        NY.add(Pair.create("ID", 5));
        NY.add(Pair.create("IL", 2));
        NY.add(Pair.create("IN", 2));
        NY.add(Pair.create("KS", 3));
        NY.add(Pair.create("KY", 2));
        NY.add(Pair.create("LA", 4));
        NY.add(Pair.create("MA", 1));
        NY.add(Pair.create("MD", 2));
        NY.add(Pair.create("ME", 1));
        NY.add(Pair.create("MI", 2));
        NY.add(Pair.create("MN", 3));
        NY.add(Pair.create("MO", 3));
        NY.add(Pair.create("MS", 4));
        NY.add(Pair.create("MT", 5));
        NY.add(Pair.create("NC", 2));
        NY.add(Pair.create("ND", 4));
        NY.add(Pair.create("NE", 3));
        NY.add(Pair.create("NH", 1));
        NY.add(Pair.create("NJ", 1));
        NY.add(Pair.create("NM", 5));
        NY.add(Pair.create("NV", 5));
        NY.add(Pair.create("NY", 0));
        NY.add(Pair.create("OH", 2));
        NY.add(Pair.create("OK", 4));
        NY.add(Pair.create("OR", 5));
        NY.add(Pair.create("PA", 2));
        NY.add(Pair.create("PR", 5));
        NY.add(Pair.create("RI", 1));
        NY.add(Pair.create("SC", 2));
        NY.add(Pair.create("SD", 4));
        NY.add(Pair.create("TN", 3));
        NY.add(Pair.create("TX", 5));
        NY.add(Pair.create("UT", 5));
        NY.add(Pair.create("VA", 2));
        NY.add(Pair.create("VT", 1));
        NY.add(Pair.create("WA", 5));
        NY.add(Pair.create("WI", 2));
        NY.add(Pair.create("WV", 2));
        NY.add(Pair.create("WY", 5));

        return NY;

    } // end method createNYZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for OH.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for OH.
     * @since 1.0
     */
    private List<Pair> createOHZoneTable() {

        List<Pair> OH = new ArrayList<>();

        OH.add(Pair.create("AK", 4));
        OH.add(Pair.create("AL", 2));
        OH.add(Pair.create("AR", 3));
        OH.add(Pair.create("AZ", 4));
        OH.add(Pair.create("CA", 4));
        OH.add(Pair.create("CO", 3));
        OH.add(Pair.create("CT", 2));
        OH.add(Pair.create("DC", 2));
        OH.add(Pair.create("DE", 2));
        OH.add(Pair.create("FL", 3));
        OH.add(Pair.create("GA", 2));
        OH.add(Pair.create("HI", 5));
        OH.add(Pair.create("IA", 2));
        OH.add(Pair.create("ID", 4));
        OH.add(Pair.create("IL", 2));
        OH.add(Pair.create("IN", 1));
        OH.add(Pair.create("KS", 2));
        OH.add(Pair.create("KY", 1));
        OH.add(Pair.create("LA", 3));
        OH.add(Pair.create("MA", 2));
        OH.add(Pair.create("MD", 2));
        OH.add(Pair.create("ME", 3));
        OH.add(Pair.create("MI", 1));
        OH.add(Pair.create("MN", 2));
        OH.add(Pair.create("MO", 2));
        OH.add(Pair.create("MS", 3));
        OH.add(Pair.create("MT", 4));
        OH.add(Pair.create("NC", 2));
        OH.add(Pair.create("ND", 3));
        OH.add(Pair.create("NE", 3));
        OH.add(Pair.create("NH", 3));
        OH.add(Pair.create("NJ", 2));
        OH.add(Pair.create("NM", 4));
        OH.add(Pair.create("NV", 4));
        OH.add(Pair.create("NY", 2));
        OH.add(Pair.create("OH", 0));
        OH.add(Pair.create("OK", 3));
        OH.add(Pair.create("OR", 4));
        OH.add(Pair.create("PA", 2));
        OH.add(Pair.create("PR", 5));
        OH.add(Pair.create("RI", 2));
        OH.add(Pair.create("SC", 2));
        OH.add(Pair.create("SD", 3));
        OH.add(Pair.create("TN", 2));
        OH.add(Pair.create("TX", 4));
        OH.add(Pair.create("UT", 4));
        OH.add(Pair.create("VA", 2));
        OH.add(Pair.create("VT", 3));
        OH.add(Pair.create("WA", 4));
        OH.add(Pair.create("WI", 2));
        OH.add(Pair.create("WV", 2));
        OH.add(Pair.create("WY", 4));

        return OH;

    } // end method createOHZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for OK.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for OK.
     * @since 1.0
     */
    private List<Pair> createOKZoneTable() {

        List<Pair> OK = new ArrayList<>();

        OK.add(Pair.create("AK", 4));
        OK.add(Pair.create("AL", 3));
        OK.add(Pair.create("AR", 2));
        OK.add(Pair.create("AZ", 3));
        OK.add(Pair.create("CA", 4));
        OK.add(Pair.create("CO", 2));
        OK.add(Pair.create("CT", 4));
        OK.add(Pair.create("DC", 3));
        OK.add(Pair.create("DE", 3));
        OK.add(Pair.create("FL", 3));
        OK.add(Pair.create("GA", 3));
        OK.add(Pair.create("HI", 5));
        OK.add(Pair.create("IA", 2));
        OK.add(Pair.create("ID", 3));
        OK.add(Pair.create("IL", 2));
        OK.add(Pair.create("IN", 3));
        OK.add(Pair.create("KS", 2));
        OK.add(Pair.create("KY", 2));
        OK.add(Pair.create("LA", 2));
        OK.add(Pair.create("MA", 4));
        OK.add(Pair.create("MD", 3));
        OK.add(Pair.create("ME", 4));
        OK.add(Pair.create("MI", 3));
        OK.add(Pair.create("MN", 3));
        OK.add(Pair.create("MO", 2));
        OK.add(Pair.create("MS", 2));
        OK.add(Pair.create("MT", 3));
        OK.add(Pair.create("NC", 3));
        OK.add(Pair.create("ND", 3));
        OK.add(Pair.create("NE", 2));
        OK.add(Pair.create("NH", 4));
        OK.add(Pair.create("NJ", 4));
        OK.add(Pair.create("NM", 2));
        OK.add(Pair.create("NV", 4));
        OK.add(Pair.create("NY", 3));
        OK.add(Pair.create("OH", 3));
        OK.add(Pair.create("OK", 0));
        OK.add(Pair.create("OR", 4));
        OK.add(Pair.create("PA", 3));
        OK.add(Pair.create("PR", 5));
        OK.add(Pair.create("RI", 4));
        OK.add(Pair.create("SC", 3));
        OK.add(Pair.create("SD", 3));
        OK.add(Pair.create("TN", 2));
        OK.add(Pair.create("TX", 2));
        OK.add(Pair.create("UT", 3));
        OK.add(Pair.create("VA", 3));
        OK.add(Pair.create("VT", 4));
        OK.add(Pair.create("WA", 4));
        OK.add(Pair.create("WI", 3));
        OK.add(Pair.create("WV", 3));
        OK.add(Pair.create("WY", 3));

        return OK;

    } // end method createOKZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for OR.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for OR.
     * @since 1.0
     */
    private List<Pair> createORZoneTable() {

        List<Pair> OR = new ArrayList<>();

        OR.add(Pair.create("AK", 4));
        OR.add(Pair.create("AL", 5));
        OR.add(Pair.create("AR", 5));
        OR.add(Pair.create("AZ", 3));
        OR.add(Pair.create("CA", 2));
        OR.add(Pair.create("CO", 3));
        OR.add(Pair.create("CT", 5));
        OR.add(Pair.create("DC", 5));
        OR.add(Pair.create("DE", 5));
        OR.add(Pair.create("FL", 5));
        OR.add(Pair.create("GA", 5));
        OR.add(Pair.create("HI", 3));
        OR.add(Pair.create("IA", 4));
        OR.add(Pair.create("ID", 2));
        OR.add(Pair.create("IL", 4));
        OR.add(Pair.create("IN", 5));
        OR.add(Pair.create("KS", 4));
        OR.add(Pair.create("KY", 5));
        OR.add(Pair.create("LA", 5));
        OR.add(Pair.create("MA", 5));
        OR.add(Pair.create("MD", 5));
        OR.add(Pair.create("ME", 5));
        OR.add(Pair.create("MI", 5));
        OR.add(Pair.create("MN", 4));
        OR.add(Pair.create("MO", 4));
        OR.add(Pair.create("MS", 5));
        OR.add(Pair.create("MT", 2));
        OR.add(Pair.create("NC", 5));
        OR.add(Pair.create("ND", 3));
        OR.add(Pair.create("NE", 4));
        OR.add(Pair.create("NH", 5));
        OR.add(Pair.create("NJ", 5));
        OR.add(Pair.create("NM", 4));
        OR.add(Pair.create("NV", 2));
        OR.add(Pair.create("NY", 5));
        OR.add(Pair.create("OH", 5));
        OR.add(Pair.create("OK", 4));
        OR.add(Pair.create("OR", 0));
        OR.add(Pair.create("PA", 5));
        OR.add(Pair.create("PR", 7));
        OR.add(Pair.create("RI", 5));
        OR.add(Pair.create("SC", 5));
        OR.add(Pair.create("SD", 4));
        OR.add(Pair.create("TN", 5));
        OR.add(Pair.create("TX", 4));
        OR.add(Pair.create("UT", 2));
        OR.add(Pair.create("VA", 5));
        OR.add(Pair.create("VT", 5));
        OR.add(Pair.create("WA", 2));
        OR.add(Pair.create("WI", 4));
        OR.add(Pair.create("WV", 5));
        OR.add(Pair.create("WY", 3));

        return OR;

    } // end method createORZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for PA.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for PA.
     * @since 1.0
     */
    private List<Pair> createPAZoneTable() {

        List<Pair> PA = new ArrayList<>();

        PA.add(Pair.create("AK", 4));
        PA.add(Pair.create("AL", 2));
        PA.add(Pair.create("AR", 4));
        PA.add(Pair.create("AZ", 5));
        PA.add(Pair.create("CA", 5));
        PA.add(Pair.create("CO", 4));
        PA.add(Pair.create("CT", 1));
        PA.add(Pair.create("DC", 1));
        PA.add(Pair.create("DE", 1));
        PA.add(Pair.create("FL", 2));
        PA.add(Pair.create("GA", 2));
        PA.add(Pair.create("HI", 5));
        PA.add(Pair.create("IA", 3));
        PA.add(Pair.create("ID", 5));
        PA.add(Pair.create("IL", 3));
        PA.add(Pair.create("IN", 2));
        PA.add(Pair.create("KS", 4));
        PA.add(Pair.create("KY", 2));
        PA.add(Pair.create("LA", 4));
        PA.add(Pair.create("MA", 2));
        PA.add(Pair.create("MD", 1));
        PA.add(Pair.create("ME", 2));
        PA.add(Pair.create("MI", 2));
        PA.add(Pair.create("MN", 3));
        PA.add(Pair.create("MO", 3));
        PA.add(Pair.create("MS", 4));
        PA.add(Pair.create("MT", 5));
        PA.add(Pair.create("NC", 2));
        PA.add(Pair.create("ND", 4));
        PA.add(Pair.create("NE", 4));
        PA.add(Pair.create("NH", 2));
        PA.add(Pair.create("NJ", 1));
        PA.add(Pair.create("NM", 5));
        PA.add(Pair.create("NV", 5));
        PA.add(Pair.create("NY", 2));
        PA.add(Pair.create("OH", 1));
        PA.add(Pair.create("OK", 4));
        PA.add(Pair.create("OR", 5));
        PA.add(Pair.create("PA", 0));
        PA.add(Pair.create("PR", 4));
        PA.add(Pair.create("RI", 2));
        PA.add(Pair.create("SC", 2));
        PA.add(Pair.create("SD", 4));
        PA.add(Pair.create("TN", 2));
        PA.add(Pair.create("TX", 4));
        PA.add(Pair.create("UT", 5));
        PA.add(Pair.create("VA", 1));
        PA.add(Pair.create("VT", 2));
        PA.add(Pair.create("WA", 5));
        PA.add(Pair.create("WI", 3));
        PA.add(Pair.create("WV", 1));
        PA.add(Pair.create("WY", 4));

        return PA;

    } // end method createPAZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for PR.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for PR.
     * @since 1.0
     */
    private List<Pair> createPRZoneTable() {

        List<Pair> PR = new ArrayList<>();

        PR.add(Pair.create("AK", 4));
        PR.add(Pair.create("AL", 3));
        PR.add(Pair.create("AR", 3));
        PR.add(Pair.create("AZ", 5));
        PR.add(Pair.create("CA", 5));
        PR.add(Pair.create("CO", 4));
        PR.add(Pair.create("CT", 4));
        PR.add(Pair.create("DC", 3));
        PR.add(Pair.create("DE", 3));
        PR.add(Pair.create("FL", 3));
        PR.add(Pair.create("GA", 3));
        PR.add(Pair.create("HI", 6));
        PR.add(Pair.create("IA", 3));
        PR.add(Pair.create("ID", 5));
        PR.add(Pair.create("IL", 2));
        PR.add(Pair.create("IN", 2));
        PR.add(Pair.create("KS", 3));
        PR.add(Pair.create("KY", 2));
        PR.add(Pair.create("LA", 3));
        PR.add(Pair.create("MA", 4));
        PR.add(Pair.create("MD", 3));
        PR.add(Pair.create("ME", 4));
        PR.add(Pair.create("MI", 3));
        PR.add(Pair.create("MN", 3));
        PR.add(Pair.create("MO", 3));
        PR.add(Pair.create("MS", 3));
        PR.add(Pair.create("MT", 5));
        PR.add(Pair.create("NC", 3));
        PR.add(Pair.create("ND", 4));
        PR.add(Pair.create("NE", 4));
        PR.add(Pair.create("NH", 4));
        PR.add(Pair.create("NJ", 3));
        PR.add(Pair.create("NM", 5));
        PR.add(Pair.create("NV", 5));
        PR.add(Pair.create("NY", 3));
        PR.add(Pair.create("OH", 3));
        PR.add(Pair.create("OK", 3));
        PR.add(Pair.create("OR", 5));
        PR.add(Pair.create("PA", 3));
        PR.add(Pair.create("PR", 0));
        PR.add(Pair.create("RI", 4));
        PR.add(Pair.create("SC", 3));
        PR.add(Pair.create("SD", 4));
        PR.add(Pair.create("TN", 2));
        PR.add(Pair.create("TX", 4));
        PR.add(Pair.create("UT", 5));
        PR.add(Pair.create("VA", 3));
        PR.add(Pair.create("VT", 4));
        PR.add(Pair.create("WA", 5));
        PR.add(Pair.create("WI", 3));
        PR.add(Pair.create("WV", 3));
        PR.add(Pair.create("WY", 5));

        return PR;

    } // end method createPRZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for RI.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for RI.
     * @since 1.0
     */
    private List<Pair> createRIZoneTable() {

        List<Pair> RI = new ArrayList<>();

        RI.add(Pair.create("AK", 4));
        RI.add(Pair.create("AL", 3));
        RI.add(Pair.create("AR", 4));
        RI.add(Pair.create("AZ", 5));
        RI.add(Pair.create("CA", 5));
        RI.add(Pair.create("CO", 4));
        RI.add(Pair.create("CT", 1));
        RI.add(Pair.create("DC", 2));
        RI.add(Pair.create("DE", 2));
        RI.add(Pair.create("FL", 3));
        RI.add(Pair.create("GA", 3));
        RI.add(Pair.create("HI", 5));
        RI.add(Pair.create("IA", 3));
        RI.add(Pair.create("ID", 5));
        RI.add(Pair.create("IL", 3));
        RI.add(Pair.create("IN", 2));
        RI.add(Pair.create("KS", 3));
        RI.add(Pair.create("KY", 2));
        RI.add(Pair.create("LA", 4));
        RI.add(Pair.create("MA", 1));
        RI.add(Pair.create("MD", 2));
        RI.add(Pair.create("ME", 1));
        RI.add(Pair.create("MI", 3));
        RI.add(Pair.create("MN", 3));
        RI.add(Pair.create("MO", 3));
        RI.add(Pair.create("MS", 4));
        RI.add(Pair.create("MT", 5));
        RI.add(Pair.create("NC", 2));
        RI.add(Pair.create("ND", 4));
        RI.add(Pair.create("NE", 4));
        RI.add(Pair.create("NH", 1));
        RI.add(Pair.create("NJ", 1));
        RI.add(Pair.create("NM", 5));
        RI.add(Pair.create("NV", 5));
        RI.add(Pair.create("NY", 2));
        RI.add(Pair.create("OH", 2));
        RI.add(Pair.create("OK", 4));
        RI.add(Pair.create("OR", 4));
        RI.add(Pair.create("PA", 2));
        RI.add(Pair.create("PR", 5));
        RI.add(Pair.create("RI", 0));
        RI.add(Pair.create("SC", 2));
        RI.add(Pair.create("SD", 4));
        RI.add(Pair.create("TN", 3));
        RI.add(Pair.create("TX", 4));
        RI.add(Pair.create("UT", 5));
        RI.add(Pair.create("VA", 2));
        RI.add(Pair.create("VT", 1));
        RI.add(Pair.create("WA", 5));
        RI.add(Pair.create("WI", 3));
        RI.add(Pair.create("WV", 2));
        RI.add(Pair.create("WY", 5));

        return RI;

    } // end method createRIZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for SC.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for SC.
     * @since 1.0
     */
    private List<Pair> createSCZoneTable() {

        List<Pair> SC = new ArrayList<>();

        SC.add(Pair.create("AK", 3));
        SC.add(Pair.create("AL", 2));
        SC.add(Pair.create("AR", 3));
        SC.add(Pair.create("AZ", 4));
        SC.add(Pair.create("CA", 5));
        SC.add(Pair.create("CO", 4));
        SC.add(Pair.create("CT", 2));
        SC.add(Pair.create("DC", 2));
        SC.add(Pair.create("DE", 2));
        SC.add(Pair.create("FL", 2));
        SC.add(Pair.create("GA", 1));
        SC.add(Pair.create("HI", 6));
        SC.add(Pair.create("IA", 3));
        SC.add(Pair.create("ID", 5));
        SC.add(Pair.create("IL", 3));
        SC.add(Pair.create("IN", 2));
        SC.add(Pair.create("KS", 3));
        SC.add(Pair.create("KY", 2));
        SC.add(Pair.create("LA", 2));
        SC.add(Pair.create("MA", 3));
        SC.add(Pair.create("MD", 2));
        SC.add(Pair.create("ME", 3));
        SC.add(Pair.create("MI", 2));
        SC.add(Pair.create("MN", 3));
        SC.add(Pair.create("MO", 3));
        SC.add(Pair.create("MS", 2));
        SC.add(Pair.create("MT", 5));
        SC.add(Pair.create("NC", 2));
        SC.add(Pair.create("ND", 4));
        SC.add(Pair.create("NE", 4));
        SC.add(Pair.create("NH", 3));
        SC.add(Pair.create("NJ", 2));
        SC.add(Pair.create("NM", 4));
        SC.add(Pair.create("NV", 5));
        SC.add(Pair.create("NY", 3));
        SC.add(Pair.create("OH", 2));
        SC.add(Pair.create("OK", 3));
        SC.add(Pair.create("OR", 5));
        SC.add(Pair.create("PA", 2));
        SC.add(Pair.create("PR", 4));
        SC.add(Pair.create("RI", 3));
        SC.add(Pair.create("SC", 0));
        SC.add(Pair.create("SD", 4));
        SC.add(Pair.create("TN", 2));
        SC.add(Pair.create("TX", 3));
        SC.add(Pair.create("UT", 5));
        SC.add(Pair.create("VA", 2));
        SC.add(Pair.create("VT", 3));
        SC.add(Pair.create("WA", 5));
        SC.add(Pair.create("WI", 3));
        SC.add(Pair.create("WV", 2));
        SC.add(Pair.create("WY", 5));

        return SC;

    } // end method createSCZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for SD.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for SD.
     * @since 1.0
     */
    private List<Pair> createSDZoneTable() {

        List<Pair> SD = new ArrayList<>();

        SD.add(Pair.create("AK", 6));
        SD.add(Pair.create("AL", 4));
        SD.add(Pair.create("AR", 3));
        SD.add(Pair.create("AZ", 4));
        SD.add(Pair.create("CA", 4));
        SD.add(Pair.create("CO", 2));
        SD.add(Pair.create("CT", 5));
        SD.add(Pair.create("DC", 3));
        SD.add(Pair.create("DE", 3));
        SD.add(Pair.create("FL", 4));
        SD.add(Pair.create("GA", 3));
        SD.add(Pair.create("HI", 5));
        SD.add(Pair.create("IA", 2));
        SD.add(Pair.create("ID", 3));
        SD.add(Pair.create("IL", 2));
        SD.add(Pair.create("IN", 2));
        SD.add(Pair.create("KS", 2));
        SD.add(Pair.create("KY", 3));
        SD.add(Pair.create("LA", 3));
        SD.add(Pair.create("MA", 4));
        SD.add(Pair.create("MD", 3));
        SD.add(Pair.create("ME", 4));
        SD.add(Pair.create("MI", 2));
        SD.add(Pair.create("MN", 1));
        SD.add(Pair.create("MO", 2));
        SD.add(Pair.create("MS", 3));
        SD.add(Pair.create("MT", 3));
        SD.add(Pair.create("NC", 3));
        SD.add(Pair.create("ND", 1));
        SD.add(Pair.create("NE", 1));
        SD.add(Pair.create("NH", 4));
        SD.add(Pair.create("NJ", 3));
        SD.add(Pair.create("NM", 3));
        SD.add(Pair.create("NV", 3));
        SD.add(Pair.create("NY", 3));
        SD.add(Pair.create("OH", 3));
        SD.add(Pair.create("OK", 2));
        SD.add(Pair.create("OR", 4));
        SD.add(Pair.create("PA", 3));
        SD.add(Pair.create("PR", 6));
        SD.add(Pair.create("RI", 4));
        SD.add(Pair.create("SC", 3));
        SD.add(Pair.create("SD", 0));
        SD.add(Pair.create("TN", 3));
        SD.add(Pair.create("TX", 3));
        SD.add(Pair.create("UT", 3));
        SD.add(Pair.create("VA", 3));
        SD.add(Pair.create("VT", 4));
        SD.add(Pair.create("WA", 4));
        SD.add(Pair.create("WI", 2));
        SD.add(Pair.create("WV", 3));
        SD.add(Pair.create("WY", 2));

        return SD;

    } // end method createSDZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for TN.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for TN.
     * @since 1.0
     */
    private List<Pair> createTNZoneTable() {

        List<Pair> TN = new ArrayList<>();

        TN.add(Pair.create("AK", 3));
        TN.add(Pair.create("AL", 2));
        TN.add(Pair.create("AR", 2));
        TN.add(Pair.create("AZ", 4));
        TN.add(Pair.create("CA", 4));
        TN.add(Pair.create("CO", 3));
        TN.add(Pair.create("CT", 3));
        TN.add(Pair.create("DC", 2));
        TN.add(Pair.create("DE", 2));
        TN.add(Pair.create("FL", 2));
        TN.add(Pair.create("GA", 2));
        TN.add(Pair.create("HI", 6));
        TN.add(Pair.create("IA", 2));
        TN.add(Pair.create("ID", 5));
        TN.add(Pair.create("IL", 2));
        TN.add(Pair.create("IN", 2));
        TN.add(Pair.create("KS", 2));
        TN.add(Pair.create("KY", 1));
        TN.add(Pair.create("LA", 2));
        TN.add(Pair.create("MA", 3));
        TN.add(Pair.create("MD", 2));
        TN.add(Pair.create("ME", 3));
        TN.add(Pair.create("MI", 2));
        TN.add(Pair.create("MN", 3));
        TN.add(Pair.create("MO", 2));
        TN.add(Pair.create("MS", 2));
        TN.add(Pair.create("MT", 5));
        TN.add(Pair.create("NC", 2));
        TN.add(Pair.create("ND", 3));
        TN.add(Pair.create("NE", 3));
        TN.add(Pair.create("NH", 3));
        TN.add(Pair.create("NJ", 2));
        TN.add(Pair.create("NM", 3));
        TN.add(Pair.create("NV", 5));
        TN.add(Pair.create("NY", 3));
        TN.add(Pair.create("OH", 2));
        TN.add(Pair.create("OK", 2));
        TN.add(Pair.create("OR", 5));
        TN.add(Pair.create("PA", 2));
        TN.add(Pair.create("PR", 4));
        TN.add(Pair.create("RI", 3));
        TN.add(Pair.create("SC", 2));
        TN.add(Pair.create("SD", 3));
        TN.add(Pair.create("TN", 0));
        TN.add(Pair.create("TX", 3));
        TN.add(Pair.create("UT", 5));
        TN.add(Pair.create("VA", 2));
        TN.add(Pair.create("VT", 3));
        TN.add(Pair.create("WA", 5));
        TN.add(Pair.create("WI", 2));
        TN.add(Pair.create("WV", 2));
        TN.add(Pair.create("WY", 4));

        return TN;

    } // end method createTNZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for TX.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for TX.
     * @since 1.0
     */
    private List<Pair> createTXZoneTable() {

        List<Pair> TX = new ArrayList<>();

        TX.add(Pair.create("AK", 4));
        TX.add(Pair.create("AL", 2));
        TX.add(Pair.create("AR", 2));
        TX.add(Pair.create("AZ", 3));
        TX.add(Pair.create("CA", 4));
        TX.add(Pair.create("CO", 2));
        TX.add(Pair.create("CT", 4));
        TX.add(Pair.create("DC", 3));
        TX.add(Pair.create("DE", 3));
        TX.add(Pair.create("FL", 3));
        TX.add(Pair.create("GA", 3));
        TX.add(Pair.create("HI", 4));
        TX.add(Pair.create("IA", 3));
        TX.add(Pair.create("ID", 4));
        TX.add(Pair.create("IL", 2));
        TX.add(Pair.create("IN", 3));
        TX.add(Pair.create("KS", 2));
        TX.add(Pair.create("KY", 3));
        TX.add(Pair.create("LA", 2));
        TX.add(Pair.create("MA", 4));
        TX.add(Pair.create("MD", 3));
        TX.add(Pair.create("ME", 4));
        TX.add(Pair.create("MI", 3));
        TX.add(Pair.create("MN", 3));
        TX.add(Pair.create("MO", 2));
        TX.add(Pair.create("MS", 2));
        TX.add(Pair.create("MT", 3));
        TX.add(Pair.create("NC", 3));
        TX.add(Pair.create("ND", 3));
        TX.add(Pair.create("NE", 3));
        TX.add(Pair.create("NH", 4));
        TX.add(Pair.create("NJ", 3));
        TX.add(Pair.create("NM", 2));
        TX.add(Pair.create("NV", 4));
        TX.add(Pair.create("NY", 4));
        TX.add(Pair.create("OH", 3));
        TX.add(Pair.create("OK", 2));
        TX.add(Pair.create("OR", 4));
        TX.add(Pair.create("PA", 3));
        TX.add(Pair.create("PR", 5));
        TX.add(Pair.create("RI", 4));
        TX.add(Pair.create("SC", 3));
        TX.add(Pair.create("SD", 3));
        TX.add(Pair.create("TN", 2));
        TX.add(Pair.create("TX", 0));
        TX.add(Pair.create("UT", 3));
        TX.add(Pair.create("VA", 3));
        TX.add(Pair.create("VT", 4));
        TX.add(Pair.create("WA", 4));
        TX.add(Pair.create("WI", 3));
        TX.add(Pair.create("WV", 3));
        TX.add(Pair.create("WY", 3));

        return TX;

    } // end method createTXZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for UT.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for UT.
     * @since 1.0
     */
    private List<Pair> createUTZoneTable() {

        List<Pair> UT = new ArrayList<>();

        UT.add(Pair.create("AK", 4));
        UT.add(Pair.create("AL", 4));
        UT.add(Pair.create("AR", 4));
        UT.add(Pair.create("AZ", 2));
        UT.add(Pair.create("CA", 2));
        UT.add(Pair.create("CO", 2));
        UT.add(Pair.create("CT", 5));
        UT.add(Pair.create("DC", 5));
        UT.add(Pair.create("DE", 5));
        UT.add(Pair.create("FL", 4));
        UT.add(Pair.create("GA", 4));
        UT.add(Pair.create("HI", 3));
        UT.add(Pair.create("IA", 3));
        UT.add(Pair.create("ID", 1));
        UT.add(Pair.create("IL", 4));
        UT.add(Pair.create("IN", 4));
        UT.add(Pair.create("KS", 3));
        UT.add(Pair.create("KY", 4));
        UT.add(Pair.create("LA", 4));
        UT.add(Pair.create("MA", 5));
        UT.add(Pair.create("MD", 5));
        UT.add(Pair.create("ME", 5));
        UT.add(Pair.create("MI", 4));
        UT.add(Pair.create("MN", 4));
        UT.add(Pair.create("MO", 3));
        UT.add(Pair.create("MS", 4));
        UT.add(Pair.create("MT", 2));
        UT.add(Pair.create("NC", 4));
        UT.add(Pair.create("ND", 3));
        UT.add(Pair.create("NE", 3));
        UT.add(Pair.create("NH", 5));
        UT.add(Pair.create("NJ", 5));
        UT.add(Pair.create("NM", 2));
        UT.add(Pair.create("NV", 2));
        UT.add(Pair.create("NY", 5));
        UT.add(Pair.create("OH", 4));
        UT.add(Pair.create("OK", 3));
        UT.add(Pair.create("OR", 2));
        UT.add(Pair.create("PA", 5));
        UT.add(Pair.create("PR", 6));
        UT.add(Pair.create("RI", 5));
        UT.add(Pair.create("SC", 4));
        UT.add(Pair.create("SD", 3));
        UT.add(Pair.create("TN", 4));
        UT.add(Pair.create("TX", 3));
        UT.add(Pair.create("UT", 0));
        UT.add(Pair.create("VA", 5));
        UT.add(Pair.create("VT", 5));
        UT.add(Pair.create("WA", 2));
        UT.add(Pair.create("WI", 4));
        UT.add(Pair.create("WV", 5));
        UT.add(Pair.create("WY", 2));

        return UT;

    } // end method createUTZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for VA.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for VA.
     * @since 1.0
     */
    private List<Pair> createVAZoneTable() {

        List<Pair> VA = new ArrayList<>();

        VA.add(Pair.create("AK", 4));
        VA.add(Pair.create("AL", 2));
        VA.add(Pair.create("AR", 3));
        VA.add(Pair.create("AZ", 5));
        VA.add(Pair.create("CA", 5));
        VA.add(Pair.create("CO", 4));
        VA.add(Pair.create("CT", 2));
        VA.add(Pair.create("DC", 1));
        VA.add(Pair.create("DE", 1));
        VA.add(Pair.create("FL", 2));
        VA.add(Pair.create("GA", 2));
        VA.add(Pair.create("HI", 6));
        VA.add(Pair.create("IA", 3));
        VA.add(Pair.create("ID", 5));
        VA.add(Pair.create("IL", 3));
        VA.add(Pair.create("IN", 2));
        VA.add(Pair.create("KS", 3));
        VA.add(Pair.create("KY", 2));
        VA.add(Pair.create("LA", 3));
        VA.add(Pair.create("MA", 2));
        VA.add(Pair.create("MD", 1));
        VA.add(Pair.create("ME", 2));
        VA.add(Pair.create("MI", 2));
        VA.add(Pair.create("MN", 4));
        VA.add(Pair.create("MO", 3));
        VA.add(Pair.create("MS", 3));
        VA.add(Pair.create("MT", 5));
        VA.add(Pair.create("NC", 1));
        VA.add(Pair.create("ND", 4));
        VA.add(Pair.create("NE", 4));
        VA.add(Pair.create("NH", 2));
        VA.add(Pair.create("NJ", 2));
        VA.add(Pair.create("NM", 5));
        VA.add(Pair.create("NV", 5));
        VA.add(Pair.create("NY", 2));
        VA.add(Pair.create("OH", 2));
        VA.add(Pair.create("OK", 4));
        VA.add(Pair.create("OR", 5));
        VA.add(Pair.create("PA", 2));
        VA.add(Pair.create("PR", 4));
        VA.add(Pair.create("RI", 2));
        VA.add(Pair.create("SC", 2));
        VA.add(Pair.create("SD", 4));
        VA.add(Pair.create("TN", 2));
        VA.add(Pair.create("TX", 5));
        VA.add(Pair.create("UT", 5));
        VA.add(Pair.create("VA", 0));
        VA.add(Pair.create("VT", 2));
        VA.add(Pair.create("WA", 5));
        VA.add(Pair.create("WI", 3));
        VA.add(Pair.create("WV", 1));
        VA.add(Pair.create("WY", 5));

        return VA;

    } // end method createVAZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for VT.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for VT.
     * @since 1.0
     */
    private List<Pair> createVTZoneTable() {

        List<Pair> VT = new ArrayList<>();

        VT.add(Pair.create("AK", 5));
        VT.add(Pair.create("AL", 3));
        VT.add(Pair.create("AR", 4));
        VT.add(Pair.create("AZ", 5));
        VT.add(Pair.create("CA", 5));
        VT.add(Pair.create("CO", 4));
        VT.add(Pair.create("CT", 1));
        VT.add(Pair.create("DC", 2));
        VT.add(Pair.create("DE", 2));
        VT.add(Pair.create("FL", 4));
        VT.add(Pair.create("GA", 3));
        VT.add(Pair.create("HI", 6));
        VT.add(Pair.create("IA", 3));
        VT.add(Pair.create("ID", 5));
        VT.add(Pair.create("IL", 3));
        VT.add(Pair.create("IN", 3));
        VT.add(Pair.create("KS", 4));
        VT.add(Pair.create("KY", 3));
        VT.add(Pair.create("LA", 4));
        VT.add(Pair.create("MA", 1));
        VT.add(Pair.create("MD", 2));
        VT.add(Pair.create("ME", 1));
        VT.add(Pair.create("MI", 3));
        VT.add(Pair.create("MN", 3));
        VT.add(Pair.create("MO", 3));
        VT.add(Pair.create("MS", 4));
        VT.add(Pair.create("MT", 5));
        VT.add(Pair.create("NC", 3));
        VT.add(Pair.create("ND", 4));
        VT.add(Pair.create("NE", 4));
        VT.add(Pair.create("NH", 1));
        VT.add(Pair.create("NJ", 2));
        VT.add(Pair.create("NM", 5));
        VT.add(Pair.create("NV", 5));
        VT.add(Pair.create("NY", 1));
        VT.add(Pair.create("OH", 2));
        VT.add(Pair.create("OK", 4));
        VT.add(Pair.create("OR", 5));
        VT.add(Pair.create("PA", 2));
        VT.add(Pair.create("PR", 5));
        VT.add(Pair.create("RI", 1));
        VT.add(Pair.create("SC", 3));
        VT.add(Pair.create("SD", 4));
        VT.add(Pair.create("TN", 3));
        VT.add(Pair.create("TX", 5));
        VT.add(Pair.create("UT", 5));
        VT.add(Pair.create("VA", 2));
        VT.add(Pair.create("VT", 0));
        VT.add(Pair.create("WA", 5));
        VT.add(Pair.create("WI", 3));
        VT.add(Pair.create("WV", 2));
        VT.add(Pair.create("WY", 5));

        return VT;

    } // end method createVTZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for WA.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for WA.
     * @since 1.0
     */
    private List<Pair> createWAZoneTable() {

        List<Pair> WA = new ArrayList<>();

        WA.add(Pair.create("AK", 4));
        WA.add(Pair.create("AL", 5));
        WA.add(Pair.create("AR", 5));
        WA.add(Pair.create("AZ", 3));
        WA.add(Pair.create("CA", 2));
        WA.add(Pair.create("CO", 3));
        WA.add(Pair.create("CT", 5));
        WA.add(Pair.create("DC", 5));
        WA.add(Pair.create("DE", 5));
        WA.add(Pair.create("FL", 5));
        WA.add(Pair.create("GA", 5));
        WA.add(Pair.create("HI", 3));
        WA.add(Pair.create("IA", 4));
        WA.add(Pair.create("ID", 2));
        WA.add(Pair.create("IL", 4));
        WA.add(Pair.create("IN", 5));
        WA.add(Pair.create("KS", 4));
        WA.add(Pair.create("KY", 5));
        WA.add(Pair.create("LA", 5));
        WA.add(Pair.create("MA", 5));
        WA.add(Pair.create("MD", 5));
        WA.add(Pair.create("ME", 5));
        WA.add(Pair.create("MI", 5));
        WA.add(Pair.create("MN", 4));
        WA.add(Pair.create("MO", 4));
        WA.add(Pair.create("MS", 5));
        WA.add(Pair.create("MT", 2));
        WA.add(Pair.create("NC", 5));
        WA.add(Pair.create("ND", 3));
        WA.add(Pair.create("NE", 4));
        WA.add(Pair.create("NH", 5));
        WA.add(Pair.create("NJ", 5));
        WA.add(Pair.create("NM", 4));
        WA.add(Pair.create("NV", 2));
        WA.add(Pair.create("NY", 5));
        WA.add(Pair.create("OH", 5));
        WA.add(Pair.create("OK", 4));
        WA.add(Pair.create("OR", 1));
        WA.add(Pair.create("PA", 5));
        WA.add(Pair.create("PR", 7));
        WA.add(Pair.create("RI", 5));
        WA.add(Pair.create("SC", 5));
        WA.add(Pair.create("SD", 4));
        WA.add(Pair.create("TN", 5));
        WA.add(Pair.create("TX", 5));
        WA.add(Pair.create("UT", 2));
        WA.add(Pair.create("VA", 5));
        WA.add(Pair.create("VT", 5));
        WA.add(Pair.create("WA", 0));
        WA.add(Pair.create("WI", 4));
        WA.add(Pair.create("WV", 5));
        WA.add(Pair.create("WY", 3));

        return WA;

    } // end method createWAZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for WI.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for WI.
     * @since 1.0
     */
    private List<Pair> createWIZoneTable() {

        List<Pair> WI = new ArrayList<>();

        WI.add(Pair.create("AK", 4));
        WI.add(Pair.create("AL", 3));
        WI.add(Pair.create("AR", 3));
        WI.add(Pair.create("AZ", 4));
        WI.add(Pair.create("CA", 4));
        WI.add(Pair.create("CO", 3));
        WI.add(Pair.create("CT", 3));
        WI.add(Pair.create("DC", 3));
        WI.add(Pair.create("DE", 3));
        WI.add(Pair.create("FL", 3));
        WI.add(Pair.create("GA", 2));
        WI.add(Pair.create("HI", 5));
        WI.add(Pair.create("IA", 2));
        WI.add(Pair.create("ID", 4));
        WI.add(Pair.create("IL", 1));
        WI.add(Pair.create("IN", 1));
        WI.add(Pair.create("KS", 2));
        WI.add(Pair.create("KY", 2));
        WI.add(Pair.create("LA", 3));
        WI.add(Pair.create("MA", 3));
        WI.add(Pair.create("MD", 3));
        WI.add(Pair.create("ME", 3));
        WI.add(Pair.create("MI", 2));
        WI.add(Pair.create("MN", 2));
        WI.add(Pair.create("MO", 2));
        WI.add(Pair.create("MS", 3));
        WI.add(Pair.create("MT", 4));
        WI.add(Pair.create("NC", 3));
        WI.add(Pair.create("ND", 3));
        WI.add(Pair.create("NE", 2));
        WI.add(Pair.create("NH", 3));
        WI.add(Pair.create("NJ", 3));
        WI.add(Pair.create("NM", 4));
        WI.add(Pair.create("NV", 4));
        WI.add(Pair.create("NY", 2));
        WI.add(Pair.create("OH", 2));
        WI.add(Pair.create("OK", 3));
        WI.add(Pair.create("OR", 4));
        WI.add(Pair.create("PA", 2));
        WI.add(Pair.create("PR", 4));
        WI.add(Pair.create("RI", 3));
        WI.add(Pair.create("SC", 3));
        WI.add(Pair.create("SD", 3));
        WI.add(Pair.create("TN", 2));
        WI.add(Pair.create("TX", 4));
        WI.add(Pair.create("UT", 4));
        WI.add(Pair.create("VA", 3));
        WI.add(Pair.create("VT", 3));
        WI.add(Pair.create("WA", 4));
        WI.add(Pair.create("WI", 0));
        WI.add(Pair.create("WV", 2));
        WI.add(Pair.create("WY", 4));

        return WI;

    } // end method createWIZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for WV.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for WV.
     * @since 1.0
     */
    private List<Pair> createWVZoneTable() {

        List<Pair> WV = new ArrayList<>();

        WV.add(Pair.create("AK", 3));
        WV.add(Pair.create("AL", 2));
        WV.add(Pair.create("AR", 2));
        WV.add(Pair.create("AZ", 4));
        WV.add(Pair.create("CA", 5));
        WV.add(Pair.create("CO", 3));
        WV.add(Pair.create("CT", 2));
        WV.add(Pair.create("DC", 2));
        WV.add(Pair.create("DE", 2));
        WV.add(Pair.create("FL", 2));
        WV.add(Pair.create("GA", 2));
        WV.add(Pair.create("HI", 5));
        WV.add(Pair.create("IA", 2));
        WV.add(Pair.create("ID", 4));
        WV.add(Pair.create("IL", 2));
        WV.add(Pair.create("IN", 2));
        WV.add(Pair.create("KS", 2));
        WV.add(Pair.create("KY", 1));
        WV.add(Pair.create("LA", 3));
        WV.add(Pair.create("MA", 2));
        WV.add(Pair.create("MD", 2));
        WV.add(Pair.create("ME", 2));
        WV.add(Pair.create("MI", 2));
        WV.add(Pair.create("MN", 2));
        WV.add(Pair.create("MO", 2));
        WV.add(Pair.create("MS", 3));
        WV.add(Pair.create("MT", 4));
        WV.add(Pair.create("NC", 2));
        WV.add(Pair.create("ND", 3));
        WV.add(Pair.create("NE", 3));
        WV.add(Pair.create("NH", 2));
        WV.add(Pair.create("NJ", 2));
        WV.add(Pair.create("NM", 4));
        WV.add(Pair.create("NV", 4));
        WV.add(Pair.create("NY", 2));
        WV.add(Pair.create("OH", 1));
        WV.add(Pair.create("OK", 3));
        WV.add(Pair.create("OR", 5));
        WV.add(Pair.create("PA", 2));
        WV.add(Pair.create("PR", 4));
        WV.add(Pair.create("RI", 2));
        WV.add(Pair.create("SC", 2));
        WV.add(Pair.create("SD", 3));
        WV.add(Pair.create("TN", 2));
        WV.add(Pair.create("TX", 3));
        WV.add(Pair.create("UT", 4));
        WV.add(Pair.create("VA", 1));
        WV.add(Pair.create("VT", 2));
        WV.add(Pair.create("WA", 5));
        WV.add(Pair.create("WI", 2));
        WV.add(Pair.create("WV", 0));
        WV.add(Pair.create("WY", 4));

        return WV;

    } // end method createWVZoneTable.

    /**
     * Initializes a List of Pair objects with key/value pairs of state or territory abbreviation strings and zone integers for WY.
     *
     * @return List of Pair objects containing key/value pairs of state or territory abbreviation string and zone integer for WY.
     * @since 1.0
     */
    private List<Pair> createWYZoneTable() {

        List<Pair> WY = new ArrayList<>();

        WY.add(Pair.create("AK", 5));
        WY.add(Pair.create("AL", 5));
        WY.add(Pair.create("AR", 4));
        WY.add(Pair.create("AZ", 3));
        WY.add(Pair.create("CA", 3));
        WY.add(Pair.create("CO", 2));
        WY.add(Pair.create("CT", 6));
        WY.add(Pair.create("DC", 5));
        WY.add(Pair.create("DE", 5));
        WY.add(Pair.create("FL", 6));
        WY.add(Pair.create("GA", 6));
        WY.add(Pair.create("HI", 4));
        WY.add(Pair.create("IA", 3));
        WY.add(Pair.create("ID", 2));
        WY.add(Pair.create("IL", 4));
        WY.add(Pair.create("IN", 4));
        WY.add(Pair.create("KS", 3));
        WY.add(Pair.create("KY", 5));
        WY.add(Pair.create("LA", 5));
        WY.add(Pair.create("MA", 6));
        WY.add(Pair.create("MD", 5));
        WY.add(Pair.create("ME", 6));
        WY.add(Pair.create("MI", 5));
        WY.add(Pair.create("MN", 3));
        WY.add(Pair.create("MO", 3));
        WY.add(Pair.create("MS", 5));
        WY.add(Pair.create("MT", 2));
        WY.add(Pair.create("NC", 6));
        WY.add(Pair.create("ND", 2));
        WY.add(Pair.create("NE", 3));
        WY.add(Pair.create("NH", 6));
        WY.add(Pair.create("NJ", 5));
        WY.add(Pair.create("NM", 3));
        WY.add(Pair.create("NV", 2));
        WY.add(Pair.create("NY", 5));
        WY.add(Pair.create("OH", 5));
        WY.add(Pair.create("OK", 3));
        WY.add(Pair.create("OR", 3));
        WY.add(Pair.create("PA", 5));
        WY.add(Pair.create("PR", 7));
        WY.add(Pair.create("RI", 6));
        WY.add(Pair.create("SC", 6));
        WY.add(Pair.create("SD", 3));
        WY.add(Pair.create("TN", 5));
        WY.add(Pair.create("TX", 3));
        WY.add(Pair.create("UT", 2));
        WY.add(Pair.create("VA", 5));
        WY.add(Pair.create("VT", 6));
        WY.add(Pair.create("WA", 3));
        WY.add(Pair.create("WI", 4));
        WY.add(Pair.create("WV", 5));
        WY.add(Pair.create("WY", 0));

        return WY;

    } // end method createWYZoneTable.

} // end class StateZoneList.