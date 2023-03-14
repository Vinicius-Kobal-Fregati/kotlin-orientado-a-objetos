package modelo

abstract class Conta(
    var titular: String,
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

    // Executa um trecho de código durante a inicialização
    init {
        println("modelo.Conta do(a) $titular criada")
    }

    /*
    //Construtor secundário
    constructor(titular: String, numero: Int) {
        this.titular = titular
        this.numero = numero
    }
     */

    fun deposita(valor: Double) {
        println("Depositando na conta do(a) $titular")
        this.saldo += valor
    }

    abstract fun saca(valor: Double)
}