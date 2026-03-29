package lld.carRentalSystem.billing;

import lld.carRentalSystem.model.Reservation;
import lld.carRentalSystem.model.Vehicle;

import java.util.concurrent.TimeUnit;

public class HourlyBillingStrategy implements BillingStrategy {

    @Override
    public long calculateAmount(Reservation reservation, Vehicle vehicle) {
        long hours = TimeUnit.MILLISECONDS.toHours(
                reservation.getEndDate().getTime() - reservation.getStartDate().getTime());
        long hourlyRate = vehicle.getDailyRental() / 24;
        return Math.max(1, hours) * Math.max(1, hourlyRate);
    }
}
