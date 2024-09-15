package domain.main;

import domain.models.entities.servicios.Servicio;
import domain.models.repositories.RepositorioDeServicios;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import java.util.List;
import java.util.Optional;

public class MainExample implements WithSimplePersistenceUnit {
  private RepositorioDeServicios repositorioDeServicios;

  public static void main(String[] args) {
    MainExample instance = new MainExample();
    instance.guardarServicios();
    instance.recuperarServicios();
  }

  private void guardarServicios() {
    Servicio servicio1 = new Servicio();
    servicio1.setNombre("Abogacia");

    Servicio servicio2 = new Servicio();
    servicio2.setNombre("Ingenieria en Sistemas");

    withTransaction(() -> {
      this.repositorioDeServicios.guardar(servicio1);
      this.repositorioDeServicios.guardar(servicio2);
    });
  }

  private void recuperarServicios() {
    Optional<Servicio> posibleServicio1 = this.repositorioDeServicios.buscarPorId(1L);

    if (posibleServicio1.isPresent()) {
      Servicio servicio1 = posibleServicio1.get();
      System.out.println(servicio1.getNombre());
    }

    List<Servicio> servicios = this.repositorioDeServicios.buscarPorNombre("Ingenieria en Sistemas");

    if (!servicios.isEmpty()) {
      Servicio servicio2 = servicios.get(0);
      System.out.println(servicio2);
    }
  }

  private void actualizarNombreDeServicios() {
    Optional<Servicio> posibleServicio1 = this.repositorioDeServicios.buscarPorId(1L);

    if (posibleServicio1.isPresent()) {
      Servicio servicio1 = posibleServicio1.get();
      servicio1.setNombre("Abogacia y Derecho");
      withTransaction(() -> this.repositorioDeServicios.guardar(servicio1));
    }
  }


}
