package co.com.invima.maestro.service.srvProfesion.service;


import co.com.invima.maestro.modeloTransversal.dto.generic.GenericRequestDTO;
import co.com.invima.maestro.modeloTransversal.dto.generic.GenericResponseDTO;
import org.springframework.http.ResponseEntity;


public interface IProfesionService {


    ResponseEntity<GenericResponseDTO> consultarPorCodigo(String codigo);

    ResponseEntity<GenericResponseDTO> consultarProfesiones();

    ResponseEntity<GenericResponseDTO> crear(GenericRequestDTO genericRequestDTO);

    ResponseEntity<GenericResponseDTO> actualizar(GenericRequestDTO genericRequestDTO);

}
