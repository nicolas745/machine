package fr.ipi.blanc.nicolas.notec.classenum;

public enum enummachine {
    BIENVENU("°º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`\r\n"
		+ "Bienvenue au Casino de Céladopole !\r\n"
		+ "°º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`"),
    NBJETON("Jetons possédés : "),
    RESTART("Combien de jetons ? (1, 2 ou 3) : ");
    private final String description;
    private enummachine(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
