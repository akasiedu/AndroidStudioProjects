package akasiedu.com.sharedprefs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityB extends ActionBarActivity {
    public static final String DEFAULT="N/A";
    TextView userNameTextView, passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        userNameTextView= (TextView) findViewById(R.id.textView5);
        passwordTextView= (TextView) findViewById(R.id.textView6);
    }

    public void load(View v){
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("name",DEFAULT);
        String password=sharedPreferences.getString("password",DEFAULT);

        if (name.equals(DEFAULT) || password.equals(DEFAULT)){
            Toast.makeText(this,"No Data found", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Data loaded successfully", Toast.LENGTH_LONG).show();
            userNameTextView.setText(name);
            passwordTextView.setText(password);
        }
    }

    public void previous(View v){

        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Previous",Toast.LENGTH_LONG).show();
    }
}
