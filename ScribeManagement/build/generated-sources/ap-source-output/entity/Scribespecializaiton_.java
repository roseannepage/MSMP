package entity;

import entity.Location;
import entity.Scribe;
import entity.ScribespecializaitonPK;
import entity.Specialization;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-11T19:54:12")
@StaticMetamodel(Scribespecializaiton.class)
public class Scribespecializaiton_ { 

    public static volatile SingularAttribute<Scribespecializaiton, Specialization> specialization;
    public static volatile SingularAttribute<Scribespecializaiton, ScribespecializaitonPK> scribespecializaitonPK;
    public static volatile SingularAttribute<Scribespecializaiton, Location> location;
    public static volatile SingularAttribute<Scribespecializaiton, Scribe> scribe;

}