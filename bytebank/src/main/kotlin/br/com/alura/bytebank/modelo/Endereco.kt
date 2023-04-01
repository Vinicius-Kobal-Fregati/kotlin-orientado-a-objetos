package br.com.alura.bytebank.modelo

class Endereco(
    var logradouro: String = "",
    var numeroEndereco: Int = 0,
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = "",
    // Deve ser evitado criar variáveis que podem ser nulas
    var complemento: String? = null
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

    override fun equals(other: Any?): Boolean {
        // Verifica se a referência é a mesma
        if (this === other) return true
        // Verifica se as classes são diferentes
        if (javaClass != other?.javaClass) return false

        other as Endereco

        // Verifica os parâmetros
        if (logradouro != other.logradouro) return false
        if (numeroEndereco != other.numeroEndereco) return false
        if (bairro != other.bairro) return false
        if (cidade != other.cidade) return false
        if (estado != other.estado) return false
        if (cep != other.cep) return false
        if (complemento != other.complemento) return false

        return true
    }

    override fun hashCode(): Int {
        var result = logradouro.hashCode()
        result = 31 * result + numeroEndereco
        result = 31 * result + bairro.hashCode()
        result = 31 * result + cidade.hashCode()
        result = 31 * result + estado.hashCode()
        result = 31 * result + cep.hashCode()
        result = 31 * result + complemento.hashCode()
        return result
    }

    fun completo(): String {
        return """
            $logradouro - $numeroEndereco, $bairro, $cidade - $estado
            $cep
            $complemento
        """.trimIndent()
    }
}