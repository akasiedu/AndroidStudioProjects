package akasiedu.com.roadtraffic;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


public class MainActivity extends ActionBarActivity {

    private static int RESULT_LOAD_IMAGE = 1;
    Button upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upload= (Button) findViewById(R.id.button);


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,RESULT_LOAD_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("ONRESULT ",  "HELLoo ");

        if (requestCode==RESULT_LOAD_IMAGE && null != data){
            Uri selectedImage = data.getData();
            Log.e("ONRESULT ", selectedImage+" ");
            String[] filePathColumn={ MediaStore.Images.Media.DATA};

            Cursor cursor=getContentResolver().query(selectedImage, filePathColumn,  null,null,null);
            cursor.moveToFirst();

            int columnIndex=cursor.getColumnIndex(filePathColumn[0]);
            String picturePath=cursor.getString(columnIndex);

            File file=new File(picturePath);

            Log.e("ONRESULT ",picturePath + " ");
            cursor.close();

            ImageView imageView= (ImageView) findViewById(R.id.imageView);
            imageView.setImageURI(selectedImage);

        }
    }
}
