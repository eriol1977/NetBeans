/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.crewmemberbackend;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "vehicle_cost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleCost.findAll", query = "SELECT v FROM VehicleCost v"),
    @NamedQuery(name = "VehicleCost.findByPid", query = "SELECT v FROM VehicleCost v WHERE v.pid = :pid"),
    @NamedQuery(name = "VehicleCost.findByStartDate", query = "SELECT v FROM VehicleCost v WHERE v.startDate = :startDate"),
    @NamedQuery(name = "VehicleCost.findByCostbykm", query = "SELECT v FROM VehicleCost v WHERE v.costbykm = :costbykm"),
    @NamedQuery(name = "VehicleCost.findByDriverValuebyhour", query = "SELECT v FROM VehicleCost v WHERE v.driverValuebyhour = :driverValuebyhour"),
    @NamedQuery(name = "VehicleCost.findByFareboxCollectorNeeded", query = "SELECT v FROM VehicleCost v WHERE v.fareboxCollectorNeeded = :fareboxCollectorNeeded"),
    @NamedQuery(name = "VehicleCost.findByFareboxcollectorValuebyhour", query = "SELECT v FROM VehicleCost v WHERE v.fareboxcollectorValuebyhour = :fareboxcollectorValuebyhour"),
    @NamedQuery(name = "VehicleCost.findByPersistentKlassName", query = "SELECT v FROM VehicleCost v WHERE v.persistentKlassName = :persistentKlassName"),
    @NamedQuery(name = "VehicleCost.findByPidStatus", query = "SELECT v FROM VehicleCost v WHERE v.pidStatus = :pidStatus")})
public class VehicleCost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    private int startDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costbykm")
    private BigDecimal costbykm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "driver_valuebyhour")
    private BigDecimal driverValuebyhour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "farebox_collector_needed")
    private short fareboxCollectorNeeded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fareboxcollector_valuebyhour")
    private BigDecimal fareboxcollectorValuebyhour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @Column(name = "pid_status")
    private BigInteger pidStatus;
    @JoinColumn(name = "pid_vehicle_classification", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private VehicleClassification pidVehicleClassification;
    @OneToMany(mappedBy = "pidVehicleCost")
    private Collection<Block> blockCollection;

    public VehicleCost() {
    }

    public VehicleCost(Long pid) {
        this.pid = pid;
    }

    public VehicleCost(Long pid, int startDate, BigDecimal costbykm, BigDecimal driverValuebyhour, short fareboxCollectorNeeded, BigDecimal fareboxcollectorValuebyhour, String persistentKlassName) {
        this.pid = pid;
        this.startDate = startDate;
        this.costbykm = costbykm;
        this.driverValuebyhour = driverValuebyhour;
        this.fareboxCollectorNeeded = fareboxCollectorNeeded;
        this.fareboxcollectorValuebyhour = fareboxcollectorValuebyhour;
        this.persistentKlassName = persistentKlassName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getCostbykm() {
        return costbykm;
    }

    public void setCostbykm(BigDecimal costbykm) {
        this.costbykm = costbykm;
    }

    public BigDecimal getDriverValuebyhour() {
        return driverValuebyhour;
    }

    public void setDriverValuebyhour(BigDecimal driverValuebyhour) {
        this.driverValuebyhour = driverValuebyhour;
    }

    public short getFareboxCollectorNeeded() {
        return fareboxCollectorNeeded;
    }

    public void setFareboxCollectorNeeded(short fareboxCollectorNeeded) {
        this.fareboxCollectorNeeded = fareboxCollectorNeeded;
    }

    public BigDecimal getFareboxcollectorValuebyhour() {
        return fareboxcollectorValuebyhour;
    }

    public void setFareboxcollectorValuebyhour(BigDecimal fareboxcollectorValuebyhour) {
        this.fareboxcollectorValuebyhour = fareboxcollectorValuebyhour;
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

    public VehicleClassification getPidVehicleClassification() {
        return pidVehicleClassification;
    }

    public void setPidVehicleClassification(VehicleClassification pidVehicleClassification) {
        this.pidVehicleClassification = pidVehicleClassification;
    }

    @XmlTransient
    public Collection<Block> getBlockCollection() {
        return blockCollection;
    }

    public void setBlockCollection(Collection<Block> blockCollection) {
        this.blockCollection = blockCollection;
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
        if (!(object instanceof VehicleCost)) {
            return false;
        }
        VehicleCost other = (VehicleCost) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.VehicleCost[ pid=" + pid + " ]";
    }
    
}
