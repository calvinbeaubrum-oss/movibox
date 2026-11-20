package m7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a2 implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f70876a = new a2();

    @Override // m7.b2
    public int b() {
        return 2;
    }

    /* JADX WARN: Type inference failed for: r8v24, types: [T, java.math.BigDecimal] */
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String strV0 = bVar.v0();
                bVar.W(16);
                return (T) Double.valueOf(Double.parseDouble(strV0));
            }
            long jD = bVar.d();
            bVar.W(16);
            if (type == Short.TYPE || type == Short.class) {
                if (jD <= 32767 && jD >= -32768) {
                    return (T) Short.valueOf((short) jD);
                }
                throw new JSONException("short overflow : " + jD);
            }
            if (type != Byte.TYPE && type != Byte.class) {
                return (jD < -2147483648L || jD > 2147483647L) ? (T) Long.valueOf(jD) : (T) Integer.valueOf((int) jD);
            }
            if (jD <= 127 && jD >= -128) {
                return (T) Byte.valueOf((byte) jD);
            }
            throw new JSONException("short overflow : " + jD);
        }
        if (bVar.k0() == 3) {
            if (type == Double.TYPE || type == Double.class) {
                String strV1 = bVar.v0();
                bVar.W(16);
                return (T) Double.valueOf(Double.parseDouble(strV1));
            }
            if (type == Short.TYPE || type == Short.class) {
                BigDecimal bigDecimalZ = bVar.Z();
                bVar.W(16);
                return (T) Short.valueOf(TypeUtils.N0(bigDecimalZ));
            }
            if (type == Byte.TYPE || type == Byte.class) {
                BigDecimal bigDecimalZ2 = bVar.Z();
                bVar.W(16);
                return (T) Byte.valueOf(TypeUtils.e(bigDecimalZ2));
            }
            ?? r11 = (T) bVar.Z();
            bVar.W(16);
            return bVar.g(Feature.UseBigDecimal) ? r11 : (T) Double.valueOf(r11.doubleValue());
        }
        if (bVar.k0() == 18 && "NaN".equals(bVar.g0())) {
            bVar.w();
            if (type == Double.class) {
                return (T) Double.valueOf(Double.NaN);
            }
            if (type == Float.class) {
                return (T) Float.valueOf(Float.NaN);
            }
            return null;
        }
        Object objX = aVar.x();
        if (objX == null) {
            return null;
        }
        if (type == Double.TYPE || type == Double.class) {
            try {
                return (T) TypeUtils.q(objX);
            } catch (Exception e11) {
                throw new JSONException("parseDouble error, field : " + obj, e11);
            }
        }
        if (type == Short.TYPE || type == Short.class) {
            try {
                return (T) TypeUtils.x(objX);
            } catch (Exception e12) {
                throw new JSONException("parseShort error, field : " + obj, e12);
            }
        }
        if (type != Byte.TYPE && type != Byte.class) {
            return (T) TypeUtils.i(objX);
        }
        try {
            return (T) TypeUtils.l(objX);
        } catch (Exception e13) {
            throw new JSONException("parseByte error, field : " + obj, e13);
        }
    }
}
