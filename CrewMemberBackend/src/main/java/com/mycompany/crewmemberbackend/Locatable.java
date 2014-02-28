/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.crewmemberbackend;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francesco
 */
@Entity
@Table(name = "locatable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locatable.findAll", query = "SELECT l FROM Locatable l"),
    @NamedQuery(name = "Locatable.findByPid", query = "SELECT l FROM Locatable l WHERE l.pid = :pid"),
    @NamedQuery(name = "Locatable.findByCode", query = "SELECT l FROM Locatable l WHERE l.code = :code"),
    @NamedQuery(name = "Locatable.findByPersistentKlassName", query = "SELECT l FROM Locatable l WHERE l.persistentKlassName = :persistentKlassName")})
public class Locatable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @JoinColumn(name = "pid_geographic_point", referencedColumnName = "PID")
    @ManyToOne
    private GeographicPoint pidGeographicPoint;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "locatable")
    private Garage garage;

    public Locatable() {
    }

    public Locatable(Long pid) {
        this.pid = pid;
    }

    public Locatable(Long pid, String code, String persistentKlassName) {
        this.pid = pid;
        this.code = code;
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

    public String getPersistentKlassName() {
        return persistentKlassName;
    }

    public void setPersistentKlassName(String persistentKlassName) {
        this.persistentKlassName = persistentKlassName;
    }

    public GeographicPoint getPidGeographicPoint() {
        return pidGeographicPoint;
    }

    public void setPidGeographicPoint(GeographicPoint pidGeographicPoint) {
        this.pidGeographicPoint = pidGeographicPoint;
    }

    public Status getPidStatus() {
        return pidStatus;
    }

    public void setPidStatus(Status pidStatus) {
        this.pidStatus = pidStatus;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
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
        if (!(object instanceof Locatable)) {
            return false;
        }
        Locatable other = (Locatable) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.Locatable[ pid=" + pid + " ]";
    }
    
}
