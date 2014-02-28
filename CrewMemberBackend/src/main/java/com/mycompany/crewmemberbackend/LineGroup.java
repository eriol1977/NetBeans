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
@Table(name = "line_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineGroup.findAll", query = "SELECT l FROM LineGroup l"),
    @NamedQuery(name = "LineGroup.findByPid", query = "SELECT l FROM LineGroup l WHERE l.pid = :pid"),
    @NamedQuery(name = "LineGroup.findByCode", query = "SELECT l FROM LineGroup l WHERE l.code = :code"),
    @NamedQuery(name = "LineGroup.findByName", query = "SELECT l FROM LineGroup l WHERE l.name = :name"),
    @NamedQuery(name = "LineGroup.findByPersistentKlassName", query = "SELECT l FROM LineGroup l WHERE l.persistentKlassName = :persistentKlassName")})
public class LineGroup implements Serializable {
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
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @OneToMany(mappedBy = "pidLineGroup")
    private Collection<Line> lineCollection;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public LineGroup() {
    }

    public LineGroup(Long pid) {
        this.pid = pid;
    }

    public LineGroup(Long pid, String code, String persistentKlassName) {
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

    public String getPersistentKlassName() {
        return persistentKlassName;
    }

    public void setPersistentKlassName(String persistentKlassName) {
        this.persistentKlassName = persistentKlassName;
    }

    @XmlTransient
    public Collection<Line> getLineCollection() {
        return lineCollection;
    }

    public void setLineCollection(Collection<Line> lineCollection) {
        this.lineCollection = lineCollection;
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
        if (!(object instanceof LineGroup)) {
            return false;
        }
        LineGroup other = (LineGroup) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.LineGroup[ pid=" + pid + " ]";
    }
    
}
