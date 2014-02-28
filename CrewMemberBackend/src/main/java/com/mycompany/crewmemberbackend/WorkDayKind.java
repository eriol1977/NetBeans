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
@Table(name = "work_day_kind")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkDayKind.findAll", query = "SELECT w FROM WorkDayKind w"),
    @NamedQuery(name = "WorkDayKind.findByPid", query = "SELECT w FROM WorkDayKind w WHERE w.pid = :pid"),
    @NamedQuery(name = "WorkDayKind.findByBenefits", query = "SELECT w FROM WorkDayKind w WHERE w.benefits = :benefits"),
    @NamedQuery(name = "WorkDayKind.findByCode", query = "SELECT w FROM WorkDayKind w WHERE w.code = :code"),
    @NamedQuery(name = "WorkDayKind.findByHasBenefits", query = "SELECT w FROM WorkDayKind w WHERE w.hasBenefits = :hasBenefits"),
    @NamedQuery(name = "WorkDayKind.findByMaxBreak", query = "SELECT w FROM WorkDayKind w WHERE w.maxBreak = :maxBreak"),
    @NamedQuery(name = "WorkDayKind.findByMaxHoursAfterBreak", query = "SELECT w FROM WorkDayKind w WHERE w.maxHoursAfterBreak = :maxHoursAfterBreak"),
    @NamedQuery(name = "WorkDayKind.findByMaxHoursBeforeBreak", query = "SELECT w FROM WorkDayKind w WHERE w.maxHoursBeforeBreak = :maxHoursBeforeBreak"),
    @NamedQuery(name = "WorkDayKind.findByMaxWorkDay", query = "SELECT w FROM WorkDayKind w WHERE w.maxWorkDay = :maxWorkDay"),
    @NamedQuery(name = "WorkDayKind.findByMinBreak", query = "SELECT w FROM WorkDayKind w WHERE w.minBreak = :minBreak"),
    @NamedQuery(name = "WorkDayKind.findByMinHoursAfterBreak", query = "SELECT w FROM WorkDayKind w WHERE w.minHoursAfterBreak = :minHoursAfterBreak"),
    @NamedQuery(name = "WorkDayKind.findByMinHoursBeforeBreak", query = "SELECT w FROM WorkDayKind w WHERE w.minHoursBeforeBreak = :minHoursBeforeBreak"),
    @NamedQuery(name = "WorkDayKind.findByMinPaidWorkDay", query = "SELECT w FROM WorkDayKind w WHERE w.minPaidWorkDay = :minPaidWorkDay"),
    @NamedQuery(name = "WorkDayKind.findByMinWorkDay", query = "SELECT w FROM WorkDayKind w WHERE w.minWorkDay = :minWorkDay"),
    @NamedQuery(name = "WorkDayKind.findByPaidBreak", query = "SELECT w FROM WorkDayKind w WHERE w.paidBreak = :paidBreak"),
    @NamedQuery(name = "WorkDayKind.findByPersistentKlassName", query = "SELECT w FROM WorkDayKind w WHERE w.persistentKlassName = :persistentKlassName"),
    @NamedQuery(name = "WorkDayKind.findByMaxBreaksNumber", query = "SELECT w FROM WorkDayKind w WHERE w.maxBreaksNumber = :maxBreaksNumber")})
