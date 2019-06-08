package edu.calpoly.clubng.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;

import edu.calpoly.clubng.LocationFragment;
import edu.calpoly.clubng.MainActivity;
import edu.calpoly.clubng.Model.LogInModel;
import edu.calpoly.clubng.R;

public class SignUpController extends AppCompatActivity {

    LogInModel model = LogInModel.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc);

        // screen ui
        final Button confirmBtn = findViewById(R.id.loginBtn);
        final EditText email = findViewById(R.id.editText2);
        final EditText password1 = findViewById(R.id.editText4);
        final EditText password2 = findViewById(R.id.editText5);
        final TextView authFailure = findViewById(R.id.authFailure);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = email.getText().toString();
                String inputPassword = password1.getText().toString();
                String confirmPassword = password2.getText().toString();

                if (inputPassword.equals(confirmPassword)) {
                    authFailure.setVisibility(View.INVISIBLE);
                    model.signUp(inputEmail, inputPassword);

                    if (model.checkLoggedIn() == 1)
                        startMainActivity();
                    else
                        displayFailedLogIn();
                }
            }
        });
    }

    public void startMainActivity()
    {
        startActivity(new Intent(SignUpController.this, MainActivity.class));
    }

    public void displayFailedLogIn()
    {
        final TextView authFailure = findViewById(R.id.authFailure);

        authFailure.setVisibility(View.VISIBLE);
    }
}
