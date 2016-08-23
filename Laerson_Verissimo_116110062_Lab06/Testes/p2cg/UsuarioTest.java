package p2cg;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	private HashSet<Jogabilidade> jogabilidades1;
	private HashSet<Jogabilidade> jogabilidades2;
	private HashSet<Jogabilidade> jogabilidades3;
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	
	@Before
	public void criaParametros() throws Exception {
		jogabilidades1 = new HashSet<>();
		jogabilidades2 = new HashSet<>();
		for(Jogabilidade j : Jogabilidade.values())
			jogabilidades2.add(j);
		jogabilidades3 = new HashSet<>();
		jogabilidades3.add(Jogabilidade.ONLINE);
		
		jogo1 = new RPG("Neverwinter", 20.0, jogabilidades1);
		jogo2 = new Luta("Street Fighter", 50.0, jogabilidades2);
		jogo3 = new Plataforma("Zelda", 100.0, jogabilidades3);
			
		
	}

	@Test
	public void testConstrutor() {
		try {
			Usuario nomeVazio = new Usuario(null, "login");
			fail();
		} catch (Exception e) {
			assertEquals("nome não pode ser vazio", e.getMessage());
		}
		
		try {
			Usuario nomeVazio = new Usuario("", "login");
			fail();
		} catch (Exception e) {
			assertEquals("nome não pode ser vazio", e.getMessage());
		}
		
		try {
			Usuario nomeVazio = new Usuario("    ", "login");
			fail();
		} catch (Exception e) {
			assertEquals("nome não pode ser vazio", e.getMessage());
		}
		
		try {
			Usuario loginVazio = new Usuario("Laerson", null);
			fail();
		} catch (Exception e) {
			assertEquals("login não pode ser vazio", e.getMessage());
		}
		
		try {
			Usuario loginVazio = new Usuario("Laerson", "");
			fail();
		} catch (Exception e) {
			assertEquals("login não pode ser vazio", e.getMessage());
		}
		
		try {
			Usuario loginVazio = new Usuario("Laerson", "    ");
			fail();
		} catch (Exception e) {
			assertEquals("login não pode ser vazio", e.getMessage());
		}
		
		try {
			Usuario usuario = new Usuario("Laerson", "login");
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRegistraJogada() {
		
	}
}
