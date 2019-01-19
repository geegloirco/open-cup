package ir.geeglo.dev.opencup.serverapp.service;

import ir.piana.dev.core.annotation.Handler;
import ir.piana.dev.core.annotation.HandlerType;
import ir.piana.dev.core.annotation.MethodHandler;
import ir.piana.dev.core.response.PianaResponse;

import javax.ws.rs.core.Response;

/**
 * @author Mohammad Rahmati, 1/15/2019
 */
@Handler(baseUrl = "open-cup", handlerType = HandlerType.METHOD_HANDLER)
public class HelloWorld {
    @MethodHandler
    public static PianaResponse sayHello() {
        return new PianaResponse(Response.Status.OK, "Hello World!");
    }
}
