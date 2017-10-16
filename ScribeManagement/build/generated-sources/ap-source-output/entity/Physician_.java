package entity;

import entity.Location;
import entity.Preference;
import entity.Shiftschedule;
import entity.Specialization;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-11T19:54:12")
@StaticMetamodel(Physician.class)
public class Physician_ { 

    public static volatile SingularAttribute<Physician, String> physicianFname;
    public static volatile SingularAttribute<Physician, Date> contractStartDate;
    public static volatile CollectionAttribute<Physician, Specialization> specializationCollection;
    public static volatile SingularAttribute<Physician, Date> contractEndDate;
    public static volatile SingularAttribute<Physician, String> physicianEmail;
    public static volatile SingularAttribute<Physician, String> physicianLname;
    public static volatile SingularAttribute<Physician, Integer> physicianId;
    public static volatile SingularAttribute<Physician, String> physicianPhone;
    public static volatile SingularAttribute<Physician, Date> clientDate;
    public static volatile CollectionAttribute<Physician, Preference> preferenceCollection;
    public static volatile SingularAttribute<Physician, byte[]> physicianPhoto;
    public static volatile CollectionAttribute<Physician, Shiftschedule> shiftscheduleCollection;
    public static volatile SingularAttribute<Physician, String> physicianAddress;
    public static volatile CollectionAttribute<Physician, Location> locationCollection;

}