public class WorkDayKind implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private Long pid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "benefits")
    private BigDecimal benefits;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_benefits")
    private short hasBenefits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_break")
    private short maxBreak;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_hours_after_break")
    private short maxHoursAfterBreak;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_hours_before_break")
    private short maxHoursBeforeBreak;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_work_day")
    private short maxWorkDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_break")
    private short minBreak;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_hours_after_break")
    private short minHoursAfterBreak;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_hours_before_break")
    private short minHoursBeforeBreak;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_paid_work_day")
    private short minPaidWorkDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_work_day")
    private short minWorkDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paid_break")
    private short paidBreak;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "persistentKlassName")
    private String persistentKlassName;
    @Column(name = "max_breaks_number")
    private Short maxBreaksNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pidWorkdaykind")
    private Collection<ScheduleWorkDayKind> scheduleWorkDayKindCollection;
    @JoinColumn(name = "pid_status", referencedColumnName = "PID")
    @ManyToOne
    private Status pidStatus;

    public WorkDayKind() {
    }

    public WorkDayKind(Long pid) {
        this.pid = pid;
    }

    public WorkDayKind(Long pid, String code, short hasBenefits, short maxBreak, short maxHoursAfterBreak, short maxHoursBeforeBreak, short maxWorkDay, short minBreak, short minHoursAfterBreak, short minHoursBeforeBreak, short minPaidWorkDay, short minWorkDay, short paidBreak, String persistentKlassName) {
        this.pid = pid;
        this.code = code;
        this.hasBenefits = hasBenefits;
        this.maxBreak = maxBreak;
        this.maxHoursAfterBreak = maxHoursAfterBreak;
        this.maxHoursBeforeBreak = maxHoursBeforeBreak;
        this.maxWorkDay = maxWorkDay;
        this.minBreak = minBreak;
        this.minHoursAfterBreak = minHoursAfterBreak;
        this.minHoursBeforeBreak = minHoursBeforeBreak;
        this.minPaidWorkDay = minPaidWorkDay;
        this.minWorkDay = minWorkDay;
        this.paidBreak = paidBreak;
        this.persistentKlassName = persistentKlassName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public BigDecimal getBenefits() {
        return benefits;
    }

    public void setBenefits(BigDecimal benefits) {
        this.benefits = benefits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public short getHasBenefits() {
        return hasBenefits;
    }

    public void setHasBenefits(short hasBenefits) {
        this.hasBenefits = hasBenefits;
    }

    public short getMaxBreak() {
        return maxBreak;
    }

    public void setMaxBreak(short maxBreak) {
        this.maxBreak = maxBreak;
    }

    public short getMaxHoursAfterBreak() {
        return maxHoursAfterBreak;
    }

    public void setMaxHoursAfterBreak(short maxHoursAfterBreak) {
        this.maxHoursAfterBreak = maxHoursAfterBreak;
    }

    public short getMaxHoursBeforeBreak() {
        return maxHoursBeforeBreak;
    }

    public void setMaxHoursBeforeBreak(short maxHoursBeforeBreak) {
        this.maxHoursBeforeBreak = maxHoursBeforeBreak;
    }

    public short getMaxWorkDay() {
        return maxWorkDay;
    }

    public void setMaxWorkDay(short maxWorkDay) {
        this.maxWorkDay = maxWorkDay;
    }

    public short getMinBreak() {
        return minBreak;
    }

    public void setMinBreak(short minBreak) {
        this.minBreak = minBreak;
    }

    public short getMinHoursAfterBreak() {
        return minHoursAfterBreak;
    }

    public void setMinHoursAfterBreak(short minHoursAfterBreak) {
        this.minHoursAfterBreak = minHoursAfterBreak;
    }

    public short getMinHoursBeforeBreak() {
        return minHoursBeforeBreak;
    }

    public void setMinHoursBeforeBreak(short minHoursBeforeBreak) {
        this.minHoursBeforeBreak = minHoursBeforeBreak;
    }

    public short getMinPaidWorkDay() {
        return minPaidWorkDay;
    }

    public void setMinPaidWorkDay(short minPaidWorkDay) {
        this.minPaidWorkDay = minPaidWorkDay;
    }

    public short getMinWorkDay() {
        return minWorkDay;
    }

    public void setMinWorkDay(short minWorkDay) {
        this.minWorkDay = minWorkDay;
    }

    public short getPaidBreak() {
        return paidBreak;
    }

    public void setPaidBreak(short paidBreak) {
        this.paidBreak = paidBreak;
    }

    public String getPersistentKlassName() {
        return persistentKlassName;
    }

    public void setPersistentKlassName(String persistentKlassName) {
        this.persistentKlassName = persistentKlassName;
    }

    public Short getMaxBreaksNumber() {
        return maxBreaksNumber;
    }

    public void setMaxBreaksNumber(Short maxBreaksNumber) {
        this.maxBreaksNumber = maxBreaksNumber;
    }

    @XmlTransient
    public Collection<ScheduleWorkDayKind> getScheduleWorkDayKindCollection() {
        return scheduleWorkDayKindCollection;
    }

    public void setScheduleWorkDayKindCollection(Collection<ScheduleWorkDayKind> scheduleWorkDayKindCollection) {
        this.scheduleWorkDayKindCollection = scheduleWorkDayKindCollection;
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
        if (!(object instanceof WorkDayKind)) {
            return false;
        }
        WorkDayKind other = (WorkDayKind) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.WorkDayKind[ pid=" + pid + " ]";
    }
    
}
