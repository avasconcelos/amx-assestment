package com.amx.assestment.domain

import jakarta.persistence.*

@Entity
data class Transaction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne
    val account: Account? = null,
    val amount: Double = 0.0
)