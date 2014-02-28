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
@Table(name = "block_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlockEvent.findAll", query = "SELECT b FROM BlockEvent b"),
    @NamedQuery(name = "BlockEvent.findByPid", query = "SELECT b FROM BlockEvent b WHERE b.pid = :pid"),
    @NamedQuery(name = "BlockEvent.findByPersistentKlassName", query = "SELECT b FROM BlockEvent b WHERE b.persistentKlassName = :persistentKlassName"),
    @NamedQuery(name = "BlockEvent.findByEventKind", query = "SELECT b FROM BlockEvent b WHERE b.eventKind = :eventKind"),
    @NamedQuery(name = "BlockEvent.findByStartTime", query = "SELECT b FROM BlockEvent b WHERE b.startTime = :startTime"),
    @NamedQuery(name = "BlockEvent.findByTime", query = "SELECT b FROM BlockEvent b WHERE b.time = :time"),
    @NamedQuery(name = "BlockEvent.findByDistance", query = "SELECT b FROM BlockEvent b WHERE b.distance = :distance"),
    @NamedQuery(name = "BlockEvent.findByPosition", query = "SELECT b FROM BlockEvent b WHERE b.position = :position")})
public class BlockEvent implements Serializable {
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
    @Column(name = "event_kind")
    private short eventKind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    private short startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    private short time;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "distance")
    private BigDecimal distance;
    @Column(name = "position")
    private Integer position;
    @OneToMany(mappedBy = "pidBlockEvent")
    private Collection<CrewMemberEvent> crewMemberEventCollection;
    @JoinColumn(name = "pid_sch_iti_trip", referencedColumnName = "PID")
    @ManyToOne
    private ScheduleItineraryTrip pidSchItiTrip;
    @JoinColumn(name = "pid_block", referencedColumnName = "PID")
    @ManyToOne
    private Block pidBlock;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public BlockEvent() {
    }

    public BlockEvent(Long pid) {
        this.pid = pid;
    }

    public BlockEvent(Long pid, String persistentKlassName, short eventKind, short startTime, short time) {
        this.pid = pid;
        this.persistentKlassName = persistentKlassName;
        this.eventKind = eventKind;
        this.startTime = startTime;
        this.time = time;
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

    public short getEventKind() {
        return eventKind;
    }

    public void setEventKind(short eventKind) {
        this.eventKind = eventKind;
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

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @XmlTransient
    public Collection<CrewMemberEvent> getCrewMemberEventCollection() {
        return crewMemberEventCollection;
    }

    public void setCrewMemberEventCollection(Collection<CrewMemberEvent> crewMemberEventCollection) {
        this.crewMemberEventCollection = crewMemberEventCollection;
    }

    public ScheduleItineraryTrip getPidSchItiTrip() {
        return pidSchItiTrip;
    }

    public void setPidSchItiTrip(ScheduleItineraryTrip pidSchItiTrip) {
        this.pidSchItiTrip = pidSchItiTrip;
    }

    public Block getPidBlock() {
        return pidBlock;
    }

    public void setPidBlock(Block pidBlock) {
        this.pidBlock = pidBlock;
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
        if (!(object instanceof BlockEvent)) {
            return false;
        }
        BlockEvent other = (BlockEvent) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.BlockEvent[ pid=" + pid + " ]";
    }
    
}
