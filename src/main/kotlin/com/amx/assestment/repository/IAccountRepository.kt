package com.amx.assestment.repository

import com.amx.assestment.domain.Account
import com.amx.assestment.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findAllByUser(user: User): List<Account>
}