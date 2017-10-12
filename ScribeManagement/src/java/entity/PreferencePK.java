/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marie
 */
@Embeddable
public class PreferencePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "physician_id")
    private int physicianId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scribe_id")
    private int scribeId;

    public PreferencePK() {
    }

    public PreferencePK(int physicianId, int scribeId) {
        this.physicianId = physicianId;
        this.scribeId = scribeId;
    }

    public int getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(int physicianId) {
        this.physicianId = physicianId;
    }

    public int getScribeId() {
        return scribeId;
    }

    public void setScribeId(int scribeId) {
        this.scribeId = scribeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) physicianId;
        hash += (int) scribeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreferencePK)) {
            return false;
        }
        PreferencePK other = (PreferencePK) object;
        if (this.physicianId != other.physicianId) {
            return false;
        }
        if (this.scribeId != other.scribeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PreferencePK[ physicianId=" + physicianId + ", scribeId=" + scribeId + " ]";
    }
    
}
