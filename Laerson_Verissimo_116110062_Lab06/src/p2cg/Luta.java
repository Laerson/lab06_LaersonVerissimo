/**
 * 
 */
package p2cg;

import java.util.HashSet;

/**
 * @author laersonsv
 *
 */
public class Luta extends Jogo {

	public Luta(String nome, Double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see p2cg.Jogo#registraJogada(int, boolean)
	 */
	@Override
	public int registraJogada(int score, boolean wasFinished) throws Exception {
		if(score > 100000)
			throw new Exception("O score máximo é 100.000");
		int x2p = 0;
		if(score > getMaiorScore())
			x2p = score / 1000;
		super.registraJogada(score, wasFinished);
		return x2p;
	}

}
