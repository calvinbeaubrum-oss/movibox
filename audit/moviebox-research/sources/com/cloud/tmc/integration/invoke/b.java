package com.cloud.tmc.integration.invoke;

import androidx.annotation.Nullable;
import androidx.collection.w0;
import cc.h;
import cc.i;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.extension.RequiredParamNotFoundException;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.utils.k;
import com.google.gson.JsonObject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final mc.a f30792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JsonObject f30793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f30794i;

    public b(Node node, NativeCallContext nativeCallContext, mc.a aVar) {
        this(node, nativeCallContext, aVar, null);
    }

    public b(Node node, NativeCallContext nativeCallContext, mc.a aVar, @Nullable rc.a aVar2) {
        super(node, null);
        this.f30792g = aVar;
        this.f30793h = nativeCallContext.getParams();
        this.f30794i = nativeCallContext.getId();
    }

    @Override // com.cloud.tmc.integration.invoke.d
    public d.b d(Object obj, Method method, Object[] objArr) throws Throwable {
        JsonObject jsonObject;
        if (method.getAnnotation(i.class) != null && ((jsonObject = this.f30793h) == null || jsonObject.size() == 0)) {
            new com.cloud.tmc.kernel.extension.b(this.f30792g, false).i(bc.b.f14085d);
            return d.b.d(null);
        }
        int length = method.getParameterTypes().length;
        Object[] objArr2 = new Object[length];
        w0<Annotation[]> w0VarH = h(method);
        for (int i11 = 0; i11 < length; i11++) {
            try {
                objArr2[i11] = g(method.getParameterTypes()[i11], w0VarH.g(i11));
            } catch (RequiredParamNotFoundException e11) {
                new com.cloud.tmc.kernel.extension.b(this.f30792g, false).i(new bc.b.C0142b(2, e11.getMessage()));
                return d.b.d(null);
            }
        }
        try {
            k.a(this.f30795a, this.f30798d.get(0));
            this.f30792g.q(this.f30798d.get(0));
            Object objE = e(this.f30798d, obj, method, objArr2);
            if (method.getAnnotation(zb.b.class) != null) {
                if (objE == null) {
                    TmcLogger.n("AutoCallback but got null!!! " + this.f30798d.get(0) + " method: " + method);
                    new com.cloud.tmc.kernel.extension.b(this.f30792g, false).i(bc.b.f14083b);
                    return d.b.d(null);
                }
                if (objE instanceof bc.b) {
                    new com.cloud.tmc.kernel.extension.b(this.f30792g, false).i((bc.b) objE);
                } else if (objE instanceof JsonObject) {
                    new com.cloud.tmc.kernel.extension.b(this.f30792g, false).a((JsonObject) objE);
                } else {
                    new com.cloud.tmc.kernel.extension.b(this.f30792g, false).i(new bc.b.C0142b(2, "method " + method.getName() + " return type not recognized " + objE.getClass().getName()));
                }
            }
            return d.b.d(objE);
        } catch (InvokeException e12) {
            TmcLogger.g("TmcEngine:BridgeExtensionInvoker", "Java exception happened!\nExtension: " + this.f30798d.get(0) + "\nMethod: " + method, e12);
            new com.cloud.tmc.kernel.extension.b(this.f30792g, false).i(new bc.b.C0142b(6, "Java exception happen in method: " + method + " message: " + e12.getMessage()));
            return d.b.d(null);
        }
    }

    public final Object g(Class cls, Annotation[] annotationArr) {
        dc.b eVar;
        Annotation annotation = (annotationArr == null || annotationArr.length <= 0) ? null : annotationArr[0];
        if (annotation instanceof cc.g) {
            eVar = new dc.g(this.f30793h);
        } else if (annotation instanceof h) {
            eVar = new dc.h(this.f30793h);
        } else if (annotation instanceof cc.c) {
            eVar = new dc.c(this.f30792g);
        } else if (annotation instanceof cc.d) {
            eVar = new dc.d();
        } else if (annotation instanceof cc.f) {
            eVar = new dc.f(this.f30795a);
        } else if (annotation instanceof cc.b) {
            eVar = new dc.a(null);
        } else {
            eVar = annotation instanceof cc.e ? new dc.e(this.f30794i) : null;
        }
        Object objA = eVar != null ? eVar.a(cls, annotation) : null;
        if (objA == null && cls.isPrimitive()) {
            return 0;
        }
        return objA;
    }

    public final w0<Annotation[]> h(Method method) {
        w0<Annotation[]> w0Var = new w0<>();
        if (method == null) {
            return w0Var;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterTypes != null && parameterTypes.length != 0) {
            for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                Annotation[] annotationArr = parameterAnnotations[i11];
                if (annotationArr != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Annotation annotation : annotationArr) {
                        if (annotation != null && annotation.annotationType() != null && annotation.annotationType().getAnnotation(cc.a.class) != null) {
                            arrayList.add(annotation);
                        }
                    }
                    if (arrayList.size() > 0) {
                        w0Var.m(i11, (Annotation[]) arrayList.toArray(new Annotation[arrayList.size()]));
                    }
                }
            }
        }
        return w0Var;
    }
}
