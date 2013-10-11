package external.utils;

import javax.swing.JCheckBox;


public class ObjCheckBox extends JCheckBox {
    private final Object obj;
    public ObjCheckBox(final Object obj) {
        super(obj.toString());
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }
}
