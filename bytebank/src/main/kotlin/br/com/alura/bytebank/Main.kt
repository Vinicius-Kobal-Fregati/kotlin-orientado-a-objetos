package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.*
import br.com.alura.bytebank.teste.testaContasDiferentes

fun main() {
    println("Bem vindo ao Bytebank")

    // Object expression para criar um objeto anônimo
    val fran = object : Autenticavel {
        val nome: String = "Fran"
        val cpf: String = "222.222.222-22"
        val senha: Int = 1003

        override fun autentica(senha: Int) = this.senha == senha
    }

    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(fran, 1000)

    println("nome do cliente ${fran.nome}")

    val vinicius = Cliente(nome = "Vinícius", cpf = "", senha = 1)
    var contaPoupanca = ContaPoupanca(titular = vinicius, numero = 1000)

    testaContasDiferentes()
    println("total de contas: ${Conta.total}")
}