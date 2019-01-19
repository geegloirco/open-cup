package ir.geeglo.dev.opencup.serverapp;

import ir.geeglo.dev.opencup.serverapp.orm.OrmLogicProvider;
import ir.geeglo.dev.opencup.serverapp.orm.logic.GeegloLogicSpringConfig;
import ir.piana.dev.core.PianaAnnotationAppMain;
import ir.piana.dev.core.annotation.PianaServer;
import ir.piana.dev.grizzly.http.GrizzlyPianaHttpServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Mohammad Rahmati, 1/15/2019
 */
@PianaServer()
public class OpenCupMainApp {
    public static OrmLogicProvider logicProvider;

    public static void main(String[] args)
            throws Exception {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(
                        GeegloLogicSpringConfig.class);
        logicProvider = OrmLogicProvider.register(applicationContext);

        PianaAnnotationAppMain.start(
                new GrizzlyPianaHttpServer(),
                OpenCupMainApp.class);
    }
}
