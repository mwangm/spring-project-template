package com.example.order.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "key_stock")
@AllArgsConstructor
@NoArgsConstructor
public class Key extends EntityBase {
    @Column
    private String number;

    @Column
    private String type;
}
