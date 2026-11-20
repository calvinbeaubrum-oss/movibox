package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.android.gms.ads.RequestConfiguration;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class o0 extends i1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g1 f71700j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j1 f71701k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f71702l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f71703m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f71704n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DateFormat f71705o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f71706p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public IdentityHashMap<Object, e1> f71707q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public e1 f71708r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TimeZone f71709s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Locale f71710t;

    public o0() {
        this(new j1(), g1.g());
    }

    public o0(j1 j1Var) {
        this(j1Var, g1.g());
    }

    public o0(j1 j1Var, g1 g1Var) {
        this.f71702l = 0;
        this.f71703m = "\t";
        this.f71707q = null;
        this.f71709s = com.alibaba.fastjson.a.defaultTimeZone;
        this.f71710t = com.alibaba.fastjson.a.defaultLocale;
        this.f71701k = j1Var;
        this.f71700j = g1Var;
    }

    public boolean A(SerializerFeature serializerFeature) {
        return this.f71701k.k(serializerFeature);
    }

    public final boolean B(Type type, Object obj) {
        e1 e1Var;
        return this.f71701k.k(SerializerFeature.WriteClassName) && !(type == null && this.f71701k.k(SerializerFeature.NotWriteRootClassName) && ((e1Var = this.f71708r) == null || e1Var.f71599a == null));
    }

    public void C() {
        this.f71701k.write(10);
        for (int i11 = 0; i11 < this.f71702l; i11++) {
            this.f71701k.write(this.f71703m);
        }
    }

    public void D(e1 e1Var, Object obj, Object obj2, int i11) {
        E(e1Var, obj, obj2, i11, 0);
    }

    public void E(e1 e1Var, Object obj, Object obj2, int i11, int i12) {
        if (this.f71701k.f71679i) {
            return;
        }
        this.f71708r = new e1(e1Var, obj, obj2, i11, i12);
        if (this.f71707q == null) {
            this.f71707q = new IdentityHashMap<>();
        }
        this.f71707q.put(obj, this.f71708r);
    }

    public void F(String str) {
        this.f71704n = str;
        if (this.f71705o != null) {
            this.f71705o = null;
        }
    }

    public void G(String str) {
        this.f71706p = str;
    }

    public final void H(Object obj) {
        if (obj == null) {
            this.f71701k.g0();
            return;
        }
        try {
            x(obj.getClass()).d(this, obj, null, null, 0);
        } catch (IOException e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public final void I(String str) {
        k1.f71692a.g(this, str);
    }

    public void J() {
        this.f71701k.g0();
    }

    public void K(Object obj) {
        e1 e1Var = this.f71708r;
        if (obj == e1Var.f71600b) {
            this.f71701k.write("{\"$ref\":\"@\"}");
            return;
        }
        e1 e1Var2 = e1Var.f71599a;
        if (e1Var2 != null && obj == e1Var2.f71600b) {
            this.f71701k.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            e1 e1Var3 = e1Var.f71599a;
            if (e1Var3 == null) {
                break;
            } else {
                e1Var = e1Var3;
            }
        }
        if (obj == e1Var.f71600b) {
            this.f71701k.write("{\"$ref\":\"$\"}");
            return;
        }
        this.f71701k.write("{\"$ref\":\"");
        this.f71701k.write(this.f71707q.get(obj).toString());
        this.f71701k.write("\"}");
    }

    public final void L(Object obj, Object obj2) {
        M(obj, obj2, null, 0);
    }

    public final void M(Object obj, Object obj2, Type type, int i11) {
        try {
            if (obj == null) {
                this.f71701k.g0();
            } else {
                x(obj.getClass()).d(this, obj, obj2, type, i11);
            }
        } catch (IOException e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public final void N(Object obj, String str) {
        if (obj instanceof Date) {
            if ("unixtime".equals(str)) {
                this.f71701k.b0((int) (((Date) obj).getTime() / 1000));
                return;
            }
            if ("millis".equals(str)) {
                this.f71701k.e0(((Date) obj).getTime());
                return;
            }
            DateFormat dateFormatU = u();
            if (dateFormatU == null) {
                if (str != null) {
                    try {
                        dateFormatU = t(str);
                    } catch (IllegalArgumentException unused) {
                        dateFormatU = t(str.replaceAll(RequestConfiguration.MAX_AD_CONTENT_RATING_T, "'T'"));
                    }
                } else {
                    String str2 = this.f71706p;
                    dateFormatU = str2 != null ? t(str2) : t(com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT);
                }
            }
            this.f71701k.j0(dateFormatU.format((Date) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            if (!(obj instanceof Collection)) {
                H(obj);
                return;
            }
            Collection collection = (Collection) obj;
            Iterator it = collection.iterator();
            this.f71701k.write(91);
            for (int i11 = 0; i11 < collection.size(); i11++) {
                Object next = it.next();
                if (i11 != 0) {
                    this.f71701k.write(44);
                }
                N(next, str);
            }
            this.f71701k.write(93);
            return;
        }
        byte[] bArr = (byte[]) obj;
        if (!"gzip".equals(str) && !"gzip,base64".equals(str)) {
            if ("hex".equals(str)) {
                this.f71701k.Z(bArr);
                return;
            } else {
                this.f71701k.n(bArr);
                return;
            }
        }
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gZIPOutputStream = bArr.length < 512 ? new GZIPOutputStream(byteArrayOutputStream, bArr.length) : new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                this.f71701k.n(byteArrayOutputStream.toByteArray());
                com.alibaba.fastjson.util.f.a(gZIPOutputStream);
            } catch (IOException e11) {
                throw new JSONException("write gzipBytes error", e11);
            }
        } catch (Throwable th2) {
            com.alibaba.fastjson.util.f.a(gZIPOutputStream);
            throw th2;
        }
    }

    public void q(SerializerFeature serializerFeature, boolean z11) {
        this.f71701k.e(serializerFeature, z11);
    }

    public boolean r(Object obj) {
        e1 e1Var;
        IdentityHashMap<Object, e1> identityHashMap = this.f71707q;
        if (identityHashMap == null || (e1Var = identityHashMap.get(obj)) == null || obj == Collections.emptyMap()) {
            return false;
        }
        Object obj2 = e1Var.f71601c;
        return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
    }

    public void s() {
        this.f71702l--;
    }

    public final DateFormat t(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, this.f71710t);
        simpleDateFormat.setTimeZone(this.f71709s);
        return simpleDateFormat;
    }

    public String toString() {
        return this.f71701k.toString();
    }

    public DateFormat u() {
        String str;
        if (this.f71705o == null && (str = this.f71704n) != null) {
            this.f71705o = t(str);
        }
        return this.f71705o;
    }

    public String v() {
        DateFormat dateFormat = this.f71705o;
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : this.f71704n;
    }

    public String w() {
        return this.f71706p;
    }

    public z0 x(Class<?> cls) {
        return this.f71700j.h(cls);
    }

    public j1 y() {
        return this.f71701k;
    }

    public void z() {
        this.f71702l++;
    }
}
