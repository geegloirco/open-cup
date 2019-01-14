package ir.geeglo.dev.product.opencup;

import ir.piana.dev.core.PianaAnnotationAppMain;
import ir.piana.dev.core.annotation.PianaServer;
import ir.piana.dev.grizzly.http.GrizzlyPianaHttpServer;
import org.jpos.q2.Q2;

@PianaServer
public class OpenCupQ2Main {
    public static void main(String[] args) throws Exception {
        PianaAnnotationAppMain.start(new GrizzlyPianaHttpServer(), OpenCupQ2Main.class);
        Q2.main(args);
    }
}
