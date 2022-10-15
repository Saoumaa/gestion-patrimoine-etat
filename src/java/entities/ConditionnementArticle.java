/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL LATITUDE E5550
 */
@Entity
@Table(name = "conditionnement_article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConditionnementArticle.findAll", query = "SELECT c FROM ConditionnementArticle c")
    , @NamedQuery(name = "ConditionnementArticle.findByConditionnementArticleId", query = "SELECT c FROM ConditionnementArticle c WHERE c.conditionnementArticleId = :conditionnementArticleId")
    , @NamedQuery(name = "ConditionnementArticle.findByDesignation", query = "SELECT c FROM ConditionnementArticle c WHERE c.designation = :designation")})
public class ConditionnementArticle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conditionnement_article_id")
    private Integer conditionnementArticleId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @JoinColumn(name = "ressources_id", referencedColumnName = "ressources_id")
    @ManyToOne
    private Ressources ressourcesId;
    @JoinColumn(name = "unite_id", referencedColumnName = "unite_id")
    @ManyToOne
    private Unite uniteId;

    public ConditionnementArticle() {
    }

    public ConditionnementArticle(Integer conditionnementArticleId) {
        this.conditionnementArticleId = conditionnementArticleId;
    }

    public Integer getConditionnementArticleId() {
        return conditionnementArticleId;
    }

    public void setConditionnementArticleId(Integer conditionnementArticleId) {
        this.conditionnementArticleId = conditionnementArticleId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Ressources getRessourcesId() {
        return ressourcesId;
    }

    public void setRessourcesId(Ressources ressourcesId) {
        this.ressourcesId = ressourcesId;
    }

    public Unite getUniteId() {
        return uniteId;
    }

    public void setUniteId(Unite uniteId) {
        this.uniteId = uniteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conditionnementArticleId != null ? conditionnementArticleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConditionnementArticle)) {
            return false;
        }
        ConditionnementArticle other = (ConditionnementArticle) object;
        if ((this.conditionnementArticleId == null && other.conditionnementArticleId != null) || (this.conditionnementArticleId != null && !this.conditionnementArticleId.equals(other.conditionnementArticleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ConditionnementArticle[ conditionnementArticleId=" + conditionnementArticleId + " ]";
    }
    
}
