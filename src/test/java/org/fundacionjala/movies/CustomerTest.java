package org.fundacionjala.movies;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brunovasquez on 8/24/2016.
 */
public class CustomerTest {
    @Test
    public void test_calculateTotalFrequentRenterPoints_whitTwoMoviesRegular() throws Exception {
        final int regular = 0;
        final int daysRented = 3;
        Customer customer = new Customer("Bruno");
        Movie movieOne = new Movie("Suicide", regular);
        Movie movieTwo = new Movie("Suicide 2", regular);
        Rental rentalOne = new Rental(movieOne, daysRented);
        Rental rentalTwo = new Rental(movieTwo, daysRented);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);

        final int expectResult = 2;
        final int actualResult = customer.calculateTotalFrequentRenterPoints();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateTotalFrequentRenterPoints_whitTwoMoviesNewReleases() throws Exception {
        final int newRelease = 1;
        final int daysRented = 3;
        Customer customer = new Customer("Bruno");
        Movie movieOne = new Movie("Avenger", newRelease);
        Movie movieTwo = new Movie("Tarzan", newRelease);
        Rental rentalOne = new Rental(movieOne, daysRented);
        Rental rentalTwo = new Rental(movieTwo, daysRented);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);

        final int expectResult = 4;
        final int actualResult = customer.calculateTotalFrequentRenterPoints();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateTotalFrequentRenterPoints_whitTwoMoviesNewReleasesAndRegular() throws Exception {
        final int regular = 0;
        final int newRelease = 1;
        final int daysRented = 3;
        Customer customer = new Customer("Bruno");
        Movie movieOne = new Movie("Avenger", regular);
        Movie movieTwo = new Movie("Tarzan", newRelease);
        Rental rentalOne = new Rental(movieOne, daysRented);
        Rental rentalTwo = new Rental(movieTwo, daysRented);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);

        final int expectResult = 3;
        final int actualResult = customer.calculateTotalFrequentRenterPoints();
        assertEquals(expectResult, actualResult, 0);
    }


    @Test
    public void test_calculateTotalAmount_withTwoMoviesChildren() throws Exception {
        final int children = 2;
        final int daysRented = 5;
        Customer customer = new Customer("Bruno");
        Movie movieOne = new Movie("Avenger", children);
        Movie movieTwo = new Movie("Tarzan", children);
        Rental rentalOne = new Rental(movieOne, daysRented);
        Rental rentalTwo = new Rental(movieTwo, daysRented);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);

        final double expectResult = 9;
        final double actualResult = customer.calculateTotalAmount();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateTotalAmount_withTwoMoviesNewRelease() throws Exception {
        final int newRelease = 1;
        final int daysRented = 3;
        Customer customer = new Customer("Bruno");
        Movie movieOne = new Movie("Avenger", newRelease);
        Movie movieTwo = new Movie("Tarzan", newRelease);
        Rental rentalOne = new Rental(movieOne, daysRented);
        Rental rentalTwo = new Rental(movieTwo, daysRented);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);

        final double expectResult = 18;
        final double actualResult = customer.calculateTotalAmount();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateTotalAmount_withTwoMoviesRegular() throws Exception {
        final int regular = 0;
        final int daysRented = 4;
        Customer customer = new Customer("Bruno");
        Movie movieOne = new Movie("Avenger", regular);
        Movie movieTwo = new Movie("Tarzan", regular);
        Rental rentalOne = new Rental(movieOne, daysRented);
        Rental rentalTwo = new Rental(movieTwo, daysRented);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);

        final double expectResult = 10;
        final double actualResult = customer.calculateTotalAmount();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateTotalAmount_withTwoMoviesRegularAndNewRelease() throws Exception {
        final int regular = 0;
        final int newRelease = 1;
        final int daysRented = 4;
        Customer customer = new Customer("Bruno");
        Movie movieOne = new Movie("Avenger", regular);
        Movie movieTwo = new Movie("Tarzan", newRelease);
        Rental rentalOne = new Rental(movieOne, daysRented);
        Rental rentalTwo = new Rental(movieTwo, daysRented);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);

        final double expectResult = 17;
        final double actualResult = customer.calculateTotalAmount();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateTotalAmount_withTwoMoviesChildrenAndNewRelease() throws Exception {
        final int children = 2;
        final int newRelease = 1;
        final int daysRented = 4;
        Customer customer = new Customer("Bruno");
        Movie movieOne = new Movie("Avenger", children);
        Movie movieTwo = new Movie("Tarzan", newRelease);
        Rental rentalOne = new Rental(movieOne, daysRented);
        Rental rentalTwo = new Rental(movieTwo, daysRented);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);

        final double expectResult = 15;
        final double actualResult = customer.calculateTotalAmount();
        assertEquals(expectResult, actualResult, 0);
    }

}