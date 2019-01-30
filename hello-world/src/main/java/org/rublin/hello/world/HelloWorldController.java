package org.rublin.hello.world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService service;

    @RequestMapping(method = RequestMethod.GET, value = "/hello-world")
    public String helloWorld() {
        return service.helloWorld();
    }


}
