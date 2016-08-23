/* 116110062 - Laerson Saraiva Verissimo: LAB 6 - Turma 2 */
package p2cg;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JogoTest {
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
		
			jogo1 = new Jogo("jogo1", 20.0, jogabilidades1);
			jogo2 = new Jogo("jogo2", 50.0, jogabilidades2);
			jogo3 = new Jogo("jogo3", 100.0, jogabilidades3);		
	}

	@Test
	public void testJogoNomeInvalido() {
		try {
			Jogo nomeVazio = new Jogo(null, 20.0, jogabilidades1);
			fail("deveria ter lançado exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "nome não pode ser vazio");
		}
		
		try {
			Jogo nomeVazio2 = new Jogo("", 20.0, jogabilidades2);
			fail("deveria ter lançado exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "nome não pode ser vazio");
		}
		
		try {
			Jogo nomeVazio3 = new Jogo("     ", 20.0, jogabilidades3);
			fail("deveria ter lançado exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "nome não pode ser vazio");
		}
	}
	
	@Test
	public void testJogoPrecoNegativo() {
		try {
			Jogo precoNegativo = new Jogo("precoNegativo", -20.0, jogabilidades2);
			fail("deveria ter lançado exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "preco não pode ser negativo");
		}
	}
	
	@Test
	public void testJogoValido() {
		try {
			jogo1 = new Jogo("jogo1", 20.0, jogabilidades1);
		} catch (Exception e) {
			fail("Não deveria ter lançado Exception");
		}
		try {
			jogo2 = new Jogo("jogo2", 50.0, jogabilidades2);
		} catch (Exception e) {
			fail("Não deveria ter lançado Exception");
		}
		try {
			jogo3 = new Jogo("jogo3", 100.0, jogabilidades3);
		} catch (Exception e) {
			fail("Não deveria ter lançado Exception");
		}
	}
	
	@Test
	public void testRegistraJogadaScoreNegativo() {
		try {
			jogo1.registraJogada(-200, true);
			fail("Deveria lançar exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Score não pode ser negativo");
		}
		
		try {
			jogo2.registraJogada(-500, true);
			fail("Deveria lançar exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Score não pode ser negativo");
		}
		
		try {
			jogo3.registraJogada(-200, false);
			fail("Deveria lançar exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Score não pode ser negativo");
		}
	}
	
	@Test
	public void testRegistraJogada() {
		
		assertTrue(jogo1.getMaiorScore() == 0);
		assertTrue(jogo2.getMaiorScore() == 0);
		assertTrue(jogo3.getMaiorScore() == 0);
		
		assertTrue(jogo1.getVezesJogado() == 0);
		assertTrue(jogo2.getVezesJogado() == 0);
		assertTrue(jogo3.getVezesJogado() == 0);
		
		assertTrue(jogo1.getVezesConcluido() == 0);
		assertTrue(jogo2.getVezesConcluido() == 0);
		assertTrue(jogo3.getVezesConcluido() == 0);
		
		for(int i = 1; i <= 10; i++) {
			try {			
				jogo1.registraJogada(300 * i, false);
			} catch (Exception e) {
				fail("Não deveria lançar Exception");
			}
			assertTrue(jogo1.getMaiorScore() == 300 * i);
			assertTrue(jogo1.getVezesJogado() == i);
			assertTrue(jogo1.getVezesConcluido() == 0);
		}
		
		for(int i = 1; i <= 10; i++) {
			try {
				jogo2.registraJogada(500 / i, true);
			} catch (Exception e) {
				fail("Não deveria lançar Exception");
			}
			
			assertTrue(jogo2.getMaiorScore() == 500);
			assertTrue(jogo2.getVezesJogado() == i);
			assertTrue(jogo2.getVezesConcluido() == i);							
		}		
	}

	@Test
	public void testEqualsObject() {
		try {
			Jogo jogo11 = new Jogo("jogo1", 50.0, jogabilidades2);
			assertEquals(jogo11, jogo1);
		} catch (Exception e) {
			fail("não deveria lançar exception");
		}
		
		try {
			Jogo jogo12 = new Jogo("jogo2", 20.0, jogabilidades1);
			assertFalse(jogo1.equals(jogo12));
		} catch (Exception e) {
			fail("não deveria lançar exception");
		}
	}

	
	@Test
	public void testToString() {
		String expected1 = "+ jogo1 - Jogo:\n" + "==> Jogou 0 vez(es)\n" + 
	"==> Zerou 0 vez(es)\n" + "==> Maior score: 0\n";
		assertEquals(expected1, jogo1.toString());
	}

}
