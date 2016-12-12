package com.example.android.quakereport;

import android.content.Context;
import android.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;

import static com.example.android.quakereport.EarthquakeActivity.LOG_TAG;

/**
 * Created by Chasen on 12/12/2016.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {


    private String mURL;

    public EarthquakeLoader(Context context, String url) {

        super(context);
        mURL = url;

        Log.v("EarthquakeLoader", "EarthquakeLoader just began!");
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {

        if (mURL == null) {
            return null;
        }

        Log.v("EarthquakeLoader", "Loading data!");

        return QueryUtils.fetchEarthquakeData(mURL);
    }
}
