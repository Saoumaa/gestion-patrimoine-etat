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
@Table(name = "mouvement_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MouvementStock.findAll", query = "SELECT m FROM MouvementStock m")
    , @NamedQuery(name = "MouvementStock.findByMouvementStockId", query = "SELECT m FROM MouvementStock m WHERE m.mouvementStockId = :mouvementStockId")
    , @NamedQuery(name = "MouvementStock.findByQuantiteMvt", query = "SELECT m FROM MouvementStock m WHERE m.quantiteMvt = :quantiteMvt")
    , @NamedQuery(name = "MouvementStock.findByTypeMouvement", query = "SELECT m FROM MouvementStock m WHERE m.typeMouvement = :typeMouvement")})
public class MouvementStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mouvement_stock_id")
    private Integer mouvementStockId;
    @Column(name = "quantite_mvt")
    private Integer quantiteMvt;
    @Size(max = 2147483647)
    @Column(name = "type_mouvement")
    private String typeMouvement;
    @JoinColumn(name = "local_id", referencedColumnName = "local_id")
    @ManyToOne
    private Local localId;
    @OneToMany(mappedBy = "mouvementStockId")
    private List<DetailsMouvementStock> detailsMouvementStockList;

    public MouvementStock() {
    }

    public MouvementStock(Integer mouvementStockId) {
        this.mouvementStockId = mouvementStockId;
    }

    public Integer getMouvementStockId() {
        return mouvementStockId;
    }

    public void setMouvementStockId(Integer mouvementStockId) {
        this.mouvementStockId = mouvementStockId;
    }

    public Integer getQuantiteMvt() {
        return quantiteMvt;
    }

    public void setQuantiteMvt(Integer quantiteMvt) {
        this.quantiteMvt = quantiteMvt;
    }

    public String getTypeMouvement() {
        return typeMouvement;
    }

    public void setTypeMouvement(String typeMouvement) {
        this.typeMouvement = typeMouvement;
    }

    public Local getLocalId() {
        return localId;
    }

    public void setLocalId(Local localId) {
        this.localId = localId;
    }

    @XmlTransient
    public List<DetailsMouvementStock> getDetailsMouvementStockList() {
        return detailsMouvementStockList;
    }

    public void setDetailsMouvementStockList(List<DetailsMouvementStock> detailsMouvementStockList) {
        this.detailsMouvementStockList = detailsMouvementStockList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mouvementStockId != null ? mouvementStockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MouvementStock)) {
            return false;
        }
        MouvementStock other = (MouvementStock) object;
        if ((this.mouvementStockId == null && other.mouvementStockId != null) || (this.mouvementStockId != null && !this.mouvementStockId.equals(other.mouvementStockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MouvementStock[ mouvementStockId=" + mouvementStockId + " ]";
    }
    
}
