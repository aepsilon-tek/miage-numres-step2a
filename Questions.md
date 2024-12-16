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
La valeur RSS utilisée par l’API Quarkus en mode JVM est de 213168 Ko, soit environ 208 Mo.

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 19.274039s
Taille: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 15.338581s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.021181s
Taille: 1 bytes

# Q8 : Empreinte mémoire en mode natif ?
Réponse:
Mémoire physique utilisée (RSS) :
	- 2324 Ko ≈ 2 Mo

# Q9: Temps et  taille  réponse   liste les questions
Temps: 15.476267s
Taille: 883 bytes

# Q10: Temps et  taille  réponse  liste des propositions
Temps: 11.282712s
Taille: 609 bytes

# Q11: Temps et  taille  réponse  évaluation les réponses
Temps: 0.002021s
Taille: 1 bytes

# Q12:  Proposition 1
Description: améliorer la vitesse de renvoie des propositions des questions
Proposal.listAll() récupère toutes les propositions de la base de données, même si on n’a besoin que de celles correspondant au questionId.
Avec notre modification, on filtre maintenant la requete SQL par questionId et on récupère uniquement les propositions liées à la question, ce qui améliore la vitesse d'éxécution.
Temps: 46.554758s
Taille: 2456 bytes

# Q13:  Proposition 2
Description: On peut essayer de mettre en cache les réponses aux questions pour appeler les éléments plus tard lorsque c'est nécessaire, cela évite des appels multiples et redondants à la base.

# Q14:  Proposition 3
Description: On peut aussi mettre des indexes dans notre base de données pour avoir des accès plus rapides aux données.

# Q15:  Proposition 4
Description: Mieux chalenger les besoins vu que le client demande une application en français alors que nous avons ici des traductions.
Après les tests, les temps d'éxécutions sont beaucoup plus rapides. On a plus besoin des types "Dto" car il s'agit des traductions.
Les questions s'affichent en 0.379103s, les propositions en 0.085595s avec ces modifications.