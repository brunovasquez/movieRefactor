package org.fundacionjala.movies;

import java.util.HashMap;

class Rental {
    public static final int NEW_RELEASE = 1;
    public static final int DAYS_RENTED = 1;
    public static final int RENTER_POINT = 1;
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    private Movie movie;
    private int daysRented;
    private HashMap<Integer, Price> strategyAvailable = new HashMap<Integer, Price>();
    private Price strategyUsed;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
        strategyAvailable.put(CHILDRENS, new PriceChildren());
        strategyAvailable.put(NEW_RELEASE, new PriceNewRelease());
        strategyAvailable.put(REGULAR, new PriceRegular());
        strategyUsed = strategyAvailable.get(movie.getPriceCode());
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int calculateFrequentRenterPoints() {
        int frequentRenterPoints = RENTER_POINT;
        // add bonus for a two day new release rental
        if ((movie.getPriceCode() == NEW_RELEASE) && getDaysRented() > DAYS_RENTED)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public double calculateAmount() {
        return strategyUsed.calculatePrice(this);
    }
}