package com.wisphil.model.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ToString
public class Account {

    @Id
    private String accountID;
    private String name;
    private Double balance;
    private String type;
}
