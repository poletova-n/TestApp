/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oauth2.server;

import com.github.oauth2.server.pojo.*;
import org.apache.commons.codec.digest.Sha2Crypt;
import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@SpringBootApplication
@Controller
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(
            value = "/"
    )
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("{\"message\":\"Home!\"}", HttpStatus.OK);
    }

    @RequestMapping(
            value = "/payments/payment",
            method = RequestMethod.POST
    )
    public ResponseEntity<Response> createPayment( @RequestHeader("Content-Type") String contentType,
                                                   @RequestBody Record record) {
        System.out.println(record.getTransaction().getDescription());
        if (contentType.equals("application/json")) {
            return new ResponseEntity<Response>(new Response(record.getId() + "", State.CREATED), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

//    @RequestMapping(method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE,
//    value = "{record.getNotification_url()}")
//    public ResponseEntity<Webhook> getWebhook(@PathVariable Record record) {
//        try {
//            SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
//
//            Scheduler sched = schedFact.getScheduler();
//
//            sched.start();
//
//            // define the job and tie it to our HelloJob class
//            JobDetail job = newJob(NewJob.class)
//                    .withIdentity("myJob", "group1")
//                    .build();
//
//            // Trigger the job to run now, and then every 40 seconds
//            Trigger trigger = newTrigger()
//                    .withIdentity("myTrigger", "group1")
//                    .startNow()
//                    .withSchedule(simpleSchedule()
//                            .withIntervalInSeconds(40)
//                            .repeatForever())
//                    .build();
//
//            // Tell quartz to schedule the job using our trigger
//            sched.scheduleJob(job, trigger);
//            sched.shutdown();
//        } catch (SchedulerException e){
//            e.printStackTrace();
//        }
//        return new ResponseEntity<Webhook>(new Webhook(record.getTransaction().getAmount().getCurrency(),
//                record.getTransaction().getAmount().getValue(), record.getId(), record.getTransaction().getExternal_id(),
//                State.CREATED, Sha2Crypt.sha256Crypt(record.getTransaction().getExternal_id().getBytes())), HttpStatus.OK);
//    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity validateFail()
    {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
