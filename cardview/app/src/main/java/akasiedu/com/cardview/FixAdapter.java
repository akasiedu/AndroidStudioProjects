package akasiedu.com.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kwame on 4/29/15.
 */
public class FixAdapter extends ArrayAdapter<FixItem> {
    private final Context context;
    private final ArrayList<FixItem> values;
    ListView listView;

    public FixAdapter(Context context, ArrayList<FixItem> values){
        super(context, R.layout.activity_home);
        this.values = values;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FixItem fixItem = values.get(position);
        View rowView = inflater.inflate(R.layout.activity_home, parent, false);
        TextView faultName_id = (TextView) rowView.findViewById(R.id.faultName_id);
        TextView cause_id = (TextView) rowView.findViewById(R.id.cause_id);
        TextView solution_id = (TextView) rowView.findViewById(R.id.solution_id);

        faultName_id.setText(fixItem.getFault());
        cause_id.setText(fixItem.getCause());
        solution_id.setText(fixItem.getSolution());

        return rowView;

    }
}
