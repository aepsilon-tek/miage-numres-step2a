package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.CategoryDto;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.dto.TranslationDto;
import org.aepsilon.web.client.TranslateClient;
import org.aepsilon.web.client.TranslateRequest;
import org.aepsilon.web.client.TranslateResponse;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TranslateService {

    @ConfigProperty(name = "api-quizz.default-language", defaultValue = "fr")
    private String defaultLanguage;
    @ConfigProperty(name = "api-quizz.translations", defaultValue = "en")
    private String translatedLanguage;

    @Inject
    @RestClient
    TranslateClient client;

    public List<QuestionDto> translateQuestions(List<QuestionDto> questions) {
        List<QuestionDto> result = new ArrayList<>();
        for(QuestionDto currentQuestion:questions){
            result.add(translateOneQuestion(currentQuestion));
        }//End For Each
        return result;
    }


    public QuestionDto translateOneQuestion(QuestionDto currentQuestion) {
            QuestionDto q = new QuestionDto();
            q.id = currentQuestion.id;
            q.translations = new ArrayList<>(currentQuestion.translations);
            String[] languages = translatedLanguage.split(",");
            for(String currentLanguage:languages){
                TranslateRequest r = new TranslateRequest();
                r.setSource(defaultLanguage);
                r.setTarget(currentLanguage);
                r.setQ(getDefaultTranslationValue(currentQuestion.translations));
                r.setAlternatives(0);
                r.setFormat("text");
                TranslateResponse rep = client.translate(r);
                q.translations.add(new TranslationDto(rep,currentLanguage));
            }//End For Each Question

            if(currentQuestion.catgory != null) {
                q.catgory = translateOneCategory(currentQuestion.catgory);
            }
        return q;
    }


    public CategoryDto translateOneCategory(CategoryDto currentCategory) {
        CategoryDto c = new CategoryDto();
        c.translations = new ArrayList<>(currentCategory.translations);
        String[] languages = translatedLanguage.split(",");
        for(String currentLanguage:languages){
            TranslateRequest r = new TranslateRequest();
            r.setSource(defaultLanguage);
            r.setTarget(currentLanguage);
            r.setQ(getDefaultTranslationValue(currentCategory.translations));
            r.setAlternatives(0);
            r.setFormat("text");
            TranslateResponse rep = client.translate(r);
            c.translations.add(new TranslationDto(rep,currentLanguage));
        }//End For Each Question
        return c;
    }


    public List<ProposalDto> translateProposals(List<ProposalDto> proposals) {
        List<ProposalDto> result = new ArrayList<>();
        for(ProposalDto currentProposal:proposals){
            result.add(translateOneProposal(currentProposal));
        }//End For Each
        return result;
    }


    public ProposalDto translateOneProposal(ProposalDto currentProposal) {
        ProposalDto p = new ProposalDto();
        p.id = currentProposal.id;
        p.translations = new ArrayList<>(currentProposal.translations);
        String[] languages = translatedLanguage.split(",");
        for(String currentLanguage:languages){
            TranslateRequest r = new TranslateRequest();
            r.setSource(defaultLanguage);
            r.setTarget(currentLanguage);
            r.setQ(getDefaultTranslationValue(currentProposal.translations));
            r.setAlternatives(0);
            r.setFormat("text");
            TranslateResponse rep = client.translate(r);
            p.translations.add(new TranslationDto(rep,currentLanguage));
        }//End For Each Question

        if(currentProposal.question != null) {
            p.question = translateOneQuestion(currentProposal.question);
        }
        return p;
    }

    private String getDefaultTranslationValue(List<TranslationDto> translations){
        for(TranslationDto currentTranslation:translations){
            if(defaultLanguage.equals(currentTranslation.language)){
                return currentTranslation.value;
            }
        }
        return translations.isEmpty() ? "" : translations.get(0).value;
    }

}
