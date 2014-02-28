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
@Table(name = "itinerary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itinerary.findAll", query = "SELECT i FROM Itinerary i"),
    @NamedQuery(name = "Itinerary.findByPid", query = "SELECT i FROM Itinerary i WHERE i.pid = :pid"),
    @NamedQuery(name = "Itinerary.findByDirection", query = "SELECT i FROM Itinerary i WHERE i.direction = :direction"),
    @NamedQuery(name = "Itinerary.findByKind", query = "SELECT i FROM Itinerary i WHERE i.kind = :kind"),
    @NamedQuery(name = "Itinerary.findByAvrgSupplyCapacity", query = "SELECT i FROM Itinerary i WHERE i.avrgSupplyCapacity = :avrgSupplyCapacity"),
    @NamedQuery(name = "Itinerary.findByPersistentKlassName", query = "SELECT i FROM Itinerary i WHERE i.persistentKlassName = :persistentKlassName"),
    @NamedQuery(name = "Itinerary.findByColor", query = "SELECT i FROM Itinerary i WHERE i.color = :color")})
public class Itinerary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "direction")
    private short direction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kind")
    private short kind;
    @Column(name = "avrg_supply_capacity")
    private Integer avrgSupplyCapacity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @Column(name = "color")
    private Integer color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidItinerary")
    private Collection<ItineraryDistance> itineraryDistanceCollection;
    @JoinColumn(name = "pid_line", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private Line pidLine;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public Itinerary() {
    }

    public Itinerary(Long pid) {
        this.pid = pid;
    }

    public Itinerary(Long pid, short direction, short kind, String persistentKlassName) {
        this.pid = pid;
        this.direction = direction;
        this.kind = kind;
        this.persistentKlassName = persistentKlassName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public short getDirection() {
        return direction;
    }

    public void setDirection(short direction) {
        this.direction = direction;
    }

    public short getKind() {
        return kind;
    }

    public void setKind(short kind) {
        this.kind = kind;
    }

    public Integer getAvrgSupplyCapacity() {
        return avrgSupplyCapacity;
    }

    public void setAvrgSupplyCapacity(Integer avrgSupplyCapacity) {
        this.avrgSupplyCapacity = avrgSupplyCapacity;
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
    public Collection<ItineraryDistance> getItineraryDistanceCollection() {
        return itineraryDistanceCollection;
    }

    public void setItineraryDistanceCollection(Collection<ItineraryDistance> itineraryDistanceCollection) {
        this.itineraryDistanceCollection = itineraryDistanceCollection;
    }

    public Line getPidLine() {
        return pidLine;
    }

    public void setPidLine(Line pidLine) {
        this.pidLine = pidLine;
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
        if (!(object instanceof Itinerary)) {
            return false;
        }
        Itinerary other = (Itinerary) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.Itinerary[ pid=" + pid + " ]";
    }
    
}
