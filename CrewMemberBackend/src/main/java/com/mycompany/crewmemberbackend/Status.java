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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Francesco
 */
@Entity
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByPid", query = "SELECT s FROM Status s WHERE s.pid = :pid"),
    @NamedQuery(name = "Status.findByStatusValue", query = "SELECT s FROM Status s WHERE s.statusValue = :statusValue"),
    @NamedQuery(name = "Status.findByCreationDate", query = "SELECT s FROM Status s WHERE s.creationDate = :creationDate"),
    @NamedQuery(name = "Status.findByLastChangeDate", query = "SELECT s FROM Status s WHERE s.lastChangeDate = :lastChangeDate"),
    @NamedQuery(name = "Status.findByPidPrincipal", query = "SELECT s FROM Status s WHERE s.pidPrincipal = :pidPrincipal")})
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PID")
    private Long pid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statusValue")
    private short statusValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creationDate")
    private long creationDate;
    @Column(name = "lastChangeDate")
    private BigInteger lastChangeDate;
    @Column(name = "pid_principal")
    private BigInteger pidPrincipal;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<GeographicPoint> geographicPointCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<CrewMemberEvent> crewMemberEventCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<CrewMemberGenericEvents> crewMemberGenericEventsCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<ScheduleItineraryTrip> scheduleItineraryTripCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<Location> locationCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<Locatable> locatableCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<Vehicle> vehicleCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<Block> blockCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<Line> lineCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<CrewMember> crewMemberCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<City> cityCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<ScheduleItinerary> scheduleItineraryCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<ScheduleWorkDayKind> scheduleWorkDayKindCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<Schedule> scheduleCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<ItineraryDistance> itineraryDistanceCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<LineGroup> lineGroupCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<WorkDayKind> workDayKindCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<Company> companyCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<BlockEvent> blockEventCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<Itinerary> itineraryCollection;
    @OneToMany(mappedBy = "pidStatus")
    private Collection<Quarter> quarterCollection;

    public Status() {
    }

    public Status(Long pid) {
        this.pid = pid;
    }

    public Status(Long pid, short statusValue, long creationDate) {
        this.pid = pid;
        this.statusValue = statusValue;
        this.creationDate = creationDate;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public short getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(short statusValue) {
        this.statusValue = statusValue;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public BigInteger getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(BigInteger lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public BigInteger getPidPrincipal() {
        return pidPrincipal;
    }

    public void setPidPrincipal(BigInteger pidPrincipal) {
        this.pidPrincipal = pidPrincipal;
    }

    @XmlTransient
    public Collection<GeographicPoint> getGeographicPointCollection() {
        return geographicPointCollection;
    }

    public void setGeographicPointCollection(Collection<GeographicPoint> geographicPointCollection) {
        this.geographicPointCollection = geographicPointCollection;
    }

    @XmlTransient
    public Collection<CrewMemberEvent> getCrewMemberEventCollection() {
        return crewMemberEventCollection;
    }

    public void setCrewMemberEventCollection(Collection<CrewMemberEvent> crewMemberEventCollection) {
        this.crewMemberEventCollection = crewMemberEventCollection;
    }

    @XmlTransient
    public Collection<CrewMemberGenericEvents> getCrewMemberGenericEventsCollection() {
        return crewMemberGenericEventsCollection;
    }

    public void setCrewMemberGenericEventsCollection(Collection<CrewMemberGenericEvents> crewMemberGenericEventsCollection) {
        this.crewMemberGenericEventsCollection = crewMemberGenericEventsCollection;
    }

    @XmlTransient
    public Collection<ScheduleItineraryTrip> getScheduleItineraryTripCollection() {
        return scheduleItineraryTripCollection;
    }

    public void setScheduleItineraryTripCollection(Collection<ScheduleItineraryTrip> scheduleItineraryTripCollection) {
        this.scheduleItineraryTripCollection = scheduleItineraryTripCollection;
    }

    @XmlTransient
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    @XmlTransient
    public Collection<Locatable> getLocatableCollection() {
        return locatableCollection;
    }

    public void setLocatableCollection(Collection<Locatable> locatableCollection) {
        this.locatableCollection = locatableCollection;
    }

    @XmlTransient
    public Collection<Vehicle> getVehicleCollection() {
        return vehicleCollection;
    }

    public void setVehicleCollection(Collection<Vehicle> vehicleCollection) {
        this.vehicleCollection = vehicleCollection;
    }

    @XmlTransient
    public Collection<Block> getBlockCollection() {
        return blockCollection;
    }

    public void setBlockCollection(Collection<Block> blockCollection) {
        this.blockCollection = blockCollection;
    }

    @XmlTransient
    public Collection<Line> getLineCollection() {
        return lineCollection;
    }

    public void setLineCollection(Collection<Line> lineCollection) {
        this.lineCollection = lineCollection;
    }

    @XmlTransient
    public Collection<CrewMember> getCrewMemberCollection() {
        return crewMemberCollection;
    }

    public void setCrewMemberCollection(Collection<CrewMember> crewMemberCollection) {
        this.crewMemberCollection = crewMemberCollection;
    }

    @XmlTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    @XmlTransient
    public Collection<ScheduleItinerary> getScheduleItineraryCollection() {
        return scheduleItineraryCollection;
    }

    public void setScheduleItineraryCollection(Collection<ScheduleItinerary> scheduleItineraryCollection) {
        this.scheduleItineraryCollection = scheduleItineraryCollection;
    }

    @XmlTransient
    public Collection<ScheduleWorkDayKind> getScheduleWorkDayKindCollection() {
        return scheduleWorkDayKindCollection;
    }

    public void setScheduleWorkDayKindCollection(Collection<ScheduleWorkDayKind> scheduleWorkDayKindCollection) {
        this.scheduleWorkDayKindCollection = scheduleWorkDayKindCollection;
    }

    @XmlTransient
    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @XmlTransient
    public Collection<ItineraryDistance> getItineraryDistanceCollection() {
        return itineraryDistanceCollection;
    }

    public void setItineraryDistanceCollection(Collection<ItineraryDistance> itineraryDistanceCollection) {
        this.itineraryDistanceCollection = itineraryDistanceCollection;
    }

    @XmlTransient
    public Collection<LineGroup> getLineGroupCollection() {
        return lineGroupCollection;
    }

    public void setLineGroupCollection(Collection<LineGroup> lineGroupCollection) {
        this.lineGroupCollection = lineGroupCollection;
    }

    @XmlTransient
    public Collection<WorkDayKind> getWorkDayKindCollection() {
        return workDayKindCollection;
    }

    public void setWorkDayKindCollection(Collection<WorkDayKind> workDayKindCollection) {
        this.workDayKindCollection = workDayKindCollection;
    }

    @XmlTransient
    public Collection<Company> getCompanyCollection() {
        return companyCollection;
    }

    public void setCompanyCollection(Collection<Company> companyCollection) {
        this.companyCollection = companyCollection;
    }

    @XmlTransient
    public Collection<BlockEvent> getBlockEventCollection() {
        return blockEventCollection;
    }

    public void setBlockEventCollection(Collection<BlockEvent> blockEventCollection) {
        this.blockEventCollection = blockEventCollection;
    }

    @XmlTransient
    public Collection<Itinerary> getItineraryCollection() {
        return itineraryCollection;
    }

    public void setItineraryCollection(Collection<Itinerary> itineraryCollection) {
        this.itineraryCollection = itineraryCollection;
    }

    @XmlTransient
    public Collection<Quarter> getQuarterCollection() {
        return quarterCollection;
    }

    public void setQuarterCollection(Collection<Quarter> quarterCollection) {
        this.quarterCollection = quarterCollection;
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
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crewmemberbackend.Status[ pid=" + pid + " ]";
    }
    
}
