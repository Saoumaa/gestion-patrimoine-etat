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
@Table(name = "famille")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f")
    , @NamedQuery(name = "Famille.findByFamilleId", query = "SELECT f FROM Famille f WHERE f.familleId = :familleId")
    , @NamedQuery(name = "Famille.findByDesignation", query = "SELECT f FROM Famille f WHERE f.designation = :designation")})
public class Famille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "famille_id")
    private Integer familleId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "familleId")
    private List<Caracteristiques> caracteristiquesList;

    public Famille() {
    }

    public Famille(Integer familleId) {
        this.familleId = familleId;
    }

    public Integer getFamilleId() {
        return familleId;
    }

    public void setFamilleId(Integer familleId) {
        this.familleId = familleId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<Caracteristiques> getCaracteristiquesList() {
        return caracteristiquesList;
    }

    public void setCaracteristiquesList(List<Caracteristiques> caracteristiquesList) {
        this.caracteristiquesList = caracteristiquesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familleId != null ? familleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Famille)) {
            return false;
        }
        Famille other = (Famille) object;
        if ((this.familleId == null && other.familleId != null) || (this.familleId != null && !this.familleId.equals(other.familleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Famille[ familleId=" + familleId + " ]";
    }
    
}
