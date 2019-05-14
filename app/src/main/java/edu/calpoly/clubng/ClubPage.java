package edu.calpoly.clubng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ClubPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_page);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference clubsDB = database.getReference();

        final EditText clubName = findViewById(R.id.clubName);
        //EditText clubRating = findViewById(R.id.clubRating);
        //EditText clubLoc = findViewById(R.id.clubLoc);


        // Read from the database
        ValueEventListener clubListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                clubName.setText(dataSnapshot.getValue(Name.String));
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }

        };
        clubsDB.addValueEventListener(clubListener);
    }
}
