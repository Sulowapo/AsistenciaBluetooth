package entidades;

import entidades.Alumno;
import entidades.Grupo;
import enumeradores.EstadoAsistencia;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-28T15:54:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Asistencia.class)
public class Asistencia_ { 

    public static volatile SingularAttribute<Asistencia, EstadoAsistencia> estado;
    public static volatile SingularAttribute<Asistencia, Grupo> grupo;
    public static volatile SingularAttribute<Asistencia, Long> asistencia_id;
    public static volatile SingularAttribute<Asistencia, Alumno> alumno;
    public static volatile SingularAttribute<Asistencia, Date> fechaHoraRegistro;

}