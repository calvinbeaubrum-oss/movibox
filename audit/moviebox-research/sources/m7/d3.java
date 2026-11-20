package m7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d3 implements n7.z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d3 f70880a = new d3();

    @Override // m7.b2
    public int b() {
        return 12;
    }

    @Override // n7.z0
    public void d(n7.o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        if (obj == null) {
            o0Var.J();
            return;
        }
        if (e2.a(obj)) {
            Optional optionalA = l2.a(obj);
            o0Var.H(optionalA.isPresent() ? optionalA.get() : null);
            return;
        }
        if (p2.a(obj)) {
            OptionalDouble optionalDoubleA = q2.a(obj);
            if (optionalDoubleA.isPresent()) {
                o0Var.H(Double.valueOf(optionalDoubleA.getAsDouble()));
                return;
            } else {
                o0Var.J();
                return;
            }
        }
        if (t2.a(obj)) {
            OptionalInt optionalIntA = u2.a(obj);
            if (optionalIntA.isPresent()) {
                o0Var.f71701k.b0(optionalIntA.getAsInt());
                return;
            } else {
                o0Var.J();
                return;
            }
        }
        if (!h2.a(obj)) {
            throw new JSONException("not support optional : " + obj.getClass());
        }
        OptionalLong optionalLongA = i2.a(obj);
        if (optionalLongA.isPresent()) {
            o0Var.f71701k.e0(optionalLongA.getAsLong());
        } else {
            o0Var.J();
        }
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        if (type == c2.a()) {
            Integer numT = TypeUtils.t(aVar.j0(Integer.class));
            return numT == null ? (T) OptionalInt.empty() : (T) OptionalInt.of(numT.intValue());
        }
        if (type == x2.a()) {
            Long lW = TypeUtils.w(aVar.j0(Long.class));
            return lW == null ? (T) OptionalLong.empty() : (T) OptionalLong.of(lW.longValue());
        }
        if (type == a3.a()) {
            Double dQ = TypeUtils.q(aVar.j0(Double.class));
            return dQ == null ? (T) OptionalDouble.empty() : (T) OptionalDouble.of(dQ.doubleValue());
        }
        Object objK0 = aVar.k0(TypeUtils.P0(type));
        return objK0 == null ? (T) Optional.empty() : (T) Optional.of(objK0);
    }
}
