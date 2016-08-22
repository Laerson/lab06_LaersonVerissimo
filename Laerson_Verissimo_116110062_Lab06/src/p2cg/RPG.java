/**
 * 
 */
package p2cg;

import java.util.HashSet;

/**
 * @author laersonsv
 *
 */
public class RPG extends Jogo {

	/**
	 * @param nome
	 * @param preco
	 * @param jogabilidade
	 * @throws Exception
	 */
	public RPG(String nome, Double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see p2cg.Jogo#registraJogada(int, boolean)
	 */
	@Override
	public int registraJogada(int score, boolean wasFinished) throws Exception {
		super.registraJogada(score, wasFinished);
		return 10;
	}

}
