/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Scribe;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.ScribeFacadeREST;

/**
 *
 * @author Marie
 */
@ManagedBean(name = "Scheduler")
@SessionScoped
public class Scheduler {
    
    @EJB
    private ScribeFacadeREST ejbScribe;
    
    private List<Scribe> scribes;
    private int availableScribes;
    
    
    public Scheduler(){

    }
    
    public String schedule(){
       scribes = ejbScribe.findAll();
       for (Scribe scribe : scribes){
           if (scribe.getCamelotProgress() == 100 && scribe.getCamelotScore() > 60
            && scribe.getTextbookReadings() && scribe.getOnlineResources()
            && scribe.getInClassTraining()&& scribe.getMscPaperwork())
               availableScribes++;
       }
       return "schedule";
    }
    
    public int getAvailableScribes(){
        return availableScribes;
    }
}
