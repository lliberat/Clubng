package edu.calpoly.clubng.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.calpoly.clubng.LocationFragment;
import edu.calpoly.clubng.MainActivity;
import edu.calpoly.clubng.Model.LogInModel;
import edu.calpoly.clubng.R;

public class LogInController extends AppCompatActivity {

    LogInModel model = new LogInModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // screen ui
        final Button logInBtn = findViewById(R.id.LoginBtn);
        final EditText email = findViewById(R.id.EmailText);
        final EditText password = findViewById(R.id.Password);
        final Button signUpBtn = findViewById(R.id.button);
        final TextView authFailure = findViewById(R.id.authFailure);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = email.getText().toString();
                String inputPassword = password.getText().toString();

                authFailure.setVisibility(View.INVISIBLE);
                model.logIn(inputEmail, inputPassword);

                if (model.checkLoggedIn() == 1)
                    startMainActivity();
                else
                    displayFailedLogIn();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change activity to sign up page
                startActivity(new Intent(LogInController.this, SignUpController.class));
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();


        model.checkLoggedIn();
    }

    private void startMainActivity()
    {
        startActivity(new Intent(LogInController.this, MainActivity.class));
    }

    private void displayFailedLogIn()
    {
        final TextView authFailure = findViewById(R.id.authFailure);

        authFailure.setVisibility(View.VISIBLE);
    }
}