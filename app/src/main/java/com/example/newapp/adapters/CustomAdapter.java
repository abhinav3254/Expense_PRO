package com.example.newapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newapp.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    private ArrayList expense_title,expense_amount;

    public CustomAdapter(Context context, ArrayList expense_title, ArrayList expense_amount) {
        this.context = context;
        this.expense_title = expense_title;
        this.expense_amount = expense_amount;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom_recyler,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.custom_title.setText(String.valueOf(expense_title.get(position)));
        holder.custom_amount.setText(String.valueOf(expense_amount.get(position)));

    }

    @Override
    public int getItemCount() {
        return expense_title.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView custom_amount,custom_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            custom_amount = itemView.findViewById(R.id.custom_amount);
            custom_title = itemView.findViewById(R.id.custom_title);

        }
    }
}
