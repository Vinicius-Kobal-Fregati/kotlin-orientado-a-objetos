package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.ContaSalario

fun testaContasDiferentes() {
    val contaCorrente = ContaCorrente(
        titular = Cliente(
            nome = "Vinícius",
            cpf = "111.111.111-11",
            senha = 1234
        ),
        numero = 1000
    )

    println("Titular")
    println("nome do titular ${contaCorrente.titular.nome}")
    println("cpf do titular ${contaCorrente.titular.cpf}")

    val contaPoupanca = ContaPoupanca(
        titular = Cliente(
            nome = "Fran",
            cpf = "111.111.111-11",
            senha = 1234
        ),
        numero = 1001
    )

    val contaSalario = ContaSalario(
        titular = Cliente(
            nome = "Pedro",
            cpf = "111.111.111-12",
            senha = 1234
        ),
        numero = 1002
    )

    contaCorrente.deposita(1000.0)
    contaPoupanca.deposita(1000.0)
    contaSalario.deposita(2000.0)

    contaCorrente.saca(100.0)
    contaPoupanca.saca(100.0)

    println("saldo corrente: ${contaCorrente.saldo}")
    println("saldo poupanca: ${contaPoupanca.saldo}")
    println("saldo salário: ${contaSalario.saldo}")

    contaCorrente.transfere(100.0, contaPoupanca)

    println("saldo corrente após transferir para poupanca: ${contaCorrente.saldo}")
    println("saldo poupança após receber transferência: ${contaPoupanca.saldo}")

    contaPoupanca.transfere(100.0, contaCorrente)

    println("saldo poupança após transferir para poupanca: ${contaPoupanca.saldo}")
    println("saldo corrente após receber transferência: ${contaCorrente.saldo}")

//    Não funciona por não ser uma conta transferível, não possuindo assim este método
//    contaSalario.transfere(300.0, contaPoupanca)
//    contaSalario.transfere(300.0, contaCorrente)
}