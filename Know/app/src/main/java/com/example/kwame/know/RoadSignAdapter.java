package com.example.kwame.know;

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
 * Created by kwame on 12/21/15.
 */
public class RoadSignAdapter extends ArrayAdapter<ParseObject>{
    private Context mContext;
    private List<ParseObject> mRoadSigns;

    public RoadSignAdapter(Context context, List<ParseObject> signs) {
        super(context, R.layout.single_custom_sign, signs);
        mContext = context;
        mRoadSigns = signs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
//            convertView = LayoutInflater.from(mContext).inflate(R.layout.single_custom_sign, null);
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_custom_sign, null);
            holder = new ViewHolder();
            holder.roadSign = (ImageView) convertView.findViewById(R.id.roadSign);
            holder.signName = (TextView) convertView.findViewById(R.id.signName);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        ParseObject mRoadItems = mRoadSigns.get(position);

        //content
        Picasso.with(getContext().getApplicationContext()).load(mRoadItems.getParseFile("RoadSigns").getUrl()).noFade().into(holder.roadSign);

        return convertView;
    }

    public static class ViewHolder{
        ImageView roadSign;
        TextView signName;
    }

    public int getItemCount(){
        return mRoadSigns.size();
    }


}
