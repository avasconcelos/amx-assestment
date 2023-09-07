package com.amx.assestment.controllers

import com.amx.assestment.domain.User
import com.amx.assestment.dto.UserDto
import com.amx.assestment.services.AccountService
import com.amx.assestment.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController(
    private val userService: UserService,
    private val accountService: AccountService
) {

    @GetMapping("/users")
    fun fetchUsers(): ResponseEntity<List<UserDto>> {
        return ResponseEntity<List<UserDto>>(userService.fetchAll(), HttpStatus.OK)
    }

    @PostMapping("/users")
    fun addUser(@RequestBody userDto: UserDto): ResponseEntity<UserDto> {
        return ResponseEntity<UserDto>(userService.addUser(userDto), HttpStatus.CREATED)
    }
}