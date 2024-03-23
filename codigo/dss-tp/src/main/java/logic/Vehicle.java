package logic;

import logic.vehicle.HistoryEntry;

import java.util.Objects;
import java.util.Set;

public abstract class Vehicle {

	private String licensePlate;
	data.dao.VehicleHistory vehicleHistoryDAO;

	public Vehicle() {
		this.vehicleHistoryDAO = data.dao.VehicleHistory.getInstance();
	}

	public String getLicensePlate() {
		return this.licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void addToServiceHistory(Service service, String status) throws Exception {
		vehicleHistoryDAO.addToHistory(this, service, status);
	}

	public Set<HistoryEntry> getServiceHistory() throws Exception {
		return vehicleHistoryDAO.getHistory(this);
	}

	@Override
	public String toString() {
		return "Vehicle{" +
				"licensePlate='" + licensePlate + '\'' +
				", type='" + getClass().getSimpleName() + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vehicle vehicle = (Vehicle) o;
		return Objects.equals(licensePlate, vehicle.licensePlate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(licensePlate);
	}
}