package com.example.acountifypro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.acountifypro.databinding.ActivityDataOneBinding;

public class DataOneActivity extends AppCompatActivity {

    ActivityDataOneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_one);
        binding = ActivityDataOneBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();

    }
}