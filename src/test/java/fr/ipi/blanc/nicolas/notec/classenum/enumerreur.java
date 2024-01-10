package fr.ipi.blanc.nicolas.notec.classenum;

public enum enumerreur {
    NB1A3("Le nombre doit être entre 1 et 3"),
	NOTFILE("Le fichier n'a pas été trouvé dans le JAR.\"");
    private final String description;
    private enumerreur(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
