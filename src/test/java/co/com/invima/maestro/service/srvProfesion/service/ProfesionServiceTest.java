package co.com.invima.maestro.service.srvProfesion.service;

import co.com.invima.maestro.modeloTransversal.dto.generic.GenericRequestDTO;
import co.com.invima.maestro.modeloTransversal.dto.generic.GenericResponseDTO;
import co.com.invima.maestro.modeloTransversal.dto.profesion.ProfesionDTO;
import co.com.invima.maestro.service.srvProfesion.commons.ConfiguradorSpring;
import co.com.invima.maestro.service.srvProfesion.commons.converter.ProfesionConverter;
import co.com.invima.maestro.service.srvProfesion.web.api.rest.v1.ProfesionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfiguradorSpring.class})
public class ProfesionServiceTest {

    @Autowired
    ProfesionController profesionController;

    @Autowired
    ProfesionConverter profesionConverter;


    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void consultarProfesiones() {
        System.out.println("entro test");
        List<ProfesionDTO> profesionDTOS = new ArrayList<>();
        Integer id = 2;
        try {
            ResponseEntity<GenericResponseDTO> response = profesionController.consultarProfesiones();
            System.out.println("Respuesta BD" + response);
            List<Object> lista = (List<Object>) response.getBody().getObjectResponse();
            for (Object profesion : lista) {
                ProfesionDTO profesionDTO = new ProfesionDTO();
                modelMapper.map(profesion, profesionDTO);
                profesionDTOS.add(profesionDTO);
            }


            assertEquals(profesionDTOS.size(), 2);

            // modelMapper.map(this.service.findById(1).getBody().getObjectResponse(),
            // pago);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void consultarPorCodigo() {
        String codigo = "354765";
        ProfesionDTO profesionDTO = new ProfesionDTO();
        try {
            ResponseEntity<GenericResponseDTO> response = profesionController.consultarPorCodigo(codigo);
            System.out.println("Respuesta BD" + response);
            Object respuesta = response.getBody().getObjectResponse();
            modelMapper.map(respuesta, profesionDTO);
            assertEquals(profesionDTO.getCodigoProfesion(), codigo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void crear() {
        GenericRequestDTO genericRequestDTO = new GenericRequestDTO();
        try {
            ProfesionDTO profesionDTO = new ProfesionDTO();
            profesionDTO.setCodigoProfesion("123456");
            profesionDTO.setNombreProfesion("Ingeniero Sistemas");


            genericRequestDTO.setRequest(profesionDTO);
            ResponseEntity<GenericResponseDTO> response = profesionController.crear(genericRequestDTO);
            System.out.println("Respuesta BD" + response);
            Object respuesta = response.getBody().getObjectResponse();

            assertEquals(respuesta, true);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void actualizar() {
        GenericRequestDTO genericRequestDTO = new GenericRequestDTO();
        try {
            ProfesionDTO profesionDTO = new ProfesionDTO();

            profesionDTO.setId(1);
            profesionDTO.setCodigoProfesion("123456");
            profesionDTO.setNombreProfesion("Ingeniero Sistemas");

            genericRequestDTO.setRequest(profesionDTO);
            ResponseEntity<GenericResponseDTO> response = profesionController.actualizar(genericRequestDTO);
            Object respuesta = response.getBody().getObjectResponse();

            assertEquals(respuesta, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
