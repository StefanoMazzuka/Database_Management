package Controller;

public class Model {
	private int ID;
	private	Brand brand;
	private String model;
	private double consumption;
	private int emissions;
	private Efficiency efficiency;

	public Model(int iD, Brand brand, String model, double consumption, int emissions, Efficiency efficiency) {
		super();
		ID = iD;
		this.brand = brand;
		this.model = model;
		this.consumption = consumption;
		this.emissions = emissions;
		this.efficiency = efficiency;
	}

	/*
	 * Getters and Setters
	 */
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getConsumption() {
		return consumption;
	}
	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	public int getEmissions() {
		return emissions;
	}
	public void setEmissions(int emissions) {
		this.emissions = emissions;
	}
	public Efficiency getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(Efficiency efficiency) {
		this.efficiency = efficiency;
	}
}