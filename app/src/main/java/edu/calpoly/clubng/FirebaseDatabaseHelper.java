package edu.calpoly.clubng;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceClubs;
    private DatabaseReference mReferenceEvents;
    private List<Club> clubs = new ArrayList<>();
    private List<Event> events = new ArrayList<>();


    public interface DataStatus{
        void ClubIsLoaded(List<Club> clubs, List<String> keys);
        void EventIsLoaded(List<Event> events, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceClubs = mDatabase.getReference("clubs");
        mReferenceEvents = mDatabase.getReference("events");
    }

    public void readClubs(final DataStatus dataStatus){
        mReferenceClubs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clubs.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Club club = keyNode.getValue(Club.class);
                    clubs.add(club);
                }
                dataStatus.ClubIsLoaded(clubs, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void readEvents(final DataStatus dataStatus2) {
        mReferenceEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                events.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Event event = keyNode.getValue(Event.class);
                    events.add(event);
                }
                dataStatus2.EventIsLoaded(events, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
