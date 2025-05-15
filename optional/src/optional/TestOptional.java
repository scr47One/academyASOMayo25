package optional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class TestOptional {

	@Test
	void test() {
		String s1 = "Hola";
		String s2 = "Holax";
		assertNotEquals(s1,s2);
	}
	
	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
	    Optional<String> empty = Optional.empty();
	    assertFalse(empty.isPresent());
	}
	
	@Test
	public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
	    String name = "baeldung";
	    Optional<String> opt = Optional.of(name);
	    assertTrue(opt.isPresent());
	}
	
	/* jUnit4
	@Test(expected = NullPointerException.class)
	public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
	    String name = null;
	    Optional.of(name);
	}*/
	
	@Test
    void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        assertThrows(NullPointerException.class, () -> {
            Optional.of(name);
        });
    }
	
	@Test
	public void givenNonNull_whenCreatesNullable_thenCorrect() {
	    String name = "baeldung";
	    Optional<String> opt = Optional.ofNullable(name);
	    assertTrue(opt.isPresent());
	}
	
	@Test
	public void givenNull_whenCreatesNullable_thenCorrect() {
	    String name = null;
	    Optional<String> opt = Optional.ofNullable(name);
	    assertFalse(opt.isPresent());
	}
	
	@Test
	public void givenOptional_whenIsPresentWorks_thenCorrect() {
	    Optional<String> opt = Optional.of("Baeldung");
	    assertTrue(opt.isPresent());

	    opt = Optional.ofNullable(null);
	    assertFalse(opt.isPresent());
	}
	
	@Test
	public void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
	    Optional<String> opt = Optional.of("Baeldung");
	    assertFalse(opt.isEmpty());

	    opt = Optional.ofNullable(null);
	    assertTrue(opt.isEmpty());
	}
	
	@Test
	public void givenOptional_whenIfPresentWorks_thenCorrect() {
	    Optional<String> opt = Optional.of("baeldung");
	    opt.ifPresent(name -> System.out.println(name.length()));
	}

}
