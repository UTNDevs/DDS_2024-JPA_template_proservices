package domain.models.entities.actores.reputaciones;

import domain.models.entities.trabajos.Calificacion;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Reputacion {

  @Column
  private String uno;

  public abstract void recibirCalificacion(Calificacion calificacion);
}
