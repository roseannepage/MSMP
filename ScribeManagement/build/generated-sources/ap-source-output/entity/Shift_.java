package entity;

import entity.Shiftschedule;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-11T19:54:12")
@StaticMetamodel(Shift.class)
public class Shift_ { 

    public static volatile SingularAttribute<Shift, Boolean> overnight;
    public static volatile SingularAttribute<Shift, Integer> shiftId;
    public static volatile SingularAttribute<Shift, String> shiftName;
    public static volatile SingularAttribute<Shift, Integer> startHour;
    public static volatile SingularAttribute<Shift, Integer> finishHour;
    public static volatile CollectionAttribute<Shift, Shiftschedule> shiftscheduleCollection;

}