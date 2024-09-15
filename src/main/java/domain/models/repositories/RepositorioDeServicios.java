package domain.models.repositories;

import domain.models.entities.servicios.Servicio;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import java.util.List;
import java.util.Optional;

public class RepositorioDeServicios implements WithSimplePersistenceUnit {

  public void guardar(Servicio servicio) {
    entityManager().persist(servicio);
  }

  public Optional<Servicio> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(Servicio.class, id));
  }

  @SuppressWarnings("unchecked")
  public List<Servicio> buscarPorNombre(String nombre) {
    return entityManager()
        .createQuery("from " + Servicio.class.getName() + " where nombre = :nombre")
        .setParameter("nombre", nombre)
        .getResultList();
  }

  @SuppressWarnings("unchecked")
  public List<Servicio> recuperarTotosLosServicios() {
    return entityManager()
        .createQuery("from " + Servicio.class.getName())
        .getResultList();
  }

  public void eliminarFisico(Servicio servicio) {
    entityManager().remove(servicio);
  }

}
