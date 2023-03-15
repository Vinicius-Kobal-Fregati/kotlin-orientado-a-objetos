package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.modelo.Funcionario

class CalculadoraBonificacao {

    var total: Double = 0.0
        private set

    fun registra(funcionario: Funcionario) {
        this.total += funcionario.bonificacao
    }

    /*
    fun registra(funcionario: Any) {
        //Cast
        //val funcionarioNovo: Funcionario =
        // Smart cast
        funcionario as Funcionario
        this.total += funcionario.bonificacao
    }

    fun registra(funcionario: Any) {
        if (funcionario is Funcionario) {
            this.total += funcionario.bonificacao
        }
    }
     */
}