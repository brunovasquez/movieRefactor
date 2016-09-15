package org.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link MovieRegular}
 */
public class MovieRegularTest {
    public static final int DELTA = 0;
    private Movie movie;

    @Before
    public void setUp() {
        final String title = "Avengers";
        movie = new MovieRegular(title);
    }

    @Test
    public void test_calculatePrice_whenTheDaysAreHigherToTwo() {
        int daysRented = 3;
        final double expectResult = 3.5;
        final double actualResult = movie.calculatePrice(daysRented);
        assertEquals(expectResult, actualResult, DELTA);
    }

    @Test
    public void test_calculatePrice_whenTheDaysAreMinorOrEqualToTwo() {
        int daysRented = 2;
        final double expectResult = 2;
        final double actualResult = movie.calculatePrice(daysRented);
        assertEquals(expectResult, actualResult, DELTA);
    }

}
