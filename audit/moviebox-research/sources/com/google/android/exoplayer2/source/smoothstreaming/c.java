package com.google.android.exoplayer2.source.smoothstreaming;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import fi.s;
import java.io.IOException;
import java.util.ArrayList;
import nh.d;
import nh.d0;
import nh.i0;
import ph.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements h, q.a<i<b>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.a f34696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final k0 f34697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f34698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f34699d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.b.a f34700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z f34701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j.a f34702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f34703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final nh.k0 f34704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f34705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public h.a f34706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f34707m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i<b>[] f34708n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public q f34709o;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, @Nullable k0 k0Var, d dVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.drm.b.a aVar3, z zVar, j.a aVar4, a0 a0Var, com.google.android.exoplayer2.upstream.b bVar) {
        this.f34707m = aVar;
        this.f34696a = aVar2;
        this.f34697b = k0Var;
        this.f34698c = a0Var;
        this.f34699d = cVar;
        this.f34700f = aVar3;
        this.f34701g = zVar;
        this.f34702h = aVar4;
        this.f34703i = bVar;
        this.f34705k = dVar;
        this.f34704j = c(aVar, cVar);
        i<b>[] iVarArrI = i(0);
        this.f34708n = iVarArrI;
        this.f34709o = dVar.a(iVarArrI);
    }

    public static nh.k0 c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, com.google.android.exoplayer2.drm.c cVar) {
        i0[] i0VarArr = new i0[aVar.f34747f.length];
        int i11 = 0;
        while (true) {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b[] bVarArr = aVar.f34747f;
            if (i11 >= bVarArr.length) {
                return new nh.k0(i0VarArr);
            }
            m1[] m1VarArr = bVarArr[i11].f34762j;
            m1[] m1VarArr2 = new m1[m1VarArr.length];
            for (int i12 = 0; i12 < m1VarArr.length; i12++) {
                m1 m1Var = m1VarArr[i12];
                m1VarArr2[i12] = m1Var.c(cVar.a(m1Var));
            }
            i0VarArr[i11] = new i0(Integer.toString(i11), m1VarArr2);
            i11++;
        }
    }

    private static i<b>[] i(int i11) {
        return new i[i11];
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j11, b3 b3Var) {
        for (i<b> iVar : this.f34708n) {
            if (iVar.f73817a == 2) {
                return iVar.a(j11, b3Var);
            }
        }
        return j11;
    }

    public final i<b> b(s sVar, long j11) {
        int iC = this.f34704j.c(sVar.getTrackGroup());
        return new i<>(this.f34707m.f34747f[iC].f34753a, null, null, this.f34696a.a(this.f34698c, this.f34707m, iC, sVar, this.f34697b), this, this.f34703i, j11, this.f34699d, this.f34700f, this.f34701g, this.f34702h);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        return this.f34709o.continueLoading(j11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j11, boolean z11) {
        for (i<b> iVar : this.f34708n) {
            iVar.discardBuffer(j11, z11);
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long e(s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11) {
        s sVar;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < sVarArr.length; i11++) {
            d0 d0Var = d0VarArr[i11];
            if (d0Var != null) {
                i iVar = (i) d0Var;
                if (sVarArr[i11] == null || !zArr[i11]) {
                    iVar.B();
                    d0VarArr[i11] = null;
                } else {
                    ((b) iVar.q()).b(sVarArr[i11]);
                    arrayList.add(iVar);
                }
            }
            if (d0VarArr[i11] == null && (sVar = sVarArr[i11]) != null) {
                i<b> iVarB = b(sVar, j11);
                arrayList.add(iVarB);
                d0VarArr[i11] = iVarB;
                zArr2[i11] = true;
            }
        }
        i<b>[] iVarArrI = i(arrayList.size());
        this.f34708n = iVarArrI;
        arrayList.toArray(iVarArrI);
        this.f34709o = this.f34705k.a(this.f34708n);
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void f(h.a aVar, long j11) {
        this.f34706l = aVar;
        aVar.h(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return this.f34709o.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return this.f34709o.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public nh.k0 getTrackGroups() {
        return this.f34704j;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f34709o.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void g(i<b> iVar) {
        this.f34706l.g(this);
    }

    public void k() {
        for (i<b> iVar : this.f34708n) {
            iVar.B();
        }
        this.f34706l = null;
    }

    public void l(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.f34707m = aVar;
        for (i<b> iVar : this.f34708n) {
            ((b) iVar.q()).c(aVar);
        }
        this.f34706l.g(this);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        this.f34698c.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
        this.f34709o.reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j11) {
        for (i<b> iVar : this.f34708n) {
            iVar.E(j11);
        }
        return j11;
    }
}
