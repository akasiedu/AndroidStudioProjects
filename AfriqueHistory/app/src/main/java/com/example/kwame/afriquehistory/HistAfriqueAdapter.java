package com.example.kwame.afriquehistory;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kwame on 10/8/15.
 */
public class HistAfriqueAdapter extends ArrayAdapter<HistAfrique> {


    private Context context;
    private List<HistAfrique> afriqueList;

    public HistAfriqueAdapter(Context context, List<HistAfrique> afriqueList) {
        super(context, android.R.layout.simple_list_item_1, afriqueList);

        this.afriqueList = afriqueList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return afriqueList.size();
    }

    @Override
    public HistAfrique getItem(int position) {
        return afriqueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;

        if (view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.single_afrique_view,null);
        }

            HistAfrique histAfrique = afriqueList.get(position);

            TextView placeName = (TextView) view.findViewById(R.id.placeName);
            placeName.setText(histAfrique.getPlaceName());

            TextView country = (TextView) view.findViewById(R.id.country);
            country.setText(histAfrique.getCountry());

            TextView province = (TextView) view.findViewById(R.id.province);
            province.setText(histAfrique.getProvince());

            TextView source = (TextView) view.findViewById(R.id.source);
            source.setText(histAfrique.getSource());

            TextView latitude = (TextView) view.findViewById(R.id.latitude);
            latitude.setText(histAfrique.getLatitude());

            TextView longitude = (TextView) view.findViewById(R.id.longitude);
            longitude.setText(histAfrique.getLongitude());




        return view;
    }

}
