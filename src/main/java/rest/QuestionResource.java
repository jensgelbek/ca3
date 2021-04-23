/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dtos.Example.QuestionDTO;
import entities.QuestionRepository;
import entities.renameme.RenameMeRepository;
import facades.FacadeExample;
import facades.QuestionFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rest.provider.Provider;
import static rest.provider.Provider.EMF;

/**
 * REST Web Service
 *
 * @author PC
 */
@Path("question")
public class QuestionResource extends Provider{
private static final QuestionRepository REPO =  QuestionFacade.getQuestionFacade(EMF);
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuestionResource
     */
    public QuestionResource() {
    }


    @Override
    public Response getById(int id) {
        QuestionDTO questionDTO = REPO.getById(id);
        return Response.ok(GSON.toJson(questionDTO)).build();
    }

    @Override
    public Response getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response create(String jsonBody) {
        QuestionDTO questionDTO = GSON.fromJson(jsonBody, QuestionDTO.class);
        QuestionDTO createdQuestion = REPO.createQuestion(questionDTO);
        return Response.ok(createdQuestion).build();
    }

    @Override
    public Response update(int id, String jsonBody) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
