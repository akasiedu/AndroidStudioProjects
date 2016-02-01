package akasiedu.com.sqlitedb;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kwame on 8/3/15.
 */
public class KwameHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="kwamedatabase";
    private static final String TABLE_NAME="KWAMETABLE";
    private static final int DATABASE_VERSION=3;
    private static final String UID="_id";
    private static final String NAME="Name";
    private static final String ADDRESS="Address";
    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;

    public KwameHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        Message.message(context, "constructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE KWAMETABLE(_id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255));
        try{
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e){
            Message.message(context, ""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            Message.message(context, "" + e);
        }
    }
}
