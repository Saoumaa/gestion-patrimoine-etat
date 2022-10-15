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
@Table(name = "gamme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gamme.findAll", query = "SELECT g FROM Gamme g")
    , @NamedQuery(name = "Gamme.findByGammeId", query = "SELECT g FROM Gamme g WHERE g.gammeId = :gammeId")
    , @NamedQuery(name = "Gamme.findByDesignation", query = "SELECT g FROM Gamme g WHERE g.designation = :designation")})
public class Gamme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gamme_id")
    private Integer gammeId;
    @Size(max = 2147483647)
    @Column(name = "designation")
    private String designation;

    public Gamme() {
    }

    public Gamme(Integer gammeId) {
        this.gammeId = gammeId;
    }

    public Integer getGammeId() {
        return gammeId;
    }

    public void setGammeId(Integer gammeId) {
        this.gammeId = gammeId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gammeId != null ? gammeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gamme)) {
            return false;
        }
        Gamme other = (Gamme) object;
        if ((this.gammeId == null && other.gammeId != null) || (this.gammeId != null && !this.gammeId.equals(other.gammeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Gamme[ gammeId=" + gammeId + " ]";
    }
    
}
