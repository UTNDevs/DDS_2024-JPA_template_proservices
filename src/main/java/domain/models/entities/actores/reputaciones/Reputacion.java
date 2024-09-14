package domain.models.entities.actores.reputaciones;

import domain.models.entities.trabajos.Calificacion;

public abstract class Reputacion {
  public abstract void recibirCalificacion(Calificacion calificacion);
}
