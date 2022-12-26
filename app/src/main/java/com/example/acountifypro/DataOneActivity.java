package com.example.acountifypro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.acountifypro.databinding.ActivityDataOneBinding;
import com.example.acountifypro.spinner.SpinnerCustomAdapter;

public class DataOneActivity extends AppCompatActivity {

    ActivityDataOneBinding binding;

    String[] categoryName = {"Food"};
    int[] icons = {R.drawable.food};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_one);
        binding = ActivityDataOneBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();

        binding.spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        SpinnerCustomAdapter customAdapter = new SpinnerCustomAdapter(getApplicationContext(),icons,categoryName);
        binding.spinner.setAdapter(customAdapter);



    }

    //Performing action onItemSelected and onNothing selected
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), categoryName[position], Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}