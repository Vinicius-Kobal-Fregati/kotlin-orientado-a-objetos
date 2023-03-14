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
    println("bonificação ${vinicius.bonificacao}")

    val fran = Gerente(
        nome = "Fran",
        cpf = "222.222.222-22",
        salario = 4000.0,
        senha = 1234
    )

    println("nome ${fran.nome}")
    println("cpf ${fran.cpf}")
    println("salario ${fran.salario}")
    println("bonificação ${fran.bonificacao}")
    if (fran.autentica(1234)) {
        println("autenticou com sucesso")
    } else {
        println("falha na autenticação")
    }

    val gui = Diretor(
        nome = "Guilherme",
        cpf = "333.333.333-33",
        salario = 6000.0,
        senha = 4000,
        plr = 200.0
    )

    println("nome ${gui.nome}")
    println("cpf ${gui.cpf}")
    println("salario ${gui.salario}")
    println("bonificação ${gui.bonificacao}")
    println("plr ${gui.plr}")
    if (gui.autentica(4000)) {
        println("autenticou com sucesso")
    } else {
        println("falha na autenticação")
    }

    val maria: Funcionario = Analista(
        nome = "Maria",
        cpf = "444.444.444-44",
        salario = 3000.0
    )

    val calculadora = CalculadoraBonificacao()
    calculadora.registra(vinicius)
    calculadora.registra(fran)
    calculadora.registra(gui)
    calculadora.registra(maria)

    println("total de bonificação: ${calculadora.total}")
}

