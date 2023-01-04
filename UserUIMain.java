package com.example.gokfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class UserUIMain extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Bundle bundle = new Bundle();
Gymfragment gymfragment = new Gymfragment();
WeightFragment weightFragment=new WeightFragment();
FoodFragment foodFragment=new FoodFragment();
PersonalFragment personalFragment=new PersonalFragment();
SettingFragment settingFragment=new SettingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setIcon(R.drawable.gym);
        setContentView(R.layout.activity_user_uimain);
       String id = getIntent().getStringExtra("UUID");


        bottomNavigationView =findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.settings:
                        SettingFragment myFragment= new SettingFragment();
                        String id = getIntent().getStringExtra("UUID");
                        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();


                        bundle.putString("ID", id);  // Key, value

                        settingFragment.setArguments(bundle);
                     //   fragmentTransaction.replace(R.id.settings,settingFragment).commit();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFragment).commit();
                        return true;
                    case R.id.person:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,personalFragment).commit();
                        return true;
                    case R.id.food:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,foodFragment).commit();
                        return true;
                    case R.id.check:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,weightFragment).commit();
                        return true;
                    case R.id.fitness:

                        getSupportFragmentManager().beginTransaction().replace(R.id.container,gymfragment).commit();
                        return true;

                }

                return false;
            }
        });

    }
}