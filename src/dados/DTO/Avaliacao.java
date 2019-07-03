package dados.DTO;

import dados.ENUM.EstadoConservacao;

public abstract class Avaliacao {
	protected EstadoConservacao EstadoC;
	public abstract EstadoConservacao getEstadoC();
	public abstract void setEstadoC(EstadoConservacao EstadoC);
}
