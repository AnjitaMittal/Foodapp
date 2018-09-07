package com.example.hp.foodapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPager_fragment extends Fragment {
    int value=0 ;
    public static final String KEY_POSITION = "key_position";
    public static final String Value = "key_value";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_view_pager_fragment, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewpager);

        int position= getArguments().getInt("KEY_POSITION");

        Bundle bundle=new Bundle();
        bundle.putInt("KEY_POSITION",position);
        bundle.putInt("Value", value);
        getActivity().setTitle(Foods.names[position]);
        final ingredientFragment ingredients =new ingredientFragment();
        ingredients.setArguments(bundle);
         final directionsFragment dierections=new directionsFragment();
         dierections.setArguments(bundle);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position!=0)
                {
                    value=1;
                }
                return position == 0 ? ingredients : dierections;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Ingeridients" : "Directions";
            }
        });


//Bundle bundle=new Bundle();
//bundle.getInt("key_position");
    TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

   // getActivity().setTitle(Foods.names[position]);
        return view;
}

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }

}
