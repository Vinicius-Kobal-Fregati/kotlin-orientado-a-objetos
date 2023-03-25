package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.modelo.SistemaInterno

fun main() {
    println("Bem vindo ao Bytebank")
    // Com Higher-order function não precisaríamos dessa variável
    val enderecoVariavel = Endereco(logradouro = "rua vergueiro", numeroEndereco = 3185)

    // O apply nos permite trabalhar com os parâmetros do objeto
    // Utiliza um receiver (this) e retorna o objeto de contexto
    val enderecoVariavelComApply = Endereco()
        // Disponibiliza o contexto do objeto como argumento (it). O retorno é o objeto de contexto
        // Amplamente usado em ações que não impactam o restante do código, como impressões.
        .also {
            println("Criando endereço")
        }
        .apply {
            logradouro = "rua vergueiro"
            numeroEndereco = 3185
        }
//    val enderecoEmMaiusculo = "${enderecoVariavel.logradouro}, ${enderecoVariavel.numeroEndereco}".uppercase()
//    println(enderecoEmMaiusculo)

    // Pode ser usado como extensão ou não
    // Normalmente é utilizado na inicialização de objetos junto com computação no final,
    // ou apenas para computar algo sem relação com objeto
    run {
        println("Execução do run sem extensão")
    }

    with(enderecoVariavel) {
        "${logradouro}, ${numeroEndereco}".uppercase()
    }.let(::println)

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

    val autenticavel = object : Autenticavel {
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