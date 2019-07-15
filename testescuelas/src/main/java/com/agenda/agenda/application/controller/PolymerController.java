package com.agenda.agenda.application.controller;

import com.agenda.agenda.application.resource.PolymerResource;
import com.agenda.agenda.domain.Persona;
import com.agenda.agenda.domain.Student;
import com.agenda.agenda.domain.Teacher;
import com.agenda.agenda.domain.repository.PersonaRepository;
import com.agenda.agenda.domain.repository.StudentRepository;
import com.agenda.agenda.domain.repository.TeacherRepository;
import com.agenda.agenda.request.ActualizaPersona;
import com.agenda.agenda.request.EliminaPersona;
import com.agenda.agenda.request.LoginRequest;
import com.agenda.agenda.request.PersonaRequest;
import com.agenda.agenda.response.LoginResponse;
import com.agenda.agenda.response.PersonaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
@CrossOrigin(origins = {"http://localhost:8083","http://localhost:8001","*"}, methods= {RequestMethod.GET, RequestMethod.POST})
public class PolymerController implements PolymerResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<PersonaResponse> testNombre( ) {
/*        Persona persona = new Persona();
        persona.setNombre("Abdiel");
        persona.setApellidoP("Cruz");
        persona.setApellidoM("Mendoza");

        personaRepository.save(persona);
*/
        PersonaResponse response = new PersonaResponse();
        response.setNombre("Abdiel");
        response.setApellidoP("cruz");
        response.setApellidoM("Mendoza");
        return new ResponseEntity<PersonaResponse>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> save(@RequestHeader(value = "test") String test, @RequestBody PersonaRequest personaRequest) {

        try {
            logger.info("Valore a guardar:"+personaRequest.toString()+ "valores del header" + test);
            Persona persona = new Persona();
            //persona.setId(personaRequest.getId());
            persona.setNombre(personaRequest.getNombre());
            persona.setCorreo(personaRequest.getCorreo());
            persona.setEdad(personaRequest.getEdad());
            persona.setIsS(personaRequest.getIs());
            persona.setNotas(personaRequest.getNotas());
            persona.setTelefono(personaRequest.getTelefono());
            persona.setActiveimg(personaRequest.getActiveimg());
            persona.setPassword(personaRequest.getPassword());

            personaRepository.save(persona);
        }catch (Exception e){
            logger.error("Error al ejecutar el guardado");
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LoginResponse> savePersona(@RequestBody PersonaRequest personaRequest) {
        LoginResponse response = new LoginResponse();
        try {
            logger.info("Valore a guardar:"+personaRequest.toString() + personaRequest.getTeacher());

            if (personaRequest.getTeacher()){
                Teacher teacher = new Teacher();
                teacher.setTeacherName(personaRequest.getNombre());
                //teacher.setTeacherAge();
                teacher.setPasswordTeacher(personaRequest.getPassword());
                teacher.setTeacherMail(personaRequest.getCorreo());
                teacherRepository.save(teacher);
                response.setStatus("200");
            }else if (personaRequest.getTeacher()){
                Student student = new Student();
                student.setStudentName(personaRequest.getNombre());
                //teacher.setTeacherAge();
                student.setPassword(personaRequest.getPassword());
                student.setStudentMail(personaRequest.getCorreo());
                studentRepository.save(student);
                response.setStatus("200");
            }else{
                Persona persona = new Persona();
                //persona.setIdPerson(personaRequest.getId());
                persona.setNombre(personaRequest.getNombre());
                persona.setCorreo(personaRequest.getCorreo());
                persona.setFgTeacher(personaRequest.getTeacher());
                persona.setPassword(personaRequest.getPassword());

                personaRepository.save(persona);
                response.setStatus("200");
            }
        }catch (Exception e){
            logger.error("Error al ejecutar el guardado");
        }
        return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
    }

/*    @Override
    public String hello(@RequestHeader  String userAgent, @RequestHeader String dos) {
        logger.info("valor de entrada:"+ userAgent);
        return null;
    }*/

    @Override
    public ResponseEntity<List<PersonaResponse>> getInformacionPersona() {
        List<PersonaResponse> response = new ArrayList<>();
        logger.error("Hola amigos");

        try {
            List<Persona> personas = personaRepository.findAll();

            for (Persona p:personas){
                PersonaResponse resp = new PersonaResponse();
                resp.setCorreo(p.getCorreo());
                resp.setEdad(p.getEdad());
                resp.setNombre(p.getNombre());
                resp.setIs(p.getIsS());
                resp.setTelefono(p.getTelefono());
                resp.setNotas(p.getNotas());
                resp.setActiveimg(p.getActiveimg());
                response.add(resp);
            }

        }catch (Exception e){
            logger.error("error al obtener datos de la persona");
        }
        return new ResponseEntity<List<PersonaResponse>>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonaResponse> actualizaPersona(@RequestBody  ActualizaPersona actualizaPersona) {
        PersonaResponse response = new PersonaResponse();
        try {
            logger.info("Voy a actualizar datos de "+ actualizaPersona.getNombreAnterior());
            Persona persona = personaRepository.findByNombreAndEdad(actualizaPersona.getNombreAnterior(),actualizaPersona.getEdadAnterior());
            persona.setNombre(actualizaPersona.getNombreActual());
            persona.setEdad(actualizaPersona.getEdadActual());
            persona.setCorreo(actualizaPersona.getCorreo());
            persona.setTelefono(actualizaPersona.getTelefono());
            persona.setNotas(actualizaPersona.getNotas());
            persona.setIsS(actualizaPersona.getIs());
            personaRepository.save(persona);

            response.setNombre(actualizaPersona.getNombreActual());
            response.setEdad(actualizaPersona.getEdadActual());
            response.setCorreo(actualizaPersona.getCorreo());


        }catch (Exception e){
            logger.error("fallo la busqueda");
        }
        return new ResponseEntity<PersonaResponse>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> eliminaPersona(@RequestBody EliminaPersona eliminaPersona) {

        try {
            logger.info("Voy a borrar datos de "+ eliminaPersona.getNombre());
           //Persona persona = personaRepository.findByNombreAndEdad(eliminaPersona.getNombre(),eliminaPersona.getEdad());
            Persona persona = personaRepository.findByNombre(eliminaPersona.getNombre());
            personaRepository.delete(persona);

        }catch (Exception e){
            logger.error("fallo la busqueda");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest login) {
        LoginResponse response = new LoginResponse();
        Boolean flag = false;
        Persona personlogin;
        try {
            logger.info("Persona a logear:"+ login.getName() + "pass:" + login.getPassword());

            Teacher teacher = teacherRepository.findByTeacherNameAndPasswordTeacher(login.getName(),login.getPassword());

            if (teacher != null ){
                logger.info("soy teacher");
                response.setStatus("teacher");
                response.setIdTeacher(teacher.getId());

            } else {
                logger.info("NO SOY teacher");
                Persona person = personaRepository.findByNombreAndPassword(login.getName(),login.getPassword());
                if (person != null){
                    response.setIdTeacher(person.getId());

                    return new ResponseEntity<>(response,HttpStatus.OK);
                }else {
                    response.setStatus("Error 404");
                    return new ResponseEntity<>(response,HttpStatus.OK);
                }
            }
            logger.info(response.toString());
        }catch (Exception e){
            logger.error("error al logear"+e);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
