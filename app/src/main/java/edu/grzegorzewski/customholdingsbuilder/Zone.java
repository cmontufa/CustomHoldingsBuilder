package edu.grzegorzewski.customholdingsbuilder;
/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */
import java.util.ArrayList;

/**
 * Contains an ArrayList of U.S. state or territory abbreviations,
 * and the methods add a state to the list,
 * remove a state from the list,
 * set the entire list,
 * return the entire list,
 * and return a string representation of the Zone object.
 *
 * @author Dennis Grzegorzewski.
 * @version 1.0, 11/20/2016
 */
class Zone {

    /*
     * Declare instance variables.
     */
    private ArrayList<String> states; // A list of U.S. state or territory abbreviations.

    /*
     * Constructors.
     */

    /**
     * No-arg constructor.
     *
     * @see #states A list of U.S. state or territory abbreviations.
     * @see #addState(String) Adds a state to the states ArrayList, and returns true if the list has been changed.
     * @see #deleteState(String) Deletes a state from the states ArrayList, and returns true if the list contained the specified element.
     * @see #getStates() Returns the states ArrayList of U.S. state or territory abbreviations.
     * @see #setStates(ArrayList) Sets the states ArrayList of U.S. state or territory abbreviations.
     * @see #toString() Returns a string representation of the Zone object.
     * @since 1.0
     */
    Zone() {
        this.states = new ArrayList<>();
    } //end No-arg constructor.

    /**
     * Full-arg constructor.
     *
     * @see #states A list of U.S. state or territory abbreviations.
     * @see #addState(String) Adds a state to the states ArrayList, and returns true if the list has been changed.
     * @see #deleteState(String) Deletes a state from the states ArrayList, and returns true if the list contained the specified element.
     * @see #getStates() Returns the states ArrayList of U.S. state or territory abbreviations.
     * @see #setStates(ArrayList) Sets the states ArrayList of U.S. state or territory abbreviations.
     * @see #toString() Returns a string representation of the Zone object.
     * @since 1.0
     */
    Zone(ArrayList<String> states) {
        this.states = states;
    } //end Full-arg constructor.

    /*
     * Methods.
     */

    /**
     * Adds a state to the states ArrayList,
     * and returns true if the list has been changed.
     *
     * @param state The abbreviation of a U.S. state or territory, for example, "CA".
     * @return - true if this list changed as a result of the call.
     * @see #states A list of U.S. state or territory abbreviations.
     * @see #deleteState(String) Deletes a state from the states ArrayList, and returns true if the list contained the specified element.
     * @see #setStates(ArrayList) Sets the states ArrayList of U.S. state or territory abbreviations.
     * @see #getStates() Returns the states ArrayList of U.S. state or territory abbreviations.
     * @see #toString() Returns a string representation of the Zone object.
     * @since 1.0
     */
    boolean addState(String state) {
        return this.states.add(state);
    } // end method addState.

    /**
     * Deletes a state from the states ArrayList,
     * and returns true if the list contained the specified element.
     *
     * @param state The abbreviation of a U.S. state or territory, for example, "CA".
     * @return - true if this list contained the specified element.
     * @see #states A list of U.S. state or territory abbreviations.
     * @see #addState(String) Adds a state to the states ArrayList, and returns true if the list has been changed.
     * @see #setStates(ArrayList) Sets the states ArrayList of U.S. state or territory abbreviations.
     * @see #getStates() Returns the states ArrayList of U.S. state or territory abbreviations.
     * @see #toString() Returns a string representation of the Zone object.
     * @since 1.0
     */
    boolean deleteState(String state) {
        return this.states.remove(state);
    } // end method deleteState.

    /**
     * Returns an ArrayList of U.S. state or territory abbreviations.
     *
     * @return - ArrayList of Strings in this
     * @see #states A list of U.S. state or territory abbreviations.
     * @see #addState(String) Adds a state to the states ArrayList, and returns true if the list has been changed.
     * @see #deleteState(String) Deletes a state from the states ArrayList, and returns true if the list contained the specified element.
     * @see #setStates(ArrayList) Sets the states ArrayList of U.S. state or territory abbreviations.
     * @see #toString() Returns a string representation of the Zone object.
     * @since 1.0
     */
    ArrayList<String> getStates() {
        return states;
    } // end method getStates.

    /**
     * Sets the states ArrayList of U.S. state or territory abbreviations.
     *
     * @param states ArrayList of Strings to initialize this ArrayList of U.S. state or territory abbreviations.
     * @see #states A list of U.S. state or territory abbreviations.
     * @see #addState(String) Adds a state to the states ArrayList, and returns true if the list has been changed.
     * @see #deleteState(String) Deletes a state from the states ArrayList, and returns true if the list contained the specified element.
     * @see #getStates() Returns the states ArrayList of U.S. state or territory abbreviations.
     * @see #toString() Returns a string representation of the Zone object.
     * @since 1.0
     */
    void setStates(ArrayList<String> states) {
        this.states = states;
    } // end method setStates.

    /**
     * Returns a string representation of the Zone object.
     *
     * @return - A string representation of the Zone object.
     * @see #states A list of U.S. state or territory abbreviations.
     * @see #addState(String) Adds a state to the states ArrayList, and returns true if the list has been changed.
     * @see #deleteState(String) Deletes a state from the states ArrayList, and returns true if the list contained the specified element.
     * @see #getStates() Returns the states ArrayList of U.S. state or territory abbreviations.
     * @see #setStates(ArrayList) Sets the states ArrayList of U.S. state or territory abbreviations.
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Zone{" +
                "states=" + states +
                '}';
    } // end method toString.

} // end class Zone.