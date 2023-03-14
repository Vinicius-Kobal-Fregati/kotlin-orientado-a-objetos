open class Conta(
    var titular: String,
    val numero: Int = 0
) {
    var saldo = 0.0
        private set
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
        println("Conta do(a) $titular criada")
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

    open fun saca(valor: Double) {
        if (saldo >= valor) {
            println("Sacando na conta do(a) $titular")
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            println("Transferência da conta do(a) $titular para o(a) ${destino.titular}")
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}