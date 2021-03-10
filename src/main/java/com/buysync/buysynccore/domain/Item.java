package com.buysync.buysynccore.domain;

import antlr.StringUtils;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Item {

    @Id
    @GeneratedValue
    private Long itemId;
    @NotBlank(message = "Item Name cannot be null/empty.")
    private String itemName;
    private String nickName;
    @NotBlank(message = "Item should have Unit of Measure.")
    private String unit;

}
