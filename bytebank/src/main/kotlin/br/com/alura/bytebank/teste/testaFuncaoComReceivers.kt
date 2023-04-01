package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaFuncaoComReceivers() {
    // Veja que dessa forma, parece que não muda nada, mas no primeiro, o lambda tem acesso ao it
    somaRecebendoFuncao(1, 5, resultado = (::println))
    // Nesse segundo, o lambda tem acesso ao this
    somaComReceiver(1, 5, resultado = (::println))

    somaRecebendoFuncao(1, 5, resultado = {
        println(it)
    })

    somaComReceiver(1, 5, resultado = {
        println(this)
    })

    somaComReceiverComParametro(1, 5, resultado = { texto: String ->
        println(this)
        println(texto)
    })

    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int): Boolean = this.senha == senha
    }

    val sistema = SistemaInterno()
    sistema.entra(autenticavel, 1234, autenticado = {
        println("Realizar pagamento")
    })

    sistema.entraReceiver(autenticavel, 1234, autenticado = {
        // Podemos chamar um método do SistemaInterno por estarmos utilizando o this
        pagamento()
    })
}

// Acesso ao argumento
fun somaRecebendoFuncao(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("antes da soma")
    resultado(a + b)
    println("depois da soma")
}

// Acesso ao receiver
fun somaComReceiver(a: Int, b: Int, resultado: Int.() -> Unit) {
    println("antes da soma")
    //resultado(a + b)
    val total = a + b
    // Aqui com o receiver, podemos usar como uma extensão do membro
    total.resultado()
    println("depois da soma")
}

fun somaComReceiverComParametro(a: Int, b: Int, resultado: Int.(String) -> Unit) {
    println("antes da soma")
    //resultado(a + b)
    val total = a + b
    // Aqui com o receiver, podemos usar como uma extensão do membro
    total.resultado("")
    println("depois da soma")
}