# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse: La méthode `listAllQuestions` renvoie une liste de `QuestionDto` contenant les questions disponibles. Chaque question inclut des traductions dans différentes langues et une catégorie également traduite.

 [{"id":1,"translations":[{"language":"fr","value":"Quel est le pays le plus grand consommateur de café par habitant ?"},{"language":"en","value":"Which country is the largest per capita coffee consumer?"},{"language":"it","value":"Quale paese è il più grande consumatore di caffè pro capite?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}},{"id":2,"translations":[{"language":"fr","value":"Quel animal est le plus dangereux pour l’Homme ?"},{"language":"en","value":"Which animal is the most dangerous for man?"},{"language":"it","value":"Quale animale è il più pericoloso per l'uomo?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}}]

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse: La méthode `listProposals` renvoie une liste de `ProposalDto` pour une question donnée. Chaque proposition inclut des traductions dans différentes langues et une référence à la question correspondante.

[{"id":1,"translations":[{"language":"fr","value":"Brésil"},{"language":"en","value":"Brazil"},{"language":"it","value":"Brasile"}],"question":{"id":1,"translations":[{"language":"fr","value":"Quel est le pays le plus grand consommateur de café par habitant ?"},{"language":"en","value":"Which country is the largest per capita coffee consumer?"},{"language":"it","value":"Quale paese è il più grande consumatore di caffè pro capite?"}],"catgory":{"translations":[{"language":"fr","value":"Culture Générale"},{"language":"en","value":"General Culture"},{"language":"it","value":"Cultura generale"}]}}}]

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse: La méthode `evaluateProposals` renvoie un nombre (`Long`) représentant le nombre de propositions correctes parmi celles fournies en entrée.

0

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse: 222648 KB (environ 217 MB)

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 18.948450s
Taille: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 13.261755s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.016736s 
Taille: 1 byte

# Q8 : Empreinte mémoire en mode natif ?
Réponse: 2248 KB (environ 2.2 MB)

# Q9: Temps et  taille  réponse   liste les questions
Temps: 18.807569s
Taille: 883 bytes

# Q10: Temps et  taille  réponse  liste des propositions
Temps: 12.738600s
Taille: 609 bytes

# Q11: Temps et  taille  réponse  évaluation les réponses
Temps: 0.002121s
Taille: 1 byte

# Q12:  Proposition 1
Description: Optimiser la methode `listProposals` en utilisant un filtre SQL au lieu d'un filtre Java, mais aussi en enlevant la création de liste non nécéssaire et d'utiliser directement la requete avec la condition WHERE.
Temps: 5.123s (vs 13.261755s)
Taille: 609 bytes

# Q13:  Proposition 2
Description: Optimiser evaluateProposals avec requête SQL directe :
- Remplacement double boucle par requête SQL IN
- Utilisation du count natif
- Réduction charge mémoire
Temps: 0.001523s (vs 0.016736s)
Taille: 1 byte (vs 1 byte)

# Q14:  Proposition 3
Description: Enlever tous les imports et variables inutiles
Temps: negligible
Taille: negligible

# Q15:  Proposition 4
Optimize the translation service by implementing caching for translations to reduce API calls :
- Add caching annotations to TranslateService
- Cache translated values using question/proposal IDs as keys
- Configure cache timeouts in application.properties
Temps: 0.842s (vs 18.948450s)
Taille: 883 bytes (vs 883 bytes)

# Q16:  Proposition 5
Description: Remove the translation system since the quiz is already in French :
1. Remove unused translation-related code and dependencies:
- Remove TranslateService
- Remove TranslateClient
- Remove translation configuration from application.properties
2. Simplify DTOs to work with direct labels instead of translations:
- Update QuestionDto
- Update ProposalDto
- Remove TranslationDto
Temps: 0.19s (vs 18.948450s)
Taille: 704 bytes (vs 883 bytes) pour proposales