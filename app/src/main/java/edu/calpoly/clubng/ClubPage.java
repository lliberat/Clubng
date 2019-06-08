package edu.calpoly.clubng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;

import java.util.List;

public class ClubPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_page);
        FirebaseApp.initializeApp(this);

        final TextView clubName = findViewById(R.id.clubName);
        final TextView clubInfo = findViewById(R.id.clubInfo);
        final TextView clubLoc = findViewById(R.id.clubLoc);
        final TextView goldPrice = findViewById(R.id.goldPrice);
        final TextView silverPrice = findViewById(R.id.silverPrice);
        final TextView bronzePrice = findViewById(R.id.bronzePrice);
        Button bookButton = findViewById(R.id.bookbutton);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);


        new FirebaseDatabaseHelper().readClubs(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void ClubIsLoaded(List<Club> clubs, List<String> keys) {
                Club club = clubs.get(0);
                Globals g = Globals.getInstance();
                String cName = g.getClubName();
                for (Club c: clubs) {
                    //Log.d("myTag", ""+c.getName());
                    if ((""+c.getName()).equals(cName)){
                        club = c;
                        break;
                    }
                }
                clubName.setText(club.getName());
                clubInfo.setText(club.getInfo());
                clubLoc.setText(club.getLocation());
                goldPrice.setText(String.valueOf(club.getGold()));
                silverPrice.setText(String.valueOf(club.getSilver()));
                bronzePrice.setText(String.valueOf(club.getBronze()));
            }

            @Override
            public void EventIsLoaded(List<Event> events, List<String> keys){

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
        Intent intent = new Intent(this, PaymentController.class);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, DateController.class);
                startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
