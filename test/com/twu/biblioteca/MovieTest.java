package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieTest {
    private ArrayList<Movie> generateNewMovielist(){
        Movie mNos = new Movie("Nosferatu","F.W. Murnau",1922, 8);
        Movie mSam = new Movie("Samurai Cop","Amir Shervan",1991, -1);
        Movie mPi = new Movie("Pi","Darren Aronofsky",1991, 7);


        ArrayList<Movie> ml = new ArrayList<Movie>();

        ml.add(mNos);
        ml.add(mSam);
        ml.add(mPi);

        return ml;
    }
}
