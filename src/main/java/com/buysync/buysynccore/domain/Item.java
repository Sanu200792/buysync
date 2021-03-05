package com.buysync.buysynccore.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Item {
    @Id
    private String itemId;
    private String itemName;
    private String nickName;
    private String unit;
}
