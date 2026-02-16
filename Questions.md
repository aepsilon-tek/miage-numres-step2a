# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse:
[{"id":1,"translations":[{"language":"fr","value":"Quel est le pays le plus grand consommateur de café par habitant ?"},{"language":"en","value":"Which country is the largest per capita coffee consumer?"},{"language":"it","value":"Quale paese è il più grande consumatore di caffè pro capite?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}},{"id":2,"translations":[{"language":"fr","value":"Quel animal est le plus dangereux pour l’Homme ?"},{"language":"en","value":"Which animal is the most dangerous for man?"},{"language":"it","value":"Quale animale è il più pericoloso per l'uomo?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}}]

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse:

[{"id":1,"translations":[{"language":"fr","value":"Brésil"},{"language":"en","value":"Brazil"},{"language":"it","value":"Brasile"}],"question":{"id":1,"translations":[{"language":"fr","value":"Quel est le pays le plus grand consommateur de café par habitant ?"},{"language":"en","value":"Which country is the largest per capita coffee consumer?"},{"language":"it","value":"Quale paese è il più grande consumatore di caffè pro capite?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}}}]

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse:

La méthode évalue une liste de réponses (proposalsInput) et renvoie le nombre de réponses correctes.

Autrement dit, elle compte combien de propositions soumises correspondent à celles de la base et sont correctes, et retourne ce nombre.

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse:
194 Mo

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 5.6 secondes
Taille: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 2.7 secondes
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.0206 seconde
Taille: 1 byte

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
Limiter la quantité de données renvoyées par l’API /quizz/questions en ne récupérant que les champs nécessaires (id et value) plutôt que toutes les traductions et la catégorie.

Temps: 5.6 secondes -> 4.9 secondes
Taille: 883 bytes -> 883 bytes

# Q13:  Proposition 2
Description:
Mettre un cache simple pour les propositions afin de ne pas relire la base de données à chaque requête.

Temps: 2.7 secondes -> 2.7 secondes (1ère fois donc inchangé) ->1.9 seconde (deuxième fois)
Taille: 609 bytes -> 609 bytes -> 609 bytes

# Q14:  Proposition 3
Description:
Simplifier l’évaluation des réponses en supprimant les boucles inutiles et les transformations intermédiaires.

Temps: 0.0206 seconde -> 0.009596s
Taille: 1 byte -> 1 byte


# Q15:  Proposition 4
Description:
Désactiver le logging SQL détaillé en mode dev pour réduire l’empreinte mémoire et le bruit dans les logs.

Temps: un peu moins
Taille: inchangée