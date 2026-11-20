package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import sg.u;
import tg.a0;
import tg.b0;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f33789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.google.android.exoplayer2.upstream.k.a f33790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public i.a f33791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public z f33792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f33793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f33794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f33795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f33796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f33797i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f33798j;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tg.r f33799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Integer, com.google.common.base.q<i.a>> f33800b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<Integer> f33801c = new HashSet();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<Integer, i.a> f33802d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.k.a f33803e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public u f33804f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public z f33805g;

        public a(tg.r rVar) {
            this.f33799a = rVar;
        }

        @Nullable
        public i.a f(int i11) {
            i.a aVar = this.f33802d.get(Integer.valueOf(i11));
            if (aVar != null) {
                return aVar;
            }
            com.google.common.base.q<i.a> qVarL = l(i11);
            if (qVarL == null) {
                return null;
            }
            i.a aVar2 = qVarL.get2();
            u uVar = this.f33804f;
            if (uVar != null) {
                aVar2.b(uVar);
            }
            z zVar = this.f33805g;
            if (zVar != null) {
                aVar2.c(zVar);
            }
            this.f33802d.put(Integer.valueOf(i11), aVar2);
            return aVar2;
        }

        public final /* synthetic */ i.a k(com.google.android.exoplayer2.upstream.k.a aVar) {
            return new n.b(aVar, this.f33799a);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0078  */
        @Nullable
        public final com.google.common.base.q<i.a> l(int i11) {
            com.google.common.base.q<i.a> qVar;
            com.google.common.base.q<i.a> qVar2;
            if (this.f33800b.containsKey(Integer.valueOf(i11))) {
                return this.f33800b.get(Integer.valueOf(i11));
            }
            final com.google.android.exoplayer2.upstream.k.a aVar = (com.google.android.exoplayer2.upstream.k.a) com.google.android.exoplayer2.util.a.e(this.f33803e);
            com.google.common.base.q<i.a> qVar3 = null;
            try {
                if (i11 == 0) {
                    final Class clsAsSubclass = DashMediaSource.Factory.class.asSubclass(i.a.class);
                    qVar = new com.google.common.base.q() { // from class: nh.g
                        @Override // com.google.common.base.q
                        /* JADX INFO: renamed from: get */
                        public final Object get2() {
                            return com.google.android.exoplayer2.source.d.f(clsAsSubclass, aVar);
                        }
                    };
                } else {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 == 3) {
                                final Class clsAsSubclass2 = RtspMediaSource.Factory.class.asSubclass(i.a.class);
                                qVar2 = new com.google.common.base.q() { // from class: nh.j
                                    @Override // com.google.common.base.q
                                    /* JADX INFO: renamed from: get */
                                    public final Object get2() {
                                        return com.google.android.exoplayer2.source.d.e(clsAsSubclass2);
                                    }
                                };
                            } else if (i11 == 4) {
                                qVar2 = new com.google.common.base.q() { // from class: nh.k
                                    @Override // com.google.common.base.q
                                    /* JADX INFO: renamed from: get */
                                    public final Object get2() {
                                        return this.f71937a.k(aVar);
                                    }
                                };
                            }
                            qVar3 = qVar2;
                        } else {
                            final Class clsAsSubclass3 = HlsMediaSource.Factory.class.asSubclass(i.a.class);
                            qVar = new com.google.common.base.q() { // from class: nh.i
                                @Override // com.google.common.base.q
                                /* JADX INFO: renamed from: get */
                                public final Object get2() {
                                    return com.google.android.exoplayer2.source.d.f(clsAsSubclass3, aVar);
                                }
                            };
                        }
                        this.f33800b.put(Integer.valueOf(i11), qVar3);
                        if (qVar3 != null) {
                            this.f33801c.add(Integer.valueOf(i11));
                        }
                        return qVar3;
                    }
                    final Class clsAsSubclass4 = SsMediaSource.Factory.class.asSubclass(i.a.class);
                    qVar = new com.google.common.base.q() { // from class: nh.h
                        @Override // com.google.common.base.q
                        /* JADX INFO: renamed from: get */
                        public final Object get2() {
                            return com.google.android.exoplayer2.source.d.f(clsAsSubclass4, aVar);
                        }
                    };
                }
                qVar3 = qVar;
            } catch (ClassNotFoundException unused) {
            }
            this.f33800b.put(Integer.valueOf(i11), qVar3);
            if (qVar3 != null) {
                this.f33801c.add(Integer.valueOf(i11));
            }
            return qVar3;
        }

        public void m(com.google.android.exoplayer2.upstream.k.a aVar) {
            if (aVar != this.f33803e) {
                this.f33803e = aVar;
                this.f33800b.clear();
                this.f33802d.clear();
            }
        }

        public void n(u uVar) {
            this.f33804f = uVar;
            Iterator<i.a> it = this.f33802d.values().iterator();
            while (it.hasNext()) {
                it.next().b(uVar);
            }
        }

        public void o(z zVar) {
            this.f33805g = zVar;
            Iterator<i.a> it = this.f33802d.values().iterator();
            while (it.hasNext()) {
                it.next().c(zVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements tg.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m1 f33806a;

        public b(m1 m1Var) {
            this.f33806a = m1Var;
        }

        @Override // tg.l
        public boolean b(tg.m mVar) {
            return true;
        }

        @Override // tg.l
        public int c(tg.m mVar, a0 a0Var) throws IOException {
            return mVar.skip(Api.BaseClientBuilder.API_PRIORITY_OTHER) == -1 ? -1 : 0;
        }

        @Override // tg.l
        public void d(tg.n nVar) {
            e0 e0VarTrack = nVar.track(0, 3);
            nVar.g(new b0.b(C.TIME_UNSET));
            nVar.endTracks();
            e0VarTrack.e(this.f33806a.b().e0("text/x-unknown").I(this.f33806a.f33445m).E());
        }

        @Override // tg.l
        public void release() {
        }

        @Override // tg.l
        public void seek(long j11, long j12) {
        }
    }

    public d(Context context, tg.r rVar) {
        this(new com.google.android.exoplayer2.upstream.r.a(context), rVar);
    }

    public d(com.google.android.exoplayer2.upstream.k.a aVar) {
        this(aVar, new tg.i());
    }

    public d(com.google.android.exoplayer2.upstream.k.a aVar, tg.r rVar) {
        this.f33790b = aVar;
        a aVar2 = new a(rVar);
        this.f33789a = aVar2;
        aVar2.m(aVar);
        this.f33793e = C.TIME_UNSET;
        this.f33794f = C.TIME_UNSET;
        this.f33795g = C.TIME_UNSET;
        this.f33796h = -3.4028235E38f;
        this.f33797i = -3.4028235E38f;
    }

    public static /* synthetic */ i.a e(Class cls) {
        return j(cls);
    }

    public static /* synthetic */ i.a f(Class cls, com.google.android.exoplayer2.upstream.k.a aVar) {
        return k(cls, aVar);
    }

    public static /* synthetic */ tg.l[] g(m1 m1Var) {
        tg.l[] lVarArr = new tg.l[1];
        vh.k kVar = vh.k.f78865a;
        lVarArr[0] = kVar.a(m1Var) ? new vh.l(kVar.b(m1Var), m1Var) : new b(m1Var);
        return lVarArr;
    }

    public static i h(u1 u1Var, i iVar) {
        u1.d dVar = u1Var.f34780g;
        long j11 = dVar.f34797a;
        if (j11 == 0 && dVar.f34798b == Long.MIN_VALUE && !dVar.f34800d) {
            return iVar;
        }
        long jC0 = o0.C0(j11);
        long jC1 = o0.C0(u1Var.f34780g.f34798b);
        u1.d dVar2 = u1Var.f34780g;
        return new ClippingMediaSource(iVar, jC0, jC1, !dVar2.f34801f, dVar2.f34799c, dVar2.f34800d);
    }

    public static i.a j(Class<? extends i.a> cls) {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static i.a k(Class<? extends i.a> cls, com.google.android.exoplayer2.upstream.k.a aVar) {
        try {
            return cls.getConstructor(com.google.android.exoplayer2.upstream.k.a.class).newInstance(aVar);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    @Override // com.google.android.exoplayer2.source.i.a
    public i a(u1 u1Var) {
        com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
        String scheme = u1Var.f34776b.f34839a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((i.a) com.google.android.exoplayer2.util.a.e(this.f33791c)).a(u1Var);
        }
        u1.h hVar = u1Var.f34776b;
        int iQ0 = o0.q0(hVar.f34839a, hVar.f34840b);
        i.a aVarF = this.f33789a.f(iQ0);
        com.google.android.exoplayer2.util.a.j(aVarF, "No suitable media source factory found for content type: " + iQ0);
        u1.g.a aVarB = u1Var.f34778d.b();
        if (u1Var.f34778d.f34829a == C.TIME_UNSET) {
            aVarB.k(this.f33793e);
        }
        if (u1Var.f34778d.f34832d == -3.4028235E38f) {
            aVarB.j(this.f33796h);
        }
        if (u1Var.f34778d.f34833f == -3.4028235E38f) {
            aVarB.h(this.f33797i);
        }
        if (u1Var.f34778d.f34830b == C.TIME_UNSET) {
            aVarB.i(this.f33794f);
        }
        if (u1Var.f34778d.f34831c == C.TIME_UNSET) {
            aVarB.g(this.f33795g);
        }
        u1.g gVarF = aVarB.f();
        if (!gVarF.equals(u1Var.f34778d)) {
            u1Var = u1Var.b().c(gVarF).a();
        }
        i iVarA = aVarF.a(u1Var);
        ImmutableList<u1.l> immutableList = ((u1.h) o0.j(u1Var.f34776b)).f34844f;
        if (!immutableList.isEmpty()) {
            i[] iVarArr = new i[immutableList.size() + 1];
            iVarArr[0] = iVarA;
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                if (this.f33798j) {
                    final m1 m1VarE = new m1.b().e0(immutableList.get(i11).f34856b).V(immutableList.get(i11).f34857c).g0(immutableList.get(i11).f34858d).c0(immutableList.get(i11).f34859e).U(immutableList.get(i11).f34860f).S(immutableList.get(i11).f34861g).E();
                    n.b bVar = new n.b(this.f33790b, new tg.r() { // from class: nh.f
                        @Override // tg.r
                        public /* synthetic */ tg.l[] b(Uri uri, Map map) {
                            return tg.q.a(this, uri, map);
                        }

                        @Override // tg.r
                        public final tg.l[] createExtractors() {
                            return com.google.android.exoplayer2.source.d.g(m1VarE);
                        }
                    });
                    z zVar = this.f33792d;
                    if (zVar != null) {
                        bVar.c(zVar);
                    }
                    iVarArr[i11 + 1] = bVar.a(u1.e(immutableList.get(i11).f34855a.toString()));
                } else {
                    s.b bVar2 = new s.b(this.f33790b);
                    z zVar2 = this.f33792d;
                    if (zVar2 != null) {
                        bVar2.b(zVar2);
                    }
                    iVarArr[i11 + 1] = bVar2.a(immutableList.get(i11), C.TIME_UNSET);
                }
            }
            iVarA = new MergingMediaSource(iVarArr);
        }
        return i(u1Var, h(u1Var, iVarA));
    }

    public final i i(u1 u1Var, i iVar) {
        com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
        u1Var.f34776b.getClass();
        return iVar;
    }

    @Override // com.google.android.exoplayer2.source.i.a
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public d b(u uVar) {
        this.f33789a.n((u) com.google.android.exoplayer2.util.a.f(uVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // com.google.android.exoplayer2.source.i.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public d c(z zVar) {
        this.f33792d = (z) com.google.android.exoplayer2.util.a.f(zVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f33789a.o(zVar);
        return this;
    }
}
