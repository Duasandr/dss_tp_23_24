package uminho.grupo3.logic.vehicle;

import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

public abstract class Vehicle implements IVehicle {

	private final String licensePlate;

	/**
	 * Construtor parametrizado.
	 * @param licensePlate matrícula do veículo
	 */
	public Vehicle(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	/**
	 * Devolve a matrícula do veículo.
	 * @return String
	 */
	public String getLicensePlate() {
		return this.licensePlate;
	}

	@Override
	public String toString() {
		return "Vehicle{" +
				"licensePlate='" + licensePlate + '\'' +
				", type='" + getClass() + '\'' +
				'}';
	}

	/**
	 * Testa se o objeto é do tipo Null, ou seja, uma instância válida, mas sem conteúdo útil.
	 * @return boolean
	 */
	public boolean isNull() {
		return false;
	}

}