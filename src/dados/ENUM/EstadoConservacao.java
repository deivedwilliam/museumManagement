package dados.ENUM;

public enum EstadoConservacao {
	EXCELENTE(3), BOM(2), RUIM(1), CRITICO(0);
	private final int valorEstado;
	EstadoConservacao(int estadoOpcao){
		valorEstado = estadoOpcao;
    }
    public int getValorEstado(){
        return valorEstado;
    }
}
