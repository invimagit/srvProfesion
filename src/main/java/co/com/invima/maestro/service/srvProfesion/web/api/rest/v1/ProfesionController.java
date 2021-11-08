package co.com.invima.maestro.service.srvProfesion.web.api.rest.v1;


import co.com.invima.maestro.modeloTransversal.dto.generic.GenericRequestDTO;
import co.com.invima.maestro.modeloTransversal.dto.generic.GenericResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import co.com.invima.maestro.service.srvProfesion.service.IProfesionService;


@RestController
@RequestMapping("/v1/Profesion")
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class ProfesionController implements IProfesionController {

    private final IProfesionService service;

    @Autowired
    public ProfesionController(IProfesionService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/consultaCodigo/{codigo}")
    @ApiOperation(value = "Consulta profesión por código", notes = "Consulta profesión por código")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    public ResponseEntity<GenericResponseDTO> consultarPorCodigo(@ApiParam(type = "String" , value = "" +
            "el parametro usuario debe ser un json con la siguiente estructura:" +
            "<br>" +
            "{ <br> request:"
            + " {<br>"
            + "     \"codigoProfesion\": \"\",<br>" +
            "}<br>"

            + "      }<br>", example = "354765", required = true) @PathVariable String codigo) {
        return service.consultarPorCodigo(codigo);
    }

    @Override
    @GetMapping("/consulta")
    @ApiOperation(value = "Consulta las profesiones", notes = "Consulta las profesiones")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    public ResponseEntity<GenericResponseDTO> consultarProfesiones() {
        return service.consultarProfesiones();
    }

    @Override
    @PostMapping("/")
    @ApiOperation(value = "Crea una nueva profesión", notes = "Crea una nueva profesión")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    public ResponseEntity<GenericResponseDTO> crear(@ApiParam(value = "" +
            "el parametro usuario debe ser un json con la siguiente estructura:" +
            "<br>" +
            "{ <br> request:"
            + " {<br>"
            + "     \"codigoProfesion\": \"\",<br>"
            + "     \"nombreProfesion\": \"\"<br>"
            +
            "}<br>"

            + "      }<br>", required = true) GenericRequestDTO genericRequestDTO) {
        return service.crear(genericRequestDTO);
    }

    @Override
    @PutMapping("/")
    @ApiOperation(value = "Actualiza la profesión", notes = "Actualiza la profesión")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    public ResponseEntity<GenericResponseDTO> actualizar(@ApiParam(value = "" +
            "el parametro usuario debe ser un json con la siguiente estructura:" +
            "<br>" +
            "{ <br> request:"
            + " {<br>"
            + "     \"idProfesion\": \"\",<br>"
            + "     \"codigoProfesion\": \"\",<br>"
            + "     \"nombreProfesion\": \"\"<br>"
            +
            "}<br>"

            + "      }<br>",required = true) GenericRequestDTO genericRequestDTO) {
        return service.actualizar(genericRequestDTO);
    }

}
