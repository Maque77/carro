package com.java4h.ilcarro.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Basket {

    private Integer basketId;
    private LocalDateTime createdDate;                  // TODO: delete, createdDate implemented by @PrePersist

}
