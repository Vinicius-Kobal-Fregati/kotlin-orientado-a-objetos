fun testaAutenticacao() {
    val gerente = Gerente(
        nome = "Vinícius",
        cpf = "111.111.111-11",
        salario = 3000.0,
        senha = 1234
    )

    val diretora = Diretor(
        nome = "Fran",
        cpf = "111.111.111-12",
        salario = 5000.0,
        senha = 1234,
        plr = 200.0
    )

    val cliente = Cliente(
        nome = "Gui",
        cpf = "333.333.333-33",
        senha = 1234
    )

    val sistema = SistemaInterno()
    sistema.entra(gerente, 1235)
    sistema.entra(diretora, 1234)
    sistema.entra(cliente, 1234)
}