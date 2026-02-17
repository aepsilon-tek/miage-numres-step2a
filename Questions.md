# Q1 : Décrire ce que renvoie la méthode qui liste les questions ?
Réponse : Une liste d’objets Question, chacun contenant un id, une liste de traductions (fr/en/it) et une catégorie elle-même traduite.

# Q2 : Décrire ce que renvoie la méthode qui liste les propositions d'une question ?
Réponse : Une liste de propositions associées à la question, chaque proposition ayant un id, des traductions multilingues et incluant l’objet Question complet auquel elle appartient.

# Q3 : Décrire ce que renvoie la méthode qui évalue des réponses ?
Réponse : Un entier représentant le résultat de l’évaluation (score ou nombre de bonnes réponses). Dans l’exemple fourni, la réponse est 0.

# Q4 : Quelle est la valeur de la RSS utilisée par l'api quarkus en mode JVM ?
Réponse: 190 852 kB (≈ 190 MB)

# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 3.993771s
Taille: 883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 1.645837s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps:  0.020844s
Taille: 1 bytes

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
# Q12:  Proposition 1
Description: Remplacement de la récupération de toute la table `Proposal` (Full Table Scan) suivi d'un filtrage en Java, par une requête SQL ciblée (`WHERE question_id = ?`). Cela évite de charger des données inutiles en mémoire RAM.

Temps: Avant: 2.99s / Après: ~0.05s (Gain de performance grâce à l'indexation BDD).

Taille: 609 bytes (La taille de la réponse HTTP reste identique pour l'instant, mais la quantité de données chargées depuis la BDD a été divisée par le nombre total de questions).

# Q13:  Proposition 2
Description: Remplacement d'une récupération complète des données suivie d'un algorithme de comparaison complexe en mémoire (double boucle for) par une requête d'agrégation SQL (`SELECT count(*)... WHERE id IN ...`). Le calcul de la note est délégué au moteur de base de données.

Temps: Avant: 0.43s / Après: 0.46s (Note : Sur un faible volume de données, les temps sont similaires, mais l'approche SQL garantit une scalabilité constante O(1) contrairement à l'approche mémoire O(N)).

Taille: 1 byte (La réponse HTTP est identique, mais le volume de données transféré entre la BDD et le serveur est passé de "toute la table" à "un seul entier").

# Q14:  Proposition 3
Description: Passage des relations Hibernate en `LAZY` et suppression de l'inclusion récursive de l'objet `Question` dans les DTOs de `Proposal`. Cela élimine le problème de "N+1 Selects" et supprime les appels redondants au service de traduction externe pour la question parente.

Temps: Avant: 8.28s / Après: 0.54s (Accélération massive due à la réduction des requêtes BDD et surtout à la suppression des appels API de traduction inutiles).

Taille: Avant: 2456 bytes / Après: 319 bytes (Division par 8 du volume de données transféré au client).

# Q15:  Proposition 4
Description: Mise en place de l'extension `quarkus-cache` et annotation `@CacheResult` sur les appels au service de traduction. Les traductions (données statiques) sont stockées en mémoire RAM après le premier appel.

Temps: Avant (ou 1er appel): 3.12s / Après (cache actif): 0.005s. Le temps de réponse devient négligeable.

Taille: 883 bytes (La taille de la réponse HTTP ne change pas, mais le volume de données échangé avec l'API tierce passe à 0 octet pour les appels suivants).