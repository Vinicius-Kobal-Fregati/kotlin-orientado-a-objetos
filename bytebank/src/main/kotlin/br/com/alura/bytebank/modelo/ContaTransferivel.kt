package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.modelo.Conta

abstract class ContaTransferivel(
    titular: String,
    numero: Int = 0
) : Conta(
    titular = titular,
    numero = numero
) {

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            println("Transferência da conta do(a) $titular para o(a) ${destino.titular}")
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}