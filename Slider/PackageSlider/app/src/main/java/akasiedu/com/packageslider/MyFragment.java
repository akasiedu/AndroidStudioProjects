package akasiedu.com.packageslider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by kwame on 6/15/15.
 */
public class MyFragment extends Fragment {

    private TextView textView;
    private static int mIndex;
    GridViewAdapter gridViewAdapter;
    GridView gridView;

//    public MyFragment(int index){
//        mIndex=index;
//    }

    public static String [] signName={"Bicycle Cross","Chevron Symbol","Crossing",
            "Deer Crossing","Emergency Vehicle","Flagger Symbol",
            "Hill Truck","Left Curve","Left Lane Ends","Left Turn Ahead",
            "No Crossing","No Left Turn","No Parking","No Right Turn",
            "No Truck Allowed","No-U-Turn","Right Curve","Right Lane Ends",
            "Right Turn Ahead","School Crossing","Stop Ahead", "Two Way Street","Worker Symbol" };
    public static int [] roadSign={R.drawable.bicycle_crossing, R.drawable.chevron_symbol, R.drawable.crossing,
            R.drawable.deer_crossing, R.drawable.emergency_vehicle, R.drawable.flagger_symbol,
            R.drawable.hill_track_sign, R.drawable.left_curve, R.drawable.left_lane_ends,
            R.drawable.left_turn_ahead, R.drawable.no_crossing, R.drawable.no_left_turn,
            R.drawable.no_parking,R.drawable.no_right_turn, R.drawable.no_truck,
            R.drawable.no_u_turn, R.drawable.right_curve, R.drawable.right_lane_ends,
            R.drawable.right_turn_ahead, R.drawable.school_crossing, R.drawable.stop_ahead,
            R.drawable.two_way_street, R.drawable.worker_symbol };

    public static MyFragment getInstance() {
        MyFragment myFragment = new MyFragment();
        Bundle args = new Bundle();
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.my_fragment, container, false);
        gridView= (GridView) layout.findViewById(R.id.gridView);
        gridViewAdapter=new GridViewAdapter(getActivity().getApplicationContext(), signName, roadSign);
        gridView.setAdapter(gridViewAdapter);
       return layout;
    }
    

}

