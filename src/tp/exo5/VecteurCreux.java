public class VecteurCreux {

    // Définition du type Maillon
    static class Maillon {
        int indice;
        float valeur;
        Maillon suivant;

        // Constructeur
        public Maillon(int indice, float valeur, Maillon suivant) {
            this.indice = indice;
            this.valeur = valeur;
            this.suivant = suivant;
        }
    }

    // // Définition du type Ptr
    // static class Ptr {
    //     Maillon maillon;

    //     // Constructeur
    //     public Ptr(Maillon maillon) {
    //         this.maillon = maillon;
    //     }
    // }

    // Fonction pour créer un nouveau maillon avec des valeurs initiales
    public static Maillon nouveau_maillon(int indice, float valeur, Maillon suivant) {
        return new Maillon(indice, valeur, suivant);
    }

    // Fonction pour construire la représentation d'un vecteur creux
    public static Maillon vecteur_creux(float[] t, int n) {
        Maillon premierMaillon = null; // Pointeur vers le premier maillon
        Maillon dernierMaillon = null; // Pointeur vers le dernier maillon

        // Parcourir le tableau pour créer les maillons
        for (int i = 0; i < n; i++) {
            if (t[i] != 0) { // Si la valeur n'est pas nulle
                Maillon nouveauMaillon = nouveau_maillon(i, t[i], null); // Créer un nouveau maillon
                if (premierMaillon == null) { // Si c'est le premier maillon
                    premierMaillon = nouveauMaillon;
                    dernierMaillon = nouveauMaillon;
                } else { // Sinon, le lier au dernier maillon
                    dernierMaillon.suivant = nouveauMaillon;
                    dernierMaillon = nouveauMaillon;
                }
            }
        }

        // Retourner le pointeur vers le premier maillon
        return (premierMaillon);
    }

    // Fonction pour additionner deux vecteurs creux
    public static Maillon somme(Maillon a, Maillon b) {
        Maillon maillonA = a;
        Maillon maillonB = b;
        Maillon resultatPremierMaillon = null; // Pointeur vers le premier maillon du résultat
        Maillon resultatDernierMaillon = null; // Pointeur vers le dernier maillon du résultat

        // Tant que les deux vecteurs ne sont pas entièrement parcourus
        while (maillonA != null || maillonB != null) {
            // Si les indices des deux vecteurs sont égaux
            if (maillonA != null && maillonB != null && maillonA.indice == maillonB.indice) {
                float somme = maillonA.valeur + maillonB.valeur; // Calculer la somme
                // Créer un nouveau maillon pour le résultat
                Maillon nouveauMaillon = nouveau_maillon(maillonA.indice, somme, null);
                if (resultatPremierMaillon == null) { // Si c'est le premier maillon
                    resultatPremierMaillon = nouveauMaillon;
                    resultatDernierMaillon = nouveauMaillon;
                } else { // Sinon, le lier au dernier maillon
                    resultatDernierMaillon.suivant = nouveauMaillon;
                    resultatDernierMaillon = nouveauMaillon;
                }
                // Passer aux maillons suivants dans les deux vecteurs
                maillonA = maillonA.suivant;
                maillonB = maillonB.suivant;
            } else if (maillonA != null && (maillonB == null || maillonA.indice < maillonB.indice)) {
                // Si seul le maillon du premier vecteur est disponible ou si l'indice du premier vecteur est inférieur
                Maillon nouveauMaillon = nouveau_maillon(maillonA.indice, maillonA.valeur, null);
                if (resultatPremierMaillon == null) { // Si c'est le premier maillon
                    resultatPremierMaillon = nouveauMaillon;
                    resultatDernierMaillon = nouveauMaillon;
                } else { // Sinon, le lier au dernier maillon
                    resultatDernierMaillon.suivant = nouveauMaillon;
                    resultatDernierMaillon = nouveauMaillon;
                }
                maillonA = maillonA.suivant; // Passer au maillon suivant dans le premier vecteur
            } else if (maillonB != null && (maillonA == null || maillonB.indice < maillonA.indice)) {
                // Si seul le maillon du deuxième vecteur est disponible ou si l'indice du deuxième vecteur est inférieur
                Maillon nouveauMaillon = nouveau_maillon(maillonB.indice, maillonB.valeur, null);
                if (resultatPremierMaillon == null) { // Si c'est le premier maillon
                    resultatPremierMaillon = nouveauMaillon;
                    resultatDernierMaillon = nouveauMaillon;
                } else { // Sinon, le lier au dernier maillon
                    resultatDernierMaillon.suivant = nouveauMaillon;
                    resultatDernierMaillon = nouveauMaillon;
                }
                maillonB = maillonB.suivant; // Passer au maillon suivant dans le deuxième vecteur
            }
        }

        // Retourner le pointeur vers le premier maillon du résultat
        return (resultatPremierMaillon);
    }

    // Fonction pour afficher un vecteur creux
    public static void afficherVecteurCreux(Maillon vecteurCreux) {
        Maillon maillonCourant = vecteurCreux;
        System.out.print("[");
        while (maillonCourant != null) {
            System.out.print("(" + maillonCourant.indice + ", " + maillonCourant.valeur + ")");
            maillonCourant = maillonCourant.suivant;
            if (maillonCourant != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Exemples d'utilisation
        float[] tableau1 = {0, 2, 9, 5, 0, 7, 0, 3, 0, 0};
        Maillon vecteurCreux1 = vecteur_creux(tableau1, tableau1.length);
        System.out.print("Vecteur creux 1 : ");
        afficherVecteurCreux(vecteurCreux1);

        float[] tableau2 = {0, 5, 0, 4, 0, 0, 6, 0, 0, 8};
        Maillon vecteurCreux2 = vecteur_creux(tableau2, tableau2.length);
        System.out.print("Vecteur creux 2 : ");
        afficherVecteurCreux(vecteurCreux2);

        Maillon sommeResultat = somme(vecteurCreux1, vecteurCreux2);
        System.out.print("Résultat de la somme : ");
        afficherVecteurCreux(sommeResultat);
    }
}
