package entity;

import entity.Scribe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-11T19:54:12")
@StaticMetamodel(Availability.class)
public class Availability_ { 

    public static volatile SingularAttribute<Availability, Boolean> overnight;
    public static volatile SingularAttribute<Availability, Integer> availabilityId;
    public static volatile SingularAttribute<Availability, Integer> startHour;
    public static volatile SingularAttribute<Availability, Date> availableDate;
    public static volatile SingularAttribute<Availability, Integer> finishHour;
    public static volatile SingularAttribute<Availability, Scribe> scribeId;

}