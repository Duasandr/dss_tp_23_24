package logic;

import logic.service.*;

import java.util.Objects;

public abstract class Service{
	private final String name;
	private final String description;
	private final float price;
	private final float duration;

	public Service(String name, String description, float price, float duration) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.duration = duration;

	}

    public static Service create(
			String name,
			String description,
			float price,
			float duration,
			String type) {
        return switch (type) {
            case "Petrol" -> new Petrol(name, description, price, duration);
            case "Diesel" -> new Diesel(name, description, price, duration);
            case "Combustion" -> new Combustion(name, description, price, duration);
            case "Electric" -> new Electric(name, description, price, duration);
			case "Universal" -> new Universal(name, description, price, duration);
			default -> throw new IllegalArgumentException("Unexpected value: " + type);
		};
	}


	public abstract boolean canApplyTo(Vehicle vehicle);

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}

	public float getDuration() {
		return duration;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		Service service = (Service) object;
		return Float.compare(price, service.price) == 0 &&
				Float.compare(duration, service.duration) == 0 &&
				Objects.equals(name, service.name) &&
				Objects.equals(description, service.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, price, duration);
	}

	@Override
	public String toString() {
		return "Service{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", duration=" + duration +
				'}';
	}

}