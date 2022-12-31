package com.example.newapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.newapp.frames.AddFragment;
import com.example.newapp.frames.GraphFragment;
import com.example.newapp.frames.HomeFragment;
import com.example.newapp.frames.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,new HomeFragment()).commit();
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.btm_view);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;

                switch (item.getItemId()) {
                    case R.id.home :temp = new HomeFragment();
                        break;
                    case R.id.profile: temp = new ProfileFragment();
                        break;
                    case R.id.add : temp = new AddFragment();
                        break;
                    case R.id.graph: temp = new GraphFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,temp).commit();

                return true;
            }
        });
    }
}