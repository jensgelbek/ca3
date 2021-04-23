/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.Example.QuestionDTO;
import dtos.RenameMeDTO;
import java.util.List;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author PC
 */
public interface QuestionRepository {
    
    public QuestionDTO getById(int id) throws WebApplicationException;
    
    public QuestionDTO createQuestion(QuestionDTO questionDTO)throws WebApplicationException;
    
}

