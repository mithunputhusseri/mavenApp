package mavenApp;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		App a = new App();
		assertEquals("DUMMY", a.returnSomething());
	}
	@Test
	public void test1() {
		App a = new App();
		assertEquals(1.0,a.add(1.0,0.0),0.01);
	}
	@Test
	public void test2() {
		App a = new App();
		assertEquals(1.0,a.sub(1.0,0.0),0.01);
	}

}
