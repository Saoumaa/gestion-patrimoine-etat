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
@Table(name = "local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l")
    , @NamedQuery(name = "Local.findByLocalId", query = "SELECT l FROM Local l WHERE l.localId = :localId")
    , @NamedQuery(name = "Local.findByDesignation", query = "SELECT l FROM Local l WHERE l.designation = :designation")})
public class Local implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "local_id")
    private Integer localId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "localId")
    private List<MouvementStock> mouvementStockList;
    @OneToMany(mappedBy = "localId")
    private List<AttribuerLocalStructure> attribuerLocalStructureList;
    @OneToMany(mappedBy = "localMereId")
    private List<Local> localList;
    @JoinColumn(name = "local_mere_id", referencedColumnName = "local_id")
    @ManyToOne
    private Local localMereId;
    @JoinColumn(name = "type_local_id", referencedColumnName = "type_local_id")
    @ManyToOne
    private TypeLocal typeLocalId;

    public Local() {
    }

    public Local(Integer localId) {
        this.localId = localId;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<MouvementStock> getMouvementStockList() {
        return mouvementStockList;
    }

    public void setMouvementStockList(List<MouvementStock> mouvementStockList) {
        this.mouvementStockList = mouvementStockList;
    }

    @XmlTransient
    public List<AttribuerLocalStructure> getAttribuerLocalStructureList() {
        return attribuerLocalStructureList;
    }

    public void setAttribuerLocalStructureList(List<AttribuerLocalStructure> attribuerLocalStructureList) {
        this.attribuerLocalStructureList = attribuerLocalStructureList;
    }

    @XmlTransient
    public List<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(List<Local> localList) {
        this.localList = localList;
    }

    public Local getLocalMereId() {
        return localMereId;
    }

    public void setLocalMereId(Local localMereId) {
        this.localMereId = localMereId;
    }

    public TypeLocal getTypeLocalId() {
        return typeLocalId;
    }

    public void setTypeLocalId(TypeLocal typeLocalId) {
        this.typeLocalId = typeLocalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localId != null ? localId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.localId == null && other.localId != null) || (this.localId != null && !this.localId.equals(other.localId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Local[ localId=" + localId + " ]";
    }
    
}
