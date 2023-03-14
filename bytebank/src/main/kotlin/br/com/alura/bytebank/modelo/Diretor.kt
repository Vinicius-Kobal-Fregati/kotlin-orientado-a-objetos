package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.modelo.FuncionarioAdmin

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int,
    val plr: Double
) : FuncionarioAdmin(
    nome = nome,
    cpf = cpf,
    salario = salario,
    senha = senha
) {

    override val bonificacao: Double get() = salario + plr

    /*
    // Usado caso a função autentica da interface tivesse corpo e fossemos usar a implementação dela
    override fun autentica(senha: Int): Boolean {
        return super<modelo.Autenticavel>.autentica(senha)
    }
     */
}