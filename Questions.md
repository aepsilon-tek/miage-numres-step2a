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

# Q9: Temps et  taille  réponse   liste les questions
Temps:
Taille:

# Q10: Temps et  taille  réponse  liste des propositions
Temps:
Taille:

# Q11: Temps et  taille  réponse  évaluation les réponses
Temps:
Taille:

# Q12:  Proposition 1
Description:
Temps:
Taille:

# Q13:  Proposition 2
Description:
Temps:
Taille:

# Q14:  Proposition 3
Description:
Temps:
Taille:

# Q15:  Proposition 4
Description:
Temps:
Taille: