package com.amx.assestment.services

import com.amx.assestment.domain.Account
import com.amx.assestment.domain.Transaction
import com.amx.assestment.exceptions.UserNotFoundException
import com.amx.assestment.repository.AccountRepository
import com.amx.assestment.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val userRepository: UserRepository,
    private val accountRepository: AccountRepository
) {

    @Transactional
    fun openAccountForUser(userId: Long, initialCredit: Double) {
        val user = userRepository.findById(userId)
            .orElseThrow { throw UserNotFoundException("User with ID $userId not found.") }

        val account = Account(user = user)
        if (initialCredit > 0) {
            account.balance += initialCredit
            val transaction = Transaction(account = account, amount = initialCredit)
            account.transactions.add(transaction)
        }

        accountRepository.save(account)
    }

    fun getUserInfo(userId: Long): Map<String, Any> {
        val user = userRepository.findById(userId)
            .orElseThrow { throw UserNotFoundException("User with ID $userId not found.") }

        val accounts = accountRepository.findAllByUser(user)

        return mapOf(
            "name" to user.name,
            "surname" to user.surname,
            "accounts" to accounts.map { account ->
                mapOf(
                    "accountId" to account.id,
                    "balance" to account.balance,
                    "transactions" to account.transactions.map { transaction ->
                        mapOf("transactionId" to transaction.id, "amount" to transaction.amount)
                    }
                )
            }
        )
    }
}