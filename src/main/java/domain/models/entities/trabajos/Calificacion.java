package domain.models.entities.trabajos;

import domain.models.entities.Persistente;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trabajo_calificacion")
@Getter
@Setter
public class Calificacion extends Persistente {

  @OneToOne
  @JoinColumn(name = "trabajo_id", referencedColumnName = "id")
  private Trabajo trabajo;

  @Column(name = "opinion_libre", columnDefinition = "TEXT")
  private String opinionLibre;

  @Column(name = "puntaje")
  private int puntaje;
}
