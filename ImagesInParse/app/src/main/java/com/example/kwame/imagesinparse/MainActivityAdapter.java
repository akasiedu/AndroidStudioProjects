package com.example.kwame.imagesinparse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kwame on 12/2/15.
 */
public class MainActivityAdapter extends ArrayAdapter<ParseObject> {

    private Context mContext;
    private List<ParseObject> mImages;

    public MainActivityAdapter(Context context, List<ParseObject> images){
        super(context, R.layout.single_row_image, images);
        mContext = context;
        mImages = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.single_row_image, null);
            holder = new ViewHolder();
            holder.homeImage = (ImageView) convertView.findViewById(R.id.imageViewHome);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ParseObject object = mImages.get(position);

       Picasso.with(getContext().getApplicationContext()).load(object.getParseFile("imageContent").getUrl()).noFade().into(holder.homeImage);

        return convertView;
    }

    public static class ViewHolder{
        ImageView homeImage;
        TextView homeText;
    }
}
