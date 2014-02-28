/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.crewmemberbackend.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Francesco
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.crewmemberbackend.service.BlockEventFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.BlockFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.CityFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.CompanyFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.CrewMemberEventFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.CrewMemberFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.CrewMemberGenericEventsFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.GarageFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.GeographicPointFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.ItineraryDistanceFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.ItineraryFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.LineFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.LineGroupFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.LocatableFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.LocationFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.QuarterFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.ScheduleFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.ScheduleItineraryFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.ScheduleItineraryTripFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.ScheduleWorkDayKindFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.StatusFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.VehicleClassificationFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.VehicleCostFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.VehicleFacadeREST.class);
        resources.add(com.mycompany.crewmemberbackend.service.WorkDayKindFacadeREST.class);
    }
    
}
