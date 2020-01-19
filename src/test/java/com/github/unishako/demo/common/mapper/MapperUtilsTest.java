package com.github.unishako.demo.common.mapper;

import com.github.unishako.demo.api.users.UsersDto;
import com.github.unishako.demo.persistence.entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapperUtilsTest {

    private MapperUtils mapperUtils;

    @BeforeEach
    void setUp() {
        mapperUtils = new MapperUtils(new ModelMapper());
    }

    @Test
    void convertList() {
        List<Users> list = new ArrayList<>();
        Users users1 = new Users();
        users1.setId(new BigDecimal(1));
        users1.setPassword("パスワード1");
        users1.setName("名前1");
        list.add(users1);

        Users users2 = new Users();
        users2.setId(new BigDecimal(2));
        users2.setPassword("パスワード2");
        users2.setName("名前2");
        list.add(users2);

        List<UsersDto> list2 = mapperUtils.convertList(list, UsersDto.class);
        assertEquals(2, list2.size());
        assertEquals("名前1", list2.stream().findFirst().orElse(new UsersDto()).getName());
        assertEquals(new BigDecimal(2), list2.stream().skip(1).findFirst().orElse(new UsersDto()).getId());
    }

    @Test
    void convertDto() {
        Users users1 = new Users();
        users1.setId(new BigDecimal(1));
        users1.setPassword("パスワード1");
        users1.setName("名前1");
        UsersDto usersDto = mapperUtils.convertDto(users1, UsersDto.class);
        assertEquals("名前1", usersDto.getName());
    }
}