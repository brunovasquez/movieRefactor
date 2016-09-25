package org.fundacionjala.movies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Movie}
 */
public class MovieTest {
    public static final String TITLE = "Batman";
    private Movie movie;

    @Test
    public void test_frequentRenterPoints_toRegular() {
        movie = new MovieRegular(TITLE);
        final int daysRented = 2;
        final int actualResult = movie.frequentRenterPoints(daysRented);
        final int expectResult = 1;
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void test_frequentRenterPoints_toChildren() {
        movie = new MovieRegular(TITLE);
        final int daysRented = 1;
        final int actualResult = movie.frequentRenterPoints(daysRented);
        final int expectResult = 1;
        assertEquals(expectResult, actualResult);
    }
}
