package edu.calpoly.clubng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Listings extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);
        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;

        actionBar.setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_listings);
        new FirebaseDatabaseHelper().readEvents(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void ClubIsLoaded(List<Club> clubs, List<String> keys) {

            }

            @Override
            public void EventIsLoaded(List<Event> events, List<String> keys) {
                Globals g = Globals.getInstance();
                String city = g.getCity();
                String year = g.getYear();
                String month = g.getMonth();
                String day = g.getDay();

                List<Event> e = new ArrayList<Event>();
                List<String> k = new ArrayList<String>();


                for(int i = 0; i < events.size(); i++){
                    if((""+events.get(i).getCity()).equals(city) &&
                            (""+events.get(i).getYear()).equals(year) &&
                            (""+events.get(i).getMonth()).equals(month) &&
                            (""+events.get(i).getDay()).equals(day)){
                        e.add(events.get(i));
                        k.add(keys.get(i));
                    }
                }
                new RecyclerView_Config().setConfig(mRecyclerView, Listings.this, e, k);
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
