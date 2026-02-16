# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse:
la méthode http://localhost:8080/quizz/questions retourne un tableau JSON de questions avec les attributs "id":1 , "translations" qui retourne une liste de traductions en fr, en, it, puis "catgory"
# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse:
la méthode http://localhost:8080/quizz/questions/1/proposals  retourne un tableau JSON avec "id", "translations", puis "question" avec son id , et une liste de "translations" et sa "catgory
# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse:
la méthode http://localhost:8080/quizz/proposals/evaluate renvoie 0 qui doit etre le score de l'évaluation (basé sur la compatibilité entre les proposals  - proposal.id.equals)
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