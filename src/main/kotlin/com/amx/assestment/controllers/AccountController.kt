package com.amx.assestment.controllers

import com.amx.assestment.dto.OpenAccountDto
import com.amx.assestment.services.AccountService
import com.amx.assestment.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class AccountController(private val userService: UserService, private val accountService: AccountService) {

    @PostMapping("/accounts/open")
    fun openAccount(@RequestBody request: OpenAccountDto): ResponseEntity<String> {
        accountService.openAccountForUser(request.customerId, request.initialCredit)
        val user = userService.getUserById(request.customerId)
        return ResponseEntity.ok("Account opened for user ${user.name} ${user.surname}")
    }

    @GetMapping("/accounts/users/{id}/info")
    fun getUserInfo(@PathVariable id: Long): ResponseEntity<Any> {
        val userInfo = accountService.getUserInfo(id)
        return ResponseEntity.ok(userInfo)
    }
}