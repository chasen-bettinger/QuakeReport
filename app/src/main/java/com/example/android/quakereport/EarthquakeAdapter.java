package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Chasen on 12/9/2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

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

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        magnitude.setText("" + currentQuake.getMagnitude());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView specificLocation = (TextView) listItemView.findViewById(R.id.specificlocation);
        TextView location = (TextView) listItemView.findViewById(R.id.location);

        String textToManipulate = currentQuake.getLocation();

        if (textToManipulate.contains("of")) {
            specificLocation.setText(specificLocation(textToManipulate));
            location.setText(editLocation(textToManipulate));
        } else {
            specificLocation.setText("Near the");
            location.setText(currentQuake.getLocation());
        }

        TextView date = (TextView) listItemView.findViewById(R.id.date);

        Date dateInMilliseconds = new Date(currentQuake.getTimeInMilliseconds());

        String formmatedDate = formatDate(dateInMilliseconds);

        date.setText(formmatedDate);

        TextView time = (TextView) listItemView.findViewById(R.id.time);

        String formattedTime = formatTime(dateInMilliseconds);

        time.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        String formattedDate = dateFormat.format(date);
        return formattedDate;
    }

    private String formatTime(Date date) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(date);
        return formattedTime;
    }

    private String specificLocation(String text) {
        int index = text.indexOf("of");
        return text.substring(0, index + 2);
    }

    private String editLocation(String text) {
        int index = text.indexOf("of");
        int lengthOfText = text.length();
        return text.substring(index + 3, lengthOfText);
    }

    private int getMagnitudeColor(Double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }


}
