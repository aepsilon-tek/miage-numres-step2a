package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<ProposalDto> listProposals(Long questionId){
        List<Proposal> proposals = Proposal.list("question.id", questionId);
        return translateService.translateProposals(proposals);
    }


    public Long evaluateProposals(List<ProposalDto> proposalsInput){
        if (proposalsInput == null || proposalsInput.isEmpty()) {
            return 0L;
        }
        Set<Long> ids = new HashSet<>();
        for (ProposalDto proposalDto : proposalsInput) {
            if (proposalDto.id != null) {
                ids.add(proposalDto.id);
            }
        }
        if (ids.isEmpty()) {
            return 0L;
        }
        return Proposal.count("id in ?1 and correct = true", ids);
    }

}
