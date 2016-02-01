package akasiedu.com.switchingscreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kwame on 5/8/15.
 */
public class SecondScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity", "MainActivity");

        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity);
        callingActivityMessage.append(" " + previousActivity);
    }

    public void onSendUsersName(View view) {
        EditText usersNameET = (EditText) findViewById(R.id.users_name_edit_text);

        String usersName = String.valueOf(usersNameET.getText());
        Intent goingBack = new Intent();

        goingBack.putExtra("UsersName", usersName);
        setResult(RESULT_OK, goingBack);

        finish();
    }
}
