package com.pv1995.my_first_springboot_app_pv1995.rest;

import com.pv1995.my_first_springboot_app_pv1995.model.ReservationDTO;
import com.pv1995.my_first_springboot_app_pv1995.service.ReservationService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationResource {

    private final ReservationService reservationService;

    public ReservationResource(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservation(@PathVariable final Long id) {
        return ResponseEntity.ok(reservationService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createReservation(
            @RequestBody @Valid final ReservationDTO reservationDTO) {
        return new ResponseEntity<>(reservationService.create(reservationDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReservation(@PathVariable final Long id,
            @RequestBody @Valid final ReservationDTO reservationDTO) {
        reservationService.update(id, reservationDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteReservation(@PathVariable final Long id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
