package org.fundacionjala.movies;

/**
 * Handles the dates of regular movies.
 *
 * @autor Bruno Vasquez
 */
public class MovieRegular extends Movie {

    public static final int DAYS_LIMIT = 2;
    public static final int INITIAL_AMOUNT = 2;
    public static final double PRICE_TO_DAY = 1.5;

    /**
     * It is the constructor of regular movies.
     *
     * @param title an String to set the title of the regular movies
     */
    public MovieRegular(String title) {
        super(title, INITIAL_AMOUNT, PRICE_TO_DAY, DAYS_LIMIT);
    }

}



