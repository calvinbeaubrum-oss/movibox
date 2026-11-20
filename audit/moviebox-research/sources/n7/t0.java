package n7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f71750a = new t0();

    @Override // n7.z0
    public final void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        boolean z11 = j1Var.k(serializerFeature) || SerializerFeature.isEnabled(i11, serializerFeature);
        j1 j1Var2 = o0Var.f71701k;
        Type typeV = z11 ? TypeUtils.V(type) : null;
        if (obj == null) {
            j1Var2.i0(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            j1Var2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        e1 e1Var = o0Var.f71708r;
        o0Var.D(e1Var, obj, obj2, 0);
        try {
            char c11 = ',';
            if (j1Var2.k(SerializerFeature.PrettyFormat)) {
                j1Var2.append('[');
                o0Var.z();
                int i12 = 0;
                for (Object obj3 : list) {
                    if (i12 != 0) {
                        j1Var2.append(c11);
                    }
                    o0Var.C();
                    if (obj3 == null) {
                        o0Var.f71701k.g0();
                    } else if (o0Var.r(obj3)) {
                        o0Var.K(obj3);
                    } else {
                        z0 z0VarX = o0Var.x(obj3.getClass());
                        o0Var.f71708r = new e1(e1Var, obj, obj2, 0, 0);
                        z0VarX.d(o0Var, obj3, Integer.valueOf(i12), typeV, i11);
                    }
                    i12++;
                    c11 = ',';
                }
                o0Var.s();
                o0Var.C();
                j1Var2.append(']');
                return;
            }
            char c12 = ',';
            j1Var2.append('[');
            int size = list.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj4 = list.get(i13);
                if (i13 != 0) {
                    j1Var2.append(c12);
                }
                if (obj4 == null) {
                    j1Var2.append("null");
                } else {
                    Class<?> cls = obj4.getClass();
                    if (cls == Integer.class) {
                        j1Var2.b0(((Integer) obj4).intValue());
                    } else {
                        if (cls == Long.class) {
                            long jLongValue = ((Long) obj4).longValue();
                            if (z11) {
                                j1Var2.e0(jLongValue);
                                j1Var2.write(76);
                            } else {
                                j1Var2.e0(jLongValue);
                            }
                        } else if ((SerializerFeature.DisableCircularReferenceDetect.mask & i11) != 0) {
                            o0Var.x(obj4.getClass()).d(o0Var, obj4, Integer.valueOf(i13), typeV, i11);
                            z11 = z11;
                        } else {
                            i13 = i13;
                            if (!j1Var2.f71679i) {
                                o0Var.f71708r = new e1(e1Var, obj, obj2, 0, 0);
                            }
                            if (o0Var.r(obj4)) {
                                o0Var.K(obj4);
                            } else {
                                z0 z0VarX2 = o0Var.x(obj4.getClass());
                                if ((SerializerFeature.WriteClassName.mask & i11) == 0 || !(z0VarX2 instanceof p0)) {
                                    z0VarX2.d(o0Var, obj4, Integer.valueOf(i13), typeV, i11);
                                } else {
                                    ((p0) z0VarX2).E(o0Var, obj4, Integer.valueOf(i13), typeV, i11);
                                }
                            }
                        }
                        i13++;
                        z11 = z11;
                        c12 = ',';
                    }
                }
                z11 = z11;
                i13++;
                z11 = z11;
                c12 = ',';
            }
            j1Var2.append(']');
        } finally {
            o0Var.f71708r = e1Var;
        }
    }
}
