package p2cg;

import java.util.HashSet;

/**
 * <code>Usuario</code> é a classe abstrata base para os diferentes usuários do <code>P2CG</code>
 * <p>
 * @author laersonsv
 *
 */
public abstract class Usuario {
	/**
	 * Nome usado pelo usuario pra fazer login
	 */
	private final String nome;
	/**
	 * lista de jogos que o usuário comprou
	 */
	private HashSet<Jogo> jogos;
	/**
	 * Quantia em dinheiro que o usuário tem disponível pra comprar jogos
	 */
	private double saldo;
	/**
	 * Quantia de "eXperiente Player Privilege", que o usuário tem na conta
	 * <p>
	 * 
	 */
	private int x2p;
	
	public Usuario(String nome) {
		this.nome = nome;
		jogos = new HashSet<Jogo>();		
	}
	/**
	 * 
	 * @return
	 */
	public final String getNome() {
		return nome;
	}
	/**
	 * 
	 * @return
	 */
	public HashSet<Jogo> getJogos() {
		return jogos;
	}
	/**
	 * 
	 * @return
	 */
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo() {
		this.saldo = saldo;
	}
	/**
	 * 
	 * @return
	 */
	public int getX2p() {
		return x2p;
	}
	
	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
	/**
	 * 
	 * @param j
	 * @return
	 */
	public boolean addJogo(Jogo j) {
		return jogos.add(j);
	}

}
