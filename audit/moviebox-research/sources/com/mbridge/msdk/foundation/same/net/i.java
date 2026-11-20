package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i<T> implements Comparable<i<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f44669c = "i";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ConcurrentHashMap<String, String> f44670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected e<T> f44671b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f44672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f44673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f44674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f44675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j f44676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l f44677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer f44678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f44679k;

    public i(int i11, String str) {
        this.f44670a = new ConcurrentHashMap<>();
        this.f44671b = null;
        this.f44675g = false;
        this.f44679k = 2;
        this.f44673e = str;
        this.f44672d = i11;
        this.f44674f = false;
        this.f44677i = new b();
    }

    public i(int i11, String str, e<T> eVar) {
        this.f44670a = new ConcurrentHashMap<>();
        this.f44675g = false;
        this.f44679k = 2;
        this.f44673e = str;
        this.f44672d = i11;
        this.f44671b = eVar;
        this.f44674f = false;
        this.f44677i = new b();
    }

    public i(int i11, String str, e<T> eVar, boolean z11) {
        this.f44670a = new ConcurrentHashMap<>();
        this.f44675g = false;
        this.f44679k = 2;
        this.f44673e = str;
        this.f44672d = i11;
        this.f44671b = eVar;
        this.f44674f = z11;
        this.f44677i = new b();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0064 A[Catch: IOException -> 0x0060, TRY_LEAVE, TryCatch #4 {IOException -> 0x0060, blocks: (B:32:0x005c, B:36:0x0064), top: B:47:0x005c }] */
    private byte[] a(com.mbridge.msdk.foundation.same.net.f.b bVar) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            InputStream inputStreamA = bVar.a();
            try {
                if (com.mbridge.msdk.foundation.same.net.g.b.b(bVar.b()) && !(inputStreamA instanceof GZIPInputStream)) {
                    inputStreamA = new GZIPInputStream(inputStreamA);
                }
                if (inputStreamA == null) {
                    throw new com.mbridge.msdk.foundation.same.net.b.a(7, null);
                }
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i11 = inputStreamA.read(bArr);
                        if (i11 == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i11);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        inputStreamA.close();
                        byteArrayOutputStream2.close();
                    } catch (IOException e11) {
                        ad.b(f44669c, e11.getMessage());
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    inputStream = inputStreamA;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } catch (IOException e12) {
                            ad.b(f44669c, e12.getMessage());
                            throw th;
                        }
                    } else if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStreamA;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(j jVar) {
        this.f44676h = jVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(l lVar) {
        this.f44677i = lVar;
        return this;
    }

    public abstract k<T> a(com.mbridge.msdk.foundation.same.net.f.c cVar);

    public final void a() {
        this.f44675g = true;
    }

    public final void a(int i11) {
        if (i11 < 1 || i11 > 4) {
            return;
        }
        this.f44679k = i11;
    }

    public final void a(long j11, long j12) {
        e<T> eVar = this.f44671b;
        if (eVar != null) {
            eVar.onProgressChange(j11, j12);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        e<T> eVar = this.f44671b;
        if (eVar != null) {
            eVar.onError(aVar);
        }
    }

    public final void a(e<T> eVar) {
        this.f44671b = eVar;
    }

    public final void a(k<T> kVar) {
        e<T> eVar = this.f44671b;
        if (eVar != null) {
            eVar.onSuccess(kVar);
        }
    }

    public final void a(String str) {
        j jVar = this.f44676h;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    public final void a(String str, String str2) {
        this.f44670a.remove(str);
        this.f44670a.put(str, str2);
    }

    public byte[] a(com.mbridge.msdk.foundation.same.net.f.b bVar, c cVar) throws com.mbridge.msdk.foundation.same.net.b.a, IOException {
        return bVar.a() != null ? a(bVar) : new byte[0];
    }

    public int b() {
        return this.f44679k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> b(int i11) {
        this.f44678j = Integer.valueOf(i11);
        return this;
    }

    public final void c() {
        e<T> eVar = this.f44671b;
        if (eVar != null) {
            eVar.onCancel();
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        int iB = b();
        int iB2 = iVar.b();
        return iB == iB2 ? this.f44678j.intValue() - iVar.f44678j.intValue() : iB2 - iB;
    }

    public final void d() {
        e<T> eVar = this.f44671b;
        if (eVar != null) {
            eVar.onFinish();
        }
    }

    public final void e() {
        e<T> eVar = this.f44671b;
        if (eVar != null) {
            eVar.onNetworking();
        }
    }

    public final void f() {
        e<T> eVar = this.f44671b;
        if (eVar != null) {
            eVar.onPreExecute();
        }
    }

    public final void g() {
        e<T> eVar = this.f44671b;
        if (eVar != null) {
            eVar.onRetry();
        }
    }

    public byte[] h() {
        return null;
    }

    public final int i() {
        try {
            return this.f44677i.f();
        } catch (Exception unused) {
            return 0;
        }
    }

    public final int j() {
        try {
            return this.f44677i.c();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final Map<String, String> k() {
        return this.f44670a;
    }

    public final int l() {
        return this.f44672d;
    }

    public final int m() {
        try {
            return this.f44677i.d();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final l n() {
        return this.f44677i;
    }

    public final int o() {
        try {
            return this.f44677i.a();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int p() {
        try {
            return this.f44677i.e();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final boolean q() {
        return this.f44675g;
    }

    public final void r() {
        a("Charset", "UTF-8");
        if (this.f44674f) {
            a("Connection", "keep-alive");
        } else {
            a("Connection", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        }
    }

    public final String s() {
        return this.f44673e;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f44675g ? "[X] " : "[ ] ");
        sb2.append(this.f44673e);
        sb2.append(" ");
        sb2.append(b());
        sb2.append(" ");
        sb2.append(this.f44678j);
        return sb2.toString();
    }
}
