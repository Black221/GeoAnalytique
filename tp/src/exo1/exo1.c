/*
On désire stocker en mémoire une suite de mots entrés au clavier. Ne connaissant pas à
l’avance le nombre de mots qui seront lus ni leur taille, on décide de les stocker dans une liste
chaînée dont les maillons pointent sur des chaînes de caractères.

Ecrire les fonctions suivantes :
1. PTR ajoute_debut(char *mot, PTR L) qui crée un maillon pour mot, le rajoute en tête
de la liste chaînée L, et retourne la nouvelle liste.
2. PTR ajoute_fin(char *mot, PTR L) qui crée un maillon pour mot, le rajoute en fin de
la liste chaînée L, et retourne la nouvelle liste.
3. PTR supprimer(char *mot, PTR l) qui supprime le maillon qui contient le mot
considéré dans la liste L et retourne la nouvelle liste.
4. void premiers( PTR liste, int n) qui affiche les n premiers mots de la liste.
5. void purifie(MAILLON *liste) qui ne conserve dans liste qu’une seule occurrence d’un
mot représenté plusieurs fois dans la liste chaînée triée liste.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct maillon {
    char *mot ;
    struct maillon *suiv ; // Pointeur vers le maillon suivant
} MAILLON, *PTR ; 
// MAILLON est un alias pour struct maillon
// PTR est un alias pour struct maillon * donc PTR est un pointeur vers un maillon

// ajoute un maillon en début de liste
PTR ajoute_debut(char *mot, PTR L) {
    PTR p = (PTR) malloc(sizeof(MAILLON)); // Allocation dynamique de la mémoire pour le maillon p
    p->mot = mot; // Initialisation du champ mot du maillon p
    p->suiv = L; // Initialisation du champ suiv du maillon p
    return p;
}

// ajoute un maillon en fin de liste
PTR ajoute_fin(char *mot, PTR L) {
    PTR p = (PTR) malloc(sizeof(MAILLON)); // Allocation dynamique de la mémoire pour le maillon p
    p->mot = mot;
    p->suiv = NULL; 
    if (L == NULL) { // Si la liste est vide on insère le maillon p en tête de liste
        return p;
    }
    PTR q = L; // q pointe sur le premier maillon de la liste
    while (q->suiv != NULL) { // On cherche le dernier maillon de la liste
        q = q->suiv;
    }
    q->suiv = p; // On insère le maillon p en fin de liste
    return L;
}

// supprime le maillon qui contient le mot considéré dans la liste L
PTR supprimer(char *mot, PTR L) {
    if (L == NULL) { // Si la liste est vide on retourne NULL
        return L;
    }
    if (strcmp(L->mot, mot) == 0) { // Si le mot à supprimer est en tête de liste
        PTR p = L->suiv;
        free(L); // On libère la mémoire allouée pour le maillon à supprimer
        return p;
    }
    PTR p = L;
    while (p->suiv != NULL && strcmp(p->suiv->mot, mot) != 0) { // On cherche le maillon à supprimer
        p = p->suiv;
    }
    if (p->suiv != NULL) { // Si le maillon à supprimer est trouvé
        PTR q = p->suiv; // q pointe sur le maillon à supprimer
        p->suiv = q->suiv; // On supprime le maillon q de la liste
        free(q); // On libère la mémoire allouée pour le maillon à supprimer
    }
    return L;
}

// affiche les n premiers mots de la liste
void premiers(PTR liste, int n) {
    while (liste != NULL && n > 0) { // On parcourt la liste jusqu'à l'élément n
        printf("%s\t", liste->mot); // On affiche le mot du maillon courant
        liste = liste->suiv; // On passe au maillon suivant
        n--; // On décrémente n
    }
    printf("\n"); // ligne suivante
}

/*
    ne conserve dans liste qu’une seule occurrence d’un
    mot représenté plusieurs fois dans la liste chaînée triée liste.
*/ 

void purifie(MAILLON *liste) {
    if (liste == NULL) { // Si la liste est vide on retourne NULL
        return;
    }
    MAILLON *p = liste; // p pointe sur le premier maillon de la liste
    while (p->suiv != NULL) { // On parcourt la liste
        if (strcmp(p->mot, p->suiv->mot) == 0) { // Si le mot courant est égal au mot suivant
            MAILLON *q = p->suiv; // q pointe sur le maillon suivant
            p->suiv = q->suiv; // On supprime le maillon q de la liste
            free(q); // On libère la mémoire allouée pour le maillon q
        } else { // Sinon on passe au maillon suivant
            p = p->suiv;
        }
    }
}

int main(int argc, char const *argv[]) {

    PTR m = NULL;
    m = ajoute_debut("Bonjour", m);
    m = ajoute_debut("Salut", m);
    m = ajoute_debut("Hello", m);
    m = ajoute_fin("Bye", m);
    
    premiers(m, 2); // Hello Salut
    purifie(m); // Hello Salut Bye
    m = supprimer("Salut", m);
    premiers(m, 10); // Hello Bye

    return 0;
}
