/*
Une Liste Chaînée Bidirectionnelle (ou LCB) est constituée de maillons, chacun comportant
une information dépendant du problème considéré et deux pointeurs : un vers le maillon
suivant et un vers le maillon précédent :
1. En supposant que l’information dépendant du problème considéré soit de type chaîne de
caractères, écrivez la déclaration de la structure maillon et des variables globales premier
et dernier nécessaires à la réalisation d’une LCB comme indiqué sur la figure ci-dessus.
2. Ecrivez la fonction
void ajouter_devant(char *s);
qui crée un nouveau maillon associé à la chaîne s et l’ajoute en tête de la liste.
3. Réécrire la fonction ajouter_devant en supposant que premier et dernier sont des
paramètres de la fonction, non des variables globales.
4. Ecrivez la fonction
void supprimer(char *s);
qui supprime de la LCB le premier maillon portant l’information représentée par s, s’il existe.
Cette fonction accède aux variables globales premier et dernier. Notez que l’existence d’un
double chaînage permet de parcourir la liste avec un seul pointeur.
*/

class Maillon {
    String info;
    Maillon suiv;
    Maillon prec;

    Maillon(String info) {
        this.info = info;
        this.suiv = null;
        this.prec = null;
    }
}

public class ListeChaineeBidirectionnelle {
    private Maillon premier = null;
    private Maillon dernier = null;

    // Crée un nouveau maillon associé à la chaîne s et l’ajoute en tête de la liste
    public void ajouterDevant(String s) {
        Maillon p = new Maillon(s);
        p.suiv = premier;
        if (premier == null) {
            premier = dernier = p;
        } else {
            premier.prec = p;
            premier = p;
        }
    }

    public void ajouterDevant(String s, Maillon premier, Maillon dernier) {
        Maillon p = new Maillon(s);
        p.suiv = premier;
        if (premier == null) {
            premier = dernier = p;
        } else {
            premier.prec = p;
            premier = p;
        }
    }

    // Supprime de la LCB le premier maillon portant l’information représentée par s, s’il existe
    public void supprimer(String s) {
        Maillon p = premier;
        while (p != null && !p.info.equals(s)) { // Parcourt la liste jusqu'à trouver le maillon à supprimer
            p = p.suiv;
        }
        if (p != null) { // Si le maillon à supprimer est trouvé
            if (p == premier) { // Si le maillon à supprimer est en tête de liste
                premier = p.suiv;
                if (premier != null) {
                    premier.prec = null;
                } else {
                    dernier = null;
                }
            } else if (p == dernier) { // Si le maillon à supprimer est en fin de liste
                dernier = p.prec;
                dernier.suiv = null;
            } else { // Si le maillon à supprimer est au milieu de la liste
                p.prec.suiv = p.suiv;
                p.suiv.prec = p.prec;
            }
        }
    }

    // Affiche les informations de tous les maillons de la liste
    public void afficherListe() {
        Maillon p = premier;
        while (p != null) { // Parcourt la liste pour afficher les informations de chaque maillon
            System.out.print(p.info + "\t");
            p = p.suiv;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListeChaineeBidirectionnelle liste = new ListeChaineeBidirectionnelle();
        liste.ajouterDevant("E");
        liste.ajouterDevant("D");
        liste.ajouterDevant("C");
        liste.ajouterDevant("B");
        liste.ajouterDevant("A");

        liste.afficherListe();

        System.out.println("--------- Suppression de C ---------");
        liste.supprimer("C");
        liste.afficherListe();

        System.out.println("--------- Ajout de C en tête de liste ---------");
        liste.ajouterDevant("C");
        liste.afficherListe();
    }
}
