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
import javax.persistence.ManyToMany;
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
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByLocationId", query = "SELECT l FROM Location l WHERE l.locationId = :locationId")
    , @NamedQuery(name = "Location.findByCountry", query = "SELECT l FROM Location l WHERE l.country = :country")
    , @NamedQuery(name = "Location.findByProvince", query = "SELECT l FROM Location l WHERE l.province = :province")
    , @NamedQuery(name = "Location.findByCity", query = "SELECT l FROM Location l WHERE l.city = :city")
    , @NamedQuery(name = "Location.findBySite", query = "SELECT l FROM Location l WHERE l.site = :site")
    , @NamedQuery(name = "Location.findByDepartment", query = "SELECT l FROM Location l WHERE l.department = :department")
    , @NamedQuery(name = "Location.findBySpecialRequirement", query = "SELECT l FROM Location l WHERE l.specialRequirement = :specialRequirement")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "location_id")
    private Integer locationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "province")
    private String province;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "site")
    private String site;
    @Size(max = 40)
    @Column(name = "department")
    private String department;
    @Basic(optional = false)
    @NotNull
    @Column(name = "special_requirement")
    private boolean specialRequirement;
    @ManyToMany(mappedBy = "locationCollection")
    private Collection<Scribe> scribeCollection;
    @ManyToMany(mappedBy = "locationCollection1")
    private Collection<Scribe> scribeCollection1;
    @ManyToMany(mappedBy = "locationCollection2")
    private Collection<Scribe> scribeCollection2;
    @ManyToMany(mappedBy = "locationCollection")
    private Collection<Physician> physicianCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Collection<Scribespecializaiton> scribespecializaitonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private Collection<Shiftschedule> shiftscheduleCollection;

    public Location() {
    }

    public Location(Integer locationId) {
        this.locationId = locationId;
    }

    public Location(Integer locationId, String country, String province, String city, String site, boolean specialRequirement) {
        this.locationId = locationId;
        this.country = country;
        this.province = province;
        this.city = city;
        this.site = site;
        this.specialRequirement = specialRequirement;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean getSpecialRequirement() {
        return specialRequirement;
    }

    public void setSpecialRequirement(boolean specialRequirement) {
        this.specialRequirement = specialRequirement;
    }

    @XmlTransient
    public Collection<Scribe> getScribeCollection() {
        return scribeCollection;
    }

    public void setScribeCollection(Collection<Scribe> scribeCollection) {
        this.scribeCollection = scribeCollection;
    }

    @XmlTransient
    public Collection<Scribe> getScribeCollection1() {
        return scribeCollection1;
    }

    public void setScribeCollection1(Collection<Scribe> scribeCollection1) {
        this.scribeCollection1 = scribeCollection1;
    }

    @XmlTransient
    public Collection<Scribe> getScribeCollection2() {
        return scribeCollection2;
    }

    public void setScribeCollection2(Collection<Scribe> scribeCollection2) {
        this.scribeCollection2 = scribeCollection2;
    }

    @XmlTransient
    public Collection<Physician> getPhysicianCollection() {
        return physicianCollection;
    }

    public void setPhysicianCollection(Collection<Physician> physicianCollection) {
        this.physicianCollection = physicianCollection;
    }

    @XmlTransient
    public Collection<Scribespecializaiton> getScribespecializaitonCollection() {
        return scribespecializaitonCollection;
    }

    public void setScribespecializaitonCollection(Collection<Scribespecializaiton> scribespecializaitonCollection) {
        this.scribespecializaitonCollection = scribespecializaitonCollection;
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
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Location[ locationId=" + locationId + " ]";
    }
    
}
