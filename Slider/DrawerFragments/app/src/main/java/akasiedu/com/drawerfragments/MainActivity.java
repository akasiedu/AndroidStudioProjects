package akasiedu.com.drawerfragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
//    private String[] planets;
    private ActionBarDrawerToggle drawerListener;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        planets=getResources().getStringArray(R.array.planets);
        listView=(ListView) findViewById(R.id.drawerList);
//        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));
        myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerListener = new ActionBarDrawerToggle(this,drawerLayout,R.drawable.drawericon, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerListener.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerListener.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }

    public void selectItem(int position){
        listView.setItemChecked(position, true);
//        setTitle(planets[position]);
    }
    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, planets[position]+" was selected", Toast.LENGTH_LONG).show();
        selectItem(position);
    }

}

class MyAdapter extends BaseAdapter{

    private Context context;
    String[] socialSites;
    int[] images={R.drawable.facebook, R.drawable.twitter, R.drawable.pinterest, R.drawable.youtube};

    public MyAdapter(Context context){
        this.context=context;
        socialSites=context.getResources().getStringArray(R.array.social);
    }

    @Override
    public int getCount() {
        return socialSites.length;
    }

    @Override
    public Object getItem(int position) {
        return socialSites[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=null;
        if (convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           row = inflater.inflate(R.layout.custom_row, parent, false);
        }else {
            row = convertView;
        }
        TextView titleTextView = (TextView) row.findViewById(R.id.textView1);
        ImageView titleImageView = (ImageView) row.findViewById(R.id.imageView1);
        titleTextView.setText(socialSites[position]);
        titleImageView.setImageResource(images[position]);
        return convertView;
    }
}