package com.amx.assestment.domain

import jakarta.persistence.*

@Entity
data class Account(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne
    val user: User? = null,
    var balance: Double = 0.0,
    @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL])
    val transactions: MutableList<Transaction> = mutableListOf()
)
