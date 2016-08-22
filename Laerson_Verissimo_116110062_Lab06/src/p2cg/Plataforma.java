/**
 * 
 */
package p2cg;

import java.util.HashSet;

/**
 * @author laersonsv
 *
 */
public class Plataforma extends Jogo {

	/**
	 * @param nome
	 * @param preco
	 * @param jogabilidade
	 * @throws Exception
	 */
	public Plataforma(String nome, Double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int registraJogada(int score, boolean wasFinished) throws Exception {
		super.registraJogada(score, wasFinished);
		return wasFinished ? 20 : 0;
	}

}
