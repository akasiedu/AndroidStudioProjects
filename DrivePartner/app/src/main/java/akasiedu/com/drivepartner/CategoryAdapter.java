package akasiedu.com.drivepartner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kwame on 4/27/15.
 */
public class CategoryAdapter extends BaseAdapter {
    String [] result;
    Context context;
    int [] imgId;
    private static LayoutInflater inflater=null;
    public CategoryAdapter(CategoryActivity categoryActivity, String[] catList, int[] catIcons){

        result=catList;
        context=categoryActivity;
        imgId=catIcons;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holding{
        TextView txt;
        ImageView imgView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holding holder = new Holding();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_item, null);
        holder.txt=(TextView) rowView.findViewById(R.id.textView1);
        holder.imgView=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.txt.setText(result[position]);
        holder.imgView.setImageResource(imgId[position]);

        return rowView;
    }
}
