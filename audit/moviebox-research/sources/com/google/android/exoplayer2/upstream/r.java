package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f35478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<k0> f35479b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f35480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public k f35481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public k f35482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public k f35483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public k f35484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public k f35485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public k f35486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public k f35487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public k f35488k;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f35489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k.a f35490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public k0 f35491c;

        public a(Context context) {
            this(context, new s.b());
        }

        public a(Context context, k.a aVar) {
            this.f35489a = context.getApplicationContext();
            this.f35490b = aVar;
        }

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r createDataSource() {
            r rVar = new r(this.f35489a, this.f35490b.createDataSource());
            k0 k0Var = this.f35491c;
            if (k0Var != null) {
                rVar.e(k0Var);
            }
            return rVar;
        }
    }

    public r(Context context, k kVar) {
        this.f35478a = context.getApplicationContext();
        this.f35480c = (k) com.google.android.exoplayer2.util.a.e(kVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws IOException {
        com.google.android.exoplayer2.util.a.g(this.f35488k == null);
        String scheme = nVar.f35422a.getScheme();
        if (o0.w0(nVar.f35422a)) {
            String path = nVar.f35422a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f35488k = k();
            } else {
                this.f35488k = h();
            }
        } else if ("asset".equals(scheme)) {
            this.f35488k = h();
        } else if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme)) {
            this.f35488k = i();
        } else if ("rtmp".equals(scheme)) {
            this.f35488k = m();
        } else if ("udp".equals(scheme)) {
            this.f35488k = n();
        } else if ("data".equals(scheme)) {
            this.f35488k = j();
        } else if (com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || "android.resource".equals(scheme)) {
            this.f35488k = l();
        } else {
            this.f35488k = this.f35480c;
        }
        return this.f35488k.a(nVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() throws IOException {
        k kVar = this.f35488k;
        if (kVar != null) {
            try {
                kVar.close();
            } finally {
                this.f35488k = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f35480c.e(k0Var);
        this.f35479b.add(k0Var);
        o(this.f35481d, k0Var);
        o(this.f35482e, k0Var);
        o(this.f35483f, k0Var);
        o(this.f35484g, k0Var);
        o(this.f35485h, k0Var);
        o(this.f35486i, k0Var);
        o(this.f35487j, k0Var);
    }

    public final void f(k kVar) {
        for (int i11 = 0; i11 < this.f35479b.size(); i11++) {
            kVar.e(this.f35479b.get(i11));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map<String, List<String>> getResponseHeaders() {
        k kVar = this.f35488k;
        return kVar == null ? Collections.emptyMap() : kVar.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        k kVar = this.f35488k;
        if (kVar == null) {
            return null;
        }
        return kVar.getUri();
    }

    public final k h() {
        if (this.f35482e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f35478a);
            this.f35482e = assetDataSource;
            f(assetDataSource);
        }
        return this.f35482e;
    }

    public final k i() {
        if (this.f35483f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f35478a);
            this.f35483f = contentDataSource;
            f(contentDataSource);
        }
        return this.f35483f;
    }

    public final k j() {
        if (this.f35486i == null) {
            h hVar = new h();
            this.f35486i = hVar;
            f(hVar);
        }
        return this.f35486i;
    }

    public final k k() {
        if (this.f35481d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f35481d = fileDataSource;
            f(fileDataSource);
        }
        return this.f35481d;
    }

    public final k l() {
        if (this.f35487j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f35478a);
            this.f35487j = rawResourceDataSource;
            f(rawResourceDataSource);
        }
        return this.f35487j;
    }

    public final k m() {
        if (this.f35484g == null) {
            try {
                k kVar = (k) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f35484g = kVar;
                f(kVar);
            } catch (ClassNotFoundException unused) {
                com.google.android.exoplayer2.util.s.i("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating RTMP extension", e11);
            }
            if (this.f35484g == null) {
                this.f35484g = this.f35480c;
            }
        }
        return this.f35484g;
    }

    public final k n() {
        if (this.f35485h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f35485h = udpDataSource;
            f(udpDataSource);
        }
        return this.f35485h;
    }

    public final void o(@Nullable k kVar, k0 k0Var) {
        if (kVar != null) {
            kVar.e(k0Var);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return ((k) com.google.android.exoplayer2.util.a.e(this.f35488k)).read(bArr, i11, i12);
    }
}
