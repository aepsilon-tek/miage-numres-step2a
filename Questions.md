# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse: Liste et retourne les questions traduites. Question qui ne possède qu'un string "label"

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse: Liste et retourne la proposition. Proposition qui possède un string "label" et un boolean "correct"

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse: Permet d'évaluer la réponse et voir si on a juste ou faux

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse: 191552 ko

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 4.903941s
Taille: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 2.312100s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.017565s
Taille: 1 byte

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
Description: Utiliser des projections DTO au lieu de charger les entités complètes pour réduire la quantité de données transférées entre la base de données et l'application
Temps: 0.089767s
Taille: 1 bytes

# Q13:  Proposition 2
Description: Implementer la pagination pour éviter de charger toutes les données en mémoire simultanément, particulièrement pour la liste des questions.
Temps: 3.530559s
Taille: 883 bytes

# Q14:  Proposition 3
Description: Optimiser la méthode listProposals() qui charge TOUTES les propositions puis filtre en mémoire. Remplacer par une requête ciblée directement en base de données. Implementation: Remplacé Proposal.listAll() + boucle for + ArrayList intermédiaire par Proposal.list("question.id", questionId) - Une seule requête SQL avec clause WHERE. Avant: O(n) en mémoire + création ArrayList inutile
Temps: 7.179254s
Taille: 2456 bytes

# Q15:  Proposition 4
Description: Corriger le bug dans listProposals() qui comparait proposal.id au lieu de question.id, ce qui retournait des résultats incorrects. Implementation: Le code original if(currentProposal.id.equals(questionId)) comparait l'ID de la proposition au questionId. Correction: utilisation de Proposal.list("question.id", questionId) qui filtre correctement sur l'ID de la question associée. Avant: Retournait la proposition ayant l'ID = questionId.
Temps: 6.913553s
Taille: 2456 bytes