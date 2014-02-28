/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.crewmemberbackend;

import java.io.Serializable;
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
@Table(name = "schedule_itinerary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduleItinerary.findAll", query = "SELECT s FROM ScheduleItinerary s"),
    @NamedQuery(name = "ScheduleItinerary.findByPid", query = "SELECT s FROM ScheduleItinerary s WHERE s.pid = :pid"),
    @NamedQuery(name = "ScheduleItinerary.findByPersistentKlassName", query = "SELECT s FROM ScheduleItinerary s WHERE s.persistentKlassName = :persistentKlassName"),
    @NamedQuery(name = "ScheduleItinerary.findByColor", query = "SELECT s FROM ScheduleItinerary s WHERE s.color = :color")})
public class ScheduleItinerary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @Column(name = "color")
    private Integer color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidSchIti")
    private Collection<ScheduleItineraryTrip> scheduleItineraryTripCollection;
    @JoinColumn(name = "pid_schedule", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private Schedule pidSchedule;
    @JoinColumn(name = "pid_distance", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private ItineraryDistance pidDistance;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public ScheduleItinerary() {
    }

    public ScheduleItinerary(Long pid) {
        this.pid = pid;
    }

    public ScheduleItinerary(Long pid, String persistentKlassName) {
        this.pid = pid;
        this.persistentKlassName = persistentKlassName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPersistentKlassName() {
        return persistentKlassName;
    }

    public void setPersistentKlassName(String persistentKlassName) {
        this.persistentKlassName = persistentKlassName;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @XmlTransient
    public Collection<ScheduleItineraryTrip> getScheduleItineraryTripCollection() {
        return scheduleItineraryTripCollection;
    }

    public void setScheduleItineraryTripCollection(Collection<ScheduleItineraryTrip> scheduleItineraryTripCollection) {
        this.scheduleItineraryTripCollection = scheduleItineraryTripCollection;
    }

    public Schedule getPidSchedule() {
        return pidSchedule;
    }

    public void setPidSchedule(Schedule pidSchedule) {
        this.pidSchedule = pidSchedule;
    }

    public ItineraryDistance getPidDistance() {
        return pidDistance;
    }

    public void setPidDistance(ItineraryDistance pidDistance) {
        this.pidDistance = pidDistance;
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
        if (!(object instanceof ScheduleItinerary)) {
            return false;
        }
        ScheduleItinerary other = (ScheduleItinerary) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.ScheduleItinerary[ pid=" + pid + " ]";
    }
    
}
