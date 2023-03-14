fun main() {
    println("Bem vindo ao Bytebank")

    val vinicius = Funcionario(
        nome = "Vinícius",
        cpf = "111.111.111-11",
        salario = 2000.0,
        tipo = 0
    )

    println("nome ${vinicius.nome}")
    println("cpf ${vinicius.cpf}")
    println("salario ${vinicius.salario}")
    println("bonificação ${vinicius.bonificacao()}")
}

