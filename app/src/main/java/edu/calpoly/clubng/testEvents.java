package edu.calpoly.clubng;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;

import java.util.List;

public class testEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_events);
        FirebaseApp.initializeApp(this);

        final TextView test = findViewById(R.id.textView_test);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);


        new FirebaseDatabaseHelper().readEvents(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void ClubIsLoaded(List<Club> clubs, List<String> keys) {

            }

            @Override
            public void EventIsLoaded(List<Event> events, List<String> keys){
                Event event = events.get(0);
                test.setText(event.getYear());
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
    }
}
