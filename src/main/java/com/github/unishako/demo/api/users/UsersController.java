package com.github.unishako.demo.api.users;

import com.github.unishako.demo.persistence.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/auth")
    public void auth(@RequestHeader("Authorization") String authorization) {
        usersService.auth(authorization);
    }
}
