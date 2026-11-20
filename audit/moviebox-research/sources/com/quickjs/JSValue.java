package com.quickjs;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
public class JSValue {
    static final int TYPE_BOOLEAN = 3;
    static final int TYPE_BYTE = 9;
    static final int TYPE_DOUBLE = 2;
    static final int TYPE_FLOAT_32_ARRAY = 16;
    static final int TYPE_FLOAT_64_ARRAY = 2;
    static final int TYPE_INTEGER = 1;
    static final int TYPE_INT_16_ARRAY = 13;
    static final int TYPE_INT_32_ARRAY = 1;
    static final int TYPE_INT_8_ARRAY = 9;
    static final int TYPE_JS_ARRAY = 5;
    static final int TYPE_JS_ARRAY_BUFFER = 10;
    static final int TYPE_JS_FUNCTION = 7;
    static final int TYPE_JS_OBJECT = 6;
    static final int TYPE_JS_TYPED_ARRAY = 8;
    static final int TYPE_NULL = 0;
    static final int TYPE_STRING = 4;
    static final int TYPE_UNDEFINED = 99;
    static final int TYPE_UNKNOWN = 0;
    static final int TYPE_UNSIGNED_INT_16_ARRAY = 14;
    static final int TYPE_UNSIGNED_INT_32_ARRAY = 15;
    static final int TYPE_UNSIGNED_INT_8_ARRAY = 11;
    static final int TYPE_UNSIGNED_INT_8_CLAMPED_ARRAY = 12;
    protected y context;
    volatile boolean released;
    long tag;
    double u_float64;
    int u_int32;
    long u_ptr;

    /* JADX INFO: compiled from: source.java */
    public enum TYPE {
        NULL(0),
        UNKNOWN(0),
        UNDEFINED(JSValue.TYPE_UNDEFINED),
        INTEGER(1),
        DOUBLE(2),
        BOOLEAN(3),
        STRING(4),
        JS_ARRAY(5),
        JS_OBJECT(6),
        JS_FUNCTION(7);

        final int value;

        TYPE(int i11) {
            this.value = i11;
        }
    }

    public JSValue(y yVar, long j11, int i11, double d11, long j12) {
        this.released = false;
        this.context = yVar;
        this.tag = j11;
        this.u_int32 = i11;
        this.u_float64 = d11;
        this.u_ptr = j12;
        if (yVar != null) {
            yVar.U(this);
        }
    }

    public JSValue(y yVar, JSValue jSValue) {
        this.released = false;
        jSValue.released = true;
        this.context = yVar;
        this.tag = jSValue.tag;
        this.u_int32 = jSValue.u_int32;
        this.u_float64 = jSValue.u_float64;
        this.u_ptr = jSValue.u_ptr;
        if (yVar != null) {
            jSValue.released = true;
            yVar.k0(jSValue);
            yVar.U(this);
        }
        if (yVar != null) {
            yVar.b0();
        }
    }

    public static JSValue NULL() {
        return null;
    }

    public static JSObject Undefined(y yVar) {
        return (JSObject) yVar.getNative()._Undefined(yVar.getContextPtr());
    }

    public static Object checkType(Object obj, TYPE type) {
        switch (type.value) {
            case 0:
                return obj;
            case 1:
                if (obj instanceof Integer) {
                    return obj;
                }
                return 0;
            case 2:
                if (obj instanceof Double) {
                    return obj;
                }
                return 0;
            case 3:
                return obj instanceof Boolean ? obj : Boolean.FALSE;
            case 4:
                if (obj instanceof String) {
                    return obj;
                }
                return null;
            case 5:
                if (obj instanceof JSArray) {
                    return obj;
                }
                return null;
            case 6:
                if (obj instanceof JSObject) {
                    return obj;
                }
                return null;
            case 7:
                if (obj instanceof JSFunction) {
                    return obj;
                }
                return null;
            default:
                return null;
        }
    }

    private void close(boolean z11) {
        if (this.released) {
            return;
        }
        this.released = true;
        this.context.j0(this, z11);
    }

    public void close() {
        close(false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && ((JSValue) obj).tag == this.tag;
    }

    public void finalize() throws Throwable {
        if (!(this instanceof y)) {
            close(true);
        }
        super.finalize();
    }

    public y getContext() {
        return this.context;
    }

    public long getContextPtr() {
        return this.context.getContextPtr();
    }

    public g0 getNative() {
        return getContext().getNative();
    }

    public QuickJS getQuickJS() {
        return getContext().getQuickJS();
    }

    public long getTag() {
        return this.tag;
    }

    public TYPE getType() {
        this.context.b0();
        int i_getObjectType = getContext().getNative()._getObjectType(getContextPtr(), this);
        if (i_getObjectType == TYPE_UNDEFINED) {
            return TYPE.UNDEFINED;
        }
        switch (i_getObjectType) {
            case 0:
                return TYPE.UNKNOWN;
            case 1:
                return TYPE.INTEGER;
            case 2:
                return TYPE.DOUBLE;
            case 3:
                return TYPE.BOOLEAN;
            case 4:
                return TYPE.STRING;
            case 5:
                return TYPE.JS_ARRAY;
            case 6:
                return TYPE.JS_OBJECT;
            case 7:
                return TYPE.JS_FUNCTION;
            default:
                return TYPE.UNKNOWN;
        }
    }

    public boolean isUndefined() {
        return getContext().getNative()._isUndefined(getContextPtr(), this);
    }

    public void postEventQueue(Runnable runnable) {
        getQuickJS().i(runnable);
    }
}
