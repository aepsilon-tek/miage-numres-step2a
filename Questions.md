# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse: elle renvoient la liste de toutes les questions traduites dans le language choisi.

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse: elles renvoient la liste de toutes les propositions dans toutes les langues de cette question là.

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse: La méthode retourne un entier de type Long qui représente le nombre de réponses correctes. Une réponse est correcte si son ID correspond à une proposition en base de données dont l’attribut correct est vrai.

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse: 219732

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 18.864109s
Taille: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 13.098015s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.018084s
Taille: 1 bytes

# Q8 : Empreinte mémoire en mode natif ?
Réponse: 100220

# Q9: Temps et  taille  réponse   liste les questions
Temps: 17.750545s
Taille: 883 bytes

# Q10: Temps et  taille  réponse  liste des propositions
Temps: 11.319397s
Taille: 609 bytes

# Q11: Temps et  taille  réponse  évaluation les réponses
Temps: 0.001832s
Taille: 1 bytes

# Q12:  Proposition 1
Description: la méthode listProposals parcours toute les propositions alors qu'elle peut récupérer directement les propositions en fonction de l'id de la question.
Temps: 8.780450s
Taille: 609 bytes

# Q13:  Proposition 2
Description: pour translate service on a du code qui est dupliqué on peut faire une méthode pour éviter le duplication de code.
Temps: 11.784000
Taille: 609 bytes

# Q14:  Proposition 3
Description: Mettre les données en cache.
Temps:
Taille:

# Q15:  Proposition 4
Description: Supprimer les imports inutilisés 
Temps:0.001632s
Taille:1 bytes
![alt text](image.png)