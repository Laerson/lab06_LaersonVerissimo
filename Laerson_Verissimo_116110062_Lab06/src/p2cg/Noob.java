/* 116110062 - Laerson Saraiva Verissimo: LAB 6 - Turma 2 */
/**
 * 
 */
package p2cg;

import exceptions.NullReferenceException;

/**
 * @author laersonsv
 *
 */
public class Noob extends Usuario {

	/**
	 * @param nome
	 * @param login
	 * @throws Exception
	 */
	public Noob(String nome, String login) throws Exception {
		super(nome, login);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean compraJogo(Jogo j) throws Exception {
		if(j == null)
			throw new NullReferenceException("Jogo não pode ser null");
		if(getSaldo() < j.getPreco() * 0.9)
			return false;
		adicionaDinheiro(-j.getPreco() * 0.9);
		addX2p((int) Math.round(10 * j.getPreco()));
		return super.compraJogo(j);
	}

}
