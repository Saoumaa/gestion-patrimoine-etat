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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL LATITUDE E5550
 */
@Entity
@Table(name = "details_mouvement_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailsMouvementStock.findAll", query = "SELECT d FROM DetailsMouvementStock d")
    , @NamedQuery(name = "DetailsMouvementStock.findByDetailsMouvementStockId", query = "SELECT d FROM DetailsMouvementStock d WHERE d.detailsMouvementStockId = :detailsMouvementStockId")
    , @NamedQuery(name = "DetailsMouvementStock.findByEstampillage", query = "SELECT d FROM DetailsMouvementStock d WHERE d.estampillage = :estampillage")})
public class DetailsMouvementStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "details_mouvement_stock_id")
    private Integer detailsMouvementStockId;
    @Size(max = 2147483647)
    @Column(name = "estampillage")
    private String estampillage;
    @JoinColumn(name = "mouvement_stock_id", referencedColumnName = "mouvement_stock_id")
    @ManyToOne
    private MouvementStock mouvementStockId;

    public DetailsMouvementStock() {
    }

    public DetailsMouvementStock(Integer detailsMouvementStockId) {
        this.detailsMouvementStockId = detailsMouvementStockId;
    }

    public Integer getDetailsMouvementStockId() {
        return detailsMouvementStockId;
    }

    public void setDetailsMouvementStockId(Integer detailsMouvementStockId) {
        this.detailsMouvementStockId = detailsMouvementStockId;
    }

    public String getEstampillage() {
        return estampillage;
    }

    public void setEstampillage(String estampillage) {
        this.estampillage = estampillage;
    }

    public MouvementStock getMouvementStockId() {
        return mouvementStockId;
    }

    public void setMouvementStockId(MouvementStock mouvementStockId) {
        this.mouvementStockId = mouvementStockId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailsMouvementStockId != null ? detailsMouvementStockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailsMouvementStock)) {
            return false;
        }
        DetailsMouvementStock other = (DetailsMouvementStock) object;
        if ((this.detailsMouvementStockId == null && other.detailsMouvementStockId != null) || (this.detailsMouvementStockId != null && !this.detailsMouvementStockId.equals(other.detailsMouvementStockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetailsMouvementStock[ detailsMouvementStockId=" + detailsMouvementStockId + " ]";
    }
    
}
