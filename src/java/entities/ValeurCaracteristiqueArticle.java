/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "valeur_caracteristique_article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValeurCaracteristiqueArticle.findAll", query = "SELECT v FROM ValeurCaracteristiqueArticle v")
    , @NamedQuery(name = "ValeurCaracteristiqueArticle.findByValeur", query = "SELECT v FROM ValeurCaracteristiqueArticle v WHERE v.valeur = :valeur")
    , @NamedQuery(name = "ValeurCaracteristiqueArticle.findByValeurCarateristiqueArtId", query = "SELECT v FROM ValeurCaracteristiqueArticle v WHERE v.valeurCarateristiqueArtId = :valeurCarateristiqueArtId")})
public class ValeurCaracteristiqueArticle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "valeur")
    private BigInteger valeur;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "valeur_carateristique_art_id")
    private Integer valeurCarateristiqueArtId;
    @JoinColumn(name = "caracteristiques_id", referencedColumnName = "caracteristiques_id")
    @ManyToOne
    private Caracteristiques caracteristiquesId;
    @JoinColumn(name = "ressources_id", referencedColumnName = "ressources_id")
    @ManyToOne
    private Ressources ressourcesId;

    public ValeurCaracteristiqueArticle() {
    }

    public ValeurCaracteristiqueArticle(Integer valeurCarateristiqueArtId) {
        this.valeurCarateristiqueArtId = valeurCarateristiqueArtId;
    }

    public BigInteger getValeur() {
        return valeur;
    }

    public void setValeur(BigInteger valeur) {
        this.valeur = valeur;
    }

    public Integer getValeurCarateristiqueArtId() {
        return valeurCarateristiqueArtId;
    }

    public void setValeurCarateristiqueArtId(Integer valeurCarateristiqueArtId) {
        this.valeurCarateristiqueArtId = valeurCarateristiqueArtId;
    }

    public Caracteristiques getCaracteristiquesId() {
        return caracteristiquesId;
    }

    public void setCaracteristiquesId(Caracteristiques caracteristiquesId) {
        this.caracteristiquesId = caracteristiquesId;
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
        hash += (valeurCarateristiqueArtId != null ? valeurCarateristiqueArtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValeurCaracteristiqueArticle)) {
            return false;
        }
        ValeurCaracteristiqueArticle other = (ValeurCaracteristiqueArticle) object;
        if ((this.valeurCarateristiqueArtId == null && other.valeurCarateristiqueArtId != null) || (this.valeurCarateristiqueArtId != null && !this.valeurCarateristiqueArtId.equals(other.valeurCarateristiqueArtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ValeurCaracteristiqueArticle[ valeurCarateristiqueArtId=" + valeurCarateristiqueArtId + " ]";
    }
    
}
