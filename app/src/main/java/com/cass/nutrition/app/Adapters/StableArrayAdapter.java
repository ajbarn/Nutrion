package com.cass.nutrition.app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cass.nutrition.app.R;
import java.util.ArrayList;
import java.util.List;

public class StableArrayAdapter extends ArrayAdapter<String> {

    List<String> mIdMap;

    public StableArrayAdapter(Context context, int textViewResourceId,
                              List<String> objects) {
        super(context, textViewResourceId, objects);
        mIdMap = new ArrayList<String>(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        TextView firstRow = (TextView) convertView.findViewById(R.id.secondLine);
        firstRow.setText(mIdMap.get(position));

        TextView listText = (TextView) convertView.findViewById(R.id.list_text);
        listText.setText("" + position);

        return convertView;

    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}