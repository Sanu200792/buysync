package com.buysync.buysynccore.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class ItemQuantity {
    @Id
    private String itemId;
    private double quantity;
}
