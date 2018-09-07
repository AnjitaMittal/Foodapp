package com.example.hp.foodapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.example.hp.foodapp.ViewPager_fragment.KEY_POSITION;
import static com.example.hp.foodapp.ViewPager_fragment.Value;

public class ingredientFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ingredients_list,container,false);
        int position = getArguments().getInt(KEY_POSITION);
        int value=getArguments().getInt(Value);
        RecyclerView recyclerView = view.findViewById(R.id.ri);
        recyclerView.setAdapter(new InDAdapter(position,value));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }
}
