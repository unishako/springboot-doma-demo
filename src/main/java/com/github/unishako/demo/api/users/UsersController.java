package com.github.unishako.demo.api.users;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/search")
    public List<UsersDto> search() {
        return usersService.search();
    }

    @PostMapping("/add")
    @Transactional
    public void add(@RequestBody UsersDto usersDto) {
        usersService.add(usersDto);
    }

    @PostMapping("/add/list")
    @Transactional
    public void addList(@RequestBody List<UsersDto> usersDtoList) {
        usersService.addList(usersDtoList);
    }

    @GetMapping("/auth")
    void auth(@RequestHeader("Authorization") String authorization) {
        usersService.auth(authorization);
    }
}
