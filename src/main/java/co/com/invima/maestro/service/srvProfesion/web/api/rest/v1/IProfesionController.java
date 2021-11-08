package co.com.invima.maestro.service.srvProfesion.web.api.rest.v1;


import co.com.invima.maestro.modeloTransversal.dto.generic.GenericRequestDTO;
import co.com.invima.maestro.modeloTransversal.dto.generic.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IProfesionController {

    ResponseEntity<GenericResponseDTO> consultarPorCodigo(@PathVariable String codigo);

    ResponseEntity<GenericResponseDTO> consultarProfesiones();

    ResponseEntity<GenericResponseDTO> crear(@RequestBody GenericRequestDTO genericRequestDTO);

    ResponseEntity<GenericResponseDTO> actualizar(@RequestBody GenericRequestDTO genericRequestDTO);

}
