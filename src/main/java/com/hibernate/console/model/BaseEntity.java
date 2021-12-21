package com.hibernate.console.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Entity
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;
}
