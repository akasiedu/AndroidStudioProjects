package com.example.kwame.know;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoadSign extends Fragment {

    protected List<ParseObject> roadSigns;
    public RoadSign() {
        // Required empty public constructor
    }

    public void queryImagesFromParse(){
        ParseQuery<ParseObject> imageQuery = new ParseQuery<ParseObject>("RoadSIgns");
        imageQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null){
                    View view;
                    LayoutInflater inflater = null;
                    ViewGroup container = null;
                    view = inflater.inflate(R.layout.fragment_road_sign, container, false);
                    ListView listView = (ListView) view.findViewById(R.id.roadSignList);
                    RoadSignAdapter adapter = new RoadSignAdapter(getActivity(), roadSigns);
                    listView.setAdapter(adapter);
                }
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_road_sign, container, false);
        View view = inflater.inflate(R.layout.fragment_road_sign, container, false);
        ListView listView = (ListView) view.findViewById(R.id.roadSignList);
        RoadSignAdapter adapter = new RoadSignAdapter(getActivity(), roadSigns);
        listView.setAdapter(adapter);
        return view;

    }


}
