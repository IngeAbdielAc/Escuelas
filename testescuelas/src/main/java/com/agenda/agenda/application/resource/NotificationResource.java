package com.agenda.agenda.application.resource;

import com.agenda.agenda.request.NotifGetRequest;
import com.agenda.agenda.request.PersonaRequest;
import com.agenda.agenda.request.SendNotifRequest;
import com.agenda.agenda.request.StudentsRequest;
import com.agenda.agenda.response.AllNotifications;
import com.agenda.agenda.response.LoginResponse;
import com.agenda.agenda.response.NotificationResponse;
import com.agenda.agenda.response.StudentsResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api
@CrossOrigin(origins = {"http://localhost:8083","http://localhost:8001","*"}, methods= {RequestMethod.GET, RequestMethod.POST})
public interface NotificationResource {

    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ApiOperation(value = "Send notifications for client")
    @PostMapping(value = "/notifications/send", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<NotificationResponse> sendNotifications(@RequestBody @Valid SendNotifRequest notifRequest);


    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ApiOperation(value = "Send notifications for client")
    @PostMapping(value = "/get/students/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<StudentsResponse>> getStudents(@RequestBody @Valid StudentsRequest studentsRequest);

    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ApiOperation(value = "Send notifications for client")
    @PostMapping(value = "/get/notif/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<AllNotifications>> getNotifs(@RequestBody @Valid NotifGetRequest notifGetRequest);

}
