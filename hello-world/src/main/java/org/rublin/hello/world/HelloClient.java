package org.rublin.hello.world;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("hello")
public interface HelloClient {
    @GetMapping("/hello/{name}")
    String hello(@PathVariable("name") String name);
}
