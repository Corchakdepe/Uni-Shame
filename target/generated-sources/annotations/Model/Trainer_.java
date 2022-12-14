package Model;

import Model.Activity;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-06T15:19:04", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Trainer.class)
public class Trainer_ { 

    public static volatile SingularAttribute<Trainer, String> tNick;
    public static volatile SetAttribute<Trainer, Activity> activitySet;
    public static volatile SingularAttribute<Trainer, String> tCod;
    public static volatile SingularAttribute<Trainer, String> tDate;
    public static volatile SingularAttribute<Trainer, String> tName;
    public static volatile SingularAttribute<Trainer, String> tIdnumber;
    public static volatile SingularAttribute<Trainer, String> tEmail;
    public static volatile SingularAttribute<Trainer, String> tPhonenumber;

}