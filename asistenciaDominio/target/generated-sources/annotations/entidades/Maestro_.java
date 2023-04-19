package entidades;

import entidades.Grupo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-28T15:54:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Maestro.class)
public class Maestro_ { 

    public static volatile SingularAttribute<Maestro, Long> maestro_id;
    public static volatile ListAttribute<Maestro, Grupo> grupos;
    public static volatile SingularAttribute<Maestro, String> nombre;

}