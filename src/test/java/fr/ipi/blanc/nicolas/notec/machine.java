package fr.ipi.blanc.nicolas.notec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import fr.ipi.blanc.nicolas.notec.classenum.enummachine;
import fr.ipi.blanc.nicolas.notec.exceptions.exceptionsmachine;

public class machine {
	private List<List<String>> matrice33 = new ArrayList<List<String>>();
	private ColumnsHandler columns = new ColumnsHandler();
	private Integer mygain = 0;
	private Integer nbjeton;
	public machine() {
		nbjeton = columns.getjeton();
		System.out.println(enummachine.BIENVENU.getDescription());
		chargematrice();
		graphique();
	}
	private void graphique() {
		affiche();
		if(nbjeton==0) {
			System.out.println(enummachine.GAMEOVER.getDescription());
		}else {
			select();
		}
	}
    private void select() {
    	System.out.println(enummachine.GAIN.getDescription()+mygain);
		System.out.println(enummachine.NBJETON.getDescription()+nbjeton);
		System.out.println(enummachine.RESTART.getDescription());
		BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
		try {
			boolean resselect = true;
			int nb=0;
			while(resselect) {
				String name = reader.readLine();
				mygain=0;
				nb = Integer.parseInt(name);
				if(nb<=nbjeton && 0<nb && nb<=3) {
					resselect = false;
				}
			}
			chargematrice();
			nbjeton -= nb;
	        if (System.console() == null) {
	        	try {
					gain(nb);
				} catch (exceptionsmachine e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	System.out.println("--------------------");
	        	graphique();
	        }else {

	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<List<String>> inverserMatrice(List<List<String>> matrice) {
        int lignes = matrice.size();
        int colonnes = matrice.get(0).size();
        List<List<String>> matriceInverse = new ArrayList<>();

        for (int j = 0; j < colonnes; j++) {
            List<String> nouvelleColonne = new ArrayList<>();
            for (int i = 0; i < lignes; i++) {
                nouvelleColonne.add(matrice.get(i).get(j));
            }
            matriceInverse.add(nouvelleColonne);
        }
        return matriceInverse;
    }
    public static void replaceCharAt(int x, int y, char newChar) {
        System.out.print("\033[" + y + ";" + x + "H");
        System.out.print(newChar);
    }
	public void chargematrice() {
		matrice33 = new ArrayList<List<String>>();
		int[] rntable = new int[3];
		for(int i=0;i<3;i++) {
			//rntable [i] = 0;
			rntable [i] = (int) Math.round(Math.random()*columns.getsize(i));
		}
		for(int i=0;i<3;i++) {
			List<String> list = new ArrayList<String>();
			for(int i2=0;i2<3;i2++) {
				list.add(columns.getculumnvalue(i,rntable[i]+i2));
			}
			matrice33.add(list);
		}
		matrice33 = inverserMatrice(matrice33);
	}
	private void affiche() {
		for (List<String> list : matrice33){
			String ligne = StringUtils.join(list,"|");
			System.out.println(ligne);
		}
		
	}
	public void gain(int nb) throws exceptionsmachine {
		if(1>nb && nb>3) {
			throw new exceptionsmachine();
		}

		Map<String, Double> listgain = columns.getgain();
		switch (nb) {
			case 1:
				if(checkligne(1)) {
					String selectcase = casename(matrice33.get(0).get(0));
					mygain =listgain.get(selectcase).intValue();
				}
				break;
			case 2:
				if(checkligne(0)) {
					String selectcase = casename(matrice33.get(0).get(0));
					System.out.println(selectcase);
					System.out.println(listgain);
					mygain =listgain.get(selectcase).intValue();
				}
				if(checkligne(1)) {
					String selectcase = casename(matrice33.get(1).get(0));
					mygain =listgain.get(selectcase).intValue();
				}
				if(checkligne(0)) {
					String selectcase = casename(matrice33.get(2).get(0));
					mygain =listgain.get(selectcase).intValue();
				}
				break;
			case 3:
				break;
			default:
				break;
		}
		nbjeton+=mygain;
	}
	private String casename(String symbole) {
		for (String namesym : columns.getgain().keySet()) {
			if(namesym.contains(symbole)) {
				return namesym;
			}
		}
		return null;
		
	}
	public boolean checkligne(int nb) {
		String lestcase = matrice33.get(nb).get(0);
		for (String casse : matrice33.get(nb)) {
			if(!lestcase.equals(casse)) {
				return false;
			}
		}
		return true;
	}
	public int select(int nb) throws exceptionsmachine{
		if(1<nb || nb<=3) {
			throw new exceptionsmachine();
		}
		return nb;
	}
	
}
