package org.fundacionjala.movies;

/**
 * Handles the dates of release movies
 *
 * @autor Bruno Vasquez
 */
public class MovieRelease extends Movie {

    private static final int DAYS_LIMIT = 1;
    private static final int TWO_POINTS = 2;
    private static final int ONE_POINT = 1;
    private static final int THIS_AMOUNT = 3;
    private static final int INCREMENT = 0;

    /**
     * It is the constructor of release movies
     *
     * @param title an String to set the title of the release movies
     */
    public MovieRelease(String title) {
        super(title, THIS_AMOUNT, INCREMENT, DAYS_LIMIT);
    }

    /**
     * Calculates the amount to pay of a release movie
     *
     * @return the total amount.
     */
    @Override
    public double calculatePrice(int daysRented) {
        return daysRented * amount;
    }

    /**
     * Bring back the frequent renter points of a release movie
     *
     * @return the frequent points.
     */
    @Override
    public int frequentRenterPoints(int daysRented) {
        return (daysRented > daysLimit) ? TWO_POINTS : ONE_POINT;
    }

}



