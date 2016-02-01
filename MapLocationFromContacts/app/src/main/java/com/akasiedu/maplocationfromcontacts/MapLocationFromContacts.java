package com.akasiedu.maplocationfromcontacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MapLocationFromContacts extends ActionBarActivity {
    private static final String DATA_MIMETYPE = ContactsContract.Data.MIMETYPE;
    private static final Uri DATA_CONTENT_URI = ContactsContract.Data.CONTENT_URI;
    private static final String DATA_CONTACT_ID = ContactsContract.Data.CONTACT_ID;

    private static final String CONTACTS_ID = ContactsContract.Contacts._ID;
    private static final Uri CONTACTS_CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;

    private static final String STRUCTURED_POSTAL_CONTENT_ITEM_TYPE = ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE;
    private static final String STRUCTURED_POSTAL_FORMATTED_ADDRESS = ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS;

    private static final int PICK_CONTACT_REQUEST = 0;
    static String TAG = "MapLocation";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_location_from_contacts);

        final Button button = (Button) findViewById(R.id.mapButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_PICK, CONTACTS_CONTENT_URI);

                    startActivityForResult(intent, PICK_CONTACT_REQUEST);
                } catch (Exception e){
                    Log.e(TAG, e.toString());
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == Activity.RESULT_OK){
            ContentResolver cr = getContentResolver();
            Cursor cursor = cr.query(data.getData(), null, null, null, null);

            if (null != cursor && cursor.moveToFirst()){
                String id = cursor.getString(cursor.getColumnIndex(CONTACTS_ID));
                String where = DATA_CONTACT_ID + " = ? AND " + DATA_MIMETYPE + " = ?";
                String[] whereParameters = new String[]{ id, STRUCTURED_POSTAL_CONTENT_ITEM_TYPE };
                Cursor addCur = cr.query(DATA_CONTENT_URI, null, where, whereParameters, null);

                if (null != addCur && addCur.moveToFirst()){
                    String formattedAddress = addCur.getString(addCur.getColumnIndex(STRUCTURED_POSTAL_FORMATTED_ADDRESS));
                    if (null != formattedAddress){
                        formattedAddress = formattedAddress.replace(' ', '+');

                        Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + formattedAddress));

                        startActivity(geoIntent);
                    }
                }
                if (null != addCur)
                    addCur.close();
            }
            if (null != cursor)
                cursor.close();
        }
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "The activity is about to be restarted.");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "The activity is about to become visible.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "The activity has become visible (it is now \"resumed\")");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,
                "Another activity is taking focus (this activity is about to be \"paused\")");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "The activity is no longer visible (it is now \"stopped\")");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "The activity is about to be destroyed.");
    }
}