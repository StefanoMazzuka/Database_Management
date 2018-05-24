package Model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Controller.Model;

/**
 * El objeto Connecxions se encarga de crear la conexión con la base de 
 * datos, cerrarla y hacer las consultas necesarias.
 * @author Stefano Mazzuka
 *
 */
public class Connexions {
	
	private final String url = 
			System.getProperty("user.dir") +
			File.separator + "bbdd_gestmotor.sqlite";
	private Connection connec;
	private PreparedStatement st;
	private ResultSet list;

	/*
	 * Constructor
	 */
	/**
	 * Constructura por defecto del objeto Connexions.
	 */
	public Connexions() {}
	
	/*
	 * Methods
	 */
	/**
	 * Crea la conexión con la base de datos.
	 * @return Devuelve un booleano que indica si se conectó o no.
	 */
	public boolean connect() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		try {
			connec = DriverManager.getConnection("jdbc:sqlite:" + url);
			if (connec != null) {
				return true;
			}
		} catch (Exception  e) {
			JOptionPane.showMessageDialog(null, null, "ERROR 001: Connection Fails.", JOptionPane.ERROR_MESSAGE);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
		return false;
	}
	/**
	 * Cierra la conexión con la base de datos.
	 */
	public void close() {
		try {
			connec.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	/**
	 * Consultamos todos los nombres de las marcas.
	 * @return Devuelve un ArrayList de tipo String con todos los nombres de las marcas.
	 */
	public ArrayList<String> selectBrandsNames() {
		connect();
		ArrayList<String> data = new ArrayList<String>();
		try {
			st = connec.prepareStatement("SELECT MARCA FROM marcas");
			list = st.executeQuery();
			while (list.next()) {
				data.add(list.getString("MARCA")); 
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Consultamos todas las descripciones de las clasificaciones energéticas.
	 * @return Devuelve un ArrayList de tipo String con todas las descripciones 
	 * de las clasificaciones energéticas.
	 */
	public ArrayList<String> selectEnergeticClassificationDescriptions() {
		connect();
		ArrayList<String> data = new ArrayList<String>();
		try {
			st = connec.prepareStatement("SELECT DESCRIPCION FROM eficiencias");
			list = st.executeQuery();
			while (list.next()) {
				data.add(list.getString("DESCRIPCION")); 
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Consultamos la clasificación energética de una descripcón dada.
	 * @param desciption Valor de la descipción concreta.
	 * @return Devuelve el nombre de la clasificación energética con descripción "desciption".
	 */
	public String selectEnergeticClassification(String desciption) {
		connect();
		String data = "";
		try {
			st = connec.prepareStatement("SELECT C_ENERGETICA FROM eficiencias " + 
		"WHERE DESCRIPCION = '" + desciption + "'");
			list = st.executeQuery();
			data = list.getString("C_ENERGETICA");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Consultamos el nombre del icono de una clasifiación energética.
	 * @param classification Valor de la clasificación energética.
	 * @return Devuelve el nombre del icono de la clasificación energética "classification".
	 */
	public String selectEnergeticIcon(String classification) {
		String data = "";
		try {
			PreparedStatement st = connec.prepareStatement("SELECT ICONO FROM eficiencias " + 
		"WHERE C_ENERGETICA = '" + classification + "'");
			ResultSet list = st.executeQuery();
			data = list.getString("ICONO");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		return data;
	}
	/**
	 * Consultamos el máximo consumo de los modelos.
	 * @return Devuelve un entero que representa el valor del consumo máximo de todos los modelos.
	 */
	public int selectMaxConsumption() {
		connect();
		int data = 0;
		try {
			st = connec.prepareStatement("SELECT MAX(CONSUMO) AS maxComsumo FROM modelos");
			list = st.executeQuery();
			data = list.getInt("maxComsumo");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Consultamos el máximo valor de emisiones de los modelos.
	 * @return Devuelve un entero que representa el valor máximo de las emisiones de todos los modelos.
	 */
	public int selectMaxEmissions() {
		connect();
		int data = 0;
		try {
			st = connec.prepareStatement("SELECT MAX(EMISIONES) AS maxEmisiones FROM modelos");
			list = st.executeQuery();
			data = list.getInt("maxEmisiones");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Consultamos el ID de una marca en concreto.
	 * @param brand Nombre de la marca.
	 * @return Devuelve el ID de la marca.
	 */
	public int selectBrandID(String brand) {
		connect();
		int data = -1;
		try {
			st = connec.prepareStatement("SELECT ID FROM marcas WHERE MARCA = '" + brand + "'");
			list = st.executeQuery();
			data = list.getInt("ID");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Consultamos todos los modelos por medio de un ID de marca.
	 * @param ID ID de la marca.
	 * @return Devuelve un ArrayList de tipo Model con todos los modelos 
	 * que sean de la marca con id igual a ID.
	 */
	public ArrayList<Model> brandFilter(int ID) {
		connect();
		ArrayList<Model> data = new ArrayList<Model>();
		try {
			st = connec.prepareStatement("SELECT MODELO, CONSUMO, EMISIONES, " + 
		"C_ENERGETICA FROM modelos WHERE ID_MARCA = " + ID);
			list = st.executeQuery();
			Model model;
			while (list.next()) {
				model = new Model();
				model.setModel(list.getString("MODELO"));
				model.setConsumption(list.getDouble("CONSUMO"));
				model.setEmissions(list.getInt("EMISIONES"));
				model.setIcon(selectEnergeticIcon(list.getString("C_ENERGETICA")));
				data.add(model);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Consultamos todos los modelos cuyo consumo sea igual o menor a un valor dado.
	 * @param value Valor máximo de consumo.
	 * @return Devuelve un ArrayList de tipo Model con todos los modelos que tengan 
	 * un consumo igual o menor a "value".
	 */
	public ArrayList<Model> consumptionFilter(int value) {
		connect();
		ArrayList<Model> data = new ArrayList<Model>();
		try {
			st = connec.prepareStatement("SELECT MODELO, CONSUMO, EMISIONES, " + 
		"C_ENERGETICA FROM modelos WHERE CONSUMO <= " + value);
			list = st.executeQuery();
			Model model;
			while (list.next()) {
				model = new Model();
				model.setModel(list.getString("MODELO"));
				model.setConsumption(list.getDouble("CONSUMO"));
				model.setEmissions(list.getInt("EMISIONES"));
				model.setIcon(selectEnergeticIcon(list.getString("C_ENERGETICA")));
				data.add(model);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Consultamos todos los modelos cuyas emisiones sean igual o menor a un valor dado.
	 * @param value Valor máximo de las emisiones.
	 * @return Devuelve un ArrayList de tipo Model con todos los modelos que tengan 
	 * unas emisiones igual o menor a "value".
	 */
	public ArrayList<Model> emissionsFilter(int value) {
		connect();
		ArrayList<Model> data = new ArrayList<Model>();
		try {
			st = connec.prepareStatement("SELECT MODELO, CONSUMO, EMISIONES, " + 
		"C_ENERGETICA FROM modelos WHERE EMISIONES <= " + value);
			list = st.executeQuery();
			Model model;
			while (list.next()) {
				model = new Model();
				model.setModel(list.getString("MODELO"));
				model.setConsumption(list.getDouble("CONSUMO"));
				model.setEmissions(list.getInt("EMISIONES"));
				model.setIcon(selectEnergeticIcon(list.getString("C_ENERGETICA")));
				data.add(model);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Consultamos todos los modelos cuya clasificación energética sea igual a un valor dado.
	 * @param classification Valor de la clasificación energética.
	 * @return Devuelve un ArrayList de tipo Model con todos los modelos que tengan 
	 * como clasificación energética el valor "classification".
	 */
	public ArrayList<Model> energeticFilter(String classification) {
		connect();
		ArrayList<Model> data = new ArrayList<Model>();
		try {
			st = connec.prepareStatement("SELECT MODELO, CONSUMO, EMISIONES, "
					+ "C_ENERGETICA FROM modelos WHERE C_ENERGETICA = '" + classification + "'");
			list = st.executeQuery();
			Model model;
			while (list.next()) {
				model = new Model();
				model.setModel(list.getString("MODELO"));
				model.setConsumption(list.getDouble("CONSUMO"));
				model.setEmissions(list.getInt("EMISIONES"));
				model.setIcon(selectEnergeticIcon(list.getString("C_ENERGETICA")));
				data.add(model);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
	/**
	 * Borramos un modelo de la tabla.
	 * @param model Nombre del modelo a borrar.
	 */
	public void deleteModel(String model) {
		connect();
		try {
			st = connec.prepareStatement("DELETE FROM modelos WHERE MODELO = '" + model + "'");
			st.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
	}
	
	public void insertModel(Model model, int brandID, String classification) {
		try {
			st = connec.prepareStatement("INSERT INTO modelos (ID_MARCA, MODELO, CONSUMO, " + 
		"EMISIONES, C_ENERGETICA) VALUES('" 
					+ brandID + "' , '"
					+ model.getModel() + "', '" 
					+ model.getConsumption() + "', '" 
					+ model.getEmissions() + "', '" 
					+ classification + "')");
			st.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(Connexions.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}