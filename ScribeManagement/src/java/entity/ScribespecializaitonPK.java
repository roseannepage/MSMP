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
public class ScribespecializaitonPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "specialization_id")
    private int specializationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scribe_id")
    private int scribeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "location_id")
    private int locationId;

    public ScribespecializaitonPK() {
    }

    public ScribespecializaitonPK(int specializationId, int scribeId, int locationId) {
        this.specializationId = specializationId;
        this.scribeId = scribeId;
        this.locationId = locationId;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public int getScribeId() {
        return scribeId;
    }

    public void setScribeId(int scribeId) {
        this.scribeId = scribeId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) specializationId;
        hash += (int) scribeId;
        hash += (int) locationId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScribespecializaitonPK)) {
            return false;
        }
        ScribespecializaitonPK other = (ScribespecializaitonPK) object;
        if (this.specializationId != other.specializationId) {
            return false;
        }
        if (this.scribeId != other.scribeId) {
            return false;
        }
        if (this.locationId != other.locationId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ScribespecializaitonPK[ specializationId=" + specializationId + ", scribeId=" + scribeId + ", locationId=" + locationId + " ]";
    }
    
}
