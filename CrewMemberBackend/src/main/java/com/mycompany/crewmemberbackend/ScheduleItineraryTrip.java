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
@Table(name = "schedule_itinerary_trip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduleItineraryTrip.findAll", query = "SELECT s FROM ScheduleItineraryTrip s"),
    @NamedQuery(name = "ScheduleItineraryTrip.findByPid", query = "SELECT s FROM ScheduleItineraryTrip s WHERE s.pid = :pid"),
    @NamedQuery(name = "ScheduleItineraryTrip.findByStartTime", query = "SELECT s FROM ScheduleItineraryTrip s WHERE s.startTime = :startTime"),
    @NamedQuery(name = "ScheduleItineraryTrip.findByMessage", query = "SELECT s FROM ScheduleItineraryTrip s WHERE s.message = :message"),
    @NamedQuery(name = "ScheduleItineraryTrip.findByPersistentKlassName", query = "SELECT s FROM ScheduleItineraryTrip s WHERE s.persistentKlassName = :persistentKlassName"),
    @NamedQuery(name = "ScheduleItineraryTrip.findByTripTime", query = "SELECT s FROM ScheduleItineraryTrip s WHERE s.tripTime = :tripTime")})
public class ScheduleItineraryTrip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startTime")
    private short startTime;
    @Size(max = 150)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tripTime")
    private short tripTime;
    @JoinColumn(name = "pid_sch_iti", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private ScheduleItinerary pidSchIti;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;
    @OneToMany(mappedBy = "pidSchItiTrip")
    private Collection<BlockEvent> blockEventCollection;

    public ScheduleItineraryTrip() {
    }

    public ScheduleItineraryTrip(Long pid) {
        this.pid = pid;
    }

    public ScheduleItineraryTrip(Long pid, short startTime, String persistentKlassName, short tripTime) {
        this.pid = pid;
        this.startTime = startTime;
        this.persistentKlassName = persistentKlassName;
        this.tripTime = tripTime;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public short getStartTime() {
        return startTime;
    }

    public void setStartTime(short startTime) {
        this.startTime = startTime;
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

    public short getTripTime() {
        return tripTime;
    }

    public void setTripTime(short tripTime) {
        this.tripTime = tripTime;
    }

    public ScheduleItinerary getPidSchIti() {
        return pidSchIti;
    }

    public void setPidSchIti(ScheduleItinerary pidSchIti) {
        this.pidSchIti = pidSchIti;
    }

    public Status getPidStatus() {
        return pidStatus;
    }

    public void setPidStatus(Status pidStatus) {
        this.pidStatus = pidStatus;
    }

    @XmlTransient
    public Collection<BlockEvent> getBlockEventCollection() {
        return blockEventCollection;
    }

    public void setBlockEventCollection(Collection<BlockEvent> blockEventCollection) {
        this.blockEventCollection = blockEventCollection;
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
        if (!(object instanceof ScheduleItineraryTrip)) {
            return false;
        }
        ScheduleItineraryTrip other = (ScheduleItineraryTrip) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.ScheduleItineraryTrip[ pid=" + pid + " ]";
    }
    
}
