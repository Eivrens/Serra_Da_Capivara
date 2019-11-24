package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.FuncionarioDados;
import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.utills.Verificar;

public class FuncionarioNegocio {
	
	private FuncionarioDados funcsDados = new FuncionarioDados();

	public String verificarCadastro(Funcionario func) throws ClassNotFoundException, IOException {

		if (Verificar.verificarCPF(func) == false) {

			return "O Funcionario n�o foi cadastrado, pois seu CPF est� incorreto";

		} else if (func.getIdade() <= 18) {

			return "O Funcionario n�o foi cadastrado pois n�o tem idade o suficiente";

		} else if (Verificar.verificarSenha(func) == false) {

			return "O Funcionario n�o foi cadastrado pois a senha est� incorreta";

		} else if (Verificar.VerificarEmail(func) == false) {

			return "O Funcionario n�o foi cadastrado pois o email est� incorreto";

		}

		funcsDados.cadastrar(func);
		return "Funcionario Cadastrado com sucesso!";

	}

	public Funcionario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Funcionario func = (Funcionario) funcsDados.consultaFuncionario(email, senha);
		return func;
	}

	public String verificarRemocao(String cpf) throws ClassNotFoundException, IOException {
		funcsDados.removerDados(cpf);
		return "Funcionario removido";
	}

}
