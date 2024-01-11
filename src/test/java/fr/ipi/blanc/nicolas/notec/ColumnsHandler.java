package fr.ipi.blanc.nicolas.notec;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import fr.ipi.blanc.nicolas.notec.classenum.enumerreur;

public class ColumnsHandler {
	private static ArrayList<ArrayList<String>> column;
	private static Map<String, Double> gain;
	private static int nbjeton;
    public ColumnsHandler() throws JsonSyntaxException {
    	Gson data = new Gson();
        try (InputStream inputStream = main.class.getResourceAsStream("/data.json")) {
            if (inputStream != null) {
				Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
                String contenuFichier = scanner.hasNext() ? scanner.next() : "";
                Map<String,Object> json = data.fromJson(contenuFichier,Map.class);
                column = (ArrayList<ArrayList<String>>) json.get("column");
                gain = (Map<String, Double>) json.get("gain");
                nbjeton = ((Double) json.get("nbjeton")).intValue();
            } else {
                System.out.println(enumerreur.NOTFILE.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public int getsize(int i) {
		return column.get(i).size();
	}
	public Map<String, Double> getgain() {
		return gain;
	}
	public String getculumnvalue(int column, int id) {
		return this.column.get(column).get(Math.floorMod(id,getsize(column)));
	}
	public int getjeton() {
		return nbjeton;
	}
}