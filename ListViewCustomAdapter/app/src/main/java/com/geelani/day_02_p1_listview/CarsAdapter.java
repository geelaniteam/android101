package com.geelani.day_02_p1_listview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarsAdapter extends BaseAdapter {

    private final Context mContext;
    private List<Car> mCars;

    public CarsAdapter(Context mContext, List<Car> mCars) {
        this.mContext = mContext;
        this.mCars = mCars;
    }

    @Override
    public int getCount() {
        if (mCars == null || mCars.size() == 0) {
            return -1;
        }
        return mCars.size();
    }

    @Override
    public Object getItem(int position) {
        if (mCars == null || mCars.size() == 0) {
            return null;
        }
        return mCars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater myInflater = LayoutInflater.from(mContext);
            view = myInflater.inflate(R.layout.custom_list_item, parent, false);

            ImageView imageView = view.findViewById(R.id.iconID);
            TextView textView = view.findViewById(R.id.name);

            textView.setText(mCars.get(position).getName());
            imageView.setImageResource(mCars.get(position).getIconID());
        }

        return view;
    }


}