package logic;

import data.dao.Vehicle;

import java.util.Objects;
import java.util.Set;

public class Customer {

	private String taxNumber;
	private String name;
	private String address;
	private String email;
	private String phoneNumber;

	private final Vehicle vehicleDAO;

	public Customer() {
		this.vehicleDAO = Vehicle.getInstance();
	}

	public Customer(String taxNumber, String name, String address, String email, String phoneNumber) {
		this();
		this.taxNumber = taxNumber;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		Customer customer = (Customer) object;
		return Objects.equals(taxNumber, customer.taxNumber) &&
				Objects.equals(name, customer.name) &&
				Objects.equals(address, customer.address) &&
				Objects.equals(email, customer.email) &&
				Objects.equals(phoneNumber, customer.phoneNumber) &&
				Objects.equals(vehicleDAO, customer.vehicleDAO);
	}

	@Override
	public int hashCode() {
		return Objects.hash(taxNumber, name, address, email, phoneNumber, vehicleDAO);
	}

	@Override
	public String toString() {
		return "Customer{" +
				"taxNumber='" + taxNumber + '\'' +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", vehicleDAO=" + vehicleDAO +
				'}';
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public logic.Vehicle getVehicle(String licensePlate) throws Exception {
		return vehicleDAO.getVehicle(licensePlate);
	}

	public Set<logic.Vehicle> getVehicles() throws Exception {
		return vehicleDAO.getVehicles(this);
	}
}