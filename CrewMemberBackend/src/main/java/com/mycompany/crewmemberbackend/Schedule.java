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
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByPid", query = "SELECT s FROM Schedule s WHERE s.pid = :pid"),
    @NamedQuery(name = "Schedule.findByName", query = "SELECT s FROM Schedule s WHERE s.name = :name"),
    @NamedQuery(name = "Schedule.findByFlags", query = "SELECT s FROM Schedule s WHERE s.flags = :flags"),
    @NamedQuery(name = "Schedule.findByRemarks", query = "SELECT s FROM Schedule s WHERE s.remarks = :remarks"),
    @NamedQuery(name = "Schedule.findByAverageFare", query = "SELECT s FROM Schedule s WHERE s.averageFare = :averageFare"),
    @NamedQuery(name = "Schedule.findByPersistentKlassName", query = "SELECT s FROM Schedule s WHERE s.persistentKlassName = :persistentKlassName")})
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flags")
    private long flags;
    @Size(max = 2000)
    @Column(name = "remarks")
    private String remarks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "averageFare")
    private BigDecimal averageFare;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidSchedule")
    private Collection<ScheduleItinerary> scheduleItineraryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidSchedule")
    private Collection<ScheduleWorkDayKind> scheduleWorkDayKindCollection;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public Schedule() {
    }

    public Schedule(Long pid) {
        this.pid = pid;
    }

    public Schedule(Long pid, String name, long flags, String persistentKlassName) {
        this.pid = pid;
        this.name = name;
        this.flags = flags;
        this.persistentKlassName = persistentKlassName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFlags() {
        return flags;
    }

    public void setFlags(long flags) {
        this.flags = flags;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getAverageFare() {
        return averageFare;
    }

    public void setAverageFare(BigDecimal averageFare) {
        this.averageFare = averageFare;
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

    @XmlTransient
    public Collection<ScheduleWorkDayKind> getScheduleWorkDayKindCollection() {
        return scheduleWorkDayKindCollection;
    }

    public void setScheduleWorkDayKindCollection(Collection<ScheduleWorkDayKind> scheduleWorkDayKindCollection) {
        this.scheduleWorkDayKindCollection = scheduleWorkDayKindCollection;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.Schedule[ pid=" + pid + " ]";
    }
    
}
