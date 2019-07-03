package dados.DTO;

import dados.ENUM.Tipo_Usuario;


public abstract class Usuario 
{
	protected int id;
	protected String Nome;
	protected String CPF;
	protected String senha;
	protected Tipo_Usuario Tipo;
	
	
	Usuario(int id, String nome, String CPF, String senha, Tipo_Usuario tipo)
	{
		this.id = id;
		this.Nome = nome;
		this.CPF = CPF;
		this.senha = senha;
		this.Tipo = tipo;
	}
	
	Usuario(int id, String nome, String senha, Tipo_Usuario tipo)
	{
		this.id = id;
		this.Nome = nome;
		this.senha = senha;
		this.Tipo = tipo;
	}
	
	Usuario(int id, String nome, String senha)
	{
		this.id = id;
		this.Nome = nome;
		this.senha = senha;
	}
	
	Usuario(String nome,String cpf,String senha,Tipo_Usuario tipo)
	{
		this.Nome = nome;
		this.CPF = cpf;
		this.senha = senha;
		this.Tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return Nome;
	}
//	public void setCPF(String cpf) {
//		if(validaCPF.isCPF(cpf))
//			this.CPF = cpf;
//		else
//			this.CPF = "INV�LIDO!"; //CRIAR UMA EXCEPTION PARA SUBSTITUIR ISSO?
//	}
	public String getCPF() {
		return CPF;
	}
	public void setTipo(Tipo_Usuario tipo) {
		this.Tipo = tipo;
	}
	public Tipo_Usuario getTipo() {
		return Tipo;
	}
	public String getSenha() {
		return senha;
	}
}
