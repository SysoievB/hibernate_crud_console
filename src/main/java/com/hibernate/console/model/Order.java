package com.hibernate.console.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order extends BaseEntity {
    private String orderName;
}
