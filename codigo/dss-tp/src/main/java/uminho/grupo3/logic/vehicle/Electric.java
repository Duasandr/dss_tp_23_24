package uminho.grupo3.logic.vehicle;


import uminho.grupo3.logic.vehicle.interfaces.IElectric;

public class Electric extends Vehicle implements IElectric {

	/**
	 * Construtor parametrizado.
	 * @param licensePlate matrícula do veículo
	 */
	public Electric(String licensePlate) {
		super(licensePlate);
	}

}