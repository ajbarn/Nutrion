package com.cass.nutrition.app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cass.nutrition.app.Models.Food;
import com.cass.nutrition.app.R;

import java.util.ArrayList;
import java.util.List;

public class StableArrayAdapter extends ArrayAdapter<Food> {

    List<Food> mIdMap;

    public StableArrayAdapter(Context context, int textViewResourceId,
                              List<Food> objects) {
        super(context, textViewResourceId, objects);
        mIdMap = new ArrayList<Food>(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        }
        TextView firstRow;
        firstRow= (TextView) convertView.findViewById(R.id.calorie_count);
        firstRow.setText(mIdMap.get(position).getCalories());

        TextView listText = (TextView) convertView.findViewById(R.id.food_name);
        listText.setText(mIdMap.get(position).getName());

        return convertView;

    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}