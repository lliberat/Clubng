package edu.calpoly.clubng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.calpoly.clubng.Globals;
import edu.calpoly.clubng.LogInModel;
import edu.calpoly.clubng.R;
import edu.calpoly.clubng.User;

public class LogInController extends AppCompatActivity {

    LogInModel logInModel = LogInModel.getInstance();
    Globals globals = Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // screen ui
        final Button logInBtn = findViewById(R.id.LoginBtn);
        final EditText email = findViewById(R.id.EmailText);
        final EditText password = findViewById(R.id.Password);
        final Button signUpBtn = findViewById(R.id.signUpBtn);
        final TextView authFailure = findViewById(R.id.authFailure);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = email.getText().toString();
                String inputPassword = password.getText().toString();

                authFailure.setVisibility(View.INVISIBLE);

                logInModel.logIn(inputEmail, inputPassword);
                User user = logInModel.checkLoggedIn();

                if (user != null) {
                    globals.setUser(user);
                    startMainActivity();
                }
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

        User user = logInModel.checkLoggedIn();

        if (user != null) {
            globals.setUser(user);
            startMainActivity();
        }

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
