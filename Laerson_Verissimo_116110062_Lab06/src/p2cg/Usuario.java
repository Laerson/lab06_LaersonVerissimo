package p2cg;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import exceptions.NullReferenceException;
import exceptions.ObjectNotFoundException;
import exceptions.StringInvalidaException;
/**
 * <code>Usuario</code> é a classe abstrata base de diversos tipos de clientes do p2cg.
 * <p>
 * Um Usuario armazena diversas informações desse cliente, bem como oferece métodos para a compra de jogos.
 * @author laersonsv
 *
 */
public abstract class Usuario {
	/**
	 * Nome do cliente.
	 */
	private final String nome;
	/**
	 * Login único, utilizado pelo cliente.
	 */
	private final String login;
	/**
	 * Quantia de dinheiro que o usuário tem disponível para comprar jogos.
	 */
	private double saldo;
	/**
	 * Lista de jogos comprados pelo cliente.
	 */
	private Set<Jogo> jogos;
	/**
	 * Quantidade de pontos do sistema de recompensas x2p que o usuário tem
	 */
	private int x2p;
	/**
	 * 
	 * @param nome
	 * @param login
	 * @throws Exception
	 */
	public Usuario(String nome, String login)  throws Exception {
		if(checaStringVazia(nome))
			throw new StringInvalidaException("nome não pode ser vazio");
		if(checaStringVazia(login))
			throw new StringInvalidaException("login não pode ser vazio");
		
		this.nome = nome;
		this.login = login;
		jogos = new HashSet<Jogo>();
	}
	/**
	 * Checa se a <code>String</code> passada como argumento está vazia.
	 * <p>
	 * A string é considerada vazia, mesmo que tenha caracteres não-gráficos.
	 * 
	 * @param s String a ser checada.
	 * @return <code>true</true> se a <code>String</code> estiver vazia.
	 */
	protected static boolean checaStringVazia(String s) {
		if(s == null || s.trim().length() == 0)
			return true;
		return false;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * @return the jogos
	 */
	public Set<Jogo> getJogos() {
		return jogos;
	}
	/**
	 * 
	 * @return quantia de x2p;
	 */
	public int getX2p() {
		return x2p;
	}
	/**
	 * Adiciona uma certa quantia de pontos x2p.
	 * @param i quantia a ser adicionada
	 */
	public void addX2p(int i) {
		x2p += i;
	}
	/**
	 * Adiciona ou remove uma certa quantia de dinheiro ao saldo do usuário.
	 * @param dinheiro quantia a ser adicionada/removida.
	 */
	public void adicionaDinheiro(double dinheiro) {
		saldo += dinheiro;
	}
	/**
	 * Adiciona um jogo à lista de jogos comprados.
	 * @param j jogo a ser adicionado
	 * @return
	 * @throws Exception
	 */
	public boolean compraJogo(Jogo j) throws Exception {
		return addJogo(j);
	}
	public boolean addJogo(Jogo j) throws Exception {
		if(j == null)
			throw new NullReferenceException("Jogo não pode ser null");
		return jogos.add(j);
	}
	/**
	 * 
	 * @param nome
	 * @param score
	 * @param zerou
	 * @return
	 * @throws Exception
	 */
	public void registraJogada(String nome, int score, boolean wasFinished) throws Exception {
		if(checaStringVazia(nome))
			throw new StringInvalidaException();
		Iterator<Jogo> i = jogos.iterator();
		while(i.hasNext()) {
			Jogo j = i.next();
			if(j.getNome().equals(nome)) {
				addX2p(j.registraJogada(score, wasFinished));
				break;
			}
		}
		throw new ObjectNotFoundException("O Usuário não comprou esse jogo");
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(login + "\n");
		builder.append(String.format("%s - Jogador %s\n", nome, getClass().getName()));
		builder.append("Lista de Jogos:\n");
		
		Iterator<Jogo> i = jogos.iterator();
		double precoTotal = 0;
		while(i.hasNext()) {
			Jogo j = i.next();
			precoTotal += j.getPreco();
			builder.append(j.toString() + "\n");
		}
		builder.append(String.format("Total de preço dos jogos: R$ %.2f\n", precoTotal));
		builder.append("--------------------------------------------\n\n");
		return builder.toString();
	}
}
