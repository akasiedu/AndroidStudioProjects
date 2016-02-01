package com.mytripgh.tripgh;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class LazyAdapter extends ArrayAdapter<LazyItem> {
  private final Context context;
  private final ArrayList<LazyItem> values;
  ListView listView;

  public LazyAdapter(Context context, ArrayList<LazyItem> values) {
    super(context, R.layout.activity_home,values);
    this.values = values;
    this.context = context;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    LazyItem lazyItem = values.get(position);
    View rowView = inflater.inflate(R.layout.activity_home, parent, false);
    TextView placeName_id = (TextView) rowView.findViewById(R.id.placeName_id);
    TextView description_id = (TextView) rowView.findViewById(R.id.description_id);
    TextView textViewId = (TextView) rowView.findViewById(R.id.textViewId);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.placeimage_id);


    placeName_id.setText(lazyItem.getName());
    description_id.setText(lazyItem.getDescription());
    textViewId.setText(lazyItem.getId());
    imageView.setImageResource(lazyItem.getImage());

return rowView;
  }

}
