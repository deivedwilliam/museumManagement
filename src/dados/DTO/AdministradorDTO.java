package dados.DTO;

import dados.ENUM.Tipo_Usuario;

public class AdministradorDTO extends Usuario
{

	public AdministradorDTO(int id, String nome, String cpf, String senha) 
	{
		super(id, nome, cpf, senha, Tipo_Usuario.ADMINISTRADOR);
	}
	
	public AdministradorDTO(String nome, String cpf, String senha) 
	{
		super(nome, cpf, senha, Tipo_Usuario.ADMINISTRADOR);
	}
}
