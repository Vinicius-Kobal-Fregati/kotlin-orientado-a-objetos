package teste

import modelo.ContaCorrente
import modelo.ContaPoupanca
import modelo.ContaSalario

fun testaContasDiferentes() {
    val contaCorrente = ContaCorrente(
        titular = "Vinícius",
        numero = 1000
    )
    val contaPoupanca = ContaPoupanca(
        titular = "Fran",
        numero = 1001
    )

    val contaSalario = ContaSalario(
        titular = "Pedro",
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