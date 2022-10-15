/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL LATITUDE E5550
 */
@Entity
@Table(name = "details_mouvement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailsMouvement.findAll", query = "SELECT d FROM DetailsMouvement d")
    , @NamedQuery(name = "DetailsMouvement.findByDetailsMouvementId", query = "SELECT d FROM DetailsMouvement d WHERE d.detailsMouvementId = :detailsMouvementId")
    , @NamedQuery(name = "DetailsMouvement.findByQuantiteMvt", query = "SELECT d FROM DetailsMouvement d WHERE d.quantiteMvt = :quantiteMvt")})
public class DetailsMouvement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "details_mouvement_id")
    private Integer detailsMouvementId;
    @Column(name = "quantite_mvt")
    private Integer quantiteMvt;
    @JoinColumn(name = "mouvement_id", referencedColumnName = "mouvement_id")
    @ManyToOne
    private Mouvement mouvementId;
    @JoinColumn(name = "ressources_id", referencedColumnName = "ressources_id")
    @ManyToOne
    private Ressources ressourcesId;

    public DetailsMouvement() {
    }

    public DetailsMouvement(Integer detailsMouvementId) {
        this.detailsMouvementId = detailsMouvementId;
    }

    public Integer getDetailsMouvementId() {
        return detailsMouvementId;
    }

    public void setDetailsMouvementId(Integer detailsMouvementId) {
        this.detailsMouvementId = detailsMouvementId;
    }

    public Integer getQuantiteMvt() {
        return quantiteMvt;
    }

    public void setQuantiteMvt(Integer quantiteMvt) {
        this.quantiteMvt = quantiteMvt;
    }

    public Mouvement getMouvementId() {
        return mouvementId;
    }

    public void setMouvementId(Mouvement mouvementId) {
        this.mouvementId = mouvementId;
    }

    public Ressources getRessourcesId() {
        return ressourcesId;
    }

    public void setRessourcesId(Ressources ressourcesId) {
        this.ressourcesId = ressourcesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailsMouvementId != null ? detailsMouvementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailsMouvement)) {
            return false;
        }
        DetailsMouvement other = (DetailsMouvement) object;
        if ((this.detailsMouvementId == null && other.detailsMouvementId != null) || (this.detailsMouvementId != null && !this.detailsMouvementId.equals(other.detailsMouvementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetailsMouvement[ detailsMouvementId=" + detailsMouvementId + " ]";
    }
    
}
