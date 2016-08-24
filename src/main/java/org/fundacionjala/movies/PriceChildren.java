package org.fundacionjala.movies;

/**
 * Created by BrunoVasquez on 8/23/2016.
 */
public class PriceChildren implements Price {

    public static final double PRICE_DAYS = 1.5;
    public static final int DAYS_RENTED = 3;

    public double calculatePrice(Rental each) {
        double thisAmount = PRICE_DAYS;
        if (each.getDaysRented() > DAYS_RENTED)
            thisAmount += (each.getDaysRented() - DAYS_RENTED) * PRICE_DAYS;
        return thisAmount;
    }
}
