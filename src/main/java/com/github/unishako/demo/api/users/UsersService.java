package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.mapper.MapperUtils;
import com.github.unishako.demo.persistence.entity.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class UsersService {

    private final UsersRepository usersRepository;
    private final MapperUtils mapperUtils;

    List<UsersDto> search() {
        return mapperUtils.convertList(usersRepository.selectAll(), UsersDto.class);
    }

    void add(UsersDto usersDto) {
        Users users = mapperUtils.convertDto(usersDto, Users.class);
        int i = usersRepository.insert(users);
        log.info("結果=" + i);
    }

    void addList(List<UsersDto> usersDtoList) {
        List<Users> usersList = mapperUtils.convertList(usersDtoList, Users.class);
        int i[] = usersRepository.batchInsert(usersList);
        log.info("結果=" + i);
    }

    void modify(UsersDto usersDto) {
        Users users = mapperUtils.convertDto(usersDto, Users.class);
        int i = usersRepository.update(users);
        log.info("結果=" + i);
    }

    void auth(String authorization) {
    }
}
