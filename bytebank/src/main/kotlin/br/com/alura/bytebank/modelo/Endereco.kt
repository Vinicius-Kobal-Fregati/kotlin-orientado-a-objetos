package br.com.alura.bytebank.modelo

class Endereco(
    var logradouro: String = "",
    var numeroEndereco: Int = 0,
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = "",
    var complemento: String = ""
) {
    override fun toString(): String {
        // raw string
        return """
            Endereco(logradouro='$logradouro', 
            numeroEndereco=$numeroEndereco, 
            bairro='$bairro', 
            cidade='$cidade', 
            estado='$estado', 
            cep='$cep', 
            complemento='$complemento')
            """.trimIndent()
    }
}