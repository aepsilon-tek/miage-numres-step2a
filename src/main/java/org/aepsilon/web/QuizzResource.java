package org.aepsilon.web;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.service.QuizzService;

import java.util.List;

@Path("/quizz")
public class QuizzResource {

    @Inject
    QuizzService quizzService;

    @GET
    @Path("questions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<QuestionDto> listQuestions(@QueryParam("page") @DefaultValue("0") int page,
                                           @QueryParam("size") @DefaultValue("10") int size) {
        Log.infof("Fetching questions - Page: %d, Size: %d", page, size);
        return quizzService.listAllQuestions(page, size);
    }
    @GET
    @Path("questions/{id}/proposals")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProposalDto> listProposals(@PathParam("id") Long id) {
        Log.infof("Fetching proposals for question ID: %d", id);
        return quizzService.listProposals(id);
    }

    @POST
    @Path("proposals/evaluate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public long evaluateProposals(List<ProposalDto> proposalsInput) {
        Log.info("Evaluating proposals");
        return quizzService.evaluateProposals(proposalsInput);
    }
}
