package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.aepsilon.dto.CategoryDto;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.orm.Category;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuizzService {

    public List<QuestionDto> listAllQuestions(int page, int size) {
        List<Question> questions = Question.findAll().page(page, size).list();
        List<QuestionDto> result = new ArrayList<>();
        for (Question q : questions) {
            result.add(new QuestionDto(q)); // Retourne directement en français
        }
        return result;
    }

    public List<ProposalDto> listProposals(Long questionId) {
        List<Proposal> proposals = Proposal.find("question.id", questionId).list();
        List<ProposalDto> result = new ArrayList<>();
        for (Proposal p : proposals) {
            result.add(new ProposalDto(p)); // Retourne directement en français
        }
        return result;
    }

    public long evaluateProposals(List<ProposalDto> proposalsInput) {
        List<Proposal> proposals = Proposal.listAll();
        long count = 0;
        for (Proposal currentProposal : proposals) {
            for (ProposalDto currentProposalDto : proposalsInput) {
                if (currentProposal.id.equals(currentProposalDto.id)) {
                    if (currentProposal.correct) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
