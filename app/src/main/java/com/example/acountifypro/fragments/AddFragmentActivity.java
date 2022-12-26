package com.example.acountifypro.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acountifypro.DataOneActivity;
import com.example.acountifypro.R;
import com.example.acountifypro.databinding.FragmentAddActivityBinding;
import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragmentActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragmentActivity extends Fragment {

    FragmentAddActivityBinding binding;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

//    public AddFragmentActivity() {
//        // Required empty public constructor
//    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment AddFragmentActivity.
//     */
    // TODO: Rename and change types and number of parameters
//    public static AddFragmentActivity newInstance(String param1, String param2) {
//        AddFragmentActivity fragment = new AddFragmentActivity();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    //    public static AddFragmentActivity newInstance(int index) {
//        AddFragmentActivity f = new AddFragmentActivity();
//        Bundle args = new Bundle();
//        args.putInt("index", index);
//        f.setArguments(args);
//        return f;
//    }

    public static Fragment newInstance()
    {
        AddFragmentActivity myFragment = new AddFragmentActivity();
        return myFragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAddActivityBinding.inflate(getLayoutInflater(),container,false);
        
        binding.expenseFragmentAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Expense", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),DataOneActivity.class);
                startActivity(intent);
            }
        });

        binding.incomeFragmentAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Income", Toast.LENGTH_SHORT).show();
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

}