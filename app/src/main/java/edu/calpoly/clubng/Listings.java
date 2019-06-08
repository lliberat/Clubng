package edu.calpoly.clubng;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
                new RecyclerView_Config().setConfig(mRecyclerView, Listings.this, events, keys);
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
                Intent homeIntent = new Intent(this, DatePicker.class);
                startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
