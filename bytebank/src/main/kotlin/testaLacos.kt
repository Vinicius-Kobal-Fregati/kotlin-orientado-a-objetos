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