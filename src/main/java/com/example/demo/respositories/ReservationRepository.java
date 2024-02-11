package com.example.demo.respositories;

import com.example.demo.daos.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ReservationRepository extends MongoRepository<Reservation, String> {

    List<Reservation> findByOwnerId(@Param(value = "ownerId") String ownerId);
    List<Reservation> findByEntityId(@Param(value = "entityId") String entityId);
    Optional<Reservation> findById(@Param(value = "id") String id);
    List<Reservation> findByEnabledEquals(@Param(value = "id") boolean enabled);
}
