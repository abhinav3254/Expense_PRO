package com.example.newapp.frames;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newapp.R;
import com.example.newapp.database.DBHelper;
import com.google.android.material.button.MaterialButton;

public class AddFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add, container, false);

        TextView add_in = view.findViewById(R.id.add_in);
        TextView add_ex = view.findViewById(R.id.add_ex);

        getFragmentManager().beginTransaction().replace(R.id.frame_add,new ExpenseFragment()).commit();

        add_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,new HomeFragment()).commit();
                getFragmentManager().beginTransaction().replace(R.id.frame_add,new IncomeFragment()).commit();
            }
        });

        add_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.frame_add,new ExpenseFragment()).commit();
            }
        });

        return view;
    }
}