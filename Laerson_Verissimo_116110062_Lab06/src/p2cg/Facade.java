package p2cg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import exceptions.InvalidConditionException;
import exceptions.NullReferenceException;
import exceptions.NumeroInvalidoException;
import exceptions.ObjectNotFoundException;
import exceptions.StringInvalidaException;
/**
 * Representação da loja do p2cg.
 * <p>
 * Facade contém uma coleção de <code>Usuario</code>, e fornece métodos para manuntenção dos mesmos. 
 * @author laersonsv
 *
 */
public class Facade {
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facade other = (Facade) obj;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}
	/**
	 * Lista de usuários, que mapeia cada login a um objeto <code>Usuario</code>
	 */
	private Map<String, Usuario> usuarios;

	public Facade() {
		usuarios = new HashMap<String, Usuario>();
	}
	/**
	 * Cria uma nova instância de <code>Usuario</code>
	 * @param nome nome do usuário.
	 * @param login login do usuário.
	 */
	public void createUser(String nome, String login) {
		try {
			Usuario user = new Noob(nome, login);
			usuarios.put(login, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Adiciona uma certa quantia de dinheiro a um usuário, identificado pelo login.
	 * 
	 * @param dinheiro quantia a ser adicionada ao saldo do usuário.
	 * @param login login do usuário que irá receber a quantia
	 * @return true se o método for bem sucedido
	 * @throws Exception se <code>dinheiro</code> < 0, ou se não existir uma entrada com a chave <code>login</code>
	 *  em <code>usuarios</code>.
	 */
	public boolean addDinheiro(double dinheiro, String login) throws Exception {
		if(dinheiro < 0)
			throw new NumeroInvalidoException("dinheiro não pode ser negativo");
		if(!usuarios.containsKey(login))
			throw new ObjectNotFoundException("Login não registrado");
		usuarios.get(login).adicionaDinheiro(dinheiro);
		return true;
	}
	/**
	 * Chama o método <code>Usuario.compraJogo(Jogo j).
	 * @param j jogo a ser vendido
	 * @param login login do usuário que irá comprar o jogo
	 * @return true se o jogo for comprado
	 * @throws Exception se o login ou o jogo forem null (Ou se o login for vazio)
	 */
	public boolean vendeJogo(Jogo j, String login) throws Exception {
		if(j == null)
			throw new NullReferenceException("jogo não pode ser null");
		if(Usuario.checaStringVazia(login))
			throw new StringInvalidaException();
		
		return usuarios.get(login).compraJogo(j);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("=== Central P2-CG ===\n\n");
		
		for(Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
			Usuario u = entry.getValue();
			builder.append(u.toString());
		}
		return builder.toString();
	}
	/**
	 * Transforma um usuário Noob em um usuário Veterano.
	 * <p>
	 * Se o usuário identificado pelo <code>login</code> for uma instancia de <code>Noob</code>, é criada uma 
	 * nova instância de <code>Veterano</code>, que copia os atributos do usuário mapeado à <code>login</code>, e
	 * o substitui.
	 * @param login login do usuário a sofrer o "upgrade".
	 * @throws Exception Se não houver nenhuma entrada em <code>usuarios</code> com <code>login</code>.
	 * @throws Exception Se a quantidade de x2p for insuficiente para um upgrade.
	 * @throws Exception Se o usuário já for veterano. 
	 */
	public void upgrade(String login) throws Exception {
		if(!usuarios.containsKey(login))
			throw new ObjectNotFoundException("login não registrado");
		Usuario u = usuarios.get(login);
		if(u.getX2p() < 1000)
			throw new InvalidConditionException("Quantidade de x2p insuficiente");
		if(u instanceof Veterano)
			throw new InvalidConditionException("Usuário já é veterano");
		
		Usuario u2 = new Veterano(u.getNome(), u.getLogin());
		u2.adicionaDinheiro(u.getSaldo());
		
		Iterator<Jogo> i = u.getJogos().iterator();
		while(i.hasNext())
			u2.addJogo(i.next());
		u2.addX2p(u.getX2p() - 1000);
		
		usuarios.put(login, u2);
	}
}
