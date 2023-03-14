class Cliente(
    val nome: String,
    val cpf: String,
    val senha: Int
) : FuncionarioAdmin(
    // Nesse exemplo vemos a "falha" da herança, pois não podemos ter os outros atributos do FuncionarioAdmin
    nome = nome,
    cpf = cpf,
    senha = senha
){
}