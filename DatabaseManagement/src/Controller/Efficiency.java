package Controller;
/**
 * El objeto Efficiency cuenta con una clasificación, una descipción y 
 * un nombre de icono para la eficiencia del coche.
 * @author Stefano Mazzuka
 *
 */
public class Efficiency {
	private String energeticClassification;
	private String description;
	private String icon;
	
	/*
	 * Constructor
	 */
	/**
	 * Constructura por defecto del objeto Efficiency.
	 */
	public Efficiency() {}
	
	/*
	 * Getters and Setters
	 */
	/**
	 * 
	 * @return Devuelve el valor de la variable "energeticClassification".
	 */
	public String getEnergeticClassification() {
		return energeticClassification;
	}
	/**
	 * Cambia el valor de la variable "energeticClassification".
	 * @param energeticClassification Valor por el cual cambiar la variable "energeticClassification";
	 */
	public void setEnergeticClassification(String energeticClassification) {
		this.energeticClassification = energeticClassification;
	}
	/**
	 * 
	 * @return Devuelve el valor de la variable "description".
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Cambia el valor de la variable "description".
	 * @param description Valor por el cual cambiar la variable "description";
	 */
	public void setDescription(String description) {
		this.description = description;
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