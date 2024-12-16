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
    public List<Question> listAllQuestions(){
        List<Question> questions =  Question.listAll();
        return questions;
    }

    public Question loadQuestionById(Long questionId){
        Question q = Question.findById(questionId);
        return q;
    }


    public List<Proposal> listProposals(Long questionId){
        List<Proposal> proposals =  Proposal.listAll();
        List<Proposal> result = new ArrayList<>();
        for(Proposal currentProposal:proposals){
            if(currentProposal.id.equals(questionId)){
                result.add(currentProposal);
            }
        }
        return result;
    }


/*
public List<ProposalDto> listProposals(Long questionId) {
    // Charger uniquement les propositions correspondant à questionId
    List<Proposal> proposals = Proposal.find("question.id", questionId).list();

    // Traduire les propositions
    return translateService.translateProposals(proposals);
}
*/

    public Long evaluateProposals(List<Proposal> proposalsInput){
        List<Proposal> proposals =  Proposal.listAll();
        Long count =0L;
        for(Proposal currentProposal:proposals){
            for(Proposal currentProposalDto:proposalsInput){
                if(currentProposal.id.equals(currentProposalDto.id)){
                    if(currentProposal.correct) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}