package Utilitarios;

import java.util.function.Function;

import Integrantes.Hunter;

public class UpperCaseFunction implements Function<Hunter, String> {

	@Override
	public String apply(Hunter hunter) {
		return hunter.getNome().toUpperCase();
	}
}
