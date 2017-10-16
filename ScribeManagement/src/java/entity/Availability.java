/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marie
 */
@Entity
@Table(name = "availability")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Availability.findAll", query = "SELECT a FROM Availability a")
    , @NamedQuery(name = "Availability.findByAvailabilityId", query = "SELECT a FROM Availability a WHERE a.availabilityId = :availabilityId")
    , @NamedQuery(name = "Availability.findByAvailableDate", query = "SELECT a FROM Availability a WHERE a.availableDate = :availableDate")
    , @NamedQuery(name = "Availability.findByStartHour", query = "SELECT a FROM Availability a WHERE a.startHour = :startHour")
    , @NamedQuery(name = "Availability.findByFinishHour", query = "SELECT a FROM Availability a WHERE a.finishHour = :finishHour")
    , @NamedQuery(name = "Availability.findByOvernight", query = "SELECT a FROM Availability a WHERE a.overnight = :overnight")})
public class Availability implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "availability_id")
    private Integer availabilityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "available_date")
    @Temporal(TemporalType.DATE)
    private Date availableDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_hour")
    private int startHour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finish_hour")
    private int finishHour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "overnight")
    private boolean overnight;
    @JoinColumn(name = "scribe_id", referencedColumnName = "scribe_id")
    @ManyToOne(optional = false)
    private Scribe scribeId;

    public Availability() {
    }

    public Availability(Integer availabilityId) {
        this.availabilityId = availabilityId;
    }

    public Availability(Integer availabilityId, Date availableDate, int startHour, int finishHour, boolean overnight) {
        this.availabilityId = availabilityId;
        this.availableDate = availableDate;
        this.startHour = startHour;
        this.finishHour = finishHour;
        this.overnight = overnight;
    }

    public Integer getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Integer availabilityId) {
        this.availabilityId = availabilityId;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
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

    public boolean getOvernight() {
        return overnight;
    }

    public void setOvernight(boolean overnight) {
        this.overnight = overnight;
    }

    public Scribe getScribeId() {
        return scribeId;
    }

    public void setScribeId(Scribe scribeId) {
        this.scribeId = scribeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (availabilityId != null ? availabilityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Availability)) {
            return false;
        }
        Availability other = (Availability) object;
        if ((this.availabilityId == null && other.availabilityId != null) || (this.availabilityId != null && !this.availabilityId.equals(other.availabilityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Availability[ availabilityId=" + availabilityId + " ]";
    }
    
}
