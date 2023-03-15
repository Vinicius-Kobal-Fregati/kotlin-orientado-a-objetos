package br.com.alura.bytebank.modelo

interface Autenticavel {
    /*
    // Essa senha é uma property que quem implementa deve ter
    // Ela não tem backfield
    // val senha: Int
    fun autentica(senha: Int): Boolean {
        if (this.senha == senha)
            return true

        return false
    }
     */

    fun autentica(senha: Int): Boolean
}