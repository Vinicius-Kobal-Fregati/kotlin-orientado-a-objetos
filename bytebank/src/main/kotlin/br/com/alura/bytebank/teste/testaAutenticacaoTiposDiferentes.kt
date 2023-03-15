package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Analista
import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.Gerente
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaAutenticacaoTiposDiferentes() {
    val analista = Analista(
        nome = "Vinícius",
        cpf = "1",
        salario = 1000.0,
        senha = 1000
    )

    val gerente = Gerente(
        nome = "Fran",
        cpf = "2",
        salario = 2000.0,
        senha = 2000
    )

    val cliente = Cliente(
        nome = "Fran",
        cpf = "3",
        senha = 3000
    )

    val sistemaInterno = SistemaInterno()

    sistemaInterno.entra(analista, 1000)
    sistemaInterno.entra(gerente, 2000)
    sistemaInterno.entra(cliente, 3000)
}