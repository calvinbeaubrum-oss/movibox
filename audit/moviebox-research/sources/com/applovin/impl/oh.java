package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class oh {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final be.a f21533t = new be.a(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fo f21534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final be.a f21535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f21537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a8 f21539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f21540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final po f21541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final wo f21542i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f21543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final be.a f21544k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f21545l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f21546m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ph f21547n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f21548o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f21549p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f21550q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f21551r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f21552s;

    public oh(fo foVar, be.a aVar, long j11, long j12, int i11, a8 a8Var, boolean z11, po poVar, wo woVar, List list, be.a aVar2, boolean z12, int i12, ph phVar, long j13, long j14, long j15, boolean z13, boolean z14) {
        this.f21534a = foVar;
        this.f21535b = aVar;
        this.f21536c = j11;
        this.f21537d = j12;
        this.f21538e = i11;
        this.f21539f = a8Var;
        this.f21540g = z11;
        this.f21541h = poVar;
        this.f21542i = woVar;
        this.f21543j = list;
        this.f21544k = aVar2;
        this.f21545l = z12;
        this.f21546m = i12;
        this.f21547n = phVar;
        this.f21550q = j13;
        this.f21551r = j14;
        this.f21552s = j15;
        this.f21548o = z13;
        this.f21549p = z14;
    }

    public static be.a a() {
        return f21533t;
    }

    public static oh a(wo woVar) {
        fo foVar = fo.f19028a;
        be.a aVar = f21533t;
        return new oh(foVar, aVar, C.TIME_UNSET, 0L, 1, null, false, po.f21808d, woVar, eb.h(), aVar, false, 0, ph.f21775d, 0L, 0L, 0L, false, false);
    }

    public oh a(int i11) {
        return new oh(this.f21534a, this.f21535b, this.f21536c, this.f21537d, i11, this.f21539f, this.f21540g, this.f21541h, this.f21542i, this.f21543j, this.f21544k, this.f21545l, this.f21546m, this.f21547n, this.f21550q, this.f21551r, this.f21552s, this.f21548o, this.f21549p);
    }

    public oh a(a8 a8Var) {
        return new oh(this.f21534a, this.f21535b, this.f21536c, this.f21537d, this.f21538e, a8Var, this.f21540g, this.f21541h, this.f21542i, this.f21543j, this.f21544k, this.f21545l, this.f21546m, this.f21547n, this.f21550q, this.f21551r, this.f21552s, this.f21548o, this.f21549p);
    }

    public oh a(be.a aVar) {
        return new oh(this.f21534a, this.f21535b, this.f21536c, this.f21537d, this.f21538e, this.f21539f, this.f21540g, this.f21541h, this.f21542i, this.f21543j, aVar, this.f21545l, this.f21546m, this.f21547n, this.f21550q, this.f21551r, this.f21552s, this.f21548o, this.f21549p);
    }

    public oh a(be.a aVar, long j11, long j12, long j13, long j14, po poVar, wo woVar, List list) {
        return new oh(this.f21534a, aVar, j12, j13, this.f21538e, this.f21539f, this.f21540g, poVar, woVar, list, this.f21544k, this.f21545l, this.f21546m, this.f21547n, this.f21550q, j14, j11, this.f21548o, this.f21549p);
    }

    public oh a(fo foVar) {
        return new oh(foVar, this.f21535b, this.f21536c, this.f21537d, this.f21538e, this.f21539f, this.f21540g, this.f21541h, this.f21542i, this.f21543j, this.f21544k, this.f21545l, this.f21546m, this.f21547n, this.f21550q, this.f21551r, this.f21552s, this.f21548o, this.f21549p);
    }

    public oh a(ph phVar) {
        return new oh(this.f21534a, this.f21535b, this.f21536c, this.f21537d, this.f21538e, this.f21539f, this.f21540g, this.f21541h, this.f21542i, this.f21543j, this.f21544k, this.f21545l, this.f21546m, phVar, this.f21550q, this.f21551r, this.f21552s, this.f21548o, this.f21549p);
    }

    public oh a(boolean z11) {
        return new oh(this.f21534a, this.f21535b, this.f21536c, this.f21537d, this.f21538e, this.f21539f, z11, this.f21541h, this.f21542i, this.f21543j, this.f21544k, this.f21545l, this.f21546m, this.f21547n, this.f21550q, this.f21551r, this.f21552s, this.f21548o, this.f21549p);
    }

    public oh a(boolean z11, int i11) {
        return new oh(this.f21534a, this.f21535b, this.f21536c, this.f21537d, this.f21538e, this.f21539f, this.f21540g, this.f21541h, this.f21542i, this.f21543j, this.f21544k, z11, i11, this.f21547n, this.f21550q, this.f21551r, this.f21552s, this.f21548o, this.f21549p);
    }

    public oh b(boolean z11) {
        return new oh(this.f21534a, this.f21535b, this.f21536c, this.f21537d, this.f21538e, this.f21539f, this.f21540g, this.f21541h, this.f21542i, this.f21543j, this.f21544k, this.f21545l, this.f21546m, this.f21547n, this.f21550q, this.f21551r, this.f21552s, z11, this.f21549p);
    }

    public oh c(boolean z11) {
        return new oh(this.f21534a, this.f21535b, this.f21536c, this.f21537d, this.f21538e, this.f21539f, this.f21540g, this.f21541h, this.f21542i, this.f21543j, this.f21544k, this.f21545l, this.f21546m, this.f21547n, this.f21550q, this.f21551r, this.f21552s, this.f21548o, z11);
    }
}
