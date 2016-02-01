package akasiedu.com.internalstorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ActivityB extends ActionBarActivity {

    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        userName= (EditText) findViewById(R.id.editText3);
        password= (EditText) findViewById(R.id.editText4);
    }

    public void previous(View v){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void load(View v){
        try {
            FileInputStream fileInputStream=openFileInput("kwame.txt");
            int read=-1;
            StringBuffer buffer=new StringBuffer();
            while((read=fileInputStream.read())!=-1){
                buffer.append((char)read);
            }
            String text1=buffer.substring(0,buffer.indexOf(" "));
            String text2=buffer.substring(buffer.indexOf(" ")+1);

            userName.setText(text1);
            password.setText(text2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
