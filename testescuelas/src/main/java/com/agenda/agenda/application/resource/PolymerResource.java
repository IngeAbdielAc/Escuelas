package com.agenda.agenda.application.resource;

import com.agenda.agenda.request.ActualizaPersona;
import com.agenda.agenda.request.EliminaPersona;
import com.agenda.agenda.request.LoginRequest;
import com.agenda.agenda.request.PersonaRequest;
import com.agenda.agenda.response.LoginResponse;
import com.agenda.agenda.response.PersonaResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api
public interface PolymerResource {


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "testing ms")
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<PersonaResponse> testNombre();

    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ApiOperation(value = "Save personal informations")
    @PostMapping(value = "/person/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> save( @RequestHeader(value = "test") String test,@RequestBody @Valid PersonaRequest personaRequest);

    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ApiOperation(value = "Save personal informations")
    @PostMapping(value = "/add/User", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<LoginResponse> savePersona(@RequestBody @Valid PersonaRequest personaRequest);



    /*@RequestMapping(value = "/hello")
    public String hello(@RequestHeader(value="User-Agent") String userAgent , @RequestHeader(value = "sfdf") String dos);
*/

    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ApiOperation(value = "get person")
    @GetMapping(value = "/persona/informacion",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<PersonaResponse>> getInformacionPersona();


    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ApiOperation(value = "get person")
    @PostMapping(value = "/persona/actualiza",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<PersonaResponse> actualizaPersona(@RequestBody @Valid ActualizaPersona actualizaPersona);

    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ApiOperation(value = "get person")
    @PostMapping(value = "/persona/elimina",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> eliminaPersona(@RequestBody @Valid EliminaPersona eliminaPersona);

    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ApiOperation(value = "get person")
    @PostMapping(value = "/login",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest login);

}
