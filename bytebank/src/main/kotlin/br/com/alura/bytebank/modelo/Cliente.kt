package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.modelo.Autenticavel

class Cliente(
    val nome: String,
    val cpf: String,
    // Precisou do override pois estamos sobrescrevendo o da interface
    private val senha: Int,
    var endereco: Endereco = Endereco()
) : Autenticavel {
    override fun autentica(senha: Int): Boolean {
        if (this.senha == senha)
            return true

        return false
    }
}