package com.example.acountifypro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.acountifypro.databinding.FragmentHomeActivityBinding;
import com.example.acountifypro.fragments.AddFragmentActivity;
import com.example.acountifypro.fragments.GraphFragmentActivity;
import com.example.acountifypro.fragments.HomeFragmentActivity;
import com.example.acountifypro.fragments.ProfileFragmentActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new HomeFragmentActivity()).commit();


        bottomNavigationView = findViewById(R.id.btm_nav_bar);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;

                switch (item.getItemId()) {
                    case R.id.home_menu: temp = new HomeFragmentActivity();
                        break;
                    case R.id.add_menu: temp = new AddFragmentActivity();
                        break;
                    case R.id.graph_menu: temp = new GraphFragmentActivity();
                        break;
                    case R.id.profile_menu: temp = new ProfileFragmentActivity();

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,temp).commit();


                return true;
            }
        });

    }
}