package akasiedu.com.fragtuts;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kwame on 5/22/15.
 */
public class FragmentB extends Fragment {

    TextView textView;
    String data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_b, container, false);
        if (savedInstanceState==null){

        }else {
            savedInstanceState.getString("text");
            TextView myText = (TextView) view.findViewById(R.id.textView2);
            myText.setText(data);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView) getActivity().findViewById(R.id.textView2);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", data);
    }

    public void changeText(String data){
        this.data = data;
        textView.setText(data);
    }
}
