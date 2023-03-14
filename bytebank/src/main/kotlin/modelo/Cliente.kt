package modelo

import modelo.Autenticavel

class Cliente(
    val nome: String,
    val cpf: String,
    // Precisou do override pois estamos sobrescrevendo o da interface
    private val senha: Int
) : Autenticavel {
    override fun autentica(senha: Int): Boolean {
        if (this.senha == senha)
            return true

        return false
    }
}