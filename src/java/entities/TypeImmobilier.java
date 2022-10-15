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
@Table(name = "type_immobilier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeImmobilier.findAll", query = "SELECT t FROM TypeImmobilier t")
    , @NamedQuery(name = "TypeImmobilier.findByTypeImmobilierId", query = "SELECT t FROM TypeImmobilier t WHERE t.typeImmobilierId = :typeImmobilierId")
    , @NamedQuery(name = "TypeImmobilier.findByDesignation", query = "SELECT t FROM TypeImmobilier t WHERE t.designation = :designation")})
public class TypeImmobilier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_immobilier_id")
    private Integer typeImmobilierId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "typeImmobilierId")
    private List<Immobilisation> immobilisationList;

    public TypeImmobilier() {
    }

    public TypeImmobilier(Integer typeImmobilierId) {
        this.typeImmobilierId = typeImmobilierId;
    }

    public Integer getTypeImmobilierId() {
        return typeImmobilierId;
    }

    public void setTypeImmobilierId(Integer typeImmobilierId) {
        this.typeImmobilierId = typeImmobilierId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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
        hash += (typeImmobilierId != null ? typeImmobilierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeImmobilier)) {
            return false;
        }
        TypeImmobilier other = (TypeImmobilier) object;
        if ((this.typeImmobilierId == null && other.typeImmobilierId != null) || (this.typeImmobilierId != null && !this.typeImmobilierId.equals(other.typeImmobilierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TypeImmobilier[ typeImmobilierId=" + typeImmobilierId + " ]";
    }
    
}
