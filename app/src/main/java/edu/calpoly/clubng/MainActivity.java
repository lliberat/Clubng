package edu.calpoly.clubng;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.footer);


        BottomNavigationView bottomnav = (BottomNavigationView) findViewById(R.id.footer_nav);
        bottomnav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                new LocationFragment()).commit(); //sets default fragment

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFrag = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_profile:
                            selectedFrag = new ProfileFragment();
                            break;
                        case R.id.nav_location:
                            selectedFrag = new LocationFragment();
                            break;
                        case R.id.nav_confirmation:
                            selectedFrag = new ConfirmationFragment();
                            break;
                    }
                    if(selectedFrag != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                                selectedFrag).commit();
                    }
                    return true;
                }
            };



}
