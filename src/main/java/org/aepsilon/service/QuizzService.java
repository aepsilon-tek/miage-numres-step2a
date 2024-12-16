package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;

import java.util.List;

@ApplicationScoped
public class QuizzService {

    public List<QuestionDto> listAllQuestions() {
        List<Question> questions = Question.listAll();
        return questions.stream().map(QuestionDto::new).toList();
    }

    public QuestionDto loadQuestionById(Long questionId) {
        Question question = Question.findById(questionId);
        return new QuestionDto(question);
    }

    public List<ProposalDto> listProposals(Long questionId) {
        List<Proposal> proposals = Proposal.list("question.id", questionId);
        return proposals.stream().map(ProposalDto::new).toList();
    }

    public Long evaluateProposals(List<ProposalDto> proposalsInput) {
        List<Proposal> proposals = Proposal.listAll();
        return proposals.stream()
                .filter(p -> proposalsInput.stream().anyMatch(dto -> dto.id.equals(p.id) && p.correct))
                .count();
    }
}
