public class ComptePrenium extends Compte{

    private int coutDuCompte = 150;

    public ComptePrenium(float solde, String typeDeCb) {
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
        this.solde = this.solde + mtOperation;
    }

    @Override
    public void retrait(float mtOperation) throws Exception {
        this.solde = this.solde - mtOperation;
    }

    @Override
    public void transfert(Compte compteReceveur, float mtOperation) throws Exception {
        retrait(mtOperation);
        compteReceveur.versement(mtOperation);
    }
}
