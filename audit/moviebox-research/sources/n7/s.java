package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class s implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f71746a = BigInteger.valueOf(-9007199254740991L);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f71747b = BigInteger.valueOf(9007199254740991L);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f71748c = new s();

    public static <T> T f(l7.a aVar) {
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() != 2) {
            Object objX = aVar.x();
            if (objX == null) {
                return null;
            }
            return (T) TypeUtils.j(objX);
        }
        String strV0 = bVar.v0();
        bVar.W(16);
        if (strV0.length() <= 65535) {
            return (T) new BigInteger(strV0);
        }
        throw new JSONException("decimal overflow");
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
        BigInteger bigInteger = (BigInteger) obj;
        String string = bigInteger.toString();
        if (string.length() < 16 || !SerializerFeature.isEnabled(i11, j1Var.f71674c, SerializerFeature.BrowserCompatible) || (bigInteger.compareTo(f71746a) >= 0 && bigInteger.compareTo(f71747b) <= 0)) {
            j1Var.write(string);
        } else {
            j1Var.j0(string);
        }
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        return (T) f(aVar);
    }
}
