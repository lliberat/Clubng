package edu.calpoly.clubng;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ConfirmationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Globals g = Globals.getInstance();
        View view = inflater.inflate(R.layout.fragment_confirmation,container,false);
        RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.nav_confirmation);
        TextView artist = view.findViewById(R.id.ArtistName);
        TextView club = view.findViewById(R.id.Club);
        TextView city = view.findViewById(R.id.City);
        TextView date = view.findViewById(R.id.Date);
        TextView statement = view.findViewById(R.id.Statement);
        if(g.getEvent()!=null){
            Event event = g.getEvent();
            artist.setText(event.getArtist());
            club.setText(event.getClub());
            city.setText(event.getCity());
            date.setText(event.getDay()+". "+event.getMonth()+". "+event.getYear());
            statement.setText("You are going Clubng");
        }else {
            statement.setText("Lets Go Clubng");
        }

        return view;

    }
}
