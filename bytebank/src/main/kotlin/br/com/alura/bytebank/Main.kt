package br.com.alura.bytebank

var numero = 10
fun main() {
    println("Bem vindo ao Bytebank")
    println(soma(1, 2))
    numero = 3
    println(soma(1, 2))
}

// Isso se assemelha mais à orientação a objetos, veja que mantém estado.
fun soma(a: Int, b: Int) : Int = a + b + numero

// Essa função se assemelha mais à funcional, ela é pura, ou seja, para mesmos argumentos o retorno será igual
fun somaFuncional(a: Int, b: Int) : Int = a + b