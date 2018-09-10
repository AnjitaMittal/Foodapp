package com.example.hp.foodapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class DirectionsAdapter extends RecyclerView.Adapter<DirectionsAdapter.DirectionHolders> {
private String[] directions;
// private final String[] ingridients;

public DirectionsAdapter(int position, int value) {

    this.directions = Foods.directions[position].split("`");

}
    @NonNull
    @Override
    public DirectionHolders onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new DirectionHolders(view);
    }

    @Override
    public void onBindViewHolder (@NonNull DirectionsAdapter.DirectionHolders holder, int position){
        holder.checkBox.setText(directions[position]);
        //  holder.checkBox.setText(directions[position]);
    }

    @Override
    public int getItemCount () {
        return directions.length;
    }

    public class DirectionHolders extends RecyclerView.ViewHolder {
        public CheckBox checkBox;

        public DirectionHolders(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);

        }
    }


}