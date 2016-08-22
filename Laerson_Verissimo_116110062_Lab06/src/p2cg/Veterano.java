/**
 * 
 */
package p2cg;

/**
 * @author laersonsv
 *
 */
public class Veterano extends Usuario {

	/**
	 * @param nome
	 * @param login
	 * @throws Exception
	 */
	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
		addX2p(1000);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean compraJogo(Jogo j) throws Exception {
		if(j == null)
			throw new Exception("Jogo não pode ser null");
		if(getSaldo() < j.getPreco() * 0.8)
			return false;
		adicionaDinheiro(-j.getPreco() * 0.8);
		addX2p((int) Math.round(15 * j.getPreco()));
		return super.compraJogo(j);
	}

}