package fr.ipi.blanc.nicolas.noteb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ipi.blanc.nicolas.notec.ColumnsHandler;

public class main {
    private static List<List<String>> matrice33 = new ArrayList<>();
    private static ColumnsHandler columnsHandler = new ColumnsHandler();

    public static void main(String[] args) {
        int total = 0;
        Map<Integer, Integer> stat = new HashMap<>();

        for (int colon1 = 0; colon1 < columnsHandler.getsize(0); colon1++) {
            for (int colon2 = 0; colon2 < columnsHandler.getsize(1); colon2++) {
                for (int colon3 = 0; colon3 < columnsHandler.getsize(2); colon3++) {
                    matrice33.clear();
                    for (int x = 0; x < 3; x++) {
                        ArrayList<String> row = new ArrayList<>();
                        row.add(columnsHandler.getculumnvalue(0, colon1 + x));
                        row.add(columnsHandler.getculumnvalue(1, colon2 + x));
                        row.add(columnsHandler.getculumnvalue(2, colon3 + x));
                        matrice33.add(row);
                    }
                    matrice33 = inverserMatrice(matrice33);
                    int mygain = 0;
                    Map<String, Double> listgain = columnsHandler.getgain();
                    if (checkligne(0)) {
                        String selectcase = casename(matrice33.get(0).get(0));
                        if(selectcase.equals("BAR")) {
                        	System.out.println("dd");
                        }
                        mygain += listgain.get(selectcase).intValue();
                    }
                    if (checkligne(1)) {
                        String selectcase = casename(matrice33.get(1).get(0));
                        mygain += listgain.get(selectcase).intValue();
                    }
                    if (checkligne(2)) {
                        String selectcase = casename(matrice33.get(2).get(0));
                        mygain += listgain.get(selectcase).intValue();
                    }
                    if (matrice33.get(0).get(0).equals(matrice33.get(1).get(1)) && matrice33.get(1).get(1).equals(matrice33.get(2).get(2))) {
                        String selectcase = casename(matrice33.get(1).get(1));
                        mygain += listgain.get(selectcase).intValue();
                    }
                    if (matrice33.get(2).get(0).equals(matrice33.get(1).get(1)) && matrice33.get(1).get(1).equals(matrice33.get(0).get(2))) {
                        String selectcase = casename(matrice33.get(1).get(1));
                        mygain += listgain.get(selectcase).intValue();
                    }
                    total++;
                    if (stat.containsKey(mygain)) {
                        stat.replace(mygain, 1 + stat.get(mygain));
                    } else {
                        stat.put(mygain, 1);
                    }
                }
            }
        }
        System.out.println(stat);
        System.out.println(total);
    }

    private static String casename(String symbole) {
        for (String namesym : columnsHandler.getgain().keySet()) {
            if (namesym.contains(symbole)) {
                return namesym;
            }
        }
        return null;
    }

    private static boolean checkligne(int nb) {
        String lestcase = matrice33.get(nb).get(0);
        for (String casse : matrice33.get(nb)) {
            if (!lestcase.equals(casse)) {
                return false;
            }
        }
        return true;
    }
	public static List<List<String>> inverserMatrice(List<List<String>> matrice332) {
        int lignes = matrice332.size();
        int colonnes = matrice332.get(0).size();
        List<List<String>> matriceInverse = new ArrayList<>();

        for (int j = 0; j < colonnes; j++) {
            List<String> nouvelleColonne = new ArrayList<>();
            for (int i = 0; i < lignes; i++) {
                nouvelleColonne.add(matrice332.get(i).get(j));
            }
            matriceInverse.add(nouvelleColonne);
        }
        return matriceInverse;
    }
}
