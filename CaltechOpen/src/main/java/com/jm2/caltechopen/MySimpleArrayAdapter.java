package com.jm2.caltechopen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.lv_item_c_store, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.lv_item_c_store, parent, false);
        TextView titleView = (TextView) rowView.findViewById(R.id.title_view);
        TextView openView = (TextView) rowView.findViewById(R.id.open_view);
        TextView timeView = (TextView) rowView.findViewById(R.id.time_view);
        titleView.setText(values[0]);
        timeView.setText(values[1]);
        openView.setText(values[2]);

        return rowView;
    }
}