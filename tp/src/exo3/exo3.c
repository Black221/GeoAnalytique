/*
On considère des listes chaînées d'entiers.
Faire les déclarations nécessaires, et écrire en C, les procédures et fonctions permettant
d'effectuer les opérations suivantes :
1. Créer une liste avec dix valeurs saisies au clavier.
2. Tester l'égalité de deux listes.
3. Concaténer deux listes :
a) Dans une troisième liste.
b) Sans créer une troisième liste.
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct maillon {
    int info;
    struct maillon *suiv;
} MAILLON, *PTR;

// Créer une liste avec dix valeurs saisies au clavier
PTR creer_liste() {
    PTR premier = NULL, p;
    int i, x;
    for (i = 0; i < 10; i++) {
        printf("Donner la valeur %d : ", i + 1);
        scanf("%d", &x);
        p = (PTR) malloc(sizeof(MAILLON));
        p->info = x;
        p->suiv = premier;
        premier = p;
    }
    return premier;
}

// Tester l'égalité de deux listes
int egalite(PTR p1, PTR p2) {
    while (p1 != NULL && p2 != NULL) {
        if (p1->info != p2->info) {
            return 0;
        }
        p1 = p1->suiv;
        p2 = p2->suiv;
    }
    return p1 == NULL && p2 == NULL;
}

// Concaténer deux listes dans une troisième liste
PTR concatenation(PTR p1, PTR p2) {
    PTR p, q, premier = NULL;
    while (p1 != NULL) {
        p = (PTR) malloc(sizeof(MAILLON));
        p->info = p1->info;
        p->suiv = NULL;
        if (premier == NULL) {
            premier = p;
        } else {
            q->suiv = p;
        }
        q = p;
        p1 = p1->suiv;
    }
    while (p2 != NULL) {
        p = (PTR) malloc(sizeof(MAILLON));
        p->info = p2->info;
        p->suiv = NULL;
        if (premier == NULL) {
            premier = p;
        } else {
            q->suiv = p;
        }
        q = p;
        p2 = p2->suiv;
    }
    return premier;
}

// Concaténer deux listes sans créer une troisième liste
void concatenation_sans_troisieme(PTR *p1, PTR p2) {
    PTR p = *p1;
    if (p == NULL) {
        *p1 = p2;
    } else {
        while (p->suiv != NULL) {
            p = p->suiv;
        }
        p->suiv = p2;
    }
}

int main(int argc, char const *argv[]) {
    PTR p1 = creer_liste();
    PTR p2 = creer_liste();
    PTR p3 = concatenation(p1, p2);
    printf("Les deux listes sont %s\n", egalite(p1, p2) ? "égales" : "différentes");
    printf("La concaténation des deux listes dans une troisième liste : ");
    while (p3 != NULL) {
        printf("%d ", p3->info);
        p3 = p3->suiv;
    }
    printf("\n");
    concatenation_sans_troisieme(&p1, p2);
    printf("La concaténation des deux listes sans créer une troisième liste : ");
    while (p1 != NULL) {
        printf("%d ", p1->info);
        p1 = p1->suiv;
    }
    printf("\n");
    return 0;
}