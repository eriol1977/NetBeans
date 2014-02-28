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
@Table(name = "crew_member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrewMember.findAll", query = "SELECT c FROM CrewMember c"),
    @NamedQuery(name = "CrewMember.findByPid", query = "SELECT c FROM CrewMember c WHERE c.pid = :pid"),
    @NamedQuery(name = "CrewMember.findByCode", query = "SELECT c FROM CrewMember c WHERE c.code = :code"),
    @NamedQuery(name = "CrewMember.findByKind", query = "SELECT c FROM CrewMember c WHERE c.kind = :kind"),
    @NamedQuery(name = "CrewMember.findByPersistentKlassName", query = "SELECT c FROM CrewMember c WHERE c.persistentKlassName = :persistentKlassName")})
public class CrewMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kind")
    private short kind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @OneToMany(mappedBy = "pidCrewMember")
    private Collection<CrewMemberEvent> crewMemberEventCollection;
    @JoinColumn(name = "pid_sch_wrk_day_knd", referencedColumnName = "PID")
    @ManyToOne
    private ScheduleWorkDayKind pidSchWrkDayKnd;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public CrewMember() {
    }

    public CrewMember(Long pid) {
        this.pid = pid;
    }

    public CrewMember(Long pid, String code, short kind, String persistentKlassName) {
        this.pid = pid;
        this.code = code;
        this.kind = kind;
        this.persistentKlassName = persistentKlassName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public short getKind() {
        return kind;
    }

    public void setKind(short kind) {
        this.kind = kind;
    }

    public String getPersistentKlassName() {
        return persistentKlassName;
    }

    public void setPersistentKlassName(String persistentKlassName) {
        this.persistentKlassName = persistentKlassName;
    }

    @XmlTransient
    public Collection<CrewMemberEvent> getCrewMemberEventCollection() {
        return crewMemberEventCollection;
    }

    public void setCrewMemberEventCollection(Collection<CrewMemberEvent> crewMemberEventCollection) {
        this.crewMemberEventCollection = crewMemberEventCollection;
    }

    public ScheduleWorkDayKind getPidSchWrkDayKnd() {
        return pidSchWrkDayKnd;
    }

    public void setPidSchWrkDayKnd(ScheduleWorkDayKind pidSchWrkDayKnd) {
        this.pidSchWrkDayKnd = pidSchWrkDayKnd;
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
        if (!(object instanceof CrewMember)) {
            return false;
        }
        CrewMember other = (CrewMember) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.CrewMember[ pid=" + pid + " ]";
    }
    
}
