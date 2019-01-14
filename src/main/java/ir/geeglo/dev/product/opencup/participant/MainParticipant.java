package ir.geeglo.dev.product.opencup.participant;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

public class MainParticipant implements TransactionParticipant {
    public int prepare(long l, Serializable serializable) {
        if(serializable instanceof ISOMsg) {
            ISOMsg m = (ISOMsg) serializable;
            String value = (String)m.getValue();
            try {
                m.setResponseMTI();
                m.setValue(value + ":)");
            } catch (ISOException e) {
                e.printStackTrace();
            }
        }
        return PREPARED;
    }

    public void commit(long id, Serializable context) {
        Space space = SpaceFactory.getSpace("tspace:default");
        space.out("my-mux-queue", context);
    }

    public void abort(long id, Serializable context) {

    }
}
