#include <stdio.h>
#include <stdlib.h>

// Définition du type Maillon
typedef struct Maillon {
    int indice;
    float valeur;
    struct Maillon* suivant;
} Maillon;

// Définition du type Ptr
typedef struct Ptr {
    Maillon* maillon;
} Ptr;

// Fonction pour créer un nouveau maillon avec des valeurs initiales
Maillon* nouveau_maillon(int indice, float valeur, Maillon* suivant) {
    Maillon* maillon = (Maillon*)malloc(sizeof(Maillon));
    maillon->indice = indice;
    maillon->valeur = valeur;
    maillon->suivant = suivant;
    return maillon;
}

// Fonction pour construire la représentation d'un vecteur creux
Ptr vecteur_creux(float* t, int n) {
    Maillon* premierMaillon = NULL; // Pointeur vers le premier maillon
    Maillon* dernierMaillon = NULL; // Pointeur vers le dernier maillon

    // Parcourir le tableau pour créer les maillons
    for (int i = 0; i < n; i++) {
        if (t[i] != 0) { // Si la valeur n'est pas nulle
            Maillon* nouveauMaillon = nouveau_maillon(i, t[i], NULL); // Créer un nouveau maillon
            if (premierMaillon == NULL) { // Si c'est le premier maillon
                premierMaillon = nouveauMaillon;
                dernierMaillon = nouveauMaillon;
            } else { // Sinon, le lier au dernier maillon
                dernierMaillon->suivant = nouveauMaillon;
                dernierMaillon = nouveauMaillon;
            }
        }
    }

    // Retourner le pointeur vers le premier maillon
    Ptr ptr;
    ptr.maillon = premierMaillon;
    return ptr;
}

// Fonction pour additionner deux vecteurs creux
Ptr somme(Ptr a, Ptr b) {
    Maillon* maillonA = a.maillon;
    Maillon* maillonB = b.maillon;
    Maillon* resultatPremierMaillon = NULL; // Pointeur vers le premier maillon du résultat
    Maillon* resultatDernierMaillon = NULL; // Pointeur vers le dernier maillon du résultat

    // Tant que les deux vecteurs ne sont pas entièrement parcourus
    while (maillonA != NULL || maillonB != NULL) {
        // Si les indices des deux vecteurs sont égaux
        if (maillonA != NULL && maillonB != NULL && maillonA->indice == maillonB->indice) {
            float somme = maillonA->valeur + maillonB->valeur; // Calculer la somme
            // Créer un nouveau maillon pour le résultat
            Maillon* nouveauMaillon = nouveau_maillon(maillonA->indice, somme, NULL);
            if (resultatPremierMaillon == NULL) { // Si c'est le premier maillon
                resultatPremierMaillon = nouveauMaillon;
                resultatDernierMaillon = nouveauMaillon;
            } else { // Sinon, le lier au dernier maillon
                resultatDernierMaillon->suivant = nouveauMaillon;
                resultatDernierMaillon = nouveauMaillon;
            }
            // Passer aux maillons suivants dans les deux vecteurs
            maillonA = maillonA->suivant;
            maillonB = maillonB->suivant;
        } else if (maillonA != NULL && (maillonB == NULL || maillonA->indice < maillonB->indice)) {
            // Si seul le maillon du premier vecteur est disponible ou si l'indice du premier vecteur est inférieur
            Maillon* nouveauMaillon = nouveau_maillon(maillonA->indice, maillonA->valeur, NULL);
            if (resultatPremierMaillon == NULL) { // Si c'est le premier maillon
                resultatPremierMaillon = nouveauMaillon;
                resultatDernierMaillon = nouveauMaillon;
            } else { // Sinon, le lier au dernier maillon
                resultatDernierMaillon->suivant = nouveauMaillon;
                resultatDernierMaillon = nouveauMaillon;
            }
            maillonA = maillonA->suivant; // Passer au maillon suivant dans le premier vecteur
        } else if (maillonB != NULL && (maillonA == NULL || maillonB->indice < maillonA->indice)) {
            // Si seul le maillon du deuxième vecteur est disponible ou si l'indice du deuxième vecteur est inférieur
            Maillon* nouveauMaillon = nouveau_maillon(maillonB->indice, maillonB->valeur, NULL);
            if (resultatPremierMaillon == NULL) { // Si c'est le premier maillon
                resultatPremierMaillon = nouveauMaillon;
                resultatDernierMaillon = nouveauMaillon;
            } else { // Sinon, le lier au dernier maillon
                resultatDernierMaillon->suivant = nouveauMaillon;
                resultatDernierMaillon = nouveauMaillon;
            }
            maillonB = maillonB->suivant; // Passer au maillon suivant dans le deuxième vecteur
        }
    }

    // Retourner le pointeur vers le premier maillon du résultat
    Ptr ptr;
    ptr.maillon = resultatPremierMaillon;
    return ptr;
}

// Fonction pour afficher un vecteur creux
void afficherVecteurCreux(Ptr vecteurCreux) {
    Maillon* maillonCourant = vecteurCreux.maillon;
    printf("[");
    while (maillonCourant != NULL) {
        printf("(%d, %.f)", maillonCourant->indice, maillonCourant->valeur);
        maillonCourant = maillonCourant->suivant;
        if (maillonCourant != NULL) {
            printf(", ");
        }
    }
    printf("]\n");
}

int main() {
    // Exemples d'utilisation
    float tableau1[] = {0, 0, 9, 5, 0, 7, 0, 3, 0, 0};
    Ptr vecteurCreux1 = vecteur_creux(tableau1, sizeof(tableau1) / sizeof(float));
    printf("Vecteur creux 1 : ");
    afficherVecteurCreux(vecteurCreux1);

    float tableau2[] = {0, 0, 0, 4, 0, 0, 6, 0, 0, 8};
    Ptr vecteurCreux2 = vecteur_creux(tableau2, sizeof(tableau2) / sizeof(float));
    printf("Vecteur creux 2 : ");
    afficherVecteurCreux(vecteurCreux2);

    Ptr sommeResultat = somme(vecteurCreux1, vecteurCreux2);
    printf("Résultat de la somme : ");
    afficherVecteurCreux(sommeResultat);

    return 0;
}
