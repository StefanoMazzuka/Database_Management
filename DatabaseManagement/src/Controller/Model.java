package Controller;
/**
 * El objeto Model será la base del programa. El objeto Model tiene como atributos 
 * un objeto Brand y un objeto Efficiency además de un "ID", el nombre del modelo "model", 
 * el consumo "consumption" y el numero de emisiones que produce "emissions"
 * @author Stefano Mazzuka
 *
 */
public class Model {
	private String model;
	private double consumption;
	private int emissions;
	private String icon;

	/*
	 * Constructor
	 */
	/**
	 * Constructura por defecto del objeto Model.
	 */
	public Model() {}

	/*
	 * Getters and Setters
	 */
	/**
	 * 
	 * @return Devuelve el valor de la variable "model".
	 */
	public String getModel() {
		return this.model;
	}
	/**
	 * Cambia el valor de la variable "model".
	 * @param model Valor por el cual cambiar la variable "model";
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 
	 * @return Devuelve el valor de la variable "consumption".
	 */
	public double getConsumption() {
		return this.consumption;
	}
	/**
	 * Cambia el valor de la variable "consumption".
	 * @param consumption Valor por el cual cambiar la variable "consumption";
	 */
	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	/**
	 * 
	 * @return Devuelve el valor de la variable "emissions".
	 */
	public int getEmissions() {
		return this.emissions;
	}
	/**
	 * Cambia el valor de la variable "emissions".
	 * @param emissions Valor por el cual cambiar la variable "emissions";
	 */
	public void setEmissions(int emissions) {
		this.emissions = emissions;
	}
	/**
	 *
	 * @return Devuelve el valor de la variable "icon".
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * Cambia el valor de la variable "icon".
	 * @param icon Valor por el cual cambiar la variable "icon";
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
}