package ec.com.hello.controller;

import ec.com.hello.vo.MessageVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/greet")
public class HelloController {

    @GetMapping(value = "{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVO sayHello(@PathVariable String name) {
        return MessageVO.builder().name(name).build();
    }

}
