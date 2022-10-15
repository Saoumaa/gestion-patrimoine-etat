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
@Table(name = "type_ressource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeRessource.findAll", query = "SELECT t FROM TypeRessource t")
    , @NamedQuery(name = "TypeRessource.findByTypeRessourceId", query = "SELECT t FROM TypeRessource t WHERE t.typeRessourceId = :typeRessourceId")
    , @NamedQuery(name = "TypeRessource.findByDesignation", query = "SELECT t FROM TypeRessource t WHERE t.designation = :designation")})
public class TypeRessource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_ressource_id")
    private Integer typeRessourceId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "typeRessourcesId")
    private List<Ressources> ressourcesList;

    public TypeRessource() {
    }

    public TypeRessource(Integer typeRessourceId) {
        this.typeRessourceId = typeRessourceId;
    }

    public Integer getTypeRessourceId() {
        return typeRessourceId;
    }

    public void setTypeRessourceId(Integer typeRessourceId) {
        this.typeRessourceId = typeRessourceId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<Ressources> getRessourcesList() {
        return ressourcesList;
    }

    public void setRessourcesList(List<Ressources> ressourcesList) {
        this.ressourcesList = ressourcesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeRessourceId != null ? typeRessourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeRessource)) {
            return false;
        }
        TypeRessource other = (TypeRessource) object;
        if ((this.typeRessourceId == null && other.typeRessourceId != null) || (this.typeRessourceId != null && !this.typeRessourceId.equals(other.typeRessourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TypeRessource[ typeRessourceId=" + typeRessourceId + " ]";
    }
    
}
