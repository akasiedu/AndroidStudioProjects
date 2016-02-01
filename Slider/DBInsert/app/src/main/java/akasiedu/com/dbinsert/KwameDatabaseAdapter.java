package akasiedu.com.dbinsert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kwame on 8/3/15.
 */
public class KwameDatabaseAdapter  {

    KwameHelper helper;

    public KwameDatabaseAdapter(Context context){
        helper=new KwameHelper(context);
    }


    public long insertData(String name, String password){

        SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KwameHelper.NAME, name);
        contentValues.put(KwameHelper.PASSWORD, password);
        long id=sqLiteDatabase.insert(KwameHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    public String getAllData(){
        String[] columns={KwameHelper.UID, KwameHelper.NAME, KwameHelper.PASSWORD};
        SQLiteDatabase db= helper.getWritableDatabase();
        Cursor cursor=db.query(KwameHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
//            int index1=cursor.getColumnIndex(KwameHelper.UID);
//            int cid=cursor.getInt(index1);
            int cid=cursor.getInt(0);
            String name=cursor.getString(1);
            String password=cursor.getString(2);
            buffer.append(cid+" "+name+" "+password+"\n");
        }
        return buffer.toString();
    }



    public String getData(String name, String password){
        SQLiteDatabase db=helper.getWritableDatabase();

        String[] columns={KwameHelper.UID};
        String[] selectionArgs={name, password};

        Cursor cursor=db.query(KwameHelper.TABLE_NAME, columns, KwameHelper.NAME + " =? AND "
                        +KwameHelper.PASSWORD+" =?", selectionArgs, null, null, null, null);

        StringBuffer buffer=new StringBuffer();

        while (cursor.moveToNext()){
//            int index1=cursor.getColumnIndex(KwameHelper.UID);
//            int cid=cursor.getInt(index1);
            int index0=cursor.getColumnIndex(KwameHelper.UID);
//            int index1=cursor.getColumnIndex(KwameHelper.NAME);
//            int index2=cursor.getColumnIndex(KwameHelper.PASSWORD);

            int personId=cursor.getInt(index0);
//            String personName=cursor.getString(index1);
//            String personPassword=cursor.getString(index2);
            buffer.append(personId + "\n");
        }
        return buffer.toString();
    }



     static class KwameHelper extends SQLiteOpenHelper{
         private static final String DATABASE_NAME="kwamedatabase";
         private static final String TABLE_NAME="KWAMETABLE";
         private static final int DATABASE_VERSION=2;
         private static final String UID="_id";
         private static final String NAME="Name";
         private static final String PASSWORD="Password";
         private static final String CREATE_TABLE= "CREATE TABLE " + TABLE_NAME
                            + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME
                            + " VARCHAR(255), " + PASSWORD + " VARCHAR(255));";
         private static final String DROP_TABLE= "DROP TABLE IF EXISTS " + TABLE_NAME;
         private Context context;

         public KwameHelper(Context context){
             super(context, DATABASE_NAME, null, DATABASE_VERSION);
             this.context=context;
             Message.message(context, "constructor called");

         }

         @Override
         public void onCreate(SQLiteDatabase db) {
             try {
                 db.execSQL(CREATE_TABLE);
                 Message.message(context, "onCreate Called");
             } catch (SQLException e) {
                 Message.message(context, ""+e);
             }
         }

         @Override
         public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             try {
                 Message.message(context, "onUpgrade called");
                 db.execSQL(DROP_TABLE);
                 onCreate(db);
             } catch (SQLException e) {
                 Message.message(context, ""+e);
             }
         }
     }
}
