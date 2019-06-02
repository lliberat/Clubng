package edu.calpoly.clubng;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ClubPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_page);
        FirebaseApp.initializeApp(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final TextView clubName = findViewById(R.id.clubName);
        final TextView clubLoc = findViewById(R.id.clubLoc);
        final TextView clubRating = findViewById(R.id.clubRating);
        final TextView goldPrice = findViewById(R.id.goldPrice);
        final TextView silverPrice = findViewById(R.id.silverPrice);
        final TextView bronzePrice = findViewById(R.id.bronzePrice);
        Button bookButton = findViewById(R.id.bookbutton);

        new FirebaseDatabaseHelper().readClubs(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Club> clubs, List<String> keys) {
                Club club = clubs.get(0);
                clubName.setText(club.getName());
                clubRating.setText(club.getService());
                clubLoc.setText(club.getLocation());
                goldPrice.setText(club.getGold());
                silverPrice.setText(club.getSilver());
                bronzePrice.setText(club.getBronze());
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }


    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
