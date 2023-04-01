package br.com.alura.bytebank.modelo

abstract class Conta(
    var titular: Cliente,
    val numero: Int = 0
) {
    var saldo = 0.0
        protected set
    /*
        set(valor) {
            // field é o valor interno da property
            if (valor > 0) {
                field = valor
            }
        }
     */

    // Object declaration
    // Com o companion conseguimos compartilhar os membros do object declaration quando estiver dentro de uma classe
    // Seria a forma de fazer o membro estático no Kotlin
    companion object {
        var total = 0
            private set
    }

    // Executa um trecho de código durante a inicialização
    init {
        println("Conta do(a) ${titular.nome} criada")
        total++
    }

    /*
    //Construtor secundário
    constructor(titular: String, numero: Int) {
        this.titular = titular
        this.numero = numero
    }
     */

    fun deposita(valor: Double) {
        println("Depositando na conta do(a) ${titular.nome}")
        this.saldo += valor
    }

    abstract fun saca(valor: Double)
}