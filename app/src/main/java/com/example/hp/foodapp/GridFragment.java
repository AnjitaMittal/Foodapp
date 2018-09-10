package com.example.hp.foodapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GridFragment extends Fragment{
    interface OnFoodClickListener {
        void onGridFoodClick(int position);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.grid,container,false);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int columns = (int) (dpWidth / 200  );
        RecyclerView recyclerView = view.findViewById(R.id.gridrecycle);
        Recycleviewadapter recycleviewadapter=new Recycleviewadapter((Recycleviewadapter.OnFoodClickListener)getActivity());
        recyclerView.setAdapter(recycleviewadapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columns));
        return view;
    }
}
