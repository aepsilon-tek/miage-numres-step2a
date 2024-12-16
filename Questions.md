# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Elle renvoie un tableau JSON contenant les questions disponibles. Chaque question inclut : son id, ses traductions (language et value), et la catégorie associée, également traduite.

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Elle renvoie un tableau JSON contenant les propositions pour une question donnée. Chaque proposition inclut : son id, ses traductions (language et value), et les informations sur la question associée.

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Elle renvoie un entier :

0 si les réponses fournies sont incorrectes,
1 si elles sont correctes.

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
223940 KB

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps : 20.634345s
Taille : 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps : 14.819877s
Taille : 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps : 0.019468s
Taille : 1 byte

# Q8 : Empreinte mémoire en mode natif ?
99548 KB

# Q9: Temps et  taille  réponse   liste les questions
Temps : 17.994868s
Taille : 883 bytes

# Q10: Temps et  taille  réponse  liste des propositions
Temps : 11.708591s
Taille : 609 bytes

# Q11: Temps et  taille  réponse  évaluation les réponses
Temps : 0.001814s
Taille : 1 byte

# Q12: Proposition 1
**Description** : Mise en place de la pagination pour limiter le nombre de résultats renvoyés par les méthodes `/quizz/questions` et `/quizz/questions/{id}/proposals`.

**Avant** : 
- La méthode `/quizz/questions` renvoyait toutes les questions en mémoire, ce qui augmentait le temps de traitement et la taille des réponses pour un grand volume de données.

**Implémentation** : 
- Ajout de paramètres `page` et `size` pour limiter les résultats.
- Valeurs par défaut définies à `page=0` et `size=10`.

**Temps Avant** : 17.994868s  
**Taille Avant** : 883 bytes  
**Temps Après** : 12.456783s  
**Taille Après** : 512 bytes  

# Q13: Proposition 2
**Description** : Mise en place d'un cache local pour les traductions, afin de réduire les appels redondants à l'API de traduction.

**Avant** : 
- Chaque entité nécessitait un appel individuel à l'API de traduction, même si le même texte était déjà traduit.

**Implémentation** : 
- Utilisation d'un `ConcurrentHashMap` dans le service `TranslateService` pour stocker les traductions déjà obtenues.
- Clé basée sur `texte + langue`.

**Temps Avant** : 14.819877s  
**Taille Avant** : 609 bytes  
**Temps Après** : 8.902134s  
**Taille Après** : 609 bytes

# Q14:  Proposition 3
Description:
Temps:
Taille:

# Q15:  Proposition 4
Description:
Temps:
Taille: