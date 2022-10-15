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
@Table(name = "type_structure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeStructure.findAll", query = "SELECT t FROM TypeStructure t")
    , @NamedQuery(name = "TypeStructure.findByTypeStructureId", query = "SELECT t FROM TypeStructure t WHERE t.typeStructureId = :typeStructureId")
    , @NamedQuery(name = "TypeStructure.findByDesignation", query = "SELECT t FROM TypeStructure t WHERE t.designation = :designation")})
public class TypeStructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_structure_id")
    private Integer typeStructureId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "typeStructureId")
    private List<Structures> structuresList;

    public TypeStructure() {
    }

    public TypeStructure(Integer typeStructureId) {
        this.typeStructureId = typeStructureId;
    }

    public Integer getTypeStructureId() {
        return typeStructureId;
    }

    public void setTypeStructureId(Integer typeStructureId) {
        this.typeStructureId = typeStructureId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<Structures> getStructuresList() {
        return structuresList;
    }

    public void setStructuresList(List<Structures> structuresList) {
        this.structuresList = structuresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeStructureId != null ? typeStructureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeStructure)) {
            return false;
        }
        TypeStructure other = (TypeStructure) object;
        if ((this.typeStructureId == null && other.typeStructureId != null) || (this.typeStructureId != null && !this.typeStructureId.equals(other.typeStructureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TypeStructure[ typeStructureId=" + typeStructureId + " ]";
    }
    
}
