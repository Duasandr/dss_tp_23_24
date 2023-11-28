package uminho.grupo3.logic.costumer.interfaces;

import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

import java.util.Set;

public interface ICostumer {

	String getName();

	String getTaxNumber();

	String getAddress();

	String getEmail();

	String getPhoneNumber();

	Set<IVehicle> getVehicles();

}