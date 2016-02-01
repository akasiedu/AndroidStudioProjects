package akasiedu.com.drivepartner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by kwame on 4/27/15.
 */
public class CategoryActivity extends ActionBarActivity {

    private Toolbar toolbar;

    GridView gridView;
    Context context;
    public static String [] catList={"Road Signs","Emergency Fixes","Driving Manual","Meet New Drivers"};
    public static int [] catIcons={R.mipmap.road_signs,R.mipmap.fixes,R.mipmap.driver_manual, R.mipmap.communities,};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        gridView=(GridView) findViewById(R.id.gridView3);
        gridView.setAdapter(new CategoryAdapter(this, catList, catIcons));

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.fix);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent roadSigns = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(roadSigns);
                        Toast.makeText(CategoryActivity.this, "Know your road signs.", Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        Intent emergencyFixes = new Intent(getApplicationContext(), CarFixesActivity.class);
                        startActivity(emergencyFixes);
                       Toast.makeText(CategoryActivity.this, "Fix small issues", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(CategoryActivity.this, "Coming Soon.", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(CategoryActivity.this, "Coming Soon.", Toast.LENGTH_SHORT).show();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
