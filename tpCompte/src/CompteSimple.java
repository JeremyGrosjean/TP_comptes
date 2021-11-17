public class CompteSimple extends Compte{

    private String decouvert = "false";
    private float limited = 0;
    private int coutDuCompte = 0;
    private final float txInteret = 5;

    public CompteSimple(float solde, String typeDeCb) {
        super(solde, typeDeCb);
        this.solde = solde - this.coutDuCompte;
        this.typeDeCb = typeDeCb;

        if (typeDeCb.equals("Visa")) {
            this.solde = this.solde - 5;
        } else if (typeDeCb.equals("MasterCard")){
            this.solde = this.solde - 10;
        }
    }

    @Override
    public void versement(float mtOperation) {
        this.solde = this.solde + mtOperation - this.txInteret;
    }

    @Override
    public void retrait(float mtOperation) throws Exception {
        if (solde - mtOperation < 0) {
                throw new Exception("Retrait non autorisé");
        } else {
            this.solde = this.solde - mtOperation - this.txInteret;
        }
    }

    @Override
    public void transfert(Compte compteReceveur, float mtOperation) throws Exception {
        retrait(mtOperation);
        compteReceveur.versement(mtOperation);
    }
}
