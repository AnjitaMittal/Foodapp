package com.example.hp.foodapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class InDAdapter extends RecyclerView.Adapter<InDAdapter.DirectionHolder> {
   // private final String[] directions;
    private final String[] ingridients;

    public InDAdapter(int position,int value) {

        this.ingridients = Foods.ingredients[position].split("`");


    }

    @NonNull
    @Override
    public DirectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new DirectionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectionHolder holder, int position) {
        holder.checkBox.setText(ingridients[position]);
      //  holder.checkBox.setText(directions[position]);
    }

    @Override
    public int getItemCount() {
        return ingridients.length;
    }

    public class DirectionHolder extends RecyclerView.ViewHolder {
       public CheckBox checkBox;
        public DirectionHolder(View itemView) {
            super(itemView);
             checkBox=itemView.findViewById(R.id.checkBox);

        }
    }
}
