package br.com.alura.bytebank.teste

import br.com.alura.bytebank.exception.FalhaAutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException
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

    try {
        contaFran.transfere(destino = contaVinicius, valor = 100.0, senha = 2)
        println("Transferência sucedida")
    } catch (e: SaldoInsuficienteException) {
        println("Falha na transferência")
        println("Saldo insuficiente")
        e.printStackTrace()
    } catch (e: FalhaAutenticacaoException) {
        println("Falha na transferência")
        println("Falha na autenticação")
        e.printStackTrace()
    } catch (e: Exception) {
        println("Erro desconhecido")
        e.printStackTrace()
    }

    println(contaVinicius.saldo)
    println(contaFran.saldo)
}