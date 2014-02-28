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
@Table(name = "line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Line.findAll", query = "SELECT l FROM Line l"),
    @NamedQuery(name = "Line.findByPid", query = "SELECT l FROM Line l WHERE l.pid = :pid"),
    @NamedQuery(name = "Line.findByCode", query = "SELECT l FROM Line l WHERE l.code = :code"),
    @NamedQuery(name = "Line.findByName", query = "SELECT l FROM Line l WHERE l.name = :name"),
    @NamedQuery(name = "Line.findByMessage", query = "SELECT l FROM Line l WHERE l.message = :message"),
    @NamedQuery(name = "Line.findByFare", query = "SELECT l FROM Line l WHERE l.fare = :fare"),
    @NamedQuery(name = "Line.findByPersistentKlassName", query = "SELECT l FROM Line l WHERE l.persistentKlassName = :persistentKlassName"),
    @NamedQuery(name = "Line.findByServiceCdStart", query = "SELECT l FROM Line l WHERE l.serviceCdStart = :serviceCdStart")})
public class Line implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "code")
    private String code;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "message")
    private String message;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fare")
    private BigDecimal fare;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @Column(name = "service_cd_start")
    private Integer serviceCdStart;
    @JoinColumn(name = "pid_line_group", referencedColumnName = "PID")
    @ManyToOne
    private LineGroup pidLineGroup;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidLine")
    private Collection<Itinerary> itineraryCollection;

    public Line() {
    }

    public Line(Long pid) {
        this.pid = pid;
    }

    public Line(Long pid, String code, String persistentKlassName) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public String getPersistentKlassName() {
        return persistentKlassName;
    }

    public void setPersistentKlassName(String persistentKlassName) {
        this.persistentKlassName = persistentKlassName;
    }

    public Integer getServiceCdStart() {
        return serviceCdStart;
    }

    public void setServiceCdStart(Integer serviceCdStart) {
        this.serviceCdStart = serviceCdStart;
    }

    public LineGroup getPidLineGroup() {
        return pidLineGroup;
    }

    public void setPidLineGroup(LineGroup pidLineGroup) {
        this.pidLineGroup = pidLineGroup;
    }

    public Status getPidStatus() {
        return pidStatus;
    }

    public void setPidStatus(Status pidStatus) {
        this.pidStatus = pidStatus;
    }

    @XmlTransient
    public Collection<Itinerary> getItineraryCollection() {
        return itineraryCollection;
    }

    public void setItineraryCollection(Collection<Itinerary> itineraryCollection) {
        this.itineraryCollection = itineraryCollection;
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
        if (!(object instanceof Line)) {
            return false;
        }
        Line other = (Line) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.Line[ pid=" + pid + " ]";
    }
    
}
