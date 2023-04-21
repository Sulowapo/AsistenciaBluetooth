
package entidades;

import java.util.Objects;

public class RelGruposAlumnos {
    
    private Long id_relGrupoAlumnos;
    
    private Long id_grupo;
    
    private Long id_alumno;

    public RelGruposAlumnos(Long id_relGrupoAlumnos, Long id_grupo, Long id_alumno) {
        this.id_relGrupoAlumnos = id_relGrupoAlumnos;
        this.id_grupo = id_grupo;
        this.id_alumno = id_alumno;
    }

    public Long getId_relGrupoAlumnos() {
        return id_relGrupoAlumnos;
    }

    public void setId_relGrupoAlumnos(Long id_relGrupoAlumnos) {
        this.id_relGrupoAlumnos = id_relGrupoAlumnos;
    }

    public Long getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Long id_grupo) {
        this.id_grupo = id_grupo;
    }

    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
        this.id_alumno = id_alumno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id_relGrupoAlumnos);
        hash = 37 * hash + Objects.hashCode(this.id_grupo);
        hash = 37 * hash + Objects.hashCode(this.id_alumno);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RelGruposAlumnos other = (RelGruposAlumnos) obj;
        if (!Objects.equals(this.id_relGrupoAlumnos, other.id_relGrupoAlumnos)) {
            return false;
        }
        if (!Objects.equals(this.id_grupo, other.id_grupo)) {
            return false;
        }
        return Objects.equals(this.id_alumno, other.id_alumno);
    }
    
    
}
