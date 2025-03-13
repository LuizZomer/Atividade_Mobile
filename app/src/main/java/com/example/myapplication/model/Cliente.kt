package com.example.myapplication.model

class Cliente(
    val id: Int,
    val nome: String,
    var saldo: Double
) {
    fun adicionarSaldo(valor: Double) {
        saldo += valor
    }
}