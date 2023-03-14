class ContaSalario(
    titular: String,
    numero: Int = 0
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        val valorComTaxa: Double = valor + 0.05
        if (saldo >= valorComTaxa) {
            saldo -= valorComTaxa
        }
    }
}