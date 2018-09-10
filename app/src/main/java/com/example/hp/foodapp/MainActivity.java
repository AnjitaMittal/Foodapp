package com.example.hp.foodapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends LoggingActivity implements Recycleviewadapter.OnFoodClickListener{

    private String TAG_GRID_FRAGMENT="grid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean ifTablet = getResources().getBoolean(R.bool.ifTablet);
        if (ifTablet) {
           GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(TAG_GRID_FRAGMENT);
            if (savedFragment == null) {
                GridFragment gridFragment = new GridFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, gridFragment, TAG_GRID_FRAGMENT);
                fragmentTransaction.commit();
Toast.makeText(this,"You are using Tablet",Toast.LENGTH_LONG).show();
        }
    }
    else {
            MainFragment savedFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.placeHolder);
            if (savedFragment == null) {

                MainFragment mainFragment = new MainFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, mainFragment);
                fragmentTransaction.commit();
            }
        }
    }
    public void onFoodClick(int position)
    {
        Toast.makeText(this, Foods.names[position], Toast.LENGTH_SHORT).show();
        Bundle bundle=new Bundle();
        bundle.putInt("Key_position",position);
        ViewPager_fragment viewPagerFragment = new ViewPager_fragment();
        viewPagerFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, viewPagerFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
