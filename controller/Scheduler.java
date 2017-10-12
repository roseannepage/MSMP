/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Location;
import entity.Scribe;
import entity.Shiftschedule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import service.LocationFacadeREST;
import service.ScribeFacadeREST;
import service.ShiftscheduleFacadeREST;

/**
 *
 * @author Marie
 */
@ManagedBean(name = "Scheduler")
@ViewScoped
public class Scheduler {

    // EJB
    @EJB
    private ScribeFacadeREST ejbScribe;
    @EJB
    private ShiftscheduleFacadeREST ejbShiftSchedule;
    @EJB
    private LocationFacadeREST ejbLocation;
    
    // property
    private Location newLocation;
    private String[] provinces;
    private String[] cities;    
    private String[] sites;    
    private String[] departments;
    private String[] areas;

    /**
     * Get the value of areas
     *
     * @return the value of areas
     */
    public String[] getAreas() {
        return areas;
    }

    /**
     * Get the value of departments
     *
     * @return the value of departments
     */
    public String[] getDepartments() {
        return departments;
    }

    /**
     * Get the value of sites
     *
     * @return the value of sites
     */
    public String[] getSites() {
        return sites;
    }   

    /**
     * Get the value of provinces
     *
     * @return the value of provinces
     */
    public String[] getProvinces() {
        return ejbLocation.getProvinces();
    }

    /**
     * Get the value of cities
     *
     * @return the value of cities
     */
    public String[] getCities() {
        return cities;
    }
        
    /**
     * Set the value of newLocation
     *
     * @param newLocation new value of newLocation
     */
    public void setNewLocation(Location newLocation) {
        this.newLocation = newLocation;
    }

    public Location getNewLocation() {
        return newLocation;
    }

    // others
    private List<Scribe> scribes;
    private int availableScribes;
    private List<Shiftschedule> requests;

    public Scheduler() {
        this.newLocation = new Location();
        requests = new ArrayList<>();
    }

    public String schedule() {
        requests = ejbShiftSchedule.findAll();
        scribes = ejbScribe.findQualifiedScribe();
        return "test";
    }

    public void provinceSelectListener(AjaxBehaviorEvent event) {
        cities = ejbLocation.getCities(newLocation.getProvince());
       
    }

    public void citySelectListener(AjaxBehaviorEvent event) {
        sites = ejbLocation.getSites(newLocation.getCity());
    }
    
    public void siteSelectListener(AjaxBehaviorEvent event) {
        departments = ejbLocation.getDepartments(newLocation.getSite());
    }
    
    public void departmentSelectListener(AjaxBehaviorEvent event) {
        areas = ejbLocation.getAreas(newLocation.getDepartment());
    }
    
    public void addNewLocation(){
        newLocation.setCountry("Canada");
        ejbLocation.create(newLocation);
        newLocation = new Location();
        clear();
    }    
    
    public void resetNewLocation(){
        newLocation = new Location();
        clear();
    }

    private void getScheduleRequest() {

    }

    public int getAvailableScribes() {
        return availableScribes;
    }
    
    // helper
    private void clear(){
        provinces = null;
        cities = null;
        sites = null;
        departments = null;
        areas = null;
    }
}
