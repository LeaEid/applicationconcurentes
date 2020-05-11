# Quelques exercices Thread Java

## Ordonner des execution de Thread avec join (Ordonner Thread squelette)[001_OrdonnerThread/]

Soit un objet tâche, la tâche à pour rôle de réaliser un certain traitement (dans l'exercice c'est juste un printf) voir (Tache)[001_OrdonnerThread/Tache.java]

Le thread principal crée 3 threads à partir de Tache et les démarre dans “l’ordre” TA,TB,TC. Vous créez un Thread TX ainsi `new Thread(new Tache(X), "TX")`

* *Question 1)* Adapter tache pour créer le Runnable avec paramètre du nom du runnable.

* *Question 2)* Créer la tache main qui va créer les trois Thread basé sur Tache TA,TB,TC

* *Question 3)* Modifier le code du constructeur de la classe Tache pour qu’il prenne en plus en paramètre une liste de 0 ou 1 threads à attendre, alternativement définir une méthode set_predecesseur(Thread t) qui permet de définir le prédécesseur d’un Thread "Tache".
* *Question 4)* Construire TC pour qu’il n’attende personne (ie ∅).
Construire TB pour qu’il attende TC.
Construire TA pour qu’il attende TB.
Lancer les 3 threads et observer (tester).
* *Question 5)* Que ce passerait-il si on ajoutait un thread TD avec TD<TC et TA<TD ? développer la solution et observer
* *Question 5)* Généraliser au cas de n threads T1,...,Ti,…Tn ou n est un argument passé au programme, En supposant que Tn ne dépend d'aucun Thread et T1 est le dernier à s’exécuter.

## RDV à n processus
Soient N processus parallèles ayant un point de rendez-vous. Un processus arrivant au point de
rendez-vous se met en attente s'il existe au moins un autre processus qui n'y est pas arrivé. Le dernier
arrivé réveillera les processus bloqués. La solution suivante résout ce problème en utilisant des
sémaphores. 

```java
public class PourRDV {
    private final Semaphore mutex;
    private final Semaphore rdv;
    private final int N;
    private int nbArrive;
    
    public PourRDV(int n) {
        mutex=new Semaphore(1);
        rdv=new Semaphore(0);
        N=n;
        nbArrive=0;
    }
    
    public void rdv() {
        mutex.acquireUninterruptibly();
        //Un arrivé supplémentaire
        nbArrive++;
        if (nbArrive < N) {
            //Tous les processus ne sont pas encore arrivé
            //Alors attendre
            mutex.release();
            rdv.acquireUninterruptibly();
        } else {
            //Il sont tous arrivé nbArrive == N
            mutex.release();
            //On libère les N-1 processus qui était en attente
            rdv.release(N-1);
        }
        
        
    }
}
```


