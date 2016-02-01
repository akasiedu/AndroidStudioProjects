package akasiedu.com.packageslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kwame on 8/19/15.
 */
public class GridViewAdapter extends BaseAdapter {

    String[] results;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater=null;

    public GridViewAdapter(Context context, String[] signName, int[] roadSign){
        results=signName;
        context=context;
        imageId=roadSign;

        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return results.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class Holder{
        TextView textView;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ;Holder holder=new Holder();
        View rowView;

        rowView=inflater.inflate(R.layout.gridview_item, null);
        holder.textView= (TextView) rowView.findViewById(R.id.signName);
        holder.imageView= (ImageView) rowView.findViewById(R.id.roadSign);

        holder.textView.setText(results[position]);
        holder.imageView.setImageResource(imageId[position]);

        return rowView;
    }

}
