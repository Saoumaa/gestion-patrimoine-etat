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
@Table(name = "nature_ressources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NatureRessources.findAll", query = "SELECT n FROM NatureRessources n")
    , @NamedQuery(name = "NatureRessources.findByNatureRessourcesId", query = "SELECT n FROM NatureRessources n WHERE n.natureRessourcesId = :natureRessourcesId")
    , @NamedQuery(name = "NatureRessources.findByDesignation", query = "SELECT n FROM NatureRessources n WHERE n.designation = :designation")})
public class NatureRessources implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nature_ressources_id")
    private Integer natureRessourcesId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "natureRessourcesId")
    private List<Ressources> ressourcesList;

    public NatureRessources() {
    }

    public NatureRessources(Integer natureRessourcesId) {
        this.natureRessourcesId = natureRessourcesId;
    }

    public Integer getNatureRessourcesId() {
        return natureRessourcesId;
    }

    public void setNatureRessourcesId(Integer natureRessourcesId) {
        this.natureRessourcesId = natureRessourcesId;
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
        hash += (natureRessourcesId != null ? natureRessourcesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NatureRessources)) {
            return false;
        }
        NatureRessources other = (NatureRessources) object;
        if ((this.natureRessourcesId == null && other.natureRessourcesId != null) || (this.natureRessourcesId != null && !this.natureRessourcesId.equals(other.natureRessourcesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NatureRessources[ natureRessourcesId=" + natureRessourcesId + " ]";
    }
    
}
