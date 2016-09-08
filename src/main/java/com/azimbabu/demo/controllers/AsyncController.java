package com.azimbabu.demo.controllers;

import com.azimbabu.demo.model.Message;
import com.azimbabu.demo.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Created by azim on 9/7/16.
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private ActorService actorService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Message> getAsyncNonBlocking(@RequestBody Message message) {
        actorService.submitMessage(message);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }
}
