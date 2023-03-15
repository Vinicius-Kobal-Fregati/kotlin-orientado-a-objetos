package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")
    var enderecoNulo: Endereco? = Endereco(logradouro = "Rua Vergueiro")

    // O let coloca nosso objeto dentro de uma scope function
    enderecoNulo?.let {
        println(it.logradouro.length)
        // Elvis operator, se for nulo, retornará o valor após o ?:
        val tamanhoComplemento: Int = it.complemento?.length ?: 0
        println(tamanhoComplemento)
    }

    val tamanhoComplemento: Int = try {
        // Podemos usar o elis também para lançar exceção
        enderecoNulo?.complemento?.length ?: throw IllegalStateException()
    } catch (e: IllegalStateException) {
        println("Complemento não pode ser vazio")
        0
    }
    println(tamanhoComplemento)

    // Outras formas de usar o let
    enderecoNulo?.let { endereco ->
        println(endereco.logradouro.length)
    }

    // Encadeamento de safe call
    enderecoNulo.let { endereco: Endereco? ->
        println(endereco?.logradouro?.length)
    }

    /*
    // Apenas pega o campo se não for nulo
    enderecoNulo?.logradouro
    //Garantimos que o objeto não é nulo
    val enderecoNaoNulo: Endereco = enderecoNulo!!
    enderecoNaoNulo.logradouro
     */
    teste("a")
}

fun teste(valor: Any) {
    val numero: Int? = valor as? Int
    println(numero)
}