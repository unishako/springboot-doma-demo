package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.mapper.MapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final MapperUtils mapperUtils;

    List<UsersDto> search() {
        return mapperUtils.convertList(usersRepository.selectAll(), UsersDto.class);
    }

    void auth(String authorization) {
    }
}
