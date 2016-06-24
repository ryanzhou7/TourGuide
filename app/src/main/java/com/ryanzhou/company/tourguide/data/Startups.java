package com.ryanzhou.company.tourguide.data;

import com.ryanzhou.company.tourguide.model.Startup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanzhou on 6/23/16.
 */
public final class Startups {
    public final static List<Startup> startups;
    static {
        startups = new ArrayList<>();
        startups.add( new Startup("Bring Hub", R.) );
        startups.add( new Startup("Movie Pilot", R.drawable.moviepilotlogo) );
        startups.add( new Startup("Realty Mogul", R.drawable.realtymogullogo) );
        startups.add( new Startup("Patient Pop", R.drawable.patientpoplogo) );
    }
}
