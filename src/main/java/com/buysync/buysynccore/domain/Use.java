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
public class Use {

    @Id
    private String transId;
    private String itemId;
    private double usedWeight;
    private double currentWeight;
    private Timestamp eventTimestamp;
}
