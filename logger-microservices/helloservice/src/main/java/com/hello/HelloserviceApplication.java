package com.hello;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.sun.org.slf4j.internal.LoggerFactory;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
@RestController
public class HelloserviceApplication {
	
//	private static Logger log = LoggerFactory.getLogger(HelloApplication.class);

    @RequestMapping(value = "/greeting")
    public String greet() {
//        log.info("Access /greeting");

        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
//        log.info("Access /");
        return "Hi!";
    }


	public static void main(String[] args) {
		SpringApplication.run(HelloserviceApplication.class, args);
	}

}
