package akasiedu.com.dbinsert;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    KwameDatabaseAdapter kwameHelper;
    EditText userName, password, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName= (EditText) findViewById(R.id.userNameValue);
        password= (EditText) findViewById(R.id.passwordValue);
        name= (EditText) findViewById(R.id.editText);

        kwameHelper=new KwameDatabaseAdapter(this);
    }



    public void addUser(View view) {
        String user=userName.getText().toString();
        String pass=password.getText().toString();

      long id= kwameHelper.insertData(user, pass);
        if (id<0){
            Message.message(this, "Unsuccessful");
        } else{
            Message.message(this, "Successful");
        }
        userName.setText(" ");
        password.setText(" ");
    }

    public void viewDetails(View view) {
        String data=kwameHelper.getAllData();
        Message.message(this, data);
    }

    public void getDetails(View view) {
        String s1=name.getText().toString();

        String sub1=s1.substring(0, s1.indexOf(" "));
        String sub2=s1.substring(s1.indexOf(" ")+1);
        String s3=kwameHelper.getData(sub1,sub2);
        Message.message(this,s3);

    }
}
