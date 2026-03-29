package lld.carRentalSystem.billing;

import lld.carRentalSystem.model.Reservation;
import lld.carRentalSystem.model.Vehicle;

import java.util.concurrent.TimeUnit;

public class DailyBillingStrategy implements BillingStrategy {

    @Override
    public long calculateAmount(Reservation reservation, Vehicle vehicle) {
        long days = TimeUnit.MILLISECONDS.toDays(
                reservation.getEndDate().getTime() - reservation.getStartDate().getTime());
        return Math.max(1, days) * vehicle.getDailyRental();
    }
}
