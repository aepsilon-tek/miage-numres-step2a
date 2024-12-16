# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse:

[{"id":1,"translations":[{"language":"fr","value":"Quel est le pays le plus grand consommateur de café par habitant ?"},{"language":"en","value":"Which country is the largest per capita coffee consumer?"},{"language":"it","value":"Quale paese è il più grande consumatore di caffè pro capite?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}},{"id":2,"translations":[{"language":"fr","value":"Quel animal est le plus dangereux pour l’Homme ?"},{"language":"en","value":"Which animal is the most dangerous for man?"},{"language":"it","value":"Quale animale è il più pericoloso per l'uomo?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}}]

La méthode renvoie une liste de questions, chacune identifiée par un id unique, avec leurs traductions dans plusieurs langues (français, anglais, italien). Chaque question est associée à une catégorie également traduite dans ces langues. Par exemple, une question sur le plus grand consommateur de café ou l'animal le plus dangereux pour l'Homme est classée dans la catégorie Culture Générale (traduit en General Culture et Cultura Generale).

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse:

[{"id":1,"translations":[{"language":"fr","value":"Brésil"},{"language":"en","value":"Brazil"},{"language":"it","value":"Brasile"}],"question":{"id":1,"translations":[{"language":"fr","value":"Quel est le pays le plus grand consommateur de café par habitant ?"},{"language":"en","value":"Which country is the largest per capita coffee consumer?"},{"language":"it","value":"Quale paese è il più grande consumatore di caffè pro capite?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}}}]

La méthode renvoie une liste de propositions associées à une question donnée. Chaque proposition contient des traductions dans différentes langues (français, anglais, italien). La question elle-même est incluse avec ses traductions ainsi que sa catégorie traduite. Par exemple, pour la question Quel est le pays le plus grand consommateur de café par habitant ?, une proposition possible est Brésil (traduit en Brazil et Brasile).

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse:

la méthode renvoie "0".

Elle prend en entrée des identifiants de réponses (ex. {"id":1} et {"id":2}) et retourne un résultat numérique, ici "0" veut signifier qu'aucune des réponses soumises sont correctes.

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse:

    9811 214448 java -jar target/quarkus-app/quarkus-run.jar
    10006  2308 grep --color=auto quarkus-run

214 KB

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 20.630939s
Taille: 883 bytes


# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 11.428506s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.055146s
Taille: 1 bytes 

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