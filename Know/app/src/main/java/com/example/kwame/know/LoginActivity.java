package com.example.kwame.know;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends Activity {

    protected EditText mUserNameLogin;
    protected EditText mEmailLogin;
    protected EditText mUserLoginPassword;
    protected Button mUserLoginButton;
    protected TextView mSignUpLink;
    private ProgressDialog pDialog;
    Context context;
//    protected Button mUserSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserNameLogin = (EditText) findViewById(R.id.inputusernameLogin);
        mEmailLogin = (EditText) findViewById(R.id.inputemailLogin);
        mUserLoginPassword = (EditText) findViewById(R.id.inputpasswordLogin);
        mUserLoginButton = (Button) findViewById(R.id.btn_login);
        mSignUpLink = (TextView) findViewById(R.id.link_signup);

        mSignUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });



        mUserLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUserNameLogin.getText().toString().trim();
                String useremail = mEmailLogin.getText().toString().trim();
                String userpassword = mUserLoginPassword.getText().toString().trim();

                context = LoginActivity.this;


                pDialog = new ProgressDialog(context);
                // Showing progress dialog before making http request
                pDialog.setMessage("Loading...");
                pDialog.show();

                ParseUser.logInInBackground(username, userpassword, new LogInCallback(){

                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null){
                            pDialog.hide();
                            Toast.makeText(LoginActivity.this, "Welcome Back", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);

                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                            pDialog.hide();
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
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
