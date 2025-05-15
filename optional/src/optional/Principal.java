package optional;

import java.util.Optional;

public class Principal {

	public static void main(String[] args) {
//		String name = null;
//		Optional<String> opt = Optional.ofNullable(name);		
		
		Optional<String> opt = Optional.ofNullable("Patrobas");
	    opt.ifPresent((Object name) -> System.out.println(((String)name).length()));
		
		System.out.println("Fin Programa");
	}

}
