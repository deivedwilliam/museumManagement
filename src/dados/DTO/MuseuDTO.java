package dados.DTO;

import java.time.LocalDate;

public class MuseuDTO {
	private int id;
	private String Nome;
	private LocalDate dataCriacao;
	private String Cidade;
	private String Estado;
	private int idGestor;	
	
	public MuseuDTO(int id, String nome, LocalDate dataC, String cidade, String estado, int idGestor){
		this.id = id;
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
	
	public LocalDate getDataCriacao() {
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
