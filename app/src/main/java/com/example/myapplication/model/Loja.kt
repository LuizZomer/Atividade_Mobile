package com.example.myapplication.model

class Loja(
    val produtosDisponiveis: MutableList<Produto> = mutableListOf()
) {
    fun atualizarEstoque(produto: Produto, novoValor: Int) {
        val itemExistente = produtosDisponiveis.find { it.id == produto.id }
        if (itemExistente != null) {
            itemExistente.estoque = novoValor
        } else {
            println("Produto não encontrado!")
        }
    }

    fun realizarCompra(cliente: Cliente, carrinho: CarrinhoDeCompras) {
        val total: Double = carrinho. calcularTotal()

        if (cliente.saldo < total) {
            println("Saldo insuficiente!")
            return
        }

        for ((produto, quantidade) in carrinho.listaDeProdutos) {
            if (produto.estoque < quantidade) {
                println("Estoque insuficiente para o produto ${produto.nome}. Não foi possível completar a compra.")
                return
            }
        }

        for ((produto, quantidade) in carrinho.listaDeProdutos) {
            produto.estoque -= quantidade
        }

        cliente.saldo -= total
        carrinho.listaDeProdutos.clear()
        println("Compra realizada com sucesso!")
    }

}