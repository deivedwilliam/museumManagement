package dados.DTO;

import dados.ENUM.Tipo_Usuario;

public class VisitanteDTO extends Usuario
{
	public VisitanteDTO(int id, String nome, String cpf, String senha) 
	{
		super(id, nome, cpf, senha, Tipo_Usuario.VISITANTE);
	}
	public VisitanteDTO(String nome,String cpf,String senha,Tipo_Usuario tipo)
	{
		super(nome, cpf, senha, Tipo_Usuario.VISITANTE);
	}
}
