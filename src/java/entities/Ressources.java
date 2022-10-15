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
@Table(name = "ressources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ressources.findAll", query = "SELECT r FROM Ressources r")
    , @NamedQuery(name = "Ressources.findByRessourcesId", query = "SELECT r FROM Ressources r WHERE r.ressourcesId = :ressourcesId")
    , @NamedQuery(name = "Ressources.findByDesignation", query = "SELECT r FROM Ressources r WHERE r.designation = :designation")})
public class Ressources implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ressources_id")
    private Integer ressourcesId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "ressourcesId")
    private List<DetailsMouvement> detailsMouvementList;
    @OneToMany(mappedBy = "ressourcesId")
    private List<ConditionnementArticle> conditionnementArticleList;
    @OneToMany(mappedBy = "ressourcesId")
    private List<ValeurCaracteristiqueArticle> valeurCaracteristiqueArticleList;
    @JoinColumn(name = "nature_ressources_id", referencedColumnName = "nature_ressources_id")
    @ManyToOne
    private NatureRessources natureRessourcesId;
    @OneToMany(mappedBy = "ressourcesMereId")
    private List<Ressources> ressourcesList;
    @JoinColumn(name = "ressources_mere_id", referencedColumnName = "ressources_id")
    @ManyToOne
    private Ressources ressourcesMereId;
    @JoinColumn(name = "type_ressources_id", referencedColumnName = "type_ressource_id")
    @ManyToOne
    private TypeRessource typeRessourcesId;

    public Ressources() {
    }

    public Ressources(Integer ressourcesId) {
        this.ressourcesId = ressourcesId;
    }

    public Integer getRessourcesId() {
        return ressourcesId;
    }

    public void setRessourcesId(Integer ressourcesId) {
        this.ressourcesId = ressourcesId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<DetailsMouvement> getDetailsMouvementList() {
        return detailsMouvementList;
    }

    public void setDetailsMouvementList(List<DetailsMouvement> detailsMouvementList) {
        this.detailsMouvementList = detailsMouvementList;
    }

    @XmlTransient
    public List<ConditionnementArticle> getConditionnementArticleList() {
        return conditionnementArticleList;
    }

    public void setConditionnementArticleList(List<ConditionnementArticle> conditionnementArticleList) {
        this.conditionnementArticleList = conditionnementArticleList;
    }

    @XmlTransient
    public List<ValeurCaracteristiqueArticle> getValeurCaracteristiqueArticleList() {
        return valeurCaracteristiqueArticleList;
    }

    public void setValeurCaracteristiqueArticleList(List<ValeurCaracteristiqueArticle> valeurCaracteristiqueArticleList) {
        this.valeurCaracteristiqueArticleList = valeurCaracteristiqueArticleList;
    }

    public NatureRessources getNatureRessourcesId() {
        return natureRessourcesId;
    }

    public void setNatureRessourcesId(NatureRessources natureRessourcesId) {
        this.natureRessourcesId = natureRessourcesId;
    }

    @XmlTransient
    public List<Ressources> getRessourcesList() {
        return ressourcesList;
    }

    public void setRessourcesList(List<Ressources> ressourcesList) {
        this.ressourcesList = ressourcesList;
    }

    public Ressources getRessourcesMereId() {
        return ressourcesMereId;
    }

    public void setRessourcesMereId(Ressources ressourcesMereId) {
        this.ressourcesMereId = ressourcesMereId;
    }

    public TypeRessource getTypeRessourcesId() {
        return typeRessourcesId;
    }

    public void setTypeRessourcesId(TypeRessource typeRessourcesId) {
        this.typeRessourcesId = typeRessourcesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ressourcesId != null ? ressourcesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ressources)) {
            return false;
        }
        Ressources other = (Ressources) object;
        if ((this.ressourcesId == null && other.ressourcesId != null) || (this.ressourcesId != null && !this.ressourcesId.equals(other.ressourcesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ressources[ ressourcesId=" + ressourcesId + " ]";
    }
    
}
