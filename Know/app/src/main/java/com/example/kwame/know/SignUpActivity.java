package com.example.kwame.know;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends Activity {

    private EditText mUserName;
    private EditText mUserEmail;
    private EditText mUserPassword;
    private Button mSignUpBtn;
    private TextView mLoginLink;
    private ProgressDialog pDialog;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mUserName = (EditText) findViewById(R.id.usernameSignUp);
        mUserEmail = (EditText) findViewById(R.id.useremailSignUp);
        mUserPassword = (EditText) findViewById(R.id.userpasswordSignUp);
        mSignUpBtn = (Button) findViewById(R.id.btn_signup);
        mLoginLink = (TextView) findViewById(R.id.link_login);

        mLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the values of parameters for SignUp
                String username = mUserName.getText().toString().trim();
                String useremail = mUserEmail.getText().toString().trim();
                String userpassword = mUserPassword.getText().toString().trim();

                context = SignUpActivity.this;


                pDialog = new ProgressDialog(context);
                // Showing progress dialog before making http request
                pDialog.setMessage("Loading...");
                pDialog.show();

                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setEmail(useremail);
                user.setPassword(userpassword);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null){
                            pDialog.hide();
                            Toast.makeText(SignUpActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            pDialog.hide();
                            Toast.makeText(SignUpActivity.this, e.getMessage()+"SignUp Failure", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
