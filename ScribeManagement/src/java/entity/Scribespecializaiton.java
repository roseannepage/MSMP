/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marie
 */
@Entity
@Table(name = "scribespecializaiton")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scribespecializaiton.findAll", query = "SELECT s FROM Scribespecializaiton s")
    , @NamedQuery(name = "Scribespecializaiton.findBySpecializationId", query = "SELECT s FROM Scribespecializaiton s WHERE s.scribespecializaitonPK.specializationId = :specializationId")
    , @NamedQuery(name = "Scribespecializaiton.findByScribeId", query = "SELECT s FROM Scribespecializaiton s WHERE s.scribespecializaitonPK.scribeId = :scribeId")
    , @NamedQuery(name = "Scribespecializaiton.findByLocationId", query = "SELECT s FROM Scribespecializaiton s WHERE s.scribespecializaitonPK.locationId = :locationId")})
public class Scribespecializaiton implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ScribespecializaitonPK scribespecializaitonPK;
    @JoinColumn(name = "scribe_id", referencedColumnName = "scribe_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Scribe scribe;
    @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Specialization specialization;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Location location;

    public Scribespecializaiton() {
    }

    public Scribespecializaiton(ScribespecializaitonPK scribespecializaitonPK) {
        this.scribespecializaitonPK = scribespecializaitonPK;
    }

    public Scribespecializaiton(int specializationId, int scribeId, int locationId) {
        this.scribespecializaitonPK = new ScribespecializaitonPK(specializationId, scribeId, locationId);
    }

    public ScribespecializaitonPK getScribespecializaitonPK() {
        return scribespecializaitonPK;
    }

    public void setScribespecializaitonPK(ScribespecializaitonPK scribespecializaitonPK) {
        this.scribespecializaitonPK = scribespecializaitonPK;
    }

    public Scribe getScribe() {
        return scribe;
    }

    public void setScribe(Scribe scribe) {
        this.scribe = scribe;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scribespecializaitonPK != null ? scribespecializaitonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scribespecializaiton)) {
            return false;
        }
        Scribespecializaiton other = (Scribespecializaiton) object;
        if ((this.scribespecializaitonPK == null && other.scribespecializaitonPK != null) || (this.scribespecializaitonPK != null && !this.scribespecializaitonPK.equals(other.scribespecializaitonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Scribespecializaiton[ scribespecializaitonPK=" + scribespecializaitonPK + " ]";
    }
    
}
