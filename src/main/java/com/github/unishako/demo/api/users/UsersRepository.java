package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.exception.NotFoundException;
import com.github.unishako.demo.common.mapper.MapperUtils;
import com.github.unishako.demo.persistence.dao.UsersDao;
import com.github.unishako.demo.persistence.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * ユーザ情報リポジトリ
 */
@Repository
@RequiredArgsConstructor
public class UsersRepository {

    private final UsersDao usersDao;
    private final MapperUtils mapperUtils;

    List<UsersDto> selectAll() {
        List<Users> list = usersDao.selectAll();
        if (list.size() == 0) {
            throw new NotFoundException();
        }
        return mapperUtils.convertList(list, UsersDto.class);
    }

    int insert(UsersDto usersDto) {
        Users users = mapperUtils.convertDto(usersDto, Users.class);
        users.setPassword(UUID.randomUUID().toString());
        LocalDateTime now = LocalDateTime.now();
        users.setCreateDate(now);
        users.setUpdateDate(now);
        return usersDao.insert(users);
    }

    int[] batchInsert(List<UsersDto> usersDtoList) {
        List<Users> usersList = mapperUtils.convertList(usersDtoList, Users.class);
        LocalDateTime now = LocalDateTime.now();
        usersList.forEach(e -> {
            e.setPassword(UUID.randomUUID().toString());
            e.setCreateDate(now);
            e.setUpdateDate(now);
        });
        return usersDao.batchInsert(usersList);
    }

    /**
     * ユーザ情報の更新
     *
     * @param usersDto ユーザ情報
     * @return 処理件数
     */
    int update(UsersDto usersDto) {
        Users users = mapperUtils.convertDto(usersDto, Users.class);
        LocalDateTime now = LocalDateTime.now();
        users.setUpdateDate(now);
        return usersDao.update(users);
    }
}
