package com.example.newapp.frames;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

        MaterialButton button = view.findViewById(R.id.save_btn);
        EditText title_et = view.findViewById(R.id.title);
        EditText amount_et = view.findViewById(R.id.amount);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = title_et.getText().toString().trim();
                String amount = amount_et.getText().toString().trim();

                DBHelper dbHelper = new DBHelper(view.getContext());
                boolean ans = dbHelper.addEntry(title,amount);
                
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
        });

        return view;
    }
}