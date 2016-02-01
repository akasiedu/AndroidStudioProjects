package akasiedu.com.cardview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by kwame on 4/29/15.
 */
public class MyActivity extends Activity {

    private CardView myCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        myCardView = (CardView) findViewById(R.id.my_card_view);
        myCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity.class);
                startActivity(i);
            }
        });
    }
}
