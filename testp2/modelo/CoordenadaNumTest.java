package modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import modelo.Coordenada;

/**
 * @author Faag1-48643667
 * @date 25/09/2017
 **/
public class CoordenadaNumTest {
	Coordenada c;
	
	@Before
	public void setUp() throws Exception {
		c = new Coordenada(3, 5);
				
	}

	
	@Test
	public final void testNumCoordenada() {
		Coordenada c3 = new Coordenada(100,25);
		Coordenada c2 = new Coordenada(c);
		assertEquals("c.suma(c7)","(103,30)",c.suma(c3).toString());
		assertEquals("Num. Coords. ", 4, Coordenada.getNumeroCoordenadas());
	}
	

}
