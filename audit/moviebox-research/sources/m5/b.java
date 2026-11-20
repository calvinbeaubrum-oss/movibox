package m5;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import u4.a0;
import u4.b0;
import u4.c0;
import u4.m0;
import u4.t;
import u4.z;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public c0 f70804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public a f70805o;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0 f70806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c0.a f70807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f70808c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f70809d = -1;

        public a(c0 c0Var, c0.a aVar) {
            this.f70806a = c0Var;
            this.f70807b = aVar;
        }

        @Override // m5.g
        public long a(t tVar) {
            long j11 = this.f70809d;
            if (j11 < 0) {
                return -1L;
            }
            long j12 = -(j11 + 2);
            this.f70809d = -1L;
            return j12;
        }

        public void b(long j11) {
            this.f70808c = j11;
        }

        @Override // m5.g
        public m0 createSeekMap() {
            z3.a.g(this.f70808c != -1);
            return new b0(this.f70806a, this.f70808c);
        }

        @Override // m5.g
        public void startSeek(long j11) {
            long[] jArr = this.f70807b.f78231a;
            this.f70809d = jArr[u0.h(jArr, j11, true, true)];
        }
    }

    public static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(z3.c0 c0Var) {
        return c0Var.a() >= 5 && c0Var.H() == 127 && c0Var.J() == 1179402563;
    }

    @Override // m5.i
    public long f(z3.c0 c0Var) {
        if (o(c0Var.e())) {
            return n(c0Var);
        }
        return -1L;
    }

    @Override // m5.i
    public boolean i(z3.c0 c0Var, long j11, i.b bVar) {
        byte[] bArrE = c0Var.e();
        c0 c0Var2 = this.f70804n;
        if (c0Var2 == null) {
            c0 c0Var3 = new c0(bArrE, 17);
            this.f70804n = c0Var3;
            bVar.f70846a = c0Var3.g(Arrays.copyOfRange(bArrE, 9, c0Var.g()), null);
            return true;
        }
        if ((bArrE[0] & Ascii.DEL) == 3) {
            c0.a aVarG = a0.g(c0Var);
            c0 c0VarB = c0Var2.b(aVarG);
            this.f70804n = c0VarB;
            this.f70805o = new a(c0VarB, aVarG);
            return true;
        }
        if (!o(bArrE)) {
            return true;
        }
        a aVar = this.f70805o;
        if (aVar != null) {
            aVar.b(j11);
            bVar.f70847b = this.f70805o;
        }
        z3.a.e(bVar.f70846a);
        return false;
    }

    @Override // m5.i
    public void l(boolean z11) {
        super.l(z11);
        if (z11) {
            this.f70804n = null;
            this.f70805o = null;
        }
    }

    public final int n(z3.c0 c0Var) {
        int i11 = (c0Var.e()[2] & 255) >> 4;
        if (i11 == 6 || i11 == 7) {
            c0Var.V(4);
            c0Var.O();
        }
        int iJ = z.j(c0Var, i11);
        c0Var.U(0);
        return iJ;
    }
}
