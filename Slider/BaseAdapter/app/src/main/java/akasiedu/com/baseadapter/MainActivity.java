package akasiedu.com.baseadapter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
//    int[] images={R.drawable.bicycle_crossing, R.drawable.chevron_symbol, R.drawable.crossing, R.drawable.deer_crossing, R.drawable.emergency_vehicle, R.drawable.left_curve, R.drawable.no_crossing,R.drawable.no_parking, R.drawable.no_right_turn,R.drawable.no_left_turn, R.drawable.no_truck};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(this));
    }

}

class SingleRow{
    String title;
    String  description;
    int image;

    SingleRow(String title, String description, int image){
        this.title=title;
        this.description=description;
        this.image=image;
    }
}



class MyAdapter extends BaseAdapter{
    ArrayList<SingleRow> arrayList;
    Context context;

    MyAdapter(Context c){
        context=c;
        arrayList=new ArrayList<SingleRow>();

        Resources res=c.getResources();
        String[] titles=res.getStringArray(R.array.titles);
        String[] descriptions=res.getStringArray(R.array.descriptions);
        int[] images={R.drawable.bicycle_crossing, R.drawable.chevron_symbol, R.drawable.crossing, R.drawable.deer_crossing, R.drawable.emergency_vehicle, R.drawable.left_curve, R.drawable.no_crossing,R.drawable.no_parking, R.drawable.no_right_turn,R.drawable.no_left_turn, R.drawable.no_truck};

        for (int i=0;i<10;i++){
            arrayList.add(new SingleRow(titles[i],descriptions[i],images[i]));
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
        View row=inflater.inflate(R.layout.single_row, parent,false);
        TextView title= (TextView) row.findViewById(R.id.textView);
        TextView description= (TextView) row.findViewById(R.id.textView2);
        ImageView image= (ImageView) row.findViewById(R.id.imageView);

        SingleRow temp=arrayList.get(position);
        title.setText(temp.title);
        description.setText(temp.description);
        image.setImageResource(temp.image);
        return row;
    }
}