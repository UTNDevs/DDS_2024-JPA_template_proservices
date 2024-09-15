package domain.models.entities.servicios;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "servicio")
public class Servicio {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "descripcion", columnDefinition = "TEXT")
  private String descripcion;

  @Column(name = "icono")
  private String icono;

  @OneToMany
  @JoinColumn(name = "servicio_id")
  private List<Tarea> tareas;

}
