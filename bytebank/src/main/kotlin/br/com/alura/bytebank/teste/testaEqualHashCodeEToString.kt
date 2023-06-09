package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco

private fun testaEqualHashCodeEToString() {
    val endereco = Endereco(
        logradouro = "Rua Vergueiro",
        complemento = "Alura",
        cep = "00000-000"
    )
    var enderecoNovo = Endereco(
        logradouro = "Rua Vergueiro",
        complemento = "Alura",
        cep = "00000-000"
    )

    println(endereco.equals(enderecoNovo))
    println(endereco.equals(endereco))

    println(endereco.hashCode())
    println(enderecoNovo.hashCode())


    // Representação do objeto
    println(endereco.toString())
    // Chama o toString internamente
    println(endereco)
    println(enderecoNovo.toString())

    enderecoNovo = endereco
    println(endereco.equals(enderecoNovo))
    println(
        "${enderecoNovo.javaClass}@${
            Integer.toHexString(enderecoNovo.hashCode())
        }"
    )
}
