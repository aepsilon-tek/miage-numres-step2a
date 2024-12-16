# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse:
La méthode retourne une liste JSON contenant les questions du quizz. Chaque question a :

- Un identifiant (id),
- Des traductions dans plusieurs langues (fr, en, it) pour le texte de la question,
- Une catégorie qui est également traduite dans plusieurs langues.

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse:
La méthode retourne une liste JSON contenant les propositions associées à une question donnée (ici id=1). Chaque proposition comprend :

- Un identifiant (id),
- Des traductions dans plusieurs langues (fr, en, it) pour le texte de la proposition,
- Un lien vers la question associée avec son identifiant et ses traductions.

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse:
La méthode retourne une valeur numérique qui représente le score obtenu par l'utilisateur en fonction des réponses fournies.
Dans l'exemple, le score est 0, ce qui signifie que les propositions {"id":1} et {"id":2} fournies ne sont pas correctes.

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse:
L'empreinte mémoire (RSS) utilisée par le processus Quarkus en mode JVM est de :
216100 Ko (environ 211,1 Mo).

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps : 0.004685 s
Taille : 125 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps : 22.773066 s
Taille : 883 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps : 0.016939 s
Taille : 1 byte

# Q8 : Empreinte mémoire en mode natif ?
Réponse:
L'empreinte mémoire (RSS) utilisée par l'API Quarkus en mode natif est de :
77156 Ko (environ 75,4 Mo).
# Q9: Temps et  taille  réponse   liste les questions
Temps : 14.375920 s
Taille : 883 bytes

# Q10: Temps et  taille  réponse  liste des propositions
Temps : 11.655834 s
Taille : 609 bytes

# Q11: Temps et  taille  réponse  évaluation les réponses
Temps : 0.001839 s
Taille : 1 byte

# Q12:  Proposition 1 : Réduction de la taille des réponses JSON
Description: 
Réduction de la taille des réponses JSON en filtrant les traductions inutiles grâce à un paramètre `lang`. Ce paramètre permet de retourner uniquement la traduction correspondant à la langue spécifiée par le client, réduisant ainsi la taille des données transmises. Si aucun paramètre `lang` n'est fourni, toutes les traductions sont renvoyées.

Temps:
- Avant amélioration (sans filtre) : 23.581519 s
- Après amélioration (avec `lang=fr`) : 17.794422 s

Taille:
- Avant amélioration (sans filtre) : 883 bytes
- Après amélioration (avec `lang=fr`) : 558 bytes

# Q13:  Proposition 2
Description:
Mise en cache des réponses pour l'endpoint `/questions` afin de réduire les temps de réponse et la charge sur la base de données. Le cache est nommé `questions-cache`, avec une taille maximale de 100 entrées et une expiration de 60 secondes.

Temps:
- Avant amélioration (sans cache) : 26.231484s
- Après amélioration (avec cache) : 0.007172s
Taille: 
Les réponses ont la même taille : 883 bytes.


# Q14:  Proposition 3
Description: Suppression des imports inutilisés dans le projet pour améliorer la lisibilité et réduire la taille des fichiers compilés.
Temps:Aucun impact sur l'exécution
Taille:Réduction légère de la taille des fichiers .class générés.

# Q15:  Proposition 4
Description: Réduire les niveaux de log pour éviter d'afficher des logs inutiles en production, ce qui allège la consommation des ressources et le bruit dans la console.
Temps:Pas de changement significatif, mais moins de ressources CPU utilisées pour l'écriture des logs.
Taille:
- Avant l'amélioration : Log complet avec beaucoup de lignes (INFO, DEBUG).
- Après amélioration : Log réduit (seules les erreurs critiques sont affichées).
