package domain.models.entities.actores;

import domain.models.entities.actores.reputaciones.Reputacion;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "prestador")
public class Prestador {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "radioCoberturaEnKm")
  private Double radioCoberturaEnKm;

  @OneToMany(mappedBy = "prestador")
  private List<Disponibilidad> disponibilidades;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "apellido")
  private String apellido;

  @Column(name = "foto")
  private String foto;

  @Column(name = "fechaNacimiento", columnDefinition = "DATE")
  private LocalDate fechaNacimiento;

  @Column(name = "tipoDocumento")
  @Enumerated(EnumType.STRING)
  private TipoDocumento tipoDocumento;

  @Column(name = "nroDocumento")
  private String nroDocumento;

  @Column(name = "cuitCuil")
  private String cuitCuil;

  @ElementCollection
  @CollectionTable(name = "prestador_telefono", joinColumns = @JoinColumn(name = "prestador_id", referencedColumnName = "id"))
  @Column(name = "telefonos")
  private List<String> telefonos;

  @ElementCollection
  @CollectionTable(name = "prestador_email", joinColumns = @JoinColumn(name = "prestador_id", referencedColumnName = "id"))
  @Column(name = "emails")
  private List<String> emails;

  @OneToOne
  @JoinColumn(name = "reputacion_id")
  private Reputacion reputacion;

  public Prestador() {
    this.disponibilidades = new ArrayList<>();
  }

  public void agregarDisponibilidad(Disponibilidad disponibilidad) {
    this.disponibilidades.add(disponibilidad);
    disponibilidad.setPrestador(this);
  }
}
