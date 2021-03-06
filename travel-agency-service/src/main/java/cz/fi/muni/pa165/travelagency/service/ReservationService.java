package cz.fi.muni.pa165.travelagency.service;

import cz.fi.muni.pa165.travelagency.entity.Customer;
import cz.fi.muni.pa165.travelagency.entity.Reservation;
import java.util.List;

/**
 *
 * @author Michal Holic
 */
public interface ReservationService {
    
    public void create(Reservation reservation);
    public void update(Reservation reservation);
    public void delete(Reservation reservation);
    public Reservation getById(Long id);
    public List<Reservation> getAll();
    public List<Reservation> getReservations(Customer customer);
}
