public abstract class Compte {
    private static int code;
    protected float solde;
    private static int nbCompte;
    protected String typeDeCb;
    private float txInteret;
    private int coutDuCompte;
    private String decouvert = "";
    private float limited;

    public Compte(float solde, String typeDeCb) {
        nbCompte++;
        code = 1000 + nbCompte;

    }

    public void versement(float mtOperation) {
    }

    public void retrait(float mtOperation) throws Exception {
    }

    // trasnfert d'un montant du compteA vers le compteB
    public void transfert(Compte compteReceveur, float mtOperation) throws Exception {
    }

    public float getSolde() {
        return solde;
    }
}
