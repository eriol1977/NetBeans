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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "garage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garage.findAll", query = "SELECT g FROM Garage g"),
    @NamedQuery(name = "Garage.findByPid", query = "SELECT g FROM Garage g WHERE g.pid = :pid"),
    @NamedQuery(name = "Garage.findByName", query = "SELECT g FROM Garage g WHERE g.name = :name"),
    @NamedQuery(name = "Garage.findByDetectionCode", query = "SELECT g FROM Garage g WHERE g.detectionCode = :detectionCode")})
public class Garage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pid")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 10)
    @Column(name = "detectionCode")
    private String detectionCode;
    @JoinColumn(name = "pid", referencedColumnName = "PID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Locatable locatable;
    @OneToMany(mappedBy = "pidPulloutGarage")
    private Collection<Block> blockCollection;
    @OneToMany(mappedBy = "pidPullinGarage")
    private Collection<Block> blockCollection1;

    public Garage() {
    }

    public Garage(Long pid) {
        this.pid = pid;
    }

    public Garage(Long pid, String name) {
        this.pid = pid;
        this.name = name;
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

    public String getDetectionCode() {
        return detectionCode;
    }

    public void setDetectionCode(String detectionCode) {
        this.detectionCode = detectionCode;
    }

    public Locatable getLocatable() {
        return locatable;
    }

    public void setLocatable(Locatable locatable) {
        this.locatable = locatable;
    }

    @XmlTransient
    public Collection<Block> getBlockCollection() {
        return blockCollection;
    }

    public void setBlockCollection(Collection<Block> blockCollection) {
        this.blockCollection = blockCollection;
    }

    @XmlTransient
    public Collection<Block> getBlockCollection1() {
        return blockCollection1;
    }

    public void setBlockCollection1(Collection<Block> blockCollection1) {
        this.blockCollection1 = blockCollection1;
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
        if (!(object instanceof Garage)) {
            return false;
        }
        Garage other = (Garage) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.Garage[ pid=" + pid + " ]";
    }
    
}
