package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chasen on 12/9/2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Earthquake currentQuake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);

        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        magnitude.setText("" + currentQuake.getMagnitude());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView location = (TextView) listItemView.findViewById(R.id.location);

        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        location.setText(currentQuake.getLocation());

        TextView date = (TextView) listItemView.findViewById(R.id.date);

        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        date.setText(currentQuake.getDate());

        return listItemView;
    }
}
