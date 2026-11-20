package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class h0 implements z0, b2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h0 f71645b = new h0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NumberFormat f71646a;

    public h0() {
    }

    public h0(String str) {
        this(new DecimalFormat(str));
    }

    public h0(DecimalFormat decimalFormat) {
        this.f71646a = decimalFormat;
    }

    public static <T> T f(l7.a aVar) {
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 2) {
            String strV0 = bVar.v0();
            bVar.W(16);
            return (T) Float.valueOf(Float.parseFloat(strV0));
        }
        if (bVar.k0() == 3) {
            float fJ0 = bVar.j0();
            bVar.W(16);
            return (T) Float.valueOf(fJ0);
        }
        Object objX = aVar.x();
        if (objX == null) {
            return null;
        }
        return (T) TypeUtils.s(objX);
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
        float fFloatValue = ((Float) obj).floatValue();
        NumberFormat numberFormat = this.f71646a;
        if (numberFormat != null) {
            j1Var.write(numberFormat.format(fFloatValue));
        } else {
            j1Var.W(fFloatValue, true);
        }
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        try {
            return (T) f(aVar);
        } catch (Exception e11) {
            throw new JSONException("parseLong error, field : " + obj, e11);
        }
    }
}
