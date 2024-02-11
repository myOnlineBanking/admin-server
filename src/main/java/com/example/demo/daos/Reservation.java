package com.example.demo.daos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document("reservations")
public class Reservation {

    @Id
    private String id;

    private boolean isDeleted = false;
    private boolean isAccepted = false;
    private boolean isEnabled = false;

    private String ownerId;
    private String entityId;
    private List<String> spotIds = new ArrayList<>();
    private Timestamp reservedFrom;
    private Timestamp reservedTo;


    @LastModifiedDate
    private Date createdAt = new Date();
    private Date deletedAt = new Date();

}
