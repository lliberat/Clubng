package edu.calpoly.clubng;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private EventAdapter mEventAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Event> events, List<String> keys){
        mContext = context;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        mEventAdapter = new EventAdapter(events, keys);
        recyclerView.setAdapter(mEventAdapter);
//        mEventAdapter.notifyDataSetChanged();
    }


    class EventItemView extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mDate;
        private TextView mArtist;
        private TextView mCity;
        private String date;
        private Button mButton;

        private String key;

        public EventItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.event_list_item, parent, false));

            mName = (TextView) itemView.findViewById(R.id.textView_eventName);
            mDate = (TextView) itemView.findViewById(R.id.textView_eventDate);
            mArtist = (TextView) itemView.findViewById(R.id.textView_eventArtist);
            mCity = (TextView) itemView.findViewById(R.id.textView_eventCity);
            mButton = (Button) itemView.findViewById(R.id.button_transparent);
        }
        public void bind(final Event event, String key){
            date = String.valueOf(event.getMonth())+"/"+String.valueOf(event.getDay())+"/"+String.valueOf(event.getYear());
            mName.setText(event.getArtist());
            mDate.setText(date);
            mCity.setText(event.getCity());
            mArtist.setText(event.getClub());
            this.key = key;
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // set globals for event
                    Globals g = Globals.getInstance();
                    g.setClubName(String.valueOf(mArtist.getText()));
                    g.setEvent(event);

                    //mName.setText("clicked");
                    Intent intent = new Intent(v.getContext(), ClubPage.class);
                    v.getContext().startActivity(intent);

                }
            });
        }
    }
    class EventAdapter extends RecyclerView.Adapter<EventItemView>{
        private List<Event> mEventList;
        private List<String> mKeys;

        public EventAdapter(List<Event> mEventList, List<String> mKeys) {
            this.mEventList = mEventList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public EventItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new EventItemView(viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull EventItemView eventItemView, int i) {
//            Globals g = Globals.getInstance();
//            String city = g.getCity();
//            String year = g.getYear();
//            String month = g.getMonth();
//            String day = g.getDay();
//
//            Event event = mEventList.get(i);
//
//            if((""+event.getCity()).equals(city) &&
//                    (""+event.getYear()).equals(year) &&
//                    (""+event.getMonth()).equals(month) &&
//                    (""+event.getDay()).equals(day)){
//                eventItemView.bind(mEventList.get(i), mKeys.get(i));
//            }else{
////                mEventList.remove(i);
////                mKeys.remove(i);
//            }
//            if((""+event.getCity()).equals(city)){
//                eventItemView.bind(mEventList.get(i), mKeys.get(i));
//            }else{
//                ;
//            }
            eventItemView.bind(mEventList.get(i), mKeys.get(i));
        }

        @Override
        public int getItemCount() {
            return mEventList.size();
        }


    }
}
