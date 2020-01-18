package com.github.unishako.demo.persistence.dao;

import com.github.unishako.demo.persistence.entity.Users;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface UsersDao {

    @Select
    List<Users> selectAll();
}
