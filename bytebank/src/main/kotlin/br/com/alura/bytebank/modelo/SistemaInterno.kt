package br.com.alura.bytebank.modelo

class SistemaInterno {

    // Usou default no Unit para evitar que quebre o código antigo
    fun entra(admin: Autenticavel, senha: Int, autenticado: () -> Unit = {}) {
        if(admin.autentica(senha)) {
            println("Bem vindo ao sistema Bytebank")
            // Quando for autenticado, pode executar alguma função
            autenticado()
        } else {
            println("Falha na autenticacao")
        }

        when (admin) {
            is FuncionarioAdmin -> println("Opções admin")
            is Funcionario -> println("Opções comum")
            else -> println("Opções reduzidas")
        }
    }

    fun entraReceiver(admin: Autenticavel, senha: Int, autenticado: SistemaInterno.() -> Unit = {}) {
        if(admin.autentica(senha)) {
            println("Bem vindo ao sistema Bytebank")
            // Quando for autenticado, pode executar alguma função
            autenticado()
        } else {
            println("Falha na autenticacao")
        }
    }

    fun pagamento() {
        println("Realizando pagamento")
    }
}