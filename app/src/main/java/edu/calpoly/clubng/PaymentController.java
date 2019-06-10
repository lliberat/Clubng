package edu.calpoly.clubng;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PaymentController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;

        actionBar.setDisplayHomeAsUpEnabled(true);
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        Button PayButton = findViewById(R.id.button5);
        final Globals g = Globals.getInstance();
        TextView txt = findViewById(R.id.textView3);
        txt.setText("USD "+Long.toString(g.getPrice()));
        PayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // add new reservation to user
                g.getUser().addReservation(g.getEvent());
                UserModel u = UserModel.getInstance();
                u.updateReservations(g.getUser(), g.getUser().getReservations());

                openMainActivity();
            }
        });
    }
    public void openMainActivity(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

        Intent intent = new Intent(this, NewMessageNotification.class);
// use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

// build notification
// the addAction re-use the same intent to keep the example short
        Notification n  = new Notification.Builder(this)
                .setContentTitle("CONGRATULATIONS!")
                .setContentText("You are going CLUBNG")
                .setColor(getTitleColor())
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
               .build();


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, ClubPage.class);
                startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
