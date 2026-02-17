package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.CategoryDto;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.orm.Category;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuizzService {

    @ConfigProperty(name = "api-quizz.default-language", defaultValue = "fr")
    String defaultLanguage;

    @Inject
    TranslateService translateService;

    public List<QuestionDto> listAllQuestions(){
        List<Question> questions =  Question.listAll();
        List<QuestionDto> result = new ArrayList<>();
        for(Question currentQuestion:questions){
            result.add(mapToQuestionDto(currentQuestion));
        }
        return translateService.translateQuestions(result);
    }

    public QuestionDto loadQuestionById(Long questionId){
        Question q = Question.findById(questionId);
        return translateService.translateOneQuestion(mapToQuestionDto(q));
    }

    public List<ProposalDto> listProposals(Long questionId){
        List<Proposal> proposals =  Proposal.listAll();
        List<ProposalDto> result = new ArrayList<>();
        for(Proposal currentProposal:proposals){
            if(currentProposal.question.id.equals(questionId)){
                result.add(mapToProposalDto(currentProposal));
            }
        }
        return translateService.translateProposals(result);
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

    private QuestionDto mapToQuestionDto(Question question){
        QuestionDto result = new QuestionDto(question.id, question.label, defaultLanguage);
        result.catgory = mapToCategoryDto(question.category);
        return result;
    }

    private CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(category.label, defaultLanguage);
    }

    private ProposalDto mapToProposalDto(Proposal proposal){
        ProposalDto result = new ProposalDto(proposal.id, proposal.label, defaultLanguage);
        result.question = mapToQuestionDto(proposal.question);
        return result;
    }

}
