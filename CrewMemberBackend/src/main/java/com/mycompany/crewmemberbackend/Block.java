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
@Table(name = "block")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Block.findAll", query = "SELECT b FROM Block b"),
    @NamedQuery(name = "Block.findByPid", query = "SELECT b FROM Block b WHERE b.pid = :pid"),
    @NamedQuery(name = "Block.findByCode", query = "SELECT b FROM Block b WHERE b.code = :code"),
    @NamedQuery(name = "Block.findByPersistentKlassName", query = "SELECT b FROM Block b WHERE b.persistentKlassName = :persistentKlassName")})
public class Block implements Serializable {
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
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @JoinColumn(name = "pid_vehicle_cost", referencedColumnName = "PID")
    @ManyToOne
    private VehicleCost pidVehicleCost;
    @JoinColumn(name = "pid_pullout_garage", referencedColumnName = "pid")
    @ManyToOne
    private Garage pidPulloutGarage;
    @JoinColumn(name = "pid_pullin_garage", referencedColumnName = "pid")
    @ManyToOne
    private Garage pidPullinGarage;
    @JoinColumn(name = "pid_vehicle", referencedColumnName = "PID")
    @ManyToOne
    private Vehicle pidVehicle;
    @JoinColumn(name = "pid_company", referencedColumnName = "PID")
    @ManyToOne
    private Company pidCompany;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;
    @OneToMany(mappedBy = "pidBlock")
    private Collection<BlockEvent> blockEventCollection;

    public Block() {
    }

    public Block(Long pid) {
        this.pid = pid;
    }

    public Block(Long pid, String code, String persistentKlassName) {
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

    public VehicleCost getPidVehicleCost() {
        return pidVehicleCost;
    }

    public void setPidVehicleCost(VehicleCost pidVehicleCost) {
        this.pidVehicleCost = pidVehicleCost;
    }

    public Garage getPidPulloutGarage() {
        return pidPulloutGarage;
    }

    public void setPidPulloutGarage(Garage pidPulloutGarage) {
        this.pidPulloutGarage = pidPulloutGarage;
    }

    public Garage getPidPullinGarage() {
        return pidPullinGarage;
    }

    public void setPidPullinGarage(Garage pidPullinGarage) {
        this.pidPullinGarage = pidPullinGarage;
    }

    public Vehicle getPidVehicle() {
        return pidVehicle;
    }

    public void setPidVehicle(Vehicle pidVehicle) {
        this.pidVehicle = pidVehicle;
    }

    public Company getPidCompany() {
        return pidCompany;
    }

    public void setPidCompany(Company pidCompany) {
        this.pidCompany = pidCompany;
    }

    public Status getPidStatus() {
        return pidStatus;
    }

    public void setPidStatus(Status pidStatus) {
        this.pidStatus = pidStatus;
    }

    @XmlTransient
    public Collection<BlockEvent> getBlockEventCollection() {
        return blockEventCollection;
    }

    public void setBlockEventCollection(Collection<BlockEvent> blockEventCollection) {
        this.blockEventCollection = blockEventCollection;
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
        if (!(object instanceof Block)) {
            return false;
        }
        Block other = (Block) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.Block[ pid=" + pid + " ]";
    }
    
}
