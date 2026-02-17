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
        List<Question> questions =  Question.listAll();
        return translateService.translateQuestions(questions);
    }
    
    public List<QuestionDto> listAllQuestions(int page, int size){
        // Optimisation éco-conception : pagination pour réduire mémoire et taille réponse
        // Utiliser une requête paginée au niveau DB
        long offset = (long) page * size;
        List<Question> questions = Question.find("").range((int)offset, (int)(offset + size)).list();
        return translateService.translateQuestions(questions);
    }

    public QuestionDto loadQuestionById(Long questionId){
        Question q = Question.findById(questionId);
        return translateService.translateOneQuestion(q);
    }

    public List<ProposalDto> listProposals(Long questionId){
        List<Proposal> result = Proposal.find("question.id", questionId).list();
        return translateService.translateProposals(result);
    }


    public Long evaluateProposals(List<ProposalDto> proposalsInput){
        List<Long> proposalIds = proposalsInput.stream()
                .map(p -> p.id)
                .collect(java.util.stream.Collectors.toList());
        
        if(proposalIds.isEmpty()) {
            return 0L;
        }
        
        List<Proposal> proposals = Proposal.find("id IN ?1", proposalIds).list();
        
        java.util.Map<Long, Proposal> proposalMap = proposals.stream()
                .collect(java.util.stream.Collectors.toMap(p -> p.id, p -> p));
        
        Long count = 0L;
        for(ProposalDto currentProposalDto : proposalsInput){
            Proposal proposal = proposalMap.get(currentProposalDto.id);
            if(proposal != null && proposal.correct) {
                count++;
            }
        }

        return count;
    }

}
