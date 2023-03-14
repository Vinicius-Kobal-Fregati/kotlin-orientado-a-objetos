package teste

import modelo.ContaCorrente

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    // Apenas o Y muda pois mandamos uma cópia de seu valor, não uma referência a ele
    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = ContaCorrente("João", 1002)
    val contaMaria = contaJoao
    contaMaria.titular = "Maria"

    // Os dois mudam pois a referêcia deles é igual, ou seja, apontam para o mesmo objeto
    println("titular conta joão:  ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")
}