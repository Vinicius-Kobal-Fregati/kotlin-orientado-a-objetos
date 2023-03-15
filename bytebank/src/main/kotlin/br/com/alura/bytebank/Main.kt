package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.totalContas
import br.com.alura.bytebank.teste.testaContasDiferentes

fun main() {
    println("Bem vindo ao Bytebank")

    val vinicius = Cliente(nome = "Vinícius", cpf = "", senha = 1)
    var contaPoupanca = ContaPoupanca(titular = vinicius, numero = 1000)

    testaContasDiferentes()
    println("total de contas: $totalContas")
}