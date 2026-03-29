package lld.carRentalSystem;

import lld.carRentalSystem.model.Reservation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepository {

    private final Map<Long, Reservation> reservationMap = new ConcurrentHashMap<>();

    public void add(Reservation reservation) {
        reservationMap.putIfAbsent(reservation.getReservationId(), reservation);
    }

    public Reservation getById(long id) {
        return reservationMap.get(id);
    }

    public void remove(long id) {
        reservationMap.remove(id);
    }
}
