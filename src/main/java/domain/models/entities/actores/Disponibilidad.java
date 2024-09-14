package domain.models.entities.actores;

import domain.models.entities.converters.DiaSemanaAttributeConverter;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@Table(name = "prestador_disponibilidad")
public class Disponibilidad {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "prestador_id")
  private Prestador prestador;  // TODO: Porque se aplica una bidireccionalidad?

  @Column(name = "horaInicio", columnDefinition = "TIME")
  private LocalTime horaInicio;

  @Column(name = "horaFin", columnDefinition = "TIME")
  private LocalTime horaFin;

  @Convert(converter = DiaSemanaAttributeConverter.class) // Los enums NO SE LLEVAN A UNA TABLA, sino que se mapea como un ordinal o un literal
  @Column(name = "dia")
  private DayOfWeek dia;
}
