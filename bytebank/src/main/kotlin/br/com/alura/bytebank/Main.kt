package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.modelo.SistemaInterno

fun main() {
    println("Bem vindo ao Bytebank")
    // Com Higher-order function não precisaríamos dessa variável
//    val endereco = Endereco(logradouro = "rua vergueiro", numeroEndereco = 3185)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numeroEndereco}".uppercase()
//    println(enderecoEmMaiusculo)

    val enderecoEmMaiusculo = Endereco(
        logradouro = "rua vergueiro",
        numeroEndereco = 3185
    ).let { endereco ->
        "${endereco.logradouro}, ${endereco.numeroEndereco}".uppercase()
    }
    println(enderecoEmMaiusculo)

    // Encadeando as funções, não precisamos criar nenhuma variável
    Endereco(
        logradouro = "rua vergueiro",
        numeroEndereco = 3185
    ).let { endereco ->
        "${endereco.logradouro}, ${endereco.numeroEndereco}".uppercase()
    }.let { enderecoEmMaiusculoNoLet ->
        println(enderecoEmMaiusculoNoLet)
    }

    // Maneira mais enxuta ainda
    Endereco(
        logradouro = "rua vergueiro",
        numeroEndereco = 3185
    ).let { endereco ->
        "${endereco.logradouro}, ${endereco.numeroEndereco}".uppercase()
    }.let(::println)

    // O apply é um receiver lambda, ele é this. Acessamos seus membros sem a referência
    // O retorno do apply (e also) retorna o objeto do contexto (quem chamou a função)
    // Mudou-se do apply para run pois este também é receiver mas seu retorno é o resultado da lambda
    // let, run e with retornam o resultado da lambda
    Endereco(
        logradouro = "rua vergueiro",
        numeroEndereco = 3185
    ).run {
        "${logradouro}, ${numeroEndereco}".uppercase()
    }.let(::println)


    // Fazendo a chamada para filtrar uma lista com higher-order function
    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento")
    ).filter { endereco -> endereco.complemento?.isNotEmpty() ?: false }
        .let(::println)

    //println(soma(1, 5))

    // Executa o bloco quando ocorrer algo
    soma2(1, 5) {
        println(it)
    }

    soma2(1, 5, resultado = {
        println(it)
    })

    val autenticavel = object: Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int): Boolean {
            return this.senha == senha
        }
    }

    SistemaInterno().entra(autenticavel, 1234, autenticado = {
        // Só será executado se entrar no escopo do if do entra
        println("Realizar pagamento")
    })
}

fun soma(a: Int, b: Int): Int {
    return a + b
}

// Código comum para eventos
fun soma2(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("Antes da soma")
    // Sem esse, ele não executaria o bloco de quem chamou
    resultado(a + b)
    println("Depois da soma")
}