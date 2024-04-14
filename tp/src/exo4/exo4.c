/*
On veut représenter un polynôme par une liste chaînée dans laquelle on ne représente que les
coefficients non nuls.
1. Donner la structure permettant de faire cette représentation.
2. Donner une fonction DERIVEE(P) qui reçoit en entrée un polynôme et donne en sortie la
dérivée P’ de ce polynôme.
3. Donner une fonction DERIVEEKIEME(P,k) qui reçoit en entrée un polynôme P et donne
en sortie sa dérivée k-ième.
*/

#include <stdio.h>
#include <stdlib.h>


typedef struct maillon {
    int degre;
    float coef;
    struct maillon *suiv;
} MAILLON, *PTR;

// Fonction qui reçoit en entrée un polynôme et donne en sortie la dérivée P’ de ce polynôme
PTR DERIVEE(PTR p) {
    PTR q, r, premier = NULL;
    while (p != NULL) {
        if (p->degre > 0) {
            q = (PTR) malloc(sizeof(MAILLON));
            q->degre = p->degre - 1;
            q->coef = p->degre * p->coef;
            q->suiv = NULL;
            if (premier == NULL) {
                premier = q;
            } else {
                r->suiv = q;
            }
            r = q;
        }
        p = p->suiv;
    }
    return premier;
}

// Fonction qui reçoit en entrée un polynôme P et donne en sortie sa dérivée k-ième
PTR DERIVEEKIEME(PTR p, int k) {
    int i;
    for (i = 0; i < k; i++) {
        p = DERIVEE(p);
    }
    return p;
}