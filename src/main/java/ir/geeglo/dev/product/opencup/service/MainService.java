package ir.geeglo.dev.product.opencup.service;

import ir.geeglo.dev.product.opencup.core.MyMsg;
import ir.piana.dev.core.annotation.Handler;
import ir.piana.dev.core.annotation.HandlerType;
import ir.piana.dev.core.annotation.MethodHandler;
import ir.piana.dev.core.response.PianaResponse;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.ISO87BPackager;
import org.jpos.q2.iso.QMUX;
import org.jpos.transaction.Context;
import org.jpos.util.NameRegistrar;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Handler(handlerType = HandlerType.METHOD_HANDLER, baseUrl = "hello-world")
public class MainService {
    @MethodHandler(sync = false)
    public static PianaResponse sayHello(@QueryParam("name") String name) throws ISOException {
//        Context context = new Context();
//        context.put("name", name == null ? "World": name);

//        SpaceFactory.getSpace("tspace:default");
        QMUX qmux = NameRegistrar.getIfExists("mux.my-mux");
        ISOMsg request = null;
        if(qmux != null) {
            MyMsg m = new MyMsg("0200");
            m.set(11, "123456");
            m.setValue(name);
            m.setPackager(new ISO87BPackager());
            request = qmux.request(m, 30000);
        }

        byte[] pack = request.pack();

        if (request != null)
            return new PianaResponse(Response.Status.OK, "Hello " + request.getValue());
        return new PianaResponse(Response.Status.OK, "Hello Unknown!");
    }
}
