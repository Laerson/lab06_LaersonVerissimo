package p2cg;

enum Tipo {
	RPG("RPG"),
	LUTA("Luta"),
	PLATAFORMA("Plataforma");
	
	private final String tipo;
	
	Tipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
