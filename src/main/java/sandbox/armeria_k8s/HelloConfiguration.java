package sandbox.armeria_k8s;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.logging.AccessLogWriter;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;

@Configuration
public class HelloConfiguration {
    @Bean
    public ArmeriaServerConfigurator armeriaServerConfigurator(HelloAnnotatedService service) {
        // Customize the server using the given ServerBuilder. For example:
        return builder -> {
            // Add DocService that enables you to send Thrift and gRPC requests from web browser.
            builder.serviceUnder("/docs", new DocService());

            // Log every message which the server receives and responds.
            builder.decorator(LoggingService.newDecorator());

            // Write access log after completing a request.
            builder.accessLogWriter(AccessLogWriter.combined(), false);

            // Add an Armeria annotated HTTP service.
            builder.annotatedService(service);

            // You can also bind asynchronous RPC services such as Thrift and gRPC:
            // builder.service(THttpService.of(...));
            // builder.service(GrpcService.builder()...build());
        };
    }
}
