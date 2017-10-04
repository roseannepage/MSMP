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
import javax.persistence.Lob;
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
@Table(name = "shiftschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shiftschedule.findAll", query = "SELECT s FROM Shiftschedule s")
    , @NamedQuery(name = "Shiftschedule.findByShiftScheduleId", query = "SELECT s FROM Shiftschedule s WHERE s.shiftScheduleId = :shiftScheduleId")
    , @NamedQuery(name = "Shiftschedule.findByDateToFill", query = "SELECT s FROM Shiftschedule s WHERE s.dateToFill = :dateToFill")
    , @NamedQuery(name = "Shiftschedule.findByTimeIn", query = "SELECT s FROM Shiftschedule s WHERE s.timeIn = :timeIn")
    , @NamedQuery(name = "Shiftschedule.findByTimeOut", query = "SELECT s FROM Shiftschedule s WHERE s.timeOut = :timeOut")
    , @NamedQuery(name = "Shiftschedule.findByPatientsSeen", query = "SELECT s FROM Shiftschedule s WHERE s.patientsSeen = :patientsSeen")
    , @NamedQuery(name = "Shiftschedule.findByHighVolumn", query = "SELECT s FROM Shiftschedule s WHERE s.highVolumn = :highVolumn")})
public class Shiftschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shift_schedule_id")
    private Integer shiftScheduleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_to_fill")
    @Temporal(TemporalType.DATE)
    private Date dateToFill;
    @Column(name = "time_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeIn;
    @Column(name = "time_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOut;
    @Column(name = "patients_seen")
    private Integer patientsSeen;
    @Column(name = "high_volumn")
    private Boolean highVolumn;
    @Lob
    @Column(name = "note")
    private byte[] note;
    @JoinColumn(name = "physician_id", referencedColumnName = "physician_id")
    @ManyToOne(optional = false)
    private Physician physicianId;
    @JoinColumn(name = "scribe_id", referencedColumnName = "scribe_id")
    @ManyToOne
    private Scribe scribeId;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id")
    @ManyToOne(optional = false)
    private Specialization specializationId;
    @JoinColumn(name = "shift_id", referencedColumnName = "shift_id")
    @ManyToOne(optional = false)
    private Shift shiftId;

    public Shiftschedule() {
    }

    public Shiftschedule(Integer shiftScheduleId) {
        this.shiftScheduleId = shiftScheduleId;
    }

    public Shiftschedule(Integer shiftScheduleId, Date dateToFill) {
        this.shiftScheduleId = shiftScheduleId;
        this.dateToFill = dateToFill;
    }

    public Integer getShiftScheduleId() {
        return shiftScheduleId;
    }

    public void setShiftScheduleId(Integer shiftScheduleId) {
        this.shiftScheduleId = shiftScheduleId;
    }

    public Date getDateToFill() {
        return dateToFill;
    }

    public void setDateToFill(Date dateToFill) {
        this.dateToFill = dateToFill;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Integer getPatientsSeen() {
        return patientsSeen;
    }

    public void setPatientsSeen(Integer patientsSeen) {
        this.patientsSeen = patientsSeen;
    }

    public Boolean getHighVolumn() {
        return highVolumn;
    }

    public void setHighVolumn(Boolean highVolumn) {
        this.highVolumn = highVolumn;
    }

    public byte[] getNote() {
        return note;
    }

    public void setNote(byte[] note) {
        this.note = note;
    }

    public Physician getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Physician physicianId) {
        this.physicianId = physicianId;
    }

    public Scribe getScribeId() {
        return scribeId;
    }

    public void setScribeId(Scribe scribeId) {
        this.scribeId = scribeId;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public Specialization getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Specialization specializationId) {
        this.specializationId = specializationId;
    }

    public Shift getShiftId() {
        return shiftId;
    }

    public void setShiftId(Shift shiftId) {
        this.shiftId = shiftId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiftScheduleId != null ? shiftScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shiftschedule)) {
            return false;
        }
        Shiftschedule other = (Shiftschedule) object;
        if ((this.shiftScheduleId == null && other.shiftScheduleId != null) || (this.shiftScheduleId != null && !this.shiftScheduleId.equals(other.shiftScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shiftschedule[ shiftScheduleId=" + shiftScheduleId + " ]";
    }
    
}
