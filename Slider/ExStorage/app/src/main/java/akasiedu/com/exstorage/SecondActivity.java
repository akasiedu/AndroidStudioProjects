package akasiedu.com.exstorage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class SecondActivity extends ActionBarActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText= (EditText) findViewById(R.id.editText);
    }


    public void loadInternalCache(View view) {
       File folder=getCacheDir();
        File myFile=new File(folder, "mydata1.txt");
        String data=readData(myFile);
        if (data!=null){
            editText.setText(data);
        }else{
            editText.setText("No data found");
        }
    }

    public void loadExternalCache(View view) {
        File folder=getExternalCacheDir();
        File myFile=new File(folder, "mydata2.txt");
        String data=readData(myFile);
        if (data!=null){
            editText.setText(data);
        }else{
            editText.setText("No data found");
        }
    }


    public void loadPrivateExternalFile(View view) {
        File folder=getExternalFilesDir("Kwame");
        File myFile=new File(folder, "mydata3.txt");
        String data=readData(myFile);
        if (data!=null){
            editText.setText(data);
        }else{
            editText.setText("No data found");
        }
    }

    public void loadPublicExternalFile(View view) {
        File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile=new File(folder, "mydata4.txt");
        String data=readData(myFile);
        if (data!=null){
            editText.setText(data);
        }else{
            editText.setText("No data found");
        }
    }

    private String readData(File myFile){
        FileInputStream fileInputStream=null;
        try {
            fileInputStream= new FileInputStream(myFile);
            int read=-1;
            StringBuffer stringBuffer=new StringBuffer();
            while((read=fileInputStream.read())!=-1){
                stringBuffer.append((char)read);
            };
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void previous(View view) {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void message(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
