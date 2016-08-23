/* 116110062 - Laerson Saraiva Verissimo: LAB 6 - Turma 2 */
package p2cg;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class PlataformaTest {
	
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
		
			jogo1 = new Luta("jogo1", 20.0, jogabilidades1);
			jogo2 = new Luta("jogo2", 50.0, jogabilidades2);
			jogo3 = new Luta("jogo3", 100.0, jogabilidades3);		
	}

	@Test
	public void testRegistraJogada() {
		try {
			assertTrue(jogo1.registraJogada(2500, true) == 20);
		} catch (Exception e) {
			fail("deveria lançar exception");
		}
		
		try {
			assertTrue(jogo1.registraJogada(2500, false) == 0);
		} catch (Exception e) {
			fail("deveria lançar exception");
		}
	}

}
