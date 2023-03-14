class SistemaInterno {

    fun entra(admin: Autenticavel, senha: Int) {
        if(admin.autentica(senha)) {
            println("Bem vindo ao sistema Bytebank")
        } else {
            println("Falha na autenticacao")
        }
    }
}