package n7;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class z implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f71767a = new z();

    @Override // m7.b2
    public int b() {
        return 14;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.i0(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        Type typeV = (j1Var.k(serializerFeature) || SerializerFeature.isEnabled(i11, serializerFeature)) ? TypeUtils.V(type) : null;
        Collection collection = (Collection) obj;
        e1 e1Var = o0Var.f71708r;
        int i12 = 0;
        o0Var.D(e1Var, obj, obj2, 0);
        if (j1Var.k(serializerFeature)) {
            if (HashSet.class.isAssignableFrom(collection.getClass())) {
                j1Var.append("Set");
            } else if (TreeSet.class == collection.getClass()) {
                j1Var.append("TreeSet");
            }
        }
        try {
            j1Var.append('[');
            for (Object obj3 : collection) {
                int i13 = i12 + 1;
                if (i12 != 0) {
                    j1Var.append(',');
                }
                if (obj3 == null) {
                    j1Var.g0();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        j1Var.b0(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        j1Var.e0(((Long) obj3).longValue());
                        if (j1Var.k(SerializerFeature.WriteClassName)) {
                            j1Var.write(76);
                        }
                    } else {
                        z0 z0VarX = o0Var.x(cls);
                        if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName) && (z0VarX instanceof p0)) {
                            ((p0) z0VarX).E(o0Var, obj3, Integer.valueOf(i12), typeV, i11);
                        } else {
                            z0VarX.d(o0Var, obj3, Integer.valueOf(i12), typeV, i11);
                        }
                    }
                }
                i12 = i13;
            }
            j1Var.append(']');
        } finally {
            o0Var.f71708r = e1Var;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.alibaba.fastjson.JSONArray, java.util.Collection] */
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        Collection collection;
        if (aVar.f70077g.k0() == 8) {
            aVar.f70077g.W(16);
            return null;
        }
        if (type == JSONArray.class) {
            ?? r11 = (T) new JSONArray();
            aVar.d0(r11);
            return r11;
        }
        if (aVar.f70077g.k0() == 21) {
            aVar.f70077g.w();
            collection = (T) TypeUtils.H(type);
        } else {
            collection = (T) TypeUtils.G(type);
        }
        aVar.b0(TypeUtils.V(type), collection, obj);
        return (T) collection;
    }
}
