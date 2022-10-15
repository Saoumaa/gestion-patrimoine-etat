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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "caracteristiques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristiques.findAll", query = "SELECT c FROM Caracteristiques c")
    , @NamedQuery(name = "Caracteristiques.findByCaracteristiquesId", query = "SELECT c FROM Caracteristiques c WHERE c.caracteristiquesId = :caracteristiquesId")
    , @NamedQuery(name = "Caracteristiques.findByDesignation", query = "SELECT c FROM Caracteristiques c WHERE c.designation = :designation")})
public class Caracteristiques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "caracteristiques_id")
    private Integer caracteristiquesId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "caracteristiquesId")
    private List<ValeurCaracteristiqueArticle> valeurCaracteristiqueArticleList;
    @JoinColumn(name = "famille_id", referencedColumnName = "famille_id")
    @ManyToOne
    private Famille familleId;

    public Caracteristiques() {
    }

    public Caracteristiques(Integer caracteristiquesId) {
        this.caracteristiquesId = caracteristiquesId;
    }

    public Integer getCaracteristiquesId() {
        return caracteristiquesId;
    }

    public void setCaracteristiquesId(Integer caracteristiquesId) {
        this.caracteristiquesId = caracteristiquesId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<ValeurCaracteristiqueArticle> getValeurCaracteristiqueArticleList() {
        return valeurCaracteristiqueArticleList;
    }

    public void setValeurCaracteristiqueArticleList(List<ValeurCaracteristiqueArticle> valeurCaracteristiqueArticleList) {
        this.valeurCaracteristiqueArticleList = valeurCaracteristiqueArticleList;
    }

    public Famille getFamilleId() {
        return familleId;
    }

    public void setFamilleId(Famille familleId) {
        this.familleId = familleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caracteristiquesId != null ? caracteristiquesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristiques)) {
            return false;
        }
        Caracteristiques other = (Caracteristiques) object;
        if ((this.caracteristiquesId == null && other.caracteristiquesId != null) || (this.caracteristiquesId != null && !this.caracteristiquesId.equals(other.caracteristiquesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Caracteristiques[ caracteristiquesId=" + caracteristiquesId + " ]";
    }
    
}
