package com.example.acountifypro.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acountifypro.R;

public class SpinnerCustomAdapter extends BaseAdapter {

    Context context;
    int[] icons;
    String[] categoryNames;
    LayoutInflater inflater;

    public SpinnerCustomAdapter(Context context, int[] icons, String[] categoryNames) {
        this.context = context;
        this.icons = icons;
        this.categoryNames = categoryNames;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_spinner,null);
        ImageView icon = view.findViewById(R.id.img_one);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(icons[i]);
        names.setText(categoryNames[i]);
        return view;
    }
}
