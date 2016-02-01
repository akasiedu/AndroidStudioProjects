package akasiedu.com.pop;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    GridView gv;
    Context context;
    public static String [] popList={"About Me","Contact Me","My Interest","My Community","My Hobbies","History","Email","Phone No","My Location"};
    public static int [] popIcons={R.drawable.about,R.drawable.mail,R.drawable.interest,R.drawable.community,R.drawable.hobby,R.drawable.history,R.drawable.mail,R.drawable.phone,R.drawable.location};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Casting out gridview
        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new MyAdapter(this, popList, popIcons));

        gv.setAdapter(new MyAdapter(this, popList, popIcons));

     gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

             switch (position){
                 case 0:

                     Intent aboutMe = new Intent(getApplicationContext(), AboutMe.class);
                     startActivity(aboutMe);
                     break;
                 case 6:
                     sendEmail();
                     break;
                 case 7:
                     call();
                     break;

             }
         }
     });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            DialogFragment myFragment = new SettingsDialogFragment();
            myFragment.show(getFragmentManager(), "myDialog");
            return true;
        } else if (id == R.id.share){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"POP");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                    "Hi friend! Kindly check out my first Android Application out in the store");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }

        return super.onOptionsItemSelected(item);
    }

    private void call() {
        String myNumber = "+233243364451";


        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + myNumber));
        startActivity(callIntent);

    }

    private void sendEmail(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"abideen.adelu@meltwater.org"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT, "body of email");
        try {
            startActivity(Intent.createChooser(i, "Sending..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients on this device.", Toast.LENGTH_SHORT).show();
        }
    }

}
