package com.example.newapp.frames;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newapp.R;
import com.example.newapp.adapters.CustomAdapter;
import com.example.newapp.database.DBHelper;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    View view;
    ArrayList<String> expense_id,expense_title,expense_amount;
    DBHelper dbHelper;
    CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        dbHelper = new DBHelper(view.getContext());
        expense_id = new ArrayList<>();
        expense_title = new ArrayList<>();
        expense_amount = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(view.getContext(),expense_title,expense_amount);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    void storeDataInArrays() {
        Cursor cursor = dbHelper.readAllData();
        if (cursor.getCount() == 0) {

        } else {
            while (cursor.moveToNext()) {
                expense_id.add(cursor.getString(0));
                expense_title.add(cursor.getString(1));
                expense_amount.add(cursor.getString(2));
            }
        }
    }
}