package edu.calpoly.clubng;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class LocationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Globals g = Globals.getInstance();
        View view =  inflater.inflate(R.layout.fragment_location,container,false);
        RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.nav_location);
        Button clickButton = view.findViewById(R.id.button3);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setCity("Los Angeles");
                Intent i = new Intent(getActivity(), DateController.class);
                startActivity(i);
            }
        });
        Button clickButton1 = view.findViewById(R.id.button2);
        clickButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setCity("New York");
                Intent i = new Intent(getActivity(), DateController.class);
                startActivity(i);
            }
        });
        Button clickButton3 = view.findViewById(R.id.button4);
        clickButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setCity("Las Vegas");
                Intent i = new Intent(getActivity(), DateController.class);
                startActivity(i);
            }
        });
        return view;
    }

}
