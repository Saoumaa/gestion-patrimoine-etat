/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL LATITUDE E5550
 */
@Entity
@Table(name = "mouvement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mouvement.findAll", query = "SELECT m FROM Mouvement m")
    , @NamedQuery(name = "Mouvement.findByMouvementId", query = "SELECT m FROM Mouvement m WHERE m.mouvementId = :mouvementId")
    , @NamedQuery(name = "Mouvement.findByDesignation", query = "SELECT m FROM Mouvement m WHERE m.designation = :designation")
    , @NamedQuery(name = "Mouvement.findByDateMouvement", query = "SELECT m FROM Mouvement m WHERE m.dateMouvement = :dateMouvement")})
public class Mouvement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mouvement_id")
    private Integer mouvementId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;
    @Column(name = "date_mouvement")
    @Temporal(TemporalType.DATE)
    private Date dateMouvement;
    @OneToMany(mappedBy = "mouvementId")
    private List<DetailsMouvement> detailsMouvementList;
    @JoinColumn(name = "type_mouvement_id", referencedColumnName = "type_mouvement_id")
    @ManyToOne
    private TypeMouvement typeMouvementId;

    public Mouvement() {
    }

    public Mouvement(Integer mouvementId) {
        this.mouvementId = mouvementId;
    }

    public Integer getMouvementId() {
        return mouvementId;
    }

    public void setMouvementId(Integer mouvementId) {
        this.mouvementId = mouvementId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(Date dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    @XmlTransient
    public List<DetailsMouvement> getDetailsMouvementList() {
        return detailsMouvementList;
    }

    public void setDetailsMouvementList(List<DetailsMouvement> detailsMouvementList) {
        this.detailsMouvementList = detailsMouvementList;
    }

    public TypeMouvement getTypeMouvementId() {
        return typeMouvementId;
    }

    public void setTypeMouvementId(TypeMouvement typeMouvementId) {
        this.typeMouvementId = typeMouvementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mouvementId != null ? mouvementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mouvement)) {
            return false;
        }
        Mouvement other = (Mouvement) object;
        if ((this.mouvementId == null && other.mouvementId != null) || (this.mouvementId != null && !this.mouvementId.equals(other.mouvementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mouvement[ mouvementId=" + mouvementId + " ]";
    }
    
}
