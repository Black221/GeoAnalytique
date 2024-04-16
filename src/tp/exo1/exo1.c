#include <stdio.h>         // Inclut la bibliothèque standard pour les entrées/sorties
#include <stdlib.h>        // Inclut la bibliothèque standard pour la gestion de la mémoire
#include <string.h>        // Inclut la bibliothèque standard pour la manipulation des chaînes de caractères

// Définition de la structure de maillon
struct maillon {
    char *mot;             // Chaîne de caractères stockant le mot
    struct maillon *suiv;  // Pointeur vers le maillon suivant dans la liste
};

typedef struct maillon MAILLON, *PTR;  // Définition du type PTR pour simplifier

// Fonction pour créer un nouveau maillon et l'ajouter en début de liste
PTR ajoute_debut(char *mot, PTR L) {
    // Allocation de mémoire pour le nouveau maillon
    PTR nouveau_maillon = (PTR)malloc(sizeof(MAILLON));
    nouveau_maillon->mot = strdup(mot);  // Copie la chaîne de caractères mot dans le nouveau maillon
    nouveau_maillon->suiv = L;  // Ajoute le nouveau maillon en début de liste
    return nouveau_maillon;  // Retourne le nouveau maillon
}

// Fonction pour créer un nouveau maillon et l'ajouter en fin de liste
PTR ajoute_fin(char *mot, PTR L) {
    // Allocation de mémoire pour le nouveau maillon
    PTR nouveau_maillon = (PTR)malloc(sizeof(MAILLON));
    nouveau_maillon->mot = strdup(mot);  // Copie la chaîne de caractères mot dans le nouveau maillon
    nouveau_maillon->suiv = NULL;  // Initialise le pointeur suivant du nouveau maillon à NULL
    if (L == NULL) {
        return nouveau_maillon;
    }
    PTR temp = L;
    while (temp->suiv != NULL) {  // Parcourt la liste pour atteindre le dernier maillon
        temp = temp->suiv;
    }
    temp->suiv = nouveau_maillon;  // Ajoute le nouveau maillon en fin de liste
    return L;  // Retourne la liste mise à jour
}

// Fonction pour supprimer un maillon contenant un mot spécifique de la liste
PTR supprimer(char *mot, PTR L) {
    if (L == NULL) {  // Vérifie si la liste est vide
        return NULL;  // Retourne NULL si la liste est vide
    }
    if (strcmp(L->mot, mot) == 0) {  // Vérifie si le premier maillon contient le mot à supprimer
        PTR temp = L->suiv;
        free(L->mot);  // Libère la mémoire allouée pour la chaîne de caractères du premier maillon
        free(L);       // Libère la mémoire allouée pour le premier maillon
        return temp;   // Retourne le pointeur vers le deuxième maillon de la liste
    }
    PTR temp = L;
    while (temp->suiv != NULL && strcmp(temp->suiv->mot, mot) != 0) {  // Recherche du maillon à supprimer
        temp = temp->suiv;
    }
    if (temp->suiv != NULL) {
        PTR a_supprimer = temp->suiv;
        temp->suiv = temp->suiv->suiv;
        free(a_supprimer->mot);  // Libère la mémoire allouée pour la chaîne de caractères du maillon à supprimer
        free(a_supprimer);       // Libère la mémoire allouée pour le maillon à supprimer
    }
    return L;  // Retourne la liste mise à jour
}

// Fonction pour afficher les n premiers mots de la liste
void premiers(PTR liste, int n) {
    int i = 0;
    while (liste != NULL && i < n) {  // Parcourt les n premiers maillons de la liste
        printf("%s ", liste->mot);   // Affiche le mot du maillon courant
        liste = liste->suiv;          // Passe au maillon suivant dans la liste
        i++;                          // Incrémente le compteur
    }
    printf("\n");  // Affiche une nouvelle ligne à la fin
}

// Fonction pour purifier la liste en ne conservant qu'une seule occurrence de chaque mot
void purifie(MAILLON *liste) {
    if (liste == NULL) {  // Vérifie si la liste est vide
        return;  // Retourne si la liste est vide
    }
    PTR courant = liste;  // Initialise un pointeur courant pour parcourir la liste
    while (courant != NULL && courant->suiv != NULL) {  // Parcourt la liste
        PTR comparer = courant;  // Initialise un pointeur pour comparer avec le maillon courant
        while (comparer->suiv != NULL) {  // Parcourt pour comparer chaque maillon avec les suivants
            if (strcmp(courant->mot, comparer->suiv->mot) == 0) {  // Si deux maillons contiennent le même mot
                PTR a_supprimer = comparer->suiv;  // Pointeur vers le maillon à supprimer
                comparer->suiv = comparer->suiv->suiv;  // Réorganise les pointeurs pour sauter le maillon à supprimer
                free(a_supprimer->mot);  // Libère la mémoire allouée pour la chaîne de caractères du maillon à supprimer
                free(a_supprimer);       // Libère la mémoire allouée pour le maillon à supprimer
            } else {
                comparer = comparer->suiv;  // Passe au maillon suivant pour la comparaison
            }
        }
        courant = courant->suiv;  // Passe au maillon suivant dans la liste
    }
}

// Fonction principale pour tester les fonctions
int main() {
    PTR liste = NULL;  // Initialise la liste comme étant vide
    liste = ajoute_debut("Bonjour", liste);  // Ajoute "Bonjour" en début de liste
    liste = ajoute_debut("Bonjour", liste);  // Ajoute "Bonjour" en début de liste
    liste = ajoute_fin("monde", liste);       // Ajoute "monde" en fin de liste
    liste = ajoute_fin("Bonjour", liste);     // Pour tester la purification

    printf("Liste initiale : ");
    premiers(liste, 10);  // Affiche les 10 premiers mots de la liste

   // printf("Après suppression de 'Bonjour' : ");
    //liste = supprimer("Bonjour", liste);  // Supprime le mot "Bonjour" de la liste
    //premiers(liste, 10);  // Affiche les 10 premiers mots de la liste mise à jour

    printf("Liste purifiée : ");
    purifie(liste);  // Purifie la liste en supprimant les doublons
    premiers(liste, 10);  // Affiche les 10 premiers mots de la liste purifiée

    return 0;  // Fin du programme
}
