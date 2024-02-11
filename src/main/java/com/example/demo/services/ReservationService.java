package com.example.demo.services;

import com.example.demo.dtos.ReservationDto;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

public interface ReservationService extends Serializable {

    List<ReservationDto> getAll(final HttpServletRequest request);

    List<ReservationDto> getReservationsNotEnabled();

    ReservationDto createReservation(ReservationDto reservationDto, final HttpServletRequest request);

    ReservationDto updateReservation(ReservationDto reservationDto, final HttpServletRequest request);

    ReservationDto getReservation(String id, HttpServletRequest request);

    List<ReservationDto> getClientReservations(String userId, HttpServletRequest request);

    ReservationDto enableReservation(ReservationDto reservationDto, HttpServletRequest request);

    ReservationDto disableReservation(ReservationDto reservationDto, HttpServletRequest request);

    List<ReservationDto> getByEntityId(String entityUd, HttpServletRequest request);
    ReservationDto acceptReservation(String cardId);
}
