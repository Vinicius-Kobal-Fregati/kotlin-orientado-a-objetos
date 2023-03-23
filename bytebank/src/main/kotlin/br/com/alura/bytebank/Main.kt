package br.com.alura.bytebank

var numero = 10
fun main() {
    println("Bem vindo ao Bytebank")
//    println(somaNaoFuncional(1, 2))
//    println(somaFuncional(1, 2))
//    numero = 3
//    println(somaNaoFuncional(1, 2))
//    println(somaFuncional(1, 2))

    testaTipoFuncaoReferencia()
    testaTipoFuncaoClasse()
//    testaOperadorInvoke()

    /*
    // Expressão lambda
    val minhaFuncaoLambda: () -> Unit = {
        println("Executa como lambda")
    }
    println(minhaFuncaoLambda)
    println(minhaFuncaoLambda())

    // Expressão anônima
    // Tanto essa como a lambda não podem ser reutilizadas em outra variável
    val minhaFuncaoAnonima: () -> Unit = fun() {
        println("Executa como anônimo")
    }
    println(minhaFuncaoAnonima)
    println(minhaFuncaoAnonima())

    /*
    // Esses dois casos não funcionam, elas não podem ser reutilizadas em outras variáveis
    val reutilizandoLambda: () -> Unit = ::minhaFuncaoLambda
    val reutilizandoAnonimo: () -> Unit = ::minhaFuncaoAnonima
     */
     */
}

private fun testaOperadorInvoke() {
    val somaOperador = Soma()
    somaOperador(10)
}

private fun testaTipoFuncaoClasse() {
    // Perceba que não passamos no construtor do objeto os valores da função, apenas quando invocamos ele
    val minhaFuncaoClasses: (Int, Int) -> Int = Soma()
    // Exibe a referência do nosso objeto
    println(minhaFuncaoClasses)
    // Executa o invoke
    println(minhaFuncaoClasses(10, 10))
}

private fun testaTipoFuncaoReferencia() {
    // Os parêntesis são os parâmetros, a seta seria o retorno
    // Assim não conseguimos usar ela
    //val minhaFuncao: () -> Unit

    // Dessa forma usamos a assinatura, a referência da função
    val minhaFuncao: (Int, Int) -> Int = ::soma
    // Lazy avaliation, só chamamos ele, não inicializamos
    println(minhaFuncao)
    // Esse executa nossa referência de teste e exibe o retorno, o Unit
    println(minhaFuncao(1, 2))
}

fun soma(a: Int, b: Int) : Int {
    return a + b
}

class Soma : (Int, Int) -> Int {
    // O override invoke sempre deve ter mesma assinatura que a implementada
    override fun invoke(a: Int, b: Int): Int {
        return a + b
    }

    // Aqui se uma referência utilizar o nome e após os parêntesis, executará esse trecho.
    // Independe da implementação da função.
    operator fun invoke(valor: Int) {
        println(valor)
    }
}

// Isso se assemelha mais à orientação a objetos, veja que mantém estado.
fun somaNaoFuncional(a: Int, b: Int): Int = a + b + numero

// Essa função se assemelha mais à funcional, ela é pura, ou seja, para mesmos argumentos o retorno será igual
fun somaFuncional(a: Int, b: Int): Int = a + b