package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class QuizzService {

    /**
     * Liste les questions avec pagination.
     * Retourne les données nécessaires pour les DTO.
     */
    public List<QuestionDto> listAllQuestions(int page, int size) {
        // Charger les questions paginées
        List<Question> questions = Question.find("SELECT q FROM Question q")
                                            .page(page, size)
                                            .list();

        // Convertir les questions en DTO
        return questions.stream()
                        .map(q -> new QuestionDto(q, "fr")) // Création d'un DTO en français
                        .collect(Collectors.toList());
    }

    /**
     * Charge une question par son ID.
     * Retourne un DTO correspondant.
     */
    public QuestionDto loadQuestionById(Long questionId) {
        Question question = Question.findById(questionId);
        if (question == null) {
            throw new IllegalArgumentException("Question introuvable avec l'ID : " + questionId);
        }

        return new QuestionDto(question, "fr");
    }

    /**
     * Liste les propositions associées à une question spécifique.
     * Retourne les données nécessaires pour les DTO.
     */
    public List<ProposalDto> listProposals(Long questionId) {
        // Charger uniquement les propositions liées à la question
        List<Proposal> proposals = Proposal.find("question.id", questionId).list();
    
        // Convertir les propositions en DTO
        return proposals.stream()
                        .map(p -> new ProposalDto(p, "fr"))
                        .collect(Collectors.toList());
    }
    

    /**
     * Évalue une liste de propositions fournies et retourne le nombre de réponses correctes.
     */
    public Long evaluateProposals(List<ProposalDto> proposalsInput) {
        if (proposalsInput == null || proposalsInput.isEmpty()) {
            return 0L; // Aucun input, aucune évaluation
        }
    
        // Extraire les IDs des propositions fournies
        List<Long> inputIds = proposalsInput.stream()
                                            .map(ProposalDto::getId)
                                            .collect(Collectors.toList());
    
        // Récupérer les propositions correspondantes en une seule requête
        List<Proposal> proposals = Proposal.find("id IN ?1", inputIds).list();
    
        // Compter les propositions correctes parmi celles récupérées
        return proposals.stream()
                        .filter(Proposal::isCorrect)
                        .count();
    }
    
}
