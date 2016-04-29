package com.example.cracking.groupproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class recentListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<listData> arrData;
    private LayoutInflater inflater;

    public recentListAdapter(Context c, ArrayList<listData> arr) {
        this.context = c;
        this.arrData = arr;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {
        return arrData.size();
    }
    public Object getItem(int position) {
        return arrData.get(position).getName();
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_recent_item, parent, false);
        }

        ImageView image = (ImageView)convertView.findViewById(R.id.recentUser);
        image.setImageResource(arrData.get(position).getImage());

        TextView name = (TextView)convertView.findViewById(R.id.recentName);
        name.setText(arrData.get(position).getName());

        TextView tel = (TextView)convertView.findViewById(R.id.recentTel);
        tel.setText(arrData.get(position).getTel());

        return convertView;
    }

}