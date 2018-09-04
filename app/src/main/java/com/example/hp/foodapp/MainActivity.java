package com.example.hp.foodapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends LoggingActivity implements Recycleviewadapter.OnFoodClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment savedFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.placeHolder);
       if(savedFragment==null) {
           MainFragment mainFragment = new MainFragment();
           FragmentManager fragmentManager = getSupportFragmentManager();
           FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
           fragmentTransaction.add(R.id.placeHolder, mainFragment);
           fragmentTransaction.commit();
       }
    }
    public void onFoodClick(int position)
    {
        Toast.makeText(this, Foods.names[position], Toast.LENGTH_SHORT).show();
    }
}
