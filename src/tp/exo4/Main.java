
/*
On veut représenter un polynôme par une liste chaînée dans laquelle on ne représente que les
coefficients non nuls.
1. Donner la structure permettant de faire cette représentation.
2. Donner une fonction DERIVEE(P) qui reçoit en entrée un polynôme et donne en sortie la
dérivée P’ de ce polynôme.
3. Donner une fonction DERIVEEKIEME(P,k) qui reçoit en entrée un polynôme P et donne
en sortie sa dérivée k-ième.
*/

public class Main {
    
    class Element {
        int degre;
        int coef;
        Element suivant;
    }

    class Polynome {
        Element tete;
    }

    public Polynome DERIVEE(Polynome P) {
        Polynome Pprime = new Polynome();
        Pprime.tete = new Element();
        Element e = P.tete;
        Element eprime = Pprime.tete;
        while (e != null) {
            eprime.degre = e.degre - 1;
            eprime.coef = e.degre * e.coef;
            eprime.suivant = new Element();
            e = e.suivant;
            eprime = eprime.suivant;
        }
        return Pprime;
    }

    public Polynome DERIVEEKIEME(Polynome P, int k) {
        Polynome Pprime = P;
        for (int i = 0; i < k; i++) {
            Pprime = DERIVEE(Pprime);
        }
        return Pprime;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Polynome P = m.new Polynome();
        P.tete = m.new Element();
        P.tete.degre = 3;
        P.tete.coef = 2;
        P.tete.suivant = m.new Element();
        P.tete.suivant.degre = 2;
        P.tete.suivant.coef = 3;
        P.tete.suivant.suivant = m.new Element();
        P.tete.suivant.suivant.degre = 1;
        P.tete.suivant.suivant.coef = 0;
        Polynome Pprime = m.DERIVEE(P);
        Polynome Pprimeprime = m.DERIVEEKIEME(P, 2);

        Element e = P.tete;
        while (e != null) {
            if (e.coef != 0) {
                System.out.print(e.coef+" x^"+e.degre +"\t");
            }
            e = e.suivant;
        }

        System.out.println();
        e = Pprime.tete;
        while (e != null) {
            if (e.coef != 0)
                System.out.print(e.coef+" x^"+e.degre +"\t");
            e = e.suivant;
        }

        System.out.println();
        e = Pprimeprime.tete;
        while (e != null) {
            if (e.coef != 0)
                System.out.print(e.coef+" x^"+e.degre +"\t");
            e = e.suivant;
        }
    }

}
