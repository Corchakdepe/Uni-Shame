package Model;

import Model.Member1;
import Model.Trainer;
import java.math.BigInteger;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-26T21:10:41", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Activity.class)
public class Activity_ { 

    public static volatile SetAttribute<Activity, Member1> member1Set;
    public static volatile SingularAttribute<Activity, String> aDescription;
    public static volatile SingularAttribute<Activity, String> aName;
    public static volatile SingularAttribute<Activity, BigInteger> aPrice;
    public static volatile SingularAttribute<Activity, Trainer> aTrainerincharge;
    public static volatile SingularAttribute<Activity, String> aId;

}