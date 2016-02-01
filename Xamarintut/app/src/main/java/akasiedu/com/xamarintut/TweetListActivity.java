package akasiedu.com.xamarintut;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TweetListActivity extends ActionBarActivity {

    private ListView tweetListView;
    private ArrayAdapter tweetItemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);



        tweetItemArrayAdapter = new TweetAdapter(this, String[10]);
        tweetListView = (ListView) findViewById(R.id.tweetList);
        tweetListView.setAdapter(tweetItemArrayAdapter);
    }
}
