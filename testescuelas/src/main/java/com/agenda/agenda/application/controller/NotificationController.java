package com.agenda.agenda.application.controller;

import com.agenda.agenda.application.resource.NotificationResource;
import com.agenda.agenda.domain.*;
import com.agenda.agenda.domain.repository.*;
import com.agenda.agenda.request.NotifGetRequest;
import com.agenda.agenda.request.PersonaRequest;
import com.agenda.agenda.request.SendNotifRequest;
import com.agenda.agenda.request.StudentsRequest;
import com.agenda.agenda.response.AllNotifications;
import com.agenda.agenda.response.LoginResponse;
import com.agenda.agenda.response.NotificationResponse;
import com.agenda.agenda.response.StudentsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:8083","http://localhost:8001","*"}, methods= {RequestMethod.GET, RequestMethod.POST})
public class NotificationController implements NotificationResource {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ControlRepository controlRepository;


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private NotificationRepository notificationRepository;


    @Override
    public ResponseEntity<NotificationResponse> sendNotifications(@RequestBody SendNotifRequest sendNotifRequest) {
        NotificationResponse response = new NotificationResponse();
        logger.info("Enviando notificacion para:" + sendNotifRequest.toString());

        Notification notification = new Notification();
        try {
            Persona papa = personaRepository.findById(sendNotifRequest.getIdPadre());
            if (papa != null){
                notification.setPersona(papa);

                notification.setComments(sendNotifRequest.getMensaje());
                notification.setTitle(sendNotifRequest.getTitulo());
                notification.setRead(sendNotifRequest.getRead());
                notificationRepository.save(notification);

                response.setTitle("Notificación enviadada con éxito");
                response.setMessage("Se ha enviado la notificación al padre " + papa.getNombre());
            }else {
                response.setTitle("Notificación NO ENVIADA");
                response.setMessage("No se encontró información del padre " + papa.getNombre());
            }
        }catch (Exception e){
            logger.error("Error al ejecutar el guardado");
        }
        return new ResponseEntity<NotificationResponse>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<StudentsResponse>> getStudents(@RequestBody StudentsRequest studentsRequest) {
        List<StudentsResponse> res =  new ArrayList<>();
        try {

            List<Control> control = controlRepository.findByTeacherId(studentsRequest.getIdTeacher());
            control.forEach(x-> {
                StudentsResponse response = new StudentsResponse();
                response.setStudentName(x.getStudent().getStudentName());
                response.setIdPadre(x.getStudent().getPersona().getId());
                logger.info("valores:" + x.getStudent().getStudentName());
                res.add(response);
            });

        }catch (Exception e){
            logger.error("error", e);
        }
        return new ResponseEntity<List<StudentsResponse>>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AllNotifications>> getNotifs(@RequestBody NotifGetRequest notifGetRequest) {

        List<AllNotifications> res = new ArrayList<>();
        try {
            List<Notification> notification = notificationRepository.findByReadAndPersonaId(notifGetRequest.getRead(), notifGetRequest.getIdPadre());
            logger.info("valores");
            notification.forEach( x-> {

                AllNotifications all = new AllNotifications();
                all.setTitle(x.getTitle());
                all.setMessage(x.getComments());
                all.setRead(x.getRead());
                res.add(all);
            });

        }catch (Exception e){
            logger.error("Error al obtener las notificaciones");
        }
        return new ResponseEntity<List<AllNotifications>>(res, HttpStatus.OK);
    }
}
