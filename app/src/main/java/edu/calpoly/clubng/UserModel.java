package edu.calpoly.clubng;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import edu.calpoly.clubng.Event;
import edu.calpoly.clubng.User;

public class UserModel {

    private static UserModel uniqueInstance;
    private DatabaseReference mDatabase;

    private UserModel(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public static UserModel getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new UserModel();
        return uniqueInstance;
    }

    // create a new user in the database when a new account is created through authentication
    public void addUserToFirebase(User newUser) {
        mDatabase.child("users").child(newUser.getUserID()).setValue(newUser);
    }

    public void updateUserEmail(User user, String newEmail) {
        mDatabase.child("users").child(user.getUserID()).child("email").setValue(newEmail);
    }

    public void updateReservations(User user, ArrayList<Event> reservations) {
        mDatabase.child("users").child(user.getUserID()).child("reservations").setValue(reservations);
    }
}
