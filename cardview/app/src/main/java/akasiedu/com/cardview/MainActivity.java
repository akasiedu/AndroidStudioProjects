package akasiedu.com.cardview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private FixAdapter fixAdapter;
    private ArrayList<FixItem> arrayList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        fixAdapter = new FixAdapter(this, arrayList);
        listView.setAdapter(fixAdapter);



//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//
//                // Sending image id to FullScreenActivity
//                Intent i = new Intent(getApplicationContext(), ShowStuff.class);
//                // passing array index
//                i.putExtra("id", position);
//                startActivity(i);
//            }
//        });


        arrayList.add(new FixItem("1", "Elmina castle",
                " It was built in 1482. It was the first slave castle to be built along the west coast of Africa and also the first permanent structure south of the Sahara built by Europeans. Originally a military factory, \n" +
                        "it's the first trading post in the Gulf of Guinea built by the Portuguese. \n" +
                        "One of Ghanaian historical sites, Elmina Fort, or 'Fort São Jorge da Mina' as it is also referred, \n" +
                        "was elevated to the status of castle because it was the seat of authority for the Portuguese. ", "Contact nearest Mechanic"));


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
