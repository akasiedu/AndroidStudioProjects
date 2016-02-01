package akasiedu.com.sqlitedb;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    KwameHelper kwameHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kwameHelper=new KwameHelper(this);

        SQLiteDatabase sqLiteDatabase=kwameHelper.getWritableDatabase();

    }


}
