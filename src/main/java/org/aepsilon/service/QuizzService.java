package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.dto.TranslationDto;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;
import org.aepsilon.web.client.TranslateClient;
import org.aepsilon.web.client.TranslateRequest;
import org.aepsilon.web.client.TranslateResponse;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuizzService {

    @Inject
    TranslateService translateService;
    public List<QuestionDto> listAllQuestions(){
        List<Question> questions = Question.listAll();
        return translateService.translateQuestions(questions);
    }

    // Eco-conception: Version paginée pour éviter de charger toutes les données en mémoire
    public List<QuestionDto> listAllQuestionsPaginated(int page, int size){
        List<Question> questions = Question.findAllPaginated(page, size);
        return translateService.translateQuestions(questions);
    }

    public QuestionDto loadQuestionById(Long questionId){
        Question q = Question.findById(questionId);
        return translateService.translateOneQuestion(q);
    }

    public List<ProposalDto> listProposals(Long questionId){
        List<Proposal> proposals = Proposal.list("question.id", questionId);
        return translateService.translateProposals(proposals);
    }


    public Long evaluateProposals(List<ProposalDto> proposalsInput){
        if(proposalsInput == null || proposalsInput.isEmpty()) {
            return 0L;
        }
        
        List<Long> ids = proposalsInput.stream()
            .map(p -> p.id)
            .toList();
        
        // Requête optimisée: compte directement les propositions correctes parmi les IDs fournis
        return Proposal.count("id IN ?1 AND correct = true", ids);
    }

}
