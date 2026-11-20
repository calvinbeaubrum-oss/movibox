package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.z;
import com.google.common.collect.ImmutableList;
import nh.f0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends com.google.android.exoplayer2.source.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.n f34646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k.a f34647j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m1 f34648k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f34649l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z f34650m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f34651n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j3 f34652o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final u1 f34653p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public k0 f34654q;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.k.a f34655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public z f34656b = new v();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f34657c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f34658d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public String f34659e;

        public b(com.google.android.exoplayer2.upstream.k.a aVar) {
            this.f34655a = (com.google.android.exoplayer2.upstream.k.a) com.google.android.exoplayer2.util.a.e(aVar);
        }

        public s a(u1.l lVar, long j11) {
            return new s(this.f34659e, lVar, this.f34655a, j11, this.f34656b, this.f34657c, this.f34658d);
        }

        public b b(@Nullable z zVar) {
            if (zVar == null) {
                zVar = new v();
            }
            this.f34656b = zVar;
            return this;
        }
    }

    public s(@Nullable String str, u1.l lVar, com.google.android.exoplayer2.upstream.k.a aVar, long j11, z zVar, boolean z11, @Nullable Object obj) {
        this.f34647j = aVar;
        this.f34649l = j11;
        this.f34650m = zVar;
        this.f34651n = z11;
        u1 u1VarA = new u1.c().i(Uri.EMPTY).d(lVar.f34855a.toString()).g(ImmutableList.of(lVar)).h(obj).a();
        this.f34653p = u1VarA;
        m1.b bVarU = new m1.b().e0((String) com.google.common.base.h.a(lVar.f34856b, "text/x-unknown")).V(lVar.f34857c).g0(lVar.f34858d).c0(lVar.f34859e).U(lVar.f34860f);
        String str2 = lVar.f34861g;
        this.f34648k = bVarU.S(str2 == null ? str : str2).E();
        this.f34646i = new com.google.android.exoplayer2.upstream.n.b().i(lVar.f34855a).b(1).a();
        this.f34652o = new f0(j11, true, false, false, null, u1VarA);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable k0 k0Var) {
        this.f34654q = k0Var;
        C(this.f34652o);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
    }

    @Override // com.google.android.exoplayer2.source.i
    public u1 a() {
        return this.f34653p;
    }

    @Override // com.google.android.exoplayer2.source.i
    public h e(i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        return new r(this.f34646i, this.f34647j, this.f34654q, this.f34648k, this.f34649l, this.f34650m, v(bVar), this.f34651n);
    }

    @Override // com.google.android.exoplayer2.source.i
    public void k(h hVar) {
        ((r) hVar).h();
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() {
    }
}
