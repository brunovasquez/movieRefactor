package org.fundacionjala.movies;

/**
 * Created by BrunoVasquez on 8/23/2016.
 */
public class PriceNewRelease implements Price {

    public static final int PRICE_DAYS = 3;

    public double calculatePrice(Rental each) {
        return each.getDaysRented() * PRICE_DAYS;
    }
}
