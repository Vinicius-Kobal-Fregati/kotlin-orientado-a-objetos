package br.com.alura.bytebank.teste

fun testaExpressao() {
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
    val valorComTaxa: Double? = if (valorRecebido != null) {
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
}