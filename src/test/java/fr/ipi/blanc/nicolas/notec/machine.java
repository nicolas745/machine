package fr.ipi.blanc.nicolas.notec;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import fr.ipi.blanc.nicolas.notec.classenum.enummachine;
import fr.ipi.blanc.nicolas.notec.exceptions.exceptionsmachine;

public class machine {
	private List<List<String>> matrice33 = new ArrayList<List<String>>();
	private ColumnsHandler columns = new ColumnsHandler();
	public machine() {
		System.out.println(enummachine.BIENVENU.getDescription());
		chargematrice();
		affiche();
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
	public void chargematrice() {
		matrice33 = new ArrayList<List<String>>();
		int[] rntable = new int[3];
		for(int i=0;i<3;i++) {
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
			String ligne = StringUtils.join(list," | ");
			System.out.println(ligne);
		}
	}
	public int gain(int nb) throws exceptionsmachine {
		if(1<nb || nb<=3) {
			throw new exceptionsmachine();
		}
		int res = 0;
		switch (nb) {
			case 1:
				if(checkligne(1)) {
					
				}
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
		return res;
	}
	public boolean checkligne(int nb) {
		String lestcase = matrice33.get(0).get(0);
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
