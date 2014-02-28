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
@Table(name = "schedule_work_day_kind")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduleWorkDayKind.findAll", query = "SELECT s FROM ScheduleWorkDayKind s"),
    @NamedQuery(name = "ScheduleWorkDayKind.findByPid", query = "SELECT s FROM ScheduleWorkDayKind s WHERE s.pid = :pid"),
    @NamedQuery(name = "ScheduleWorkDayKind.findByPersistentKlassName", query = "SELECT s FROM ScheduleWorkDayKind s WHERE s.persistentKlassName = :persistentKlassName")})
public class ScheduleWorkDayKind implements Serializable {
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
    @OneToMany(mappedBy = "pidSchWrkDayKnd")
    private Collection<CrewMember> crewMemberCollection;
    @JoinColumn(name = "pid_workdaykind", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private WorkDayKind pidWorkdaykind;
    @JoinColumn(name = "pid_schedule", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private Schedule pidSchedule;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public ScheduleWorkDayKind() {
    }

    public ScheduleWorkDayKind(Long pid) {
        this.pid = pid;
    }

    public ScheduleWorkDayKind(Long pid, String persistentKlassName) {
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

    @XmlTransient
    public Collection<CrewMember> getCrewMemberCollection() {
        return crewMemberCollection;
    }

    public void setCrewMemberCollection(Collection<CrewMember> crewMemberCollection) {
        this.crewMemberCollection = crewMemberCollection;
    }

    public WorkDayKind getPidWorkdaykind() {
        return pidWorkdaykind;
    }

    public void setPidWorkdaykind(WorkDayKind pidWorkdaykind) {
        this.pidWorkdaykind = pidWorkdaykind;
    }

    public Schedule getPidSchedule() {
        return pidSchedule;
    }

    public void setPidSchedule(Schedule pidSchedule) {
        this.pidSchedule = pidSchedule;
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
        if (!(object instanceof ScheduleWorkDayKind)) {
            return false;
        }
        ScheduleWorkDayKind other = (ScheduleWorkDayKind) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.ScheduleWorkDayKind[ pid=" + pid + " ]";
    }
    
}
