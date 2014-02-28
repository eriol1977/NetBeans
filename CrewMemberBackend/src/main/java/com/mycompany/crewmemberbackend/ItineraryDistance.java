/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.crewmemberbackend;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "itinerary_distance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItineraryDistance.findAll", query = "SELECT i FROM ItineraryDistance i"),
    @NamedQuery(name = "ItineraryDistance.findByPid", query = "SELECT i FROM ItineraryDistance i WHERE i.pid = :pid"),
    @NamedQuery(name = "ItineraryDistance.findByStartDate", query = "SELECT i FROM ItineraryDistance i WHERE i.startDate = :startDate"),
    @NamedQuery(name = "ItineraryDistance.findByDistance", query = "SELECT i FROM ItineraryDistance i WHERE i.distance = :distance"),
    @NamedQuery(name = "ItineraryDistance.findByPersistentKlassName", query = "SELECT i FROM ItineraryDistance i WHERE i.persistentKlassName = :persistentKlassName")})
public class ItineraryDistance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    private int startDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "distance")
    private BigDecimal distance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidDistance")
    private Collection<ScheduleItinerary> scheduleItineraryCollection;
    @JoinColumn(name = "pid_itinerary", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private Itinerary pidItinerary;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public ItineraryDistance() {
    }

    public ItineraryDistance(Long pid) {
        this.pid = pid;
    }

    public ItineraryDistance(Long pid, int startDate, BigDecimal distance, String persistentKlassName) {
        this.pid = pid;
        this.startDate = startDate;
        this.distance = distance;
        this.persistentKlassName = persistentKlassName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public String getPersistentKlassName() {
        return persistentKlassName;
    }

    public void setPersistentKlassName(String persistentKlassName) {
        this.persistentKlassName = persistentKlassName;
    }

    @XmlTransient
    public Collection<ScheduleItinerary> getScheduleItineraryCollection() {
        return scheduleItineraryCollection;
    }

    public void setScheduleItineraryCollection(Collection<ScheduleItinerary> scheduleItineraryCollection) {
        this.scheduleItineraryCollection = scheduleItineraryCollection;
    }

    public Itinerary getPidItinerary() {
        return pidItinerary;
    }

    public void setPidItinerary(Itinerary pidItinerary) {
        this.pidItinerary = pidItinerary;
    }

    public Status getPidStatus() {
        return pidStatus;
    }

    public void setPidStatus(Status pidStatus) {
        this.pidStatus = pidStatus;
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
        if (!(object instanceof ItineraryDistance)) {
            return false;
        }
        ItineraryDistance other = (ItineraryDistance) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.ItineraryDistance[ pid=" + pid + " ]";
    }
    
}
