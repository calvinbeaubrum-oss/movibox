package com.quickjs;

import android.webkit.JavascriptInterface;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class JSObject extends JSValue {

    /* JADX INFO: compiled from: source.java */
    public static class a extends JSObject {
        public a(y yVar, long j11, int i11, double d11, long j12) {
            super(yVar, j11, i11, d11, j12);
            this.released = true;
        }

        @Override // com.quickjs.JSObject
        public Object c(JSValue.TYPE type, String str, JSArray jSArray) {
            throw new UnsupportedOperationException();
        }

        @Override // com.quickjs.JSObject
        public Object h(JSValue.TYPE type, String str) {
            throw new UnsupportedOperationException();
        }

        public int hashCode() {
            return 99;
        }

        @Override // com.quickjs.JSObject
        public JSFunction o(b0 b0Var, String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.quickjs.JSObject
        public JSFunction p(c0 c0Var, String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.quickjs.JSObject
        public JSObject r(String str, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public JSObject(y yVar) {
        super(yVar, yVar.getNative()._initNewJSObject(yVar.getContextPtr()));
    }

    public JSObject(y yVar, long j11, int i11, double d11, long j12) {
        super(yVar, j11, i11, d11, j12);
    }

    public JSObject(y yVar, JSValue jSValue) {
        super(yVar, jSValue);
    }

    public static void e(JSObject jSObject, final Object obj) {
        for (final Method method : obj.getClass().getMethods()) {
            if (method.getAnnotation(JavascriptInterface.class) != null) {
                String name = method.getName();
                if (method.getReturnType().equals(Void.TYPE)) {
                    jSObject.p(new c0() { // from class: com.quickjs.z
                        @Override // com.quickjs.c0
                        public final void a(JSObject jSObject2, JSArray jSArray) {
                            JSObject.m(method, obj, jSObject2, jSArray);
                        }
                    }, name);
                } else {
                    jSObject.o(new b0() { // from class: com.quickjs.a0
                        @Override // com.quickjs.b0
                        public final Object a(JSObject jSObject2, JSArray jSArray) {
                            return JSObject.n(method, obj, jSObject2, jSArray);
                        }
                    }, name);
                }
            }
        }
    }

    public static Object[] l(Method method, JSArray jSArray) {
        int iW = jSArray.W();
        Object[] objArr = new Object[iW];
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (int i11 = 0; i11 < iW; i11++) {
            Type type = genericParameterTypes[i11];
            if (type == Integer.TYPE || type == Integer.class) {
                objArr[i11] = Integer.valueOf(jSArray.y(i11));
            } else if (type == Double.TYPE || type == Double.class) {
                objArr[i11] = Double.valueOf(jSArray.getDouble(i11));
            } else if (type == Boolean.TYPE || type == Boolean.class) {
                objArr[i11] = Boolean.valueOf(jSArray.x(i11));
            } else if (type == String.class) {
                objArr[i11] = jSArray.getString(i11);
            } else if (type == JSArray.class) {
                objArr[i11] = jSArray.w(i11);
            } else {
                if (type != JSObject.class && type != JSFunction.class) {
                    throw new RuntimeException("Type error");
                }
                objArr[i11] = jSArray.U(i11);
            }
        }
        return objArr;
    }

    public static /* synthetic */ void m(Method method, Object obj, JSObject jSObject, JSArray jSArray) {
        try {
            method.invoke(obj, l(method, jSArray));
        } catch (Exception e11) {
            e11.printStackTrace();
            throw new RuntimeException(e11);
        }
    }

    public static /* synthetic */ Object n(Method method, Object obj, JSObject jSObject, JSArray jSArray) {
        try {
            return method.invoke(obj, l(method, jSArray));
        } catch (Exception e11) {
            e11.printStackTrace();
            throw new RuntimeException(e11);
        }
    }

    public Object c(JSValue.TYPE type, String str, JSArray jSArray) {
        this.context.b0();
        this.context.d0(jSArray);
        Object obj_executeFunction = getNative()._executeFunction(this.context.getContextPtr(), type.value, this, str, jSArray);
        QuickJS.b(this.context);
        return JSValue.checkType(obj_executeFunction, type);
    }

    public JSObject d(Object obj, String str) {
        this.context.b0();
        JSObject jSObject = new JSObject(this.context);
        e(jSObject, obj);
        q(str, jSObject);
        return jSObject;
    }

    public Object g(String str, JSArray jSArray) {
        return c(JSValue.TYPE.UNKNOWN, str, jSArray);
    }

    public Object h(JSValue.TYPE type, String str) {
        this.context.b0();
        if (type == null) {
            type = JSValue.TYPE.UNKNOWN;
        }
        return JSValue.checkType(this.context.getNative()._get(getContextPtr(), type.value, this, str), type);
    }

    public Object i(String str) {
        return h(JSValue.TYPE.UNKNOWN, str);
    }

    public int j(String str) {
        return ((Integer) h(JSValue.TYPE.INTEGER, str)).intValue();
    }

    public String[] k() {
        this.context.b0();
        return getContext().getNative()._getKeys(getContextPtr(), this);
    }

    public JSFunction o(b0 b0Var, String str) {
        this.context.b0();
        JSFunction jSFunction_registerJavaMethod = getNative()._registerJavaMethod(getContextPtr(), this, str, b0Var.hashCode(), false);
        this.context.w(b0Var, jSFunction_registerJavaMethod);
        return jSFunction_registerJavaMethod;
    }

    public JSFunction p(c0 c0Var, String str) {
        this.context.b0();
        JSFunction jSFunction_registerJavaMethod = getNative()._registerJavaMethod(getContextPtr(), this, str, c0Var.hashCode(), true);
        this.context.x(c0Var, jSFunction_registerJavaMethod);
        return jSFunction_registerJavaMethod;
    }

    public JSObject q(String str, JSValue jSValue) {
        this.context.d0(jSValue);
        return r(str, jSValue);
    }

    public JSObject r(String str, Object obj) {
        this.context.b0();
        this.context.getNative()._set(getContextPtr(), this, str, obj);
        return this;
    }

    public JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        for (String str : k()) {
            Object objI = i(str);
            if (!(objI instanceof a) && !(objI instanceof JSFunction)) {
                if ((objI instanceof Number) || (objI instanceof String) || (objI instanceof Boolean)) {
                    try {
                        jSONObject.put(str, objI);
                    } catch (JSONException e11) {
                        e11.printStackTrace();
                    }
                } else if (objI instanceof JSArray) {
                    try {
                        jSONObject.put(str, ((JSArray) objI).i0());
                    } catch (JSONException e12) {
                        e12.printStackTrace();
                    }
                } else if (objI instanceof JSObject) {
                    try {
                        jSONObject.put(str, ((JSObject) objI).t());
                    } catch (JSONException e13) {
                        e13.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }
}
