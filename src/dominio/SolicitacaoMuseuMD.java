package dominio;

public class SolicitacaoMuseuMD
{
	private String nome;
	private String estado;
	private String cpfGestor;
	private String cidade;
	private String senha;
	
	public SolicitacaoMuseuMD(String nome, String estado, String cpfGestor, String cidade, String senha)
	{
		this.nome = nome;
		this.estado = estado;
		this.cpfGestor = cpfGestor;
		this.cidade = cidade;
		this.senha = senha;
	}
	
}
