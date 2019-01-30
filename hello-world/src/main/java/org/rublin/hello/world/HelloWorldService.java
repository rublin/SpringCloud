package org.rublin.hello.world;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    @Autowired
    private HelloClient client;

    @Value("${hello.name}")
    private String name;

    @HystrixCommand(fallbackMethod = "connectionError")
    public String helloWorld() {
        return client.hello(name);
    }

    public String connectionError(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return "Something wrong";
    }
}
