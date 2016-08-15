package p2cg;

enum Jogabilidade {
	ONLINE("Online"),
	OFFLINE("Offline"),
	MULTIPLAYER("Multiplayer"),
	COOPERATIVO("Cooperativo"),
	COMPETITIVO("Competitivo");
	
	private final String jogabilidade;
	
	Jogabilidade(String jogabilidade) {
		this.jogabilidade = jogabilidade;
	}
	
	public String getJogabilidade() {
		return jogabilidade;
	}
}
