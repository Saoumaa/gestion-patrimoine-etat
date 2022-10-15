/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "immobilisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Immobilisation.findAll", query = "SELECT i FROM Immobilisation i")
    , @NamedQuery(name = "Immobilisation.findByImmobilisationId", query = "SELECT i FROM Immobilisation i WHERE i.immobilisationId = :immobilisationId")
    , @NamedQuery(name = "Immobilisation.findByDesignation", query = "SELECT i FROM Immobilisation i WHERE i.designation = :designation")
    , @NamedQuery(name = "Immobilisation.findByForme", query = "SELECT i FROM Immobilisation i WHERE i.forme = :forme")
    , @NamedQuery(name = "Immobilisation.findBySuperficie", query = "SELECT i FROM Immobilisation i WHERE i.superficie = :superficie")})
public class Immobilisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "immobilisation_id")
    private Integer immobilisationId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @Size(max = 2147483647)
    @Column(name = "forme")
    private String forme;
    @Column(name = "superficie")
    private BigInteger superficie;
    @JoinColumn(name = "localisation_id", referencedColumnName = "localisation_id")
    @ManyToOne
    private Localisation localisationId;
    @JoinColumn(name = "type_immobilier_id", referencedColumnName = "type_immobilier_id")
    @ManyToOne
    private TypeImmobilier typeImmobilierId;

    public Immobilisation() {
    }

    public Immobilisation(Integer immobilisationId) {
        this.immobilisationId = immobilisationId;
    }

    public Integer getImmobilisationId() {
        return immobilisationId;
    }

    public void setImmobilisationId(Integer immobilisationId) {
        this.immobilisationId = immobilisationId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getForme() {
        return forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public BigInteger getSuperficie() {
        return superficie;
    }

    public void setSuperficie(BigInteger superficie) {
        this.superficie = superficie;
    }

    public Localisation getLocalisationId() {
        return localisationId;
    }

    public void setLocalisationId(Localisation localisationId) {
        this.localisationId = localisationId;
    }

    public TypeImmobilier getTypeImmobilierId() {
        return typeImmobilierId;
    }

    public void setTypeImmobilierId(TypeImmobilier typeImmobilierId) {
        this.typeImmobilierId = typeImmobilierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (immobilisationId != null ? immobilisationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Immobilisation)) {
            return false;
        }
        Immobilisation other = (Immobilisation) object;
        if ((this.immobilisationId == null && other.immobilisationId != null) || (this.immobilisationId != null && !this.immobilisationId.equals(other.immobilisationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Immobilisation[ immobilisationId=" + immobilisationId + " ]";
    }
    
}
