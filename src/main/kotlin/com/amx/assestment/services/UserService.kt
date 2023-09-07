package com.amx.assestment.services

import com.amx.assestment.domain.User
import com.amx.assestment.dto.UserDto
import com.amx.assestment.exceptions.UserNoContentException
import com.amx.assestment.exceptions.UserNotFoundException
import com.amx.assestment.mappers.toDto
import com.amx.assestment.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun fetchAll(): List<UserDto> {
        val users = userRepository.findAll()
        if (users.isEmpty()) throw UserNoContentException("No users found")
        else return users.map { it.toDto() }
    }

    fun addUser(userDto: UserDto): UserDto {
        val user = User(
            name = userDto.name,
            surname = userDto.surname
        )

        return userRepository.save(user).toDto()
    }

    fun getUserById(userId: Long): User {
        return userRepository.findById(userId)
            .orElseThrow { throw UserNotFoundException("User with ID $userId not found.") }
    }
}