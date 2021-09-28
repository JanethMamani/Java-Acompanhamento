package Utilitarios;

import java.util.function.Consumer;

import Integrantes.Hunter;

public class HPUpdate implements Consumer<Hunter>{

	@Override
	public void accept(Hunter hunter) {
		hunter.setHP(hunter.getHP() * 1.1);
	}
	
}
