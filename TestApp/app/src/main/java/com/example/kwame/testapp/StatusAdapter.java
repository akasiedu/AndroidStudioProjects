package com.example.kwame.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseObject;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by kwame on 11/17/15.
 */
public class StatusAdapter extends ArrayAdapter<ParseObject> {
   protected Context mContext;
    protected List<ParseObject> mStatus;

    public StatusAdapter(Context context, List<ParseObject> status){
        super(context, R.layout.single_custom_status, status);
        mContext = context;
        mStatus = status;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.single_custom_status, null);
            holder = new ViewHolder();
            holder.userName = (TextView) convertView.findViewById(R.id.userName);
            holder.userPost = (TextView) convertView.findViewById(R.id.userPost);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ParseObject mStatusObject = mStatus.get(position);

        //content
        String username = mStatusObject.getString("user");
        holder.userName.setText(username);

        String userpost = mStatusObject.getString("newStatus");
        holder.userPost.setText(userpost);

        return convertView;
    }



    public static class ViewHolder{
        TextView userName;
        TextView userPost;
    }
}
