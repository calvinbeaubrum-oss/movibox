package com.applovin.impl;

import android.content.Context;
import android.net.Uri;
import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v5 implements i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f23748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f23749b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i5 f23750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i5 f23751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i5 f23752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private i5 f23753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private i5 f23754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i5 f23755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private i5 f23756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private i5 f23757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private i5 f23758k;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements i5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f23759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i5.a f23760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private xo f23761c;

        public a(Context context) {
            this(context, new d6.b());
        }

        public a(Context context, i5.a aVar) {
            this.f23759a = context.getApplicationContext();
            this.f23760b = aVar;
        }

        @Override // com.applovin.impl.i5.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public v5 a() {
            v5 v5Var = new v5(this.f23759a, this.f23760b.a());
            xo xoVar = this.f23761c;
            if (xoVar != null) {
                v5Var.a(xoVar);
            }
            return v5Var;
        }
    }

    public v5(Context context, i5 i5Var) {
        this.f23748a = context.getApplicationContext();
        this.f23750c = (i5) b1.a(i5Var);
    }

    private void a(i5 i5Var) {
        for (int i11 = 0; i11 < this.f23749b.size(); i11++) {
            i5Var.a((xo) this.f23749b.get(i11));
        }
    }

    private void a(i5 i5Var, xo xoVar) {
        if (i5Var != null) {
            i5Var.a(xoVar);
        }
    }

    private i5 g() {
        if (this.f23752e == null) {
            c1 c1Var = new c1(this.f23748a);
            this.f23752e = c1Var;
            a(c1Var);
        }
        return this.f23752e;
    }

    private i5 h() {
        if (this.f23753f == null) {
            s4 s4Var = new s4(this.f23748a);
            this.f23753f = s4Var;
            a(s4Var);
        }
        return this.f23753f;
    }

    private i5 i() {
        if (this.f23756i == null) {
            h5 h5Var = new h5();
            this.f23756i = h5Var;
            a(h5Var);
        }
        return this.f23756i;
    }

    private i5 j() {
        if (this.f23751d == null) {
            p8 p8Var = new p8();
            this.f23751d = p8Var;
            a(p8Var);
        }
        return this.f23751d;
    }

    private i5 k() {
        if (this.f23757j == null) {
            li liVar = new li(this.f23748a);
            this.f23757j = liVar;
            a(liVar);
        }
        return this.f23757j;
    }

    private i5 l() {
        if (this.f23754g == null) {
            try {
                i5 i5Var = (i5) Class.forName("com.applovin.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f23754g = i5Var;
                a(i5Var);
            } catch (ClassNotFoundException unused) {
                pc.d("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating RTMP extension", e11);
            }
            if (this.f23754g == null) {
                this.f23754g = this.f23750c;
            }
        }
        return this.f23754g;
    }

    private i5 m() {
        if (this.f23755h == null) {
            np npVar = new np();
            this.f23755h = npVar;
            a(npVar);
        }
        return this.f23755h;
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) {
        return ((i5) b1.a(this.f23758k)).a(bArr, i11, i12);
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) {
        b1.b(this.f23758k == null);
        String scheme = l5Var.f20336a.getScheme();
        if (xp.a(l5Var.f20336a)) {
            String path = l5Var.f20336a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f23758k = j();
            } else {
                this.f23758k = g();
            }
        } else if ("asset".equals(scheme)) {
            this.f23758k = g();
        } else if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme)) {
            this.f23758k = h();
        } else if ("rtmp".equals(scheme)) {
            this.f23758k = l();
        } else if ("udp".equals(scheme)) {
            this.f23758k = m();
        } else if ("data".equals(scheme)) {
            this.f23758k = i();
        } else if (RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || "android.resource".equals(scheme)) {
            this.f23758k = k();
        } else {
            this.f23758k = this.f23750c;
        }
        return this.f23758k.a(l5Var);
    }

    @Override // com.applovin.impl.i5
    public void a(xo xoVar) {
        b1.a(xoVar);
        this.f23750c.a(xoVar);
        this.f23749b.add(xoVar);
        a(this.f23751d, xoVar);
        a(this.f23752e, xoVar);
        a(this.f23753f, xoVar);
        a(this.f23754g, xoVar);
        a(this.f23755h, xoVar);
        a(this.f23756i, xoVar);
        a(this.f23757j, xoVar);
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        i5 i5Var = this.f23758k;
        if (i5Var == null) {
            return null;
        }
        return i5Var.c();
    }

    @Override // com.applovin.impl.i5
    public void close() {
        i5 i5Var = this.f23758k;
        if (i5Var != null) {
            try {
                i5Var.close();
            } finally {
                this.f23758k = null;
            }
        }
    }

    @Override // com.applovin.impl.i5
    public Map e() {
        i5 i5Var = this.f23758k;
        return i5Var == null ? Collections.emptyMap() : i5Var.e();
    }
}
