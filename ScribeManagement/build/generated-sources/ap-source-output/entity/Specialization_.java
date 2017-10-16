package entity;

import entity.Physician;
import entity.Scribespecializaiton;
import entity.Shiftschedule;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-11T19:54:12")
@StaticMetamodel(Specialization.class)
public class Specialization_ { 

    public static volatile CollectionAttribute<Specialization, Physician> physicianCollection;
    public static volatile SingularAttribute<Specialization, String> specializationName;
    public static volatile SingularAttribute<Specialization, Integer> specializationId;
    public static volatile CollectionAttribute<Specialization, Scribespecializaiton> scribespecializaitonCollection;
    public static volatile CollectionAttribute<Specialization, Shiftschedule> shiftscheduleCollection;

}