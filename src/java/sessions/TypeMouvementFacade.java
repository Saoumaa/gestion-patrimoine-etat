/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.TypeMouvement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DELL LATITUDE E5550
 */
@Stateless
public class TypeMouvementFacade extends AbstractFacade<TypeMouvement> {

    @PersistenceContext(unitName = "patrimoinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeMouvementFacade() {
        super(TypeMouvement.class);
    }
    
}
