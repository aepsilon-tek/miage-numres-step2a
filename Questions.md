# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse: 

Chaque question contient :
	- id : Identifiant unique de la question.
	- translations : Traductions de la question (fr, en, it).
	- category : La catégorie à laquelle la question appartient, avec son nom traduit.

Voici ce qui est renvoyé :

[
   {
      "id":1,
      "translations":[
         {
            "language":"fr",
            "value":"Quel est le pays le plus grand consommateur de café par habitant ?"
         },
         {
            "language":"en",
            "value":"Which country is the largest per capita coffee consumer?"
         },
         {
            "language":"it",
            "value":"Quale paese è il più grande consumatore di caffè pro capite?"
         }
      ],
      "catgory":{
         "translations":[
            {
               "language":"fr",
               "value":"Culture Générale"
            },
            {
               "language":"en",
               "value":"General Culture"
            },
            {
               "language":"it",
               "value":"Cultura generale"
            }
         ]
      }
   },
   {
      "id":2,
      "translations":[
         {
            "language":"fr",
            "value":"Quel animal est le plus dangereux pour l’Homme ?"
         },
         {
            "language":"en",
            "value":"Which animal is the most dangerous for man?"
         },
         {
            "language":"it",
            "value":"Quale animale è il più pericoloso per l'uomo?"
         }
      ],
      "catgory":{
         "translations":[
            {
               "language":"fr",
               "value":"Culture Générale"
            },
            {
               "language":"en",
               "value":"General Culture"
            },
            {
               "language":"it",
               "value":"Cultura generale"
            }
         ]
      }
   }
]

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse:

Chaque élément contient :
	- id : Identifiant unique de la réponse.
	- translations : Traductions de la réponse dans différentes langues (fr, en, it).
	- question : L’objet question associé à cette réponse, avec :
	- id : Identifiant de la question.
	- translations : Traductions de la question en plusieurs langues (fr, en, it).
	- category : La catégorie à laquelle appartient la question, également traduite (fr, en, it).

Voici ce qui est renvoyé :

[
   {
      "id":1,
      "translations":[
         {
            "language":"fr",
            "value":"Brésil"
         },
         {
            "language":"en",
            "value":"Brazil"
         },
         {
            "language":"it",
            "value":"Brasile"
         }
      ],
      "question":{
         "id":1,
         "translations":[
            {
               "language":"fr",
               "value":"Quel est le pays le plus grand consommateur de café par habitant ?"
            },
            {
               "language":"en",
               "value":"Which country is the largest per capita coffee consumer?"
            },
            {
               "language":"it",
               "value":"Quale paese è il più grande consumatore di caffè pro capite?"
            }
         ],
         "catgory":{
            "translations":[
               {
                  "language":"fr",
                  "value":"Culture Générale"
               },
               {
                  "language":"en",
                  "value":"General Culture"
               },
               {
                  "language":"it",
                  "value":"Cultura generale"
               }
            ]
         }
      }
   }
]

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse: 
La méthode renvoie 0. 
Je pense que cela signifie que la réponse aux questions sont incorrectes.

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