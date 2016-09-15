package org.fundacionjala.movies;


/**
 * Handles the kinds of movies.
 *
 * @autor Bruno Vasquez
 */
public abstract class Movie {
    private static final int POINT = 1;
    protected double amount;
    protected int daysLimit;
    protected double increment;
    final private String title;

    /**
     * It is the constructor of movies.
     *
     * @param title an String to set the title of the movie
     * @param amount an integer to set the amount of movie
     * @param increment an double to set the increment of movie
     * @param daysLimit an integer to set the days limit
     */
    public Movie(String title, double amount, double increment, int daysLimit) {
        this.title = title;
        this.amount = amount;
        this.increment = increment;
        this.daysLimit = daysLimit;
    }

    /**
     * Bring back the frequent renter points of a movie
     *
     * @return the frequent points.
     */
    public int frequentRenterPoints(int daysRented) {
        return POINT;
    }

    /**
     * Calculates the amount to pay of a movie
     *
     * @return the total amount.
     */
    public double calculatePrice(int daysRented) {
        return (daysRented > daysLimit) ? amount + (daysRented - daysLimit) * increment : amount;
    }

    /**
     * Bring back the title of a movie
     *
     * @return the title.
     */
    public String getTitle() {
        return title;
    }

}


