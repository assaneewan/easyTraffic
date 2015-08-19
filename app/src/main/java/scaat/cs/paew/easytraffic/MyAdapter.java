package scaat.cs.paew.easytraffic;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lab on 8/18/2015.
 */
public class MyAdapter extends BaseAdapter {
    //explicit
    private Context objContext;
    private int[] iconInts;
    private String[] titleStrings;

    public MyAdapter(Context objContext, int[] iconInts, String[] titleStrings) {
        this.objContext = objContext;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
    } // Constructor

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //set picture to layout listview_traffic
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = objLayoutInflater.inflate(R.layout.listview_traffic, parent, false);

        // Show Image
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imvIcon);
        iconImageView.setImageResource(iconInts[position]);

        // Show Text
        TextView titleTextView = (TextView)  view1.findViewById(R.id.txtShowTitle);
        titleTextView.setText(titleStrings[position]);


        return view1;
    }  // getView
} // Main Class
