package tuan2_bai3_Vehicle;

public class Vehicle {
	private String owner;
	private double value;
	private int engineCapacity;

	public Vehicle(String owner, double value, int engineCapacity) {
		this.owner = owner;
		this.value = value;
		this.engineCapacity = engineCapacity;
	}


	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public double calculateTax() {
		if (engineCapacity < 100) {
			return value * 0.01; // Thuế là 1% giá trị phương tiện
			// Nếu dung tích động cơ từ 100 cc đến 200 cc
		} else if (engineCapacity <= 200) {
			return value * 0.03; // Thuế là 3% giá trị phương tiện
			// Nếu dung tích động cơ lớn hơn 200 cc
		} else {
			return value * 0.05; // Thuế là 5% giá trị phương tiện
		}
	}

	@Override
	public String toString() {
	    return String.format("%-20s %-15.2f %-15d %-15.2f", 
	        owner, value, engineCapacity, calculateTax());
	}
	public static String getHeader() {
	    return String.format("%-20s %-15s %-20s %-20s", 
	        "Chủ sở hữu", "Trị giá xe", "Dung tích xy lanh", "Thuế trước bạ");
	}

}
