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
@Table(name = "type_local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeLocal.findAll", query = "SELECT t FROM TypeLocal t")
    , @NamedQuery(name = "TypeLocal.findByTypeLocalId", query = "SELECT t FROM TypeLocal t WHERE t.typeLocalId = :typeLocalId")
    , @NamedQuery(name = "TypeLocal.findByDesignation", query = "SELECT t FROM TypeLocal t WHERE t.designation = :designation")})
public class TypeLocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_local_id")
    private Integer typeLocalId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "typeLocalId")
    private List<Local> localList;

    public TypeLocal() {
    }

    public TypeLocal(Integer typeLocalId) {
        this.typeLocalId = typeLocalId;
    }

    public Integer getTypeLocalId() {
        return typeLocalId;
    }

    public void setTypeLocalId(Integer typeLocalId) {
        this.typeLocalId = typeLocalId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(List<Local> localList) {
        this.localList = localList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeLocalId != null ? typeLocalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeLocal)) {
            return false;
        }
        TypeLocal other = (TypeLocal) object;
        if ((this.typeLocalId == null && other.typeLocalId != null) || (this.typeLocalId != null && !this.typeLocalId.equals(other.typeLocalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TypeLocal[ typeLocalId=" + typeLocalId + " ]";
    }
    
}
