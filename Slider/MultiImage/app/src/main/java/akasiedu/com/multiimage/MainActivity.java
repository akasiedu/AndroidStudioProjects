package akasiedu.com.multiimage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    ListView listView;
    String[] memeTitles;
    String[] memeDescriptions;
    int[] images={R.drawable.bicycle_crossing, R.drawable.chevron_symbol, R.drawable.crossing, R.drawable.deer_crossing, R.drawable.emergency_vehicle, R.drawable.left_curve, R.drawable.no_crossing,R.drawable.no_parking, R.drawable.no_right_turn,R.drawable.no_left_turn, R.drawable.no_truck};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources=getResources();
        memeTitles=resources.getStringArray(R.array.titles);
        memeDescriptions=resources.getStringArray(R.array.descriptions);

        listView= (ListView) findViewById(R.id.listView);

        MyAdapter adapter=new MyAdapter(this, memeTitles, images, memeDescriptions);

        listView.setAdapter(adapter);
    }

}



class MyAdapter extends ArrayAdapter<String>{
    Context context;
    int[] images;
    String[] titleArray;
    String[] description;

   MyAdapter(Context c, String[] titles, int imgs[], String[] desc ){
       super(c, R.layout.single_row, R.id.textView,titles);
       this.context=c;
       this.images=imgs;
       this.titleArray=titles;
       this.description=desc;
   }


    class MyViewHolder{
        ImageView myImage;
        TextView myTitle;
        TextView myDescription;

        MyViewHolder(View v){
            myImage= (ImageView) v.findViewById(R.id.imageView);
            myTitle= (TextView) v.findViewById(R.id.textView);
            myDescription= (TextView) v.findViewById(R.id.textView2);
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    View row=convertView;
        MyViewHolder holder=null;
        if (row==null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.single_row, parent, false);
            holder=new MyViewHolder(row);
            row.setTag(holder);
        } else{
            holder= (MyViewHolder) row.getTag();

        }

//        ImageView myImage= (ImageView) row.findViewById(R.id.imageView);
//        TextView myTitle= (TextView) row.findViewById(R.id.textView);
//        TextView myDesription= (TextView) row.findViewById(R.id.textView2);

        holder.myImage.setImageResource(images[position]);
        holder.myTitle.setText(titleArray[position]);
        holder.myDescription.setText(description[position]);

        return row;
    }
}
