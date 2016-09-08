package com.azimbabu.demo.services;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.azimbabu.demo.actors.SpringExtension;
import com.azimbabu.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by azim on 9/7/16.
 */
@Service
public class ActorService {
    @Autowired
    private ActorSystem actorSystem;

    @Autowired
    private SpringExtension springExtension;

    public void submitMessage(Message message) {
        ActorRef workerActor = actorSystem.actorOf(springExtension.props("workerActor", null), "worker-actor");
        workerActor.tell(message, ActorRef.noSender());
    }
}
