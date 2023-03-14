fun main() {
    println("Bem vindo ao Bytebank")

    val vinicius = Funcionario(
        nome = "Vinícius",
        cpf = "111.111.111-11",
        salario = 2000.0,
    )

    println("nome ${vinicius.nome}")
    println("cpf ${vinicius.cpf}")
    println("salario ${vinicius.salario}")
    println("bonificação ${vinicius.bonificacao()}")

    val fran = Gerente(
        nome = "Fran",
        cpf = "222.222.222-22",
        salario = 4000.0,
        senha = 1234
    )

    println("nome ${fran.nome}")
    println("cpf ${fran.cpf}")
    println("salario ${fran.salario}")
    println("bonificação ${fran.bonificacao()}")
    if (fran.autentica(1234)) {
        println("autenticou com sucesso")
    } else {
        println("falha na autenticação")
    }
}

