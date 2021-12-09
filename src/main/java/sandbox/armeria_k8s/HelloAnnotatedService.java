package sandbox.armeria_k8s;

import org.springframework.stereotype.Component;

import com.linecorp.armeria.server.annotation.Get;

@Component
public class HelloAnnotatedService {
    @Get("/")
    public String defaultHello() {
        return "Hello, world! Try sending a GET request to /hello/armeria";
    }
}
