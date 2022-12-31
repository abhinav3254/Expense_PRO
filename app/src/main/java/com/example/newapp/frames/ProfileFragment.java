package com.example.newapp.frames;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newapp.R;
import com.example.newapp.database.ProfileDBHelper;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    View view;
    ArrayList<String> user_name_id,user_name;
    ProfileDBHelper profileDBHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);


        MaterialCardView profile_card = view.findViewById(R.id.profile_card);
        MaterialButton edit_profile_btn = view.findViewById(R.id.edit_profile_btn);

        profile_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), ProfileActivity.class);
//                startActivity(intent);
            }
        });

        edit_profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), ProfileActivity.class);
//                startActivity(intent);
            }
        });


        TextView name_fp_user = view.findViewById(R.id.name_fp_user);

        user_name = new ArrayList<>();
        user_name_id = new ArrayList<>();
        profileDBHelper = new ProfileDBHelper(view.getContext());
        int len = storeDataInArrays();

//        ProfileActivity profileActivity = new ProfileActivity(String.valueOf(user_name_id.get(0)),String.valueOf(user_name.get(0)));

        name_fp_user.setText(String.valueOf(user_name.get(len)));

        getFragmentManager().beginTransaction().detach(this).attach(this).commit();


        return view;
    }

    public int storeDataInArrays () {
        Cursor cursor = profileDBHelper.readAllData();
        if (cursor.getCount() == 0) {

        } else {
            while (cursor.moveToNext()) {
                user_name_id.add(cursor.getString(0));
                user_name.add(cursor.getString(1));
            }
        }
        return cursor.getCount()-1;
    }
}