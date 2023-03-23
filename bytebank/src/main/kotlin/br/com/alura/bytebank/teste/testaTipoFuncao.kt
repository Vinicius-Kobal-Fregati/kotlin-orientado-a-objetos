package br.com.alura.bytebank.teste

var numero = 10

fun testaMetodoFuncional() {
    println(somaNaoFuncional(1, 2))
    println(somaFuncional(1, 2))
    numero = 3
    println(somaNaoFuncional(1, 2))
    println(somaFuncional(1, 2))
}

fun testaFuncaoAnonima() {
    // Expressão anônima
    // Tanto essa como a lambda não podem ser reutilizadas em outra variável.
    // Usamos ela em situações que queremos deixar bem claro os parâmetros e retornos
    // Além do escopo de execução do código ser mais claro (obrigatório o return).
    // É uma forma mais explícita da função lambda
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a, b): Int {
        println("Executa como anônimo")
        return a + b
    }

    val outraFuncaoAnonima = fun(a: Int, b: Int): Int {
        println("Executa como anônimo")
        return a + b
    }

    val maisUmaFuncaoAnonima = fun(_: Int, b: Int): Int {
        println("Executa como anônimo")
        return b
    }
    println(minhaFuncaoAnonima)
    println(minhaFuncaoAnonima(20, 5))

    val calculaBonificacaoAnonima: (salario: Double) -> Double =
        fun(salario): Double {
            if (salario > 1000.0) {
                // Assim conseguimos tanto retornar aqui para o label quanto na última instrução
                return salario + 50
            }
            return salario + 100.0
        }
    println(calculaBonificacaoAnonima(1100.0))

    /*
    // Esses dois casos não funcionam, elas não podem ser reutilizadas em outras variáveis
    val reutilizandoLambda: () -> Unit = ::minhaFuncaoLambda
    val reutilizandoAnonimo: () -> Unit = ::minhaFuncaoAnonima
     */
}

fun testaExpressaoLambda() {
    // Expressão lambda
    // Normalmente entre a função anônima e essa, a expressão lambda é mais usada
    val minhaFuncaoLambda: (Int, Int) -> Int = { a, b ->
        println("Executa como lambda")
        // Lembrando que a última linha é o retorno
        a + b
    }

    // Quando não for usar algum parâmetro, pode usar o _
    val outraFuncaoLambda: (Int, Int) -> Int = { _, b ->
        println("Executa como lambda")
        b
    }

    val maisUmaFuncaoLambda = { a: Int, b: Int ->
        println("Executa como lambda")
        // Lembrando que a última linha é o retorno
        a + b
    }

    println(minhaFuncaoLambda)
    println(minhaFuncaoLambda(15, 10))

    // Com salário passamos a identificação do que é esse parâmetro.
    // O retorno normal na lambda devolve para quem a chamou, nesse caso, o main.
    // Para criarmos o label adicionamos seu nome com o @ no fim.
    // Por boa prática, evite utilizar muito o it, mesmo podendo.
    val calculaBonificacao: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.0) {
            // Assim conseguimos tanto retornar aqui para o label quanto na última instrução
            return@lambda salario + 50
        }
        salario + 100.0
    }
    print(calculaBonificacao(1100.0))
}

fun testaOperadorInvoke() {
    val somaOperador = Soma()
    somaOperador(10)
}

fun testaTipoFuncaoClasse() {
    // Perceba que não passamos no construtor do objeto os valores da função, apenas quando invocamos ele
    val minhaFuncaoClasses: (Int, Int) -> Int = Soma()
    // Exibe a referência do nosso objeto
    println(minhaFuncaoClasses)
    // Executa o invoke
    println(minhaFuncaoClasses(10, 10))
}

fun testaTipoFuncaoReferencia() {
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

fun soma(a: Int, b: Int): Int {
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