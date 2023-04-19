package entidades;

import entidades.Alumno;
import entidades.Asistencia;
import java.sql.Timestamp;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-28T15:54:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Grupo.class)
public class Grupo_ { 

    public static volatile SingularAttribute<Grupo, Timestamp> horaFin;
    public static volatile SingularAttribute<Grupo, String> nombreClase;
    public static volatile ListAttribute<Grupo, Alumno> alumnos;
    public static volatile SingularAttribute<Grupo, Long> grupo_id;
    public static volatile SingularAttribute<Grupo, Timestamp> horaInicio;
    public static volatile ListAttribute<Grupo, Asistencia> asistencias;

}