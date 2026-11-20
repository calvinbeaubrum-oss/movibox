package com.quickjs;

import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class JSArray extends JSObject {
    public JSArray(y yVar) {
        super(yVar, yVar.getNative()._initNewJSArray(yVar.getContextPtr()));
    }

    public JSArray(y yVar, long j11, int i11, double d11, long j12) {
        super(yVar, j11, i11, d11, j12);
    }

    public JSObject U(int i11) {
        Object objU = u(JSValue.TYPE.JS_OBJECT, i11);
        if (objU instanceof JSObject) {
            return (JSObject) objU;
        }
        return null;
    }

    public int W() {
        return j("length");
    }

    public JSArray Z(double d11) {
        return h0(Double.valueOf(d11));
    }

    public JSArray b0(int i11) {
        return h0(Integer.valueOf(i11));
    }

    public JSArray d0(JSValue jSValue) {
        this.context.d0(jSValue);
        return h0(jSValue);
    }

    public JSArray e0(String str) {
        return h0(str);
    }

    public JSArray g0(boolean z11) {
        return h0(Boolean.valueOf(z11));
    }

    public Object get(int i11) {
        return u(JSValue.TYPE.UNKNOWN, i11);
    }

    public double getDouble(int i11) {
        Object objU = u(JSValue.TYPE.DOUBLE, i11);
        if (objU instanceof Double) {
            return ((Double) objU).doubleValue();
        }
        return 0.0d;
    }

    public String getString(int i11) {
        Object objU = u(JSValue.TYPE.STRING, i11);
        if (objU instanceof String) {
            return (String) objU;
        }
        return null;
    }

    public JSArray h0(Object obj) {
        this.context.b0();
        getNative()._arrayAdd(getContextPtr(), this, obj);
        return this;
    }

    public JSONArray i0() {
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < W(); i11++) {
            Object obj = get(i11);
            if (!(obj instanceof JSObject.a) && !(obj instanceof JSFunction)) {
                if ((obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean)) {
                    jSONArray.put(obj);
                } else if (obj instanceof JSArray) {
                    jSONArray.put(((JSArray) obj).i0());
                } else if (obj instanceof JSObject) {
                    jSONArray.put(((JSObject) obj).t());
                }
            }
        }
        return jSONArray;
    }

    public Object u(JSValue.TYPE type, int i11) {
        this.context.b0();
        if (type == null) {
            type = JSValue.TYPE.UNKNOWN;
        }
        return JSValue.checkType(getNative()._arrayGet(getContextPtr(), type.value, this, i11), type);
    }

    public JSArray w(int i11) {
        Object objU = u(JSValue.TYPE.JS_ARRAY, i11);
        if (objU instanceof JSArray) {
            return (JSArray) objU;
        }
        return null;
    }

    public boolean x(int i11) {
        Object objU = u(JSValue.TYPE.BOOLEAN, i11);
        if (objU instanceof Boolean) {
            return ((Boolean) objU).booleanValue();
        }
        return false;
    }

    public int y(int i11) {
        Object objU = u(JSValue.TYPE.INTEGER, i11);
        if (objU instanceof Integer) {
            return ((Integer) objU).intValue();
        }
        return 0;
    }
}
