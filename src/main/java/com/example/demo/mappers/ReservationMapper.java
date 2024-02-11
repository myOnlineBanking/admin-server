package com.example.demo.mappers;


import com.example.demo.daos.Reservation;
import com.example.demo.dtos.ReservationDto;
import com.example.demo.exceptions.ReservationException;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationMapper {

    public ReservationDto map(Reservation reservation) {

        try {
            ReservationDto reservationDto = new ReservationDto();

            reservationDto.setId(reservation.getId());
            reservationDto.setAccepted(reservation.isAccepted());
            reservationDto.setDeleted(reservation.isDeleted());
            reservationDto.setEnabled(reservation.isEnabled());

            reservationDto.setOwnerId(reservation.getOwnerId());
            reservationDto.setEntityId(reservation.getEntityId());
            reservationDto.setSpotIds(reservation.getSpotIds());
            reservationDto.setReservedFrom(reservation.getReservedFrom());
            reservationDto.setReservedTo(reservation.getReservedTo());


            reservationDto.setCreatedAt(reservation.getCreatedAt());
            reservationDto.setDeletedAt(reservation.getDeletedAt());

            return reservationDto;
        } catch (Exception e) {
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }

    public Reservation map(ReservationDto reservationDto) {
        try {
            Reservation reservation = new Reservation();

            reservation.setId(reservationDto.getId());
            reservation.setAccepted(reservationDto.isAccepted());
            reservation.setDeleted(reservationDto.isDeleted());
            reservation.setEnabled(reservationDto.isEnabled());
            reservation.setOwnerId(reservationDto.getOwnerId());
            reservation.setEntityId(reservationDto.getEntityId());
            reservation.setSpotIds(reservationDto.getSpotIds());
            reservation.setReservedFrom(reservationDto.getReservedFrom());
            reservation.setReservedTo(reservationDto.getReservedTo());
            reservation.setCreatedAt(reservationDto.getCreatedAt());
            reservation.setDeletedAt(reservationDto.getDeletedAt());

            return reservation;
        } catch (Exception e) {
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }

    public List<ReservationDto> map(List<Reservation> reservations) {
        try {
            return reservations
                    .stream()
                    .map(this::map)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }

    public List<Reservation> toMap(List<ReservationDto> reservationDtos) {
        try {
            return reservationDtos
                    .stream()
                    .map(this::map)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }


}
