package p2cg;

import exceptions.*;
import java.util.HashSet;
import java.util.Set;

/**
 * <code>Jogo</code> é a classe que representa uma cópia que um determinado
 * usuário tem de um jogo.
 * <p>
 * Um objeto <code>Jogo</code> guarda informações específicas de um jogo (nome,
 * gênero, preço, ...), e informações relacionadas ao usuário daquele jogo
 * (recordes, vezes jogadas, ...) . *
 * 
 * @author laersonsv
 *
 */
public class Jogo {
	/**
	 * Título do jogo na loja.
	 * <p>
	 * Cada jogo tem um nome único, e imutável.
	 */
	private final String nome;
	/**
	 * Preço atual do jogo na loja.
	 */
	private Double preco;
	/**
	 * Essa coleção armazena Enumeradores que informam características sobre a
	 * jogabilidade.
	 * <p>
	 */
	// Não é final, pois modos de jogo podem ser adicionados(ou removidos), ao
	// longo do tempo
	// Ex: O jogo ser originalmente single player, mas futuramente adicionarem
	// um modo multiplayer
	private Set<Jogabilidade> jogabilidade;
	/**
	 * Maior score obtido pelo usuário que tem uma cópia desse jogo.
	 */
	private int maiorScore;
	/**
	 * Quantidade de vezes que o usuário jogou o jogo.
	 */
	private int vezesJogado;
	/**
	 * Quantidade de vezes que o usuário concluiu o jogo
	 */
	private int vezesConcluido;

	/**
	 * Constroi um <code>Jogo</code>. As informações relacionadas ao usuário do
	 * jogo (maior score, quantas vezes foi jogado, etc), são iniciadas com
	 * valor default.
	 * <p>
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preço do jogo.
	 * @param jogabilidade
	 *            Conjunto de Enumeradores, que armazena os modos de jogo. A
	 *            coleção HashSet garante que não há duplicatas.
	 * @throws Exception
	 *             se o paramêtro <code>nome</code> estiver vazio, ou se o preço
	 *             for negativo.
	 */
	public Jogo(String nome, Double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		if (checaStringVazia(nome))
			throw new StringInvalidaException("nome não pode ser vazio");
		if (preco < 0)
			throw new NumeroInvalidoException("preco não pode ser negativo");

		this.nome = nome;
		this.preco = preco;
		this.jogabilidade = jogabilidade;
	}

	/**
	 * Checa se a <code>String</code> passada como argumento está vazia.
	 * <p>
	 * A string é considerada vazia, mesmo que tenha caracteres não-gráficos.
	 * 
	 * @param s
	 *            String a ser checada.
	 * @return <code>true</true> se a <code>String</code> estiver vazia.
	 */
	private static boolean checaStringVazia(String s) {
		if (s == null || s.trim().length() == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param score
	 * @param wasFinished
	 * @throws Exception
	 */
	protected int registraJogada(int score, boolean wasFinished) throws Exception {
		if (score < 0)
			throw new NumeroInvalidoException("Score não pode ser negativo");
		if (score > maiorScore)
			maiorScore = score;
		if (wasFinished)
			vezesConcluido++;
		vezesJogado++;
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 *            the preco to set
	 */
	public void setPreco(Double preco) {
		if (preco < 0)
			this.preco = preco;
	}

	/**
	 * @return the jogabilidade
	 */
	public Set<Jogabilidade> getJogabilidade() {
		return jogabilidade;
	}

	/**
	 * @param jogabilidade
	 *            the jogabilidade to set
	 */
	public void setJogabilidade(HashSet<Jogabilidade> jogabilidade) {
		this.jogabilidade = jogabilidade;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the maiorScore
	 */
	public int getMaiorScore() {
		return maiorScore;
	}

	/**
	 * @return the vezesJogado
	 */
	public int getVezesJogado() {
		return vezesJogado;
	}

	/**
	 * @return the vezesConcluido
	 */
	public int getVezesConcluido() {
		return vezesConcluido;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("+ %s - %s:\n", nome, getClass().getSimpleName()));
		builder.append(String.format("==> Jogou %d vez(es)\n", getVezesJogado()));
		builder.append(String.format("==> Zerou %d vez(es)\n", getVezesConcluido()));
		builder.append(String.format("==> Maior score: %d\n", getMaiorScore()));
		return builder.toString();
	}

}
