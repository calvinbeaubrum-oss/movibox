package ch;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import tg.b0;
import tg.m;
import tg.s;
import tg.t;
import tg.u;
import tg.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public v f14800n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public a f14801o;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public v f14802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public v.a f14803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f14804c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f14805d = -1;

        public a(v vVar, v.a aVar) {
            this.f14802a = vVar;
            this.f14803b = aVar;
        }

        @Override // ch.g
        public long a(m mVar) {
            long j11 = this.f14805d;
            if (j11 < 0) {
                return -1L;
            }
            long j12 = -(j11 + 2);
            this.f14805d = -1L;
            return j12;
        }

        public void b(long j11) {
            this.f14804c = j11;
        }

        @Override // ch.g
        public b0 createSeekMap() {
            com.google.android.exoplayer2.util.a.g(this.f14804c != -1);
            return new u(this.f14802a, this.f14804c);
        }

        @Override // ch.g
        public void startSeek(long j11) {
            long[] jArr = this.f14803b.f77092a;
            this.f14805d = jArr[o0.i(jArr, j11, true, true)];
        }
    }

    public static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(c0 c0Var) {
        return c0Var.a() >= 5 && c0Var.D() == 127 && c0Var.F() == 1179402563;
    }

    @Override // ch.i
    public long f(c0 c0Var) {
        if (o(c0Var.d())) {
            return n(c0Var);
        }
        return -1L;
    }

    @Override // ch.i
    public boolean h(c0 c0Var, long j11, i.b bVar) {
        byte[] bArrD = c0Var.d();
        v vVar = this.f14800n;
        if (vVar == null) {
            v vVar2 = new v(bArrD, 17);
            this.f14800n = vVar2;
            bVar.f14842a = vVar2.g(Arrays.copyOfRange(bArrD, 9, c0Var.f()), null);
            return true;
        }
        if ((bArrD[0] & Ascii.DEL) == 3) {
            v.a aVarF = t.f(c0Var);
            v vVarB = vVar.b(aVarF);
            this.f14800n = vVarB;
            this.f14801o = new a(vVarB, aVarF);
            return true;
        }
        if (!o(bArrD)) {
            return true;
        }
        a aVar = this.f14801o;
        if (aVar != null) {
            aVar.b(j11);
            bVar.f14843b = this.f14801o;
        }
        com.google.android.exoplayer2.util.a.e(bVar.f14842a);
        return false;
    }

    @Override // ch.i
    public void l(boolean z11) {
        super.l(z11);
        if (z11) {
            this.f14800n = null;
            this.f14801o = null;
        }
    }

    public final int n(c0 c0Var) {
        int i11 = (c0Var.d()[2] & 255) >> 4;
        if (i11 == 6 || i11 == 7) {
            c0Var.Q(4);
            c0Var.K();
        }
        int iJ = s.j(c0Var, i11);
        c0Var.P(0);
        return iJ;
    }
}
