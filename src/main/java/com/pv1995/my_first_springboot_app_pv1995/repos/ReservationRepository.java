package com.pv1995.my_first_springboot_app_pv1995.repos;

import com.pv1995.my_first_springboot_app_pv1995.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
