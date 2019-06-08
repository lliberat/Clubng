package edu.calpoly.clubng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class DateController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Globals g = Globals.getInstance();
        final DatePicker picker = findViewById(R.id.datePicker);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;

        actionBar.setDisplayHomeAsUpEnabled(true);

        Button btn = findViewById(R.id.button6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setDay(Integer.toString(picker.getDayOfMonth()));
                g.setMonth(Integer.toString(picker.getMonth()+1));
                g.setYear(Integer.toString(picker.getYear()));
                Intent i = new Intent(DateController.this, Listings.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
