package entity;

import entity.Availability;
import entity.Location;
import entity.Preference;
import entity.Scribe;
import entity.Scribespecializaiton;
import entity.Shiftschedule;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-11T19:54:12")
@StaticMetamodel(Scribe.class)
public class Scribe_ { 

    public static volatile SingularAttribute<Scribe, String> scribeEmail;
    public static volatile SingularAttribute<Scribe, Boolean> onlineResources;
    public static volatile SingularAttribute<Scribe, byte[]> scribePhoto;
    public static volatile SingularAttribute<Scribe, Date> endDate;
    public static volatile SingularAttribute<Scribe, String> scribeFname;
    public static volatile SingularAttribute<Scribe, String> contractType;
    public static volatile SingularAttribute<Scribe, String> scribePhone;
    public static volatile SingularAttribute<Scribe, Date> expectedEndDate;
    public static volatile SingularAttribute<Scribe, Integer> camelotScore;
    public static volatile CollectionAttribute<Scribe, Location> locationCollection1;
    public static volatile SingularAttribute<Scribe, String> scribeAddress;
    public static volatile CollectionAttribute<Scribe, Location> locationCollection2;
    public static volatile CollectionAttribute<Scribe, Availability> availabilityCollection;
    public static volatile SingularAttribute<Scribe, Boolean> textbookReadings;
    public static volatile SingularAttribute<Scribe, Boolean> inClassTraining;
    public static volatile SingularAttribute<Scribe, Boolean> generalQualified;
    public static volatile CollectionAttribute<Scribe, Scribespecializaiton> scribespecializaitonCollection;
    public static volatile CollectionAttribute<Scribe, Shiftschedule> shiftscheduleCollection;
    public static volatile SingularAttribute<Scribe, String> scribeLname;
    public static volatile SingularAttribute<Scribe, Short> hoursWorked;
    public static volatile SingularAttribute<Scribe, Short> camelotProgress;
    public static volatile SingularAttribute<Scribe, Date> hiringDate;
    public static volatile CollectionAttribute<Scribe, Scribe> scribeCollection1;
    public static volatile SingularAttribute<Scribe, Integer> scribeId;
    public static volatile SingularAttribute<Scribe, Boolean> mscPaperwork;
    public static volatile CollectionAttribute<Scribe, Scribe> scribeCollection;
    public static volatile CollectionAttribute<Scribe, Preference> preferenceCollection;
    public static volatile CollectionAttribute<Scribe, Location> locationCollection;

}