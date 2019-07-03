package dados.DTO;

import dados.ENUM.EstadoConservacao;

public class AvaliacaoCoisaDTO extends Avaliacao {

	@Override
	public EstadoConservacao getEstadoC() {
		return this.EstadoC;
	}

	@Override
	public void setEstadoC(EstadoConservacao EstadoC) {		
		this.EstadoC = EstadoC;
	}

}
