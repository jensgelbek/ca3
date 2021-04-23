/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.Example.QuestionDTO;
import dtos.RenameMeDTO;
import entities.Question;
import entities.QuestionRepository;
import entities.renameme.RenameMe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author PC
 */
public class QuestionFacade implements QuestionRepository{
  private static QuestionFacade instance;
    private static EntityManagerFactory emf;
    public static QuestionFacade getQuestionFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new QuestionFacade();
        }
        return instance;
    }
    
    @Override
    public QuestionDTO getById(int id) throws WebApplicationException {
         EntityManager em = emf.createEntityManager();
        Question question = em.find(Question.class, (long)id);
        return new QuestionDTO(question);
    }

    @Override
    public QuestionDTO createQuestion(QuestionDTO questionDTO) throws WebApplicationException {
           EntityManager em = emf.createEntityManager();
        Question question = new Question(questionDTO);
        try {
            em.getTransaction().begin();
            em.persist(question);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        System.out.println(question);
        return new QuestionDTO(question);
    }  
}
