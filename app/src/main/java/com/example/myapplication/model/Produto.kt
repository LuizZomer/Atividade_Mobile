package com.example.myapplication.model;

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.ui.tooling.preview.Preview;


class Produto(
    val id: Int,
    val nome: String,
    var preco: Double,
    var estoque: Int
) {
    @Composable()
    fun ExibirDetalhes() {
        Text("$id - $nome")
    }
}

@Preview(showBackground = true)
@Composable()
fun previewProduto() {
    val p = Produto(1, "mouse", 1.1, 10)

    p.ExibirDetalhes()
}