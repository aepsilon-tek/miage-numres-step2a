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

    public QuestionDto loadQuestionById(Long questionId){
        Question q = Question.findById(questionId);
        return translateService.translateOneQuestion(q);
    }

    /* public List<ProposalDto> listProposals(Long questionId){
        List<Proposal> proposals =  Proposal.listAll();
        List<Proposal> result = new ArrayList<>();
        for(Proposal currentProposal:proposals){
            if(currentProposal.id.equals(questionId)){
                result.add(currentProposal);
            }
        }
        return translateService.translateProposals(result);
    } */

         public List<ProposalDto> listProposals(Long questionId){
        // MODIFICATION : Utilisation de la méthode list de Panache avec une requête filtrée
        // On ne récupère que les propositions liées à la question donnée.
        List<Proposal> proposals = Proposal.list("question.id", questionId);
        
        // Plus besoin de la boucle de filtrage manuel ni de l'ArrayList intermédiaire
        return translateService.translateProposals(proposals);
    } 


    /* public Long evaluateProposals(List<ProposalDto> proposalsInput){
        List<Proposal> proposals =  Proposal.listAll();
        Long count =0L;
        for(Proposal currentProposal:proposals){
            for(ProposalDto currentProposalDto:proposalsInput){
                if(currentProposal.id.equals(currentProposalDto.id)){
                    if(currentProposal.correct) {
                        count++;
                    }
                }
            }
        }

        return count;
    } */

public Long evaluateProposals(List<ProposalDto> proposalsInput){
    if (proposalsInput == null || proposalsInput.isEmpty()) return 0L;
    List<Long> ids = new ArrayList<>();
    for (ProposalDto p : proposalsInput) ids.add(p.id);
    // Optimisation :
    return Proposal.count("id in ?1 and correct = true", ids);
}

}
