package Controller;
/**
 * El objeto Brand será nuestra marca, cuenta con un ID y un nombre de marca "brand".
 * @author Stefano Mazzuka
 *
 */
public class Brand {
	private int ID;
	private String brand;
	
	/*
	 * Constructor
	 */
	/**
	 * Constructura por defecto del objeto Brand.
	 */
	public Brand() {}

	/*
	 * Getters and Setters
	 */
	/**
	 * 
	 * @return Devuelve el valor de la variable "ID".
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Cambia el valor de la variable "ID".
	 * @param ID Valor por el cual cambiar la variable "ID".
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	/**
	 * 
	 * @return Devuelve la variable "brand".
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * Cambia el valor de la variable "brand".
	 * @param brand Valor por el cual cambiar la variable "brand".
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
}