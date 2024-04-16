class Maillon {
    String mot;    // Chaîne de caractères stockant le mot
    Maillon suiv;  // Référence vers le maillon suivant dans la liste

    // Constructeur pour initialiser un maillon avec un mot donné
    public Maillon(String mot) {
        this.mot = mot;  // Initialise le mot du maillon avec la valeur donnée
        this.suiv = null;  // Initialise la référence vers le maillon suivant à null
    }
}

public class ListeChainee {

    
    // Fonction pour créer un nouveau maillon et l'ajouter en début de liste
    public static Maillon ajouteDebut(String mot, Maillon L) {
        Maillon nouveauMaillon = new Maillon(mot);  // Crée un nouveau maillon avec le mot donné
        nouveauMaillon.suiv = L;  // Affecte la référence vers le maillon suivant au maillon précédent
        return nouveauMaillon;  // Retourne le nouveau maillon ajouté en début de liste
    }

    // Fonction pour créer un nouveau maillon et l'ajouter en fin de liste
    public static Maillon ajouteFin(String mot, Maillon L) {
        Maillon nouveauMaillon = new Maillon(mot);  // Crée un nouveau maillon avec le mot donné
        if (L == null) {
            return nouveauMaillon;  // Si la liste est vide, retourne le nouveau maillon comme tête de liste
        }
        Maillon temp = L;
        while (temp.suiv != null) {
            temp = temp.suiv;  // Parcourt la liste jusqu'au dernier maillon
        }
        temp.suiv = nouveauMaillon;  // Ajoute le nouveau maillon à la fin de la liste
        return L;  // Retourne la tête de liste
    }

    // Fonction pour supprimer un maillon contenant un mot spécifique de la liste
    public static Maillon supprimer(String mot, Maillon L) {
        if (L == null) {
            return null;  // Si la liste est vide, retourne null
        }
        if (L.mot.equals(mot)) {
            return L.suiv;  // Si le mot à supprimer est dans le premier maillon, retourne le deuxième maillon
        }
        Maillon temp = L;
        while (temp.suiv != null && !temp.suiv.mot.equals(mot)) {
            temp = temp.suiv;  // Parcourt la liste jusqu'à trouver le maillon précédant celui à supprimer
        }
        if (temp.suiv != null) {
            temp.suiv = temp.suiv.suiv;  // Supprime le maillon en ajustant les références
        }
        return L;  // Retourne la tête de liste
    }

    // Fonction pour afficher les n premiers mots de la liste
    public static void premiers(Maillon liste, int n) {
        int i = 0;
        while (liste != null && i < n) {
            System.out.print(liste.mot + " ");  // Affiche le mot du maillon courant
            liste = liste.suiv;  // Passe au maillon suivant dans la liste
            i++;  // Incrémente le compteur
        }
        System.out.println();  // Affiche une nouvelle ligne à la fin
    }

    // Fonction pour purifier la liste en ne conservant qu'une seule occurrence de chaque mot
    public static void purifie(Maillon liste) {
        Maillon courant = liste;  // Initialise un pointeur pour parcourir la liste
        while (courant != null && courant.suiv != null) {
            Maillon comparer = courant;  // Initialise un pointeur pour comparer avec le maillon courant
            while (comparer.suiv != null) {
                if (courant.mot.equals(comparer.suiv.mot)) {
                    comparer.suiv = comparer.suiv.suiv;  // Supprime le maillon en ajustant les références
                } else {
                    comparer = comparer.suiv;  // Passe au maillon suivant pour la comparaison
                }
            }
            courant = courant.suiv;  // Passe au maillon suivant dans la liste
        }
    }

    // Fonction principale pour tester les fonctions
    public static void main(String[] args) {
        Maillon liste = null;  // Initialise la liste comme étant vide
        liste = ajouteDebut("Bonjour", liste);  // Ajoute "Bonjour" en début de liste
        liste = ajouteFin("monde", liste);       // Ajoute "monde" en fin de liste
        liste = ajouteFin("Bonjour", liste);     // Pour tester la purification

        System.out.print("Liste initiale : ");
        premiers(liste, 10);  // Affiche les 10 premiers mots de la liste

        System.out.print("Après suppression de 'Bonjour' : ");
        liste = supprimer("Bonjour", liste);  // Supprime le mot "Bonjour" de la liste
        premiers(liste, 10);  // Affiche les 10 premiers mots de la liste mise à jour

        System.out.print("Liste purifiée : ");
        purifie(liste);  // Purifie la liste en supprimant les doublons
        premiers(liste, 10);  // Affiche les 10 premiers mots de la liste purifiée
    }
}
