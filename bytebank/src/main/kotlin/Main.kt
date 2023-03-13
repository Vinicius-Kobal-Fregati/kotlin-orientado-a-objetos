fun main() {
    println("Bem vindo ao Bytebank")
    val contaVinicius = Conta()
    contaVinicius.titular = "Vinícius"
    contaVinicius.numero = 1000
    contaVinicius.saldo = 200.0

    val contaFran = Conta()
    contaFran.titular = "Fran"
    contaFran.numero = 1001
    contaFran.saldo = 300.0

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println(contaVinicius.titular)
    println(contaVinicius.numero)
    println(contaVinicius.saldo)

    contaVinicius.deposita(50.0)
    println(contaVinicius.saldo)
    contaFran.deposita(70.0)
    println(contaFran.saldo)

    contaVinicius.saca(20.0)
    println(contaVinicius.saldo)
    contaFran.saca(40.0)
    println(contaFran.saldo)

    println("Saque em excesso")
    contaVinicius.saca(1000.0)
    println(contaVinicius.saldo)
}

class Conta {
    var titular = ""
    var numero = 0
    var saldo = 0.0

    fun deposita(valor: Double) {
        println("Depositando na conta do(a) $titular")
        this.saldo += valor
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            println("Sacando na conta do(a) $titular")
            saldo -= valor
        }
    }
}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    // Apenas o Y muda pois mandamos uma cópia de seu valor, não uma referência a ele
    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta()
    contaJoao.titular = "João"
    val contaMaria = contaJoao
    contaMaria.titular = "Maria"

    // Os dois mudam pois a referêcia deles é igual, ou seja, apontam para o mesmo objeto
    println("titular conta joão:  ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    // Mesma coisa que o if, ele é semelhante ao switch do Java
    /*
    when {
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
    */
}

fun testaLacos() {
    for (i in 1..5) {
        val titular: String = "Vinícius $i"
        val numeroConta: Int = 1000 + i
        var saldo = 0.0
        saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }

    for (i in 4 downTo 1 step 2) {
        if (i == 3) {
            break
        } else if (i == 1) {
            continue
        }

        println("valor do i: $i")
    }

    var valorWhile = 1
    while (valorWhile < 4) {
        println("valor while: $valorWhile")
        valorWhile++
    }
}