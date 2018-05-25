package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ExcelExporter {
	public ExcelExporter() {}
	
	public void export(JTable table, File file) throws IOException {
		TableModel model = table.getModel();
		FileWriter out = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(out);
		
		for (int i = 0; i < model.getColumnCount(); i++) {
			bw.write(model.getColumnName(i) + '\t');
		}
		bw.write('\n');
		
		for (int i = 0; i < model.getColumnCount(); i++) {
			for (int j = 0; j <  model.getColumnCount(); j++) {
				bw.write(model.getValueAt(i,  j).toString() + '\t');
			}
			bw.write('\n');
		}
		bw.close();
		System.out.println("Write out to " + file);
	}
}
