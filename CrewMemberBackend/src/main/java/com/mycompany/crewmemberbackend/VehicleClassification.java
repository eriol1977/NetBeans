/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.crewmemberbackend;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "vehicle_classification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleClassification.findAll", query = "SELECT v FROM VehicleClassification v"),
    @NamedQuery(name = "VehicleClassification.findByPid", query = "SELECT v FROM VehicleClassification v WHERE v.pid = :pid"),
    @NamedQuery(name = "VehicleClassification.findByCapacity", query = "SELECT v FROM VehicleClassification v WHERE v.capacity = :capacity"),
    @NamedQuery(name = "VehicleClassification.findBySeats", query = "SELECT v FROM VehicleClassification v WHERE v.seats = :seats"),
    @NamedQuery(name = "VehicleClassification.findByPersistentKlassName", query = "SELECT v FROM VehicleClassification v WHERE v.persistentKlassName = :persistentKlassName"),
    @NamedQuery(name = "VehicleClassification.findByPidStatus", query = "SELECT v FROM VehicleClassification v WHERE v.pidStatus = :pidStatus")})
public class VehicleClassification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacity")
    private short capacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seats")
    private short seats;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @Column(name = "pid_status")
    private BigInteger pidStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidVehicleClassification")
    private Collection<VehicleCost> vehicleCostCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidClassification")
    private Collection<Vehicle> vehicleCollection;

    public VehicleClassification() {
    }

    public VehicleClassification(Long pid) {
        this.pid = pid;
    }

    public VehicleClassification(Long pid, short capacity, short seats, String persistentKlassName) {
        this.pid = pid;
        this.capacity = capacity;
        this.seats = seats;
        this.persistentKlassName = persistentKlassName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public short getSeats() {
        return seats;
    }

    public void setSeats(short seats) {
        this.seats = seats;
    }

    public String getPersistentKlassName() {
        return persistentKlassName;
    }

    public void setPersistentKlassName(String persistentKlassName) {
        this.persistentKlassName = persistentKlassName;
    }

    public BigInteger getPidStatus() {
        return pidStatus;
    }

    public void setPidStatus(BigInteger pidStatus) {
        this.pidStatus = pidStatus;
    }

    @XmlTransient
    public Collection<VehicleCost> getVehicleCostCollection() {
        return vehicleCostCollection;
    }

    public void setVehicleCostCollection(Collection<VehicleCost> vehicleCostCollection) {
        this.vehicleCostCollection = vehicleCostCollection;
    }

    @XmlTransient
    public Collection<Vehicle> getVehicleCollection() {
        return vehicleCollection;
    }

    public void setVehicleCollection(Collection<Vehicle> vehicleCollection) {
        this.vehicleCollection = vehicleCollection;
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
        if (!(object instanceof VehicleClassification)) {
            return false;
        }
        VehicleClassification other = (VehicleClassification) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.VehicleClassification[ pid=" + pid + " ]";
    }
    
}
