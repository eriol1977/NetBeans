/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.crewmemberbackend;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Francesco
 */
@Entity
@Table(name = "geographic_point")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeographicPoint.findAll", query = "SELECT g FROM GeographicPoint g"),
    @NamedQuery(name = "GeographicPoint.findByPid", query = "SELECT g FROM GeographicPoint g WHERE g.pid = :pid"),
    @NamedQuery(name = "GeographicPoint.findByLatitude", query = "SELECT g FROM GeographicPoint g WHERE g.latitude = :latitude"),
    @NamedQuery(name = "GeographicPoint.findByLongitude", query = "SELECT g FROM GeographicPoint g WHERE g.longitude = :longitude"),
    @NamedQuery(name = "GeographicPoint.findByLocationNumber", query = "SELECT g FROM GeographicPoint g WHERE g.locationNumber = :locationNumber"),
    @NamedQuery(name = "GeographicPoint.findByMessage", query = "SELECT g FROM GeographicPoint g WHERE g.message = :message"),
    @NamedQuery(name = "GeographicPoint.findByPersistentKlassName", query = "SELECT g FROM GeographicPoint g WHERE g.persistentKlassName = :persistentKlassName")})
public class GeographicPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private double longitude;
    @Size(max = 10)
    @Column(name = "locationNumber")
    private String locationNumber;
    @Size(max = 50)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @JoinColumn(name = "pid_location", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private Location pidLocation;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;
    @OneToMany(mappedBy = "pidGeographicPoint")
    private Collection<Locatable> locatableCollection;

    public GeographicPoint() {
    }

    public GeographicPoint(Long pid) {
        this.pid = pid;
    }

    public GeographicPoint(Long pid, double latitude, double longitude, String persistentKlassName) {
        this.pid = pid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.persistentKlassName = persistentKlassName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(String locationNumber) {
        this.locationNumber = locationNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPersistentKlassName() {
        return persistentKlassName;
    }

    public void setPersistentKlassName(String persistentKlassName) {
        this.persistentKlassName = persistentKlassName;
    }

    public Location getPidLocation() {
        return pidLocation;
    }

    public void setPidLocation(Location pidLocation) {
        this.pidLocation = pidLocation;
    }

    public Status getPidStatus() {
        return pidStatus;
    }

    public void setPidStatus(Status pidStatus) {
        this.pidStatus = pidStatus;
    }

    @XmlTransient
    public Collection<Locatable> getLocatableCollection() {
        return locatableCollection;
    }

    public void setLocatableCollection(Collection<Locatable> locatableCollection) {
        this.locatableCollection = locatableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeographicPoint)) {
            return false;
        }
        GeographicPoint other = (GeographicPoint) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.GeographicPoint[ pid=" + pid + " ]";
    }
    
}
