package org.fundacionjala.movies;

/**
 * Handles the dates of movies to children.
 *
 * @autor Bruno Vasquez
 */
public class MovieChildren extends Movie {

    public static final int DAYS_LIMIT = 2;
    public static final double INITIAL_AMOUNT = 1.5;
    public static final double PRICE_TO_DAY = 1.5;

    /**
     * It is the constructor of movies to children.
     *
     * @param title an String to set the title of the movies to children
     */
    public MovieChildren(String title) {
        super(title, INITIAL_AMOUNT, PRICE_TO_DAY, DAYS_LIMIT);
    }

}

