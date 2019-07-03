package dados.DTO;

import java.util.Date;

import dados.ENUM.EstadoConservacao;

public class AvalicaoUsuarioDTO extends Avaliacao {
	private Date Data;
	private Usuario usuario;
	@Override
	public EstadoConservacao getEstadoC() {
		return this.EstadoC;
	}

	@Override
	public void setEstadoC(EstadoConservacao EstadoC) {		
		this.EstadoC = EstadoC;
	}

}
