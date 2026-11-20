package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import androidx.annotation.Nullable;
import bh.o;
import bh.p;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import fi.s;
import java.io.IOException;
import java.util.List;
import ph.e;
import ph.f;
import ph.g;
import ph.h;
import ph.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements com.google.android.exoplayer2.source.smoothstreaming.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f34685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g[] f34687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f34688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f34689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f34690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f34691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public IOException f34692h;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0370a implements com.google.android.exoplayer2.source.smoothstreaming.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k.a f34693a;

        public C0370a(k.a aVar) {
            this.f34693a = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public com.google.android.exoplayer2.source.smoothstreaming.b a(a0 a0Var, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i11, s sVar, @Nullable k0 k0Var) {
            k kVarCreateDataSource = this.f34693a.createDataSource();
            if (k0Var != null) {
                kVarCreateDataSource.e(k0Var);
            }
            return new a(a0Var, aVar, i11, sVar, kVarCreateDataSource);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends ph.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b f34694e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f34695f;

        public b(com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar, int i11, int i12) {
            super(i12, bVar.f34763k - 1);
            this.f34694e = bVar;
            this.f34695f = i11;
        }

        @Override // ph.o
        public long a() {
            c();
            return this.f34694e.e((int) d());
        }

        @Override // ph.o
        public long b() {
            return a() + this.f34694e.c((int) d());
        }
    }

    public a(a0 a0Var, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i11, s sVar, k kVar) {
        this.f34685a = a0Var;
        this.f34690f = aVar;
        this.f34686b = i11;
        this.f34689e = sVar;
        this.f34688d = kVar;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = aVar.f34747f[i11];
        this.f34687c = new g[sVar.length()];
        int i12 = 0;
        while (i12 < this.f34687c.length) {
            int indexInTrackGroup = sVar.getIndexInTrackGroup(i12);
            m1 m1Var = bVar.f34762j[indexInTrackGroup];
            p[] pVarArr = m1Var.f33448p != null ? ((com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0371a) com.google.android.exoplayer2.util.a.e(aVar.f34746e)).f34752c : null;
            int i13 = bVar.f34753a;
            int i14 = i12;
            this.f34687c[i14] = new e(new bh.g(3, null, new o(indexInTrackGroup, i13, bVar.f34755c, C.TIME_UNSET, aVar.f34748g, m1Var, 0, pVarArr, i13 == 2 ? 4 : 0, null, null)), bVar.f34753a, m1Var);
            i12 = i14 + 1;
        }
    }

    public static n i(m1 m1Var, k kVar, Uri uri, int i11, long j11, long j12, long j13, int i12, @Nullable Object obj, g gVar) {
        return new ph.k(kVar, new com.google.android.exoplayer2.upstream.n(uri), m1Var, i12, obj, j11, j12, j13, C.TIME_UNSET, i11, 1, j11, gVar);
    }

    @Override // ph.j
    public long a(long j11, b3 b3Var) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = this.f34690f.f34747f[this.f34686b];
        int iD = bVar.d(j11);
        long jE = bVar.e(iD);
        return b3Var.a(j11, jE, (jE >= j11 || iD >= bVar.f34763k + (-1)) ? jE : bVar.e(iD + 1));
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void b(s sVar) {
        this.f34689e = sVar;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b[] bVarArr = this.f34690f.f34747f;
        int i11 = this.f34686b;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = bVarArr[i11];
        int i12 = bVar.f34763k;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar2 = aVar.f34747f[i11];
        if (i12 == 0 || bVar2.f34763k == 0) {
            this.f34691g += i12;
        } else {
            int i13 = i12 - 1;
            long jE = bVar.e(i13) + bVar.c(i13);
            long jE2 = bVar2.e(0);
            if (jE <= jE2) {
                this.f34691g += i12;
            } else {
                this.f34691g += bVar.d(jE2);
            }
        }
        this.f34690f = aVar;
    }

    @Override // ph.j
    public void d(f fVar) {
    }

    @Override // ph.j
    public boolean e(f fVar, boolean z11, z.c cVar, z zVar) {
        z.b bVarD = zVar.d(fi.a0.c(this.f34689e), cVar);
        if (z11 && bVarD != null && bVarD.f35525a == 2) {
            s sVar = this.f34689e;
            if (sVar.blacklist(sVar.g(fVar.f73809d), bVarD.f35526b)) {
                return true;
            }
        }
        return false;
    }

    @Override // ph.j
    public final void g(long j11, long j12, List<? extends n> list, h hVar) {
        int iE;
        long j13 = j12;
        if (this.f34692h != null) {
            return;
        }
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f34690f;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = aVar.f34747f[this.f34686b];
        if (bVar.f34763k == 0) {
            hVar.f73816b = !aVar.f34745d;
            return;
        }
        if (list.isEmpty()) {
            iE = bVar.d(j13);
        } else {
            iE = (int) (list.get(list.size() - 1).e() - ((long) this.f34691g));
            if (iE < 0) {
                this.f34692h = new BehindLiveWindowException();
                return;
            }
        }
        if (iE >= bVar.f34763k) {
            hVar.f73816b = !this.f34690f.f34745d;
            return;
        }
        long j14 = j13 - j11;
        long j15 = j(j11);
        int length = this.f34689e.length();
        ph.o[] oVarArr = new ph.o[length];
        for (int i11 = 0; i11 < length; i11++) {
            oVarArr[i11] = new b(bVar, this.f34689e.getIndexInTrackGroup(i11), iE);
        }
        this.f34689e.d(j11, j14, j15, list, oVarArr);
        long jE = bVar.e(iE);
        long jC = jE + bVar.c(iE);
        if (!list.isEmpty()) {
            j13 = C.TIME_UNSET;
        }
        long j16 = j13;
        int i12 = iE + this.f34691g;
        int selectedIndex = this.f34689e.getSelectedIndex();
        hVar.f73815a = i(this.f34689e.getSelectedFormat(), this.f34688d, bVar.a(this.f34689e.getIndexInTrackGroup(selectedIndex), iE), i12, jE, jC, j16, this.f34689e.getSelectionReason(), this.f34689e.getSelectionData(), this.f34687c[selectedIndex]);
    }

    @Override // ph.j
    public int getPreferredQueueSize(long j11, List<? extends n> list) {
        return (this.f34692h != null || this.f34689e.length() < 2) ? list.size() : this.f34689e.evaluateQueueSize(j11, list);
    }

    @Override // ph.j
    public boolean h(long j11, f fVar, List<? extends n> list) {
        if (this.f34692h != null) {
            return false;
        }
        return this.f34689e.f(j11, fVar, list);
    }

    public final long j(long j11) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f34690f;
        if (!aVar.f34745d) {
            return C.TIME_UNSET;
        }
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = aVar.f34747f[this.f34686b];
        int i11 = bVar.f34763k - 1;
        return (bVar.e(i11) + bVar.c(i11)) - j11;
    }

    @Override // ph.j
    public void maybeThrowError() throws IOException {
        IOException iOException = this.f34692h;
        if (iOException != null) {
            throw iOException;
        }
        this.f34685a.maybeThrowError();
    }

    @Override // ph.j
    public void release() {
        for (g gVar : this.f34687c) {
            gVar.release();
        }
    }
}
