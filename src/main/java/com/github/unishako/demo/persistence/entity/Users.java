package com.github.unishako.demo.persistence.entity;

import lombok.Data;
import org.seasar.doma.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    private String password;

    private String name;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @Version
    private BigDecimal version;

    @OriginalStates
    private Users originalStates;
}
