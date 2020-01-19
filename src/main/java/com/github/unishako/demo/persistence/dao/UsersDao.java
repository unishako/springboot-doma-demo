package com.github.unishako.demo.persistence.dao;

import com.github.unishako.demo.persistence.entity.Users;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
@Table(name = "Users")
public interface UsersDao {

    @Select
    List<Users> selectAll();

    @Insert
    int insert(Users users);

    /**
     * ユーザ情報の更新
     *
     * @param users ユーザ情報
     * @return 処理件数
     */
    @Update(excludeNull = true)
    int update(Users users);

    @Delete
    int delete(Users users);

    @BatchInsert
    int[] batchInsert(List<Users> users);

}
