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
@Table(name = "quarter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quarter.findAll", query = "SELECT q FROM Quarter q"),
    @NamedQuery(name = "Quarter.findByPid", query = "SELECT q FROM Quarter q WHERE q.pid = :pid"),
    @NamedQuery(name = "Quarter.findByName", query = "SELECT q FROM Quarter q WHERE q.name = :name"),
    @NamedQuery(name = "Quarter.findByPersistentKlassName", query = "SELECT q FROM Quarter q WHERE q.persistentKlassName = :persistentKlassName")})
public class Quarter implements Serializable {
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
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidQuarter")
    private Collection<Location> locationCollection;
    @JoinColumn(name = "pid_city", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private City pidCity;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public Quarter() {
    }

    public Quarter(Long pid) {
        this.pid = pid;
    }

    public Quarter(Long pid, String name, String persistentKlassName) {
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
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    public City getPidCity() {
        return pidCity;
    }

    public void setPidCity(City pidCity) {
        this.pidCity = pidCity;
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
        if (!(object instanceof Quarter)) {
            return false;
        }
        Quarter other = (Quarter) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.Quarter[ pid=" + pid + " ]";
    }
    
}
