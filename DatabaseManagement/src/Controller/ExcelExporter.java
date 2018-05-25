package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelExporter {
	public ExcelExporter() {}

	public void export(ArrayList<Model> models, File file) throws IOException {
		FileWriter out = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(out);

		bw.write("MODELO" + '\t');
		bw.write("CONSUMO" + '\t');
		bw.write("EMISIONES" + '\t');
		bw.write("C_ENERGETICA" + '\t');

		bw.write('\n');

		for (int i = 0; i < models.size(); i++) {
			bw.write(models.get(i).getModel() + '\t');
			bw.write(String.valueOf(models.get(i).getConsumption()) + '\t');
			bw.write(String.valueOf(models.get(i).getEmissions()) + '\t');

			if (models.get(i).getIcon().equals("coches_A.gif"))
				bw.write("A" + '\t');

			else if (models.get(i).getIcon().equals("coches_B.gif"))
				bw.write("B" + '\t');

			else if (models.get(i).getIcon().equals("coches_C.gif"))
				bw.write("C" + '\t');

			else if (models.get(i).getIcon().equals("coches_D.gif"))
				bw.write("D" + '\t');

			else if (models.get(i).getIcon().equals("coches_E.gif"))
				bw.write("E" + '\t');

			else if (models.get(i).getIcon().equals("coches_F.gif"))
				bw.write("F" + '\t');

			else if (models.get(i).getIcon().equals("coches_G.gif"))
				bw.write("G" + '\t');

			else 
				bw.write("N/A" + '\t');

			bw.write('\n');
		}
		bw.close();
	}
}
