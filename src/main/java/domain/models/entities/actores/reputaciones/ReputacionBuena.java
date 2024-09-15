package domain.models.entities.actores.reputaciones;

import domain.models.entities.trabajos.Calificacion;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("BUENA")
public class ReputacionBuena extends Reputacion {

  @Column
  private String dos;


  @Override
  public void recibirCalificacion(Calificacion calificacion) {
    // TODO: implement this method
  }
}
