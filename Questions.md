# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse:La méthode qui liste les questions renvoie un ensemble de questions récupérées depuis la base de données. Chaque question contient des informations telles que son id, son CATEGORY_ID , et son label

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
Réponse:La mémoire RSS utilisée par l'API Quarkus en mode JVM est 225,9 Mo.

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps de la réponse :Le temps total de la réponse de la méthode qui liste les questions est 27,352061 secondes.

Taille de la réponse :La taille de la réponse est 883 octets.

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps : 8,635514 secondes.
Taille : 609 octets.
# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps : 0,017867 secondes.
Taille : 1 octet.


# Q8 : Empreinte mémoire en mode natif ?
reponse : 2.2 MB

# Q9: Temps et  taille  réponse   liste les questions
Temps : 18,861605 secondes
Taille : 883 octets
# Q10: Temps et  taille  réponse  liste des propositions
Temps : 11,280289 secondes
Taille : 609 octets

# Q11: Temps et  taille  réponse  évaluation les réponses
Temps : 0,001944 secondes
Taille : 1 octet

# Q12:  Proposition 1 :Réduction des champs inutiles dans la méthode qui liste les questions
Description:
- La méthode retourne toutes les relations (translations, category), ce qui alourdit la taille de la réponse et augmente le temps de traitement.
- Pas de pagination pour limiter le volume de données.

Solution proposée :
   - Modifier la requête pour ne retourner que les champs nécessaires (`id` et `label`).
   - Ajouter une pagination pour limiter le nombre de questions retournées à chaque appel.
   
Temps: 1.835569s
Taille:2748 bytes

# Q13:  Proposition 2 Optimisation via le Cache côté serveur
Description:
L'API qui liste les questions est fréquemment appelée et, si les données changent rarement, une mise en cache des résultats peut réduire considérablement :
    -Le temps de réponse : Les données sont servies directement depuis le cache.
    -La charge sur la base de données : Réduit les appels inutiles.
Temps:
Taille:

# Q14:  Proposition 3 Amélioration de la méthode evaluateProposals
Description:La méthode actuelle charge toutes les propositions en mémoire via Proposal.listAll(), ce qui est inefficace pour des bases de données volumineuses.
Elle utilise des boucles imbriquées pour comparer les propositions, ce qui ralentit les performances.

Solution : 
-Charger uniquement les propositions nécessaires en filtrant directement via une requête SQL (id IN ?1).
-Éliminer les boucles imbriquées pour améliorer la lisibilité et les performances.

Temps:
Taille:

# Q15:  Proposition 4 Éliminer la partie translate
Description:Actuellement, le service effectue des traductions via un client externe (TranslateService) pour répondre dans plusieurs langues.
Si le besoin est exclusivement un quiz en français, cette fonctionnalité est inutile et alourdit les performances avec des appels REST externes.
En éliminant les traductions, on simplifie le code et réduit les dépendances.
Temps:
Taille: