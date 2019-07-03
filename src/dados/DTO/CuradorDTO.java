package dados.DTO;

import dados.ENUM.Tipo_Usuario;

public class CuradorDTO extends Funcionario {

	CuradorDTO(int id, String nome, String CPF, String senha) {
		super(id, nome, CPF, senha);
		// TODO Auto-generated constructor stub
	}
	CuradorDTO(int id, String nome, String senha) {
		super(id, nome, senha);
		// TODO Auto-generated constructor stub
	}
	

}
