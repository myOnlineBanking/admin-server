package com.example.demo.services;

import com.example.demo.daos.Reservation;
import com.example.demo.dtos.ReservationDto;
import com.example.demo.exceptions.ReservationException;
import com.example.demo.mappers.ReservationMapper;
import com.example.demo.respositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationMapper reservationMapper;

    Logger logger = Logger.getLogger("myLogger");

    @Override
    public List<ReservationDto> getAll(HttpServletRequest request) {
        try {
            return reservationMapper.map(reservationRepository.findAll());
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }

    @Override
    public List<ReservationDto> getReservationsNotEnabled() {
        try {
            return reservationMapper.map(reservationRepository.findByEnabledEquals(false));
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }


    @Override
    public ReservationDto getReservation(String id, HttpServletRequest request) {
        try {
            return reservationMapper.map(reservationRepository.findById(id).orElse(null));
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }


    @Override
    public ReservationDto createReservation(ReservationDto reservationDto, HttpServletRequest request) {
        try {
            Reservation reservation = reservationMapper.map(reservationDto);
            reservation = reservationRepository.save(reservation);
            reservationDto.setId(reservation.getId());

            logger.log(Level.INFO, reservation.toString());

            return reservationMapper.map(reservation);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), ex.getMessage());
        }
    }



    @Override
    public ReservationDto updateReservation(ReservationDto reservationDto, HttpServletRequest request) {
        try {
            Reservation reservation = reservationMapper.map(reservationDto);
            return reservationMapper.map(reservationRepository.save(reservation));
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }

    @Override
    public List<ReservationDto> getClientReservations(String userId, HttpServletRequest request) {
        try {
            return reservationMapper.map(reservationRepository.findByOwnerId(userId));
        } catch (Exception e) {
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }

    @Override
    public ReservationDto enableReservation(ReservationDto reservationDto, HttpServletRequest request) {
        try {
            Reservation reservation = reservationRepository.findById(reservationDto.getId()).orElse(null);
            assert reservation != null;
            reservation.setEnabled(true);
            return reservationMapper.map(reservationRepository.save(reservation));
        } catch (Exception e) {
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }

    @Override
    public ReservationDto disableReservation(ReservationDto reservationDto, HttpServletRequest request) {
        try {
            Reservation reservation = reservationRepository.findById(reservationDto.getId()).orElse(null);
            assert reservation != null;
            reservation.setEnabled(false);
            return reservationMapper.map(reservationRepository.save(reservation));
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }

    @Override
    public List<ReservationDto> getByEntityId(String agencyId, HttpServletRequest request) {
        try {
            return reservationMapper.map(reservationRepository.findByEntityId(agencyId));
        } catch (Exception e) {

            logger.log(Level.SEVERE, e.getMessage());
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());
        }
    }

    @Override
    public ReservationDto acceptReservation(String reservationId) {
        try {
            Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
            reservation.setAccepted(true);
            return reservationMapper.map(reservationRepository.save(reservation));
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new ReservationException(HttpStatus.SEE_OTHER.value(), e.getMessage());

        }
    }
}
