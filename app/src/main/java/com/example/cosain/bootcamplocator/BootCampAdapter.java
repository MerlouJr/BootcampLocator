package com.example.cosain.bootcamplocator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cosain on 8/15/2017.
 */

public class BootCampAdapter extends RecyclerView.Adapter<BootCampAdapter.MyViewHolder> {


    private List<Recycler> bootCampsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, address ;
        public ImageView imageID;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            address = (TextView) view.findViewById(R.id.address);
            imageID = (ImageView) view.findViewById(R.id.imageView);

        }
    }


    public BootCampAdapter(List<Recycler> bootCampsList) {
        this.bootCampsList = bootCampsList;
    }



    @Override
    public BootCampAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.boot_camp_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BootCampAdapter.MyViewHolder holder, int position) {
        Recycler campList = bootCampsList.get(position);
        holder.title.setText(campList.getTitle());
        holder.address.setText(campList.getAddress());
        holder.imageID.setImageResource(R.drawable.img);

    }

    @Override
    public int getItemCount() {
        return bootCampsList.size();
    }
}
