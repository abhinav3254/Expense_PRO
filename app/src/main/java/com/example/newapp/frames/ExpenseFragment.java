package com.example.newapp.frames;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newapp.ExtraStuffs;
import com.example.newapp.R;
import com.example.newapp.database.DBHelper;
import com.google.android.material.button.MaterialButton;

import java.util.Calendar;

public class ExpenseFragment extends Fragment {

    ExtraStuffs extraStuffs = new ExtraStuffs();

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_expense, container, false);


        MaterialButton button = view.findViewById(R.id.save_btn);
        EditText title_et = view.findViewById(R.id.title);
        EditText amount_et = view.findViewById(R.id.amount);

        TextView date_et = view.findViewById(R.id.date);
        date_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                extraStuffs.dateSet(view.getContext(),date_et);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = title_et.getText().toString().trim();
                String amount = amount_et.getText().toString().trim();
                String date = date_et.getText().toString().trim();

                if (date.isEmpty()) {
                    date = ExtraStuffs.todayDate();
                }


                if (title.isEmpty() || amount.isEmpty() || date.isEmpty()) {
                    Toast.makeText(view.getContext(), "Fields can't be empty", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper dbHelper = new DBHelper(view.getContext());
                    boolean ans = dbHelper.addEntry(title,Double.parseDouble(amount)*-1,date);

                    if (ans) {
                        Toast.makeText(view.getContext(), "Added", Toast.LENGTH_SHORT).show();

                        FragmentTransaction fragmentTransaction = getActivity()
                                .getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_main, new HomeFragment());
                        fragmentTransaction.commit();

                    } else {
                        Toast.makeText(view.getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }
}