#include <stdio.h>
#include <stdlib.h>

// Définition de la structure ARB_BIN pour un arbre binaire d'entiers
typedef struct Noeud {
    int valeur;
    struct Noeud *gauche;
    struct Noeud *droit;
} ARB_BIN;

// Fonction de création d'un nouveau noeud
ARB_BIN* creerNoeud(int valeur) {
    ARB_BIN* nouveauNoeud = (ARB_BIN*)malloc(sizeof(ARB_BIN)); // Alloue dynamiquement de la mémoire pour un nouveau noeud
    if (nouveauNoeud == NULL) {
        fprintf(stderr, "Erreur: Impossible d'allouer de la mémoire\n");
        exit(EXIT_FAILURE);
    }
    nouveauNoeud->valeur = valeur;
    nouveauNoeud->gauche = NULL;
    nouveauNoeud->droit = NULL;
    return nouveauNoeud;   // Renvoie un pointeur vers le nouveau noeud créé
}

// Procédure d'affichage des feuilles
void feuille(ARB_BIN* racine) {
    if (racine != NULL) { 
        if (racine->gauche == NULL && racine->droit == NULL) {
            printf("%d ", racine->valeur);
        }
        feuille(racine->gauche);
        feuille(racine->droit);
    }
}

// Procédure d'affichage des degrés
void afficherDegre(ARB_BIN* racine) {
    if (racine != NULL) {
        int degre = 0;
        if (racine->gauche != NULL) degre++;
        if (racine->droit != NULL) degre++;

        printf("Noeud %d : degré %d\n", racine->valeur, degre);

        afficherDegre(racine->gauche);
        afficherDegre(racine->droit);
    }
}

// Fonction récursive pour trouver la profondeur d'un noeud
int profondeurNoeud(ARB_BIN* racine, int valeur, int profondeurActuelle) {
    if (racine == NULL) return -1; // Vérifie si la racine est NULL, dans ce cas retourne -1
    if (racine->valeur == valeur) return profondeurActuelle;

    int gauche = profondeurNoeud(racine->gauche, valeur, profondeurActuelle + 1);
    if (gauche != -1) return gauche;

    return profondeurNoeud(racine->droit, valeur, profondeurActuelle + 1);
}

// Procédure pour afficher la profondeur d'un noeud
void profondeur(ARB_BIN* racine, int valeur) {
    int profondeur = profondeurNoeud(racine, valeur, 0);
    if (profondeur != -1) {
        printf("La profondeur du noeud avec la valeur %d est : %d\n", valeur, profondeur);
    } else {
        printf("Le noeud avec la valeur %d n'existe pas dans l'arbre.\n", valeur);
    }
}

// Fonction récursive pour calculer la hauteur de l'arbre
int hauteurArbre(ARB_BIN* racine) {
    if (racine == NULL) return -1;
    int hauteurGauche = hauteurArbre(racine->gauche);
    int hauteurDroit = hauteurArbre(racine->droit);
    return (hauteurGauche > hauteurDroit ? hauteurGauche : hauteurDroit) + 1;
}

// Procédure pour afficher la hauteur de l'arbre
void hauteur(ARB_BIN* racine) {
    printf("La hauteur de l'arbre est : %d\n", hauteurArbre(racine));
}

// Fonction récursive pour calculer la somme des noeuds de l'arbre
int sommeNoeuds(ARB_BIN* racine) {
    if (racine == NULL) return 0;
    return racine->valeur + sommeNoeuds(racine->gauche) + sommeNoeuds(racine->droit);
}

// Fonction pour afficher la somme des noeuds de l'arbre


int main() {
    // Création de l'arbre binaire
    ARB_BIN* A = creerNoeud(1);
    A->gauche = creerNoeud(2);
    A->droit = creerNoeud(3);
    A->gauche->gauche = creerNoeud(4);
    A->gauche->droit = creerNoeud(5);
    A->droit->gauche = creerNoeud(6);
    A->droit->droit = creerNoeud(7);

    // Test des différentes procédures et fonctions
    printf("Feuilles de l'arbre : ");
    feuille(A);
    printf("\n");

    printf("\nDegrés des noeuds de l'arbre : \n");
    afficherDegre(A);

    profondeur(A, 4);

    hauteur(A);


    printf("La somme des noeuds de l'arbre est : %d\n", sommeNoeuds(A));

    return 0;
}
