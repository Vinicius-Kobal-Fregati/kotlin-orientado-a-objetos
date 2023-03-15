package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")

    println("início main")
    val entrada: String = "1,9"

    // Usando o try como expressão (try-expression)
    val valorRecebido: Double? = try {
        // retorna sempre a última linha
        entrada.toDouble()
    } catch (e: NumberFormatException) {
        println("Problema na conversão")
        e.printStackTrace()
        null
    }

    // Usando if como expressão (if-expression)
    val valorComTaxa: Double? = if(valorRecebido != null) {
        // retorna sempre a última linha
        valorRecebido + 0.1
    } else {
        null
    }

    // When expression
    val possuiTaxa: Boolean = when {
        valorComTaxa != null -> true
        else -> false
    }

    if (valorComTaxa != null) {
        println("valor recebido: $valorComTaxa")
    } else {
        println("valor inválido")
    }

    funcao1()
    println("fim main")
}

fun funcao1() {
    println("início funcao1")
    try {
        funcao4()
    } catch (e: ClassCastException) {
//        println(e.message)
//        println(e.stackTrace)
//        println(e.cause)
        e.printStackTrace()
        println("ClassCastException foi pega")
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
            endereco as Endereco
        } catch (e: ClassCastException) {
            println("ClassCastException foi pega")
        }
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