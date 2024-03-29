package edu.calpoly.clubng;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import edu.calpoly.clubng.LogInController;
import edu.calpoly.clubng.SignUpController;
import edu.calpoly.clubng.Globals;
import edu.calpoly.clubng.LogInModel;
import edu.calpoly.clubng.UserModel;
import edu.calpoly.clubng.R;

public class ProfileFragment extends Fragment {

    LogInModel logInModel = LogInModel.getInstance();
    UserModel userModel = UserModel.getInstance();
    Globals globals = Globals.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View profileView = inflater.inflate(R.layout.fragment_profile,container,false);

        final EditText inputEmail = profileView.findViewById(R.id.emailText);
        final EditText inputPassword = profileView.findViewById(R.id.passText);
        final EditText inputConfirm = profileView.findViewById(R.id.comfirmPassText);
        final Button changeInfoBtn = profileView.findViewById(R.id.changeBtn);
        final Button logOutBtn = profileView.findViewById(R.id.logoutBtn);

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInModel.logOut();
                startActivity(new Intent(getActivity(), LogInController.class));
            }
        });

        changeInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEmail = inputEmail.getText().toString();

                logInModel.updateInfo(newEmail);
                userModel.updateUserEmail(globals.getUser(), newEmail);
            }
        });

        return profileView;
    }
}
