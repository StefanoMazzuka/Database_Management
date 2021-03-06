package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.ExcelExporter;
import Controller.Model;
import Controller.QueryTableModel;
import Model.Connexions;

import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * FullView es el JFrame principal de la aplicaci�n.
 * @author Stefano Mazzuka
 *
 */
public class FullView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField modelTextField;
	private JTextField consumptionTextField;
	private JTextField emissionsTextField;
	private ArrayList<Model> models;

	/*
	 * Constructor
	 */
	/**
	 * Constructora por defecto del objeto FullView.
	 */
	public FullView() {
		Connexions conn = new Connexions();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu archivoMenu = new JMenu("Archivo");
		menuBar.add(archivoMenu);

		JMenuItem exportMenuItem = new JMenuItem("Exportar");
		exportMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				models = conn.getAllDataBase();
				exportModel();
			}
		});
		archivoMenu.add(exportMenuItem);

		JMenu modelosMenu = new JMenu("Modelos");
		menuBar.add(modelosMenu);

		JMenuItem createMenuItem = new JMenuItem("Crear");
		modelosMenu.add(createMenuItem);

		JMenuItem querysMenuItem = new JMenuItem("Consultar");
		querysMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "fullQueryPanel");
			}
		});
		modelosMenu.add(querysMenuItem);

		JMenu ayudaNewMenu = new JMenu("Ayuda");
		menuBar.add(ayudaNewMenu);

		JMenuItem helpMenuItem = new JMenuItem("Ayuda");
		helpMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create("https://stefanomazzuka.github.io/Database_Management_Javadoc/"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		ayudaNewMenu.add(helpMenuItem);

		JMenuItem aboutMenuItem = new JMenuItem("Acerca de");
		aboutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub		
				JLabel[] labels = new JLabel[4];
				labels[0] = new JLabel("Author:");
				labels[0].setFont(new Font("Arial", Font.BOLD, 12));
				labels[1] = new JLabel("Stefano Mazzuka");
				labels[1].setFont(new Font("Arial", Font.ITALIC, 12));
				labels[2] = new JLabel("Contact email:");
				labels[2].setFont(new Font("Arial", Font.BOLD, 12));
				labels[3] = new JLabel("stefano.mazzuka@gmail.com");
				labels[3].setFont(new Font("Arial", Font.ITALIC, 12));
				JOptionPane.showMessageDialog( null, labels, null, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		ayudaNewMenu.add(aboutMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel fullQueryPanel = new JPanel();
		contentPane.add(fullQueryPanel, "fullQueryPanel");
		fullQueryPanel.setLayout(new BorderLayout(0, 0));

		JToolBar toolBarFullQueryPanel = new JToolBar();
		fullQueryPanel.add(toolBarFullQueryPanel, BorderLayout.NORTH);

		JButton searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("find.png")));

		toolBarFullQueryPanel.add(searchButton);

		JButton editButton = new JButton("");
		editButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("edit.png")));
		toolBarFullQueryPanel.add(editButton);

		JButton deleteButton = new JButton("");
		deleteButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("delete.png")));
		toolBarFullQueryPanel.add(deleteButton);

		JButton saveExcelButton = new JButton("");
		saveExcelButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("saveExcel.png")));
		toolBarFullQueryPanel.add(saveExcelButton);

		JPanel queryPanel = new JPanel();
		fullQueryPanel.add(queryPanel, BorderLayout.CENTER);
		queryPanel.setLayout(new BorderLayout(0, 0));

		JPanel dataQueryPanel = new JPanel();
		queryPanel.add(dataQueryPanel, BorderLayout.NORTH);
		GridBagLayout gbl_dataQueryPanel = new GridBagLayout();
		gbl_dataQueryPanel.columnWidths = new int[] {0, 0, 0, 0};
		gbl_dataQueryPanel.rowHeights = new int[] {0, 0, 0, 0};
		gbl_dataQueryPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_dataQueryPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		dataQueryPanel.setLayout(gbl_dataQueryPanel);

		JRadioButton brandRadioButton = new JRadioButton("Marca");
		brandRadioButton.setSelected(true);
		brandRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_brandRadioButton = new GridBagConstraints();
		gbc_brandRadioButton.anchor = GridBagConstraints.WEST;
		gbc_brandRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_brandRadioButton.gridx = 0;
		gbc_brandRadioButton.gridy = 0;
		dataQueryPanel.add(brandRadioButton, gbc_brandRadioButton);

		JComboBox<String> brandsQueryComboBox = new JComboBox<String>();
		GridBagConstraints gbc_brandsQueryComboBox = new GridBagConstraints();
		gbc_brandsQueryComboBox.anchor = GridBagConstraints.WEST;
		gbc_brandsQueryComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_brandsQueryComboBox.gridx = 1;
		gbc_brandsQueryComboBox.gridy = 0;
		dataQueryPanel.add(brandsQueryComboBox, gbc_brandsQueryComboBox);

		JRadioButton maximumConsumptionRadioButton = new JRadioButton("Consumo m�ximo");
		maximumConsumptionRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_maximumConsumptionRadioButton = new GridBagConstraints();
		gbc_maximumConsumptionRadioButton.anchor = GridBagConstraints.WEST;
		gbc_maximumConsumptionRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_maximumConsumptionRadioButton.gridx = 0;
		gbc_maximumConsumptionRadioButton.gridy = 1;
		dataQueryPanel.add(maximumConsumptionRadioButton, gbc_maximumConsumptionRadioButton);

		JSlider maximumConsumptionSlider = new JSlider();
		maximumConsumptionSlider.setPaintTicks(true);
		maximumConsumptionSlider.setMajorTickSpacing(5);
		maximumConsumptionSlider.setMinorTickSpacing(1);
		GridBagConstraints gbc_maximumConsumptionSlider = new GridBagConstraints();
		gbc_maximumConsumptionSlider.anchor = GridBagConstraints.WEST;
		gbc_maximumConsumptionSlider.insets = new Insets(0, 0, 5, 5);
		gbc_maximumConsumptionSlider.gridx = 1;
		gbc_maximumConsumptionSlider.gridy = 1;
		dataQueryPanel.add(maximumConsumptionSlider, gbc_maximumConsumptionSlider);

		JLabel consumptionSliderLabel = new JLabel("");
		GridBagConstraints gbc_consumptionSliderLabel = new GridBagConstraints();
		gbc_consumptionSliderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_consumptionSliderLabel.gridx = 2;
		gbc_consumptionSliderLabel.gridy = 1;
		dataQueryPanel.add(consumptionSliderLabel, gbc_consumptionSliderLabel);

		maximumConsumptionSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				consumptionSliderLabel.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
			}
		});

		JRadioButton maximumEmissionsRadioButton = new JRadioButton("Emisiones m�ximas");
		maximumEmissionsRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_maximumEmissionsRadioButton = new GridBagConstraints();
		gbc_maximumEmissionsRadioButton.anchor = GridBagConstraints.WEST;
		gbc_maximumEmissionsRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_maximumEmissionsRadioButton.gridx = 0;
		gbc_maximumEmissionsRadioButton.gridy = 2;
		dataQueryPanel.add(maximumEmissionsRadioButton, gbc_maximumEmissionsRadioButton);

		JSlider maximumEmissionsSlider = new JSlider();
		maximumEmissionsSlider.setPaintTicks(true);
		maximumEmissionsSlider.setMajorTickSpacing(100);
		maximumEmissionsSlider.setMinorTickSpacing(25);
		GridBagConstraints gbc_maximumEmissionsSlider = new GridBagConstraints();
		gbc_maximumEmissionsSlider.anchor = GridBagConstraints.WEST;
		gbc_maximumEmissionsSlider.insets = new Insets(0, 0, 5, 5);
		gbc_maximumEmissionsSlider.gridx = 1;
		gbc_maximumEmissionsSlider.gridy = 2;
		dataQueryPanel.add(maximumEmissionsSlider, gbc_maximumEmissionsSlider);

		JLabel emissionsSliderLabel = new JLabel("");
		GridBagConstraints gbc_emissionsSliderLabel = new GridBagConstraints();
		gbc_emissionsSliderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emissionsSliderLabel.gridx = 2;
		gbc_emissionsSliderLabel.gridy = 2;

		dataQueryPanel.add(emissionsSliderLabel, gbc_emissionsSliderLabel);
		maximumEmissionsSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				emissionsSliderLabel.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
			}
		});

		JRadioButton energeticClassificationRadioButton = new JRadioButton("Calificaci�n energ�tica");
		energeticClassificationRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_energeticClassificationRadioButton = new GridBagConstraints();
		gbc_energeticClassificationRadioButton.anchor = GridBagConstraints.WEST;
		gbc_energeticClassificationRadioButton.insets = new Insets(0, 0, 0, 5);
		gbc_energeticClassificationRadioButton.gridx = 0;
		gbc_energeticClassificationRadioButton.gridy = 3;
		dataQueryPanel.add(energeticClassificationRadioButton, gbc_energeticClassificationRadioButton);

		brandRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				maximumConsumptionRadioButton.setSelected(false);
				maximumEmissionsRadioButton.setSelected(false);
				energeticClassificationRadioButton.setSelected(false);
			}
		});

		maximumConsumptionRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brandRadioButton.setSelected(false);
				maximumEmissionsRadioButton.setSelected(false);
				energeticClassificationRadioButton.setSelected(false);
			}
		});

		maximumEmissionsRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brandRadioButton.setSelected(false);
				maximumConsumptionRadioButton.setSelected(false);
				energeticClassificationRadioButton.setSelected(false);
			}
		});

		energeticClassificationRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brandRadioButton.setSelected(false);
				maximumConsumptionRadioButton.setSelected(false);
				maximumEmissionsRadioButton.setSelected(false);
			}
		});

		JComboBox<String> energeticClassificationQueryComboBox = new JComboBox<String>();
		GridBagConstraints gbc_energeticClassificationQueryComboBox = new GridBagConstraints();
		gbc_energeticClassificationQueryComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_energeticClassificationQueryComboBox.anchor = GridBagConstraints.WEST;
		gbc_energeticClassificationQueryComboBox.gridx = 1;
		gbc_energeticClassificationQueryComboBox.gridy = 3;
		dataQueryPanel.add(energeticClassificationQueryComboBox, gbc_energeticClassificationQueryComboBox);

		JScrollPane scrollPane = new JScrollPane();
		queryPanel.add(scrollPane, BorderLayout.CENTER);

		String[] head = new String[] {"MODELO", "CONSUMO", "EMISIONES", "C.E"};
		Object[][] body = new Object[][] {};
		JTable queryTable = new JTable();
		QueryTableModel queryTableModel = new QueryTableModel(body, head);
		queryTable.setModel(queryTableModel);
		scrollPane.setViewportView(queryTable);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		queryTable.getColumn("CONSUMO").setCellRenderer(rightRenderer);
		queryTable.getColumn("EMISIONES").setCellRenderer(rightRenderer);

		JPanel createPanel = new JPanel();
		contentPane.add(createPanel, "createPanel");
		createPanel.setLayout(new BorderLayout(0, 0));

		JToolBar toolBarFullCreatePanel = new JToolBar();
		createPanel.add(toolBarFullCreatePanel, BorderLayout.NORTH);

		JButton saveButton = new JButton("");
		saveButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("save.png")));
		toolBarFullCreatePanel.add(saveButton);

		createMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "createPanel");
				saveButton.setName("insert");
				modelTextField.setText("");
				consumptionTextField.setText("");
				emissionsTextField.setText("");
			}
		});

		JPanel dataCreatePanel = new JPanel();
		dataCreatePanel.setBackground(UIManager.getColor("Panel.background"));
		createPanel.add(dataCreatePanel, BorderLayout.CENTER);
		GridBagLayout gbl_dataCreatePanel = new GridBagLayout();
		gbl_dataCreatePanel.columnWidths = new int[] {0, 179};
		gbl_dataCreatePanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
		gbl_dataCreatePanel.columnWeights = new double[]{0.0, 0.0};
		gbl_dataCreatePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		dataCreatePanel.setLayout(gbl_dataCreatePanel);

		JLabel createNewModelLabel = new JLabel("DATOS PARA EL NUEVO MODELO");
		GridBagConstraints gbc_createNewModelLabel = new GridBagConstraints();
		gbc_createNewModelLabel.gridwidth = 2;
		gbc_createNewModelLabel.insets = new Insets(0, 0, 5, 0);
		gbc_createNewModelLabel.gridx = 0;
		gbc_createNewModelLabel.gridy = 0;
		dataCreatePanel.add(createNewModelLabel, gbc_createNewModelLabel);

		JLabel brandLabel = new JLabel("Marca");
		brandLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_brandLabel = new GridBagConstraints();
		gbc_brandLabel.anchor = GridBagConstraints.EAST;
		gbc_brandLabel.insets = new Insets(0, 0, 5, 5);
		gbc_brandLabel.gridx = 0;
		gbc_brandLabel.gridy = 1;
		dataCreatePanel.add(brandLabel, gbc_brandLabel);

		JComboBox<String> brandsCreateComboBox = new JComboBox<String>();
		GridBagConstraints gbc_brandsCreateComboBox = new GridBagConstraints();
		gbc_brandsCreateComboBox.anchor = GridBagConstraints.WEST;
		gbc_brandsCreateComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_brandsCreateComboBox.gridx = 1;
		gbc_brandsCreateComboBox.gridy = 1;
		dataCreatePanel.add(brandsCreateComboBox, gbc_brandsCreateComboBox);

		JLabel modelLabel = new JLabel("Modelo");
		modelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_modelLabel = new GridBagConstraints();
		gbc_modelLabel.anchor = GridBagConstraints.EAST;
		gbc_modelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_modelLabel.gridx = 0;
		gbc_modelLabel.gridy = 2;
		dataCreatePanel.add(modelLabel, gbc_modelLabel);

		modelTextField = new JTextField();
		modelTextField.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_modelTextField = new GridBagConstraints();
		gbc_modelTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_modelTextField.anchor = GridBagConstraints.WEST;
		gbc_modelTextField.insets = new Insets(0, 0, 5, 0);
		gbc_modelTextField.gridx = 1;
		gbc_modelTextField.gridy = 2;
		dataCreatePanel.add(modelTextField, gbc_modelTextField);
		modelTextField.setColumns(10);

		JLabel consumptionLabel = new JLabel("Consumo");
		consumptionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_consumptionLabel = new GridBagConstraints();
		gbc_consumptionLabel.anchor = GridBagConstraints.EAST;
		gbc_consumptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_consumptionLabel.gridx = 0;
		gbc_consumptionLabel.gridy = 3;
		dataCreatePanel.add(consumptionLabel, gbc_consumptionLabel);

		consumptionTextField = new JTextField();
		consumptionTextField.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_consumptionTextField = new GridBagConstraints();
		gbc_consumptionTextField.anchor = GridBagConstraints.WEST;
		gbc_consumptionTextField.insets = new Insets(0, 0, 5, 0);
		gbc_consumptionTextField.gridx = 1;
		gbc_consumptionTextField.gridy = 3;
		dataCreatePanel.add(consumptionTextField, gbc_consumptionTextField);
		consumptionTextField.setColumns(10);

		JLabel emissionsLabel = new JLabel("Emisiones");
		emissionsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_emissionsLabel = new GridBagConstraints();
		gbc_emissionsLabel.anchor = GridBagConstraints.EAST;
		gbc_emissionsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emissionsLabel.gridx = 0;
		gbc_emissionsLabel.gridy = 4;
		dataCreatePanel.add(emissionsLabel, gbc_emissionsLabel);

		emissionsTextField = new JTextField();
		emissionsTextField.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_emissionsTextField = new GridBagConstraints();
		gbc_emissionsTextField.anchor = GridBagConstraints.WEST;
		gbc_emissionsTextField.insets = new Insets(0, 0, 5, 0);
		gbc_emissionsTextField.gridx = 1;
		gbc_emissionsTextField.gridy = 4;
		dataCreatePanel.add(emissionsTextField, gbc_emissionsTextField);
		emissionsTextField.setColumns(10);

		JLabel energeticClassificationLabel = new JLabel("Clasifiaci�n energ�tica");
		energeticClassificationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_energeticClassificationLabel = new GridBagConstraints();
		gbc_energeticClassificationLabel.anchor = GridBagConstraints.EAST;
		gbc_energeticClassificationLabel.insets = new Insets(0, 0, 0, 5);
		gbc_energeticClassificationLabel.gridx = 0;
		gbc_energeticClassificationLabel.gridy = 5;
		dataCreatePanel.add(energeticClassificationLabel, gbc_energeticClassificationLabel);

		JComboBox<String> energeticClassificationCreateComboBox = new JComboBox<String>();
		energeticClassificationCreateComboBox.setMaximumRowCount(5);
		GridBagConstraints gbc_energeticClassificationCreateComboBox = new GridBagConstraints();
		gbc_energeticClassificationCreateComboBox.anchor = GridBagConstraints.WEST;
		gbc_energeticClassificationCreateComboBox.gridx = 1;
		gbc_energeticClassificationCreateComboBox.gridy = 5;
		dataCreatePanel.add(energeticClassificationCreateComboBox, gbc_energeticClassificationCreateComboBox);

		models = new ArrayList<Model>();

		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub		
				if (brandRadioButton.isSelected()) {	
					int brandID = conn.selectBrandID((String) brandsQueryComboBox.getSelectedItem());
					models = conn.brandFilter(brandID);
				}

				else if (maximumConsumptionRadioButton.isSelected())
					models = conn.consumptionFilter(maximumConsumptionSlider.getValue());

				else if (maximumEmissionsRadioButton.isSelected())
					models = conn.emissionsFilter(maximumEmissionsSlider.getValue());

				else if (energeticClassificationRadioButton.isSelected()) {
					String classification = conn.selectEnergeticClassification((String) 
							energeticClassificationQueryComboBox.getSelectedItem());
					models = conn.energeticFilter(classification);
				}

				updateTable(queryTableModel);
			}
		});
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if(!queryTable.getSelectionModel().isSelectionEmpty()) {
					Model model = models.get(queryTable.getSelectedRow());

					int option = JOptionPane.showConfirmDialog(null, "�Desea eliminar el modelo?", 
							"ATENCI�N", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						conn.deleteModel(model.getID());
						models.remove(model);
						updateTable(queryTableModel);
						updateSliders(conn, maximumConsumptionSlider, maximumEmissionsSlider);
					}
				}

				else
					JOptionPane.showMessageDialog(null, "Seleccione un modelo.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!modelTextField.getText().equals("") && !consumptionTextField.getText().equals("") 
						&& !emissionsTextField.getText().equals("")) {

					try {
						Model model = new Model();
						model.setModel(modelTextField.getText());
						model.setConsumption(Double.valueOf(consumptionTextField.getText()));
						model.setEmissions(Double.valueOf(emissionsTextField.getText()));
						int brandID = conn.selectBrandID((String) brandsCreateComboBox.getSelectedItem());
						String classification = conn.selectEnergeticClassification((String) 
								energeticClassificationCreateComboBox.getSelectedItem());

						if (saveButton.getName() == "insert")
							conn.insertModel(model, brandID, classification);

						else {
							model.setID(Integer.valueOf(saveButton.getName()));
							conn.updateModel(model, brandID, classification);
						}

						updateComboBoxes(conn, brandsQueryComboBox, energeticClassificationQueryComboBox, 
								brandsCreateComboBox, energeticClassificationCreateComboBox);
						updateSliders(conn, maximumConsumptionSlider, maximumEmissionsSlider);
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Datos inv�lidos.", "ERROR", JOptionPane.ERROR_MESSAGE);
						consumptionTextField.setText("");
						emissionsTextField.setText("");
					}
				}
				
				else
					JOptionPane.showMessageDialog(null, "Datos del modelo vac�os.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});
		editButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				if(!queryTable.getSelectionModel().isSelectionEmpty()) {
					Model model = models.get(queryTable.getSelectedRow());
					saveButton.setName(String.valueOf(model.getID()));
					String brand = (String) brandsQueryComboBox.getSelectedItem();
					String classification = (String) energeticClassificationQueryComboBox.getSelectedItem();

					brandsCreateComboBox.setSelectedItem(brand);
					energeticClassificationCreateComboBox.setSelectedItem(classification);
					modelTextField.setText(model.getModel());
					consumptionTextField.setText(String.valueOf(model.getConsumption()));
					emissionsTextField.setText(String.valueOf(model.getEmissions()));

					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "createPanel");
				}

				else
					JOptionPane.showMessageDialog(null, "Seleccione un modelo.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});
		saveExcelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exportModel();
			}
		});

		updateComboBoxes(conn, brandsQueryComboBox, energeticClassificationQueryComboBox, 
				brandsCreateComboBox, energeticClassificationCreateComboBox);
		updateSliders(conn, maximumConsumptionSlider, maximumEmissionsSlider);
	}

	/**
	 * Actualizamos todos los JComboBox de la vista.
	 * @param conn Objeto de tipo Connexion para hacer las consultas a la base de datos.
	 * @param brandsQueryComboBox JComboBox del panel queryPanel.
	 * @param energeticClassificationQueryComboBox JComboBox del panel queryPanel.
	 * @param brandsCreateComboBox JComboBox del panel createPanel.
	 * @param energeticClassificationCreateComboBox JComboBox del panel createPanel.
	 */
	private void updateComboBoxes(Connexions conn, JComboBox<String> brandsQueryComboBox, JComboBox<String> energeticClassificationQueryComboBox,
			JComboBox<String> brandsCreateComboBox, JComboBox<String> energeticClassificationCreateComboBox) {	
		ArrayList<String> data;
		data = conn.selectBrandsNames();
		brandsQueryComboBox.setModel(new DefaultComboBoxModel<>(new Vector<String>(data)));
		brandsCreateComboBox.setModel(new DefaultComboBoxModel<>(new Vector<String>(data)));

		data = conn.selectEnergeticClassificationDescriptions();
		energeticClassificationQueryComboBox.setModel(new DefaultComboBoxModel<>(new Vector<String>(data)));
		energeticClassificationCreateComboBox.setModel(new DefaultComboBoxModel<>(new Vector<String>(data)));
	}
	/**
	 * Actualizamos todos los JSlider de la vista.
	 * @param conn Objeto de tipo Connexion para hacer las consultas a la base de datos.
	 * @param maximumConsumptionSlider JSlider del panel queryPanel.
	 * @param maximumEmissionsSlider JSlider del panel queryPanel.
	 */
	private void updateSliders(Connexions conn, JSlider maximumConsumptionSlider, JSlider maximumEmissionsSlider) {
		int data;
		data = conn.selectMaxConsumption();
		maximumConsumptionSlider.setMaximum(data + 1);
		maximumConsumptionSlider.setValue((data + 1) / 2);

		data = conn.selectMaxEmissions();
		maximumEmissionsSlider.setMaximum(data + 1);
		maximumEmissionsSlider.setValue((data + 1) / 2);
	}
	/**
	 * Actualizamos la talba con una lista de modelos dada.
	 * @param models Lista de modelos que queremos mostrar en la tabla.
	 */
	private void updateTable(QueryTableModel queryTableModel) {
		Object[][] body = new Object[models.size()][4];

		int rowCount = queryTableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			queryTableModel.removeRow(i);
		}

		for (int i = 0; i < models.size(); i++) {
			body[i][0] = models.get(i).getModel();
			body[i][1] = models.get(i).getConsumption();
			body[i][2] = models.get(i).getEmissions();
			body[i][3] = new ImageIcon(getClass().getClassLoader().getResource(models.get(i).getIcon()));;
			queryTableModel.addRow(body[i]);
		}
	}
	/**
	 * Generamos un excel con los modelos.
	 * @throws IOException
	 */
	private void exportModel() {
		JFileChooser fc = new JFileChooser();
		int result = fc.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ExcelExporter excelExporter = new ExcelExporter();	
			try {
				excelExporter.export(models, new File(file.getPath() + ".xls"));
				JOptionPane.showMessageDialog(null, "Fichero generado con �xito.", 
						"INFORMACI�N", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}