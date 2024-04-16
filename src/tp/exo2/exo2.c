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

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct maillon {
    char *info; 
    struct maillon *suiv, *prec; // Pointeurs vers le maillon suivant et le maillon précédent
} MAILLON, *PTR;

PTR premier = NULL, dernier = NULL; // Variables globales premier et dernier initialisées à NULL

/*
    Analyse :
    nous avons le maillon bidirectionnel suivant :
    premier -> A -> B -> C -> D -> E -> NULL
    NULL <- A <- B <- C <- D <- E <- dernier
*/

// Crée un nouveau maillon associé à la chaîne s et l’ajoute en tête de la liste
void ajouter_devant(char *s) {
    PTR p = (PTR) malloc(sizeof(MAILLON)); // Allocation dynamique de la mémoire pour le maillon p
    p->info = s; // Initialisation du champ info du maillon p
    p->suiv = premier; // Initialisation du champ suiv du maillon p
    p->prec = NULL; // Initialisation du champ prec du maillon p
    if (premier == NULL) { // Si la liste est vide
        premier = dernier = p; // On insère le maillon p en tête de liste et en fin de liste
    } else {
        premier->prec = p; // On relie le maillon p au maillon suivant
        premier = p; // On insère le maillon p en tête de liste
    }
}   

// Réécrire la fonction ajouter_devant en supposant que premier et dernier sont des
// paramètres de la fonction, non des variables globales.

void ajouter_devant2(PTR *premier, PTR *dernier, char *s) {
    PTR p = (PTR) malloc(sizeof(MAILLON)); // Allocation dynamique de la mémoire pour le maillon p
    p->info = s; // Initialisation du champ info du maillon p
    p->suiv = *premier; // Initialisation du champ suiv du maillon p
    p->prec = NULL; // Initialisation du champ prec du maillon p
    if (*premier == NULL) { // Si la liste est vide
        *premier = *dernier = p; // On insère le maillon p en tête de liste et en fin de liste
    } else {
        (*premier)->prec = p; // On relie le maillon p au maillon suivant
        *premier = p; // On insère le maillon p en tête de liste
    }
}

// Supprime de la LCB le premier maillon portant l’information représentée par s, s’il existe
void supprimer(char *s) {
    PTR p = premier; // Initialisation du pointeur p sur le premier maillon de la liste
    while (p != NULL && strcmp(p->info, s) != 0) { // On cherche le maillon à supprimer
        p = p->suiv; // On passe au maillon suivant
    }
    if (p != NULL) { // Si le maillon à supprimer existe
        if (p == premier) { // Si le maillon à supprimer est en tête de liste
            premier = p->suiv; // On met à jour le pointeur premier
            if (premier != NULL) { // Si la liste n'est pas vide
                premier->prec = NULL; // On met à jour le champ prec du maillon suivant
            } else { // Sinon la liste est vide
                dernier = NULL; // On met à jour le pointeur dernier
            }
        } else if (p == dernier) { // Si le maillon à supprimer est en fin de liste
            dernier = p->prec; // On met à jour le pointeur dernier
            dernier->suiv = NULL; // On met à jour le champ suiv du maillon précédent
        } else { // Sinon le maillon à supprimer est entre deux maillons de la liste
            p->prec->suiv = p->suiv; // On met à jour le champ suiv du maillon précédent
            p->suiv->prec = p->prec; // On met à jour le champ prec du maillon suivant
        }
        free(p); // On libère la mémoire allouée pour le maillon à supprimer
    }
}

int main(int argc, char const *argv[]) {

    ajouter_devant("E"); 
    ajouter_devant("D"); 
    ajouter_devant("C"); 
    ajouter_devant("B"); 
    ajouter_devant("A"); 


    PTR p = premier; // Initialisation du pointeur p sur le premier maillon de la liste
    while (p != NULL) { // On parcourt la liste
        printf("%s\t", p->info); // On affiche l'information du maillon courant
        p = p->suiv; // On passe au maillon suivant
    }
    printf("\n");

    printf("--------- Suppression de C ---------\n");
    supprimer("C"); 
    p = premier; 

    while (p != NULL) { 
        printf("%s\t", p->info); 
        p = p->suiv; 
    }
    printf("\n"); 

    printf("--------- Ajout de C en tête de liste ---------\n");
    ajouter_devant2(&premier, &dernier, "C"); 
    p = premier; 

    while (p != NULL) { 
        printf("%s\t", p->info);
        p = p->suiv;
    }
    printf("\n"); 
    return 0;
}
