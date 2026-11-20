package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class u0 implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u0 f71755a = new u0();

    @Override // m7.b2
    public int b() {
        return 2;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.i0(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        long jLongValue = ((Long) obj).longValue();
        j1Var.e0(jLongValue);
        if (!j1Var.k(SerializerFeature.WriteClassName) || jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class || type == Long.TYPE) {
            return;
        }
        j1Var.write(76);
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        Object objW;
        l7.b bVar = aVar.f70077g;
        try {
            int iK0 = bVar.k0();
            if (iK0 == 2) {
                long jD = bVar.d();
                bVar.W(16);
                objW = (T) Long.valueOf(jD);
            } else if (iK0 == 3) {
                objW = (T) Long.valueOf(TypeUtils.E0(bVar.Z()));
                bVar.W(16);
            } else {
                if (iK0 == 12) {
                    JSONObject jSONObject = new JSONObject(true);
                    aVar.p0(jSONObject);
                    objW = (T) TypeUtils.w(jSONObject);
                } else {
                    objW = TypeUtils.w(aVar.x());
                }
                if (objW == null) {
                    return null;
                }
            }
            return type == AtomicLong.class ? (T) new AtomicLong(((Long) objW).longValue()) : (T) objW;
        } catch (Exception e11) {
            throw new JSONException("parseLong error, field : " + obj, e11);
        }
    }
}
