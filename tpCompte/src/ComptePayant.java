public class ComptePayant extends Compte{

    private float limited = -100;
    private int coutDuCompte = 50;
    private final float txInteret = 1;


    public ComptePayant(float solde, String typeDeCb) throws Exception {
        super(solde, typeDeCb);
        if (solde-coutDuCompte>limited){
            this.solde = solde - this.coutDuCompte;
            this.typeDeCb = typeDeCb;

            if (typeDeCb.equals("Visa")) {
                this.solde = this.solde - 5;
            } else if (typeDeCb.equals("MasterCard")){
                this.solde = this.solde - 10;
            }
        } else {
            throw new Exception("Solde insuffisant pour la création du compte");
        }

    }


    @Override
    public void versement(float mtOperation) {
        this.solde = this.solde + mtOperation - this.txInteret;
    }

    @Override
    public void retrait(float mtOperation) throws Exception {
        if (solde - mtOperation < limited) {
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
