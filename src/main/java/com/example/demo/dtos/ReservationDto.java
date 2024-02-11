package com.example.demo.dtos;


import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ReservationDto {

    private String id;

    private boolean isDeleted = false;
    private boolean isAccepted = false;
    private boolean isEnabled = false;

    private String ownerId;
    private String entityId;
    private List<String> spotIds = new ArrayList<>();
    private Timestamp reservedFrom;
    private Timestamp reservedTo;

    private Date createdAt = new Date();
    private Date deletedAt = new Date();
}
