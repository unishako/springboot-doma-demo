package com.github.unishako.demo.persistence.entity;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import java.math.BigDecimal;

@Entity
@Data
public class Users {

    @Id
    private BigDecimal id;

    private String password;

    private String name;
}
