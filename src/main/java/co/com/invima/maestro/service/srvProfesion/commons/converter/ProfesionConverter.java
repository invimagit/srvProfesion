package co.com.invima.maestro.service.srvProfesion.commons.converter;

import co.com.invima.maestro.modeloTransversal.dto.profesion.ProfesionDTO;

import co.com.invima.maestro.modeloTransversal.entities.profesion.ProfesionDAO;

import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProfesionConverter {



    /**
     * @param profesionDAO
     * @return paisDTO
     * @author RScalante
     * method to convert ProfesionDAO to ProfesionDTO
     */
    public ProfesionDTO profesionDAOtoDTO(ProfesionDAO profesionDAO, ModelMapper modelMapper)  throws NotFoundException {
        ProfesionDTO profesionDTO = new ProfesionDTO();
        modelMapper.map(profesionDAO, profesionDTO);
        return profesionDTO;

    }


    /**
     * @param profesionDTO
     * @return profesionDAO
     * @author RScalante
     * method to convert ProfesionDTO to ProfesionDAO
     */
    public ProfesionDAO profesionDTOtoDAO(ProfesionDTO profesionDTO, ModelMapper modelMapper) throws NotFoundException {
        ProfesionDAO profesionDAO = new ProfesionDAO();
        modelMapper.map(profesionDTO, profesionDAO);

        return profesionDAO;
    }
}
