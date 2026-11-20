package androidx.media3.exoplayer.source;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import u4.l0;
import u4.m0;
import u4.r0;
import u4.y;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.media3.datasource.a.InterfaceC0090a f11145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o5.s.a f11146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public l.a f11147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public e f11148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public androidx.media3.exoplayer.upstream.m f11149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f11153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f11154k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11155l;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f11156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Integer, com.google.common.base.q<l.a>> f11157b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<Integer> f11158c = new HashSet();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<Integer, l.a> f11159d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.media3.datasource.a.InterfaceC0090a f11160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f11161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public o5.s.a f11162g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public androidx.media3.exoplayer.upstream.f.a f11163h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public i4.u f11164i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public androidx.media3.exoplayer.upstream.m f11165j;

        public a(y yVar, o5.s.a aVar) {
            this.f11156a = yVar;
            this.f11162g = aVar;
        }

        @Nullable
        public l.a f(int i11) {
            l.a aVar = this.f11159d.get(Integer.valueOf(i11));
            if (aVar != null) {
                return aVar;
            }
            com.google.common.base.q<l.a> qVarL = l(i11);
            if (qVarL == null) {
                return null;
            }
            l.a aVar2 = qVarL.get2();
            androidx.media3.exoplayer.upstream.f.a aVar3 = this.f11163h;
            if (aVar3 != null) {
                aVar2.f(aVar3);
            }
            i4.u uVar = this.f11164i;
            if (uVar != null) {
                aVar2.d(uVar);
            }
            androidx.media3.exoplayer.upstream.m mVar = this.f11165j;
            if (mVar != null) {
                aVar2.e(mVar);
            }
            aVar2.a(this.f11162g);
            aVar2.b(this.f11161f);
            this.f11159d.put(Integer.valueOf(i11), aVar2);
            return aVar2;
        }

        public final /* synthetic */ l.a k(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            return new q.b(interfaceC0090a, this.f11156a);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0080  */
        @Nullable
        public final com.google.common.base.q<l.a> l(int i11) {
            com.google.common.base.q<l.a> qVar;
            com.google.common.base.q<l.a> qVar2;
            if (this.f11157b.containsKey(Integer.valueOf(i11))) {
                return this.f11157b.get(Integer.valueOf(i11));
            }
            final androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a = (androidx.media3.datasource.a.InterfaceC0090a) z3.a.e(this.f11160e);
            com.google.common.base.q<l.a> qVar3 = null;
            try {
                if (i11 == 0) {
                    final Class clsAsSubclass = DashMediaSource.Factory.class.asSubclass(l.a.class);
                    qVar = new com.google.common.base.q() { // from class: p4.g
                        @Override // com.google.common.base.q
                        /* JADX INFO: renamed from: get */
                        public final Object get2() {
                            return androidx.media3.exoplayer.source.d.i(clsAsSubclass, interfaceC0090a);
                        }
                    };
                } else {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 == 3) {
                                final Class<? extends U> clsAsSubclass2 = Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(l.a.class);
                                qVar2 = new com.google.common.base.q() { // from class: p4.j
                                    @Override // com.google.common.base.q
                                    /* JADX INFO: renamed from: get */
                                    public final Object get2() {
                                        return androidx.media3.exoplayer.source.d.h(clsAsSubclass2);
                                    }
                                };
                            } else if (i11 == 4) {
                                qVar2 = new com.google.common.base.q() { // from class: p4.k
                                    @Override // com.google.common.base.q
                                    /* JADX INFO: renamed from: get */
                                    public final Object get2() {
                                        return this.f73569a.k(interfaceC0090a);
                                    }
                                };
                            }
                            qVar3 = qVar2;
                        } else {
                            final Class clsAsSubclass3 = HlsMediaSource.Factory.class.asSubclass(l.a.class);
                            qVar = new com.google.common.base.q() { // from class: p4.i
                                @Override // com.google.common.base.q
                                /* JADX INFO: renamed from: get */
                                public final Object get2() {
                                    return androidx.media3.exoplayer.source.d.i(clsAsSubclass3, interfaceC0090a);
                                }
                            };
                        }
                        this.f11157b.put(Integer.valueOf(i11), qVar3);
                        if (qVar3 != null) {
                            this.f11158c.add(Integer.valueOf(i11));
                        }
                        return qVar3;
                    }
                    final Class<? extends U> clsAsSubclass4 = Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(l.a.class);
                    qVar = new com.google.common.base.q() { // from class: p4.h
                        @Override // com.google.common.base.q
                        /* JADX INFO: renamed from: get */
                        public final Object get2() {
                            return androidx.media3.exoplayer.source.d.i(clsAsSubclass4, interfaceC0090a);
                        }
                    };
                }
                qVar3 = qVar;
            } catch (ClassNotFoundException unused) {
            }
            this.f11157b.put(Integer.valueOf(i11), qVar3);
            if (qVar3 != null) {
                this.f11158c.add(Integer.valueOf(i11));
            }
            return qVar3;
        }

        public void m(androidx.media3.exoplayer.upstream.f.a aVar) {
            this.f11163h = aVar;
            Iterator<l.a> it = this.f11159d.values().iterator();
            while (it.hasNext()) {
                it.next().f(aVar);
            }
        }

        public void n(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            if (interfaceC0090a != this.f11160e) {
                this.f11160e = interfaceC0090a;
                this.f11157b.clear();
                this.f11159d.clear();
            }
        }

        public void o(i4.u uVar) {
            this.f11164i = uVar;
            Iterator<l.a> it = this.f11159d.values().iterator();
            while (it.hasNext()) {
                it.next().d(uVar);
            }
        }

        public void p(int i11) {
            y yVar = this.f11156a;
            if (yVar instanceof u4.m) {
                ((u4.m) yVar).j(i11);
            }
        }

        public void q(androidx.media3.exoplayer.upstream.m mVar) {
            this.f11165j = mVar;
            Iterator<l.a> it = this.f11159d.values().iterator();
            while (it.hasNext()) {
                it.next().e(mVar);
            }
        }

        public void r(boolean z11) {
            this.f11161f = z11;
            this.f11156a.c(z11);
            Iterator<l.a> it = this.f11159d.values().iterator();
            while (it.hasNext()) {
                it.next().b(z11);
            }
        }

        public void s(o5.s.a aVar) {
            this.f11162g = aVar;
            this.f11156a.a(aVar);
            Iterator<l.a> it = this.f11159d.values().iterator();
            while (it.hasNext()) {
                it.next().a(aVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements u4.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.y f11166a;

        public b(androidx.media3.common.y yVar) {
            this.f11166a = yVar;
        }

        @Override // u4.s
        public boolean b(u4.t tVar) {
            return true;
        }

        @Override // u4.s
        public /* synthetic */ u4.s c() {
            return u4.r.a(this);
        }

        @Override // u4.s
        public int d(u4.t tVar, l0 l0Var) throws IOException {
            return tVar.skip(Api.BaseClientBuilder.API_PRIORITY_OTHER) == -1 ? -1 : 0;
        }

        @Override // u4.s
        public void f(u4.u uVar) {
            r0 r0VarTrack = uVar.track(0, 3);
            uVar.f(new m0.b(C.TIME_UNSET));
            uVar.endTracks();
            r0VarTrack.b(this.f11166a.b().k0("text/x-unknown").M(this.f11166a.f9501m).I());
        }

        @Override // u4.s
        public void release() {
        }

        @Override // u4.s
        public void seek(long j11, long j12) {
        }
    }

    public d(Context context) {
        this(new androidx.media3.datasource.b.a(context));
    }

    public d(Context context, y yVar) {
        this(new androidx.media3.datasource.b.a(context), yVar);
    }

    public d(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
        this(interfaceC0090a, new u4.m());
    }

    public d(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, y yVar) {
        this.f11145b = interfaceC0090a;
        o5.h hVar = new o5.h();
        this.f11146c = hVar;
        a aVar = new a(yVar, hVar);
        this.f11144a = aVar;
        aVar.n(interfaceC0090a);
        this.f11150g = C.TIME_UNSET;
        this.f11151h = C.TIME_UNSET;
        this.f11152i = C.TIME_UNSET;
        this.f11153j = -3.4028235E38f;
        this.f11154k = -3.4028235E38f;
    }

    public static /* synthetic */ l.a h(Class cls) {
        return n(cls);
    }

    public static /* synthetic */ l.a i(Class cls, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
        return o(cls, interfaceC0090a);
    }

    public static l l(b0 b0Var, l lVar) {
        b0.d dVar = b0Var.f8955f;
        if (dVar.f8981b == 0 && dVar.f8983d == Long.MIN_VALUE && !dVar.f8985f) {
            return lVar;
        }
        b0.d dVar2 = b0Var.f8955f;
        return new ClippingMediaSource(lVar, dVar2.f8981b, dVar2.f8983d, !dVar2.f8986g, dVar2.f8984e, dVar2.f8985f);
    }

    public static l.a n(Class<? extends l.a> cls) {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static l.a o(Class<? extends l.a> cls, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
        try {
            return cls.getConstructor(androidx.media3.datasource.a.InterfaceC0090a.class).newInstance(interfaceC0090a);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.source.l.a
    public l c(b0 b0Var) {
        z3.a.e(b0Var.f8951b);
        String scheme = b0Var.f8951b.f9047a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((l.a) z3.a.e(this.f11147d)).c(b0Var);
        }
        if (Objects.equals(b0Var.f8951b.f9048b, "application/x-image-uri")) {
            return new g.b(u0.S0(b0Var.f8951b.f9055i), (e) z3.a.e(this.f11148e)).c(b0Var);
        }
        b0.h hVar = b0Var.f8951b;
        int iC0 = u0.C0(hVar.f9047a, hVar.f9048b);
        if (b0Var.f8951b.f9055i != C.TIME_UNSET) {
            this.f11144a.p(1);
        }
        l.a aVarF = this.f11144a.f(iC0);
        z3.a.j(aVarF, "No suitable media source factory found for content type: " + iC0);
        b0.g.a aVarA = b0Var.f8953d.a();
        if (b0Var.f8953d.f9028a == C.TIME_UNSET) {
            aVarA.k(this.f11150g);
        }
        if (b0Var.f8953d.f9031d == -3.4028235E38f) {
            aVarA.j(this.f11153j);
        }
        if (b0Var.f8953d.f9032e == -3.4028235E38f) {
            aVarA.h(this.f11154k);
        }
        if (b0Var.f8953d.f9029b == C.TIME_UNSET) {
            aVarA.i(this.f11151h);
        }
        if (b0Var.f8953d.f9030c == C.TIME_UNSET) {
            aVarA.g(this.f11152i);
        }
        b0.g gVarF = aVarA.f();
        if (!gVarF.equals(b0Var.f8953d)) {
            b0Var = b0Var.a().c(gVarF).a();
        }
        l lVarC = aVarF.c(b0Var);
        ImmutableList<b0.k> immutableList = ((b0.h) u0.i(b0Var.f8951b)).f9052f;
        if (!immutableList.isEmpty()) {
            l[] lVarArr = new l[immutableList.size() + 1];
            lVarArr[0] = lVarC;
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                if (this.f11155l) {
                    final androidx.media3.common.y yVarI = new androidx.media3.common.y.b().k0(immutableList.get(i11).f9076b).b0(immutableList.get(i11).f9077c).m0(immutableList.get(i11).f9078d).i0(immutableList.get(i11).f9079e).Z(immutableList.get(i11).f9080f).X(immutableList.get(i11).f9081g).I();
                    q.b bVar = new q.b(this.f11145b, new y() { // from class: p4.f
                        @Override // u4.y
                        public /* synthetic */ u4.y a(o5.s.a aVar) {
                            return u4.x.c(this, aVar);
                        }

                        @Override // u4.y
                        public /* synthetic */ u4.s[] b(Uri uri, Map map) {
                            return u4.x.a(this, uri, map);
                        }

                        @Override // u4.y
                        public /* synthetic */ u4.y c(boolean z11) {
                            return u4.x.b(this, z11);
                        }

                        @Override // u4.y
                        public final u4.s[] createExtractors() {
                            return this.f73538b.k(yVarI);
                        }
                    });
                    androidx.media3.exoplayer.upstream.m mVar = this.f11149f;
                    if (mVar != null) {
                        bVar.e(mVar);
                    }
                    lVarArr[i11 + 1] = bVar.c(b0.b(immutableList.get(i11).f9075a.toString()));
                } else {
                    v.b bVar2 = new v.b(this.f11145b);
                    androidx.media3.exoplayer.upstream.m mVar2 = this.f11149f;
                    if (mVar2 != null) {
                        bVar2.b(mVar2);
                    }
                    lVarArr[i11 + 1] = bVar2.a(immutableList.get(i11), C.TIME_UNSET);
                }
            }
            lVarC = new MergingMediaSource(lVarArr);
        }
        return m(b0Var, l(b0Var, lVarC));
    }

    @Override // androidx.media3.exoplayer.source.l.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public d b(boolean z11) {
        this.f11155l = z11;
        this.f11144a.r(z11);
        return this;
    }

    public final /* synthetic */ u4.s[] k(androidx.media3.common.y yVar) {
        u4.s[] sVarArr = new u4.s[1];
        sVarArr[0] = this.f11146c.a(yVar) ? new o5.n(this.f11146c.c(yVar), yVar) : new b(yVar);
        return sVarArr;
    }

    public final l m(b0 b0Var, l lVar) {
        z3.a.e(b0Var.f8951b);
        b0Var.f8951b.getClass();
        return lVar;
    }

    @Override // androidx.media3.exoplayer.source.l.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public d f(androidx.media3.exoplayer.upstream.f.a aVar) {
        this.f11144a.m((androidx.media3.exoplayer.upstream.f.a) z3.a.e(aVar));
        return this;
    }

    public d q(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
        this.f11145b = interfaceC0090a;
        this.f11144a.n(interfaceC0090a);
        return this;
    }

    @Override // androidx.media3.exoplayer.source.l.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public d d(i4.u uVar) {
        this.f11144a.o((i4.u) z3.a.f(uVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // androidx.media3.exoplayer.source.l.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public d e(androidx.media3.exoplayer.upstream.m mVar) {
        this.f11149f = (androidx.media3.exoplayer.upstream.m) z3.a.f(mVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f11144a.q(mVar);
        return this;
    }

    @Override // androidx.media3.exoplayer.source.l.a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public d a(o5.s.a aVar) {
        this.f11146c = (o5.s.a) z3.a.e(aVar);
        this.f11144a.s(aVar);
        return this;
    }
}
