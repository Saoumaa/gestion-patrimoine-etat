/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.ConditionnementArticle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DELL LATITUDE E5550
 */
@Stateless
public class ConditionnementArticleFacade extends AbstractFacade<ConditionnementArticle> {

    @PersistenceContext(unitName = "patrimoinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConditionnementArticleFacade() {
        super(ConditionnementArticle.class);
    }
    
}
