package uminho.grupo3.logic.vehicle;

public class Null extends Vehicle {

	/**
	 * Construtor vazio.
	 */
	public Null() {
		super("");
	}

	/**
	 * Testa se o objeto é `null`.
	 * @return true se o objeto for uma intância válida, mas sem conteúdo útil.
	 */
	public boolean isNull() {
		return true;
	}

}