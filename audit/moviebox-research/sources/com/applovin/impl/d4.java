package com.applovin.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.gslb.Utils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d4 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List f18346e = Arrays.asList("5.0/i", "4.0/ad", "1.0/mediate");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f18347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f18348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final eg f18349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f18350d;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f18351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f18352b;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j11) {
            this.f18351a = j11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j11) {
            this.f18352b = j11;
        }

        public long a() {
            return this.f18351a;
        }

        public long b() {
            return this.f18352b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements androidx.core.util.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.network.a f18354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f18355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f18356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f18357e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final b f18358f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final e f18359g;

        private c(String str, com.applovin.impl.sdk.network.a aVar, String str2, Object obj, boolean z11, b bVar, e eVar) {
            this.f18353a = str;
            this.f18354b = aVar;
            this.f18355c = str2;
            this.f18356d = obj;
            this.f18357e = z11;
            this.f18358f = bVar;
            this.f18359g = eVar;
        }

        @Override // androidx.core.util.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(eg.d dVar) {
            int i11;
            long jE = dVar.e();
            Object objA = null;
            int iA = 0;
            try {
                int iC = dVar.c();
                try {
                    if (iC <= 0) {
                        d4.this.a(this.f18355c, this.f18353a, iC, jE, (Throwable) null);
                        this.f18359g.a(this.f18353a, iC, null, null);
                        return;
                    }
                    if (iC < 200 || iC >= 400) {
                        this.f18359g.a(this.f18353a, iC, null, null);
                        return;
                    }
                    b bVar = this.f18358f;
                    if (bVar != null) {
                        bVar.a(jE);
                    }
                    d4.this.a(this.f18355c, this.f18353a, iC, jE);
                    byte[] bArrD = dVar.d();
                    if (yp.f(com.applovin.impl.sdk.j.l()) && (!this.f18357e || vi.b(bArrD) != vi.a.V2)) {
                        d4.this.f18347a.p().a(bArrD != null ? new String(dVar.d(), Charset.forName("UTF-8")) : "", this.f18353a, this.f18354b.b() != null ? this.f18354b.b().toString() : "");
                    }
                    if (bArrD == null) {
                        this.f18359g.a(this.f18353a, this.f18356d, iC);
                        return;
                    }
                    String str = new String(dVar.d(), Charset.forName("UTF-8"));
                    b bVar2 = this.f18358f;
                    if (bVar2 != null) {
                        bVar2.b(bArrD.length);
                        if (this.f18354b.r()) {
                            d4.this.f18350d = new d(this.f18354b.f(), bArrD.length, jE);
                        }
                    }
                    if (this.f18357e) {
                        String strB = vi.b(bArrD, d4.this.f18347a.b0(), d4.this.f18347a);
                        if (strB == null) {
                            HashMap map = new HashMap(2);
                            map.put(PermissionConstant.ACTION_REQUEST, StringUtils.getHostAndPath(this.f18353a));
                            map.put("response", str);
                            d4.this.f18347a.A().trackEvent("rdf", map);
                        }
                        str = strB;
                    }
                    try {
                        this.f18359g.a(this.f18353a, d4.this.a(str, this.f18356d), iC);
                    } catch (Throwable th2) {
                        String str2 = "Unable to parse response from " + StringUtils.getHostAndPath(this.f18353a) + " because of " + th2.getClass().getName() + " : " + th2.getMessage();
                        com.applovin.impl.sdk.n unused = d4.this.f18348b;
                        if (com.applovin.impl.sdk.n.a()) {
                            d4.this.f18348b.a("ConnectionManager", str2, th2);
                        }
                        d4.this.f18347a.D().c(ca.f18157n);
                        d4.this.f18347a.E().a("ConnectionManager", "failedToParseResponse", th2, CollectionUtils.hashMap("url", StringUtils.getHostAndPath(this.f18353a)));
                        this.f18359g.a(this.f18353a, AppLovinErrorCodes.INVALID_RESPONSE, str2, null);
                    }
                } catch (MalformedURLException e11) {
                    e = e11;
                    i11 = iC;
                    if (this.f18356d != null) {
                        d4.this.a(this.f18355c, this.f18353a, i11, jE, e);
                        this.f18359g.a(this.f18353a, -901, e.getMessage(), null);
                    } else {
                        d4.this.a(this.f18355c, this.f18353a, i11, jE);
                        this.f18359g.a(this.f18353a, this.f18356d, -901);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    iA = iC;
                    if (((Boolean) d4.this.f18347a.a(sj.f23036q)).booleanValue()) {
                        iA = dVar.b();
                    }
                    if (iA == 0) {
                        iA = d4.this.a(th);
                    }
                    int i12 = iA;
                    try {
                        byte[] bArrF = dVar.f();
                        String str3 = new String(bArrF);
                        if (bArrF != null) {
                            if (this.f18357e) {
                                str3 = vi.b(bArrF, d4.this.f18347a.b0(), d4.this.f18347a);
                            }
                            objA = d4.this.a(str3, this.f18356d);
                        }
                    } catch (Throwable unused2) {
                    }
                    d4.this.a(this.f18355c, this.f18353a, i12, jE, th);
                    this.f18359g.a(this.f18353a, i12, th.getMessage(), objA);
                }
            } catch (MalformedURLException e12) {
                e = e12;
                i11 = 0;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f18361a = System.currentTimeMillis();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f18363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f18364d;

        public d(String str, long j11, long j12) {
            this.f18362b = str;
            this.f18363c = j11;
            this.f18364d = j12;
        }

        public long a() {
            return this.f18364d;
        }

        public boolean a(Object obj) {
            return obj instanceof d;
        }

        public long b() {
            return this.f18363c;
        }

        public long c() {
            return this.f18361a;
        }

        public String d() {
            return this.f18362b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!dVar.a(this) || c() != dVar.c() || b() != dVar.b() || a() != dVar.a()) {
                return false;
            }
            String strD = d();
            String strD2 = dVar.d();
            return strD != null ? strD.equals(strD2) : strD2 == null;
        }

        public int hashCode() {
            long jC = c();
            long jB = b();
            int i11 = ((((int) (jC ^ (jC >>> 32))) + 59) * 59) + ((int) (jB ^ (jB >>> 32)));
            long jA = a();
            String strD = d();
            return (((i11 * 59) + ((int) ((jA >>> 32) ^ jA))) * 59) + (strD == null ? 43 : strD.hashCode());
        }

        public String toString() {
            return "ConnectionManager.RequestMeasurement(timestampMillis=" + c() + ", urlHostAndPathString=" + d() + ", responseSizeBytes=" + b() + ", connectionTimeMillis=" + a() + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a(String str, int i11, String str2, Object obj);

        void a(String str, Object obj, int i11);
    }

    public d4(com.applovin.impl.sdk.j jVar) {
        this.f18347a = jVar;
        this.f18348b = jVar.J();
        eg egVar = new eg(jVar);
        this.f18349c = egVar;
        egVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Throwable th2) {
        if (th2 instanceof UnknownHostException) {
            return -1009;
        }
        if (th2 instanceof SocketTimeoutException) {
            return -1001;
        }
        if (th2 instanceof IOException) {
            return -100;
        }
        return th2 instanceof JSONException ? -104 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str, Object obj) {
        if (obj == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (obj instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (obj instanceof es) {
                return fs.a(str, this.f18347a);
            }
            if (obj instanceof String) {
                return str;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f18348b.b("ConnectionManager", "Failed to process response of type '" + obj.getClass().getName() + "'");
            }
        }
        return obj;
    }

    private String a(String str) {
        return Utils.SEPARATOR + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i11, long j11) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f18348b.d("ConnectionManager", "Successful " + str + " returned " + i11 + " in " + (j11 / 1000.0f) + " s over " + e4.g(this.f18347a) + " to " + a(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i11, long j11, Throwable th2) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f18348b.a("ConnectionManager", "Failed " + str + " returned " + i11 + " in " + (j11 / 1000.0f) + " s over " + e4.g(this.f18347a) + " to " + a(str2), th2);
        }
    }

    public d a() {
        return this.f18350d;
    }

    /* JADX WARN: Code duplicated, block: B:85:0x024d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x024f A[Catch: all -> 0x0175, TryCatch #1 {all -> 0x0175, blocks: (B:45:0x0129, B:47:0x0139, B:51:0x0165, B:50:0x0161, B:54:0x017a, B:57:0x019f, B:59:0x01bb, B:65:0x01dd, B:81:0x0235, B:84:0x0244, B:86:0x024f, B:67:0x01e1, B:70:0x01e9, B:76:0x0201, B:78:0x0207, B:79:0x0221, B:61:0x01ca, B:87:0x0252, B:89:0x0258, B:90:0x026c, B:72:0x01fa), top: B:107:0x0129, inners: #2 }] */
    public void a(com.applovin.impl.sdk.network.a aVar, b bVar, e eVar) {
        byte[] bytes;
        byte[] bArrA;
        if (aVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        String strF = aVar.f();
        String strH = aVar.h();
        if (strF == null) {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (strH == null) {
            throw new IllegalArgumentException("No method specified");
        }
        if (eVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        if (!strF.toLowerCase().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            String str = "Requested postback submission to non HTTP endpoint " + strF + "; skipping...";
            com.applovin.impl.sdk.n.h("ConnectionManager", str);
            eVar.a(strF, AppLovinErrorCodes.INVALID_URL, str, null);
            return;
        }
        if (((Boolean) this.f18347a.a(sj.f22952f3)).booleanValue() && !strF.contains(AgentPageJsBridge.HTTPS)) {
            this.f18347a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18347a.J().k("ConnectionManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
            }
            strF = strF.replace("http://", AgentPageJsBridge.HTTPS);
        }
        HashMap map = new HashMap(2);
        boolean zM = aVar.m();
        vi.a aVarA = ((Boolean) this.f18347a.a(sj.f23002l5)).booleanValue() ? vi.a.a(((Integer) this.f18347a.a(sj.f22978i5)).intValue()) : aVar.e();
        long jA = yp.a(this.f18347a);
        if ((aVar.i() != null && !aVar.i().isEmpty()) || aVar.c() > 0) {
            Map mapI = aVar.i();
            Boolean bool = (Boolean) this.f18347a.a(sj.f23064t3);
            if (mapI != null && aVar.c() > 0) {
                mapI.put("current_retry_attempt", String.valueOf(aVar.c()));
            }
            if (zM) {
                String strA = yp.a(mapI, bool.booleanValue());
                String strB = vi.b(strA, jA, aVarA, this.f18347a.b0(), this.f18347a);
                if (StringUtils.isValidString(strA) && TextUtils.isEmpty(strB)) {
                    map.put("query", strA);
                }
                strF = StringUtils.appendQueryParameter(strF, TtmlNode.TAG_P, strB);
            } else {
                strF = StringUtils.appendQueryParameters(strF, mapI, bool.booleanValue());
            }
        }
        String str2 = strF;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            Boolean boolEndsWith = StringUtils.endsWith(StringUtils.getHostAndPath(str2), f18346e);
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVar = this.f18348b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Sending ");
                sb2.append(strH);
                sb2.append(" request to id=#");
                sb2.append(str2.hashCode());
                sb2.append(" \"");
                sb2.append(boolEndsWith.booleanValue() ? str2 : StringUtils.getHostAndPath(str2));
                sb2.append("\"...");
                nVar.d("ConnectionManager", sb2.toString());
            }
            eg.c.a aVarA2 = new eg.c.a().a(str2).b(strH).a(aVar.g()).a(aVar.l());
            if (aVar.b() != null) {
                if (zM) {
                    bytes = vi.a(aVar.b().toString(), jA, aVarA, this.f18347a.b0(), this.f18347a);
                    if (bytes == null) {
                        map.put(TtmlNode.TAG_BODY, aVar.b().toString());
                    }
                } else {
                    bytes = aVar.b().toString().getBytes("UTF-8");
                }
                byte[] bArr = bytes;
                if (!(zM && aVarA == vi.a.V2) && aVar.o() && bArr != null && bArr.length > ((Integer) this.f18347a.a(sj.E5)).intValue()) {
                    try {
                        bArrA = yp.a(bArr);
                    } catch (Throwable th2) {
                        if (com.applovin.impl.sdk.n.a()) {
                            this.f18348b.a("ConnectionManager", "Failed to gzip POST body for request " + a(str2), th2);
                        }
                        this.f18347a.E().a("ConnectionManager", "gzip", th2, CollectionUtils.hashMap("url", StringUtils.getHostAndPath(str2)));
                        bArrA = null;
                    }
                    aVarA2.a(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                    if (!aVar.o() && bArrA != null) {
                        aVarA2.a(HttpHeaders.CONTENT_ENCODING, "gzip");
                        aVarA2.a(bArrA);
                    } else if (bArr != null) {
                        aVarA2.a(bArr);
                    }
                } else {
                    bArrA = null;
                    aVarA2.a(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                    if (!aVar.o()) {
                        if (bArr != null) {
                            aVarA2.a(bArr);
                        }
                    } else if (bArr != null) {
                        aVarA2.a(bArr);
                    }
                }
                a(strH, str2, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, th);
                eVar.a(str2, 0, th.getMessage(), null);
                return;
            }
            if (!map.isEmpty()) {
                map.put(PermissionConstant.ACTION_REQUEST, StringUtils.getHostAndPath(str2));
                this.f18347a.A().trackEvent("ref", map);
            }
            try {
                this.f18349c.a(aVarA2.a(new c(str2, aVar, strH, aVar.d(), zM, bVar, eVar)).a(this.f18347a.j0().c()).a());
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
