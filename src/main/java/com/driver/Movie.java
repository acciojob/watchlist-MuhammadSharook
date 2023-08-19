package com.driver;

import java.util.ArrayList;

public class Movie
{
    private String moviename;
    private int durationInMinutes;
    private double imdbRating;

    public Movie() {
    }

    public Movie(String moviename, int durationInMinutes, double imdbRating) {
        this.moviename = moviename;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getmoviename() {
        return moviename;
    }

    public void setmoviename(String moviename) {
        this.moviename = moviename;
    }


}
