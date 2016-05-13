package com.example.cracking.groupproj;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomListViewAdapter extends BaseAdapter {

    private ArrayList<listData> ogDataList;
    private List<listData> dataList = null;
    LayoutInflater inflater;
    Context mContext;

    public CustomListViewAdapter(Context context, List<listData> objects) {
        mContext = context;
        this.dataList = objects;
        inflater = LayoutInflater.from(mContext);
        this.ogDataList = new ArrayList<listData>();
        this.ogDataList.addAll(dataList);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public listData getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataList.get(position).hashCode();
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtName;
        TextView txtTel;
    }

    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_recent_item, null);
            holder.txtTel = (TextView) view.findViewById(R.id.Tel);
            holder.txtName = (TextView) view.findViewById(R.id.Name);
            holder.imageView = (ImageView) view.findViewById(R.id.User);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtTel.setText(dataList.get(position).getTel());
        holder.txtName.setText(dataList.get(position).getName());
        holder.imageView.setImageResource(dataList.get(position).getImageId());

        return view;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataList.clear();
        if (charText.length() == 0) {
            dataList.addAll(ogDataList);
        } else {
            for (listData listdata : ogDataList) {
                if (listdata.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    dataList.add(listdata);
                }
            }
        }
        notifyDataSetChanged();
    }

    private class DataFilter extends Filter {

        String TAG = "CustomListViewAdapter";

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = ogDataList;
                results.count = ogDataList.size();
            } else {
                ArrayList<listData> filterDataList = new ArrayList<listData>();
                filterDataList.clear();
                for (listData data : dataList) {
                    if (data.getName().toUpperCase().startsWith(constraint.toString().toUpperCase()))
                        filterDataList.add(data);
                }
                results.values = filterDataList;
                results.count = filterDataList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                dataList = (ArrayList<listData>) results.values;
                notifyDataSetChanged();
                for (int i = 0; i < dataList.size(); i++) {
                    Log.d(TAG, "PublishResults [" + i + "] : " + dataList.get(i).getName());
                }
            }
        }

    }
}