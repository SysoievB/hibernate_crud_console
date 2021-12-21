package com.hibernate.console.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
public class Account extends BaseEntity {
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public Account() {
    }

    public Account(Long id) {
        this.id = id;
    }

    public Account(Long id, AccountStatus status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " " + status.name();
    }
}
