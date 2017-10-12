package entity;

import entity.Location;
import entity.Physician;
import entity.Scribe;
import entity.Shift;
import entity.Specialization;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-11T19:54:12")
@StaticMetamodel(Shiftschedule.class)
public class Shiftschedule_ { 

    public static volatile SingularAttribute<Shiftschedule, byte[]> note;
    public static volatile SingularAttribute<Shiftschedule, Shift> shiftId;
    public static volatile SingularAttribute<Shiftschedule, Integer> patientsSeen;
    public static volatile SingularAttribute<Shiftschedule, Physician> physicianId;
    public static volatile SingularAttribute<Shiftschedule, Location> locationId;
    public static volatile SingularAttribute<Shiftschedule, Specialization> specializationId;
    public static volatile SingularAttribute<Shiftschedule, Scribe> scribeId;
    public static volatile SingularAttribute<Shiftschedule, Integer> shiftScheduleId;
    public static volatile SingularAttribute<Shiftschedule, Date> dateToFill;
    public static volatile SingularAttribute<Shiftschedule, Boolean> highVolumn;
    public static volatile SingularAttribute<Shiftschedule, Date> timeIn;
    public static volatile SingularAttribute<Shiftschedule, Date> timeOut;

}