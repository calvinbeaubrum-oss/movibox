package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j0 implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j0 f71665a = new j0();

    @Override // m7.b2
    public int b() {
        return 2;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        Number number = (Number) obj;
        if (number == null) {
            j1Var.i0(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        if (obj instanceof Long) {
            j1Var.e0(number.longValue());
        } else {
            j1Var.b0(number.intValue());
        }
        if (j1Var.k(SerializerFeature.WriteClassName)) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                j1Var.write(66);
            } else if (cls == Short.class) {
                j1Var.write(83);
            }
        }
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        Object obj2;
        l7.b bVar = aVar.f70077g;
        int iK0 = bVar.k0();
        if (iK0 == 8) {
            bVar.W(16);
            return null;
        }
        try {
            if (iK0 == 2) {
                int iH = bVar.h();
                bVar.W(16);
                obj2 = (T) Integer.valueOf(iH);
            } else if (iK0 == 3) {
                obj2 = (T) Integer.valueOf(TypeUtils.l0(bVar.Z()));
                bVar.W(16);
            } else if (iK0 == 12) {
                JSONObject jSONObject = new JSONObject(true);
                aVar.p0(jSONObject);
                obj2 = (T) TypeUtils.t(jSONObject);
            } else {
                obj2 = (T) TypeUtils.t(aVar.x());
            }
            obj = AtomicInteger.class;
            return type == obj ? (T) new AtomicInteger(((Integer) obj2).intValue()) : (T) obj2;
        } catch (Exception e11) {
            String str = "parseInt error";
            if (obj != null) {
                str = "parseInt error, field : " + obj;
            }
            throw new JSONException(str, e11);
        }
    }
}
