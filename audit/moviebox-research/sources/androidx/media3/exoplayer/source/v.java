package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.common.m0;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import p4.g0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v extends androidx.media3.exoplayer.source.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.g f11358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.media3.datasource.a.InterfaceC0090a f11359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final y f11360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f11361k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.m f11362l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f11363m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m0 f11364n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b0 f11365o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public c4.o f11366p;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.datasource.a.InterfaceC0090a f11367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.media3.exoplayer.upstream.m f11368b = new androidx.media3.exoplayer.upstream.k();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11369c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f11370d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public String f11371e;

        public b(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            this.f11367a = (androidx.media3.datasource.a.InterfaceC0090a) z3.a.e(interfaceC0090a);
        }

        public v a(b0.k kVar, long j11) {
            return new v(this.f11371e, kVar, this.f11367a, j11, this.f11368b, this.f11369c, this.f11370d);
        }

        public b b(@Nullable androidx.media3.exoplayer.upstream.m mVar) {
            if (mVar == null) {
                mVar = new androidx.media3.exoplayer.upstream.k();
            }
            this.f11368b = mVar;
            return this;
        }
    }

    public v(@Nullable String str, b0.k kVar, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, long j11, androidx.media3.exoplayer.upstream.m mVar, boolean z11, @Nullable Object obj) {
        this.f11359i = interfaceC0090a;
        this.f11361k = j11;
        this.f11362l = mVar;
        this.f11363m = z11;
        b0 b0VarA = new b0.c().i(Uri.EMPTY).d(kVar.f9075a.toString()).g(ImmutableList.of(kVar)).h(obj).a();
        this.f11365o = b0VarA;
        y.b bVarZ = new y.b().k0((String) com.google.common.base.h.a(kVar.f9076b, "text/x-unknown")).b0(kVar.f9077c).m0(kVar.f9078d).i0(kVar.f9079e).Z(kVar.f9080f);
        String str2 = kVar.f9081g;
        this.f11360j = bVarZ.X(str2 == null ? str : str2).I();
        this.f11358h = new c4.g.b().i(kVar.f9075a).b(1).a();
        this.f11364n = new g0(j11, true, false, false, null, b0VarA);
    }

    @Override // androidx.media3.exoplayer.source.a
    public void B() {
    }

    @Override // androidx.media3.exoplayer.source.l
    public b0 a() {
        return this.f11365o;
    }

    @Override // androidx.media3.exoplayer.source.l
    public k h(l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        return new u(this.f11358h, this.f11359i, this.f11366p, this.f11360j, this.f11361k, this.f11362l, u(bVar), this.f11363m);
    }

    @Override // androidx.media3.exoplayer.source.l
    public void l(k kVar) {
        ((u) kVar).i();
    }

    @Override // androidx.media3.exoplayer.source.l
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // androidx.media3.exoplayer.source.a
    public void z(@Nullable c4.o oVar) {
        this.f11366p = oVar;
        A(this.f11364n);
    }
}
