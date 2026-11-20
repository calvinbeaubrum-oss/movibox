package n7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f0 implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f0 f71603a = new f0();

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.i0(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i12 = 0;
        Type type2 = (j1Var.k(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        Enumeration enumeration = (Enumeration) obj;
        e1 e1Var = o0Var.f71708r;
        o0Var.D(e1Var, obj, obj2, 0);
        try {
            j1Var.append('[');
            while (enumeration.hasMoreElements()) {
                Object objNextElement = enumeration.nextElement();
                int i13 = i12 + 1;
                if (i12 != 0) {
                    j1Var.append(',');
                }
                if (objNextElement == null) {
                    j1Var.g0();
                } else {
                    o0Var.x(objNextElement.getClass()).d(o0Var, objNextElement, Integer.valueOf(i12), type2, 0);
                }
                i12 = i13;
            }
            j1Var.append(']');
        } finally {
            o0Var.f71708r = e1Var;
        }
    }
}
