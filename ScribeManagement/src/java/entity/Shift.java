/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marie
 */
@Entity
@Table(name = "shift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shift.findAll", query = "SELECT s FROM Shift s")
    , @NamedQuery(name = "Shift.findByShiftId", query = "SELECT s FROM Shift s WHERE s.shiftId = :shiftId")
    , @NamedQuery(name = "Shift.findByShiftName", query = "SELECT s FROM Shift s WHERE s.shiftName = :shiftName")
    , @NamedQuery(name = "Shift.findByStartHour", query = "SELECT s FROM Shift s WHERE s.startHour = :startHour")
    , @NamedQuery(name = "Shift.findByFinishHour", query = "SELECT s FROM Shift s WHERE s.finishHour = :finishHour")
    , @NamedQuery(name = "Shift.findByOvernight", query = "SELECT s FROM Shift s WHERE s.overnight = :overnight")})
public class Shift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shift_id")
    private Integer shiftId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "shift_name")
    private String shiftName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_hour")
    private int startHour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finish_hour")
    private int finishHour;
    @Column(name = "overnight")
    private Boolean overnight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shiftId")
    private Collection<Shiftschedule> shiftscheduleCollection;

    public Shift() {
    }

    public Shift(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public Shift(Integer shiftId, String shiftName, int startHour, int finishHour) {
        this.shiftId = shiftId;
        this.shiftName = shiftName;
        this.startHour = startHour;
        this.finishHour = finishHour;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(int finishHour) {
        this.finishHour = finishHour;
    }

    public Boolean getOvernight() {
        return overnight;
    }

    public void setOvernight(Boolean overnight) {
        this.overnight = overnight;
    }

    @XmlTransient
    public Collection<Shiftschedule> getShiftscheduleCollection() {
        return shiftscheduleCollection;
    }

    public void setShiftscheduleCollection(Collection<Shiftschedule> shiftscheduleCollection) {
        this.shiftscheduleCollection = shiftscheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiftId != null ? shiftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shift)) {
            return false;
        }
        Shift other = (Shift) object;
        if ((this.shiftId == null && other.shiftId != null) || (this.shiftId != null && !this.shiftId.equals(other.shiftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shift[ shiftId=" + shiftId + " ]";
    }
    
}
