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
@Table(name = "localisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localisation.findAll", query = "SELECT l FROM Localisation l")
    , @NamedQuery(name = "Localisation.findByLocalisationId", query = "SELECT l FROM Localisation l WHERE l.localisationId = :localisationId")
    , @NamedQuery(name = "Localisation.findByDesignation", query = "SELECT l FROM Localisation l WHERE l.designation = :designation")})
public class Localisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "localisation_id")
    private Integer localisationId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "localisationMereId")
    private List<Localisation> localisationList;
    @JoinColumn(name = "localisation_mere_id", referencedColumnName = "localisation_id")
    @ManyToOne
    private Localisation localisationMereId;
    @JoinColumn(name = "type_localisation_id", referencedColumnName = "type_localisation_id")
    @ManyToOne
    private TypeLocalisation typeLocalisationId;
    @OneToMany(mappedBy = "localisationId")
    private List<Immobilisation> immobilisationList;

    public Localisation() {
    }

    public Localisation(Integer localisationId) {
        this.localisationId = localisationId;
    }

    public Integer getLocalisationId() {
        return localisationId;
    }

    public void setLocalisationId(Integer localisationId) {
        this.localisationId = localisationId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<Localisation> getLocalisationList() {
        return localisationList;
    }

    public void setLocalisationList(List<Localisation> localisationList) {
        this.localisationList = localisationList;
    }

    public Localisation getLocalisationMereId() {
        return localisationMereId;
    }

    public void setLocalisationMereId(Localisation localisationMereId) {
        this.localisationMereId = localisationMereId;
    }

    public TypeLocalisation getTypeLocalisationId() {
        return typeLocalisationId;
    }

    public void setTypeLocalisationId(TypeLocalisation typeLocalisationId) {
        this.typeLocalisationId = typeLocalisationId;
    }

    @XmlTransient
    public List<Immobilisation> getImmobilisationList() {
        return immobilisationList;
    }

    public void setImmobilisationList(List<Immobilisation> immobilisationList) {
        this.immobilisationList = immobilisationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localisationId != null ? localisationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localisation)) {
            return false;
        }
        Localisation other = (Localisation) object;
        if ((this.localisationId == null && other.localisationId != null) || (this.localisationId != null && !this.localisationId.equals(other.localisationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Localisation[ localisationId=" + localisationId + " ]";
    }
    
}
