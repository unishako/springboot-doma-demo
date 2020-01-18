package com.github.unishako.demo.api.users;

import com.github.unishako.demo.persistence.dao.UserDao;
import com.github.unishako.demo.persistence.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UserDao userDao;

    List<Users> users() {
        return userDao.selectAll();
    }
}
