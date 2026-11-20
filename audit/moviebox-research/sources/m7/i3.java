package m7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class i3 extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i3 f70896b = new i3();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i3 f70897c = new i3(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f70898a = false;

    public i3() {
    }

    public i3(boolean z11) {
    }

    @Override // m7.b2
    public int b() {
        return 2;
    }

    @Override // m7.b
    public <T> T g(l7.a aVar, Type type, Object obj, Object obj2) {
        long timeInMillis;
        if (this.f70898a) {
            return (T) h(aVar, type, obj, obj2);
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new java.sql.Date(((Date) obj2).getTime());
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new java.sql.Date(TypeUtils.E0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new java.sql.Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error : " + obj2);
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        l7.e eVar = new l7.e(str);
        try {
            if (eVar.p1()) {
                timeInMillis = eVar.C0().getTimeInMillis();
            } else {
                try {
                    T t11 = (T) new java.sql.Date(aVar.k().parse(str).getTime());
                    eVar.close();
                    return t11;
                } catch (ParseException unused) {
                    timeInMillis = Long.parseLong(str);
                }
            }
            eVar.close();
            return (T) new java.sql.Date(timeInMillis);
        } catch (Throwable th2) {
            eVar.close();
            throw th2;
        }
    }

    public <T> T h(l7.a aVar, Type type, Object obj, Object obj2) {
        long timeInMillis;
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new Timestamp(((Date) obj2).getTime());
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new Timestamp(TypeUtils.E0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new Timestamp(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        l7.e eVar = new l7.e(str);
        try {
            if (str.length() > 19 && str.charAt(4) == '-' && str.charAt(7) == '-' && str.charAt(10) == ' ' && str.charAt(13) == ':' && str.charAt(16) == ':' && str.charAt(19) == '.') {
                String strJ = aVar.j();
                if (strJ.length() != str.length() && strJ == com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT) {
                    T t11 = (T) Timestamp.valueOf(str);
                    eVar.close();
                    return t11;
                }
            }
            if (eVar.q1(false)) {
                timeInMillis = eVar.C0().getTimeInMillis();
            } else {
                try {
                    T t12 = (T) new Timestamp(aVar.k().parse(str).getTime());
                    eVar.close();
                    return t12;
                } catch (ParseException unused) {
                    timeInMillis = Long.parseLong(str);
                }
            }
            eVar.close();
            return (T) new Timestamp(timeInMillis);
        } catch (Throwable th2) {
            eVar.close();
            throw th2;
        }
    }
}
