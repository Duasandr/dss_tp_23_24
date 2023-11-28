package uminho.grupo3.logic.costumer;

import uminho.grupo3.logic.costumer.interfaces.ICostumer;
import uminho.grupo3.logic.person.Details;
import uminho.grupo3.logic.service.interfaces.IService;
import uminho.grupo3.logic.vehicle.Vehicle;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Costumer implements ICostumer {

	private final Details details;
	private final Map<String, IVehicle> vehicleMap;

	/**
	 * @param details
	 * @param vehicleSet
	 */
	public Costumer(Details details, Set<IVehicle> vehicleSet) {
		this.details = details;
		this.vehicleMap = vehicleSet.stream().collect(Collectors.toMap(IVehicle::getLicensePlate, v -> v));
	}

	public String getName() {
		return details.name();
	}

	public String getTaxNumber() {
		return details.taxNumber();
	}

	@Override
	public String getAddress() {
		return details.address();
	}

	public String getEmail() {
		return details.email();
	}

	public String getPhoneNumber() {
		return details.phoneNumber();
	}

	public Set<IVehicle> getVehicles() {
		return new HashSet<>(vehicleMap.values());
	}

	@Override
	public String toString() {
		return "Costumer{" +
				"details=" + details +
				", vehicleMap=" + vehicleMap +
				'}';
	}
}