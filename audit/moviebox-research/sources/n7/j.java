package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Class f71660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f71661b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Method f71662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Method f71663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static j f71664e = new j();

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            Class<?> cls = interfaces[0];
            if (f71660a == null && !f71661b) {
                try {
                    f71660a = Class.forName("sun.reflect.annotation.AnnotationType");
                } catch (Throwable th2) {
                    f71661b = true;
                    throw new JSONException("not support Type Annotation.", th2);
                }
            }
            if (f71660a == null) {
                throw new JSONException("not support Type Annotation.");
            }
            if (f71662c == null && !f71661b) {
                try {
                    f71662c = f71660a.getMethod("getInstance", Class.class);
                } catch (Throwable th3) {
                    f71661b = true;
                    throw new JSONException("not support Type Annotation.", th3);
                }
            }
            if (f71663d == null && !f71661b) {
                try {
                    f71663d = f71660a.getMethod("members", new Class[0]);
                } catch (Throwable th4) {
                    f71661b = true;
                    throw new JSONException("not support Type Annotation.", th4);
                }
            }
            if (f71662c == null || f71661b) {
                throw new JSONException("not support Type Annotation.");
            }
            try {
                Object[] objArr = {cls};
                Object objInvoke = null;
                try {
                    Map map = (Map) f71663d.invoke(f71662c.invoke(null, objArr), new Object[0]);
                    JSONObject jSONObject = new JSONObject(map.size());
                    for (Map.Entry entry : map.entrySet()) {
                        try {
                            objInvoke = ((Method) entry.getValue()).invoke(obj, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException unused) {
                        }
                        jSONObject.put((String) entry.getKey(), com.alibaba.fastjson.a.toJSON(objInvoke));
                    }
                    o0Var.H(jSONObject);
                } catch (Throwable th5) {
                    f71661b = true;
                    throw new JSONException("not support Type Annotation.", th5);
                }
            } catch (Throwable th6) {
                f71661b = true;
                throw new JSONException("not support Type Annotation.", th6);
            }
        }
    }
}
