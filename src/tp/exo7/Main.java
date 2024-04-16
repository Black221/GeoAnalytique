public class Main {

    public static void main(String[] args) {
        // Création de l'arbre binaire
        Noeud A = new Noeud(1);
        A.gauche = new Noeud(2);
        A.droit = new Noeud(3);
        A.gauche.gauche = new Noeud(4);
        A.gauche.droit = new Noeud(5);
        A.droit.gauche = new Noeud(6);
        A.droit.droit = new Noeud(7);

        // Test des différentes méthodes
        System.out.print("Feuilles de l'arbre : ");
        feuille(A);
        System.out.println();

        System.out.println("\nDegrés des noeuds de l'arbre : ");
        Degre(A);

        System.out.print("Profondeur du noeud avec la valeur 4 : ");
        System.out.println(profondeur(A, 4));

        System.out.print("Hauteur de l'arbre : ");
        System.out.println(hauteur(A));

        System.out.print("Somme des noeuds de l'arbre : ");
        System.out.println(somNoeuds(A));
    }

    // Définition de la classe Noeud pour un arbre binaire d'entiers
    static class Noeud {
        int valeur;
        Noeud gauche;
        Noeud droit;

        public Noeud(int valeur) {
            this.valeur = valeur;
            this.gauche = null;
            this.droit = null;
        }
    }

    // Méthode récursive pour afficher les feuilles de l'arbre
    static void feuille(Noeud racine) {
        if (racine != null) {
            if (racine.gauche == null && racine.droit == null) {
                System.out.print(racine.valeur + " ");
            }
            feuille(racine.gauche);
            feuille(racine.droit);
        }
    }

    // Méthode récursive pour afficher les degrés des noeuds de l'arbre
    static void Degre(Noeud racine) {
        if (racine != null) {
            int degre = 0;
            if (racine.gauche != null) degre++;
            if (racine.droit != null) degre++;

            System.out.println("Noeud " + racine.valeur + " : degré " + degre);

            Degre(racine.gauche);
            Degre(racine.droit);
        }
    }

    // Méthode récursive pour trouver la profondeur d'un noeud dans l'arbre
    static int profondeur(Noeud racine, int valeur) {
        if (racine == null) return -1;
        if (racine.valeur == valeur) return 0;

        int gauche = profondeur(racine.gauche, valeur);
        if (gauche != -1) return gauche + 1;

        int droit = profondeur(racine.droit, valeur);
        if (droit != -1) return droit + 1;

        return -1;
    }

    // Méthode récursive pour calculer la hauteur de l'arbre
    static int hauteur(Noeud racine) {
        if (racine == null) return -1;
        int hauteurGauche = hauteur(racine.gauche);
        int hauteurDroit = hauteur(racine.droit);
        return Math.max(hauteurGauche, hauteurDroit) + 1;
    }

    // Méthode récursive pour calculer la somme des noeuds de l'arbre
    static int somNoeuds(Noeud racine) {
        if (racine == null) return 0;
        return racine.valeur + somNoeuds(racine.gauche) + somNoeuds(racine.droit);
    }
}


