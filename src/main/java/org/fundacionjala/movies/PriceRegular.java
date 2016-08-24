package org.fundacionjala.movies;

/**
 * Created by BrunoVasquez on 8/23/2016.
 */
public class PriceRegular implements Price {

    public static final int DAYS_RENTED = 2;
    public static final double PRICE_DAY = 1.5;
    public static final int AMOUNT = 2;

    public double calculatePrice(Rental each) {
        double thisAmount = AMOUNT;
        if (each.getDaysRented() > DAYS_RENTED)
            thisAmount += (each.getDaysRented() - DAYS_RENTED) * PRICE_DAY;
        return thisAmount;
    }
}
