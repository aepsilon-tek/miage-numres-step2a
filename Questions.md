# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse: La méthode renvoie une liste JSON où chaque entrée contient un id, translations, catgory 

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse:  La méthode renvoie une liste JSON où chaque entrée contient un id, translations et question 

# Q3 : Que renvoie la méthode d'évaluation des réponses ?
Réponse: evaluate(...) renvoir un nombre qui est le nombre total de propositions soumises qui sont correctes

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse: 219764 KB (219.76 MB)

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 3.379196s
Taille: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 2.073035s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.021206s
Taille: 1 bytes

# Q8 : Empreinte mémoire en mode natif ? - mode natif ne s'execute pas
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

# Q12:  Proposition 1 :
Description: 
Ajouter la méthode "listProposals" qui va récuperer toutes les propositions avec listAll() 

Solution: utiliser une requête filtrée pour récupérer uniquement les propositions concernant la question au niveau de la BD.
Ca permet de Réduire la consommation mémoire, requête BD plus efficace, moins de données transférées.

Taille avant: 609 bytes 
Temps après: 1.976666s
Taille après: 2456 bytes

# Q13:  Proposition 2 :
Description:
La méthode evaluateProposals() récupère TOUTES les propositions avec listAll() 
et les compare avec les propositions en entrée via deux boucle. Cela est très inefficace 
en mémoire et CPU. Solution: tout dabord extraire les IDs des propositions en entrée puis utiliser une requête pour récupérer uniquement les pertinentes et finalement construire une HashMap pour lookup.

Temps avant: 0.021206s (avec cache)
Taille avant: 1 bytes
Temps après: 0.008102s (sans cache initiale), 0.016210s (avec cache)
Taille après: 1 bytes
Amélioration: plus rapide

# Q14:  Proposition 3 
Description:
BUGS et problèmes identifiés:
 La méthode translateOneProposal() appelle translateOneQuestion() à la fin, qui prend du temps et Les traductions identiques sont répétées 2+ fois sans être réutilisées
Solution: 
Ajouter des Maps en cache (translationCache, categoryCache, questionCache) au niveau service
Aussi avant appel réseau, vérifier le cache d'abord
Réutiliser les questions/catégories déjà traduites dans translateProposals()

Temps avant (listAllQuestions): 4.466735s
Taille avant: 883 bytes
Temps après (listAllQuestions): 3.217063s
Taille après: 883 bytes
Amélioration: plus rapide

# Q15:  Proposition 4 - Ajouter pagination listAllQuestions
Description: 
Temps: 
Taille: