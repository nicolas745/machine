package fr.ipi.blanc.nicolas.notec.exceptions;

import fr.ipi.blanc.nicolas.notec.classenum.enumerreur;

public class exceptionsmachine extends Exception{
	public exceptionsmachine() {
		super(enumerreur.NB1A3.getDescription());
	}
}
