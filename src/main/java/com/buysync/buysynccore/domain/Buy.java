package com.buysync.buysynccore.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
public class Buy {

    @Id
    private String buyId;
    private String itemId;
    private double quantity;
    private Timestamp expiryDate;
    private Timestamp eventTimestamp;
}
