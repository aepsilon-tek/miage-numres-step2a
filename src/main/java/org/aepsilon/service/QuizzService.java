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

    public List<Question> listAllQuestions(){
        List<Question> questions =  Question.listAll();
        return questions;
    }

    public Question loadQuestionById(Long questionId){
        Question q = Question.findById(questionId);
        return q;
    }

    public List<Proposal> listProposals(Long questionId){
        List<Proposal> proposals = Proposal.find("question.id", questionId).list();
        List<Proposal> result = new ArrayList<>();
        for(Proposal currentProposal:proposals){
            if(currentProposal.id.equals(questionId)){
                result.add(currentProposal);
            }
        }
        return result;
    }


    public Long evaluateProposals(List<ProposalDto> proposalsInput){
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
    }

}
