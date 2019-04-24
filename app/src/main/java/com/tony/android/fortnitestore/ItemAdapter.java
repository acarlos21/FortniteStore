package com.tony.android.fortnitestore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<FortniteBundle> {

    Context context;
    public ItemAdapter(Context context, ArrayList<FortniteBundle> list) {
        super(context, 0, list);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.fortnite_item, parent, false);
        final FortniteBundle currentItem = getItem(position);
        ImageView fortniteImage = convertView.findViewById(R.id.fortniteImage);
        //fortniteImage.setImageResource(currentItem.getImage());
        TextView fortniteName = convertView.findViewById(R.id.fortniteName);
        fortniteName.setText(currentItem.getName());


        return convertView;


    }
}
