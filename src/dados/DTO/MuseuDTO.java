package dados.DTO;


public class MuseuDTO {
	private int id;
	private String Nome;
	private String dataCriacao;
	private String Cidade;
	private String Estado;
	private int idGestor;	
	
	public MuseuDTO(int id, String nome, String dataC, String cidade, String estado, int idGestor){
		this.id = id;
		this.Nome = nome;
		this.dataCriacao = dataC;
		this.Cidade = cidade; 
		this.Estado = estado;
		this.idGestor = idGestor;
	}
	
	public MuseuDTO(String nome, String dataC, String cidade, String estado, int idGestor){
		this.Nome = nome;
		this.dataCriacao = dataC;
		this.Cidade = cidade; 
		this.Estado = estado;
		this.idGestor = idGestor;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public String getDataCriacao() {
        return dataCriacao;
	}
	
	public String getCidade() {
        return Cidade;
	}
	
	 public String getEstado() {
	        return Estado;
	}
	public int getIdGestor() {
	       return idGestor;
	}
}
