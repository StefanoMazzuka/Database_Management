package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FullView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem exportMenuItem;
	private JTable queryTable;
	private JTextField modelTextField;
	private JTextField consumptionTextField;
	private JTextField emissionsTextField;

	/**
	 * Create the frame.
	 */
	public FullView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu archivoMenu = new JMenu("Archivo");
		menuBar.add(archivoMenu);
		
		exportMenuItem = new JMenuItem("Exportar");
		archivoMenu.add(exportMenuItem);
		
		JMenu modelosMenu = new JMenu("Modelos");
		menuBar.add(modelosMenu);
		
		JMenuItem createMenuItem = new JMenuItem("Crear");
		createMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "createPanel");
			}
		});
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
							java.net.URI.create("https://github.com/StefanoMazzuka"));
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
				JOptionPane.showMessageDialog(null, "Author:" + '\n' + 
						"Stefano Mazzuka" + '\n' + 
						"Contact email:" + '\n' + 
						"stefano.mazzuka@gamil.com");
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
		searchButton.setIcon(new ImageIcon(
				System.getProperty("user.dir") + File.separator + 
				"src" + File.separator + 
				"Resources" + File.separator + 
				"find.png"));
		toolBarFullQueryPanel.add(searchButton);
		
		JButton editButton = new JButton("");
		editButton.setIcon(new ImageIcon(
				System.getProperty("user.dir") + File.separator + 
				"src" + File.separator + 
				"Resources" + File.separator + 
				"edit.png"));
		toolBarFullQueryPanel.add(editButton);
		
		JButton deleteButton = new JButton("");
		deleteButton.setIcon(new ImageIcon(
				System.getProperty("user.dir") + File.separator +
				"src" + File.separator + 
				"Resources" + File.separator + 
				"delete.png"));
		toolBarFullQueryPanel.add(deleteButton);
		
		JButton saveExcelButton = new JButton("");
		saveExcelButton.setIcon(new ImageIcon(
				System.getProperty("user.dir") + File.separator + 
				"src" + File.separator + 
				"Resources" + File.separator + 
				"saveExcel.png"));
		toolBarFullQueryPanel.add(saveExcelButton);
		
		JPanel queryPanel = new JPanel();
		fullQueryPanel.add(queryPanel, BorderLayout.CENTER);
		queryPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel dataQueryPanel = new JPanel();
		queryPanel.add(dataQueryPanel, BorderLayout.NORTH);
		GridBagLayout gbl_dataQueryPanel = new GridBagLayout();
		gbl_dataQueryPanel.columnWidths = new int[] {137, 0};
		gbl_dataQueryPanel.rowHeights = new int[] {0, 0, 0, 0};
		gbl_dataQueryPanel.columnWeights = new double[]{1.0, 1.0};
		gbl_dataQueryPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		dataQueryPanel.setLayout(gbl_dataQueryPanel);
		
		JRadioButton brandRadioButton = new JRadioButton("Marca");
		brandRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_brandRadioButton = new GridBagConstraints();
		gbc_brandRadioButton.anchor = GridBagConstraints.EAST;
		gbc_brandRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_brandRadioButton.gridx = 0;
		gbc_brandRadioButton.gridy = 0;
		dataQueryPanel.add(brandRadioButton, gbc_brandRadioButton);
		
		JComboBox brandsQueryComboBox = new JComboBox();
		GridBagConstraints gbc_brandsQueryComboBox = new GridBagConstraints();
		gbc_brandsQueryComboBox.anchor = GridBagConstraints.WEST;
		gbc_brandsQueryComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_brandsQueryComboBox.gridx = 1;
		gbc_brandsQueryComboBox.gridy = 0;
		dataQueryPanel.add(brandsQueryComboBox, gbc_brandsQueryComboBox);
		
		JRadioButton maximumConsumptionRadioButton = new JRadioButton("Consumo máximo");
		maximumConsumptionRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_maximumConsumptionRadioButton = new GridBagConstraints();
		gbc_maximumConsumptionRadioButton.anchor = GridBagConstraints.EAST;
		gbc_maximumConsumptionRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_maximumConsumptionRadioButton.gridx = 0;
		gbc_maximumConsumptionRadioButton.gridy = 1;
		dataQueryPanel.add(maximumConsumptionRadioButton, gbc_maximumConsumptionRadioButton);
		
		JSlider maximumConsumptionSlider = new JSlider();
		GridBagConstraints gbc_maximumConsumptionSlider = new GridBagConstraints();
		gbc_maximumConsumptionSlider.anchor = GridBagConstraints.WEST;
		gbc_maximumConsumptionSlider.insets = new Insets(0, 0, 5, 0);
		gbc_maximumConsumptionSlider.gridx = 1;
		gbc_maximumConsumptionSlider.gridy = 1;
		dataQueryPanel.add(maximumConsumptionSlider, gbc_maximumConsumptionSlider);
		
		JRadioButton maximumEmissionsRadioButton = new JRadioButton("Emisiones máximas");
		maximumEmissionsRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_maximumEmissionsRadioButton = new GridBagConstraints();
		gbc_maximumEmissionsRadioButton.anchor = GridBagConstraints.EAST;
		gbc_maximumEmissionsRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_maximumEmissionsRadioButton.gridx = 0;
		gbc_maximumEmissionsRadioButton.gridy = 2;
		dataQueryPanel.add(maximumEmissionsRadioButton, gbc_maximumEmissionsRadioButton);
		
		JSlider maximumEmissionsSlider = new JSlider();
		GridBagConstraints gbc_maximumEmissionsSlider = new GridBagConstraints();
		gbc_maximumEmissionsSlider.anchor = GridBagConstraints.WEST;
		gbc_maximumEmissionsSlider.insets = new Insets(0, 0, 5, 0);
		gbc_maximumEmissionsSlider.gridx = 1;
		gbc_maximumEmissionsSlider.gridy = 2;
		dataQueryPanel.add(maximumEmissionsSlider, gbc_maximumEmissionsSlider);
		
		JRadioButton energeticClassificationRadioButton = new JRadioButton("Calificación energética");
		energeticClassificationRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_energeticClassificationRadioButton = new GridBagConstraints();
		gbc_energeticClassificationRadioButton.anchor = GridBagConstraints.EAST;
		gbc_energeticClassificationRadioButton.insets = new Insets(0, 0, 0, 5);
		gbc_energeticClassificationRadioButton.gridx = 0;
		gbc_energeticClassificationRadioButton.gridy = 3;
		dataQueryPanel.add(energeticClassificationRadioButton, gbc_energeticClassificationRadioButton);
		
		JComboBox energeticClassificationQueryComboBox = new JComboBox();
		GridBagConstraints gbc_energeticClassificationQueryComboBox = new GridBagConstraints();
		gbc_energeticClassificationQueryComboBox.anchor = GridBagConstraints.WEST;
		gbc_energeticClassificationQueryComboBox.gridx = 1;
		gbc_energeticClassificationQueryComboBox.gridy = 3;
		dataQueryPanel.add(energeticClassificationQueryComboBox, gbc_energeticClassificationQueryComboBox);
		
		queryTable = new JTable();
		queryPanel.add(queryTable, BorderLayout.CENTER);
		
		JPanel createPanel = new JPanel();
		contentPane.add(createPanel, "createPanel");
		createPanel.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBarFullCreatePanel = new JToolBar();
		createPanel.add(toolBarFullCreatePanel, BorderLayout.NORTH);
		
		JButton saveButton = new JButton("");
		saveButton.setIcon(new ImageIcon(
				System.getProperty("user.dir") + File.separator + 
				"src" + File.separator + 
				"Resources" + File.separator + 
				"save.png"));
		toolBarFullCreatePanel.add(saveButton);
		
		JPanel dataCreatePanel = new JPanel();
		createPanel.add(dataCreatePanel, BorderLayout.CENTER);
		GridBagLayout gbl_dataCreatePanel = new GridBagLayout();
		gbl_dataCreatePanel.columnWidths = new int[]{201, 175, 0};
		gbl_dataCreatePanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
		gbl_dataCreatePanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_dataCreatePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		dataCreatePanel.setLayout(gbl_dataCreatePanel);
		
		JLabel brandLabel = new JLabel("Marca");
		brandLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_brandLabel = new GridBagConstraints();
		gbc_brandLabel.anchor = GridBagConstraints.EAST;
		gbc_brandLabel.insets = new Insets(0, 0, 5, 5);
		gbc_brandLabel.gridx = 0;
		gbc_brandLabel.gridy = 0;
		dataCreatePanel.add(brandLabel, gbc_brandLabel);
		
		JComboBox brandsCreateComboBox = new JComboBox();
		GridBagConstraints gbc_brandsCreateComboBox = new GridBagConstraints();
		gbc_brandsCreateComboBox.anchor = GridBagConstraints.WEST;
		gbc_brandsCreateComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_brandsCreateComboBox.gridx = 1;
		gbc_brandsCreateComboBox.gridy = 0;
		dataCreatePanel.add(brandsCreateComboBox, gbc_brandsCreateComboBox);
		
		JLabel modelLabel = new JLabel("Modelo");
		modelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_modelLabel = new GridBagConstraints();
		gbc_modelLabel.anchor = GridBagConstraints.EAST;
		gbc_modelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_modelLabel.gridx = 0;
		gbc_modelLabel.gridy = 1;
		dataCreatePanel.add(modelLabel, gbc_modelLabel);
		
		modelTextField = new JTextField();
		GridBagConstraints gbc_modelTextField = new GridBagConstraints();
		gbc_modelTextField.anchor = GridBagConstraints.WEST;
		gbc_modelTextField.insets = new Insets(0, 0, 5, 0);
		gbc_modelTextField.gridx = 1;
		gbc_modelTextField.gridy = 1;
		dataCreatePanel.add(modelTextField, gbc_modelTextField);
		modelTextField.setColumns(10);
		
		JLabel consumptionLabel = new JLabel("Consumo");
		consumptionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_consumptionLabel = new GridBagConstraints();
		gbc_consumptionLabel.anchor = GridBagConstraints.EAST;
		gbc_consumptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_consumptionLabel.gridx = 0;
		gbc_consumptionLabel.gridy = 2;
		dataCreatePanel.add(consumptionLabel, gbc_consumptionLabel);
		
		consumptionTextField = new JTextField();
		GridBagConstraints gbc_consumptionTextField = new GridBagConstraints();
		gbc_consumptionTextField.anchor = GridBagConstraints.WEST;
		gbc_consumptionTextField.insets = new Insets(0, 0, 5, 0);
		gbc_consumptionTextField.gridx = 1;
		gbc_consumptionTextField.gridy = 2;
		dataCreatePanel.add(consumptionTextField, gbc_consumptionTextField);
		consumptionTextField.setColumns(10);
		
		JLabel emissionsLabel = new JLabel("Emisiones");
		emissionsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_emissionsLabel = new GridBagConstraints();
		gbc_emissionsLabel.anchor = GridBagConstraints.EAST;
		gbc_emissionsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emissionsLabel.gridx = 0;
		gbc_emissionsLabel.gridy = 3;
		dataCreatePanel.add(emissionsLabel, gbc_emissionsLabel);
		
		emissionsTextField = new JTextField();
		GridBagConstraints gbc_emissionsTextField = new GridBagConstraints();
		gbc_emissionsTextField.anchor = GridBagConstraints.WEST;
		gbc_emissionsTextField.insets = new Insets(0, 0, 5, 0);
		gbc_emissionsTextField.gridx = 1;
		gbc_emissionsTextField.gridy = 3;
		dataCreatePanel.add(emissionsTextField, gbc_emissionsTextField);
		emissionsTextField.setColumns(10);
		
		JLabel energeticClassificationLabel = new JLabel("Clasifiación energética");
		energeticClassificationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_energeticClassificationLabel = new GridBagConstraints();
		gbc_energeticClassificationLabel.anchor = GridBagConstraints.EAST;
		gbc_energeticClassificationLabel.insets = new Insets(0, 0, 0, 5);
		gbc_energeticClassificationLabel.gridx = 0;
		gbc_energeticClassificationLabel.gridy = 4;
		dataCreatePanel.add(energeticClassificationLabel, gbc_energeticClassificationLabel);
		
		JComboBox energeticClassificationCreateComboBox = new JComboBox();
		GridBagConstraints gbc_energeticClassificationCreateComboBox = new GridBagConstraints();
		gbc_energeticClassificationCreateComboBox.anchor = GridBagConstraints.WEST;
		gbc_energeticClassificationCreateComboBox.gridx = 1;
		gbc_energeticClassificationCreateComboBox.gridy = 4;
		dataCreatePanel.add(energeticClassificationCreateComboBox, gbc_energeticClassificationCreateComboBox);
	}
	
	private void updateJTable(JTable table) {
		
	}
}