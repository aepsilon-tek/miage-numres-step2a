# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse:retourne une liste json de questions, chaque item contient un identifiant unique de la question, les traductions en plusieurs langues de la quesiton et la catégorie de la question 

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse:retourne les propositions (en plusieurs langues) d'une qestion spécifique

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse:retourne le score des réponses données aux question, on a eu 0 puisque les 2 réponses aux questions 1 et 2 son fausses

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse:180,92 Mo

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 26.918207s
Taille: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 11.994623s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.017259s
Taille: 1 bytes

# Q8 : Empreinte mémoire en mode natif ?
Réponse: 2,26 Mo

# Q9: Temps et  taille  réponse   liste les questions
Temps: 22.326824s
Taille: 883 bytes

# Q10: Temps et  taille  réponse  liste des propositions
Temps: 15.843726s
Taille: 609 bytes

# Q11: Temps et  taille  réponse  évaluation les réponses
Temps: 0.002009s
Taille: 1 bytes

# Q12:  Proposition 1
Description: Dans listPorposals, on fait un selectAll() alors qu'on peut retirer les propositions d'un question avec .find()
test: curl -w "\nTime: %{time_total}s\nSize: %{size_download} bytes\n" http://localhost:8080/quizz/questions/1/proposals
Temps: 11.134626s
Taille: 609 bytes

# Q13:  Proposition 2
Description: Ajouter la fonctionalité de cache d'hibernate
test: curl -w "\nTime: %{time_total}s\nSize: %{size_download} bytes\n" http://localhost:8080/quizz/questions/1/proposals
Temps: 11.305722s
Taille: 609 bytes

# Q14:  Proposition 3
Description:
Temps:
Taille:

# Q15:  Proposition 4
Description: 
Temps:
Taille: