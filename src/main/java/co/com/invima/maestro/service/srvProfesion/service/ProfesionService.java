package co.com.invima.maestro.service.srvProfesion.service;

import co.com.invima.maestro.modeloTransversal.dto.generic.GenericRequestDTO;
import co.com.invima.maestro.modeloTransversal.dto.generic.GenericResponseDTO;
import co.com.invima.maestro.modeloTransversal.dto.profesion.ProfesionDTO;
import co.com.invima.maestro.modeloTransversal.entities.profesion.ProfesionDAO;
import co.com.invima.maestro.service.srvProfesion.commons.converter.ProfesionConverter;
import co.com.invima.maestro.service.srvProfesion.repository.IProfesionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionService implements IProfesionService {



    private final IProfesionRepository iProfesionRepository;
    private final ModelMapper modelMapper;

    private final ProfesionConverter profesionConverter;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ProfesionService(ProfesionConverter profesionConverter, ModelMapper modelMapper, IProfesionRepository iProfesionRepository) {

        this.profesionConverter = profesionConverter;
        this.modelMapper = modelMapper;
        this.iProfesionRepository = iProfesionRepository;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> consultarPorCodigo(String codigo) {
        ProfesionDTO profesionDTO = new ProfesionDTO();
        try {
            ProfesionDAO profesionDAO = iProfesionRepository.consultarPorCodigo(codigo);
            profesionDTO = profesionConverter.profesionDAOtoDTO(profesionDAO, modelMapper);

            return new ResponseEntity<>(GenericResponseDTO.builder().message("Se consulta la profesión por código: " + codigo)
                    .objectResponse(profesionDTO).statusCode(HttpStatus.OK.value()).build(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(GenericResponseDTO.builder().message("Error consultando la profesión:  " + e.getMessage())
                    .objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> consultarProfesiones() {
        try {
            List<ProfesionDAO> list = iProfesionRepository.consultarProfesiones();

            return new ResponseEntity<>(GenericResponseDTO.builder().message("Se consultan las profesiones")
                    .objectResponse(list).statusCode(HttpStatus.OK.value()).build(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(GenericResponseDTO.builder().message("Error consultando las profesiones:  " + e.getMessage())
                    .objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> crear(GenericRequestDTO genericRequestDTO) {
        try {
            ProfesionDTO profesionDTO = new ProfesionDTO();
            modelMapper.map(genericRequestDTO.getRequest(), profesionDTO);
            ProfesionDAO profesionDAO = profesionConverter.profesionDTOtoDAO(profesionDTO, modelMapper);
            iProfesionRepository.save(profesionDAO);

            return new ResponseEntity<>(GenericResponseDTO.builder().message("Se crea la profesión")
                    .objectResponse(true).statusCode(HttpStatus.CREATED.value()).build(), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(GenericResponseDTO.builder().message("Error creando la profesión:  " + e.getMessage())
                    .objectResponse(false).statusCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> actualizar(GenericRequestDTO genericRequestDTO) {
        try {
            ProfesionDTO profesionDTO = new ProfesionDTO();
            modelMapper.map(genericRequestDTO.getRequest(), profesionDTO);
            ProfesionDAO profesionDAO = profesionConverter.profesionDTOtoDAO(profesionDTO, modelMapper);
            iProfesionRepository.save(profesionDAO);

            return new ResponseEntity<>(GenericResponseDTO.builder().message("Se actualiza la profesión")
                    .objectResponse(true).statusCode(HttpStatus.OK.value()).build(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(GenericResponseDTO.builder().message("Error actualizando la profesión:  " + e.getMessage())
                    .objectResponse(false).statusCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
