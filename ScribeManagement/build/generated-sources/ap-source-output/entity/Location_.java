package entity;

import entity.Physician;
import entity.Scribe;
import entity.Scribespecializaiton;
import entity.Shiftschedule;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-11T19:54:12")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> area;
    public static volatile SingularAttribute<Location, String> country;
    public static volatile CollectionAttribute<Location, Scribe> scribeCollection1;
    public static volatile SingularAttribute<Location, String> city;
    public static volatile CollectionAttribute<Location, Scribe> scribeCollection2;
    public static volatile CollectionAttribute<Location, Scribe> scribeCollection;
    public static volatile SingularAttribute<Location, String> site;
    public static volatile SingularAttribute<Location, String> province;
    public static volatile CollectionAttribute<Location, Physician> physicianCollection;
    public static volatile SingularAttribute<Location, Integer> locationId;
    public static volatile CollectionAttribute<Location, Scribespecializaiton> scribespecializaitonCollection;
    public static volatile CollectionAttribute<Location, Shiftschedule> shiftscheduleCollection;
    public static volatile SingularAttribute<Location, String> department;

}