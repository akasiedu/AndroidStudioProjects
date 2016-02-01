package akasiedu.com.packageslider;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmergencyFixes extends Fragment {
    ListView listView;
    EmergencyFixAdapter emergencyFixAdapter;


    public EmergencyFixes() {
        // Required empty public constructor
    }

//    public static EmergencyFixes getInstance() {
////        mIndex=position;
//        EmergencyFixes emergencyFixes = new EmergencyFixes();
//        Bundle args = new Bundle();
////        args.putInt("position", position);
//        emergencyFixes.setArguments(args);
//        return emergencyFixes;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_emergency_fixes, container, false);
        listView= (ListView) layout.findViewById(R.id.listView);
        emergencyFixAdapter=new EmergencyFixAdapter(getActivity().getApplicationContext());
        listView.setAdapter(emergencyFixAdapter);
        return layout;
//        return inflater.inflate(R.layout.fragment_emergency_fixes, container, false);
    }


}
