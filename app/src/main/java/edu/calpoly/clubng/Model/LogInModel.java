package edu.calpoly.clubng.Model;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.support.constraint.Constraints.TAG;

public class LogInModel extends AppCompatActivity {

    // implemented with singleton design pattern
    private static LogInModel uniqueInstance;

    private FirebaseAuth mAuth;

    private LogInModel() {}

    public static LogInModel getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new LogInModel();
        return uniqueInstance;
    }

    public void signUp(String email, String password){

        FirebaseApp.initializeApp(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            System.out.println("failed to create an account");
                            //Toast.makeText(, "Authentication failed.",
                                    //Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void logIn(String email, String password) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            System.out.println("failed to sign in");
                            //Toast.makeText(getApplicationContext(), "Authentication failed.",
                            //Toast.LENGTH_SHORT).show();
                            // do not enter new activity
                        }

                        // ...
                    }
                });
    }

    public int checkLoggedIn()
    {
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null)
            return 0;
        else {
            System.out.println("\nUser ID: " + mAuth.getCurrentUser().getUid() + "\n");
            return 1;
        }
    }

    public void updateInfo(String newEmail) {
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.updateEmail(newEmail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User email address updated.");
                        } else {
                            // email not updated
                        }
                    }
                });

        /*
        user.updatePassword(newPassword)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User password updated.");
                        } else {
                            // password not updated
                        }
                    }
                });
        */
    }

    public void logOut()
    {
        FirebaseAuth.getInstance().signOut();
    }
}
