package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.exception.FalhaAutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException

abstract class ContaTransferivel(
    titular: Cliente,
    numero: Int = 0
) : Conta(
    titular = titular,
    numero = numero
), Autenticavel {

    fun transfere(valor: Double, destino: Conta, senha: Int) {
        if (saldo < valor) {
            throw SaldoInsuficienteException(mensagem = "O saldo é insuficiente, " +
                    "saldo atual: $saldo, valor a ser subtraído: $valor"
            )
        }
        else if (!autentica(senha)) {
            throw FalhaAutenticacaoException()
        }

        println("Transferência da conta do(a) ${titular.nome} para o(a) ${destino.titular.nome}")
        saldo -= valor
        destino.deposita(valor)
        throw RuntimeException()
    }

    override fun autentica(senha: Int): Boolean {
        return titular.autentica(senha)
    }
}