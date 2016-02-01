package com.example.kwame.testapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class CreateStatus extends AppCompatActivity {
    protected EditText mCreateStatus;
    protected Button mCreateStatusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_status);

        mCreateStatus= (EditText) findViewById(R.id.updateStatusBox);
        mCreateStatusButton= (Button) findViewById(R.id.createStatusButton);

        //listen to the status update for onClick
        mCreateStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get current user
                ParseUser currentUser = ParseUser.getCurrentUser();
                String currentUserName = currentUser.getUsername();
                //get the content in box and conver to a string
                String newStatus = mCreateStatus.getText().toString();
                if (newStatus.isEmpty()){
                    //there is a problem
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateStatus.this);
                    builder.setMessage("Status should not be empty");
                    builder.setTitle("Sorry");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else{
                    //Save the status to parse
                    ParseObject createStatus = new ParseObject("Status");
                    createStatus.put("newStatus", newStatus);
                    createStatus.put("user", currentUserName);
                    createStatus.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e==null){
                                //successfully save status
                                Toast.makeText(CreateStatus.this, "Success", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(CreateStatus.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                //there is a problem
                                AlertDialog.Builder builder = new AlertDialog.Builder(CreateStatus.this);
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


            }
        });
    }
}
