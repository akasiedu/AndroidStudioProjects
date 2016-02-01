package akasiedu.com.sharedprefs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    EditText userName;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName= (EditText) findViewById(R.id.userName);
        password= (EditText) findViewById(R.id.password);
    }



    public void save(View v){
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",userName.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();


        Toast.makeText(this,"Data was saved successfully",Toast.LENGTH_LONG).show();
    }




    public void next(View v){
        Toast.makeText(this,"Next",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,ActivityB.class);
        startActivity(intent);
    }

}
