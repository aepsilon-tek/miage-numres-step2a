# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse:
La méthode qui liste les questions renvoie un tableau JSON contenant les détails des questions disponibles dans l'application. Chaque question est représentée par un objet contenant les informations suivantes :

- id : Identifiant unique de la question.
- translations : Une liste d'objets décrivant les traductions de la question dans différentes langues. 
    - language : Le code de langue (fr, en, it, etc.).
    - value : Le texte de la question dans la langue correspondante.
- catgory : Un objet décrivant la catégorie associée à la question, avec ses traductions dans différentes langues. 
    - translations : Une liste d'objets décrivant les traductions de la catégorie
    - value : Le tye de catégorie de la question

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse:
La méthode qui liste les propositions d'une question renvoie un tableau JSON contenant les détails des propositions associées à la question spécifiée. Chaque proposition est représentée par un objet avec les informations suivantes :

- id : Identifiant unique de la proposition.
- translations : Une liste d'objets décrivant les traductions de la proposition dans différentes langues. Chaque objet contient :
    - language : Le code de langue (fr, en, it, etc.).
    - value : Le texte de la proposition dans la langue correspondante.
- question : Un objet décrivant la question à laquelle la proposition est associée, avec :
    - id : Identifiant unique de la question.
    - translations : Une liste d'objets
        - language : Le code de langue (fr, en, it, etc.).
        - value : Le texte de la proposition dans la langue correspondante.
catgory : Un objet décrivant la catégorie associée à la question
    - language : Le code de langue (fr, en, it, etc.).
    - value : Le texte de la proposition dans la langue correspondante.

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse:
La méthode qui évalue des réponses renvoie un résultat sous la forme d'une valeur numérique.
Pour notre cas, on obtient une réponse de 0. Cela signifie que la réponse à la question est fausse.
Le curl que l'on envoit répond Colombie cependant la réponse attendu est Finlande avec l'id = 4. Si on met id = 4 alors on obtient une réponse de 1.

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse:
La valeur de la RSS utilisée par l'api quarkus en mode JVM est de : 210608 KB soit environ 210,6 MB.

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Time: 22.350903s
Size: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Time: 12.801599s
Size: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Time: 0.023343s
Size: 1 bytes

# Q8 : Empreinte mémoire en mode natif ?
Réponse:
La valeur de la RSS utilisée par l'API Quarkus en mode natif est 2268 KB soit environ 2,3 MB

# Q9: Temps et  taille  réponse   liste les questions
Time: 17.690825s
Size: 883 bytes

# Q10: Temps et  taille  réponse  liste des propositions
Time: 12.701349s
Size: 609 bytes

# Q11: Temps et  taille  réponse  évaluation les réponses
Time: 0.001944s
Size: 1 bytes

algorithmie / maniere dont les endpoints ça a été implémenté sur la liste des questions (faire moins lourds)

# Q12:  Proposition 1
Description: Optimisation de la méthode listProposals
Time: 45.921063s
Size: 2456 bytes

PS : Valeur un peu biaisés mais c'est de l'optimisation car on ne va pas récupérer la terre entière mais seulement ce qui nous intéresse.

# Q13:  Proposition 2
Description: Le champ question dans l’entité Proposal est actuellement configuré avec FetchType.EAGER. C'est un pb car ça va effectuer une requête supplémentair pour récupérer les données associées de l'entité Question.

Solution : On remplace FetchType.EAGER par FetchType.LAZY

Time: 43.874552s
Size: 2456 bytes

# Q14:  Proposition 3
Description: Actuellement, chaque entité (questions, propositions, catégories) est traduite dans toutes les langues spécifiées. Cela entraîne :
- Une surcharge inutile lorsque toutes les traductions ne sont pas nécessaires.
- Une augmentation du temps de traitement et des appels réseau.

Amélioration proposée :
- Optimiser le nombre de traductions effectuées en :
    - Traduisant uniquement dans les langues spécifiquement demandées
    - Réduisant les langues par défaut configurées dans application.properties

Pour nous, seulement le français est nécessaire. On a pas besoin de la partie traduction.
Time: 0.464554s
Size: 571 bytes

# Q15:  Proposition 4
Description: Actuellement, l'application exécute une nouvelle requête à chaque fois qu'un même endpoint est appelé, même si les données n'ont pas changé. Cela génère :
- Des appels inutiles à la base de données ou au service externe.
- Une augmentation du temps de réponse et de la charge réseau.

Amélioration proposée :
- Mettre en place un mécanisme de cache en mémoire pour stocker temporairement les réponses fréquemment demandées

Temps:
Taille: