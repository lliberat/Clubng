package edu.calpoly.clubng;

import java.util.ArrayList;

public class User {
    private String userID;
    private String email;
    private ArrayList<Event> reservations;

    //UserModel model = UserModel.getInstance();

    public User(String userID, String email) {
        this.userID = userID;
        this.email = email;
        this.reservations = null;
    }

    public String getUserID() { return this.userID; }

    public void setUserID(String newUserID) { this.userID = newUserID; }

    public String getEmail() { return this.email; }

    public void setEmail(String newEmail) { this.email = newEmail; }

    public ArrayList<Event> getReservations() { return reservations; }

    public void setReservations(ArrayList<Event> reservations) { this.reservations = reservations; }

    public void addReservation(Event newReservation) {this.reservations.add(newReservation); }

    /*
    // returns the event with the soonest date
    // if there are no reservations, it will return null
    public Event getSoonestReservation() {
        Event soonest;
        int month;
        int day;
        int year;

        if (reservations == null)
            return null;

        for (int i = 0; i < reservations.size(); i++)
        {
            if (reservations.get(i).getYear() < year)
                reservations.get(i).getYear;
        }

        return soonest;
    }
    */

}
