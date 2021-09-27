package Utilitarios;

import java.util.function.Predicate;

import Integrantes.Hunter;

public class HuntersPredicate implements Predicate<Hunter>{

	@Override
	public boolean test(Hunter testados) {
		// TODO Auto-generated method stub
		return testados.getHP() >=40.0;
	}

}
