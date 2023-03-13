fun main() {
    println("Bem vindo ao Bytebank")
    val titular: String = "Vinícius"
    val numeroConta: Int = 1000
    var saldo = 0.0
    saldo = 100 + 2.0
    saldo += 200
    saldo -= 1000

    println("titular $titular")
    println("número da conta $numeroConta")
    println("saldo da conta $saldo")

    testaCondicoes(saldo)
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0){
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