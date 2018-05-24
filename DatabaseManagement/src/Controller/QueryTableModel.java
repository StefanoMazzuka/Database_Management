package Controller;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class QueryTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryTableModel(Object body[][], Object head[]) {
		super(body, head);
	}

	@Override
	public Class<?> getColumnClass(int column) {
		if (column == 3) return ImageIcon.class;
		return Object.class;
	}
}
