package com.example.kwame.testapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivty extends Activity {

    protected EditText mUsernameLogin;
    protected EditText mUserLoginPassword;
    protected Button mUserLoginButton;
    protected Button mUserSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameLogin = (EditText) findViewById(R.id.loginUsername);
        mUserLoginPassword = (EditText) findViewById(R.id.loginPassword);
        mUserLoginButton = (Button) findViewById(R.id.loginButton);
        mUserSignUpButton = (Button) findViewById(R.id.signUpButton);

        mUserSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivty.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mUserLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsernameLogin.getText().toString().trim();
                String password = mUserLoginPassword.getText().toString().trim();


                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Toast.makeText(LoginActivty.this, "Welcome back", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivty.this, CreateStatus.class);
                            startActivity(intent);
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivty.this);
                            builder.setMessage(e.getMessage());
                            builder.setTitle("Sorry");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    }
                });
            }
        });


    }
}
