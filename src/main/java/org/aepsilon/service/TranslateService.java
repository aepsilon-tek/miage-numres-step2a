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
import io.quarkus.cache.CacheResult; // Maintenant ça marchera grâce à l'extension

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

    // --- NOUVELLE MÉTHODE CACHÉE ---
    @CacheResult(cacheName = "translations")
    public TranslateResponse callTranslationApi(String q, String source, String target) {
        TranslateRequest r = new TranslateRequest();
        r.setSource(source);
        r.setTarget(target);
        r.setQ(q);
        r.setAlternatives(0);
        r.setFormat("text");
        return client.translate(r);
    }
    // -------------------------------

    public List<QuestionDto> translateQuestions(List<Question> questions) {
        List<QuestionDto> result = new ArrayList<>();
        for(Question currentQuestion:questions){
            result.add(translateOneQuestion(currentQuestion));
        }
        return result;
    }

    public QuestionDto translateOneQuestion(Question currentQuestion) {
        QuestionDto q = new QuestionDto(currentQuestion,defaultLanguage);
        String[] languages = translatedLanguage.split(",");
        for(String currentLanguage:languages){
            // UTILISATION DU CACHE
            TranslateResponse rep = callTranslationApi(currentQuestion.label, defaultLanguage, currentLanguage);
            q.translations.add(new TranslationDto(rep,currentLanguage));
        }

        q.catgory = translateOneCategory(currentQuestion.category);
        return q;
    }

    public CategoryDto translateOneCategory(Category currentCategory) {
        CategoryDto c = new CategoryDto(currentCategory,defaultLanguage);
        String[] languages = translatedLanguage.split(",");
        for(String currentLanguage:languages){
            // UTILISATION DU CACHE
            TranslateResponse rep = callTranslationApi(currentCategory.label, defaultLanguage, currentLanguage);
            c.translations.add(new TranslationDto(rep,currentLanguage));
        }
        return c;
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
            // UTILISATION DU CACHE
            TranslateResponse rep = callTranslationApi(currentProposal.label, defaultLanguage, currentLanguage);
            p.translations.add(new TranslationDto(rep,currentLanguage));
        }

        // OPTIMISATION Q14 (LAZY) : On ne charge pas la question
        p.question = null; 
        
        return p;
    }
}