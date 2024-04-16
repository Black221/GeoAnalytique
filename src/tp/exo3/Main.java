/*
On considère des listes chaînees d'entiers.
Faire les declarations necessaires, et ecrire en C, les procedures et fonctions permettant
d'effectuer les operations suivantes :
1. Creer une liste avec dix valeurs saisies au clavier.
2. Tester l'egalite de deux listes.
3. Concatener deux listes :
a) Dans une troisième liste.
b) Sans creer une troisième liste.
*/
public class Main {
    
    class Maillon {
        int valeur;
        Maillon suivant;
    }

    class Liste {
        Maillon tete;
    }

    public Liste creerListe() {
        Liste l = new Liste();
        l.tete = new Maillon();
        Maillon m = l.tete;
        for (int i = 0; i < 10; i++) {
            m.valeur = Clavier.lire_int();
            m.suivant = new Maillon();
            m = m.suivant;
        }
        return l;
    }

    public boolean egalite(Liste l1, Liste l2) {
        Maillon m1 = l1.tete;
        Maillon m2 = l2.tete;
        while (m1 != null && m2 != null) {
            if (m1.valeur != m2.valeur) {
                return false;
            }
            m1 = m1.suivant;
            m2 = m2.suivant;
        }
        return m1 == null && m2 == null;
    }

    public Liste concatenationA(Liste l1, Liste l2) {
        Liste l3 = new Liste();
        l3.tete = new Maillon();
        Maillon m1 = l1.tete;
        Maillon m3 = l3.tete;
        while (m1 != null) {
            m3.valeur = m1.valeur;
            m3.suivant = new Maillon();
            m1 = m1.suivant;
            m3 = m3.suivant;
        }
        Maillon m2 = l2.tete;
        while (m2 != null) {
            m3.valeur = m2.valeur;
            m3.suivant = new Maillon();
            m2 = m2.suivant;
            m3 = m3.suivant;
        }
        return l3;
    }

    public Liste concatenationB(Liste l1, Liste l2) {
        Maillon m1 = l1.tete;
        while (m1.suivant != null) {
            m1 = m1.suivant;
        }
        m1.suivant = l2.tete;
        return l1;
    }

    public void afficherListe(Liste l) {
        Maillon m = l.tete;
        while (m != null) {
            System.out.print(m.valeur + " ");
            m = m.suivant;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main m = new Main();
        Liste l1 = m.creerListe();
        afficherListe(l1);
        Liste l2 = m.creerListe();
        afficherListe(l2);
        Liste l3 = m.concatenationA(l1, l2);
        afficherListe(l3);
        Liste l4 = m.concatenationB(l1, l2);
        afficherListe(l4);
    }
}
