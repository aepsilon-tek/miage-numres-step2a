package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;


import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuizzService {

    @Inject
    TranslateService translateService;
    public List<Question> listAllQuestions(){
        return Question.listAll();
    }

    public Question loadQuestionById(Long questionId){
        return Question.findById(questionId);
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


    public Long evaluateProposals(List<Proposal> proposalsInput){
        List<Proposal> proposals =  Proposal.listAll();
        Long count =0L;
        for(Proposal currentProposal:proposals){
            for(Proposal currentProposalt:proposalsInput){
                if(currentProposal.id.equals(currentProposalt.id)){
                    if(currentProposal.correct) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
