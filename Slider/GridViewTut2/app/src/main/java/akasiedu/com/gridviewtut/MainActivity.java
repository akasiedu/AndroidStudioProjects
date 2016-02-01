package akasiedu.com.gridviewtut;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView= (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new MyAdapter(this));
        gridView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this, MyDialog.class);
        ViewHolder holder= (ViewHolder) view.getTag();
        Country temp= (Country) holder.myCountry.getTag();
        intent.putExtra("countryImage",temp.image);
        intent.putExtra("countryName",temp.countryName);
        startActivity(intent);
    }
}

class Country{
    String countryName;
    int image;

    Country(int image, String countryName){
        this.image=image;
        this.countryName=countryName;

    }
}

class MyAdapter extends BaseAdapter{
    Context context;


    ArrayList<Country> countryList;

    MyAdapter(Context context){
        this.context=context;
      countryList=new ArrayList<Country>();
        Resources res=context.getResources();
        String[] countryName=res.getStringArray(R.array.signs);
        int[] images={R.drawable.bicycle_crossing, R.drawable.chevron_symbol, R.drawable.crossing, R.drawable.deer_crossing, R.drawable.emergency_vehicle, R.drawable.left_curve, R.drawable.no_crossing,R.drawable.no_parking, R.drawable.no_right_turn,R.drawable.no_left_turn, R.drawable.no_truck};

        for (int i=0;i<10;i++){
            Country tempCountry=new Country(images[i],countryName[i]);
            countryList.add(tempCountry);
        }
    }


    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    View row=convertView;
        ViewHolder holder=null;
        if (row==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             row = inflater.inflate(R.layout.single_item, parent, false);
            holder=new ViewHolder(row);
            row.setTag(holder);

        } else{
             holder= (ViewHolder) row.getTag();
        }
        Country temp=countryList.get(position);
        holder.myCountry.setImageResource(temp.image);
        holder.myCountry.setTag(temp);
        return row;
    }


}

class ViewHolder{
    ImageView myCountry;

    ViewHolder(View v){
        myCountry= (ImageView) v.findViewById(R.id.imageView);
    }

}