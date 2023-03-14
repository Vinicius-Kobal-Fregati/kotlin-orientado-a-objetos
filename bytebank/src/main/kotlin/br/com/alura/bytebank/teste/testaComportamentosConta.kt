package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente
import br.com.alura.bytebank.modelo.ContaPoupanca

fun testaComportamentosConta() {
    val contaVinicius = ContaCorrente(
        Cliente("Vinícius", "12", 1)
    )
    contaVinicius.deposita(200.0)

    val contaFran = ContaPoupanca(
        numero = 1001,
        titular = Cliente(
            "Fran",
            "21",
            2
        )
    )
    contaFran.deposita(300.0)

    println(contaFran.titular.nome)
    println(contaFran.numero)
    println(contaFran.saldo)

    println(contaVinicius.titular.nome)
    println(contaVinicius.numero)
    println(contaVinicius.saldo)

    contaVinicius.deposita(50.0)
    println(contaVinicius.saldo)
    contaFran.deposita(70.0)
    println(contaFran.saldo)

    contaVinicius.saca(20.0)
    println(contaVinicius.saldo)
    contaFran.saca(40.0)
    println(contaFran.saldo)

    println("Saque em excesso")
    contaVinicius.saca(1000.0)
    println(contaVinicius.saldo)

    if (contaFran.transfere(destino = contaVinicius, valor = 100.0)) {
        println("Transferência sucedida")
    } else {
        println("Falha na transferência")
    }

    println(contaVinicius.saldo)
    println(contaFran.saldo)
}