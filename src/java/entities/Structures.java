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
@Table(name = "structures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Structures.findAll", query = "SELECT s FROM Structures s")
    , @NamedQuery(name = "Structures.findByStructuresId", query = "SELECT s FROM Structures s WHERE s.structuresId = :structuresId")
    , @NamedQuery(name = "Structures.findByAbreviation", query = "SELECT s FROM Structures s WHERE s.abreviation = :abreviation")
    , @NamedQuery(name = "Structures.findByDesignation", query = "SELECT s FROM Structures s WHERE s.designation = :designation")
    , @NamedQuery(name = "Structures.findByRangStructureId", query = "SELECT s FROM Structures s WHERE s.rangStructureId = :rangStructureId")})
public class Structures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "structures_id")
    private Integer structuresId;
    @Size(max = 2147483647)
    @Column(name = "abreviation")
    private String abreviation;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @Column(name = "rang_structure_id")
    private Integer rangStructureId;
    @OneToMany(mappedBy = "structuresId")
    private List<AttribuerLocalStructure> attribuerLocalStructureList;
    @JoinColumn(name = "type_structure_id", referencedColumnName = "type_structure_id")
    @ManyToOne
    private TypeStructure typeStructureId;

    public Structures() {
    }

    public Structures(Integer structuresId) {
        this.structuresId = structuresId;
    }

    public Integer getStructuresId() {
        return structuresId;
    }

    public void setStructuresId(Integer structuresId) {
        this.structuresId = structuresId;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getRangStructureId() {
        return rangStructureId;
    }

    public void setRangStructureId(Integer rangStructureId) {
        this.rangStructureId = rangStructureId;
    }

    @XmlTransient
    public List<AttribuerLocalStructure> getAttribuerLocalStructureList() {
        return attribuerLocalStructureList;
    }

    public void setAttribuerLocalStructureList(List<AttribuerLocalStructure> attribuerLocalStructureList) {
        this.attribuerLocalStructureList = attribuerLocalStructureList;
    }

    public TypeStructure getTypeStructureId() {
        return typeStructureId;
    }

    public void setTypeStructureId(TypeStructure typeStructureId) {
        this.typeStructureId = typeStructureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (structuresId != null ? structuresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Structures)) {
            return false;
        }
        Structures other = (Structures) object;
        if ((this.structuresId == null && other.structuresId != null) || (this.structuresId != null && !this.structuresId.equals(other.structuresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Structures[ structuresId=" + structuresId + " ]";
    }
    
}
