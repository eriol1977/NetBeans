/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.crewmemberbackend;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francesco
 */
@Entity
@Table(name = "crew_member_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrewMemberEvent.findAll", query = "SELECT c FROM CrewMemberEvent c"),
    @NamedQuery(name = "CrewMemberEvent.findByPid", query = "SELECT c FROM CrewMemberEvent c WHERE c.pid = :pid"),
    @NamedQuery(name = "CrewMemberEvent.findByPersistentKlassName", query = "SELECT c FROM CrewMemberEvent c WHERE c.persistentKlassName = :persistentKlassName"),
    @NamedQuery(name = "CrewMemberEvent.findByStartTime", query = "SELECT c FROM CrewMemberEvent c WHERE c.startTime = :startTime"),
    @NamedQuery(name = "CrewMemberEvent.findByTime", query = "SELECT c FROM CrewMemberEvent c WHERE c.time = :time"),
    @NamedQuery(name = "CrewMemberEvent.findByEventKind", query = "SELECT c FROM CrewMemberEvent c WHERE c.eventKind = :eventKind"),
    @NamedQuery(name = "CrewMemberEvent.findByFirstStretchIndex", query = "SELECT c FROM CrewMemberEvent c WHERE c.firstStretchIndex = :firstStretchIndex"),
    @NamedQuery(name = "CrewMemberEvent.findByLastStretchIndex", query = "SELECT c FROM CrewMemberEvent c WHERE c.lastStretchIndex = :lastStretchIndex"),
    @NamedQuery(name = "CrewMemberEvent.findByPosition", query = "SELECT c FROM CrewMemberEvent c WHERE c.position = :position")})
public class CrewMemberEvent implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    private short startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    private short time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_kind")
    private short eventKind;
    @Column(name = "first_stretch_index")
    private Short firstStretchIndex;
    @Column(name = "last_stretch_index")
    private Short lastStretchIndex;
    @Column(name = "position")
    private Integer position;
    @JoinColumn(name = "pid_block_event", referencedColumnName = "PID")
    @ManyToOne
    private BlockEvent pidBlockEvent;
    @JoinColumn(name = "pid_generic_event", referencedColumnName = "PID")
    @ManyToOne
    private CrewMemberGenericEvents pidGenericEvent;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;
    @JoinColumn(name = "pid_crew_member", referencedColumnName = "PID")
    @ManyToOne
    private CrewMember pidCrewMember;

    public CrewMemberEvent() {
    }

    public CrewMemberEvent(Long pid) {
        this.pid = pid;
    }

    public CrewMemberEvent(Long pid, String persistentKlassName, short startTime, short time, short eventKind) {
        this.pid = pid;
        this.persistentKlassName = persistentKlassName;
        this.startTime = startTime;
        this.time = time;
        this.eventKind = eventKind;
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

    public short getStartTime() {
        return startTime;
    }

    public void setStartTime(short startTime) {
        this.startTime = startTime;
    }

    public short getTime() {
        return time;
    }

    public void setTime(short time) {
        this.time = time;
    }

    public short getEventKind() {
        return eventKind;
    }

    public void setEventKind(short eventKind) {
        this.eventKind = eventKind;
    }

    public Short getFirstStretchIndex() {
        return firstStretchIndex;
    }

    public void setFirstStretchIndex(Short firstStretchIndex) {
        this.firstStretchIndex = firstStretchIndex;
    }

    public Short getLastStretchIndex() {
        return lastStretchIndex;
    }

    public void setLastStretchIndex(Short lastStretchIndex) {
        this.lastStretchIndex = lastStretchIndex;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public BlockEvent getPidBlockEvent() {
        return pidBlockEvent;
    }

    public void setPidBlockEvent(BlockEvent pidBlockEvent) {
        this.pidBlockEvent = pidBlockEvent;
    }

    public CrewMemberGenericEvents getPidGenericEvent() {
        return pidGenericEvent;
    }

    public void setPidGenericEvent(CrewMemberGenericEvents pidGenericEvent) {
        this.pidGenericEvent = pidGenericEvent;
    }

    public Status getPidStatus() {
        return pidStatus;
    }

    public void setPidStatus(Status pidStatus) {
        this.pidStatus = pidStatus;
    }

    public CrewMember getPidCrewMember() {
        return pidCrewMember;
    }

    public void setPidCrewMember(CrewMember pidCrewMember) {
        this.pidCrewMember = pidCrewMember;
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
        if (!(object instanceof CrewMemberEvent)) {
            return false;
        }
        CrewMemberEvent other = (CrewMemberEvent) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.CrewMemberEvent[ pid=" + pid + " ]";
    }
    
}
