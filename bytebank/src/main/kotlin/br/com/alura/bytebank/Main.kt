package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.*
import br.com.alura.bytebank.teste.testaFuncaoComReceivers
import br.com.alura.bytebank.teste.testaRun
import br.com.alura.bytebank.teste.testaWith

fun main() {
    println("Bem vindo ao Bytebank")

    testaRun()
    testaWith()
    testaFuncaoComReceivers()
}