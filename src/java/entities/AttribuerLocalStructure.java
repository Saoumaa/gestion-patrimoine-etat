/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL LATITUDE E5550
 */
@Entity
@Table(name = "attribuer_local_structure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttribuerLocalStructure.findAll", query = "SELECT a FROM AttribuerLocalStructure a")
    , @NamedQuery(name = "AttribuerLocalStructure.findByAttrLocalStructId", query = "SELECT a FROM AttribuerLocalStructure a WHERE a.attrLocalStructId = :attrLocalStructId")
    , @NamedQuery(name = "AttribuerLocalStructure.findByDateAttribution", query = "SELECT a FROM AttribuerLocalStructure a WHERE a.dateAttribution = :dateAttribution")
    , @NamedQuery(name = "AttribuerLocalStructure.findByDateFinAttribution", query = "SELECT a FROM AttribuerLocalStructure a WHERE a.dateFinAttribution = :dateFinAttribution")})
public class AttribuerLocalStructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attr_local_struct_id")
    private Integer attrLocalStructId;
    @Column(name = "date_attribution")
    @Temporal(TemporalType.DATE)
    private Date dateAttribution;
    @Column(name = "date_fin_attribution")
    @Temporal(TemporalType.DATE)
    private Date dateFinAttribution;
    @JoinColumn(name = "local_id", referencedColumnName = "local_id")
    @ManyToOne
    private Local localId;
    @JoinColumn(name = "structures_id", referencedColumnName = "structures_id")
    @ManyToOne
    private Structures structuresId;

    public AttribuerLocalStructure() {
    }

    public AttribuerLocalStructure(Integer attrLocalStructId) {
        this.attrLocalStructId = attrLocalStructId;
    }

    public Integer getAttrLocalStructId() {
        return attrLocalStructId;
    }

    public void setAttrLocalStructId(Integer attrLocalStructId) {
        this.attrLocalStructId = attrLocalStructId;
    }

    public Date getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(Date dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    public Date getDateFinAttribution() {
        return dateFinAttribution;
    }

    public void setDateFinAttribution(Date dateFinAttribution) {
        this.dateFinAttribution = dateFinAttribution;
    }

    public Local getLocalId() {
        return localId;
    }

    public void setLocalId(Local localId) {
        this.localId = localId;
    }

    public Structures getStructuresId() {
        return structuresId;
    }

    public void setStructuresId(Structures structuresId) {
        this.structuresId = structuresId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attrLocalStructId != null ? attrLocalStructId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttribuerLocalStructure)) {
            return false;
        }
        AttribuerLocalStructure other = (AttribuerLocalStructure) object;
        if ((this.attrLocalStructId == null && other.attrLocalStructId != null) || (this.attrLocalStructId != null && !this.attrLocalStructId.equals(other.attrLocalStructId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AttribuerLocalStructure[ attrLocalStructId=" + attrLocalStructId + " ]";
    }
    
}
