package n7;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d1 implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f71596a = new d1();

    @Override // m7.b2
    public int b() {
        return 12;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        o0Var.H(obj instanceof AtomicReference ? ((AtomicReference) obj).get() : ((Reference) obj).get());
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Object objK0 = aVar.k0(parameterizedType.getActualTypeArguments()[0]);
        Type rawType = parameterizedType.getRawType();
        if (rawType == AtomicReference.class) {
            return (T) new AtomicReference(objK0);
        }
        if (rawType == WeakReference.class) {
            return (T) new WeakReference(objK0);
        }
        if (rawType == SoftReference.class) {
            return (T) new SoftReference(objK0);
        }
        throw new UnsupportedOperationException(rawType.toString());
    }
}
