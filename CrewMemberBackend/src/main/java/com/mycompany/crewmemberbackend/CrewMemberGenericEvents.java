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
@Table(name = "crew_member_generic_events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrewMemberGenericEvents.findAll", query = "SELECT c FROM CrewMemberGenericEvents c"),
    @NamedQuery(name = "CrewMemberGenericEvents.findByPid", query = "SELECT c FROM CrewMemberGenericEvents c WHERE c.pid = :pid"),
    @NamedQuery(name = "CrewMemberGenericEvents.findByName", query = "SELECT c FROM CrewMemberGenericEvents c WHERE c.name = :name"),
    @NamedQuery(name = "CrewMemberGenericEvents.findByPersistentKlassName", query = "SELECT c FROM CrewMemberGenericEvents c WHERE c.persistentKlassName = :persistentKlassName")})
public class CrewMemberGenericEvents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @OneToMany(mappedBy = "pidGenericEvent")
    private Collection<CrewMemberEvent> crewMemberEventCollection;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public CrewMemberGenericEvents() {
    }

    public CrewMemberGenericEvents(Long pid) {
        this.pid = pid;
    }

    public CrewMemberGenericEvents(Long pid, String name, String persistentKlassName) {
        this.pid = pid;
        this.name = name;
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
        if (!(object instanceof CrewMemberGenericEvents)) {
            return false;
        }
        CrewMemberGenericEvents other = (CrewMemberGenericEvents) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.CrewMemberGenericEvents[ pid=" + pid + " ]";
    }
    
}
