package Model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * Connecxions se encarga de crear la conexión con la base de 
 * datos, cerrarla y hacer las consultas necesarias.
 * @author Stefano Mazzuka
 *
 */
public class Connexions {
	
	private final String url = 
			System.getProperty("user.dir") +
			File.separator + "MyCookbookDB.sqlite";
	private Connection connec;
	private PreparedStatement st;
	private ResultSet list;
	
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
			JOptionPane.showMessageDialog(null, "ERROR 001: Connection Fails.");
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
	 * Elimina un modelo de la base de datos.
	 * @param idIngredient
	 */
	public void deleteIngredient(int idIngredient) {
		try {
			st = connec.prepareStatement("DETELE FROM ingredient WHERE idIngredient = " + idIngredient);
			st.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
