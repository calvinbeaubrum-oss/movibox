package m7;

import com.alibaba.fastjson.JSONException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f70883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f70884b;

    public g(Method method) {
        this.f70883a = method;
        this.f70884b = method.getParameterTypes()[0];
    }

    @Override // m7.b2
    public int b() {
        return 0;
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        try {
            return (T) this.f70883a.invoke(null, aVar.j0(this.f70884b));
        } catch (IllegalAccessException e11) {
            throw new JSONException("parse enum error", e11);
        } catch (InvocationTargetException e12) {
            throw new JSONException("parse enum error", e12);
        }
    }
}
