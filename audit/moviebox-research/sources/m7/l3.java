package m7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class l3 implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l3 f70902a = new l3();

    @Override // m7.b2
    public int b() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        long timeInMillis;
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 16) {
            bVar.W(4);
            if (bVar.k0() != 4) {
                throw new JSONException("syntax error");
            }
            bVar.j(2);
            if (bVar.k0() != 2) {
                throw new JSONException("syntax error");
            }
            long jD = bVar.d();
            bVar.W(13);
            if (bVar.k0() != 13) {
                throw new JSONException("syntax error");
            }
            bVar.W(16);
            return (T) new Time(jD);
        }
        T t11 = (T) aVar.x();
        if (t11 == 0) {
            return null;
        }
        if (t11 instanceof Time) {
            return t11;
        }
        if (t11 instanceof BigDecimal) {
            return (T) new Time(TypeUtils.E0((BigDecimal) t11));
        }
        if (t11 instanceof Number) {
            return (T) new Time(((Number) t11).longValue());
        }
        if (!(t11 instanceof String)) {
            throw new JSONException("parse error");
        }
        String str = (String) t11;
        if (str.length() == 0) {
            return null;
        }
        l7.e eVar = new l7.e(str);
        if (eVar.p1()) {
            timeInMillis = eVar.C0().getTimeInMillis();
        } else {
            for (int i11 = 0; i11 < str.length(); i11++) {
                char cCharAt = str.charAt(i11);
                if (cCharAt < '0' || cCharAt > '9') {
                    eVar.close();
                    return (T) Time.valueOf(str);
                }
            }
            timeInMillis = Long.parseLong(str);
        }
        eVar.close();
        return (T) new Time(timeInMillis);
    }
}
