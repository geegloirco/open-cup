package ir.geeglo.dev.product.opencup.core;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

public class MyMsg extends ISOMsg {
    private Object value;

    public MyMsg() {
        super();
    }

    public MyMsg(String mti) {
        super(mti);
    }

    public MyMsg(String mti, Object value) {
        super(mti);
        this.value = value;
    }

    @Override
    public void setValue(Object value) throws ISOException {
        this.value = value;
    }

    @Override
    public Object getValue() {
        super.getValue();
        return value;
    }
}
