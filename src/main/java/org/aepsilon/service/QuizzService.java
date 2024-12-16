package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;
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

    /*public List<ProposalDto> listProposals(Long questionId){
        List<Proposal> proposals =  Proposal.listAll();
        List<Proposal> result = new ArrayList<>();
        for(Proposal currentProposal:proposals){
            if(currentProposal.id.equals(questionId)){
                result.add(currentProposal);
            }
        }
        return translateService.translateProposals(result);
    }*/

    public List<Proposal> listProposals(Long questionId){
        List<Proposal> result = Proposal.find("question.id", questionId).list();
        return result;
    }


    public Long evaluateProposals(List<Proposal> proposalsInput){
        List<Proposal> proposals = Proposal.listAll();
        Long count =0L;
        for(Proposal currentProposal:proposals){
            if(currentProposal.id.equals(currentProposal.id)){
                if(currentProposal.correct) {
                    count++;
                }
            }
        }
        return count;
    }

    

}
