package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    // Apenas o Y muda pois mandamos uma cópia de seu valor, não uma referência a ele
    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = ContaCorrente(
        Cliente(
            nome = "Pedro",
            cpf = "111.111.111-11",
            senha = 1234
        ),
        1002
    )
    val contaMaria = contaJoao
    contaMaria.titular = Cliente(
        nome = "Maria",
        cpf = "111.111.111-12",
        senha = 1234
    )

    // Os dois mudam pois a referêcia deles é igual, ou seja, apontam para o mesmo objeto
    println("titular conta joão:  ${contaJoao.titular.nome}")
    println("titular conta maria: ${contaMaria.titular.nome}")
}