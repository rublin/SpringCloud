package org.rublin.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@RestController
public class HelloController {

    @Value("${default.name: bob}")
    private String defaultName;

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(@PathVariable String name) {
        System.out.println("Say hello for " + name);
        return "Hello, ".concat(name);
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello, ".concat(defaultName);
    }
}
