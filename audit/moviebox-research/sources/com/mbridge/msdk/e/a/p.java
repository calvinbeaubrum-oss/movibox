package com.mbridge.msdk.e.a;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class p<T> implements Comparable<p<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f43808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f43809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private s f43810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final aa.a f43811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f43813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f43814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f43815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f43816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private r.a f43817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Integer f43818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private q f43819l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f43820m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f43821n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f43822o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f43823p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f43824q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private v f43825r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.mbridge.msdk.e.a.b.a f43826s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private a f43827t;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(p<?> pVar);

        void a(p<?> pVar, r<?> rVar);
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public p(int i11, String str) {
        this(i11, str, 0);
    }

    public p(int i11, String str, int i12) {
        Uri uri;
        String host;
        this.f43811d = null;
        this.f43816i = new Object();
        int iHashCode = 0;
        this.f43820m = false;
        this.f43821n = false;
        this.f43822o = false;
        this.f43823p = false;
        this.f43824q = false;
        this.f43826s = null;
        this.f43812e = i11;
        this.f43813f = str;
        this.f43814g = i12;
        this.f43825r = new f();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.f43815h = iHashCode;
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            int i11 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                i11++;
                if (entry.getKey() != null) {
                    sb2.append(URLEncoder.encode(entry.getKey(), str));
                    sb2.append('=');
                    sb2.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), str));
                    if (i11 <= map.size() - 1) {
                        sb2.append('&');
                    }
                }
            }
            return sb2.toString().getBytes(str);
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException("Encoding not supported: " + str, e11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p<?> a(com.mbridge.msdk.e.a.b.a aVar) {
        this.f43826s = aVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p<?> a(q qVar) {
        this.f43819l = qVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p<?> a(boolean z11) {
        this.f43820m = z11;
        return this;
    }

    public abstract r<T> a(m mVar);

    public Map<String, String> a() {
        return null;
    }

    public final void a(int i11) {
        this.f43812e = i11;
    }

    public final void a(a aVar) {
        synchronized (this.f43816i) {
            this.f43827t = aVar;
        }
    }

    public final void a(r.a aVar) {
        this.f43817j = aVar;
    }

    public final void a(r<?> rVar) {
        a aVar;
        synchronized (this.f43816i) {
            aVar = this.f43827t;
        }
        if (aVar != null) {
            aVar.a(this, rVar);
        }
    }

    public abstract void a(T t11);

    /* JADX WARN: Multi-variable type inference failed */
    public final p<?> b(boolean z11) {
        this.f43823p = z11;
        return this;
    }

    public v b() {
        return this.f43825r;
    }

    public final void b(int i11) {
        q qVar = this.f43819l;
        if (qVar != null) {
            qVar.a(this, i11);
        }
    }

    public final void b(z zVar) {
        r.a aVar;
        synchronized (this.f43816i) {
            aVar = this.f43817j;
        }
        if (aVar != null) {
            aVar.a(zVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p<?> c(int i11) {
        this.f43818k = Integer.valueOf(i11);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p<?> c(boolean z11) {
        this.f43824q = z11;
        return this;
    }

    public void c() {
        synchronized (this.f43816i) {
            this.f43821n = true;
            this.f43817j = null;
        }
    }

    public final void c(String str) {
        q qVar = this.f43819l;
        if (qVar != null) {
            qVar.b(this);
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        p pVar = (p) obj;
        b bVarE = e();
        b bVarE2 = pVar.e();
        return bVarE == bVarE2 ? this.f43818k.intValue() - pVar.f43818k.intValue() : bVarE2.ordinal() - bVarE.ordinal();
    }

    public Map<String, String> d() {
        return Collections.emptyMap();
    }

    public b e() {
        return b.NORMAL;
    }

    public final int f() {
        return this.f43814g;
    }

    public final int g() {
        return this.f43812e;
    }

    public final int h() {
        return this.f43815h;
    }

    public final String i() {
        return this.f43813f;
    }

    public final String j() {
        if (!TextUtils.isEmpty(this.f43809b)) {
            return this.f43809b;
        }
        if (this.f43808a == null) {
            this.f43808a = new com.mbridge.msdk.e.a.a.d();
        }
        String strA = this.f43808a.a(this);
        this.f43809b = strA;
        return strA;
    }

    public final s k() {
        return this.f43810c;
    }

    public final com.mbridge.msdk.e.a.b.a l() {
        return this.f43826s;
    }

    public final boolean m() {
        boolean z11;
        synchronized (this.f43816i) {
            z11 = this.f43821n;
        }
        return z11;
    }

    public final String n() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public final byte[] o() {
        Map<String, String> mapA = a();
        if (mapA == null || mapA.size() <= 0) {
            return null;
        }
        return a(mapA, "UTF-8");
    }

    public final boolean p() {
        return this.f43820m;
    }

    public final boolean q() {
        return this.f43823p;
    }

    public final boolean r() {
        return this.f43824q;
    }

    public final int s() {
        return b().a();
    }

    public final void t() {
        synchronized (this.f43816i) {
            this.f43822o = true;
        }
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(this.f43815h);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m() ? "[X] " : "[ ] ");
        sb2.append(this.f43813f);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append(e());
        sb2.append(" ");
        sb2.append(this.f43818k);
        return sb2.toString();
    }

    public final boolean u() {
        boolean z11;
        synchronized (this.f43816i) {
            z11 = this.f43822o;
        }
        return z11;
    }

    public final void v() {
        a aVar;
        synchronized (this.f43816i) {
            aVar = this.f43827t;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
