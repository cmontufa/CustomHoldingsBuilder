package edu.grzegorzewski.customholdingsbuilder;
/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */
import java.util.ArrayList;

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
    public ZoneList(String state) {
        Zone zone = new Zone();
        zone.addState(state);
        this.zones.add(0,zone);
        zone.clearStates();
    }
}
