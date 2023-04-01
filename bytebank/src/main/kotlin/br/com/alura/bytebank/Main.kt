package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.teste.testaFuncoesEscopoEHOF

fun main() {
    println("Bem vindo ao Bytebank")

    testaWith()
}

fun testaWith() {
    with(Endereco()) {
        logradouro = "Rua vergueiro"
        numeroEndereco = 318
        bairro = "Vila Mariana"
        cidade = "São Paulo"
        estado = "SP"
        cep = "02310-063"
        complemento = "Apartamento"
        completo()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }
}