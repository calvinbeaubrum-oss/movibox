package n7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class v extends m7.e implements z0, a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f71756b = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DatatypeFactory f71757a;

    @Override // m7.b2
    public int b() {
        return 2;
    }

    @Override // n7.a0
    public void c(o0 o0Var, Object obj, p pVar) throws IOException {
        j1 j1Var = o0Var.f71701k;
        String strB = pVar.b();
        Calendar calendar = (Calendar) obj;
        if (strB.equals("unixtime")) {
            j1Var.b0((int) (calendar.getTimeInMillis() / 1000));
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strB);
        simpleDateFormat.setTimeZone(o0Var.f71709s);
        j1Var.j0(simpleDateFormat.format(calendar.getTime()));
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        char[] charArray;
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.g0();
            return;
        }
        Calendar gregorianCalendar = obj instanceof XMLGregorianCalendar ? ((XMLGregorianCalendar) obj).toGregorianCalendar() : (Calendar) obj;
        if (!j1Var.k(SerializerFeature.UseISO8601DateFormat)) {
            o0Var.H(gregorianCalendar.getTime());
            return;
        }
        char c11 = j1Var.k(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
        j1Var.append(c11);
        int i12 = gregorianCalendar.get(1);
        int i13 = gregorianCalendar.get(2) + 1;
        int i14 = gregorianCalendar.get(5);
        int i15 = gregorianCalendar.get(11);
        int i16 = gregorianCalendar.get(12);
        int i17 = gregorianCalendar.get(13);
        int i18 = gregorianCalendar.get(14);
        if (i18 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            com.alibaba.fastjson.util.f.i(i18, 23, charArray);
            com.alibaba.fastjson.util.f.i(i17, 19, charArray);
            com.alibaba.fastjson.util.f.i(i16, 16, charArray);
            com.alibaba.fastjson.util.f.i(i15, 13, charArray);
            com.alibaba.fastjson.util.f.i(i14, 10, charArray);
            com.alibaba.fastjson.util.f.i(i13, 7, charArray);
            com.alibaba.fastjson.util.f.i(i12, 4, charArray);
        } else if (i17 == 0 && i16 == 0 && i15 == 0) {
            charArray = "0000-00-00".toCharArray();
            com.alibaba.fastjson.util.f.i(i14, 10, charArray);
            com.alibaba.fastjson.util.f.i(i13, 7, charArray);
            com.alibaba.fastjson.util.f.i(i12, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            com.alibaba.fastjson.util.f.i(i17, 19, charArray);
            com.alibaba.fastjson.util.f.i(i16, 16, charArray);
            com.alibaba.fastjson.util.f.i(i15, 13, charArray);
            com.alibaba.fastjson.util.f.i(i14, 10, charArray);
            com.alibaba.fastjson.util.f.i(i13, 7, charArray);
            com.alibaba.fastjson.util.f.i(i12, 4, charArray);
        }
        j1Var.write(charArray);
        float offset = gregorianCalendar.getTimeZone().getOffset(gregorianCalendar.getTimeInMillis()) / 3600000.0f;
        int i19 = (int) offset;
        if (i19 == 0.0d) {
            j1Var.write(90);
        } else {
            if (i19 > 9) {
                j1Var.write(43);
                j1Var.b0(i19);
            } else if (i19 > 0) {
                j1Var.write(43);
                j1Var.write(48);
                j1Var.b0(i19);
            } else if (i19 < -9) {
                j1Var.write(45);
                j1Var.b0(i19);
            } else if (i19 < 0) {
                j1Var.write(45);
                j1Var.write(48);
                j1Var.b0(-i19);
            }
            j1Var.write(58);
            j1Var.append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf((int) ((offset - i19) * 60.0f))));
        }
        j1Var.append(c11);
    }

    @Override // m7.e, m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        return (T) f(aVar, type, obj, null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.util.Calendar] */
    @Override // m7.e
    public <T> T f(l7.a aVar, Type type, Object obj, String str, int i11) {
        T t11 = (T) c0.f71593a.f(aVar, type, obj, str, i11);
        if (t11 instanceof Calendar) {
            return t11;
        }
        Date date = (Date) t11;
        if (date == null) {
            return null;
        }
        l7.b bVar = aVar.f70077g;
        ?? r11 = (T) Calendar.getInstance(bVar.h0(), bVar.u0());
        r11.setTime(date);
        return type == XMLGregorianCalendar.class ? (T) g((GregorianCalendar) r11) : r11;
    }

    public XMLGregorianCalendar g(Calendar calendar) {
        if (this.f71757a == null) {
            try {
                this.f71757a = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e11) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e11);
            }
        }
        return this.f71757a.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }
}
