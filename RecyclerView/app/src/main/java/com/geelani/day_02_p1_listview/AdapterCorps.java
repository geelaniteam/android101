package com.geelani.day_02_p1_listview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterCorps extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<Crop> items = new ArrayList<>();
    private Context ctx;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterCorps(Context context, RecyclerView view, List<Crop> items) {
        this.items = items;
        ctx = context;
    }


    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView desc;
        public TextView name;
        public ImageView image;
        public RelativeLayout childView;

        public OriginalViewHolder(View v) {
            super(v);
            desc =  v.findViewById(R.id.desc);
            childView =  v.findViewById(R.id.child_parent);
            name =  v.findViewById(R.id.name);
            image =  v.findViewById(R.id.image);
        }
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, parent, false);
            vh = new OriginalViewHolder(v);
            return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

            final Crop crop = items.get(position);
            OriginalViewHolder vItem = (OriginalViewHolder) holder;
            vItem.name.setText(crop.name);
            vItem.desc.setText(crop.desc);
            //loading image from picasso
        Picasso.get().load(crop.image).into(vItem.image);

        //setting onclick listener to child view
        vItem.childView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, CropDetailActivity.class);
                intent.putExtra("name",crop.getName());
                intent.putExtra("desc",crop.getDesc());
                intent.putExtra("imageUrl",crop.getImage());
                ctx.startActivity(intent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.size();
    }


}