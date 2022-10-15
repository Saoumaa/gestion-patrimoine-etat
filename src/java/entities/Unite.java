/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL LATITUDE E5550
 */
@Entity
@Table(name = "unite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unite.findAll", query = "SELECT u FROM Unite u")
    , @NamedQuery(name = "Unite.findByUniteId", query = "SELECT u FROM Unite u WHERE u.uniteId = :uniteId")
    , @NamedQuery(name = "Unite.findBySymbole", query = "SELECT u FROM Unite u WHERE u.symbole = :symbole")
    , @NamedQuery(name = "Unite.findByDesignation", query = "SELECT u FROM Unite u WHERE u.designation = :designation")})
public class Unite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unite_id")
    private Integer uniteId;
    @Size(max = 2147483647)
    @Column(name = "symbole")
    private String symbole;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "uniteId")
    private List<ConditionnementArticle> conditionnementArticleList;

    public Unite() {
    }

    public Unite(Integer uniteId) {
        this.uniteId = uniteId;
    }

    public Integer getUniteId() {
        return uniteId;
    }

    public void setUniteId(Integer uniteId) {
        this.uniteId = uniteId;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<ConditionnementArticle> getConditionnementArticleList() {
        return conditionnementArticleList;
    }

    public void setConditionnementArticleList(List<ConditionnementArticle> conditionnementArticleList) {
        this.conditionnementArticleList = conditionnementArticleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniteId != null ? uniteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unite)) {
            return false;
        }
        Unite other = (Unite) object;
        if ((this.uniteId == null && other.uniteId != null) || (this.uniteId != null && !this.uniteId.equals(other.uniteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Unite[ uniteId=" + uniteId + " ]";
    }
    
}
