package br.com.alura.bytebank

import br.com.alura.bytebank.teste.testaAutenticacao
import br.com.alura.bytebank.teste.testaContasDiferentes
import java.lang.String as StringJava

fun main() {
    println("Bem vindo ao Bytebank")

    testaAutenticacao()
    val palavraKotlin: kotlin.String = ""
    val palavraJava: StringJava = StringJava("Teste")
    testaContasDiferentes()
}