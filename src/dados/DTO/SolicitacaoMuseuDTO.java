package dados.DTO;



public class SolicitacaoMuseuDTO {
	private int id;
	private String nome;
	private String dataCriacao;
	private String cidade;
	private String estado;
	private String cpfGestor;
	private String senhaGestor;
	
	public SolicitacaoMuseuDTO(int id, String nome, String dataC, String cidade, String estado, String cpfGestor, String senhaGestor){
		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataC;
		this.cidade = cidade;
		this.estado = estado;
		this.cpfGestor = cpfGestor;
		this.senhaGestor = senhaGestor;
	}
	public SolicitacaoMuseuDTO(String nome, String dataC, String cidade, String estado, String cpfGestor, String senhaGestor){
	
		this.nome = nome;
		this.dataCriacao = dataC;
		this.cidade = cidade;
		this.estado = estado;
		this.cpfGestor = cpfGestor;
		this.senhaGestor = senhaGestor;
	}
	public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCpfGestor() {
        return cpfGestor;
    }

    public String getSenhaGestor() {
        return senhaGestor;
    }
}
