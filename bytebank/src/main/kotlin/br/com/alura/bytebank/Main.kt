package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")

    testaRun()
}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("taxa mensal $taxaMensal")

    Cliente(nome = "Vinícius", cpf = "111.111.111-11", senha = 1234)
        .let { clienteNovo: Cliente ->
            ContaPoupanca(titular = clienteNovo, numero = 1)
        }.run {
            deposita(1000.0)
            println(" saldo antigo: $saldo")
            saldo * taxaMensal
        }.let { rendimentoMensal ->
            println("Rendimento mensal: $rendimentoMensal")
        }

    val contaPoupanca = ContaPoupanca(Cliente(nome = "André", cpf = "111.111.111-12", senha = 1234), 2)
    contaPoupanca.deposita(1000.0)

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo
    }

    println("Rendimento anual: $rendimentoAnual")
}

fun testaWith() {
    with(Endereco()) {
        logradouro = "Rua vergueiro"
        numeroEndereco = 318
        bairro = "Vila Mariana"
        cidade = "São Paulo"
        estado = "SP"
        cep = "02310-063"
        complemento = "Apartamento"
        completo()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }
}