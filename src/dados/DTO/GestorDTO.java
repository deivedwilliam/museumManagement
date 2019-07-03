package dados.DTO;

public class GestorDTO extends Funcionario {
	private int idMuseu;
	public GestorDTO(int id, String nome, String CPF, String senha) {
		super(id, nome, CPF, senha);
		
		// TODO Auto-generated constructor stub
	}
	public GestorDTO(int id, String nome, String senha) {
		super(id, nome, senha);
		// TODO Auto-generated constructor stub
	}

	public void setIdMuseu(int idMuseu) {
		this.idMuseu = idMuseu;
	}
	public int getIdMuseu() {
		return this.idMuseu;
	}
}
