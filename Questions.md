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
ps -e -o pid,rss,args | grep quarkus-run retourne :
  19500 192092 java -jar target/quarkus-app/quarkus-run.jar
  19616  2304 grep quarkus-run

  la la valeur de la RSS est de 192092kb soit 192.092mb
# Q5: Quel est le temps et la taille de la réponse  de la méthode qui liste les questions
Temps: 5.385131s
Taille:  883 bytes

# Q6: Quel est le temps et la taille de la réponse  de la méthode qui liste les propositions d'une question
Temps: 2.562641s
Taille: 609 bytes

# Q7: Quel est le temps et la taille de la réponse  de la méthode qui évalue les réponses
Temps: 0.019603s
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
Description: /quizz/questions/1/proposals renvoie une proposition + la question complète à l’intérieur, on peut profiter du dto ProposalDto pour modifier la question avec un champ plus léger
Dans ProposalDto on a maitnenant public Long questionId;
dans QuizzService on a uniqumeent  List<Proposal> result = Proposal.find("question.id", questionId).list();


Temps: 1.164119s
Taille: 616 bytes

# Q13:  Proposition 2
Description: La traduction est appelée à chaque requête et pour chaque entité, alors que le client demande une applicaiton en frnaçais, donc nous avons des traductions redondantes, en plus dans listAllQuestions() on a List<Question> questions = Question.listAll();
De plus on a aussi la traduction automatique dans /proposals
Je supprime donc les boucles dans TranslateOneQuestion, TranslateOneCategory, TranslateOneProposal

pour /Questions
Temps: 2.581848s
Taille: 558 bytes

pour /Proposals
Time: 0.792420s
Size: 315 bytes

# Q14:  Proposition 3
Description: la méthode evaluateProposals() charge toute la table proposal et donc inutilement des colonnes non utilisées.
J'ai modifié la méthode pour ne charger que les IDs
Time: 0.006049s
Size: 1 bytes

# Q15:  Proposition 4
Description: Passer de Fetch EAGER à LAZY dans Proposal et Question, parceque Hibernate va aussi charger Question Category, alors que dans evaluateProposals on a besoinunqiuement de p.correct

/Questions :
Time: 0.021165s
Size: 380 bytes

proposals
Temps: 0.680424s
Taille: 315 bytes 