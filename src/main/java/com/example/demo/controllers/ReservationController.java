package com.example.demo.controllers;


import com.example.demo.dtos.ReservationDto;
import com.example.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/getAll")
    public List<ReservationDto> getReservations(final HttpServletRequest request) {
        return reservationService.getAll(request);
    }

    @GetMapping("/get")
    public ReservationDto getReservation(@RequestParam String id, final HttpServletRequest request) {
        return reservationService.getReservation(id, request);
    }

    @PostMapping("/create")
    public ReservationDto createReservation(@RequestBody ReservationDto reservationDto, final HttpServletRequest request) {
        return reservationService.createReservation(reservationDto, request);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/enable")
    public ReservationDto enableReservation(@RequestBody ReservationDto reservationDto, final HttpServletRequest request) {
        return reservationService.enableReservation(reservationDto, request);
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/disable")
    public ReservationDto disableReservation(@RequestBody ReservationDto reservationDto, final HttpServletRequest request) {
        return reservationService.disableReservation(reservationDto, request);
    }


    @PutMapping("/accept/{cardId}")
    public ReservationDto acceptReservation(@PathVariable(required = true, name = "cardId") String reservationId) {
        return reservationService.acceptReservation(reservationId);
    }

    @PutMapping("/update")
    public ReservationDto updateCard(@RequestBody ReservationDto reservationDto, final HttpServletRequest request) {
        return reservationService.updateReservation(reservationDto, request);
    }

}
