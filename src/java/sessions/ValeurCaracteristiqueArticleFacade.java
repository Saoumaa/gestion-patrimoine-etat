/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.ValeurCaracteristiqueArticle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DELL LATITUDE E5550
 */
@Stateless
public class ValeurCaracteristiqueArticleFacade extends AbstractFacade<ValeurCaracteristiqueArticle> {

    @PersistenceContext(unitName = "patrimoinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValeurCaracteristiqueArticleFacade() {
        super(ValeurCaracteristiqueArticle.class);
    }
    
}
