package com.geelani.day_02_p4_listviewclick;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CarsAdapter extends BaseAdapter {

    private final Context mContext;
    private List<Car> mCars;

    public CarsAdapter(Context mContext, List<Car> mFriends) {
        this.mContext = mContext;
        this.mCars = mFriends;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater myInflater = LayoutInflater.from(mContext);
            view = myInflater.inflate(R.layout.custom_list_item, parent, false);

            ImageView imageView = view.findViewById(R.id.iconID);
            TextView textView = view.findViewById(R.id.name);

            textView.setText(mCars.get(position).getName());
            imageView.setImageResource(mCars.get(position).getIconID());

            LinearLayout itemView = view.findViewById(R.id.itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(mContext, CarDetailActivity.class);
                    intent.putExtra("name",mCars.get(position).getName());
                    intent.putExtra("image",mCars.get(position).getIconID());
                    mContext.startActivity(intent);
                }
            });

            //image click listener for each row

//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(mContext,"Image Clicked",Toast.LENGTH_LONG).show();
//                }
//            });


            //text click listener for each row

//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(mContext,"Text Clicked",Toast.LENGTH_LONG).show();
//                }
//            });

        }

        return view;
    }


}