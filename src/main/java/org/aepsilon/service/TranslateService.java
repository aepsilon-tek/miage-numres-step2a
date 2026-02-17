package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.CategoryDto;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.dto.TranslationDto;
import org.aepsilon.orm.Category;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;
import org.aepsilon.web.client.TranslateClient;
import org.aepsilon.web.client.TranslateRequest;
import org.aepsilon.web.client.TranslateResponse;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TranslateService {

    @ConfigProperty(name = "api-quizz.default-language", defaultValue = "fr")
    private String defaultLanguage;
    @ConfigProperty(name = "api-quizz.translations", defaultValue = "en")
    private String translatedLanguage;

    @Inject
    @RestClient
    TranslateClient client;
    
    private final Map<String, String> translationCache = new HashMap<>();
    private final Map<Long, CategoryDto> categoryCache = new HashMap<>();
    private final Map<Long, QuestionDto> questionCache = new HashMap<>();

    public List<QuestionDto> translateQuestions(List<Question> questions) {
        clearCaches();
        List<QuestionDto> result = new ArrayList<>();
        for(Question currentQuestion:questions){
            result.add(translateOneQuestion(currentQuestion));
        }
        return result;
    }


    public QuestionDto translateOneQuestion(Question currentQuestion) {
        if(questionCache.containsKey(currentQuestion.id)) {
            return questionCache.get(currentQuestion.id);
        }
        
        QuestionDto q = new QuestionDto(currentQuestion,defaultLanguage);
        String[] languages = translatedLanguage.split(",");
        for(String currentLanguage:languages){
            String cacheKey = currentQuestion.label + "|" + defaultLanguage + "|" + currentLanguage;
            String translatedText;
            
            if(translationCache.containsKey(cacheKey)) {
                translatedText = translationCache.get(cacheKey);
            } else {
                TranslateRequest r = new TranslateRequest();
                r.setSource(defaultLanguage);
                r.setTarget(currentLanguage);
                r.setQ(currentQuestion.label);
                r.setAlternatives(0);
                r.setFormat("text");
                TranslateResponse rep = client.translate(r);
                translatedText = rep.getTranslatedText();
                translationCache.put(cacheKey, translatedText);
            }
            
            q.translations.add(new TranslationDto(currentLanguage, translatedText));
        }

        q.catgory = translateOneCategory(currentQuestion.category);
        questionCache.put(currentQuestion.id, q);
        return q;
    }


    public CategoryDto translateOneCategory(Category currentCategory) {
        if(categoryCache.containsKey(currentCategory.id)) {
            return categoryCache.get(currentCategory.id);
        }
        
        CategoryDto c = new CategoryDto(currentCategory,defaultLanguage);
        String[] languages = translatedLanguage.split(",");
        for(String currentLanguage:languages){
            String cacheKey = currentCategory.label + "|" + defaultLanguage + "|" + currentLanguage;
            String translatedText;
            
            if(translationCache.containsKey(cacheKey)) {
                translatedText = translationCache.get(cacheKey);
            } else {
                TranslateRequest r = new TranslateRequest();
                r.setSource(defaultLanguage);
                r.setTarget(currentLanguage);
                r.setQ(currentCategory.label);
                r.setAlternatives(0);
                r.setFormat("text");
                TranslateResponse rep = client.translate(r);
                translatedText = rep.getTranslatedText();
                translationCache.put(cacheKey, translatedText);
            }
            
            c.translations.add(new TranslationDto(currentLanguage, translatedText));
        }
        categoryCache.put(currentCategory.id, c);
        return c;
    }
    
    private void clearCaches() {
        translationCache.clear();
        categoryCache.clear();
        questionCache.clear();
    }


    public List<ProposalDto> translateProposals(List<Proposal> proposals) {
        List<ProposalDto> result = new ArrayList<>();
        for(Proposal currentProposal:proposals){
            result.add(translateOneProposal(currentProposal));
        }
        return result;
    }


    public ProposalDto translateOneProposal(Proposal currentProposal) {
        ProposalDto p = new ProposalDto(currentProposal,defaultLanguage);
        String[] languages = translatedLanguage.split(",");
        for(String currentLanguage:languages){
            String cacheKey = currentProposal.label + "|" + defaultLanguage + "|" + currentLanguage;
            String translatedText;
            
            if(translationCache.containsKey(cacheKey)) {
                translatedText = translationCache.get(cacheKey);
            } else {
                TranslateRequest r = new TranslateRequest();
                r.setSource(defaultLanguage);
                r.setTarget(currentLanguage);
                r.setQ(currentProposal.label);
                r.setAlternatives(0);
                r.setFormat("text");
                TranslateResponse rep = client.translate(r);
                translatedText = rep.getTranslatedText();
                translationCache.put(cacheKey, translatedText);
            }
            
            p.translations.add(new TranslationDto(currentLanguage, translatedText));
        }

        p.question = translateOneQuestion(currentProposal.question);
        return p;
    }

}
