package ms.ejercicio1.repository;

import ms.ejercicio1.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {
    List<Departamento> findByDireccionContainingIgnoreCaseAndM2GreaterThanEqual(String direccion, Double m2);
    List<Departamento>findByPrecioLessThan(Double precio);

}
