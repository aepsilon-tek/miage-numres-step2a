# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse: Une liste de questions avec leurs traductions (fr, en, it) et la categorie traduite

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse: Une liste de propositions pour la question, avec traductions et la question associee qui est aussi traduite

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse: Un entier correspondant au nombre de propositions correctes parmi celles envoyees

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse: 191536 KB

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 7.400178s
Taille: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 2.592147s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.018968s
Taille: 1 bytes

# Q8 : Empreinte mémoire en mode natif ?
Réponse: La compilation native échoue systématiquement (exit status 143) même en limitant la mémoire GraalVM via quarkus.native.native-image-xmx=2g


# Q9: Temps et  taille  réponse   liste les questions NA
Temps:
Taille:

# Q10: Temps et  taille  réponse  liste des propositions NA
Temps:
Taille:

# Q11: Temps et  taille  réponse  évaluation les réponses NA 
Temps:
Taille:

# Q12:  Proposition 1
Description: On va filtrer les propositions dans la base de données qui filtre directement sur question.id pour eviter de charger toute la table
Temps: 7.999915s
Taille: 2456 bytes

# Q13:  Proposition 2
Description: On enleve les boucles imbriquees et on envoie la liste des ids a la base de donnees pour compter directement combien de propositions sont correctes sans charger toutes les propositions en memoire 
Temps: 2.127872s
Taille: 1 bytes

# Q14:  Proposition 3
Description: On va mettre en cache les traductions (source/target/texte) pour eviter de faire des appels HTTP repetes.
Temps:5.391747s
Taille:883 bytes

# Q15:  Proposition 4
Description:
Temps:
Taille: