package co.com.invima.maestro.service.srvProfesion.repository;

import co.com.invima.maestro.modeloTransversal.entities.profesion.ProfesionDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfesionRepository extends JpaRepository<ProfesionDAO, Integer> {

    @Query("SELECT profesion FROM ProfesionDAO profesion")
    List<ProfesionDAO> consultarProfesiones();

    @Query("SELECT profesion FROM ProfesionDAO profesion WHERE profesion.codigoProfesion=:codigo")
    ProfesionDAO consultarPorCodigo(@Param("codigo") String codigo);

}
