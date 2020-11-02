package com.wisphil.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDto {

    private String accountID;
    private String name;
    private Double balance;

}
