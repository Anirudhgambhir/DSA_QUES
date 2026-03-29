package lld.carRentalSystem.billing;

import lld.carRentalSystem.model.Reservation;
import lld.carRentalSystem.model.Vehicle;

public interface BillingStrategy {
    long calculateAmount(Reservation reservation, Vehicle vehicle);
}
