package akasiedu.com.packageslider;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kwame on 8/19/15.
 */
public class EmergencyFixAdapter extends BaseAdapter {
    ArrayList<SingleRow> arrayList;
    Context context;

    EmergencyFixAdapter(Context c){
        context=c;
        arrayList=new ArrayList<SingleRow>();

        Resources resources=c.getResources();
        String[] titles=resources.getStringArray(R.array.signs);
        String[] description=resources.getStringArray(R.array.descriptions);

        for (int i=0;i<description.length;i++){
            arrayList.add(new SingleRow(titles[i], description[i]));
        }
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.listview_items,parent,false);
        TextView title= (TextView) row.findViewById(R.id.textView);
        TextView description= (TextView) row.findViewById(R.id.textView2);

        SingleRow temp=arrayList.get(position);
        title.setText(temp.title);
        description.setText(temp.description);

        return row;
    }

}

class SingleRow{
    String title;
    String description;
//    int image;

    SingleRow(String title, String description){
        this.title=title;
        this.description=description;
//        this.image=image;
    }
}

