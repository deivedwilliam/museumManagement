package dados.DTO;

import dados.ENUM.Tipo_Usuario;

public abstract class Funcionario extends Usuario {

	Funcionario(int id, String nome, String CPF, String senha) {
		super(id, nome, CPF, senha, Tipo_Usuario.FUNCIONARIO);
		// TODO Auto-generated constructor stub
	}
	Funcionario(int id, String nome, String senha) {
		super(id, nome, senha, Tipo_Usuario.FUNCIONARIO);
		// TODO Auto-generated constructor stub
	}

}
