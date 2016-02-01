package akasiedu.com.dialogfragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kwame on 5/25/15.
 */
public class MyDialog extends DialogFragment implements View.OnClickListener{

    Button yes, no;
    Communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_dialog, null);
        yes = (Button) view.findViewById(R.id.yes);
        no = (Button) view.findViewById(R.id.no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.yes){
            communicator.onDialogMessage("yes was clicked");
            dismiss();

        } else {
            communicator.onDialogMessage("no was clicked");
            dismiss();
        }
    }

    public interface Communicator{
        public void onDialogMessage(String message);
    }
}
