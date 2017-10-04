/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marie
 */
@Entity
@Table(name = "preference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preference.findAll", query = "SELECT p FROM Preference p")
    , @NamedQuery(name = "Preference.findByPhysicianId", query = "SELECT p FROM Preference p WHERE p.preferencePK.physicianId = :physicianId")
    , @NamedQuery(name = "Preference.findByScribeId", query = "SELECT p FROM Preference p WHERE p.preferencePK.scribeId = :scribeId")
    , @NamedQuery(name = "Preference.findByPreference", query = "SELECT p FROM Preference p WHERE p.preference = :preference")})
public class Preference implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreferencePK preferencePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preference")
    private boolean preference;
    @JoinColumn(name = "scribe_id", referencedColumnName = "scribe_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Scribe scribe;
    @JoinColumn(name = "physician_id", referencedColumnName = "physician_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Physician physician;

    public Preference() {
    }

    public Preference(PreferencePK preferencePK) {
        this.preferencePK = preferencePK;
    }

    public Preference(PreferencePK preferencePK, boolean preference) {
        this.preferencePK = preferencePK;
        this.preference = preference;
    }

    public Preference(int physicianId, int scribeId) {
        this.preferencePK = new PreferencePK(physicianId, scribeId);
    }

    public PreferencePK getPreferencePK() {
        return preferencePK;
    }

    public void setPreferencePK(PreferencePK preferencePK) {
        this.preferencePK = preferencePK;
    }

    public boolean getPreference() {
        return preference;
    }

    public void setPreference(boolean preference) {
        this.preference = preference;
    }

    public Scribe getScribe() {
        return scribe;
    }

    public void setScribe(Scribe scribe) {
        this.scribe = scribe;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preferencePK != null ? preferencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preference)) {
            return false;
        }
        Preference other = (Preference) object;
        if ((this.preferencePK == null && other.preferencePK != null) || (this.preferencePK != null && !this.preferencePK.equals(other.preferencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Preference[ preferencePK=" + preferencePK + " ]";
    }
    
}
