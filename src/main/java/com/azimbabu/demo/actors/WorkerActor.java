package com.azimbabu.demo.actors;

import akka.actor.AbstractActor;
import akka.actor.UntypedActor;
import akka.japi.pf.ReceiveBuilder;
import com.azimbabu.demo.model.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

/**
 * Created by azim on 9/7/16.
 */
@Component("workerActor")
@Scope("prototype")
public class WorkerActor extends AbstractActor {
    @Override
    public PartialFunction<Object, BoxedUnit> receive() {
        return ReceiveBuilder
                .match(Message.class, message -> {
                    System.out.println("Message received: " + message);
                    Thread.sleep(30000);
                    System.out.println("Message processed: " + message);
                    // acknowledge completion. actorPool is an actor ref to the pool actor.
                    //actorPool.tell(new Status.Success(request), self());
                })
                .matchAny(o -> {
                    //actorPool.tell(new Status.Failure(new UnsupportedOperationException()), self());
                })
                .build();
    }
}
