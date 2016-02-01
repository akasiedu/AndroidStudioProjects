package com.example.kwame.histafrique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kwame on 10/8/15.
 */
public class HistAfriqueAdapter extends ArrayAdapter<HistAfrique>{

    private Context context;
    private List<HistAfrique> afriqueList;

    public HistAfriqueAdapter(Context context, List<HistAfrique> afriqueList) {
        super(context, android.R.layout.simple_list_item_1, afriqueList);

        this.afriqueList = afriqueList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View v = convertView;

        if (v==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.single_afrique_view, null);
        }

        HistAfrique histAfrique = afriqueList.get(position);

        TextView placeName = (TextView) v.findViewById(R.id.placeName);
        placeName.setText(histAfrique.getPlaceName());

        TextView country = (TextView) v.findViewById(R.id.country);
        country.setText(histAfrique.getCountry());

        TextView province = (TextView) v.findViewById(R.id.province);
        province.setText(histAfrique.getProvince());

//        TextView likes = (TextView) v.findViewById(R.id.likes);
//        likes.setText(histAfrique.getLikes());

        return v;
    }


}
