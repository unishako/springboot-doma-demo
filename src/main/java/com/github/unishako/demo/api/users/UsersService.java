package com.github.unishako.demo.api.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class UsersService {

    private final UsersRepository usersRepository;

    List<UsersDto> search() {
        return usersRepository.selectAll();
    }

    void add(UsersDto usersDto) {
        int i = usersRepository.insert(usersDto);
        log.info("結果=" + i);
    }

    void addList(List<UsersDto> usersDtoList) {
        int i[] = usersRepository.batchInsert(usersDtoList);
        log.info("結果=" + i);
    }

    void modify(UsersDto usersDto) {
        int i = usersRepository.update(usersDto);
        log.info("結果=" + i);
    }

    void auth(String authorization) {
    }
}
