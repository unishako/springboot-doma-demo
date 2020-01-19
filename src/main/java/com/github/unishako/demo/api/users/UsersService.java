package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.mapper.MapperUtils;
import com.github.unishako.demo.persistence.entity.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        int i = usersRepository.insert(mapperUtils.convertDto(usersDto, Users.class));
        log.info("結果=" + i);
    }

    void addList(List<UsersDto> usersDtoList) {
        int i[] = usersRepository.batchInsert(mapperUtils.convertList(usersDtoList, Users.class));
        log.info("結果=" + i);
    }

    void auth(String authorization) {
    }
}
