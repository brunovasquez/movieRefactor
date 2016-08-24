package org.fundacionjala.movies;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by carlos gonzales on 8/23/2016.
 */
public class RentalTest {


    @Test
    public void test_calculateAmount_WhenMovieIsRegular() throws Exception {
        final int regular = 0;
        final int daysRented = 3;
        Movie movie = new Movie("Suicide", regular);
        Rental rental = new Rental(movie, daysRented);

        final double expectResult = 3.5;
        final double actualResult = rental.calculateAmount();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateAmount_WhenMovieIsChildren() throws Exception {
        final int children = 2;
        final int daysRented = 4;
        Movie movie = new Movie("Suicide", children);
        Rental rental = new Rental(movie, daysRented);

        final double expectResult = 3;
        final double actualResult = rental.calculateAmount();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateAmount_WhenMovieIsNewRelease() throws Exception {
        final int newRelease = 1;
        final int daysRented = 2;
        Movie movie = new Movie("Suicide", newRelease);
        Rental rental = new Rental(movie, daysRented);

        final double expectResult = 6;
        final double actualResult = rental.calculateAmount();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateFrequentRenterPoints_whenMovieIsNewRelease() throws Exception {
        Movie movie = new Movie("Bats", 1);
        Rental rental = new Rental(movie, 5);

        final int expectResult = 2;
        final int actualResult = rental.calculateFrequentRenterPoints();
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void test_calculateFrequentRenterPoints_whenMovieIsNotNewRelease() throws Exception {
        Movie movie = new Movie("Micky", 0);
        Rental rental = new Rental(movie, 5);

        final int expectResult = 1;
        final int actualResult = rental.calculateFrequentRenterPoints();
        assertEquals(expectResult, actualResult);
    }


}