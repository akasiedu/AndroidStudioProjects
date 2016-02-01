package akasiedu.com.gridviewtut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MyDialog extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);

        Intent intent=getIntent();
        if (intent!=null){
            int imageId=intent.getIntExtra("countryImage",R.drawable.no_crossing);
            String countryName=intent.getStringExtra("countryName");
            ImageView imageView= (ImageView) findViewById(R.id.imageView);
            imageView.setImageResource(imageId);
            TextView textView= (TextView) findViewById(R.id.textView);
            textView.setText(countryName);
        }
    }

    public void closeDialog(View v){
        finish();
    }
}
