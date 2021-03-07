package com.buysync.buysynccore.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
public class Item {
    @Id
    @NotBlank(message = "Item Id cannot be null/empty.")
    private String itemId;
    @NotBlank(message = "Item Name cannot be null/empty.")
    private String itemName;
    private String nickName;
    @NotBlank(message = "Item should have Unit of Measure.")
    private String unit;
}
