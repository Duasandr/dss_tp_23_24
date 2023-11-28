package uminho.grupo3.logic.vehicle.interfaces;

public interface IVehicle {

	/**
	 * Devolve a matrícula do veículo.
	 * @return String
	 */
	String getLicensePlate();

	/**
	 * Testa se o objeto é `null`.
	 * @return true se o objeto for uma intância válida, mas sem conteúdo útil.
	 */
	boolean isNull();

}