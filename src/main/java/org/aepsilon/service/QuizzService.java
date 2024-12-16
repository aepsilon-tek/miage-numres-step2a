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


    public List<QuestionDto> listAllQuestions(int page, int size) {
   
        List<Question> questions = Question.find("SELECT q FROM Question q")
                                            .page(page, size)
                                            .list();

        return questions.stream()
                        .map(q -> new QuestionDto(q, "fr")) // Création d'un DTO en français
                        .collect(Collectors.toList());
    }

 
    public QuestionDto loadQuestionById(Long questionId) {
        Question question = Question.findById(questionId);
        if (question == null) {
            throw new IllegalArgumentException("Question introuvable avec l'ID : " + questionId);
        }

        return new QuestionDto(question, "fr");
    }

    public List<ProposalDto> listProposals(Long questionId) {
       
        List<Proposal> proposals = Proposal.find("question.id", questionId).list();
    
        
        return proposals.stream()
                        .map(p -> new ProposalDto(p, "fr"))
                        .collect(Collectors.toList());
    }
    


    public Long evaluateProposals(List<ProposalDto> proposalsInput) {
        if (proposalsInput == null || proposalsInput.isEmpty()) {
            return 0L; 
        }
    
        List<Long> inputIds = proposalsInput.stream()
                                            .map(ProposalDto::getId)
                                            .collect(Collectors.toList());
    
        List<Proposal> proposals = Proposal.find("id IN ?1", inputIds).list();
    
        return proposals.stream()
                        .filter(Proposal::isCorrect)
                        .count();
    }
    
}
