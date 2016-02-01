package akasiedu.com.fragnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by kwame on 5/23/15.
 */
public class AnotherActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent intent=getIntent();
        int index = intent.getIntExtra("index", 0);

        FragmentB f2 = (FragmentB) getFragmentManager().findFragmentById(R.id.fragment2);
        if (f2!=null)
        f2.changeData(index);
    }
}
