package com.example.kwame.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;

public class RegisterActivity extends AppCompatActivity {


    protected EditText mUsername;
    protected EditText mUserEmail;
    protected EditText mUserPassword;
    protected Button mRegisterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize the widgets
        mUsername= (EditText) findViewById(R.id.userNameRegister);
        mUserEmail= (EditText) findViewById(R.id.emailRegister);
        mUserPassword= (EditText) findViewById(R.id.passwordRegister);
        mRegisterButton= (Button) findViewById(R.id.registerButton);

        //Listen to register button click
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get UseName password and email and convert to a string to store in parse
                String username = mUsername.getText().toString().trim();
                String email = mUserEmail.getText().toString().trim();
                String password = mUserPassword.getText().toString().trim();

                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if(e == null){
                            //User signed up
                            Toast.makeText(RegisterActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            //Error signing up user
                            Toast.makeText(RegisterActivity.this, "SignUp Failure", Toast.LENGTH_LONG).show();;
                        }
                    }
                });
            }
        });
    }
}
