package n7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f71693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0 f71694b;

    public l(Class<?> cls, z0 z0Var) {
        this.f71693a = cls;
        this.f71694b = z0Var;
    }

    @Override // n7.z0
    public final void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.i0(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        e1 e1Var = o0Var.f71708r;
        o0Var.D(e1Var, obj, obj2, 0);
        try {
            j1Var.append('[');
            for (int i12 = 0; i12 < length; i12++) {
                if (i12 != 0) {
                    j1Var.append(',');
                }
                Object obj3 = objArr[i12];
                if (obj3 == null) {
                    if (j1Var.k(SerializerFeature.WriteNullStringAsEmpty) && (obj instanceof String[])) {
                        j1Var.j0("");
                    } else {
                        j1Var.append("null");
                    }
                } else if (obj3.getClass() == this.f71693a) {
                    this.f71694b.d(o0Var, obj3, Integer.valueOf(i12), null, 0);
                } else {
                    o0Var.x(obj3.getClass()).d(o0Var, obj3, Integer.valueOf(i12), null, 0);
                }
            }
            j1Var.append(']');
        } finally {
            o0Var.f71708r = e1Var;
        }
    }
}
