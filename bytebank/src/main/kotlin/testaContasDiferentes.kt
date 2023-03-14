fun testaContasDiferentes() {
    val contaCorrente = ContaCorrente(
        titular = "Vinícius",
        numero = 1000
    )
    val contaPoupanca = ContaPoupanca(
        titular = "Fran",
        numero = 1001
    )

    contaCorrente.deposita(1000.0)
    contaPoupanca.deposita(1000.0)

    contaCorrente.saca(100.0)
    contaPoupanca.saca(100.0)

    println("saldo corrente: ${contaCorrente.saldo}")
    println("saldo poupanca: ${contaPoupanca.saldo}")

    contaCorrente.transfere(100.0, contaPoupanca)

    println("saldo corrente após transferir para poupanca: ${contaCorrente.saldo}")
    println("saldo poupança após receber transferência: ${contaPoupanca.saldo}")

    contaPoupanca.transfere(100.0, contaCorrente)

    println("saldo poupança após transferir para poupanca: ${contaPoupanca.saldo}")
    println("saldo corrente após receber transferência: ${contaCorrente.saldo}")
}