public class Main {

    public static void main(String[] args)  {

        Compte compteJerem = new ComptePrenium(200,"Visa");
        Compte compteManon = null;
        try {
            compteManon = new ComptePayant(80,"CB");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Compte compteAlbert = new CompteSimple(400, "MasterCard");

        System.out.println("Compte de Jerem : " + compteJerem.getSolde());

        compteJerem.versement(25);
        System.out.println("Compte de Jerem : " + compteJerem.getSolde());
        System.out.println("Compte de Manon : " + compteManon.getSolde());

        try {
            compteManon.transfert(compteAlbert,150);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Compte de Manon : " + compteManon.getSolde());
        System.out.println("Compte d'Albert : " + compteAlbert.getSolde());


    }
}
