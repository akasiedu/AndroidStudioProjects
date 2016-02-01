package akasiedu.com.sqlitedb;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by kwame on 8/3/15.
 */
public class Message {
    public static void message(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
