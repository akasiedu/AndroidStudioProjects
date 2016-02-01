package akasiedu.com.internalstorage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    EditText userName,passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName= (EditText) findViewById(R.id.editText);
        passWord= (EditText) findViewById(R.id.editText2);
    }

    public void save(View v){

        String text1=userName.getText().toString();
        String text2=passWord.getText().toString();
        FileOutputStream fileOutputStream=null;
        File file=null;

        text1=text1+" ";
        try {
            file=getFilesDir();
            fileOutputStream=openFileOutput("kwame.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Toast.makeText(this,"Data saved successfully"+file+" /kwame.txt", Toast.LENGTH_LONG).show();
    }
    public void next(View v){

        Intent intent=new Intent(this,ActivityB.class);
        startActivity(intent);

    }

}
