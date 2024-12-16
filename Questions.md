# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse:La méthode qui liste les questions renvoie un ensemble de questions récupérées depuis la base de données. Chaque question contient des informations telles que son id, son CATEGORY_ID (la catégorie à laquelle elle appartient), et son label

[{"id":1,"translations":[{"language":"fr","value":"Quel est le pays le plus grand consommateur de café par habitant ?"},{"language":"en","value":"Which country is the largest per capita coffee consumer?"},{"language":"it","value":"Quale paese è il più grande consumatore di caffè pro capite?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}},{"id":2,"translations":[{"language":"fr","value":"Quel animal est le plus dangereux pour l’Homme ?"},{"language":"en","value":"Which animal is the most dangerous for man?"},{"language":"it","value":"Quale animale è il più pericoloso per l'uomo?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}}]
# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse:La méthode qui liste les propositions pour une question spécifique renvoie une liste des propositions liées à cette question. Chaque proposition contient des informations telles que :

    -id : Identifiant de la proposition.
    -correct : Indicateur booléen indiquant si la proposition est correcte ou non.
    -label : Le texte de la proposition.
    -QUESTION_ID : L'identifiant de la question à laquelle elle est associée.


[{"id":1,"translations":[{"language":"fr","value":"Brésil"},{"language":"en","value":"Brazil"},{"language":"it","value":"Brasile"}],"question":{"id":1,"translations":[{"language":"fr","value":"Quel est le pays le plus grand consommateur de café par habitant ?"},{"language":"en","value":"Which country is the largest per capita coffee consumer?"},{"language":"it","value":"Quale paese è il più grande consumatore di caffè pro capite?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}}}]

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Reponse :La méthode evaluate renvoie une liste indiquant si chaque proposition soumise est correcte (true) ou incorrecte (false).

gitpod /workspace/miage-numres-step2a (main) $ curl -w "\n" http://localhost:8080/quizz/proposals/evaluate  -H 'accept: application/json'  -H 'content-type: application/json; charset=UTF-8' --data-raw '[{"id":1},{"id":2}]' ~
0
# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse:

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps:
Taille:

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps:
Taille:

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps:
Taille:

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