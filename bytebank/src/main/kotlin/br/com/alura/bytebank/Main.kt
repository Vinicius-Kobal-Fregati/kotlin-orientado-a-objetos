package br.com.alura.bytebank

import br.com.alura.bytebank.exception.SaldoInsuficienteException
import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")

    println("início main")
    funcao1()
    println("fim main")
}

fun funcao1() {
    println("início funcao1")
    try {
        funcao2()
    } catch (e: SaldoInsuficienteException) {
//        println(e.message)
//        println(e.stackTrace)
//        println(e.cause)
        e.printStackTrace()
        println("SaldoInsuficienteException foi pega")
    }
    //funcao3()
    println("fim funcao1")
}

fun funcao2() {
    println("início funcao2")
    for (i in 1..5) {
        println(i)
        val endereco = Any()
        try {
            //endereco as Endereco
            throw ClassCastException()
        } catch (e: ClassCastException) {
            println("ClassCastException foi pega")
        }
        throw SaldoInsuficienteException()
    }
    println("fim funcao2")
}

fun funcao3() {
    println("início funcao3")
    // Ao ocorrer a exception, como o escopo do for não sabe lidar com o erro, ela sobe de escopo, mudando o fluxo do código
    try {
        for (i in 1..5) {
            println(i)
            val endereco = Any()
            endereco as Endereco
        }
    } catch (e: ClassCastException) {
        println("ClassCastException foi pega")
    }
    println("fim funcao3")
}

fun funcao4() {
    println("início funcao4")
    for (i in 1..5) {
        println(i)
        val endereco = Any()
        endereco as Endereco
    }
    println("fim funcao4")
}