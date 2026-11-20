package androidx.media3.datasource;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import c4.g;
import c4.o;
import com.applovin.sdk.AppLovinEventTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements androidx.media3.datasource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<o> f9585b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.media3.datasource.a f9586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a f9587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a f9588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a f9589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a f9590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a f9591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a f9592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a f9593j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a f9594k;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements androidx.media3.datasource.a.InterfaceC0090a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.media3.datasource.a.InterfaceC0090a f9596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public o f9597c;

        public a(Context context) {
            this(context, new c.b());
        }

        public a(Context context, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            this.f9595a = context.getApplicationContext();
            this.f9596b = interfaceC0090a;
        }

        @Override // androidx.media3.datasource.a.InterfaceC0090a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createDataSource() {
            b bVar = new b(this.f9595a, this.f9596b.createDataSource());
            o oVar = this.f9597c;
            if (oVar != null) {
                bVar.c(oVar);
            }
            return bVar;
        }
    }

    public b(Context context, androidx.media3.datasource.a aVar) {
        this.f9584a = context.getApplicationContext();
        this.f9586c = (androidx.media3.datasource.a) z3.a.e(aVar);
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws IOException {
        z3.a.g(this.f9594k == null);
        String scheme = gVar.f14598a.getScheme();
        if (u0.L0(gVar.f14598a)) {
            String path = gVar.f14598a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f9594k = h();
            } else {
                this.f9594k = e();
            }
        } else if ("asset".equals(scheme)) {
            this.f9594k = e();
        } else if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme)) {
            this.f9594k = f();
        } else if ("rtmp".equals(scheme)) {
            this.f9594k = j();
        } else if ("udp".equals(scheme)) {
            this.f9594k = k();
        } else if ("data".equals(scheme)) {
            this.f9594k = g();
        } else if (com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || "android.resource".equals(scheme)) {
            this.f9594k = i();
        } else {
            this.f9594k = this.f9586c;
        }
        return this.f9594k.a(gVar);
    }

    @Override // androidx.media3.datasource.a
    public void c(o oVar) {
        z3.a.e(oVar);
        this.f9586c.c(oVar);
        this.f9585b.add(oVar);
        l(this.f9587d, oVar);
        l(this.f9588e, oVar);
        l(this.f9589f, oVar);
        l(this.f9590g, oVar);
        l(this.f9591h, oVar);
        l(this.f9592i, oVar);
        l(this.f9593j, oVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() throws IOException {
        androidx.media3.datasource.a aVar = this.f9594k;
        if (aVar != null) {
            try {
                aVar.close();
            } finally {
                this.f9594k = null;
            }
        }
    }

    public final void d(androidx.media3.datasource.a aVar) {
        for (int i11 = 0; i11 < this.f9585b.size(); i11++) {
            aVar.c(this.f9585b.get(i11));
        }
    }

    public final androidx.media3.datasource.a e() {
        if (this.f9588e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f9584a);
            this.f9588e = assetDataSource;
            d(assetDataSource);
        }
        return this.f9588e;
    }

    public final androidx.media3.datasource.a f() {
        if (this.f9589f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f9584a);
            this.f9589f = contentDataSource;
            d(contentDataSource);
        }
        return this.f9589f;
    }

    public final androidx.media3.datasource.a g() {
        if (this.f9592i == null) {
            c4.b bVar = new c4.b();
            this.f9592i = bVar;
            d(bVar);
        }
        return this.f9592i;
    }

    @Override // androidx.media3.datasource.a
    public Map<String, List<String>> getResponseHeaders() {
        androidx.media3.datasource.a aVar = this.f9594k;
        return aVar == null ? Collections.emptyMap() : aVar.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        androidx.media3.datasource.a aVar = this.f9594k;
        if (aVar == null) {
            return null;
        }
        return aVar.getUri();
    }

    public final androidx.media3.datasource.a h() {
        if (this.f9587d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f9587d = fileDataSource;
            d(fileDataSource);
        }
        return this.f9587d;
    }

    public final androidx.media3.datasource.a i() {
        if (this.f9593j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f9584a);
            this.f9593j = rawResourceDataSource;
            d(rawResourceDataSource);
        }
        return this.f9593j;
    }

    public final androidx.media3.datasource.a j() {
        if (this.f9590g == null) {
            try {
                androidx.media3.datasource.a aVar = (androidx.media3.datasource.a) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f9590g = aVar;
                d(aVar);
            } catch (ClassNotFoundException unused) {
                z3.o.h("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating RTMP extension", e11);
            }
            if (this.f9590g == null) {
                this.f9590g = this.f9586c;
            }
        }
        return this.f9590g;
    }

    public final androidx.media3.datasource.a k() {
        if (this.f9591h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f9591h = udpDataSource;
            d(udpDataSource);
        }
        return this.f9591h;
    }

    public final void l(@Nullable androidx.media3.datasource.a aVar, o oVar) {
        if (aVar != null) {
            aVar.c(oVar);
        }
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return ((androidx.media3.datasource.a) z3.a.e(this.f9594k)).read(bArr, i11, i12);
    }
}
