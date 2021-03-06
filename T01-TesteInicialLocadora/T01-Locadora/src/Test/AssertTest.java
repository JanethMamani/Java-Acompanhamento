package Test;

import org.junit.Assert;
import org.junit.Test;

import Entidades.Usuario;

public class AssertTest {
	
	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals("Erro de comparação", 1, 1);
		Assert.assertEquals(0.51234, 0.512, 0.001);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		int i = 5;
		Integer n = 5;
		Assert.assertEquals(Integer.valueOf(i), n);
		Assert.assertEquals(i, n.intValue());
		
		Assert.assertNotEquals("Bola", "bola");//Tudo pode ter a forma Not
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2);
		
		Assert.assertSame(u1, u1);
		Assert.assertNotSame(u1, u2);
		
		Assert.assertNull(u3);
		
	}

}
