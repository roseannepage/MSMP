package entity;

import entity.Physician;
import entity.PreferencePK;
import entity.Scribe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-11T19:54:12")
@StaticMetamodel(Preference.class)
public class Preference_ { 

    public static volatile SingularAttribute<Preference, PreferencePK> preferencePK;
    public static volatile SingularAttribute<Preference, Boolean> preference;
    public static volatile SingularAttribute<Preference, Physician> physician;
    public static volatile SingularAttribute<Preference, Scribe> scribe;

}