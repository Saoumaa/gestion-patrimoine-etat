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
@Table(name = "type_mouvement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeMouvement.findAll", query = "SELECT t FROM TypeMouvement t")
    , @NamedQuery(name = "TypeMouvement.findByTypeMouvementId", query = "SELECT t FROM TypeMouvement t WHERE t.typeMouvementId = :typeMouvementId")
    , @NamedQuery(name = "TypeMouvement.findByDesignation", query = "SELECT t FROM TypeMouvement t WHERE t.designation = :designation")})
public class TypeMouvement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_mouvement_id")
    private Integer typeMouvementId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "typeMouvementId")
    private List<Mouvement> mouvementList;

    public TypeMouvement() {
    }

    public TypeMouvement(Integer typeMouvementId) {
        this.typeMouvementId = typeMouvementId;
    }

    public Integer getTypeMouvementId() {
        return typeMouvementId;
    }

    public void setTypeMouvementId(Integer typeMouvementId) {
        this.typeMouvementId = typeMouvementId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<Mouvement> getMouvementList() {
        return mouvementList;
    }

    public void setMouvementList(List<Mouvement> mouvementList) {
        this.mouvementList = mouvementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeMouvementId != null ? typeMouvementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeMouvement)) {
            return false;
        }
        TypeMouvement other = (TypeMouvement) object;
        if ((this.typeMouvementId == null && other.typeMouvementId != null) || (this.typeMouvementId != null && !this.typeMouvementId.equals(other.typeMouvementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TypeMouvement[ typeMouvementId=" + typeMouvementId + " ]";
    }
    
}
