package com.amx.assestment.mappers

import com.amx.assestment.domain.User
import com.amx.assestment.dto.UserDto

fun User.toDto() = UserDto(
    id = this.id,
    name = this.name,
    surname = this.surname
)