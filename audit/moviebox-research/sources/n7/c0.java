package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.android.material.timepicker.TimeModel;
import com.hisavana.common.constant.ComConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0 extends m7.b implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f71593a = new c0();

    @Override // m7.b2
    public int b() {
        return 2;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        char[] charArray;
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.g0();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == Date.class && !j1Var.k(SerializerFeature.WriteDateUseDateFormat)) {
            long time = ((Date) obj).getTime();
            if ((time + ((long) o0Var.f71709s.getOffset(time))) % ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED == 0 && !SerializerFeature.isEnabled(j1Var.f71674c, i11, SerializerFeature.WriteClassName)) {
                j1Var.j0(obj.toString());
                return;
            }
        }
        if (cls == Time.class) {
            long time2 = ((Time) obj).getTime();
            if ("unixtime".equals(o0Var.v())) {
                j1Var.e0(time2 / 1000);
                return;
            } else if ("millis".equals(o0Var.v())) {
                j1Var.e0(time2);
                return;
            } else if (time2 < ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                j1Var.j0(obj.toString());
                return;
            }
        }
        int nanos = cls == Timestamp.class ? ((Timestamp) obj).getNanos() : 0;
        java.util.Date dateO = obj instanceof java.util.Date ? (java.util.Date) obj : TypeUtils.o(obj);
        if ("unixtime".equals(o0Var.v())) {
            j1Var.e0(dateO.getTime() / 1000);
            return;
        }
        if ("millis".equals(o0Var.v())) {
            j1Var.e0(dateO.getTime());
            return;
        }
        if (j1Var.k(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat dateFormatU = o0Var.u();
            if (dateFormatU == null) {
                String strW = o0Var.w();
                if (strW == null) {
                    strW = com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strW, o0Var.f71710t);
                simpleDateFormat.setTimeZone(o0Var.f71709s);
                dateFormatU = simpleDateFormat;
            }
            j1Var.j0(dateFormatU.format(dateO));
            return;
        }
        if (j1Var.k(SerializerFeature.WriteClassName) && cls != type) {
            if (cls == java.util.Date.class) {
                j1Var.write("new Date(");
                j1Var.e0(((java.util.Date) obj).getTime());
                j1Var.write(41);
                return;
            } else {
                j1Var.write(123);
                j1Var.q(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY);
                o0Var.I(cls.getName());
                j1Var.w(',', "val", ((java.util.Date) obj).getTime());
                j1Var.write(125);
                return;
            }
        }
        long time3 = dateO.getTime();
        if (!j1Var.k(SerializerFeature.UseISO8601DateFormat)) {
            j1Var.e0(time3);
            return;
        }
        int i12 = j1Var.k(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        j1Var.write(i12);
        Calendar calendar = Calendar.getInstance(o0Var.f71709s, o0Var.f71710t);
        calendar.setTimeInMillis(time3);
        int i13 = calendar.get(1);
        int i14 = calendar.get(2) + 1;
        int i15 = calendar.get(5);
        int i16 = calendar.get(11);
        int i17 = calendar.get(12);
        int i18 = calendar.get(13);
        int i19 = calendar.get(14);
        if (nanos > 0) {
            charArray = "0000-00-00 00:00:00.000000000".toCharArray();
            com.alibaba.fastjson.util.f.i(nanos, 29, charArray);
            com.alibaba.fastjson.util.f.i(i18, 19, charArray);
            com.alibaba.fastjson.util.f.i(i17, 16, charArray);
            com.alibaba.fastjson.util.f.i(i16, 13, charArray);
            com.alibaba.fastjson.util.f.i(i15, 10, charArray);
            com.alibaba.fastjson.util.f.i(i14, 7, charArray);
            com.alibaba.fastjson.util.f.i(i13, 4, charArray);
        } else if (i19 != 0) {
            char[] charArray2 = "0000-00-00T00:00:00.000".toCharArray();
            com.alibaba.fastjson.util.f.i(i19, 23, charArray2);
            com.alibaba.fastjson.util.f.i(i18, 19, charArray2);
            com.alibaba.fastjson.util.f.i(i17, 16, charArray2);
            com.alibaba.fastjson.util.f.i(i16, 13, charArray2);
            com.alibaba.fastjson.util.f.i(i15, 10, charArray2);
            com.alibaba.fastjson.util.f.i(i14, 7, charArray2);
            com.alibaba.fastjson.util.f.i(i13, 4, charArray2);
            charArray = charArray2;
        } else if (i18 == 0 && i17 == 0 && i16 == 0) {
            char[] charArray3 = "0000-00-00".toCharArray();
            com.alibaba.fastjson.util.f.i(i15, 10, charArray3);
            com.alibaba.fastjson.util.f.i(i14, 7, charArray3);
            com.alibaba.fastjson.util.f.i(i13, 4, charArray3);
            charArray = charArray3;
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            com.alibaba.fastjson.util.f.i(i18, 19, charArray);
            com.alibaba.fastjson.util.f.i(i17, 16, charArray);
            com.alibaba.fastjson.util.f.i(i16, 13, charArray);
            com.alibaba.fastjson.util.f.i(i15, 10, charArray);
            com.alibaba.fastjson.util.f.i(i14, 7, charArray);
            com.alibaba.fastjson.util.f.i(i13, 4, charArray);
        }
        if (nanos > 0) {
            int i21 = 0;
            while (i21 < 9 && charArray[(charArray.length - i21) - 1] == '0') {
                i21++;
            }
            j1Var.write(charArray, 0, charArray.length - i21);
            j1Var.write(i12);
            return;
        }
        j1Var.write(charArray);
        float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
        int i22 = (int) offset;
        if (i22 == 0.0d) {
            j1Var.write(90);
        } else {
            if (i22 > 9) {
                j1Var.write(43);
                j1Var.b0(i22);
            } else if (i22 > 0) {
                j1Var.write(43);
                j1Var.write(48);
                j1Var.b0(i22);
            } else if (i22 < -9) {
                j1Var.write(45);
                j1Var.b0(-i22);
            } else if (i22 < 0) {
                j1Var.write(45);
                j1Var.write(48);
                j1Var.b0(-i22);
            }
            j1Var.write(58);
            j1Var.append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf((int) (Math.abs(offset - i22) * 60.0f))));
        }
        j1Var.write(i12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v19, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r6v25, types: [T, java.util.Calendar] */
    @Override // m7.b
    public <T> T g(l7.a aVar, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof java.util.Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new java.util.Date(TypeUtils.E0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new java.util.Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error");
        }
        String strSubstring = (String) obj2;
        if (strSubstring.length() == 0) {
            return null;
        }
        if (strSubstring.length() == 23 && strSubstring.endsWith(" 000")) {
            strSubstring = strSubstring.substring(0, 19);
        }
        l7.e eVar = new l7.e(strSubstring);
        try {
            if (eVar.q1(false)) {
                ?? r11 = (T) eVar.C0();
                if (type == Calendar.class) {
                    eVar.close();
                    return r11;
                }
                T t11 = (T) r11.getTime();
                eVar.close();
                return t11;
            }
            eVar.close();
            String strJ = aVar.j();
            if (strSubstring.length() == strJ.length() || ((strSubstring.length() == 22 && strJ.equals("yyyyMMddHHmmssSSSZ")) || (strSubstring.indexOf(84) != -1 && strJ.contains("'T'") && strSubstring.length() + 2 == strJ.length()))) {
                try {
                    return (T) aVar.k().parse(strSubstring);
                } catch (ParseException unused) {
                }
            }
            if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
            }
            if ("0000-00-00".equals(strSubstring) || "0000-00-00T00:00:00".equalsIgnoreCase(strSubstring) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(strSubstring)) {
                return null;
            }
            int iLastIndexOf = strSubstring.lastIndexOf(124);
            if (iLastIndexOf > 20) {
                TimeZone timeZone = TimeZone.getTimeZone(strSubstring.substring(iLastIndexOf + 1));
                if (!"GMT".equals(timeZone.getID())) {
                    l7.e eVar2 = new l7.e(strSubstring.substring(0, iLastIndexOf));
                    try {
                        if (eVar2.q1(false)) {
                            ?? r12 = (T) eVar2.C0();
                            r12.setTimeZone(timeZone);
                            return type == Calendar.class ? r12 : (T) r12.getTime();
                        }
                    } finally {
                        eVar2.close();
                    }
                }
            }
            return (T) new java.util.Date(Long.parseLong(strSubstring));
        } catch (Throwable th2) {
            eVar.close();
            throw th2;
        }
    }
}
