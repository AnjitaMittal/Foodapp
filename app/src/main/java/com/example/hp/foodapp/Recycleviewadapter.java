package com.example.hp.foodapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static java.security.AccessController.getContext;

public class Recycleviewadapter extends RecyclerView.Adapter<Recycleviewadapter.ListHolder> {
    OnFoodClickListener onFoodClickListener;
     public Recycleviewadapter(OnFoodClickListener onFoodClickListener)
     {
    this.onFoodClickListener =onFoodClickListener;
     }


    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        boolean ifTablet = parent.getResources().getBoolean(R.bool.ifTablet);
        View view;
       if( ifTablet){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_items,parent,false);
        }
        else{
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        }
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        holder.bindView(position);
    }


    @Override
    public int getItemCount() {
        return Foods.names.length;
    }

    interface OnFoodClickListener {
   void onFoodClick(int position);

     }

    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;

        public ListHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.foodimage);
            textView = itemView.findViewById(R.id.foodname);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            String photouri= String.valueOf(Foods.ids[position]);
            Picasso.get().load(Foods.ids[position]).resize(80,80).into(imageView);
         //  imageView.setImageResource(Integer.parseInt(photouri));
            textView.setText(Foods.names[position]);

        }

        @Override
        public void onClick(View v) {
            onFoodClickListener.onFoodClick(getAdapterPosition());

        }
    }
}
