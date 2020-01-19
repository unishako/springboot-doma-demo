package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.exception.NotFoundException;
import com.github.unishako.demo.persistence.dao.UsersDao;
import com.github.unishako.demo.persistence.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UsersRepository {

    private final UsersDao usersDao;

    List<Users> selectAll() {
        List<Users> list = usersDao.selectAll();
        if (list.size() == 0) {
            throw new NotFoundException();
        }
        return list;
    }

    int insert(Users users) {
        users.setPassword(UUID.randomUUID().toString());
        return usersDao.insert(users);
    }

    int[] batchInsert(List<Users> usersList) {
        usersList.forEach(e -> e.setPassword(UUID.randomUUID().toString()));
        return usersDao.batchInsert(usersList);
    }
}
