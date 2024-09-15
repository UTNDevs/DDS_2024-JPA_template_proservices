package domain.models.entities.actores.reputaciones;

import domain.models.entities.trabajos.Calificacion;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MALA")
public class ReputacionMala extends Reputacion {
  @Column
  private String cuatro;

  @Override
  public void recibirCalificacion(Calificacion calificacion) {
    //TODO: Implement this method
  }
}
