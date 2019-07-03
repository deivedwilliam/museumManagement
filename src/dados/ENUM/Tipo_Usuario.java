package dados.ENUM;

public enum Tipo_Usuario {
	ADMINISTRADOR{
		@Override
		public String toString() {
			return "ADMINISTRADOR";
		}
	}, 
	VISITANTE{
		@Override
		public String toString() {
			return "VISITANTE";
		}
	}, 
	FUNCIONARIO{
		@Override
		public String toString() {
			return "FUNCIONARIO";
		}
	};
}
