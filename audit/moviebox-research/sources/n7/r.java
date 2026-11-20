package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class r implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigDecimal f71743a = BigDecimal.valueOf(-9007199254740991L);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigDecimal f71744b = BigDecimal.valueOf(9007199254740991L);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f71745c = new r();

    public static <T> T f(l7.a aVar) {
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 2) {
            T t11 = (T) bVar.Z();
            bVar.W(16);
            return t11;
        }
        if (bVar.k0() == 3) {
            T t12 = (T) bVar.Z();
            bVar.W(16);
            return t12;
        }
        Object objX = aVar.x();
        if (objX == null) {
            return null;
        }
        return (T) TypeUtils.i(objX);
    }

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
        BigDecimal bigDecimal = (BigDecimal) obj;
        int iScale = bigDecimal.scale();
        String string = (!SerializerFeature.isEnabled(i11, j1Var.f71674c, SerializerFeature.WriteBigDecimalAsPlain) || iScale < -100 || iScale >= 100) ? bigDecimal.toString() : bigDecimal.toPlainString();
        if (iScale == 0 && string.length() >= 16 && SerializerFeature.isEnabled(i11, j1Var.f71674c, SerializerFeature.BrowserCompatible) && (bigDecimal.compareTo(f71743a) < 0 || bigDecimal.compareTo(f71744b) > 0)) {
            j1Var.j0(string);
            return;
        }
        j1Var.write(string);
        if (j1Var.k(SerializerFeature.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
            j1Var.write(46);
        }
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        try {
            return (T) f(aVar);
        } catch (Exception e11) {
            throw new JSONException("parseDecimal error, field : " + obj, e11);
        }
    }
}
