package com.quickjs;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class JSFunction extends JSObject {
    public JSFunction(y yVar, long j11, int i11, double d11, long j12) {
        super(yVar, j11, i11, d11, j12);
    }

    public JSFunction(y yVar, b0 b0Var) {
        super(yVar, yVar.getNative()._initNewJSFunction(yVar.getContextPtr(), b0Var.hashCode(), false));
        this.context.w(b0Var, this);
    }

    public JSFunction(y yVar, c0 c0Var) {
        super(yVar, yVar.getNative()._initNewJSFunction(yVar.getContextPtr(), c0Var.hashCode(), true));
        this.context.x(c0Var, this);
    }

    public Object u(JSObject jSObject, JSArray jSArray) {
        return w(JSValue.TYPE.UNKNOWN, jSObject, jSArray);
    }

    public Object w(JSValue.TYPE type, JSObject jSObject, JSArray jSArray) {
        this.context.b0();
        this.context.d0(jSArray);
        if (jSObject == null) {
            jSObject = JSValue.Undefined(this.context);
        }
        Object obj_executeFunction2 = getNative()._executeFunction2(this.context.getContextPtr(), type.value, jSObject, this, jSArray);
        QuickJS.b(this.context);
        return JSValue.checkType(obj_executeFunction2, type);
    }
}
